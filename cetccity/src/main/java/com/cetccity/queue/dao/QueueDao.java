package com.cetccity.queue.dao;

import java.util.Date;
import java.util.List;

public interface QueueDao {

	
	public List<Object[]> getCallCount(Date waitBegin,Date lastWaitBegin );
	
	public int updateTSpecialCustomer(String userid,String callerno);

	int insertTSpecialCustomer(String userid, String callerno);
}
