package DateTimeAPI;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/*
* -- THE API USE THE GREGORIAN CALENDAR SYSTEM DEFINED IN ISO-8601
* -- CORE CLASSES OF THE API ARE LocalDateTime, ZonedDateTime, OffsetDateTime
* -- PRIMARY PACKAGE:
*   --> java.time
* -- SUBPACKAGES:
*   --> java.time.chrono
*   --> java.time.format
*   --> java.time.temporal
*   --> java.time.zone
*
* -- FOUR CLASSES DEAL EXCLUSIVELY WITH DATE INFORMATION, NO TIME, NO TIME ZONE:
*   --> LocalDate
*   --> YearMonth
*   --> MonthDay
*   --> Year
*
*  -- THE TIME ZONE IS USUALLY DESCRIBED BY AND IDENTIFIER WITH THE FORMAT region/city (Brazil/America_Sao_Paulo)
*  -- INCLUDES THE OFFSET FROM GREENWICH/UTC TIME, FOR EXAMPLE -03:00
*
*  -- CLASSES TO WORK WITH TIME ZONE:
*   --> ZonedDateTime
*   --> OffsetDateTime
*   --> OffsetTime
*
*  -- DateTimeFormatter class HAS NUMEROUS PREDEFINED FORMATTERS, OR YOU CAN DEFINE YOUR OWN
*   --> THIS CLASS IS IMMUTABLE AND THREAD-SAFE
* */
public class DateTimeAPI {

    public static void main(String[] args) {
        enumsDayOfWeek();
        enumsMonth();

        System.out.print("\n");
        localDateClass();
        yearMonthClass();
        monthDayClass();
        yearClass();

        localTimeClass();
        localDateTimeClass();

        System.out.print("\n");
        zoneIdClass();
        zoneOffsetClass();

        System.out.print("\n");
        zoneDateTimeClass();
        offsetDateTimeClass();
        offsetTimeClass();

        System.out.print("\n");
        instantClass();

        System.out.print("\n");
        parseADate();
        formatADate();

        System.out.print("\n");
        temporalPackage();

        System.out.print("\n");
        durationClass();
        periodClass();
    }

