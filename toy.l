import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Yytoken {
  public String type;
  public Object value;
  public Yytoken(String type) {
    this.type = type;
  }
  public Yytoken(String type, Object value) {
    this.type = type;
    this.value = value;
  }
}

%%

%unicode

%{
StringBuffer stringBuffer = new StringBuffer();

public static void main(String[] args) throws FileNotFoundException, IOException{
            FileReader yyin = new FileReader(args[0]);
            Yylex yy = new Yylex(yyin);
            Yytoken t;
            while ((t = yy.yylex()) != null)
                System.out.println(t.type);
}
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
Digit = [0 - 9]
AnyLet = [A - Za - z]
Others = [0 - 9 & .]
WhiteSp = [\040\ n]
Integer = {Digit}*
String = "\""{AnyLet}"\""

Type = "int" | "bool" | "string"
Symbol = "{" | "}" | ";" | "<=" | ">=" | "<" | ">" | "==" | "!=" |"!" | "(" | ")" | "+" | "-" | "." | "="
Keyword = "bool" | "int" | "true" | "false" | "void" | "printf" | "string" | "struct" | "if" | "then" | "else" | "for" | "return"
Declaration = {Type}{WhiteSpace}*"="{WhiteSpace}*({String}|{Integer})
Identifier = [:jletter:] [:jletterdigit:]*
Comment = {SlashComment} | {HashComment}
SlashComment = "//" {InputCharacter}* {LineTerminator}
HashComment = "##" {InputCharacter}* {LineTerminator}


%state STRING

%%
/* keywords
<YYINITIAL>
"bool" { return new Yytoken("BOOL"); }
"int" { return new Yytoken("INT"); }
"true" { return new Yytoken("TRUE"); }
"false" { return new Yytoken("FALSE"); }
"void" { return new Yytoken("VOID"); }
"printf" { return new Yytoken("PRINTF"); }
"string" { return new Yytoken("STRING"); }
"struct" { return new Yytoken("STRUCT"); }
"if" { return new Yytoken("IF"); }
"then" { return new Yytoken("THEN"); }
"else" { return new Yytoken("ELSE"); }
"for" { return new Yytoken("FOR"); }
"return" { return new Yytoken("RETURN"); }
 */
<YYINITIAL> {
/*Type*/
{Type}                   { return new Yytoken("TYPE"); }
/* identifiers */
{Identifier}                   { return new Yytoken("IDENTIFIER"); }
/* comments */
{Comment}                      { return new Yytoken("COMMENT"); }
/* integer */
{Integer}                   { return new Yytoken("INTEGER"); }
/*string*/
{String}                         { return new Yytoken("STRING"); }
/* comments */
{Symbol}                   { return new Yytoken("SYMBOL"); }

/* whitespace */
{WhiteSp}                   { /* ignore */ }



/* literals */
\"                             { stringBuffer.setLength(0); yybegin(STRING); }

/* symbols
"{"                            { return new Yytoken("RBRACKET"); }
"}"                            { return new Yytoken("LBRACKET"); }
";"                            { return new Yytoken("SEMICOLON"); }
"<"                            { return new Yytoken("LESSTHAN"); }
">"                            { return new Yytoken("GREATERTHAN"); }
"=="                           { return new Yytoken("DOUBLEEQ"); }
"<="                           { return new Yytoken("LESSTHANOREQ"); }
">="                           { return new Yytoken("GREATERTHANOREQ"); }
"!="                           { return new Yytoken("NOTEQ"); }
"!"                            { return new Yytoken("NOT"); }
"("                            { return new Yytoken("LEFTPAREN"); }
")"                            { return new Yytoken("RIGHTPAREN"); }
"+"                            { return new Yytoken("PLUS"); }
"-"                            { return new Yytoken("MINUS"); }
"*"                            { return new Yytoken("MULT"); }
"="                            { return new Yytoken("EQ"); }*/
/* whitespace */
{WhiteSpace}                   { /* ignore */ }
}

<STRING> {
\"                             { yybegin(YYINITIAL);
                               return new Yytoken("STRING_LITERAL",
                               stringBuffer.toString()); }
[^\n\r\"\\]+                   { stringBuffer.append( yytext() ); }
\\t                            { stringBuffer.append('\t'); }
\\n                            { stringBuffer.append('\n'); }

\\r                            { stringBuffer.append('\r'); }
\\\"                           { stringBuffer.append('\"'); }
\\                             { stringBuffer.append('\\'); }
}

/* error fallback */
[^]                              { throw new Error("ERROR <"+
                                                   yytext()+">"); }


