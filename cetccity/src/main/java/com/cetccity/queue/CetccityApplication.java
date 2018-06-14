package com.cetccity.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetccity.queue.config.TestConfig;
import com.cetccity.queue.dao.CustLevelRepository;
import com.cetccity.queue.service.QueueService;

@SpringBootApplication
//@EnableScheduling 
@RestController
public class CetccityApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CetccityApplication.class, args);
	}
	
	@Autowired
	private CustLevelRepository dao;
	
	@RequestMapping("/test")
	public void test() {
		long totalCount = dao.updateUserStatus("18090209111");
		System.out.println(totalCount);
	}
	
	
}
