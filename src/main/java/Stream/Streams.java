package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* -- THE STREAM API PROVIDE AN IMPLEMENTATION WELL KNOWN "MAP-FILTER-REDUCE" ALGORTIHM
* -- STREAM HAS INTERMEDIATE AND TERMINAL OPERATIONS
*
* -- INTERMEDIATE:
*   --> IT DOES NOT RETURN VALUE IN THE END OF THE STREAM, JUST DO SOME ACTION UNDER YOUR DATA.
*   --> WE CAN CHAIN THE OPERATIONS.
*   --> EVERY TIME THAT WE CALL THIS OPERATION, IT CREATES A NEW STREAM
*
* -- TERMINAL:
*   --> IT CAN RETURN OR NOT SOME DATA.
*   --> IT IS RESPONSIBLE TO CALL THE PROCESS OF A STREAM.
*   --> IT CANNOT CHAIN THE OPERATIONS.
*
*
*
* */
public class Streams {

    public static void main(String[] args) {
        avoidingBoxingAndUnboxing();

        debbugingStreams();

        createEmptyStreams();
    }

    private static void createEmptyStreams() {
        // RETURN STREAM.EMPTY() IS THE BEST PRACTICE THAN RETURN NULL AS VALUE
        // BECAUSE ANOTHER STREAM METHODS CAN HANDLE AND IGNORE WHEN IS A EMPTY STREAM

        System.out.println("\\n Empty Streams \\n");

        System.out.println(Stream.empty());
    }

    private static void debbugingStreams() {
        System.out.println("\n Debbuging Streams \n");
        List<String> strings = List.of("one", "two", "three", "four");
        List<String> result =
                strings.stream()
                        .peek(s -> System.out.println("Starting with = " + s))
                        .filter(s -> s.startsWith("t"))
                        .peek(s -> System.out.println("Filtered = " + s))
                        .map(String::toUpperCase)
                        .peek(s -> System.out.println("Mapped = " + s))
                        .collect(Collectors.toList());
        System.out.println("result = " + result);
    }

    private static void avoidingBoxingAndUnboxing() {
        // TO HANDLE STREAM OF NUMBERS WE CAN USE IntStream, LongStream and DoubleStream
        // THEY USE PRIMITIVE TYPES FOR NUMBERS INSTEAD OF THE WRAPPER CLASS, AVOIDING BOXING AND UNBOXING

        // HOW THEY ARE HANDLING NUMBERS, SOME TERMINAL OPERATION EXISTS JUST FOR THEM, LIKE:
        // sum(), min(), max(), average(), summaryStatistics()

        System.out.println("\n Avoid boxing and unboxing \n");
        int[] ints = {1, 2, 3, 4, 5};
        IntStream intsStream = IntStream.of(ints);
        System.out.println(intsStream.summaryStatistics());
//        System.out.println(intsStream.max());
//        System.out.println(intsStream.average());
//        System.out.println(intsStream.min());
    }
}
