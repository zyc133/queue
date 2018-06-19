package com.cetccity.queue.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	
	private static final int[] TIME_FILED_LEVEL={
		Calendar.YEAR,
		Calendar.MONTH,	
		Calendar.DATE,
		Calendar.HOUR_OF_DAY,	
		Calendar.MINUTE,
		Calendar.SECOND,	
		Calendar.MILLISECOND,	
	};
	/**
	 * 对齐日期对象到指定的精度
	 * @param date
	 * @param filed
	 * @return
	 */
	public static Date roundDate(Date date,int filed){
		if(date==null){
			return date;
		}
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(date.getTime());
		Boolean clearFlag=false;
		for (int i = 0; i < TIME_FILED_LEVEL.length; i++) {
			if(clearFlag){
				instance.set(TIME_FILED_LEVEL[i], instance.getMinimum(TIME_FILED_LEVEL[i]));
			}else if(filed==TIME_FILED_LEVEL[i]){
				clearFlag=true;
			}
		
		}
		return instance.getTime();
	}
	/**
	 * 调整日期对象
	 * @param date
	 * @param filed
	 * @param amount
	 * @return
	 */
	public static Date rollDate(Date date,int filed,int amount){
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(date.getTime());
		instance.add(filed, amount);
		return instance.getTime();
		
	}
	
	/**
	 * 获得时间对象的时间域值
	 * @param date
	 * @param field
	 * @return
	 */
	public static int getDateFiled(Date date,int field){
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		return instance.get(field);
		
	}
	/**
	 * 获得调整后的额日期对象
	 * @param date
	 * @param field
	 * @param value
	 * @return
	 */
	public static Date setDateField(Date date,int field,int value){
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		instance.set(field, value);
		return instance.getTime();
		
	}
	/**
	 * 判断是否是今天
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date){
		Calendar instance = Calendar.getInstance();
		int year= instance.get(Calendar.YEAR);
		int dayOfYear = instance.get(Calendar.DAY_OF_YEAR);
		instance.setTime(date);
		if(year==instance.get(Calendar.YEAR)&&dayOfYear==instance.get(Calendar.DAY_OF_YEAR)){
			return true;
		}
		return false;
	}
	/**
	 * 判断是否在今天之前(未来) 
	 * @param date
	 * @return
	 */
	public static boolean isBeforeToday(Date date){
		Calendar instance = Calendar.getInstance();
		int year= instance.get(Calendar.YEAR);
		int dayOfYear = instance.get(Calendar.DAY_OF_YEAR);
		instance.setTime(date);
		if(year>instance.get(Calendar.YEAR)) return true;
		if(year<instance.get(Calendar.YEAR)) return false;
		if(dayOfYear>instance.get(Calendar.DAY_OF_YEAR)) return true;
		return false;
	}
	/**
	 * 是否是过去的时间
	 * @param date
	 * @return
	 */
	public static boolean isAfterToday(Date date){
		Calendar instance = Calendar.getInstance();
		int year= instance.get(Calendar.YEAR);
		int dayOfYear = instance.get(Calendar.DAY_OF_YEAR);
		instance.setTime(date);
		if(year>instance.get(Calendar.YEAR)) return false;
		if(year<instance.get(Calendar.YEAR)) return true;
		if(dayOfYear>instance.get(Calendar.DAY_OF_YEAR)) return false;
		return true;
	}
	/**
	 * 获取上一天的时间
	 * @return
	 */
	public static Date lastDate(){
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DATE, -1);
		return instance.getTime();
		
	}
	/**
	 * 获取上一个月的时间
	 * @return
	 */
	public static Date lasMonth(){
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.MONTH, -1);
		return instance.getTime();
	}
	
	/**
	 * 返回两个时间间隔
	 * @param begindate
	 * @param endDate
	 * @return
	 */
	public static int compareDays(Date begindate,Date endDate){
		long endDateTime = endDate.getTime();
		long beginTime = begindate.getTime();
		long time=(endDateTime-beginTime);
		long longTimes=24L*60l*60L*1000l;
		return (int)(time/longTimes);
	}
	
	/**
	 * 组合时间和日期
	 * @param date 日期偏移量
	 * @param time 时间偏移量
	 * @return
	 */
	public static Date composeDateTime(Date date,Date time){
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		instance.set(Calendar.HOUR_OF_DAY, getDateFiled(time, Calendar.HOUR_OF_DAY));
		instance.set(Calendar.MINUTE, getDateFiled(time, Calendar.MINUTE));
		instance.set(Calendar.SECOND, getDateFiled(time, Calendar.SECOND));
		instance.set(Calendar.MILLISECOND, 0);
		return instance.getTime();
	}
	/**
	 * 当天时间的最后一秒
	 * @param date 日期
	 * @return
	 */
	public static Date getLastDateTime(Date date){
		//当天时间的最后一秒
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date waitbegin = calendar.getTime();
		return waitbegin;
	}
	/**
	 * 当天时间的第一秒
	 * @param date 日期
	 * @return
	 */
	public static Date getFirstDateTime(Date date){
		Calendar calendar = Calendar.getInstance();
		//当天时间的第一秒
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date lastwaitbegin2 = calendar.getTime();
		return lastwaitbegin2;
	}
}
