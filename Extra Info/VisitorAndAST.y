%language "Java"
%define api.prefix {ToY}
%define api.parser.class {ToY}
%define api.parser.public
%define parse.error verbose



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
%type declarationStmt
%type function
%type paramList
%type stmt
%type stmtSeq
%type Lexp
%type pgm
%type recursePgm
%type exp
%type op



%start pgm

%%
    
    type: INT /* { $$ = new Type(); } */
    | BOOL /* { $$ = new Type(); } */
    | STRING /* { $$ = new Type(); } */
    /*
    | IDENTIFIER
    */
    ;
    
    returnType: type { $$ = $1; }
    | VOID /* { $$ = new Type(); } */
    ;
    
    struct : STRUCT IDENTIFIER LBRACKET declaration RBRACKET { $$ = new StructCreator($2, $4); }
    ;
    
    declaration: type IDENTIFIER { $$ = new Decl($2); }
    ;
    
    declarationList: /*empty*/
    | declaration { $$ = $1; }
    | declaration COMMA declarationList
    ;
    
    function : returnType IDENTIFIER LEFTPAREN declarationList RIGHTPAREN LBRACKET stmt RBRACKET SEMICOLON { $$ = new FunctionConstruct($1, $3) }
    ;
    
    paramList: /* empty */
    | IDENTIFIER
    | IDENTIFIER COMMA paramList
    ;
    
    stmt : FOR LEFTPAREN exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN stmt SEMICOLON { ForLoop fl = new ForLoop($3, $5, $7, $9); nodeHash.put(fl); $$ = fl; }
    | IF LEFTPAREN exp RIGHTPAREN THEN stmt SEMICOLON{ $$ = new IfStmt($3, $6, null); }
    | IF LEFTPAREN exp RIGHTPAREN THEN stmt ELSE stmt SEMICOLON { $$ = new IfStmt($3, $6, $8); }
    | PRINTF LEFTPAREN STRING RIGHTPAREN SEMICOLON { $$ = new EndFunction($2); }
    | RETURN exp SEMICOLON { $$ = new EndFunction($2); }
    | LBRACKET stmtSeq RBRACKET { $$ = $1; }
    | declaration SEMICOLON { $$ = $1; } 
    | Lexp EQ exp SEMICOLON { $$ = new Asnmt($1, $3); }
    | IDENTIFIER paramList SEMICOLON { $$ = $1; } 
    | IDENTIFIER EQ IDENTIFIER paramList SEMICOLON { $$ = new Asnmt($1, $3); }  
    ;
    
    stmtSeq : /* empty sequence */
    | stmt stmtSeq
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
    
    exp : type { $$ = $1 }
    | TRUE /*{ $$ = $1; }*/
    | FALSE /*{ $$ = $1; }*/
    | exp PLUS exp { $$ = new Arithemtic($1, $3); }
    | exp MINUS exp { $$ = new Arithemtic($1, $3); }
    | exp MULT exp { $$ = new Arithemtic($1, $3); }
    | exp DIVIDE exp { $$ = new Arithemtic($1, $3); }
    | exp MOD exp { $$ = new Arithemtic($1, $3); }
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
    /*
    
  
  */
  
  /* might not need this */
 
 
%%
   // Java code for the HashMaps
// todo:
// 1. make a Visitor class (header would be: public interface Visitor extends ID) 
//   a. this is essentially the equivalent of a .h file
// 2. make the current Visitor class into an AbstractVisitorClass (header would be: public class AbstractVisitor implements Visitor)
// 3. add semantic actions

// 4.  add setName() in ID class

class ID extends ASTNode{
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
    
    public String getScope(){
        return this.scope;
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
    
    public String getType(){
        return type;
    }
    
    public void setType(String type) {
		    this.type = type;
	  }
    
    public ID accept(Visitor v, ID id) {
	      return v.visit(this, id);
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
    
    public ArrayList<String> getParamTypes(){
        return parameterTypes;
    }
    
    public void setParamTypes(ArrayList<String> parameterTypes) {
		    this.paramterTypes = parameterTypes;
	  }
    
    public ID accept(Visitor v, ID id) {
	      return v.visit(this, id);
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
    
    public ArrayList<String> getFieldTypes(){
        return fieldTypes;
    }
    
    public void setFieldTypes(ArrayList<String> fieldTypes) {
    	this.fieldTypes = fieldTypes;
	  }
    
    public ID accept(Visitor v, ID id) {
    	return v.visit(this, id);
    }

}

/* to ask Emma...can u help me link these (w/ the extend and implement keywords) */
public class ASTNode {
	Object accept(Visitor v, ID id);  /* This may have to be type ID...not sure */
}

public class AbstractVisitor implements Visitor{  

	public ID visit(Var var, ID id){
		/* var.getName().accept(this, id);
    		var.getScope().accept(this, id);
    		var.getType().accept(this, id); */
		return null;
	}
	
	public Object visit(Function func, ID id){
		func.getName().accept(this, id);
    		func.getScope().accept(this, id);
    		if (func.getParamTypes() != null){
        		for (String paramTyoes : Function.getParamTypes()) {
				paramTypes.accept(this, id);
		    	}
    		}
		return null;
	}
	
	public Object visit(Struct struct, ID id){
		/* struct.getName().accept(this, id);
    		struct.getScope.accept(this, id); */
    		struct.getFieldTypes().accept(this, id);
		return null;
	}
}

public interface Visitor extends ID {
	
	ID visit(Var var, ID id);
	
	ID visit(Function func, ID id);
	
	ID visit(Struct struct, ID id);
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
    

