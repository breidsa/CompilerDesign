import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Yytoken {
  public int type;
  public Object value;
  public Yytoken(int type) {
    this.type = type;
  }
  public Yytoken(int type, Object value) {
    this.type = type;
    this.value = value;
  }
}

%%

%unicode


%{
StringBuffer stringBuffer = new StringBuffer();
StringBuffer intBuffer = new StringBuffer();

/* public static void main(String[] args) throws FileNotFoundException, IOException{
            FileReader yyin = new FileReader(args[0]);
            Yylex yy = new Yylex(yyin);
            Yytoken t;
            while ((t = yy.yylex()) != null)
                System.out.println(t.type);
            System.out.println("VALID");
}
*/
%}

LineTerminator = \r|\n|\r\n
Digit = [0-9]
NonDigit = [^0-9]
Letter = [A-Za-z]
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
Identifier = [:jletter:] [:jletterdigit:]*
Comment = {SlashComment} | {HashComment}
SlashComment = "//" {InputCharacter}* {LineTerminator}
HashComment = "##" {InputCharacter}* {LineTerminator}
%x STRING
%x INT


%%
/*keywords*/
"bool" { return new Yytoken(ToYLexer.BOOL); }
"int" { return new Yytoken(ToYLexer.INT); }
"true" { return new Yytoken(ToYLexer.TRUE); }
"false" { return new Yytoken(ToYLexer.FALSE); }
"void" { return new Yytoken(ToYLexer.VOID); }
"printf" { return new Yytoken(ToYLexer.PRINTF); }
"string" { return new Yytoken(ToYLexer.STRING); }
"struct" { return new Yytoken(ToYLexer.STRUCT); }
"if" { return new Yytoken(ToYLexer.IF); }
"then" { return new Yytoken(ToYLexer.THEN); }
"else" { return new Yytoken(ToYLexer.ELSE); }
"for" { return new Yytoken(ToYLexer.FOR); }
"return" { return new Yytoken(ToYLexer.RETURN); }
"and" { return new Yytoken(ToYLexer.AND); }
"or" { return new Yytoken(ToYLexer.OR); }
"mod" { return new Yytoken(ToYLexer.MOD); }

/*keywords
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
"and" { return new Yytoken("AND"); }
"or" { return new Yytoken("OR"); }
"mod" { return new Yytoken("MOD"); }
*/

/*String Literals*/
\" {
    stringBuffer.setLength(0);
    yybegin(STRING);
    stringBuffer.toString();
    stringBuffer.append( yytext() );
}
    
{Digit}+             { return new Yytoken(ToYLexer.INTEGER); }
/* Integers Literals
{Digit} {
        intBuffer.setLength(0);
        yybegin(INT);
        intBuffer.toString();
        intBuffer.append( yytext() );
}
 */

    
/* identifiers */
{Identifier}                   { return new Yytoken(ToYLexer.IDENTIFIER); }


    
    

/* symbols */
"{"                            { return new Yytoken(ToYLexer.RBRACKET); }
"}"                            { return new Yytoken(ToYLexer.LBRACKET); }
";"                            { return new Yytoken(ToYLexer.SEMICOLON); }
","                            { return new Yytoken(ToYLexer.COMMA); }
"<"                            { return new Yytoken(ToYLexer.LESSTHAN); }
">"                            { return new Yytoken(ToYLexer.GREATERTHAN); }
"=="                           { return new Yytoken(ToYLexer.DOUBLEEQ); }
"<="                           { return new Yytoken(ToYLexer.LESSTHANOREQ); }
">="                           { return new Yytoken(ToYLexer.GREATERTHANOREQ); }
"!="                           { return new Yytoken(ToYLexer.NOTEQ); }
"!"                            { return new Yytoken(ToYLexer.NOT); }
"("                            { return new Yytoken(ToYLexer.LEFTPAREN); }
")"                            { return new Yytoken(ToYLexer.RIGHTPAREN); }
"+"                            { return new Yytoken(ToYLexer.PLUS); }
"-"                            { return new Yytoken(ToYLexer.MINUS); }
"*"                            { return new Yytoken(ToYLexer.MULT); }
"/"                            { return new Yytoken(ToYLexer.DIVIDE); }
"="                            { return new Yytoken(ToYLexer.EQ); }
"."                            { return new Yytoken(ToYLexer.ATTRIBUTE); }

/* whitespace */
{WhiteSpace}                   { /* ignore */ }
/* comment */
{Comment}                   { return new Yytoken(ToYLexer.COMMENT); }

/*Integer
<INT>{Digit} {
        intBuffer.append( yytext() );
    }
<INT>{WhiteSpace} {
    try  {Integer.valueOf(Integer.parseInt(intBuffer.toString()));
    } catch (NumberFormatException nfe) {
    }
        return new Yytoken("Integer " + Integer.valueOf(Integer.parseInt(intBuffer.toString())));
}
<INT>{NonDigit} {
    throw new Error("ERROR: Integer Not Formatted Correct");
    }
 */

<STRING>{Letter} {
    stringBuffer.append( yytext() );
}
<STRING>{Digit} {
    stringBuffer.append( yytext() );
}
<STRING>\" {
    yybegin(YYINITIAL);
    stringBuffer.append( yytext() );
    return new Yytoken("String " + stringBuffer.toString());
}
<STRING><<EOF>> {
    throw new Error("ERROR: String Error EOF");
}
<STRING>\\\" {
    throw new Error("ERROR No Escape Characters");
}
<STRING>\\\n { stringBuffer.append('\n');}
<STRING>\\\t { stringBuffer.append('\t');}
<STRING>\\\r { stringBuffer.append('\r');}
<STRING>\n {
    yybegin(YYINITIAL);
    throw new Error("ERRORString Error NewLine");
}
<STRING>\0 {
    throw new Error("String Error Null Character");
}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                yytext()+">"); }
