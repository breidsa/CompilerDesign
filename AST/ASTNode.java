import java.util.*;

public abstract class ASTNode {
    abstract Object accept(Visitor v); /* This may have to be type ID...not sure */
    // might need children nodes
}

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

class UnaryOperators extends ASTNode {
    public ASTNode right;

    public UnaryOperators(ASTNode right) {
        this.right = right;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// For return types ... relevant to line 81 in .y
class EndFunction extends ASTNode {
    String exp;

    public EndFunction(String exp) {
        this.exp = exp;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class ForLoop extends ASTNode {

    String iterator;
    String conditional;
    String increment;
    String loopBody;

    public ForLoop(String iterator, String conditional, String increment, String loopBody) {
        this.iterator = iterator;
        this.conditional = conditional;
        this.increment = increment;
        this.loopBody = loopBody;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// subclasses of statement
class IfStmt extends ASTNode {

    String ifStmt;
    String thenStmt;
    String elseStmt;

    public IfStmt(String ifStmt, String thenStmt, String elseStmt) {
        this.ifStmt = ifStmt;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

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

class Decl extends ASTNode {
    String varName;
    String value;

    public Decl(String varName, String value) {
        this.varName = varName;
        this.value = value;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class StructCreator extends ASTNode {
    String name;
    ArrayList<String> fieldTypes;

    public StructCreator(String name, ArrayList<String> fieldTypes) {
        this.name = name;
        this.fieldTypes = fieldTypes;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// typeclass ----- ASK QUESTION ABOUT WHAT TO DO FOR JUST TYPES
class Type extends ASTNode {

    public Type() {
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

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

}

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

}
