package com.cetccity.queue.service.impl;

import org.springframework.stereotype.Service;

import com.cetccity.queue.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService {

	@Override
	public void queuePriorityChange() {
		System.out.println("定时器运行");
	}

}
