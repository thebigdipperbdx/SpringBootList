package com.sto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author yanyugang
 * @description 计算日期区间
 * @date 2019-04-29 16:29
 */
public class MyDateUtils {
    // 解决多线程并发的安全性问题
    private static ThreadLocal<SimpleDateFormat> threadLocal=new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    // 解决多线程并发的安全性问题
    private static ThreadLocal<SimpleDateFormat> threadLocal2=new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String todayTimeStart(){
        boolean flag=beforeNoontime();
        if (flag){
            Date date=new Date();
            Calendar calendar=new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, -1);
            date=calendar.getTime();
            return threadLocal.get().format(date) + " 12:00:00";
        }else {
            return threadLocal.get().format(System.currentTimeMillis()) + " 12:00:00";
        }

    }

    public static String todayTimeEnd(){
        boolean flag=beforeNoontime();
        if (flag){
            return threadLocal.get().format(System.currentTimeMillis()) + " 11:59:59";
        }else {
            Date date=new Date();
            Calendar calendar=new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 1);
            date=calendar.getTime();
            return threadLocal.get().format(date) + " 11:59:59";
        }
    }

    public static String nowString(){
        return threadLocal2.get().format(System.currentTimeMillis());
    }

    // 现在时间是否在当天12点之前
    // true
    public static boolean beforeNoontime(){
        try {
            Date now=new Date();
            String noon=threadLocal.get().format(System.currentTimeMillis()) + " 12:00:00";
            Date date=threadLocal2.get().parse(noon);
            // 当天12点之前
            if (now.before(date)){
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String yesterdayStart(){
        boolean flag=beforeNoontime();
        if (flag){
            Date date=new Date();
            Calendar calendar=new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, -2);
            date=calendar.getTime();
            return threadLocal.get().format(date) + " 12:00:00";
        }else {
            Date date=new Date();
            Calendar calendar=new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, -1);
            date=calendar.getTime();
            return threadLocal.get().format(date) + " 12:00:00";
        }
    }

    public static String yesterdayEnd(){
        boolean flag=beforeNoontime();
        if (flag){
            Date date=new Date();
            Calendar calendar=new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, -1);
            date=calendar.getTime();
            return threadLocal.get().format(date) + " 11:59:59";
        }else {
            return threadLocal.get().format(System.currentTimeMillis()) + " 11:59:59";
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println("todat==="+todayTimeStart() + "  " + todayTimeEnd());
        System.out.println("yesterday==="+yesterdayStart() + "  "+yesterdayEnd());
    }

}
