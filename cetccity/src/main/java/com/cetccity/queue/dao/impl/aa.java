package com.cetccity.queue.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class aa {
	public static void main(String[] args) {
		DateFormat sf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String format = sf.format(new Date());
		System.out.println(format);
	}
}
