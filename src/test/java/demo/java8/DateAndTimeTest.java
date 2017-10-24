package demo.java8;

import org.testng.annotations.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class DateAndTimeTest {

    //PollsTest.java could be used as PL+ example
    @Test
    void javaTimeDemo() {
        LocalDate today = LocalDate.now();

        System.out.println("Is " + today.getYear() + " - leap? : " + today.isLeapYear());

        System.out.println("Is today before 08.10.2017? : " + today.isBefore(LocalDate.of(2017,10,8)));

        System.out.println("Current time is : " + today.atTime(LocalTime.now()));

        System.out.println("6 days after today: " + today.plusDays(6));
        System.out.println("2 weeks after today: " + today.plusWeeks(2));
        System.out.println("11 months after today: " + today.plusMonths(11));

        System.out.println("6 days before today: " + today.minusDays(6));
        System.out.println("2 weeks before today: " + today.minusWeeks(2));
        System.out.println("11 months before today: " + today.minusMonths(11));

        System.out.println("The first day of this month: " + today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("The last day of this year: " + lastDayOfYear);

        Period period = today.until(lastDayOfYear);
        System.out.println("Period between two dates: " + period);
        System.out.println("There are " + period.getMonths() + " before the end of this year");
    }

    @Test
    void timeZoneDemo() {
        ZoneId timeZone=ZoneId.of("America/New_York");
        ZonedDateTime todayWithTimeZone=ZonedDateTime.of(LocalDateTime.now(), timeZone);
        System.out.format("Date time with zone ID of New York is %s\n", todayWithTimeZone);

        LocalDateTime todayZoneOffset=LocalDateTime.now();
        ZoneId timeZoneOffset=ZoneOffset.of("-0500");
        ZonedDateTime todayWithTimeZoneOffset=ZonedDateTime.of(todayZoneOffset, timeZoneOffset);
        System.out.format("Date time with zone offset of UTC -5 hours is %s\n", todayWithTimeZoneOffset);
    }
}
