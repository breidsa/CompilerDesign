%language "Java"
%define api.prefix {ToY}
%define api.parser.class {ToY}
%define api.parser.public
%define parse.error verbose
//%define api.value.type {Yytoken}


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
HashMap<String, ID> functions = new HashMap<String, ID>();
HashMap<String, ID> statements = new HashMap<String, ID>();
HashMap<String, ID> var = new HashMap<String, ID>();

public static void main(String[] args) throws IOException {
FileReader yyin = new FileReader(args[0]);
 ToYLexer l = new ToYLexer(yyin);
 ToY p = new ToY(l);
 if (!p.parse()) System.out.println("INVALID");
}
}

/* Bison Declarations do we need the AST NODE HERE */
/* Questions: does boolean and stuff have to come from the lexer?? */
%token  INT BOOL STRING VOID
%token  IDENTIFIER 
%token  COMMENT
%token  TRUE FALSE 
%token  IF THEN ELSE FOR STRUCT
%token  RETURN PRINTF 
%token  SEMICOLON COMMA
%token  EQ ATTRIBUTE
%token  RBRACKET LBRACKET LEFTPAREN RIGHTPAREN
%token  LESSTHAN GREATERTHAN DOUBLEEQ LESSTHANOREQ GREATERTHANOREQ NOTEQ
%token  AND OR NOT 
%token  PLUS MINUS MULT DIVIDE MOD

%left OR AND 



%type  type
%type  returnType
%type  struct
%type  declaration
%type  function
%type  paramList
%type  stmt
%type  stmtSeq
%type  Lexp
%type  pgm
%type  recursePgm
%type  exp


/* %type op */



%start pgm

%%
    
     type: INT /* { $$ = new Type(); } */
    | BOOL /* { $$ = new Type(); } */
    | STRING /* { $$ = new Type(); } */
    /*
    | IDENTIFIER
    */
    ;
    
    returnType: type //{ $$ = $1; }
    | VOID /* { $$ = new Type(); } */
    ;
    
    struct : STRUCT IDENTIFIER LBRACKET declarationList RBRACKET //{ $$ = new StructCreator($2, $4); }
    ;
    
    declaration: type IDENTIFIER // { $$ = new Decl($2); }
    ;
    //MAYBE ADD DECLARATION LIST 

    declarationList: /*empty*/
    | declaration //{ $$ = $1; }
    | declaration COMMA declarationList
    ;

    function : returnType IDENTIFIER LEFTPAREN declarationList RIGHTPAREN LBRACKET stmt RBRACKET SEMICOLON //{ $$ = new FunctionConstruct($1, $3) }
    ;

    paramList: IDENTIFIER 
    | IDENTIFIER COMMA paramList
    | /* empty */
    ;
    
    
    stmt : FOR LEFTPAREN exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN stmt SEMICOLON // { ForLoop fl = new ForLoop($3, $5, $7, $9); nodeHash.put(fl); $$ = fl; }
    | IF LEFTPAREN exp RIGHTPAREN THEN stmt SEMICOLON //{ $$ = new IfStmt($3, $6, null); }
    | IF LEFTPAREN exp RIGHTPAREN THEN stmt ELSE stmt SEMICOLON //{ $$ = new IfStmt($3, $6, $8); }
    | PRINTF LEFTPAREN STRING RIGHTPAREN SEMICOLON //{ $$ = new EndFunction($2); }
    | RETURN exp SEMICOLON //{ $$ = new EndFunction($2); }
    | LBRACKET stmtSeq RBRACKET //{ $$ = $1; }
    | declaration SEMICOLON //{ $$ = $1; } 
    | Lexp EQ exp SEMICOLON //{ $$ = new Asnmt($1, $3); }
    | IDENTIFIER paramList SEMICOLON //{ $$ = $1; } 
    | IDENTIFIER EQ IDENTIFIER paramList SEMICOLON //{ $$ = new Asnmt($1, $3); }  
    ;
    
    stmtSeq : /* empty sequence */
    | stmt SEMICOLON stmtSeq //{make a list of statements HERE}
    ;
    
    Lexp : IDENTIFIER 
    | IDENTIFIER ATTRIBUTE Lexp /* attribute is a . like: <id > . <l - exp > */
    ;
    
    pgm : function recursePgm 
    | struct pgm 
    ;
    
    recursePgm : /* empty sequence */
    | function recursePgm 
    | struct recursePgm 
    ;
    
    exp : type //{ $$ = $1 }
    | TRUE //{ $$ = $1; } DOES NOT COMPILE WHEN I REMOVE THIS 
    | FALSE { $$ = $1; }
    | exp PLUS exp { $$ = new Arithmetic($1, $3); }
    | exp MINUS exp { $$ = new Arithmetic($1, $3); }
    | exp MULT exp { $$ = new Arithmetic($1, $3); }
    | exp DIVIDE exp { $$ = new Arithmetic($1, $3); }
    | exp MOD exp  { $$ = new Arithmetic($1, $3); }
    | exp AND exp { $$ = new Conditions($1, $3); }
    | exp OR exp { $$ = new Conditions($1, $3); }
    | exp DOUBLEEQ exp { $$ = new Conditions($1, $3); }
    | exp GREATERTHAN exp { $$ = new Conditions($1, $3); }
    | exp LESSTHAN exp { $$ = new Conditions($1, $3); }
    | exp GREATERTHANOREQ exp { $$ = new Conditions($1, $3); }
    | exp LESSTHANOREQ exp { $$ = new Conditions($1, $3); }
    | exp NOTEQ exp { $$ = new Conditions($1, $3); }
    | exp EQ exp { $$ = new Asnmt($1, $3); }
    | NOT exp { $$ = new UnaryOperators($2); }
    | MINUS exp { $$ = new UnaryOperators($2); }
    | LEFTPAREN exp RIGHTPAREN { $$ = $2; }
    ;

  
  /* might not need this */
   //  op : PLUS
   //  | MINUS
   //  | MULT
   //  | DIVIDE
   //  | MOD
   //  | AND
   //  | OR
   //  | DOUBLEEQ
   //  | GREATERTHAN
   //  | LESSTHAN
   //  | GREATERTHANOREQ
   //  | LESSTHANOREQ
   //  | NOTEQ
   //  | EQ
   //  ;
 
 
