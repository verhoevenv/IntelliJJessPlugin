package com.github.verhoevenv.intellij.jess;

import com.intellij.lang.Language;

public class JessLanguage extends Language {
    public static final JessLanguage INSTANCE = new JessLanguage();

    public JessLanguage() {
        super("Jess");
    }
}
