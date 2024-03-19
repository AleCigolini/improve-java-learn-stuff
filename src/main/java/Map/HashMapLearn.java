package Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapLearn {

    public static void main(String[] args) {
        /*
        -- This class implements the MAP interface .
        -- The HashMap does not guarantee the items order.
        -- Offers performance for the basic operations (get and put).
        */

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Ale");
        map.put(2, "Ale 2");

        System.out.println(map);
    }
}
