package com.ayt.example.task;

import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * Description
 * Author ayt  on
 */
public class DateUtils {
	public static void main(String[] args) {

		Calendar ca = Calendar.getInstance();//创建一个日期实例
		Date beginOfDay = DateUtil.beginOfDay(new Date());
		ca.setTime(beginOfDay);//实例化一个日期
		int weekYear = ca.get(Calendar.YEAR);//获得当前的年
		int weekOfYear = ca.get(Calendar.WEEK_OF_YEAR);//获得当前日期属于今年的第几周


		ca.setWeekDate(weekYear,weekOfYear+1,2);
		String date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ca.getTime());

		String date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ca.getTime());

		System.out.println(date1);
//		System.out.println(ca.get();//获取是第多少天
//		System.out.println(ca.get(Calendar.WEEK_OF_YEAR));//获取是第几周
//
//
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2016); // 2016年
//		cal.set(Calendar.WEEK_OF_YEAR, 10); // 设置为2016年的第10周
//		cal.set(Calendar.DAY_OF_WEEK, 2); // 1表示周日，2表示周一，7表示周六
//		Date date = cal.getTime();




	}
}
