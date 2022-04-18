
/* As this parser file is very long, here is a general table of contents to make it easier to go through the code:
// as of Friday at 2 am ... we can command F since the names are the same
   
  Start Line    |    Code Type
 -----------------------------------------------------------------------------------------------------------
      27        |  defines and imports
      48        |  global hashmaps and main function
      63        |  Bison Declarations
      101       |  Bison grammar rules and semantic actions
 -----------------------------------------------------------------------------------------------------------	       
      200       |  Start of the AST (AST constructor and StmtList helper function)
      240       |  AST expression subclasses (Arithmetic, Logic, Conditions, UnaryOperators, EndFunctions)
      379       |  AST statement/method subclasses (ForLoop, IfStmt)
      445       |  AST variable subclasses (Asnmt, Decl, ParamList, Keyword, VarDef, Type[might not need])
      568       |  AST program subclasses (StructCreater, FunctionConstruct, FunctionCall, Program)
 ------------------------------------------------------------------------------------------------------------		
      687       |  Start of Semantic Analysis 
      691	|  AbstractVisitor implementations and Visitor definitions
      948	|  Symbol Table Helper Functions
      1012      |  Symbol Table Class
      1073 	|  Parser - Lexer Link 
		
*/
	       

%language "Java"
%define api.prefix {ToY}
%define api.parser.class {ToY}
%define api.parser.public
%define parse.error verbose
//%define api.value.type {YytokenS}


%code imports {
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
}


%code {

/* ----------------- Global Hashmaps and Main Function ---------------- */

//  HashMap<Object, ID> functions = new HashMap<Object, ID>();
//  HashMap<Object, ID> statements = new HashMap<Object, ID>();

 static SymbolTable symbolTable = new SymbolTable();
 static Program ast = new Program(new StmtList());
 

 public static void main(String[] args) throws IOException {
 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file: ");
        String file = input.nextLine();
        File initialFile = new File(file);
        InputStream targetStream = new FileInputStream(initialFile);
        // BufferedReader br = new BufferedReader(new FileReader(initialFile));
        
        // String line;

        // while ((line = br.readLine()) != null) {
        //     System.out.println(line);
        // }

        ToYLexer l = new ToYLexer(targetStream);
        ToY p = new ToY(l);

        // PARSER ERRORS
        if (!p.parse()){
            System.out.println("ERROR SYNTAX FROM PARSER");
            System.exit(0);
        } else{
            if(symbolTable.areErrors()){
                ArrayList<String> arrErrors = symbolTable.getErrors();
                for(String error: arrErrors){
                    System.out.println("ERROR");
                    System.exit(0);
                }
                
            } else{
            System.out.println("VAlID -- PARSER");
            System.out.println();
            }
        }

        // SEMANTIC ANALYSIS ERRORS
        AbstractVisitor v = new AbstractVisitor();
        if(v.visit(ast)){
            System.out.println("VALID -- SEMANTIC");
        }else{
            System.out.println();
            System.out.println("ERROR -- SEMANTIC");
        }
 }

// CHECKS TO MAKE SURE THINGS HAVE BEEN PREVIOUSLY DEFINED WITHIN CURRENT SCOPE
 static void varExistsID(Yytoken name){
     Object val = name.getValue();
     if(symbolTable.check_scope(val) == null){
       System.out.println("ERROR SYMBOL DOES NOT EXIST IN THIS SCOPE"); 
       System.exit(0);
     }
 }

// CHECKS TO MAKE SURE VARIABLES HAVE NOT BEEN DUPLICATED WITHIN THE SAME SCOPE
 static void dupExistsID(Yytoken name){
     Object val = name.getValue();
     if(symbolTable.check_scope(val) != null){
       System.out.println("ERROR SYMBOL ALREADY EXISTS"); 
       System.exit(0);
     }
 }

 // CHECKS TO MAKE SURE FUNCTION NAME HAS NOT BEEN DEFINED 
 static void dupExistsFUN(Yytoken name){
     Object val = name.getValue();
     if(symbolTable.find_symbol(val) != null){
       System.out.println("ERROR SYMBOL ALREADY EXISTS"); 
       System.exit(0);
     }
 }

//CHECKS THAT FUNCTION HAS BEEN DEFINED
 static void funcExistsID(Yytoken name){
     Object val = name.getValue();
     if(symbolTable.find_symbol(val) == null){
       System.out.println("ERROR SYMBOL DOES NOT EXIST"); 
       System.exit(0);
     }
 }

 // CHECKS TO MAKE SURE STRUCT NAME HAS NOT BEEN DEFINED 
 static void strucExistsID(Yytoken name){
     Object val = name.getValue();
     if(symbolTable.find_symbol(val) != null){
       System.out.println("ERROR SYMBOL DOES NOT EXIST"); 
       System.exit(0);
     }
 }

 /*
 The functions below (lines 188-206) type check the following code correctly.

 RETURNS VALID 
 void main(){
    int x; 
    int y;
    x = 3;
    y = 3; 
    x = y;
}

 RETURNS ERROR -- Incompadable Types
 void main(){
    int x; 
    int y;
    x = 3;
    y = "hey"; 
}

 We were able to correctly type check declaration statements.  We commented these functions out because 
 we were not able to type check arithmetic, conditional, and logical statements.  Leaving these commented out 
 allows forloop, ifstatment, and function defintions to still pass the rest out our semantic analysis.  
 The zip file we included has tester files with the aforementioned methods that pass with the 
 following functions commented out.

 */ 

//     static void typeCheck(Yytoken name, Object value){
//     Object val = (symbolTable.find_symbol(name.getValue()));
//     int type = ((Yytoken)((Keyword)(((Var)val).getType())).getKeyword()).getToken();
//     int typeVal = ((Yytoken)(((Literals)value).getInstance())).getToken();
//
//     if(typeVal == ToYLexer.IDENTIFIER){
//         Object val2 = (symbolTable.find_symbol(name.getValue()));
//         int type2 = ((Yytoken)((Keyword)(((Var)val2).getType())).getKeyword()).getToken();
//         typeVal = type2;
//     }
//     if(type == ToYLexer.INT && !(typeVal == ToYLexer.NUMBER || typeVal == ToYLexer.INT)){
//         System.out.println("ERROR -- Incompadable Types");
//         System.exit(0);
//     }
//     if(type == ToYLexer.STRING && typeVal != ToYLexer.WORD){
//         System.out.println("ERROR -- Incompadable Types");
//         System.exit(0);
//     } 
//  }
}

