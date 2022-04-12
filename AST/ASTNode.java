public class ASTNode {
    // Object accept(Visitor v, ID id); /* This may have to be type ID...not sure */
}

// 3 main classes for the nodes
// statement class
class ASTStmt extends ASTNode {

}

// subclasses of statement
class IfStmt extends ASTStmt {
    String testexp;
    String thenstmt;
    String elsestmt;

    public IfStmt(String testexp, String thenstmt, String elsestmt) {
        this.testexp = testexp;
        this.thenstmt = thenstmt;
        this.elsestmt = elsestmt;
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
