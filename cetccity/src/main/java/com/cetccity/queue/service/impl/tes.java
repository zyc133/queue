package com.cetccity.queue.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tes {

	public static void main(String[] args) {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
			Date waitbegin = sf.parse("2018/06/01 06:49:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
