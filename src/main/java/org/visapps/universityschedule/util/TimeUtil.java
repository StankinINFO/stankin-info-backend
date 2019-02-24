package org.visapps.universityschedule.util;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    public static String getWeekOfPeriod(Date start, Date current) {
        LocalDateTime startDate = LocalDateTime.ofInstant(start.toInstant(), ZoneId.systemDefault());
        LocalDateTime currentDate = LocalDateTime.ofInstant(current.toInstant(), ZoneId.systemDefault());
        return String.valueOf(ChronoUnit.WEEKS.between(startDate, currentDate) + 1L);
    }

    public static Integer getDayOfWeek(Date current) {
        LocalDateTime currentDate = LocalDateTime.ofInstant(current.toInstant(), ZoneId.systemDefault());
        return currentDate.getDayOfWeek().getValue();
    }

}
