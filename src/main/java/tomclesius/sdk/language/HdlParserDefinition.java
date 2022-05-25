package tomclesius.sdk.language;

import com.intellij.lang.ASTNode;
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
import tomclesius.sdk.language.parser.HdlParser;
import tomclesius.sdk.language.psi.HdlFile;
import tomclesius.sdk.language.psi.HdlTypes;
import org.jetbrains.annotations.NotNull;

public class HdlParserDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(HdlTypes.COMMENT);

    public static final IFileElementType FILE = new IFileElementType(HdlLanguage.INSTANCE);


    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new HdlLexerAdapter();
    }


    @Override
    public @NotNull TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }


    @Override
    public @NotNull TokenSet getCommentTokens() {
        return COMMENTS;
    }


    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }


    @Override
    public @NotNull PsiParser createParser(final Project project) {
        return new HdlParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new HdlFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }


    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return HdlTypes.Factory.createElement(node);
    }

}
