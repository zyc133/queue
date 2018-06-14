package com.cetccity.queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cetccity.queue.dao.CustLevelRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CetccityApplicationTests {

	@Autowired
	
	private CustLevelRepository dao;
	
	@Test
	public void contextLoads() {
		
		long totalCount = dao.getTotalCount("partid");
		System.out.println(totalCount);
	}

}
