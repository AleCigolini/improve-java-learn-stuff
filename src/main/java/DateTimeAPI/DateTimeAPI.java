package DateTimeAPI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
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
* */
public class DateTimeAPI {

    public static void main(String[] args) {

        enumsDayOfWeek();
        enumsMonth();

        localDateClass();
        yearMonthClass();
        monthDayClass();
        yearClass();
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
