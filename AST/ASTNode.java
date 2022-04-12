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

}

// expression class
class ASTExp extends ASTNode {

}

// typeclass
class ASTType extends ASTNode {

}
