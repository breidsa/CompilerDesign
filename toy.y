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
import java.util.HashMap;
import java.util.ArrayList;
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
%token <INTEGER> INT
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
    
    exp : INT /*{ $$ = $1; }*/
    | STRING /*{ $$ = $1; }*/
    | TRUE /*{ $$ = $1; }*/
    | FALSE /*{ $$ = $1; }*/
    /*| exp PLUS exp { $$ = $1 + $3 }
    | exp MINUS exp { $$ = $1 - $3; }
    | exp MULT exp { $$ = $1 * $3; }
    | exp DIVIDE exp { $$ = $1 / $3; }
    | exp MOD exp
    | exp AND exp
    | exp OR exp
    | exp DOUBLEEQ exp
    | exp GREATERTHAN exp
    | exp LESSTHAN exp
    | exp GREATERTHANOREQ exp
    | exp LESSTHANOREQ exp
    | exp NOTEQ exp
    | exp EQ exp { if ($1.intValue() != $3.intValue()) yyerror("calc: error: " + $1 + " != " + $3); }*/
    
    | exp op exp
    | NOT exp /*{ $$ = 0; return YYERROR; }*/
    | MINUS exp /*%prec NEG { $$ = -$2; } /* might not need prec Neg */
    | LEFTPAREN exp RIGHTPAREN /*{ $$ = $2; }*/
    ;
    /*
    
    exp:
 NUM { $$ = $1; }
| exp '=' exp { if ($1.intValue() != $3.intValue()) yyerror("calc: error: " + $1 + " != " + $3); }

| '-' exp %prec NEG { $$ = -$2; }
| exp '^' exp { $$ = (int) Math.pow($1, $3); }

| '!' { $$ = 0; return YYERROR; }
| '-' error { $$ = 0; return YYERROR; }
  
  */
  
  /* might not need this */
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
   // Java code for the HashMaps
   class Function {
      String name;
      String type; 
      ArrayList<String> parameters;
      //contrustor
      public Function(String name, String type, ArrayList<String> parameters){
         this.name = name;
         this.type = type;
         this.parameters = parameters;
      }
   }

   class Struct {
      String name;
      ArrayList<String> definitions;
      
      //contrustor
      public Struct(String name, ArrayList<String> definitions){
         this.name = name;
         this.definitions = definitions;
      }
   }

   class Var {
      String name;
      String type; 
      String value;

      //contrustor
      public Var(String name, String type, String value){
         this.name = name;
         this.type = type;
         this.value = value;
      }
   }
   
   
  class Symbol{

  }

  class SymbolVar extends Symbol{

  }

  class SymbolFunction extends Symbol{


  }

  class SymbolStruct extends Symbol{

  }


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
    

















    