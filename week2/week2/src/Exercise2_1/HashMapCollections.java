package Exercise2_1;

import java.util.HashMap;
import java.util.Map;

public class HashMapCollections {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        map.put(4,"4");
        map.put(5,"5");
//  --------------------------
        System.out.println("get value from associate keys");
        System.out.println(map.get(1));
// ---------------------------
        System.out.println("Check if the map contains a specified key");
        System.out.println(map.containsKey(6));
//        ---------------------------
        System.out.println("Checking if the map contains a specified value");
        System.out.println(map.containsValue("3"));
//        ----------------------------
        System.out.println("Removing a mapping from the map");
        System.out.println(map.remove(2));
//------------------------------------
        System.out.println("Replace a object in map");
        System.out.println(map.replace(1,"!213"));
//        -------------------
        System.out.println("Getting the size of the map");
        System.out.println(map.size());
//        ---------------------------------
        System.out.println("Check if the map is empty");
        System.out.println(map.isEmpty());
//---------------------------
        System.out.println("Iterating Over a Map ");
        map.forEach((a,b) -> System.out.println("key" + a + " " + "value " + b));
    }
}
