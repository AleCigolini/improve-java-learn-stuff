package Record;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.Base64;

public class RecordMain {

    public static void main(String[] args) {
        /*
        * RECORD CLASSES ARE IMMUTABLE;
        * OFFERS THE LOW CODE WRITE;
        * USEFUL WHEN WE HAVE TO AGGREGATE THE DATA, WITHOUT FIELDS VALUES MODIFICATION, BECAUSE THE FIELDS ARE FINAL;
        * THE COMPILER CREATE THE CONSTRUCTOR AND FIELDS ACCESSORS FOR US;
        * RECORD CLASSES ALREADY IMPLEMENT THE EQUALS, HASHCODE AND TOSTRING FOR EACH FIELD.
        * */
        RecordClass recordClass = new RecordClass("Ale", 23);

//        System.out.println(recordClass);
//        System.out.println(recordClass.name());

        Instant instant = Instant.now().plusSeconds(60);

        System.out.println(instant);

        String originalInput = "150;2023-11-01T14:34:00.342846200Z";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());

        System.out.println("Encode");
        System.out.println(encodedString);

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);

        System.out.println("Decode");
        System.out.println(decodedString);

        String s = decodedString.split(";")[1];

        System.out.println(Instant.now());

        System.out.println(Instant.now().isBefore(Instant.parse(s)));
    }
}