%%
//java code for making the AST and the visitor class -----------------------------------------------------------
// ~~~~~~ idea: what if we made a variable class and made all names and stuff of type Var ~~~~~~~ 

// Asbstract syntax tree base class.  
// methods: accept
//          accept method will call the Visitor class, will accept a node if deemed "correct" by semantic analysis 
//          this method will be applied in all subclasses that create nodes
abstract class ASTNode {
    abstract Object accept(Visitor v); /* This may have to be type ID...not sure */
    // might need children nodes
}

class StmtList {
    ArrayList<ASTNode> stmts;

    public StmtList() {
        stmts = new ArrayList<ASTNode>();
    }

    public void addElement(ASTNode n) {
        stmts.add(n);
    }

    public ASTNode elementAt(int i) {
        return (ASTNode) stmts.get(i);
    }
    // public int size() {
    // return stmts.size();
    // }
}

// ------------------------------- Expression subclasses
// ------------------------------------------

// Arithmetic Class that extends the ASTNode class
// creates two Nodes, the left and right sides of an arithmetic statement
// constructor allows semantic actions to initialize nodes
class Arithmetic extends ASTNode {
    public Object left, right;

    public Arithmetic(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// Conditions class that extends the ASTNode class
// creates two Nodes, the left and right sides of a conditional statement
// constructor allows semantic actions to initialize nodes
class Conditions extends ASTNode {
    public Object left, right;

    public Conditions(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// UnaryOperators class that extends the ASTNode class
// creates one Node, the right statement of a unary expression
// constructor allows semantic actions to initialize nodes
class UnaryOperators extends ASTNode {
    public Object right;

    public UnaryOperators(Object right) {
        this.right = right;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// EndFunctions class that extends the ASTNode class
// Used for return and print functions
// creates one node, the expression to be printed or returned
// constructor allows semantic actions to initialize nodes
class EndFunction extends ASTNode {
    Object exp;

    public EndFunction(Object exp) {
        this.exp = exp;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// ----------------------------------- Method subclasses
// ---------------------------------------------

// ForLoop class that extends the ASTNode class
// creates four nodes, the for loop iterator, it's conditional, its
// incrementation statement, and the loop body
// constructor allows semantic actions to initialize nodes
class ForLoop extends ASTNode {

    Object iterator;
    Object conditional;
    Object increment;
    StmtList body;

    public ForLoop(Object iterator, Object conditional, Object increment, StmtList body) {
        this.iterator = iterator;
        this.conditional = conditional;
        this.increment = increment;
        this.body = body;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// IfStmt class that extends the ASTNode class
// creates three nodes, the if statment conditional, the if statment body, and
// the else statement
// else statement can bc a null pointer, in which case only 2 nodes are created
// constructor allows semantic actions to initialize nodes
class IfStmt extends ASTNode {

    Object conditional;
    StmtList body;
    Object elseStmt;

    public IfStmt(Object conditional, StmtList body, Object elseStmt) {
        this.conditional = conditional;
        this.body = body;
        this.elseStmt = elseStmt;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// ---------------------------- Variable subclasses
// ----------------------------------------------

// Asnmt class that extends the ASTNode class
// The class is used when assigning objects to variables
// Creates two nodes, the variable and the expression
// constructor allows semantic actions to initialize nodes
class Asnmt extends ASTNode {
    Object var;
    Object exp;

    public Asnmt(Object var, Object exp) {
        this.var = var;
        this.exp = exp;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// Decl class that extends the ASTNode class
// used for variable declarations, which can potentially be multiple in a row
// creates 1 node: a list of all the variable names
// constructor allows semantic actions to initialize nodes
class Decl extends ASTNode {
    // QUESTION: would we need type
    // String varType;
    // String name;
    ArrayList<String> names;

    public Decl(ArrayList<String> names) {
        // this.varType = varType;
        this.names = names;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// ------------------------------ Type class question
// -------------------------------------------

// ******** ASK QUESTION ABOUT WHAT TO DO FOR JUST TYPES ********
class Type extends ASTNode {

    public Type() {
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// ---------------------------------------- Program subclasses
// --------------------------------------

// Struct class that extends the ASTNode class
// creates 2 nodes: the name of the struct and an ArrayList of all the struct
// fieldTypes
// constructor allows semantic actions to initialize nodes
class StructCreator extends ASTNode {
    Object name;
    StmtList fieldTypes;

    public StructCreator(Object name, StmtList fieldTypes) {
        this.name = name;
        this.fieldTypes = fieldTypes;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// ****** QUESTION: does the body need to be another node? *******

// Function class that extends the ASTNode class
// creates 2 nodes, the function name and it's parameters
// constructor allows semantic actions to initialize nodes
class FunctionConstuct extends ASTNode {
    Object returnType;
    Object name;
    ArrayList<String> parameters;
    StmtList body;

    public FunctionConstuct(Object returnType, Object name, ArrayList<String> parameters, StmtList body) {
        this.returnType = returnType;
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// FunctionCall class that extends the ASTNode class
// specifically for when you don't want to have full declarations in the
// parenthesis, just already declared param names
// creates 2 nodes, the name (a string) and the parameters, which are an array
// of strings (variable names)
// constructor allows semantic actions to initialize nodes
class FunctionCall extends ASTNode {
    Object name;
    ArrayList<String> parameters;
    // ASK ABOUT BODY

    public FunctionCall(Object name, ArrayList<String> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// ------------------------------------- Semantic Analysis
// ------------------------------------------

// An implementation of all the visitor methods
// These act as semantic analysis, so each of these methods will visit the nodes
// in the AST tree and make
// sure that they are semantically doing the correct thing
class AbstractVisitor implements Visitor {

    // arithmetic expressions

    public Object visit(Arithmetic add) {
        // return add.e1.accept(this) + add.e2.accept(this);
        return null;
    }

    public Object visit(Conditions n) {
        return null;
    }

    public Object visit(UnaryOperators n) {
        return null;
    }

    public Object visit(Asnmt n) {
        return null;
    }

    public Object visit(Decl n) {
        return null;
    }

    public Object visit(EndFunction n) {
        return null;
    }

    public Object visit(ForLoop n) {
        return null;
    }

    public Object visit(IfStmt n) {
        return null;
    }

    public Object visit(StructCreator n) {
        return null;
    }

    public Object visit(Type n) {
        return null;
    }

    public Object visit(FunctionConstuct n) {
        return null;
    }

    public Object visit(FunctionCall n) {
        return null;
    }

}

// A declaration of all the visitor methods for each AST subclass
interface Visitor {

    public Object visit(Arithmetic symbol);

    public Object visit(Conditions symbol);

    public Object visit(UnaryOperators symbol);

    public Object visit(Asnmt symbol);

    public Object visit(Decl symbol);

    public Object visit(EndFunction symbol);

    public Object visit(ForLoop symbol);

    public Object visit(IfStmt symbol);

    public Object visit(StructCreator symbol);

    public Object visit(Type symbol);

    public Object visit(FunctionConstuct symbol);

    public Object visit(FunctionCall symbol);

}


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
   
 // symbol table class -------------------------------------------------------------------------
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



// for the parser and lexer link ------------------------------------------------------
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
    

















    