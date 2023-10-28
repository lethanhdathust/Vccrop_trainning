package Exercise2_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashSetCollections {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
//        ------
        System.out.println("Add elements");
        set.add("a");
        set.add("b");
        set.add("c");
        set.add(null);
        //        -----
        System.out.println("Get total number of elements in a Set");
        System.out.println(set.size());
//        -----
        System.out.println("Iterating over a set");
        for(String a: set){
            System.out.println(a);
        }
//        ------
        System.out.println("Remove an element ");
        set.remove("a");
//        ----
        System.out.println("Check if a set is empty");
        System.out.println(set.isEmpty());
//        ----
        System.out.println("Remove all elements from a set");
        set.clear();

    }
}
