package com.cetccity.queue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cetccity.queue.dao.QueueDao;
import com.cetccity.queue.service.QueueService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CetccityApplicationTests {

	@Autowired
	private QueueDao dao;
	
	
	@Autowired
	private QueueService service;
	

//	@Test
//	public void contextLoads() {
//	}
	@Test
	public void test1() throws ParseException {
//		DateFormat sf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		List<String> newBeginDate = dao.getNewBeginDate();
//		try {
//			Date parse = sf.parse(newBeginDate.get(0));
//			System.out.println(parse);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		int updateSysCong = dao.updateSysCong(sf.parse("2018/06/16 16:23:33"));
//		System.err.println(updateSysCong);
		
		service.clearCustomerPriority();
		
		
	}
}
