package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLearn {

    public static void main(String[] args) {
        /*
        -- This class implements the MAP interface .
        -- The LinkedHashMap guarantee the items insertion order.
        -- Offers performance for the basic operations (get and put).
        */

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Ale");
        map.put(2, "Ale 2");
        map.put(3, "Ale 3");

        System.out.println(map);
    }
}
