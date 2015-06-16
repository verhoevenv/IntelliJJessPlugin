package com.github.verhoevenv.intellij.jess;

import com.github.verhoevenv.intellij.jess.psi.JessTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class JessSyntaxHighlighter extends SyntaxHighlighterBase {

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new JessLexerAdapter();
    }

    private static final Map<IElementType, TextAttributesKey> keys1;


    public static final TextAttributesKey JESS_STRING_LITERAL = TextAttributesKey.createTextAttributesKey(
            "JESS.STRINGLITERAL",
            DefaultLanguageHighlighterColors.STRING
    );

    public static final TextAttributesKey JESS_COMMENT = TextAttributesKey.createTextAttributesKey(
            "JESS.COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
    );

    public static final TextAttributesKey JESS_CONSTRUCT = TextAttributesKey.createTextAttributesKey(
            "JESS.CONSTRUCT",
            DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL
    );


    static {
        keys1 = new THashMap<IElementType, TextAttributesKey>();

        keys1.put(JessTypes.COMMENT, JESS_COMMENT);

        keys1.put(JessTypes.DEFCLASS, JESS_CONSTRUCT);
        keys1.put(JessTypes.DEFMODULE, JESS_CONSTRUCT);
        keys1.put(JessTypes.DEFRULE, JESS_CONSTRUCT);
        keys1.put(JessTypes.DEFFACTS, JESS_CONSTRUCT);
        keys1.put(JessTypes.DEFTEMPLATE, JESS_CONSTRUCT);

        keys1.put(JessTypes.STRING_LITERAL, JESS_STRING_LITERAL);
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return SyntaxHighlighterBase.pack(keys1.get(tokenType));
    }
}
