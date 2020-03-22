package com.sto.transport.report.util;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * LocalDateTime
 */
public class MyDateUtils {
    public static DateTimeFormatter formatterOne = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter formatterTwo = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter formatterThree = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static DateTimeFormatter formatterFour = DateTimeFormatter.ofPattern("HH");


    public static String getNowDayTime() {
        return LocalDateTime.now().format(formatterOne);
    }

    public static String getNowTime() {
        return LocalDate.now().format(formatterTwo);
    }

    public static String getDayTimePlusByDay() {
        return LocalDateTime.now().plusDays(1).format(formatterOne);
    }

    public static String getDayPlusByDay(int day) {
        return LocalDate.now().plusDays(day).format(formatterTwo);
    }

    public static String getPersonDayTime(String actualDepartureTime) {
        LocalDateTime dayTime = LocalDateTime.parse(actualDepartureTime, formatterOne);
        int hour = Integer.parseInt(dayTime.format(formatterFour));
        if (hour < 12) {
            return dayTime.plusDays(-1).format(formatterTwo);
        }
        return dayTime.format(formatterTwo);
    }


    private static final LocalTime NOON_TIME = LocalTime.of(12, 00, 00);

    // 是否在中午12点之前
    public static boolean beforeNoontime() {
        return LocalTime.now().isBefore(NOON_TIME);
    }

    public static String yesterdayStart() {
        if (beforeNoontime()) {
            return getDayPlusByDay(-2) + " 12:00:00";
        }
        return getDayPlusByDay(-1) + " 12:00:00";
    }

    public static String yesterdayEnd() {
        if (beforeNoontime()) {
            return getDayPlusByDay(-1) + " 11:59:59";
        }
        return getDayPlusByDay(0) + " 11:59:59";
    }


    public static String getDateByDayStart(String startDay, int day) throws ParseException {
        LocalDateTime time = LocalDateTime.parse(startDay, formatterOne);
        time.plusDays(day);
        return time.format(formatterOne);
    }

    public static String getDateByDayEnd(String endDay, int day) throws ParseException {
        LocalDateTime time = LocalDateTime.parse(endDay, formatterOne);
        time.plusDays(day);
        return time.format(formatterOne);
    }

    public static String getSecondsDateTime(long millisecond) {
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(millisecond / 1000, 0, ZoneOffset.ofHours(8));
        return localDateTime.format(formatterOne);
    }


    public static void main(String[] args) {
        //获得时间戳
        long milliseconds = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        long modifiedOn = LocalDateTime.now().plusMinutes(-5).toInstant(ZoneOffset.of("+8")).toEpochMilli();

        // 将时间戳转为当前时间
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(modifiedOn / 1000, 0, ZoneOffset.ofHours(8));
        // 2020-02-03T13:35:53
        System.out.println(localDateTime.format(formatterOne));


    }
}
