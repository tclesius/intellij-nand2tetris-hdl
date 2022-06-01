package tomclesius.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import tomclesius.sdk.language.psi.HdlTypes;
import com.intellij.psi.TokenType;

%%

%class HdlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}



CRLF=\R
WHITE_SPACE=[\ \n\t\f]
NUMBER= [\d]+
BOOLEAN= ("true" | "false")
LINE_COMMENT=("//").*
DOC_COMMENT= \/[*]([^*]|([*][^\/]))*
VARIABLE= [a-zA-Z0-9-]+
CHIP_NAME= [a-zA-Z0-9-]+
LIST_VARIABLE= [a-zA-Z]+\[[^\]]*\]


%state WAITING_VALUE

%%



<YYINITIAL>{

    "{"                                             { yybegin(YYINITIAL); return HdlTypes.LBRACE; }
    "}"                                             { yybegin(YYINITIAL); return HdlTypes.RBRACE; }
    ":"                                             { yybegin(YYINITIAL); return HdlTypes.COLON; }
    "="                                             { yybegin(YYINITIAL); return HdlTypes.EQUAL; }
    "("                                             { yybegin(YYINITIAL); return HdlTypes.LPAREN; } // waiting value?
    ")"                                             { yybegin(YYINITIAL); return HdlTypes.RPAREN; }
    ","                                             { yybegin(YYINITIAL); return HdlTypes.COMMA; }
    ";"                                             { yybegin(YYINITIAL); return HdlTypes.SEMICOLON; }


    "CHIP"                                          { yybegin(YYINITIAL); return HdlTypes.CHIP_KEYWORD; }
    "PARTS"                                         { yybegin(YYINITIAL); return HdlTypes.PARTS_KEYWORD; }
    "IN"                                            { yybegin(YYINITIAL); return HdlTypes.IN_KEYWORD; }
    "OUT"                                           { yybegin(YYINITIAL); return HdlTypes.OUT_KEYWORD; }



    {LINE_COMMENT}                                  {return HdlTypes.LINE_COMMENT; }
    {DOC_COMMENT}                                   { yybegin(WAITING_VALUE); return HdlTypes.DOC_COMMENT;}
    {BOOLEAN}                                       { yybegin(YYINITIAL); return HdlTypes.BOOLEAN; }
    {LIST_VARIABLE}                                 { yybegin(YYINITIAL); return HdlTypes.LIST_VARIABLE; }
    {VARIABLE}                                      { yybegin(YYINITIAL);return HdlTypes.VARIABLE; }
}

<WAITING_VALUE>{
    {WHITE_SPACE}+                                  { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }
    "*/"                                            { yybegin(YYINITIAL); return HdlTypes.DOC_COMMENT;}
}

({CRLF}|{WHITE_SPACE})+                             { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
[^]                                                 { return TokenType.BAD_CHARACTER; }