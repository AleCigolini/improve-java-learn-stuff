package Set;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetLearn {

    public static void main(String[] args) {
        /*
        -- This class implements the SET interface .
        -- This class does not accept duplicated items.
        -- The TreeSet guarantee the natural order of each element.
        -- Offers performance for the basic operations (add, contains and remove).
        -- This class uses the equals and compareTo methods to verify if an item is equal to another.
        -- We can use the power of Streams with Sets
        */

        Set<String> stringSet = new TreeSet<>();
        stringSet.add("ale");
        stringSet.add("carro");
        stringSet.add("bola");

        System.out.println(stringSet);
    }
}