    private static void periodClass() {
        // A PERIOD USES DATE-BASED VALUES (YEARS, MONTHS, DAYS).
        // PROVIDES VARIOUS GET METHODS, SUCH AS getMonths(), getDays(), AND getYears(), SO THAT YOU CAN EXTRACT THE AMOUNT OF TIME FROM THE PERIOD.

        // FOLLOWING CODE REPRESENTS HOW OLD YOU ARE, ASSUMING THAT YOU WERE BORN IN ON APRIL 20, 2000
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2000, Month.APRIL, 20);

        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() +
                " days old. (" + p2 + " days total)");
    }

    private static void durationClass() {
        // IT MEASURES AN AMOUNT OF TIME USING TIME-BASED VALUES (SECONDS, NANOSECONDS)
        // A DURATION IS MOST SUITABLE IN SITUATIONS THAT MEASURE MACHINE-BASED TIME
        // A DURATION IS NOT CONNECTED TO THE TIMELINE, IN THAT IT DOES NOT TRACK TIME ZONES OR DAYLIGHT SAVING TIME.
    }

    private static void temporalPackage() {
        // PROVIDE COLLECTION OF INTERFACES, CLASSES AND ENUMS THAT SUPPORT DATE AND TIME CODE
        // THESE INTERFACES ARE INTENDED TO BE USED AT THE LOWEST LEVEL.
        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/temporal/package-summary.html
    }

    private static void formatADate() {
        // TEMPORAL-BASED CLASSES PROVIDE format() METHOD TO FORMAT String THAT CONTAIN DATE AND TIME INFO
        // NORMALLY WE PROVIDE A PATTERN TO DateTimeFormatter OBJECT, THEN WE USE IT TO PASS IN THE format() METHOD
        // THROW AN EXCEPTION WHEN OCCURS SOME PROBLEM TO PARSE. SO WE CAN CATCH THE EXCEPTION DateTimeException

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

        // Leaving from San Francisco on July 20, 2013, at 7:30 p.m.
        LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        try {
            String out1 = departure.format(format);
            System.out.printf("LEAVING:  %s (%s)%n", out1, leavingZone);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", departure);
            throw exc;
        }

        // Flight is 10 hours and 50 minutes, or 650 minutes
        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone)
                .plusMinutes(650);

        try {
            String out2 = arrival.format(format);
            System.out.printf("ARRIVING: %s (%s)%n", out2, arrivingZone);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", arrival);
            throw exc;
        }

        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant()))
            System.out.printf("  (%s daylight saving time will be in effect.)%n",
                    arrivingZone);
        else
            System.out.printf("  (%s standard time will be in effect.)%n",
                    arrivingZone);

    }

    private static void parseADate() {
        // TEMPORAL-BASED CLASSES PROVIDE parse() METHOD TO PARSE String THAT CONTAIN DATE AND TIME INFO
        // NORMALLY WE PROVIDE A PATTERN TO DateTimeFormatter OBJECT, THEN WE USE IT TO PASS IN THE parse() METHOD
        // THROW AN EXCEPTION WHEN OCCURS SOME PROBLEM TO PARSE. SO WE CAN CATCH THE EXCEPTION DateTimeParseException

        // THE DEFAULT PARSE FORMATTER IS ISO_LOCAL_DATE. WE CAN CHOOSE ANOTHER LIKE THIS:
        /* LocalDate date = LocalDate.parse(string_input, DateTimeFormatter.BASIC_ISO_DATE); */
    }

    private static void instantClass() {
        // ONE OF THE CORE CLASSES OF THE DATE-TIME API
        // IT IS USEFUL FOR GENERATING A TIME STAMP TO REPRESENT MACHINE TIME
        // A VALUE RETURNED FROM THE INSTANT CLASS COUNTS TIME BEGINNING FROM THE FIRST SECOND OF JANUARY 1, 1970 (1970-01-01T00:00:00Z) ALSO CALLED THE EPOCH.
        // AN INSTANT THAT OCCURS BEFORE THE EPOCH HAS A NEGATIVE VALUE, AND AN INSTANT THAT OCCURS AFTER THE EPOCH HAS A POSITIVE VALUE.

        System.out.println(Instant.MIN);
        System.out.println(Instant.MAX);
        System.out.println(Instant.now());

    }

    private static void offsetTimeClass() {
        // USED TO REPRESENT A TIME WITH AN OFFSET FROM GREENWICH/UTC TIME
        // THE CLASS COMBINES LocalTime with ZoneOffset class
        // IT IS USED IN THE SAME CONTEXT OF OffsetDateTime BUT WHEN WE JUST NEED THE TIME

        LocalTime localTime = LocalTime.of(10, 50);
        OffsetTime offsetTime = OffsetTime.of(localTime, ZoneOffset.of("-03:00"));
        System.out.println("OffsetTime: " + offsetTime);
    }

    private static void offsetDateTimeClass() {
        // USED TO REPRESENT A FULL DATE WITH AN OFFSET FROM GREENWICH/UTC TIME
        // THE CLASS COMBINES LocalDateTime with ZoneOffset class

        // Find the last Thursday in July 2013.
        LocalDateTime localDateTime = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        ZoneOffset offset = ZoneOffset.of("-08:00");

        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, offset);
        OffsetDateTime lastThursday =
                offsetDateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        System.out.printf("The last Thursday in July 2013 is the %sth.%n",
                lastThursday.getDayOfMonth());

    }

    private static void zoneDateTimeClass() {
        // USED TO REPRESENT A FULL DATE WITH A TIME ZONE
        // THE CLASS COMBINES LocalDateTime with ZoneId class


        // THE CODE BELOW SHOWS HOW TO USE ZoneDateTime AND HOW IT WORKS WITH DIFFERENT TIME ZONES DURING A
        // FLIGHT FROM SAN FRANCISCO TO TOKYO
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

        // Leaving from San Francisco on July 20, 2013, at 7:30 p.m.
        LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        try {
            String out1 = departure.format(format);
            System.out.printf("LEAVING:  %s (%s)%n", out1, leavingZone);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", departure);
            throw exc;
        }

        // Flight is 10 hours and 50 minutes, or 650 minutes
        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone)
                .plusMinutes(650);

        try {
            String out2 = arrival.format(format);
            System.out.printf("ARRIVING: %s (%s)%n", out2, arrivingZone);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", arrival);
            throw exc;
        }

        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant())){
            System.out.printf("  (%s daylight saving time will be in effect.)%n",
                    arrivingZone);
        } else{
            System.out.printf("  (%s standard time will be in effect.)%n",
                    arrivingZone);
        }

    }

    private static void zoneOffsetClass() {
        // SPECIFIES A TIME ZONE OFFSET FROM GREENWICH/UTC TIME
    }

    private static void zoneIdClass() {
        // SPECIFIES A TIME ZONE IDENTIFIER AND PROVIDES RULES FOR CONVERTING BETWEEN AN INSTANT AND A LOCALDATETIME
    }

    private static void localDateTimeClass() {
        // THE CLASS HANDLES DATE AND TIME WITH NO TIME ZONE
        // USED TO REPRESENT DATE (YEAR-MONTH-DAY) WITH TIME (HOUR-MINUTE-SECOND-NANOSECOND)
        // IT IS A COMBINATION OF LocalDate AND LocalTime

        // SOME METHODS AND WAYS TO USE LOCALDATETIME
        System.out.printf("now: %s%n", LocalDateTime.now());

        System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
                LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

        System.out.printf("now (from Instant): %s%n",
                LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.printf("6 months from now: %s%n",
                LocalDateTime.now().plusMonths(6));

        System.out.printf("6 months ago: %s%n",
                LocalDateTime.now().minusMonths(6));

    }

    private static void localTimeClass() {
        // USEFUL CLASS TO DEAL WITH HUMAN-BASED TIME OF DAY
        // THE CLASS DOES NOT STORE TIME ZONE OR DAYLIGHT SAVING TIME INFORMATION

        // CREATING A DIGITAL CLOCK
        LocalTime thisSec;

        for (;;) { // INFINITE LOOP
            thisSec = LocalTime.now();

            // implementation of display code is left to the reader
//            display(thisSec.getHour(), thisSec.getMinute(), thisSec.getSecond());
            break;
        }

    }

    private static void yearClass() {
        // REPRESENTS A YEAR

        // GET IF THE YEAR IS A LEAP YEAR
        boolean validLeapYear = Year.of(2012).isLeap();
        System.out.println("Is it a leap year too? " + validLeapYear);
    }

    private static void monthDayClass() {
        // REPRESENTS THE DAY OF A PARTICULAR MONTH

        // GET IF IT'S A VALID YEAR BY MONTH AND DAY, USED TO CHECK FOR LEAP YEARS
        MonthDay date = MonthDay.of(Month.FEBRUARY, 29);
        boolean validLeapYear = date.isValidYear(2010);
        // IT WILL RETURN FALSE BECAUSE 2010 IS NOT A LEAP YEAR
        System.out.println("Is it a leap year? " + validLeapYear);
    }

    private static void yearMonthClass() {
        // REPRESENTS THE MONTH OF A SPECIFIC YEAR

        // VERIFY THE NUMBER OF DAYS IN A SPECIFIC YEAR AND MONTH
        YearMonth date = YearMonth.now();
        System.out.printf("%s: %d%n", date, date.lengthOfMonth());

        YearMonth date2 = YearMonth.of(2010, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

        YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());
    }

    private static void localDateClass() {
        // REPRESENTS A YEAR-MONTH-DAY IN THE ISO CALENDAR.

        // CREATING AN INSTANCE OF LOCALDATE
        LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
        LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println(nextWed);

        // GET THE DAY OF WEEK IN SOME DATE
        DayOfWeek dotw = LocalDate.of(2012, Month.JULY, 9).getDayOfWeek();
        System.out.println("Day of week by local date: " + dotw);

        // GET THE FIRST WEDNESDAY AFTER SPECIFIC DATE
        LocalDate dateTwo = LocalDate.of(2000, Month.NOVEMBER, 20);
        TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);
        LocalDate nextWedTwo = dateTwo.with(adj);
        System.out.printf("For the dateTwo of %s, the next Wednesday is %s.%n", dateTwo, nextWedTwo);
    }

    private static void enumsMonth() {
        // INCLUDE CONSTANTS FOR TWELVE MONTHS, JANUARY TO DECEMBER
        // THE INTEGERS VALUES ARE 1 (JANUARY) TO 12 (DECEMBER)

        // WE CAN USE A METHOD TO KNOW HOW IS THE MAXIMUM POSSIBLE NUMBER OF DAYS IN SOME MONTH
        System.out.printf("%d%n", Month.FEBRUARY.maxLength());

        // WE CAN RETURN THE MONTH WITH DIFFERENT STYLES BASED ON USER'S LOCALE
        Month month = Month.AUGUST;
        Locale locale = Locale.getDefault();
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));
        System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(month.getDisplayName(TextStyle.SHORT, locale));

    }

    private static void enumsDayOfWeek() {
        // THE DayOfWeek ENUM CONSIST OF SEVEN CONSTANTS FROM MONDAY TO SUNDAY
        // THE INTEGER VALUES ARE A RANGE FROM 1 (MONDAY) TO 7 (SUNDAY)

        // WE CAN USE THE TEMPORAL-BASED METHODS WITH THE ENUM ABOVE
        System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));

        // WE CAN RETURN THE DAY OF WEEK WITH DIFFERENT STYLES BASED ON USER'S LOCALE
        DayOfWeek dow = DayOfWeek.MONDAY;
        Locale locale = Locale.getDefault();
        System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
        System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));


    }
}
