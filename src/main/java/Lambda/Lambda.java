package Lambda;

import java.util.function.Predicate;

/*
* -- STARTED IN JAVA 8
* -- WE CAN JUST USE LAMBDA WITH FUNCTIONAL INTERFACES
* -- LAMBDA CANNOT MODIFY VARIABLES DEFINED OUTSIDE THEIR BODY
* */
public class Lambda {

    public static void main(String[] args) {
        waysToCreatePredicateByLambda();
    }

    private static void waysToCreatePredicateByLambda() {
        Predicate<String> predicate = (String s) -> {
            return s.length() == 3;
        };

        Predicate<String> predicateSimplified = s -> s.length() == 3;

        System.out.println(predicate.test("test"));
        System.out.println(predicateSimplified.test("test simple"));
    }
}
