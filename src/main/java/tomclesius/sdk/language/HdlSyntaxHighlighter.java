// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package tomclesius.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import tomclesius.sdk.language.psi.HdlTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class HdlSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("HDL_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey VARIABLE =
            createTextAttributesKey("HDL_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("HDL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey DOC_COMMENT =
            createTextAttributesKey("HDL_DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("HDL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("HDL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey SEMICOLON =
            createTextAttributesKey("HDL_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);

    public static final TextAttributesKey COMMA =
            createTextAttributesKey("HDL_COMMA", DefaultLanguageHighlighterColors.COMMA);

    public static final TextAttributesKey BOOLEAN =
            createTextAttributesKey("HDL_BOOLEAN", DefaultLanguageHighlighterColors.NUMBER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] VARIABLE_KEYS = new TextAttributesKey[]{VARIABLE};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[]{SEMICOLON};
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[]{LINE_COMMENT};
    private static final TextAttributesKey[] DOC_COMMENT_KEYS = new TextAttributesKey[]{DOC_COMMENT};

    private static final TextAttributesKey[] BOOLEAN_KEYS = new TextAttributesKey[]{BOOLEAN};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new HdlLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(HdlTypes.BOOLEAN)) {
            return BOOLEAN_KEYS;
        }
        if (tokenType.equals(HdlTypes.EQUAL) || tokenType.equals(HdlTypes.COLON)) {
            return SEPARATOR_KEYS;
        }
        if (tokenType.equals(HdlTypes.CHIP_KEYWORD) || tokenType.equals(HdlTypes.PARTS_KEYWORD) || tokenType.equals(HdlTypes.IN_KEYWORD) || tokenType.equals(HdlTypes.OUT_KEYWORD)) {
            return KEYWORD_KEYS;
        }
        if (tokenType.equals(HdlTypes.VARIABLE)) {
            return VARIABLE_KEYS;
        }
        if (tokenType.equals(HdlTypes.SEMICOLON)) {
            return SEMICOLON_KEYS;
        }
        if (tokenType.equals(HdlTypes.COMMA)) {
            return COMMA_KEYS;
        }
        if (tokenType.equals(HdlTypes.DOC_COMMENT)) {
            return DOC_COMMENT_KEYS;
        }
        if (tokenType.equals(HdlTypes.LINE_COMMENT)) {
            return LINE_COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}