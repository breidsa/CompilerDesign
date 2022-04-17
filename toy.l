import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
//import util.ToY;


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
  
  //ADDED THIS IF IT DOESNT COMPILE
  public int getToken(){
      return this.type;
  }
  public Object getValue(){
      return this.value;
  }
  
}

%%

%unicode
%public


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
%x EOF


%%
/*keywords*/
"bool" { return new Yytoken(ToY.Lexer.BOOL); }
"int" { return new Yytoken(ToY.Lexer.INT); }
"true" { return new Yytoken(ToY.Lexer.TRUE); }
"false" { return new Yytoken(ToY.Lexer.FALSE); }
"void" { return new Yytoken(ToY.Lexer.VOID); }
"printf" { return new Yytoken(ToY.Lexer.PRINTF); }
"string" { return new Yytoken(ToY.Lexer.STRING); }
"struct" { return new Yytoken(ToY.Lexer.STRUCT); }
"if" { return new Yytoken(ToY.Lexer.IF); }
"then" { return new Yytoken(ToY.Lexer.THEN); }
"else" { return new Yytoken(ToY.Lexer.ELSE); }
"for" { return new Yytoken(ToY.Lexer.FOR); }
"return" { return new Yytoken(ToY.Lexer.RETURN); }
"and" { return new Yytoken(ToY.Lexer.AND); }
"or" { return new Yytoken(ToY.Lexer.OR); }
"mod" { return new Yytoken(ToY.Lexer.MOD); }

/*keywords
"bool" { return new Yytoken("BOOL"); }
"int" { return new Yytoken("INT"); }
"true" { return new Yytoken("TRUE"); }
"false" { return new Yytoken("FALSE"); }
"void" { return new Yytoken("VOID"); System.out.println("Reached Void"); }
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
    
{Digit}+             { return new Yytoken(ToY.Lexer.INT); }
/* Integers Literals
{Digit} {
        intBuffer.setLength(0);
        yybegin(INT);
        intBuffer.toString();
        intBuffer.append( yytext() );
}
 */

    
/* identifiers */
{Identifier}                   { return new Yytoken(ToY.Lexer.IDENTIFIER, yytext()); }


    
    

/* symbols */
"}"                            { return new Yytoken(ToY.Lexer.RBRACKET); }
"{"                            { return new Yytoken(ToY.Lexer.LBRACKET); }
";"                            { return new Yytoken(ToY.Lexer.SEMICOLON); }
","                            { return new Yytoken(ToY.Lexer.COMMA); }
"<"                            { return new Yytoken(ToY.Lexer.LESSTHAN); }
">"                            { return new Yytoken(ToY.Lexer.GREATERTHAN); }
"=="                           { return new Yytoken(ToY.Lexer.DOUBLEEQ); }
"<="                           { return new Yytoken(ToY.Lexer.LESSTHANOREQ); }
">="                           { return new Yytoken(ToY.Lexer.GREATERTHANOREQ); }
"!="                           { return new Yytoken(ToY.Lexer.NOTEQ); }
"!"                            { return new Yytoken(ToY.Lexer.NOT); }
"("                            { return new Yytoken(ToY.Lexer.LEFTPAREN); }
")"                            { return new Yytoken(ToY.Lexer.RIGHTPAREN); }
"+"                            { return new Yytoken(ToY.Lexer.PLUS); }
"-"                            { return new Yytoken(ToY.Lexer.MINUS); }
"*"                            { return new Yytoken(ToY.Lexer.MULT); }
"/"                            { return new Yytoken(ToY.Lexer.DIVIDE); }
"="                            { return new Yytoken(ToY.Lexer.EQ); }
"."                            { return new Yytoken(ToY.Lexer.ATTRIBUTE); }

/* whitespace */
{WhiteSpace}                   { /* ignore */ }
/* comment */
{Comment}                   { return new Yytoken(ToY.Lexer.COMMENT); }

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
    return new Yytoken(ToY.Lexer.STRING, stringBuffer.toString());
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

<EOF>

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                yytext()+">"); }
