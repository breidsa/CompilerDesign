public class ASTNode {
    // Object accept(Visitor v, ID id); /* This may have to be type ID...not sure */
}

// 3 main classes for the nodes
// statement class
class ASTStmt extends ASTNode {

}

class ForLoop extends ASTStmt {
    
    String iterator;
    String conditional;
    String increment;
    String loopBody;
    
    public ForLoop(String iterator, String conditional, String increment, String loopBody){
        this.iterator = iterator;
        this.conditional = conditional;
        this.increment = increment;
        this.loopBody = loopBody;
    
}

// subclasses of statement
class IfStmt extends ASTStmt {
    
    String ifStmt
    String thenStmt;
    String elseSTmt;

    public IfStmt(String ifStmt, String thenStmt, String elseStmt) {
        this.ifStmt = ifStmt;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

}

class Asnmt extends ASTStmt {
    String var;
    String exp;

    public Asnmt(String var, String exp) {
        this.var = var;
        this.exp = exp;
    }

}

class VarDec extends ASTStmt {
    String varType;
    String varName;

    public VarDec(String varType, String varName) {
        this.varType = varType;
        this.varName = varName;
    }

}

// expression class
class ASTExp extends ASTNode {

}

// typeclass
class ASTType extends ASTNode {

}
