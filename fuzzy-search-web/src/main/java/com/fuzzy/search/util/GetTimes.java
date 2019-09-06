package com.fuzzy.search.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimes {
	// 解决多线程并发的安全性问题
	private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public static Date parse(String dateStr) throws ParseException {
		return threadLocal.get().parse(dateStr);
	}

	public static String format(Date date) {
		return threadLocal.get().format(date);
	}
	
	
	
	

}
