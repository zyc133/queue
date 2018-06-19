package com.cetccity.queue.service.schedul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cetccity.queue.service.QueueService;

@Component
public class QueueChangeScheuler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private QueueService queueService;

	@Scheduled(cron = "0 0/1 * * * ?") // 每1分钟执行一次
	public void statusCheck() {
		logger.info("定时器开始运行....");
		try {
			queueService.toChangePriority();
//			queueService.clearCustomerPriority();
		} catch (Exception e) {
			logger.error("定时器运行失败..");
		}
		logger.info("定时器运行结束....");
	}

}
