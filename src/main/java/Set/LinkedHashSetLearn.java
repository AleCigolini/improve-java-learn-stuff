package Set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetLearn {

    public static void main(String[] args) {
        /*
        -- This class implements the SET interface and extends HashSet.
        -- This class does not accept duplicated items.
        -- The LinkedHashSet guarantee the insertion order.
        -- Offers performance for the basic operations (add, contains and remove).
        -- The LinkedHashSet iteration has more performance than the HashSet because the items have an order.
        -- We can use the power of Streams with Sets
        */

        Set<String> stringSet = new LinkedHashSet<>();
        stringSet.add("test");
        stringSet.add("test2");
        stringSet.add("test3");

        stringSet.remove("test");
        stringSet.add("test");

        System.out.println(stringSet);
    }
}
