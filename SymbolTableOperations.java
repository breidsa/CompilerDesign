
import java.util.*;



public class Scope {
    
     private Hashtable<String,Integer> hash;
     private int parseLvl;
     
     public Scope(int parseLvl){
        this.parseLvl = parseLvl;
        hash = new Hashtable<>();
     }
     
     public Scope(){
        parseLlv = 0;
     }

     public void addSymbol(String name, Integer val){
        hash.put(name, val);
     }

     public boolean isMatching(String name){
        return hash.containsKey(name);
     }

     public Integer getVal(String name){
        return  hash.get(name);
     }
    
     public int getParseLvl(){
        return parseLvl;
     }
    }

    
   
    }

    class SymbolTable {

     private Stack<Scope> parseStructure;
        private int currentLvl;
        

        /*
    public static void main(String args[]) {

    }
*/
    public SymbolTable(){
       parseStructure = new Stack<>();
       currentLvl = -1;
    }
        
    public void enterScope() {
       currentLvl++;
       parseStructure.push(new Scope(currentLvl));

    }

    public void exitScope() {
       currentLvl--;
       parseStructure.pop();

    }

    public void addSymbol(String name, String val) {
       Scope currentScope = parseStructure.peek();
       currentScope.addSymbol(name, Integer.parseInt(val));
    }

    public void findSymbol(String name) {
        String result = "Error";
        
        if(parseStructure.isEmpty()){
           return result;
        }
        
        else{
            /* for all parseStructures pS in Scope */
           for(Scope pS:parseStructure){
               if((currentLvl > pS.getParseLvl()) && pS.isMatching(name)){
                   Integer val = pS.getParseVal(name);
                   result = val.toString();
               }
           }
       }
       return result;
    }

    public void checkSymbol(String fileName) {
        File file = new File(filename);
        try {
            Scanner in = new Scanner(file);
            
            while(in.hasNextLine()){
                String line = in.nextLine();
                String[] input = line.split(" ");
                
                if(input[0].equals("enterScope")){
                    enterScope();
                    System.out.println(line);
                }

                else if (input[0].equals("exitScope")){
                    endScope();
                    System.out.println(line);
                }
                
                else if (input[0].equals("addSymbol")){
                    String name = input[1];
                    String val = input[2];
                    addSymbol(name, val);
                    System.out.println(line);
                }
                
                else if(input[0].equals("use")){
                    String name = input[1];
                    System.out.println(line+" = " + findSymbol(name));
                }
                
                else{
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
