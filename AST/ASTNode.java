public abstract class ASTNode {
    abstract Object accept(Visitor v); /* This may have to be type ID...not sure */
    // might need children nodes
}

// // 3 main classes for the nodes
// // statement class
// class ASTStmt extends ASTNode {

// }

// class Types extends ASTStmt{
    
// }

// For return types ... relevant to line 81 in .y
class EndFunction extends ASTNode{
    
    String exp;
    
    public EndFunction(String exp){
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
    
    public ForLoop(String iterator, String conditional, String increment, String loopBody){
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
    
    String ifStmt
    String thenStmt;
    String elseSTmt;

    public IfStmt(String ifStmt, String thenStmt, String elseStmt) {
        this.ifStmt = ifStmt;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }
    
    public Object accept(Visitor v) {
	      return v.visit(this);
    }

}

class Asnmt extends ASTStmt {
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

class VarDec extends ASTStmt {
    String varType;
    String varName;

    public VarDec(String varType, String varName) {
        this.varType = varType;
        this.varName = varName;
    }
    
    public Object accept(Visitor v) {
	      return v.visit(this);
    }

}
   
class StructCreator extends ASTStmt {
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

    
    
    

// expression class
class ASTExp extends ASTNode {

}

// typeclass
class ASTType extends ASTNode {

}
    
    
    
    
public class AbstractVisitor implements Visitor{  

	public Object visit(Var var){
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

public interface Visitor {
	
	public Object visit(Var var);
	
	public Object visit(Function func);
	
	public Object visit(Struct struct);
}