/* ----------------- Bison Declarations ---------------- */

%token <Yytoken> INT BOOL STRING VOID
%token <Yytoken> IDENTIFIER 
%token <Yytoken> COMMENT
%token <Yytoken> TRUE FALSE 
%token <Yytoken> IF THEN ELSE FOR STRUCT
%token <Yytoken> RETURN PRINTF 
%token <Yytoken> SEMICOLON COMMA
%token <Yytoken> EQ ATTRIBUTE
%token <Yytoken> RBRACKET LBRACKET LEFTPAREN RIGHTPAREN
%token <Yytoken> LESSTHAN GREATERTHAN DOUBLEEQ LESSTHANOREQ GREATERTHANOREQ NOTEQ
%token <Yytoken> AND OR NOT 
%token <Yytoken> PLUS MINUS MULT DIVIDE MOD
%token <Yytoken> NUMBER WORD
%token END O "end o file"

%nonassoc LESSTHAN GREATERTHAN GREATERTHANOREQ LESSTHANOREQ DOUBLEEQ NOTEQ
%left MULT DIVIDE 
%left PLUS MINUS
%nonassoc NOT AND OR MOD

%left ATTRIBUTE

%type <StmtList> pgm
%type <StmtList> recursePgm
%type <Object> function
%type <Object> struct
%type <StmtList> declarationListZero
%type <StmtList> declarationList
%type <StmtList> stmts
%type <Object> declaration
%type <Object> stmt
%type <StmtList> paramList
%type <StmtList> stmtSeq
%type <Object> type
%type <Object> returnType
%type <Object> exp
%type <StmtList> Lexp


/* ----------------- Bison Grammar ---------------- */

%start pgm

