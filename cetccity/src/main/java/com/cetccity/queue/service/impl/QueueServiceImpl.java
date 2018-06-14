package com.cetccity.queue.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cetccity.queue.dao.CustLevelRepository;
import com.cetccity.queue.dao.QueueDao;
import com.cetccity.queue.dao.Tbilllog061Repository;
import com.cetccity.queue.dao.TspecialCustomerRepository;
import com.cetccity.queue.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustLevelRepository custLevelDao;
	
	@Autowired
	private Tbilllog061Repository tbilllogDao;
	
	@Autowired
	private TspecialCustomerRepository tspecialCustomerDao;
	
	@Autowired
	private QueueDao queueDao;

	@Override
	public void queuePriorityChange(String userid, String callerno) {
		int count = queueDao.updateTSpecialCustomer(userid, callerno);
		System.out.println("定时器运行"+count);
	}
	@Override
	@Transactional
	public void insertTSpecialCustomer(String userid, String callerno) {
		int count = queueDao.insertTSpecialCustomer(userid, callerno);
		System.out.println("定时器运行"+count);
	}

	@Override
	@Transactional
	public void toChangePriority() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		try {
			Date waitbegin = sf.parse("2018/06/01 06:49:00");
			List<Object[]> callCount = queueDao.getCallCount(waitbegin);
			for (Object[] objects : callCount) {
				try {
					String callerno = objects[0].toString();
					String userid = objects[1].toString();
					long count = getUserLevel(callerno);
					if(count==1) {
						insertTSpecialCustomer(userid+1, callerno);
					}else {
						queuePriorityChange(userid+count, callerno);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@Override
	public long getUserLevel(String callerno) {
		String userid = tspecialCustomerDao.getUserid(callerno);
		if(null==userid||"".equals(userid)) {
			userid="1";
		}
		long count = Long.valueOf(userid);
		return count;
	}
}
