package com.github.verhoevenv.intellij.jess;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;

public class JessLexerAdapter extends FlexAdapter {
    public JessLexerAdapter() {
        super(new _JessLexer(null));
    }
}
