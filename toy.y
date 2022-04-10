%language "Java"
%define api.prefix {ToY}
%define api.parser.class {ToY}
%define api.parser.public
%define parse.error verbose
%define api.value.type {Yytoken}


%code imports {
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.*;
}


%code {
public static void main(String[] args) throws IOException {
FileReader yyin = new FileReader(args[0]);
 ToYLexer l = new ToYLexer(yyin);
 ToY p = new ToY(l);
 if (!p.parse()) System.out.println("INVALID");
}
}

/* Bison Declarations */
/* Questions: does boolean and stuff have to come from the lexer?? */
%token INT
%token BOOL STRING IDENTIFIER COMMENT
%token TRUE FALSE IF THEN ELSE FOR AND OR MOD
%token VOID RETURN PRINTF STRUCT
%token RBRACKET LBRACKET SEMICOLON COMMA LESSTHAN GREATERTHAN DOUBLEEQ LESSTHANOREQ GREATERTHANOREQ NOTEQ NOT LEFTPAREN RIGHTPAREN PLUS MINUS MULT DIVIDE EQ ATTRIBUTE


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


%start pgm

%%
    
    type: INT 
    | BOOL 
    | STRING 
    | IDENTIFIER
    ;
    
    returnType: type 
    | VOID
    ;
    
    struct : STRUCT IDENTIFIER LBRACKET declaration COMMA declaration RBRACKET /* this needs: , ... inside the RBRACKET */
    ;
    
    declaration: type IDENTIFIER
    ;
    
    proc : returnType IDENTIFIER LEFTPAREN declaration RIGHTPAREN LBRACKET stmt RBRACKET /* this needs: , ... after declaration before rightparen */
    ;
    
    stmt : FOR LEFTPAREN IDENTIFIER EQ exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN stmt
    | IF LEFTPAREN exp RIGHTPAREN THEN stmt
    | IF LEFTPAREN exp RIGHTPAREN THEN stmt ELSE stmt
    | PRINTF LEFTPAREN STRING RIGHTPAREN SEMICOLON
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
    
    /*
    
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
  
  */
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
    | LESSTHANOREQ
    | NOTEQ
    | EQ
    ;
 
 
%%
    
    class ToYLexer implements ToY.Lexer {
      Yylex yylex;
    
     

    public ToYLexer(FileReader is){
      yylex = new Yylex(is);
     }

    
     
     @Override
     public void yyerror (String s){
     System.err.println(s);
     }
      Object yylval;
     
     @Override
      public Yytoken getLVal() {
         return token;
      }

      Yytoken token;

      @Override
      public int yylex () throws IOException{
         token = yylex.yylex();
         return token.type;
      }
    }
    

















    /*
    public class Scope {
    
     private Hashtable<String,Integer> hash;
     private int parseLevel;
     
     public Scope(int parseLevel){
        this.parseLevel = parseLevel;
        map = new Hashtable<>();
     }
     
     public Scope(){
        parseLevel = 0;
     }

     public void define(String name, Integer val){
        map.put(name, val);
     }

     public boolean isMatching(String name){
        return map.containsKey(name);
     }

     public Integer getVal(String name){
        return  map.get(name);
     }
    
     public int getParseLevel(){
        return parseLevel;
     }
    }

    
    
    public class SymbolTable {
    enter_scope()
    exit_scope()
    
    }

*/

