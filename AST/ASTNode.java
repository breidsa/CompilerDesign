import java.util.*;

// ~~~~~~ idea: what if we made a variable class and made all names and stuff of type Var ~~~~~~~ 

// Asbstract syntax tree base class.  
// methods: accept
//          accept method will call the Visitor class, will accept a node if deemed "correct" by semantic analysis 
//          this method will be applied in all subclasses that create nodes
public abstract class ASTNode {
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
    public ASTNode left, right;

    public Arithmetic(ASTNode left, ASTNode right) {
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
    public ASTNode left, right;

    public Conditions(ASTNode left, ASTNode right) {
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
    public ASTNode right;

    public UnaryOperators(ASTNode right) {
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
    String exp;

    public EndFunction(String exp) {
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

    String iterator;
    String conditional;
    String increment;
    StmtList body;

    public ForLoop(String iterator, String conditional, String increment, StmtList body) {
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

    String conditional;
    StmtList body;
    String elseStmt;

    public IfStmt(String conditional, StmtList body, String elseStmt) {
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
    String var;
    String exp;

    public Asnmt(String var, String exp) {
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
    String name;
    StmtList fieldTypes;

    public StructCreator(String name, StmtList fieldTypes) {
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
    String returnType;
    String name;
    ArrayList<String> parameters;
    StmtList body;

    public FunctionConstuct(String returnType, String name, ArrayList<String> parameters, StmtList body) {
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
    String name;
    ArrayList<String> parameters;
    // ASK ABOUT BODY

    public FunctionCall(String name, ArrayList<String> parameters) {
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
