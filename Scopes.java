import java.util.HashMap;
import java.util.ArrayList;

public class Scopes {

    // hashmap for functions maps from function/variable name to value
    HashMap<String, ArrayList<String>> functions = new HashMap<>();

    // hashmap for functions maps from fstruct name to list of definitions
    HashMap<String, ArrayList<String>> struct = new HashMap<>();

    // hashmap for functions maps from variable name to type string
    HashMap<String, String> vars = new HashMap<>();

    public void addEntry(HashMap<String, ArrayList<String>> map, String name, ArrayList<String> parameters) {
        map.put(name, parameters);
    }

    public void addEntry(HashMap<String, String> map, String name, String type) {
        map.put(name, type);
    }

    public ArrayList<String> getEntry(HashMap<String, ArrayList<String>> map, String name) {
        return map.get(name);
    }

    public String getVarEntry(HashMap<String, String> map, String name) {
        return map.get(name);
    }
}