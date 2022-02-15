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

Identifier = [:jletter:] [:jletterdigit:]*


%state STRING

%%
/* keywords */
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
/* identifiers */
{Identifier}                   { return new Yytoken("IDENTIFIER"); }

/* literals */
\"                             { stringBuffer.setLength(0); yybegin(STRING); }

/* operators */
"="                            { return new Yytoken("EQ"); }

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
[^]                              { throw new Error("Illegal character <"+
                                                yytext()+">"); }
