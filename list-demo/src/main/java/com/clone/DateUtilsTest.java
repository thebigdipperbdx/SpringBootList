package com.clone;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-28 17:39
 */
public class DateUtilsTest {
    /**
     * commons-lang3 时间工具类使用
     * org.apache.commons.lang3.time.DateFormatUtils：线程安全
     * @param args
     */
    public static void main(String[] args) throws ParseException{
        String pattern="yyyy-MM-dd HH:mm:ss";
        Date date=new Date();
        System.out.println(DateFormatUtils.format(date, pattern));
        System.out.println("-----------------------------------------");

        String dateString="2019-11-28 17:49:30";
        Date myDate=DateUtils.parseDate(dateString, pattern);
        System.out.println(myDate.toString());

    }
}
