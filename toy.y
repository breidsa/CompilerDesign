

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
%token RBRACKET LBRACKET SEMICOLON LESSTHAN GREATERTHAN DOUBLEEQ LESSTHANOREQ GREATERTHANOREQ NOTEQ NOT LEFTPAREN RIGHTPAREN PLUS MINUS MULT DIVIDE EQ


%type type
%type returnType
%type struct
%type declaration
%type proc
%type stmt
%type stmtSeq
%type Lexp
%type pgm
%type recursePgm
%type exp
%type op


%start program

%%
    
    program:
    stmt {program}
    ;
    
    type: INT 
    | BOOL 
    | STRING 
    | IDENTIFIER
    ;
    
    returnType: type 
    | VOID
    ;
    
    struct : STRUCT IDENTIFIER LBRACKET DECLARATION COMMA DECLARATION RBRACKET /* this needs: , ... inside the RBRACKET */
    ;
    
    declaration: type IDENTIFIER
    ;
    
    proc : returnType IDENTIFIER LEFTPAREN declaration RIGHTPAREN LBRACKET stmt RBRACKET /* this needs: , ... after declaration before rightparen */
    ;
    
    stmt : FOR LEFTPAREN IDENTIFIER EQUAL exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN stmt
    | IF LEFTPAREN exp RIGHTPAREN THEN stmt
    | IF LEFTPAREN exp RIGHTPAREN THEN stmt ELSE stmt
    | PRINTF LEFTPAREN string RIGHTPAREN SEMICOLON
    | RETURN exp SEMICOLON
    | LBRACKET stmtSeq RBRACKET /* compound statement */
    | type IDENTIFIER SEMICOLON  /* variable declaration */
    | Lexp EQ exp SEMICOLON /* assignment */
    | IDENTIFIER LEFTPAREN exp RIGHTPAREN SEMICOLON  /* void procedure call; needs a ,... after exp before rightparen*/
    | IDENTIFIER EQ IDENTIFIER LEFTPAREN exp RIGHTPAREN SEMICOLON  /* non - void procedure call;  needs a ,... after exp before rightparen */
    ;
    
    stmtSeq : /* empty sequence */
    | stmt stmtSeq
    ;
    
    Lexp : IDENTIFIER 
    | IDENTIFIER ATTRIBUTE Lexp /* attribute is a . like: <id > . <l - exp > */
    ;
    
    pgm : proc recursePgm 
    | struct pgm 
    ;
    
    recursePgm : /* empty sequence */
    | proc recursePgm 
    | struct recursePgm 
    ;
    
    exp : INT
    | STRING 
    | TRUE
    | FALSE
    | exp op exp 
    | NOT exp 
    | Lexp
    | LEFTPAREN exp RIGHTPAREN
    ;
  
    op : PLUS
    | MINUS
    | MULT
    | DIVIDE
    | MOD
    | AND
    | OR
    | DOUBLEEQ
    | GREATERTHAN
    | LESSTHAN
    | GREATERTHANOREQ
    | LESSTHATOREQ
    | NOTEQ
    | EQ
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
    
    /*
    class SymbolTable {
    enter_scope()
    exit_scope()
    
    }
    */


