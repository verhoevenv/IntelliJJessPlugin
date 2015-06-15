package com.github.verhoevenv.intellij.jess;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class JessFileType extends LanguageFileType {

    public static final JessFileType INSTANCE = new JessFileType();

    protected JessFileType() {
        super(JessLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Jess file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Jess file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "clp";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return JessIcons.FILE;
    }
}