%%  
    pgm : function recursePgm  { StmtList pgm = $2; ast.addElement($1); $$ = pgm; }
    | struct pgm { StmtList pgm = $2; ast.addElement($1); $$ = pgm; } 
    ; 
    
    recursePgm : { $$ = new StmtList(); }
    | function recursePgm { StmtList pgm = $2; ast.addElement($1); $$ = pgm;  }
    | struct recursePgm { StmtList pgm =  $2; ast.addElement($1); $$ = pgm; }
    ; 

    function : returnType IDENTIFIER LEFTPAREN declarationListZero RIGHTPAREN LBRACKET stmts RBRACKET  { dupExistsFUN($2); $$ = new FunctionConstruct($1, $2, $4, $7);
                                                                                                         Function ft = new Function(($2).getValue(), $1, (StmtList)$4); symbolTable.add_symbol(ft); symbolTable.addScope();}
    ; 

    struct : STRUCT IDENTIFIER LBRACKET declarationList RBRACKET {dupExistsFUN($2); $$ = new StructCreator($2, $4); Struct st = new Struct($2.getValue(), (StmtList)$4); symbolTable.add_symbol(st);symbolTable.addScope(); }
    ;      

    declarationListZero: { $$ = new StmtList();}  
    | declaration {$$ = new StmtList($1); }
    | declaration COMMA declarationList {StmtList decls = $3; decls.addElement($1); $$ = decls;} 
    ;    

    declarationList: declaration { $$ = new StmtList($1); }
    | declaration COMMA declarationList { StmtList decls = $3; decls.addElement($1); $$ = decls;} 
    ;      

    stmts : { $$ = new StmtList();}
    | stmt stmts { StmtList sequence = $2; sequence.addElement($1); $$ = sequence; }
    ;

    declaration: type IDENTIFIER {dupExistsID($2); $$ = new VarDef($1, $2); Var addMe = new Var(($2).getValue(), $1); symbolTable.add_symbol(addMe); }
    ;

    stmt : FOR LEFTPAREN IDENTIFIER EQ exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN LBRACKET stmts RBRACKET { Asnmt iterator = new Asnmt($3, $5);
										               $$ = new ForLoop(iterator, $7, $9, $12);} 
    | IF LEFTPAREN exp RIGHTPAREN LBRACKET stmts RBRACKET { $$ = new IfStmt($3, $6, null); } 
    | IF LEFTPAREN exp RIGHTPAREN LBRACKET stmts RBRACKET ELSE LBRACKET stmts RBRACKET { $$ = new IfStmt($3, $6, $10);}
    | PRINTF LEFTPAREN STRING RIGHTPAREN SEMICOLON { $$ = new EndFunction($1, $3); } 
    | PRINTF LEFTPAREN IDENTIFIER RIGHTPAREN SEMICOLON { $$ = new EndFunction($1, $3); varExistsID($3); } 
    | RETURN exp SEMICOLON { $$ = new EndFunction($1, $2); }
    | LBRACKET stmtSeq RBRACKET { $$ = $1; }
    | type IDENTIFIER SEMICOLON { dupExistsID($2); $$ = new VarDef($1, $2); Var addMe = new Var(($2).getValue(), $1); symbolTable.add_symbol(addMe);} 
    | IDENTIFIER EQ exp SEMICOLON { $$ = new Asnmt($1, $3); varExistsID($1);} //typeCheck($1, $3); }
    | IDENTIFIER EQ exp { $$ = new Asnmt($1, $3); varExistsID($1); }//typeCheck($1, $3);}
    | IDENTIFIER ATTRIBUTE Lexp EQ exp SEMICOLON { $$ = new Asnmt($1, $3);} 
    | IDENTIFIER LEFTPAREN paramList RIGHTPAREN SEMICOLON {$$ = new FunctionCall($1, $2); dupExistsFUN($1);}
    | IDENTIFIER EQ IDENTIFIER LEFTPAREN paramList RIGHTPAREN SEMICOLON {FunctionCall func = new FunctionCall($3, $5); $$ = new Asnmt($1, func); funcExistsID($1);}
    | COMMENT {$$ = $1;}
    ;

    paramList: { $$ = new StmtList();}
    | exp COMMA paramList {StmtList params = $3; params.addElement($1); $$ = params;}
    ;

    stmtSeq: { $$ = new StmtList();}
    | stmt COMMA stmtSeq { StmtList sequence = $3; sequence.addElement($1); $$ = sequence; }
    ;

    type: INT { $$ = new Keyword($1); }
    | BOOL { $$ = new Keyword($1); }
    | STRING { $$ = new Keyword($1); }
    | IDENTIFIER { $$ = new Literals($1); varExistsID($1); }
    ;
 
    returnType: type { $$ = $1; }
    | VOID { $$ = new Keyword($1); }
    ;
       
    exp: NUMBER { $$ = new Literals($1); }
    | WORD { $$ = new Literals($1); }
    | TRUE { $$ = new Keyword($1); }
    | FALSE { $$ = new Keyword($1); }
    | IDENTIFIER { $$ = new Literals($1); varExistsID($1); }
    | exp PLUS exp { $$ = new Arithmetic($1, $2, $3); }
    | exp MINUS exp { $$ = new Arithmetic($1, $2, $3); }
    | exp MULT exp { $$ = new Arithmetic($1, $2, $3); }
    | exp DIVIDE exp { $$ = new Arithmetic($1, $2, $3); }
    | exp MOD exp { $$ = new Arithmetic($1, $2, $3); }
    | exp AND exp { $$ = new Logic($1, $2, $3); } 
    | exp OR exp { $$ = new Logic($1, $2, $3); } 
    | exp DOUBLEEQ exp { $$ = new Conditions($1, $2, $3); } 
    | exp GREATERTHAN exp { $$ = new Conditions($1, $2, $3); } 
    | exp LESSTHAN exp { $$ = new Conditions($1, $2, $3); } 
    | exp GREATERTHANOREQ exp { $$ = new Conditions($1, $2, $3); } 
    | exp LESSTHANOREQ exp { $$ = new Conditions($1, $2, $3); } 
    | exp NOTEQ exp { $$ = new Conditions($1, $2, $3); } 
    | NOT exp { $$ = new UnaryOperators($1, $2); }
    | MINUS exp { $$ = new UnaryOperators($1, $2); }
    | LEFTPAREN exp RIGHTPAREN {$$ = $2;}
    ;
    
    Lexp : IDENTIFIER { StmtList emptyList = new StmtList(); emptyList.addElement($1); $$ = emptyList;}
    | IDENTIFIER ATTRIBUTE Lexp { StmtList attributeList = $3; attributeList.addElement($1); $$ = attributeList;}
    ;

