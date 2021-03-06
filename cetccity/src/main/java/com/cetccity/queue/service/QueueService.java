package com.cetccity.queue.service;

import java.util.Date;

import org.springframework.stereotype.Service;

public interface QueueService {
	
	public void queuePriorityChange(String userid, String callerno);
	
	public void toChangePriority() throws Exception;

	Integer getUserLevel(String callerno);

	void insertTSpecialCustomer(String userid, String callerno);

	void clearCustomerPriority() throws Exception;
	
}
