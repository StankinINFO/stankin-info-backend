package org.visapps.universityschedule.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeUtil {

    public static String WeekOfPeriod(Date start, Date current) {
        LocalDateTime startDate = LocalDateTime.ofInstant(start.toInstant(), ZoneId.systemDefault());
        LocalDateTime currentDate = LocalDateTime.ofInstant(current.toInstant(), ZoneId.systemDefault());
        return String.valueOf(ChronoUnit.WEEKS.between(startDate, currentDate));
    }

    public static Integer DayOfWeek(Date current) {
        LocalDateTime currentDate = LocalDateTime.ofInstant(current.toInstant(), ZoneId.systemDefault());
        return currentDate.getDayOfWeek().getValue();
    }

    public static Date DateWithDefaultTime(Date current) {
        LocalDateTime localDate = LocalDateTime.ofInstant(current.toInstant(), ZoneId.systemDefault());
        Instant instant = localDate.toInstant(ZoneOffset.UTC);
        return Date.from(instant);
    }

    public static Date DateFromString(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.parse(date);
    }

}
