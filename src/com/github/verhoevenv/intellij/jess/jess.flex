package com.github.verhoevenv.intellij.jess.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.verhoevenv.intellij.jess.psi.JessTypes;
import com.intellij.psi.TokenType;

%%

%class JessLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f] | {CRLF}
UNTIL_END_OF_LINE_COMMENT=";"[^\r\n]*
LP="("
RP=")"
SYMBOL_CHARACTER=[a-zA-Z0-9$*=+/<>_?#.]|"-"

STRING_CHAR=[^\"]
STRING_LITERAL=\"{STRING_CHAR}*\"

%%

<YYINITIAL> {UNTIL_END_OF_LINE_COMMENT} { return JessTypes.COMMENT; }
<YYINITIAL> {LP} { return JessTypes.LP; }
<YYINITIAL> {RP} { return JessTypes.RP; }
<YYINITIAL> "defrule" { return JessTypes.DEFRULE; }
<YYINITIAL> "defmodule" { return JessTypes.DEFMODULE; }
<YYINITIAL> "defclass" { return JessTypes.DEFCLASS; }
<YYINITIAL> "deffacts" { return JessTypes.DEFFACTS; }
<YYINITIAL> "deftemplate" { return JessTypes.DEFTEMPLATE; }
<YYINITIAL> "slot" { return JessTypes.SLOT; }
<YYINITIAL> "=>" { return JessTypes.ARROW; }
<YYINITIAL> "&" { return JessTypes.AMP; }
<YYINITIAL> "|" { return JessTypes.PIPE; }
<YYINITIAL> ":" { return JessTypes.COLON; }

<YYINITIAL> {STRING_LITERAL} { return JessTypes.STRING_LITERAL; }
<YYINITIAL> {SYMBOL_CHARACTER}+ { return JessTypes.SYMBOL; }
<YYINITIAL> {WHITE_SPACE}+ { return TokenType.WHITE_SPACE; }

. { return TokenType.BAD_CHARACTER; }