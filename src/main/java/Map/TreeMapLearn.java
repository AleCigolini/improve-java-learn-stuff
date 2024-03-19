package Map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapLearn {

    public static void main(String[] args) {
        /*
        -- This class implements the MAP interface .
        -- The TreeMap guarantee the natural items order of theirs keys.
        -- Offers performance for the basic operations (get and put).
        */

        Map<String, Integer> map = new TreeMap<>();
        map.put("Ale", 1);
        map.put("Aless 4", 2);
        map.put("Aless 3", 3);

        System.out.println(map);

        map.put("Ale 2", 3);
        System.out.println(map);
    }
}
