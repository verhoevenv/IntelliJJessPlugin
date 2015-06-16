package com.github.verhoevenv.intellij.jess.psi;

import com.github.verhoevenv.intellij.jess.JessLanguage;
import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;

public class JessTokenType extends IElementType {
    public JessTokenType(String debugName) {
        super(debugName, JessLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "JessTokenType." + super.toString();
    }
}
