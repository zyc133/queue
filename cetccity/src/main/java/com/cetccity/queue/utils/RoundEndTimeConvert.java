package com.cetccity.queue.utils;

import java.util.Calendar;
import java.util.Date;


/**
 * 对齐到结束日期的格式化类
 * @author Administrator
 *
 */
public class RoundEndTimeConvert implements CondPropertiesConvertor {

	@Override
	public Object convert(Object condProperty) {
		if(!(condProperty instanceof java.util.Date) ){
			throw new RuntimeException("不支持的日期类型");
		}
		java.util.Date roundDate =DateUtils.roundDate((java.util.Date)condProperty, Calendar.DATE);
		return DateUtils.rollDate(roundDate, Calendar.DATE, 1);
	}

}
