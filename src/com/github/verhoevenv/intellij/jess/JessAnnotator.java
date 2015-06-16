package com.github.verhoevenv.intellij.jess;

import com.github.verhoevenv.intellij.jess.psi.JessConditionhead;
import com.github.verhoevenv.intellij.jess.psi.JessRuleconditionlist;
import com.github.verhoevenv.intellij.jess.psi.JessSlotname;
import com.github.verhoevenv.intellij.jess.psi.JessTypes;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static java.util.Arrays.asList;

public class JessAnnotator implements Annotator {

    private final List<String> conditionalGroupings = asList("not", "or", "and");

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if(element instanceof JessSlotname) {
            highlightAsSlotName(element, holder);
        }
        if(element instanceof JessConditionhead) {
            JessConditionhead conditionhead = (JessConditionhead) element;
            if(conditionalGroupings.contains(conditionhead.getSymbol().getText())) {
                Annotation infoAnnotation = holder.createInfoAnnotation(element, null);
                infoAnnotation.setTextAttributes(DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);
            } else {
                highlightFollowingSlots(conditionhead, holder);
            }
        }
    }

    private void highlightAsSlotName(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        Annotation infoAnnotation = holder.createInfoAnnotation(element, null);
        infoAnnotation.setTextAttributes(DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    }

    private void highlightFollowingSlots(JessConditionhead conditionhead, AnnotationHolder holder) {
        PsiElement[] siblings = conditionhead.getParent().getChildren();
        for (PsiElement sibling : siblings) {
            if(sibling instanceof JessRuleconditionlist) {
                JessRuleconditionlist conditionlist = (JessRuleconditionlist) sibling;
                if(!isInFunctionContext(conditionlist)) {
                    highlightAsSlotName(conditionlist.getConditionhead(), holder);
                }

            }
        }
    }

    private boolean isInFunctionContext(JessRuleconditionlist element) {
        return getPreviousNonWhitspaceSibling(element).getText().equals(":") || wrappingListIsInFunctionContext(element);
    }

    private boolean wrappingListIsInFunctionContext(JessRuleconditionlist element) {
        if(element.getParent() instanceof JessRuleconditionlist) {
            return isInFunctionContext((JessRuleconditionlist) element.getParent());
        }
        return false;
    }

    private PsiElement getPreviousNonWhitspaceSibling(JessRuleconditionlist element) {
        PsiElement prevSibling = element.getPrevSibling();
        while(prevSibling != null && prevSibling instanceof PsiWhiteSpace) {
            prevSibling = prevSibling.getPrevSibling();
        }
        return prevSibling;
    }
}
