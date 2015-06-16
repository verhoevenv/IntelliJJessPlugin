package com.github.verhoevenv.intellij.jess;

import com.github.verhoevenv.intellij.jess.parser.JessParser;
import com.github.verhoevenv.intellij.jess.psi.JessFile;
import com.github.verhoevenv.intellij.jess.psi.JessTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class JessParserDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(JessTypes.COMMENT);
    public static final TokenSet STRING_LITERAL = TokenSet.create(JessTypes.STRING_LITERAL);

    public static final IFileElementType FILE = new IFileElementType(Language.findInstance(JessLanguage.class));


    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new JessLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new JessParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRING_LITERAL;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {
        return JessTypes.Factory.createElement(astNode);
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new JessFile(fileViewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        return SpaceRequirements.MAY;
    }
}
