
import java.util.*;



public class Scope {
    
     private Hashtable<String,Integer> hash;
     private int parseLevel;
     
     public Scope(int parseLevel){
        this.parseLevel = parseLevel;
        hash = new Hashtable<>();
     }
     
     public Scope(){
        parseLevel = 0;
     }

     public void define(String name, Integer val){
        hash.put(name, val);
     }

     public boolean isMatching(String name){
        return hash.containsKey(name);
     }

     public Integer getVal(String name){
        return  hash.get(name);
     }
    
     public int getParseLevel(){
        return parseLevel;
     }
    }

    
    
    public class SymbolTable {
    enter_scope()
    exit_scope()
    
    }

class symbolMethods {

    // private Stack<Scope> indexStructure;

    public static void main(String args[]) {

    }

    public void enterScope() {

    }

    public void exitScope() {

    }

    public void addSymbol() {

    }

    public void findSymbol() {

    }

    public void checkSymbol() {

    }

}
