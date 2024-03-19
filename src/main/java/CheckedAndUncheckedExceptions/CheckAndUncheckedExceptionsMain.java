package CheckedAndUncheckedExceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckAndUncheckedExceptionsMain {

    public static void main(String[] args) throws FileNotFoundException {

        /*
        * CHECKED EXCEPTIONS:
        *
        * -- WE HAVE TO DEAL THE EXCEPTION CODE WITHIN JAVA COMPILE TIME;
        * */
        readFile("fileOne.txt");
        readFileTwo("fileOne.txt");

        /*
         * UNCHECKED EXCEPTIONS:
         *
         * -- JAVA DOES NOT CHECK THE EXCEPTIONS AT COMPILER TIME, THE EXCEPTIONS
         * ARE RUNTIME EXCEPTIONS AND SO JUST SHOW WHEN GET AN ERROR AT EXECUTION TIME;
         * -- WE CAN DEAL THE UNCHECKED EXCEPTIONS WITH TRY/CATCH
         * */
        printLength(null);

    }

    /* USING TRY/CATCH WITH CHECKED EXCEPTIONS */
    private static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    /* USING METHOD SIGNATURE WITH CHECKED EXCEPTIONS */
    private static void readFileTwo(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
    }

    /* USING UNCHECKED EXCEPTIONS */
    private static void printLength(String name) {
        // HERE WILL THROW A NULLPOINTEREXCEPTION
        System.out.println(name.length());
    }
}
