
import java.util.HashMap;
import java.util.ArrayList;

public class PracScopes {

    // hashmap for functions maps from function/variable name to value
    HashMap<String, ArrayList<String>> functions = new HashMap<>();

    // hashmap for functions maps from fstruct name to list of definitions
    HashMap<String, ArrayList<String>> struct = new HashMap<>();

    // hashmap for functions maps from variable name to type string
    HashMap<String, String> vars = new HashMap<>();

    public void addEntry(HashMap<String, ArrayList<String>> map, String name,
            ArrayList<String> parameters) {
        map.put(name, parameters);
    }

    public void addEntry(HashMap<String, String> map, String name, String type) {
        map.put(name, type);
    }

    public ArrayList<String> getEntry(HashMap<String, ArrayList<String>> map,
            String name) {
        return map.get(name);
    }

    public String getVarEntry(HashMap<String, String> map, String name) {
        return map.get(name);
    }
}

/*
 * public class Scope {
 * 
 * private Hashtable<String,Integer> hash;
 * private int parseLevel;
 * 
 * public Scope(int parseLevel){
 * this.parseLevel = parseLevel;
 * map = new Hashtable<>();
 * }
 * 
 * public Scope(){
 * parseLevel = 0;
 * }
 * 
 * public void define(String name, Integer val){
 * map.put(name, val);
 * }
 * 
 * public boolean isMatching(String name){
 * return map.containsKey(name);
 * }
 * 
 * public Integer getVal(String name){
 * return map.get(name);
 * }
 * 
 * public int getParseLevel(){
 * return parseLevel;
 * }
 * }
 * 
 * 
 * 
 * public class SymbolTable {
 * enter_scope()
 * exit_scope()
 * 
 * }
 * 
 */

// scopes ----------------------------------
/*
 * class Scopes {
 * 
 * //hashmap for functions maps from function/variable name to value
 * HashMap<String, Function> functions = new HashMap<>();
 * 
 * //hashmap for functions maps from fstruct name to list of definitions
 * HashMap<String, Struct> struct = new HashMap<>();
 * 
 * //hashmap for functions maps from variable name to type string
 * HashMap<String, Var> vars = new HashMap<>();
 * 
 * public void addEntry(HashMap<String, Fucntion> map, String name, Function
 * addMe) {
 * map.put(name, addMe);
 * }
 * 
 * public void addEntry(HashMap<String, Struct> map, String name,
 * Struct addMe) {
 * map.put(name, addMe);
 * }
 * 
 * public void addEntry(HashMap<String, Var> map, String name, Var addMe) {
 * map.put(name, addMee);
 * }
 * 
 * public ArrayList<String> getEntry(HashMap<String, ArrayList<String>> map,
 * String name) {
 * return map.get(name);
 * }
 * 
 * public String getVarEntry(HashMap<String, String> map, String name) {
 * return map.get(name);
 * }
 * }
 * 
 * 
 * class Function {
 * String name;
 * String type;
 * ArrayList<String> parameters;
 * //contrustor
 * public Function(String name, String type, ArrayList<String> parameters){
 * this.name = name;
 * this.type = type;
 * this.parameters = parameters;
 * }
 * }
 * 
 * class Struct {
 * String name;
 * ArrayList<String> definitions;
 * 
 * //contrustor
 * public Struct(String name, ArrayList<String> definitions){
 * this.name = name;
 * this.definitions = definitions;
 * }
 * }
 * 
 * class Var {
 * String name;
 * String type;
 * String value;
 * 
 * //contrustor
 * public Var(String name, String type, String value){
 * this.name = name;
 * this.type = type;
 * this.value = value;
 * }
 * }
 * 
 */