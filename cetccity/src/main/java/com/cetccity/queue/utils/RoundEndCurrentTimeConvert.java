package com.cetccity.queue.utils;

import java.util.Calendar;
import java.util.Date;


/**
 * 对齐到截止日期的格式化类
 * @author Administrator
 *
 */
public class RoundEndCurrentTimeConvert implements CondPropertiesConvertor {

	@Override
	public Object convert(Object condProperty) {
		if(!(condProperty instanceof Date) ){
			throw new RuntimeException("不支持的日期类型");
		}
		Date endDate=(java.util.Date)condProperty;
		//截止日期是当天到 当前时间的时分秒
		//不是当天 则到日期的日期的23:59:59
		if(DateUtils.isToday(endDate)){
			return new Date();
		}else{
			Date d = DateUtils.roundDate(endDate, Calendar.DATE);
			Date rollDate = DateUtils.rollDate(d, Calendar.DATE, 1);
			return rollDate;
		}
		
	}

}
