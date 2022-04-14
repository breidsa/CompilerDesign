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
HashMap<Object, ID> functions = new HashMap<Object, ID>();
HashMap<Object, ID> statements = new HashMap<Object, ID>();
// HashMap<Object, ID> var = new HashMap<Object, ID>();

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


%nonassoc LESSTHAN GREATERTHAN GREATERTHANOREQ LESSTHANOREQ DOUBLEEQ NOTEQ
%left MULT DIVIDE MOD
%left PLUS MINUS
%nonassoc NOT

%left ATTRIBUTE

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

//MGARG@TCD.IE
    
    type: INT { $$ = new VarDef($1, null); }
    | BOOL { $$ = new VarDef($1, null); }
    | STRING { $$ = new VarDef($1, null); }
    ;
    
    returnType: type { $$ = $1; }
    | VOID { $$ = new Keyword($1); }
    ;
    
    struct : STRUCT IDENTIFIER LBRACKET declarationList RBRACKET { $$ = new StructCreator($2, (StmtList)$4); Struct st = new Struct($2,(StmtList)$4); statements.put($2, st);} /* {StmtList fieldTypes = new StmtList(); fieldTypes.addElement($4); $$ = new StructCreator($2, fieldTypes);} */
    ;                                                              

                   
    declaration: type IDENTIFIER {$$ = new VarDef($1, $2); } 
    ;
    
    declarationList: /* empty */ {$$ = new StmtList();}  
    | declarationList COMMA declaration {StmtList decls = (StmtList) $1; decls.addElement($3); $$ = decls;} 
    ;                         
    

    function : returnType IDENTIFIER LEFTPAREN declarationList RIGHTPAREN LBRACKET stmtSeq RBRACKET SEMICOLON {$$ = new FunctionConstruct($1, $2, $4, (StmtList)$7);
                                                                                                             Function ft = new Function($2, $1, (StmtList)$4); functions.put($2, ft);}
    ;
    
    param: IDENTIFIER {$$ = new VarDef(null, $1); } 
    ;

    paramList:  {$$ = new StmtList();}
    | paramList COMMA param {StmtList params = (StmtList) $1; params.addElement($3); $$ = params;}
    ;
    
    
    /* I want to look at the 1st stmt for the for loop */
    stmt : FOR LEFTPAREN IDENTIFIER EQ exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN stmtSeq SEMICOLON { Asnmt iterator = new Asnmt($3, $5);
											               $$ = new ForLoop(iterator, $7, $9, (StmtList)$11);}
    | IF LEFTPAREN exp RIGHTPAREN THEN stmtSeq SEMICOLON { $$ = new IfStmt($3, (StmtList) $6, null); }
    | IF LEFTPAREN exp RIGHTPAREN THEN stmtSeq ELSE stmtSeq SEMICOLON { $$ = new IfStmt($3, (StmtList)$6, (StmtList)$8);}
    | PRINTF LEFTPAREN STRING RIGHTPAREN SEMICOLON { $$ = new EndFunction($2); }
    | RETURN exp SEMICOLON { $$ = new EndFunction($2); }
    | LBRACKET stmtSeq RBRACKET { $$ = $1; }
    | declaration SEMICOLON { $$ = $1; } 
    | Lexp EQ exp SEMICOLON { $$ = new Asnmt($1, $3); }
    | IDENTIFIER paramList SEMICOLON { $$ = new FunctionCall($1, $2); }
    | IDENTIFIER EQ IDENTIFIER paramList SEMICOLON { FunctionCall func = new FunctionCall($3, (StmtList) $4); $$ = new Asnmt($1, func); }  
    ;
    
    stmtSeq : /* empty sequence */ { $$ = new StmtList();}
    | stmt SEMICOLON stmtSeq { StmtList sequence = (StmtList) $3; sequence.addElement($1); $$ = sequence; }
    ;
    
    Lexp : param { StmtList emptyList = new StmtList(); emptyList.addElement($1); $$ = emptyList; }
    | param ATTRIBUTE Lexp { StmtList attributeList = (StmtList)$3; attributeList.addElement($1); $$ = attributeList; }
    ;
    
    // This will initially go to recurseProgram, and create an empty function that will either act as main, or just have the 1 required function
    // if there is only one in the test code
    
    // create pgm class that has a list of ASTNodes 
    pgm : recursePgm { $$ = $1; }
    ;
    
    recursePgm : /* empty sequence */ { $$ = new StmtList(); }
    | function recursePgm { StmtList pgm = (StmtList) $2; pgm.addElement($1); $$ = pgm; }
    | struct recursePgm  { StmtList pgm = (StmtList) $2; pgm.addElement($1); $$ = pgm; }
    ;
    
    exp : type { $$ = $1; }
    | TRUE { $$ = new Keyword($1); } 
    | FALSE { $$ = new Keyword($1); }
    | exp PLUS exp { $$ = new Arithmetic($1, $2, $3); }
    | exp MINUS exp { $$ = new Arithmetic($1,$2,$3); }
    | exp MULT exp { $$ = new Arithmetic($1, $2,$3); }
    | exp DIVIDE exp { $$ = new Arithmetic($1,$2, $3); }
    | exp MOD exp  { $$ = new Arithmetic($1,$2, $3); }
    | exp AND exp { $$ = new Logic($1, $2, $3); }
    | exp OR exp { $$ = new Logic($1, $2, $3); }
    | exp DOUBLEEQ exp { $$ = new Conditions($1, $2, $3); }
    | exp GREATERTHAN exp { $$ = new Conditions($1, $2, $3); }
    | exp LESSTHAN exp { $$ = new Conditions($1, $2, $3); }
    | exp GREATERTHANOREQ exp { $$ = new Conditions($1, $2, $3); }
    | exp LESSTHANOREQ exp { $$ = new Conditions($1, $2, $3); }
    | exp NOTEQ exp { $$ = new Conditions($1, $2, $3); }
    | exp EQ exp { $$ = new Asnmt($1, $3); }
    | NOT exp { $$ = new UnaryOperators($1, $2); }
    | MINUS exp { $$ = new UnaryOperators($1, $2); }
    | LEFTPAREN exp RIGHTPAREN { $$ = $2; }
    ;

 
 
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
	// stmtLists are ArrayList<Object>s, but are used in classes that create ASTNodes, so an Array<List> in this case is an ASTNode.
    ArrayList<Object> stmts;

    public StmtList() {
        stmts = new ArrayList<Object>();
    }

    public void addElement(Object n) {
        stmts.add(n);
    }

    public Object elementAt(int i) {
        return stmts.get(i);
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
    public Object left, right, op;

    public Arithmetic(Object left, Object op, Object right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public Object getLeft(){
        return this.left;
    }

    public Object getRight(){
        return this.right;
    }

    public Object getOp(){
        return this.op;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

class Logic extends ASTNode {
    public Object left, right, op;

    public Logic(Object left, Object op, Object right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public Object getLeft(){
        return this.left;
    }

    public Object getRight(){
        return this.right;
    }

    public Object getOp(){
        return this.op;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// Conditions class that extends the ASTNode class
// creates two Nodes, the left and right sides of a conditional statement
// constructor allows semantic actions to initialize nodes
class Conditions extends ASTNode {
    public Object left, op, right;

    public Conditions(Object left, Object op, Object right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public Object getLeft(){
        return this.left;
    } 

    public Object getRight(){
        return this.right;
    }

    public Object getOp(){
        return this.op;
    }


    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// UnaryOperators class that extends the ASTNode class
// creates one Node, the right statement of a unary expression
// constructor allows semantic actions to initialize nodes
class UnaryOperators extends ASTNode {
    public Object op, right;

    public UnaryOperators(Object op, Object right) {
        this.op = op;
        this.right = right;
    }

    public Object getRight(){
        return this.right;
    }

    public Object getOp(){
        return this.op;
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
    StmtList ifBody;
    StmtList elseBody;

    public IfStmt(Object conditional, StmtList ifBody, StmtList elseBody) {
        this.conditional = conditional;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
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

    public Object getVar(){
        return this.var;
    }

    public Object getExp(){
        return this.exp;
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
    
    // MAYBE DECL NEEDS A HASMAP
    ArrayList<Object> names;

    public Decl(ArrayList<Object> names) {
        // this.varType = varType;
        this.names = names;
    }

    public Object getNames(){
        return this.names;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// this might just be a Var definition situation????
class ParamList extends ASTNode {
	StmtList params;
	
	public ParamList(StmtList params){
		this.params = params;
	}

    public Object getParams(){
        return this.params;
    }
	
	public Object accept(Visitor v) {
        	return v.visit(this);
    	}
}

class Keyword extends ASTNode {
	Object keyword;
	
	public Keyword(Object keyword){
		this.keyword = keyword;
	}

    public Object getKeyword(){
        return this.keyword;
    }
	
	public Object accept(Visitor v) {
        	return v.visit(this);
    	}
}
	

// ********************** POTENTIAL SOLUTION FOR VAR AND PARAM ***************

class VarDef extends ASTNode {
	
	Object type, name;
	
	public VarDef(Object type, Object name){
		this.type = type;
		this.name = name;
    }	

    public Object getType(){
        return this.type;
    }

    public Object getName(){
        return this.name;
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

// ---------------------------------------- Program classes & subclasses 
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

    public Object getName(){
        return this.name;
    }

    public StmtList getFeilds(){
        return this.fieldTypes;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// ****** QUESTION: does the body need to be another node? *******

// Function class that extends the ASTNode class
// creates 2 nodes, the function name and it's parameters
// constructor allows semantic actions to initialize nodes
class FunctionConstruct extends ASTNode {
    Object returnType;
    Object name;
    Object parameters;
    StmtList body;

    public FunctionConstruct(Object returnType, Object name, Object parameters, StmtList body) {
        this.returnType = returnType;
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public Object getReturnType(){
        return this.returnType;
    }

    public Object getName(){
        return this.name;
    }

    public Object getParameters(){
        return this.parameters;
    }

    public StmtList getBody(){
        return this.body;
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
    Object parameters;
    // ASK ABOUT BODY

    public FunctionCall(Object name, Object parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public Object getName(){
        return this.name;
    }

    public Object getParameters(){
        return this.parameters;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// Program class, almost acts are our main parent node :)
class Program extends ASTNode {
	StmtList program;
	
	public Program(StmtList program){
		this.program = program;
	}

    public StmtList getProgram(){
        return this.program;
    }
	
	public Object accept(Visitor v) {
        	return v.visit(this);
    }
}
	


// ------------------------------------- Semantic Analysis JUMP
// ------------------------------------------

// An implementation of all the visitor methods
// These act as semantic analysis, so each of these methods will visit the nodes
// in the AST tree and make
// sure that they are semantically doing the correct thing
class AbstractVisitor implements Visitor {

    // arithmetic expressions

    public boolean visit(Arithmetic add) {
        int op = ((Yytoken)(add.getOp())).getToken();
        int left = ((Yytoken)(add.getLeft())).getToken();
        int right = ((Yytoken)(add.getRight())).getToken();
        if (op == ToYLexer.PLUS || op == ToYLexer.MINUS ){
            if ((left == ToYLexer.INT && right == ToYLexer.INT) ||(left == ToYLexer.STRING && right == ToYLexer.STRING) ){
                return true;
            }
        }
        if (op == ToYLexer.MULT || op == ToYLexer.DIVIDE ){
            if (left == ToYLexer.INT && right == ToYLexer.INT){
                return true;
            }
        }
        
        return false;
    }

    public boolean visit(Logic add) {
        //int op = ((Yytoken)(add.getOp())).getToken();
        int left = ((Yytoken)(add.getLeft())).getToken();
        int right = ((Yytoken)(add.getRight())).getToken();
        if (left == ToYLexer.BOOL && right == ToYLexer.BOOL){
            return true;
        }
        
        return false;
    }

    public boolean visit(Conditions add) {
        int op = ((Yytoken)(add.getOp())).getToken();
        int left = ((Yytoken)(add.getLeft())).getToken();
        int right = ((Yytoken)(add.getRight())).getToken();
        if (op == ToYLexer.GREATERTHAN || op == ToYLexer.GREATERTHANOREQ || op == ToYLexer.LESSTHAN || op == ToYLexer.LESSTHANOREQ ){
            if (left == ToYLexer.INT && right == ToYLexer.INT){
                return true;
            }
        }
        if (op == ToYLexer.DOUBLEEQ || op == ToYLexer.NOTEQ ){
            if ((left == ToYLexer.INT && right == ToYLexer.INT) ||(left == ToYLexer.STRING && right == ToYLexer.STRING) ){
                return true;
            }
        }
        
        return false;
    }

    public boolean visit(UnaryOperators add) {
        int op = ((Yytoken)(add.getOp())).getToken();
        int right = ((Yytoken)(add.getRight())).getToken();
        if (op == ToYLexer.NOT && right == ToYLexer.BOOL){
            return true;
        }
        if (op == ToYLexer.MINUS && right == ToYLexer.INT){
            return true;
        }
        return false;
    }

    //SO I THINK FOR THIS WE MIGHT NEED TO PULL THE TYPE FROM SOMEWHERE I AM KINDA CONFUSED 
    public boolean visit(Asnmt add) {
        return false;
    }

    public boolean visit(Decl add) {
        return false;
    }

    public boolean visit(EndFunction add) {
        return false;
    }

    public boolean visit(ForLoop add) {
        return false;
    }

    public boolean visit(IfStmt add) {
        return false;
    }

    public boolean visit(StructCreator add) {
        return false;
    }

    public boolean visit(Type add) {
        return false;
    }

    public boolean visit(FunctionConstruct add) {
        return false;
    }

    public boolean visit(FunctionCall add) {
        return false;
    }
    
    public boolean visit(ParamList add) {
        return false;
    }
    
    public boolean visit(VarDef add) {
        int type = ((Yytoken)(add.getType())).getToken();
        int name = ((Yytoken)(add.getName())).getToken();
        // CHECK DO WE NEED TO CHECK IF THIS IS OF TYPE STRUCT 
        if ((type == ToYLexer.BOOL || type == ToYLexer.INT || type == ToYLexer.STRING ) && name == ToYLexer.IDENTIFIER){
            return true;
        }
        return false;
    }
    
    public boolean visit(Program add) {
    	return false;
    }
    
    public boolean visit(Keyword add) {
        int keyword = ((Yytoken)(add.getKeyword())).getToken();
        if( keyword == ToYLexer.VOID || keyword == ToYLexer.TRUE || keyword == ToYLexer.FALSE ){
            return true;
        }
    	return false;
    }

}

// A declaration of all the visitor methods for each AST subclass
interface Visitor {

    public boolean visit(Arithmetic symbol);

    public boolean visit(Logic symbol);

    public boolean visit(Conditions symbol);

    public boolean visit(UnaryOperators symbol);

    public boolean visit(Asnmt symbol);

    public boolean visit(Decl symbol);

    public boolean visit(EndFunction symbol);

    public boolean visit(ForLoop symbol);

    public boolean visit(IfStmt symbol);

    public boolean visit(StructCreator symbol);
    
    public boolean visit(VarDef vardef);

    public boolean visit(Type symbol);

    public boolean visit(FunctionConstruct symbol);

    public boolean visit(FunctionCall symbol);
    
    public boolean visit(ParamList paramList);
    
    public boolean visit(Program program);
    
    public boolean visit(Keyword keyword);

}


// Java code for the HashMaps ID TYPES -------------------------------------------------------------------------
class ID {
    Object name;
    Object scope;
    // String type;
    // String returnType;
    // ArrayList<String> parameterTypes;
    // ArrayList<String> fieldTypes;
    // int size;

    public ID(Object name) {
        this.name = name;
        // this.type = type;
        // this.returnType = returnType;
        // this.parameterTypes = parameterTypes;
        // this.fieldTypes = fieldTypes;
        // this.size = size;
    }
    public Object getName(){
       return this.name;
    }
    public Object getScope(Object Scope){
       return this.scope;
    }
    public void setScope(Object Scope){
       this.scope = scope;
    }
}

class Var extends ID {
    Object type;

    public Var(Object name, Object type) {
        super(name);
        this.type = type;

    }
}

class Function extends ID {
    Object returnType;
    StmtList parameterTypes;

    public Function(Object name, Object returnType, StmtList parameterTypes) {
        super(name);
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

}

class Struct extends ID {
    StmtList fieldTypes;
    //Object size; TOOK OUT SIZE

    public Struct(Object name, StmtList fieldTypes){ //Object size
        super(name);
        this.fieldTypes = fieldTypes;
        //this.size = size;
    }

}
   
 // symbol table class -------------------------------------------------------------------------
  class SymbolTable{
   
   int scope = 0; 
   HashMap<Object, ID> currentScope; 
   ArrayList<HashMap<Object, ID>> table;

   public SymbolTable() {
		table = new ArrayList<HashMap<Object, ID>>();
		table.add(new HashMap<Object, ID>());
	}

   public void addScope(){
      table.add(new HashMap<Object, ID>());
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

    // ADDED THIS IF IT DOESNT COMPILE
    /*
      @Override
      public int getToken() {
         return this.type;
      }
    */

      Yytoken token;

      @Override
      public int yylex () throws IOException{
         token = yylex.yylex();
         return token.type;
      }
    }
    
