package com.github.verhoevenv.intellij.jess.psi;

import com.github.verhoevenv.intellij.jess.JessFileType;
import com.github.verhoevenv.intellij.jess.JessLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class JessFile extends PsiFileBase {
    public JessFile(@NotNull FileViewProvider fileViewProvider) {
        super(fileViewProvider, JessLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return JessFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Jess file";
    }

}
