package com.cetccity.queue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetccity.queue.config.TestConfig;
import com.cetccity.queue.dao.CustLevelRepository;
import com.cetccity.queue.dao.QueueDao;
import com.cetccity.queue.dao.Tbilllog061Repository;
import com.cetccity.queue.dao.TspecialCustomerRepository;
import com.cetccity.queue.service.QueueService;

@SpringBootApplication
@EnableScheduling 
@RestController
@EnableTransactionManagement
public class CetccityApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CetccityApplication.class, args);
	}
	
	@Autowired
	private CustLevelRepository custLevelDao;
	
	@Autowired
	private Tbilllog061Repository tbilllogDao;
	
	@Autowired
	private TspecialCustomerRepository tspecialCustomerDao;
	

	@Autowired
	private QueueService queueService;
	
	@RequestMapping("/test")
	public void test() {
		queueService.toChangePriority();
	}
	
	@RequestMapping("/test1")
	public void test1() {
		queueService.insertTSpecialCustomer("1", "15699854698");
	}
	@RequestMapping("/test2")
	public void test2() {
		System.out.println("552");
	}
}
