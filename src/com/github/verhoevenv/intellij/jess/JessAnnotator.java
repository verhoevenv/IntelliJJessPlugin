package com.github.verhoevenv.intellij.jess;

import com.github.verhoevenv.intellij.jess.psi.JessSlotname;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class JessAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if(element instanceof JessSlotname) {
            Annotation infoAnnotation = holder.createInfoAnnotation(element, null);
            infoAnnotation.setTextAttributes(DefaultLanguageHighlighterColors.INSTANCE_FIELD);
        }
    }
}