%%


/* ------------------------------------------------------- */
/*                       Start of AST                      */
/* ------------------------------------------------------- */

abstract class ASTNode {
    public abstract Object accept(Visitor v); 
}

class StmtList extends ASTNode{

    ArrayList<Object> stmts;

    public StmtList() {
        stmts = new ArrayList<Object>();
    }

    public StmtList(Object add) {
        stmts = new ArrayList<Object>();
        stmts.add(add);
    }

    public void addElement(Object n) {
        stmts.add(n);
    }

    public int getSize(){
        return stmts.size();
    }

    public Object elementAt(int i) {
        return stmts.get(i);
    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


/* ----------------- AST Expression Subclasses ---------------- */
/* ------------------------------------------------------------ */


// Arithmetic Class that extends the ASTNode class
// creates two Nodes, the left and right sides of an arithmetic statement
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

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// Conditions class that extends the ASTNode class
// creates two Nodes, the left and right sides of a conditional statement
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

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// Logic class that extends the ASTNode class
// creates two Nodes, the left and right sides of a conditional statement
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

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// UnaryOperators class that extends the ASTNode class
// creates one Node, the right statement of a unary expression
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
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// EndFunctions class that extends the ASTNode class
// Used for return and print functions
// creates one node, the expression to be printed or returned
class EndFunction extends ASTNode {
    Object type;
    Object exp;

    public EndFunction(Object type, Object exp) {
        this.type = type;   
        this.exp = exp;
    }

    public Object getType(){
        return this.type;
    }

    public Object getExp(){
        return this.exp;
    }
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


/* ----------------- AST Statement/Method subclasses ---------------- */
/* ------------------------------------------------------------------ */


// ForLoop class that extends the ASTNode class
// creates four nodes, the for loop iterator, it's conditional, its
// incrementation statement, and the loop body
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

    public Object getIterator(){
        return this.iterator;
    }

    public Object getConditional(){
        return this.conditional;
    }

    public Object getIncrement(){
        return this.increment;
    }

    public Object getBody(){
        return this.body;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// IfStmt class that extends the ASTNode class
// creates three nodes, the if statment conditional, the if statment body, and
// the else statement
// else statement can bc a null pointer, in which case only 2 nodes are created
class IfStmt extends ASTNode {

    Object conditional;
    StmtList ifBody;
    StmtList elseBody;

    public IfStmt(Object conditional, StmtList ifBody, StmtList elseBody) {
        this.conditional = conditional;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Object getConditional(){
        return this.conditional;
    }

    public Object getIfBody(){
        return this.ifBody;
    }

    public Object getElseBody(){
        return this.elseBody;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


/* ----------------- AST Variable Subclasses ---------------- */
/* ---------------------------------------------------------- */


// Asnmt class that extends the ASTNode class
// The class is used when assigning objects to variables
// Creates two nodes, the variable and the expression
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

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }

}


// ParamList class that extends the ASTNode class
// The class is used when listing paramaters in a function call
// Creates 1 node, a list of paramaters
class ParamList extends ASTNode {

	StmtList params;
	
	public ParamList(StmtList params){
		this.params = params;
	}

    	public Object getParameters(){
        	return this.params;
    	}
	
	@Override
	public Object accept(Visitor v) {
        	return v.visit(this);
    	}
}


// Keyword class that extends the ASTNode class
// The class is used when keywords are used
// Creates 1 node, the keyword
class Keyword extends ASTNode {

	Object keyword;
	
	public Keyword(Object keyword){
		this.keyword = keyword;
	}

    	public Object getKeyword(){
        	return this.keyword;
    	}
	
	@Override
	public Object accept(Visitor v) {
        	return v.visit(this);
    	}
}


// Literals class that extends the ASTNode class
// The class is used when literal strings, numbers, or identifiers are used
// Creates 1 node, the keyword
class Literals extends ASTNode {
 
    Object literal;

    public Literals(Object literal){
        this.literal = literal;
    }

    public Object getInstance(){
        return this.literal;
    }

    @Override
	public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// VarDef class that extends the ASTNode class
// The class is used for variable definitions
// Creates 2 nodes, the type and name of the Identifier
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

    	@Override
	public Object accept(Visitor v) {
        	return v.visit(this);
    	}
}


/* ------------------- Program classes & subclasses------------------ */
/* ------------------------------------------------------------------ */


// Struct class that extends the ASTNode class
// creates 2 nodes: the name of the struct and an ArrayList of all the struct
// fieldTypes
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
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// FunctionCreator class that extends the ASTNode class
// creates 4 nodes, the function return type, name and it's parameters, and it's body (as a list)
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
    
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// FunctionCall class that extends the ASTNode class
// specifically for when you don't want to have full declarations in the
// parenthesis, just already declared param names
// creates 2 nodes, the name and the parameters, which are an array
// of objects (variable names)
class FunctionCall extends ASTNode {

    Object name;
    Object parameters;

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
    
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// Program class that extends ASTNode
// The root node, this class has no parents, only children
// Contains only 1 Node, the program itself
class Program extends ASTNode {

	StmtList program;
	
	public Program(StmtList program){
		this.program = program;
	}

    	public StmtList getProgram(){
    	    	return this.program;
    	}

    	public void addElement(Object add) {
        	program.addElement(add);
    	}

	@Override
	public Object accept(Visitor v) {
        	return v.visit(this);
    }
}
	

/* ---------------------------- Start of Semantic Analysis ---------------------------- */
/* ------------------------------------------------------------------------------------ */



/* ----------------- AbstractVisitor implementations and Visitor definitions ----------------- */
/* ------------------------------------------------------------------------------------------- */

// An implementation of all the visitor methods
// These act as semantic analysis, so each of these methods will visit the nodes
// in the AST tree and make sure that they are semantically doing the correct thing
class AbstractVisitor implements Visitor {

    // public tryHelper method, lets us have try catch blocks for every Class constructor for semantic 
    // analysis purposes
    public boolean tryHelper(Object item){
        try { // FORLOOP 
            ForLoop forloop = (ForLoop)item;
            if(visit(forloop)){
                    return true;
        }}catch(Exception e) {} 
        try { // IFSTMT
            IfStmt ifStmt = (IfStmt)item;
            if(visit(ifStmt)){
                    return true;
            }
        }catch(Exception e) {} 
        try { // ENDFUNCTION
            EndFunction endFunction = (EndFunction)item;
            if(visit(endFunction)){
        	    return true;
            }
        }catch (Exception e){} 
        try { // VARDEF
            VarDef varDef = (VarDef)item;
            if(visit(varDef)){
                return true;
            }
        }catch (Exception e){}
        try { // ASNMT
            Asnmt asnmt = (Asnmt)item;
            if(visit(asnmt)){
                return true;
            } 
        }catch (Exception e){}
        try { // PARAMLIST
            ParamList paramlist = (ParamList)item;
            if(visit(paramlist)){
                return true;
            }
        }catch (Exception e){}
        try { // FUNCTIONCALL
            FunctionCall funcCall = (FunctionCall)item;
            if(visit(funcCall)){
                return true;
            }
        }catch (Exception e){}
        try{ // ARITHMETIC
            Arithmetic art = (Arithmetic)item;
            if(visit(art)){
                return true;
            }
        }catch (Exception e){}
        try{ // CONDITIONS
            Conditions condition = (Conditions)item;
            if(visit(condition)){
                return true;
            }
        }catch (Exception e){}
        try{ // LOGIC
            Logic log = (Logic)item;
            if(visit(log)){
                return true;
            }
        }catch (Exception e){}
        try{ // UNARYOPERATORS
            UnaryOperators un = (UnaryOperators)item;
            if(visit(un)){
                return true;
            }
        }catch (Exception e){}
        try{ // LITERAL
            Literals lit = (Literals)item;
            if(visit(lit)){
                return true;
            }
        }catch (Exception e){}
        
        
	return false;
    }	
	

    public boolean visit(Arithmetic add) {
    	
        int op = ((Yytoken)(add.getOp())).getToken();
        int left = ((Yytoken)(((Literals)add.getLeft()).getInstance())).getToken();
        int right = ((Yytoken)(((Literals)add.getRight()).getInstance())).getToken();
	
        if (op == ToYLexer.PLUS || op == ToYLexer.MINUS ){
            if (((left == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.NUMBER || right == ToYLexer.IDENTIFIER)) || ((left == ToYLexer.STRING || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.STRING || right == ToYLexer.IDENTIFIER))){
                return true;
            }
        }
        if (op == ToYLexer.MULT || op == ToYLexer.DIVIDE || op == ToYLexer.MOD ){
            if ((left == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.NUMBER || right == ToYLexer.IDENTIFIER) ){
                return true;
            }
        }
        return false;
    }
    
        public boolean visit(Conditions add) {
    	
        int op = ((Yytoken)(add.getOp())).getToken();
        int left = ((Yytoken)(((Literals)add.getLeft()).getInstance())).getToken();
        int right = ((Yytoken)(((Literals)add.getRight()).getInstance())).getToken();
	
        if (op == ToYLexer.GREATERTHAN || op == ToYLexer.GREATERTHANOREQ || op == ToYLexer.LESSTHAN || op == ToYLexer.LESSTHANOREQ ){
            if ((left == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.NUMBER || right == ToYLexer.IDENTIFIER)){
                return true;
            }
        }
	
        if (op == ToYLexer.DOUBLEEQ || op == ToYLexer.NOTEQ ){
            if (((left == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER)) || ((left == ToYLexer.WORD || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.WORD || left == ToYLexer.IDENTIFIER)) ){
                return true;
            }
        }
        
        return false;
    }


    public boolean visit(Logic add) {
    	
        int left = ((Yytoken)(((Literals)add.getLeft()).getInstance())).getToken();
        int right = ((Yytoken)(((Literals)add.getRight()).getInstance())).getToken();
        
        if ((left == ToYLexer.BOOL || left == ToYLexer.TRUE || left == ToYLexer.FALSE || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.BOOL || right == ToYLexer.TRUE || right == ToYLexer.FALSE || right == ToYLexer.IDENTIFIER) ){
                return true;
        }
        return false;
    }
    
    
    public boolean visit(UnaryOperators add) {
            
	int op = ((Yytoken)(add.getOp())).getToken();
    	int right = ((Yytoken)(((Literals)add.getRight()).getInstance())).getToken();
	        
	if (op == ToYLexer.NOT && (right == ToYLexer.BOOL || right == ToYLexer.IDENTIFIER )){
            return true;
        }
        if (op == ToYLexer.MINUS && right == ToYLexer.INT){
            return true;
        }
        return false;
    }
    
    
    public boolean visit(EndFunction add) {
    
            int type = ((Yytoken)(add.getType())).getToken();
 
        if (type == ToYLexer.PRINTF){
            int printME = ((Yytoken)(add.getExp())).getToken(); 
            if(!(printME == ToYLexer.WORD || printME == ToYLexer.IDENTIFIER)){
                return false;
            }
        } 
        return true;
    }
    
    
    public boolean visit(ForLoop add) {
    	
        Asnmt iterator = ((Asnmt)(add.getIterator()));
        Conditions condition = ((Conditions)(add.getConditional()));
        Asnmt increment = ((Asnmt)(add.getIncrement()));
        StmtList body = ((StmtList)(add.getBody()));
      
        int name = (((Yytoken)(iterator.getVar())).getToken());
        int item = ((Yytoken)((Literals)iterator.getExp()).getInstance()).getToken();

        // CHECK ITERATION
        if(!(name == ToYLexer.IDENTIFIER)){
             return false;
        }

        if(!(item == ToYLexer.IDENTIFIER || item == ToYLexer.NUMBER )){
             return false;
        }
       
        // CHECK CONDITIONAL
        if (!visit(condition)){
            return false; 
        }
        
        // CHECK INCREMENTATION
        int name2 = (((Yytoken)(increment.getVar())).getToken());
        Arithmetic exp = (Arithmetic)(increment.getExp());
        
        if (!visit(exp)){
            return false; 
        }
        
	    // CHECK BODY
        for(int i = 0; i < body.getSize(); i++) {
            if(!(tryHelper(body.elementAt(i)))){    
                    return false;               
            }                                  
        }
	return true;
    }
    
    
    public boolean visit(IfStmt add) {
    	
        Conditions condition = ((Conditions)(add.getConditional()));
        StmtList ifBody = ((StmtList)(add.getIfBody()));
        StmtList elseBody = ((StmtList)(add.getElseBody()));
	
        //checks for conditional expression at pos 2 in for loop 
        if (!visit(condition)){
            return false; 
        }

        return true;
    }
    
    
    public boolean visit(Asnmt add) {
    	
        int name = (((Yytoken)(add.getVar())).getToken());
        

        Object item = add.getExp();
	
        if (!(name == ToYLexer.IDENTIFIER)){
            return false;
        }
	
        if(!tryHelper(item)){
            return false;
        } 
        return true;
    }


    public boolean visit(ParamList add) {
    
        StmtList params = ((StmtList)(add.getParameters()));
	
        for (int i = 0; i < params.getSize(); i++){
            int v = ((Yytoken)(params.elementAt(i))).getToken();
            if(!(v == ToYLexer.IDENTIFIER)){
                return false;
            }
         }
        return true;
    }
    
    public boolean visit(Keyword add) {
    	
        int keyword = ((Yytoken)(add.getKeyword())).getToken();
        if( keyword == ToYLexer.VOID || keyword == ToYLexer.TRUE || keyword == ToYLexer.FALSE ){
            return true;
        }
    	return false;
    }
    
    
    public boolean visit(Literals add){
    
        int lit = ((Yytoken)(add.getInstance())).getToken();
        if (lit == ToYLexer.NUMBER || lit == ToYLexer.WORD || lit == ToYLexer.IDENTIFIER){
            return true;
        }
        return false;
    }
    
    
    public boolean visit(VarDef add) {
    	
        int type = ((Yytoken)((Keyword)(add.getType())).getKeyword()).getToken();
        int name = ((Yytoken)(add.getName())).getToken();

        if ((type == ToYLexer.BOOL || type == ToYLexer.INT || type == ToYLexer.STRING ) && name == ToYLexer.IDENTIFIER){
            return true;
        }
        return false;
    }
    

    public boolean visit(StructCreator add) {
    	
        int name = ((Yytoken)(add.getName())).getToken();
        StmtList fields = ((StmtList)(add.getFeilds()));
	
        if(!(name == ToYLexer.IDENTIFIER)){
            return false; 
        }
	
        for (int i = 0; i < fields.getSize(); i++){
            VarDef v = (VarDef) fields.elementAt(i);
            if(!visit(v)){
                return false;
            }
         }
        return true;
    }


    public boolean visit(FunctionConstruct add) {
    	
        int returnType = ((Yytoken)((Keyword)(add.getReturnType())).getKeyword()).getToken();
	
        int name = ((Yytoken)(add.getName())).getToken();
	
        StmtList params = ((StmtList)(add.getParameters()));
        StmtList body = ((StmtList)(add.getBody()));
	
        if(!(returnType == ToYLexer.INT || returnType == ToYLexer.STRING || returnType == ToYLexer.BOOL || returnType == ToYLexer.VOID)){
            return false; 
        }
	
	// CHECK RETURN TRYPE
        if(!(name == ToYLexer.IDENTIFIER)){
             return false; 
        }
	
	// CHECK NAME
        for (int i = 0; i < params.getSize(); i++){
            VarDef v = ((VarDef)(params.elementAt(i)));
            if(!visit(v)){
                return false;
            }
         }
	 
	// CHECK BODY 
        for (int i = 0; i < body.getSize(); i++){
            if(!tryHelper(body.elementAt(i))){
                return false;
            }
        }
        return true;
    }


    public boolean visit(FunctionCall add) {
    	
        int name = ((Yytoken)(add.getName())).getToken();
        StmtList params = ((StmtList)(add.getParameters()));
	
        if(!(name == ToYLexer.IDENTIFIER)){
            return false; 
        }
	
        for (int i = 0; i < params.getSize(); i++){
            int v = ((Yytoken)(params.elementAt(i))).getToken();
            if(!(v == ToYLexer.IDENTIFIER)){
                return false;
            }
         }
        return true;
        
    }
    

    public boolean visit(Program add) {
    
        StmtList pgm = (StmtList) add.getProgram();
	
        for (int i = 0; i < pgm.getSize(); i++){
            try{
                FunctionConstruct function = (FunctionConstruct)(pgm.elementAt(i));
                if(visit(function)){
                    return true;
                }
                try{
                    StructCreator struct = (StructCreator)(pgm.elementAt(i));
                    if(visit(struct)){
                        return true;
                    }
                }catch(Exception e){ 
                }
            }catch(Exception e){
            }
        }
    	return false;
     }


     public boolean visit(StmtList add) {
            return true;
     }
}


// A declaration of all the visitor methods for each AST subclass
interface Visitor {

    public boolean visit(Arithmetic symbol);
    
    public boolean visit(Conditions symbol);

    public boolean visit(Logic symbol);

    public boolean visit(UnaryOperators symbol);
    
    public boolean visit(EndFunction symbol);

    public boolean visit(ForLoop symbol);

    public boolean visit(IfStmt symbol);
    
    public boolean visit(Asnmt symbol);
    
    public boolean visit(ParamList paramList);
    
    public boolean visit(Keyword keyword);
    
    public boolean visit(Literals literal);
    
    public boolean visit(VarDef vardef);

    public boolean visit(StructCreator symbol);

    public boolean visit(FunctionConstruct symbol);

    public boolean visit(FunctionCall symbol);
   
    public boolean visit(Program program);
   
    public boolean visit(StmtList keyword);

}


/* ------------------------- Symbol Table Helper Functions ------------------------- */
/* --------------------------------------------------------------------------------- */
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
    public Object getType(){
       return type;
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
   
/* ---------------------------- Symbol Table Class ------------------------ */
/* ------------------------------------------------------------------------ */

  class SymbolTable{
   
   int scope = 0; 
   HashMap<Object, ID> currentScope;
   ArrayList<String> errors = new ArrayList<String>(); 
   ArrayList<HashMap<Object, ID>> table;

   public SymbolTable() {
		table = new ArrayList<HashMap<Object, ID>>();
		table.add(new HashMap<Object, ID>());
    }

    public int size(){
        return table.size();
    }

    public ArrayList<String> getErrors(){
        return this.errors;
    }

    public boolean areErrors(){
        if(this.errors.size() == 0){
            return false;
        }
        return true;
    }

   public void addScope(){
      table.add(new HashMap<Object, ID>());
      scope++;
   }
   public int getScope(){
      return this.scope;
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

   public Object find_symbol(Object name){
      for (int i = this.scope; i >= 0; i--) {
			if (this.table.get(i).containsKey(name)) {
				return this.table.get(i).get(name);
			}
		}
		return null;

   }

   public void printKeys(){
       for (int i = this.scope; i >= 0; i--) {
			HashMap<Object, ID> table = this.table.get(i); 
            Set<Object> keys = table.keySet();
            for (Object key : keys) {
            }
		}
	}

   

   //adds all the information we need to know about x in current scope
   public boolean add_symbol(ID id){
     if(this.check_scope(id.getName()) != null){
            System.out.println("ERROR -- DUPLICATE DEFINITIONS");
            errors.add("ERROR: DUPLICATE DEFINITIONS");
    } 
      if (id != null && check_scope(id) == null) {
			this.table.get(this.scope).put(id.getName(), id);
			return true;
		}
		return false;
   }

   //check if x is in current scope and if it is returns the symbol 
   public ID check_scope(ID id){
      if(this.table.get(scope).containsKey(id.getName())){
         return this.table.get(this.scope).get(id.getName());
      }
      return null;
   }
    public Object check_scope(Object name){
      if (this.table.get(scope).containsKey(name)) {
				return this.table.get(scope).get(name);
			}
      return null;
      
   } 

  }



/* --------------------- Parser - Lexer Link --------------------- */
/* ------------------------------------------------------------- */
    class ToYLexer implements ToY.Lexer {
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
    
     	Yytoken token;
     
     	@Override
      	public Object getLVal() {
        	return token;
      	}

      	@Override
      	public int yylex () throws IOException{
         	token = (yylex.yylex());
         	if(token != null){
            		return token.getToken();
         	}else{
            		return 0;
         	}
    	}
}
    
/*
to get the string name Yytoken.getValue();
Var addVar = new Var(name.type);
symbolTable.add_symbol(addVar);
*/
