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

// delcare global hashmaps to fill while parsing -------------------------------------------------------------------------
HashMap<String, ID> functions;
HashMap<String, ID> statements;
HashMap<String, ID> var;

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


// Java code for the HashMaps ID TYPES -------------------------------------------------------------------------
class ID {
    String name;
    int scope;
    // String type;
    // String returnType;
    // ArrayList<String> parameterTypes;
    // ArrayList<String> fieldTypes;
    // int size;

    public ID(String name) {
        this.name = name;
        // this.type = type;
        // this.returnType = returnType;
        // this.parameterTypes = parameterTypes;
        // this.fieldTypes = fieldTypes;
        // this.size = size;
    }
    public String getName(){
       return this.name;
    }
    public void setScope(int Scope){
       this.scope = scope;
    }
}

class Var extends ID {
    String type;

    public Var(String name, String type) {
        super(name);
        this.type = type;

    }
}

class Function extends ID {
    String returnType;
    ArrayList<String> parameterTypes;

    public Function(String name, String returnType, ArrayList<String> parameterTypes) {
        super(name);
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

}

class Struct extends ID {
    ArrayList<String> fieldTypes;
    int size;

    public Struct(String name, ArrayList<String> fieldTypes, int size) {
        super(name);
        this.fieldTypes = fieldTypes;
        this.size = size;
    }

}
   
   
  class SymbolTable{
   
   int scope = 0; 
   HashMap<String, ID> currentScope; 
   ArrayList<HashMap<String, ID>> table;

   public SymbolTable() {
		table = new ArrayList<HashMap<String, ID>>();
		table.add(new HashMap<String, ID>());
	}

   public void addScope(){
      table.add(new HashMap<String, ID>());
      scope++;
   }

   public void enterScope(){
      this.scope++;
   }

   public void exitScope(){
      this.scope--;
   }

   /*
   public void enterScope(int scope){
      this.currentScope = table.get(scope);
   }
   

   //NOT SURE WHAT TO DO WITH THIS METHOD
   public void exitScope(){
      this.currentScope = table.get(0);; 
   }
   */
   

   //see if the symbol is already included in the table returns the symbol if found
   public ID find_symbol(ID id){
      for (int i = this.scope; i >= 0; i--) {
			if (this.table.get(i).containsKey(id.getName())) {
				return this.table.get(i).get(id.getName());
			}
		}
		return null;

   }

   //adds all the information we need to know about x in current scope
   public boolean add_symbol(ID id){
      if (id != null && find_symbol(id) == null) {
			this.table.get(this.scope).put(id.getName(), id);
			id.setScope(this.scope);
			return true;
		}
		return false;
   }

   //check if x is in current scope and if it is returns the symbol 
   public ID check_scope(ID id){
      if(this.currentScope.containsKey(id.getName())){
         return this.table.get(this.scope).get(id.getName());
      }
      return null;
      
   } 

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
    

















    