package Set;

import java.util.HashSet;
import java.util.Set;

public class HashSetLearn {

    public static void main(String[] args) {
        /*
        -- This class implements the SET interface.
        -- This class does not accept duplicated items.
        -- The HashSet does not guarantee the iteration order.
        -- Offers performance for the basic operations (add, remove, contains and size).
        -- We can use the power of Streams with Sets
        */

        Set<String> stringSet = new HashSet<>();
        stringSet.add("test");
        stringSet.add("test2");
        stringSet.add("test3");

        System.out.println(stringSet);
    }
}
