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

	@Scheduled(cron = "0 0/1 * * * ?") // 每5分钟执行一次
	public void statusCheck() {
		logger.info("每分钟执行一次。开始……");
		queueService.queuePriorityChange();
		logger.info("每分钟执行一次。结束。");
	}

}
