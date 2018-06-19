package com.cetccity.queue.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.cetccity.queue.utils.DateUtils;

public class aa {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date lastwaitbegin2 = calendar.getTime();
		System.out.println("end========"+lastwaitbegin2);
	}
}
