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
StringBuffer intBuffer = new StringBuffer();

public static void main(String[] args) throws FileNotFoundException, IOException{
            FileReader yyin = new FileReader(args[0]);
            Yylex yy = new Yylex(yyin);
            Yytoken t;
            while ((t = yy.yylex()) != null)
                System.out.println(t.type);
            System.out.println("VALID");
}
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


<YYINITIAL> {
/*String Literals*/
\" {
    stringBuffer.setLength(0);
    yybegin(STRING);
    stringBuffer.toString();
    stringBuffer.append( yytext() );
}
    
{Digit}+             { return new Yytoken("INTEGER"); }
/* Integers Literals
{Digit} {
        intBuffer.setLength(0);
        yybegin(INT);
        intBuffer.toString();
        intBuffer.append( yytext() );
}
 */

    
/* identifiers */
{Identifier}                   { return new Yytoken("IDENTIFIER"); }


    
    

/* symbols */
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
"/"                            { return new Yytoken("DIVIDE"); }
"="                            { return new Yytoken("EQ"); }

/* whitespace */
{WhiteSpace}                   { /* ignore */ }
/* comment */
{Comment}                   { return new Yytoken("COMMENT"); }

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
}
/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                yytext()+">"); }
