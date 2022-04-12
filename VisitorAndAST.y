

public class ASTNode {
  Object accept(Visitor v, Object o);
}

public class Visitor {
  Object visit(____, Object o);
}


// function declaration node, struct declaration node, and a variable declaration node
