




%define api.parser.class {ToYParser}
%define api.parser.public
%define parse.error verbose


%code imports {
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer
}


%code {
public static void main(String[] args) throws IOException {
 ToYLexer l = new ToYLexer(System.in);
 ToYParser p = new ToYParser(l);
 if (!p.parse()) System.out.println("INVALID");
}
}

/* Bison Declarations */
/* Questions: does boolean and stuff have to come from the lexer?? */
%token <Integer> INT
%token <Identifier> BOOL STRING IDENTIFIER
%token <Boolean> TRUE FALSE IF THEN ELSE FOR
%token VOID RETURN PRINTF STRUCT

/* Operator precedence for mathematical operators */
/* MIGHT NOT NEED!! */
%left TPLUS TMINUS
%left TMUL TDIV

%type input
%type line
%type exp
%type returnType
%type struct
%type stmt
%type string

%start program

%%
    
    program:
    stmts {program}
    
    type: int | bool | string;
    
    returnType: type | void;
    
    input: line | input line;
    
    declaration: type IDENTIFIER;
    
    line: '\n'
    | exp '\n' { System.out.println($exp); }
    | error '\n'
    ;
    
    exp:
     NUM { $$ = $1; }
    | exp '=' exp { if ($1.intValue() != $3.intValue()) yyerror("calc: error: " + $1 + " != " + $3); }
    | exp '+' exp { $$ = $1 + $3; }
    | exp '-' exp { $$ = $1 - $3; }
    | exp '*' exp { $$ = $1 * $3; }
    | exp '/' exp { $$ = $1 / $3; }
    | '-' exp %prec NEG { $$ = -$2; }
    | exp '^' exp { $$ = (int) Math.pow($1, $3); }
    | '(' exp ')' { $$ = $2; }
    | '(' error ')' { $$ = 1111; }
    | '!' { $$ = 0; return YYERROR; }
    | '-' error { $$ = 0; return YYERROR; }
    ;
    
    /* need help on struct */
    /* ask abt statement keyword*/
    stmt:
    FOR (IDENTIFIER = exp; exp; stmt) stmt
    | IF (exp) THEN stmt
    | IF (exp) THEN stmt ELSE stmt
    | PRINTF (string)
    | RETURN exp
    | { stmt-seq }
    | declaration
    | l-exp '=' exp
    ;
    /* need help on dotdotdot portions*/
    
    stmt-seq:
    | stmt stmt-seq
    ;
    
    1-exp:
    IDENTIFIER
    | IDENTIFIER.1-exp
    ;
    
    


%%
    
    class ToYLexer implements ToY.L {
     InputStreamReader it;
     Yylex yylex;
     
     public ToYLexer(InputStream is){
     it = new InputStreamReader(is);
     yylex = new Yylex(it);
     }
     
     @Override
     public void yyerror (String s){
     System.err.println(s);
     }
     ParserToken yylval;
     
     @Override
     public Object getLVal() {
     // Returns the semantic value of the last token that yylex returned.
     return yylval;
     }
     
     @Override
     public int yylex () throws IOException{
     // Returns the next token. Here we get the next Token from the Lexer
     return yylex.yylex();
     }
    }


