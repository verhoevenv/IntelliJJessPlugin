package com.github.verhoevenv.intellij.jess.psi;

import com.github.verhoevenv.intellij.jess.JessLanguage;
import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;

public class JessElementType extends IElementType {

    public JessElementType(String debugName) {
        super(debugName, JessLanguage.INSTANCE);
    }
}
