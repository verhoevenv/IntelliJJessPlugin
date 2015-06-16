package com.github.verhoevenv.intellij.jess;

import com.github.verhoevenv.intellij.jess.psi.JessConditionhead;
import com.github.verhoevenv.intellij.jess.psi.JessSlotname;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static java.util.Arrays.asList;

public class JessAnnotator implements Annotator {

    private final List<String> conditionalGroupings = asList("not", "or", "and");

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if(element instanceof JessSlotname) {
            Annotation infoAnnotation = holder.createInfoAnnotation(element, null);
            infoAnnotation.setTextAttributes(DefaultLanguageHighlighterColors.INSTANCE_FIELD);
        }
        if(element instanceof JessConditionhead) {
            JessConditionhead conditionhead = (JessConditionhead) element;
            if(conditionalGroupings.contains(conditionhead.getSymbol().getText())) {
                Annotation infoAnnotation = holder.createInfoAnnotation(element, null);
                infoAnnotation.setTextAttributes(DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);
            }
        }
    }
}
