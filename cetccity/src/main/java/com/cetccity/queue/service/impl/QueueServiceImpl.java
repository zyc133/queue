package com.cetccity.queue.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cetccity.queue.dao.CustLevelRepository;
import com.cetccity.queue.dao.QueueDao;
import com.cetccity.queue.dao.SysConfRepository;
import com.cetccity.queue.dao.Tbilllog061Repository;
import com.cetccity.queue.dao.TspecialCustomerRepository;
import com.cetccity.queue.dao.model.SysConf;
import com.cetccity.queue.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustLevelRepository custLevelDao;
	
	@Autowired
	private SysConfRepository sysRepository;
	
	@Autowired
	private Tbilllog061Repository tbilllogDao;
	
	@Autowired
	private TspecialCustomerRepository tspecialCustomerDao;
	
	@Autowired
	private SysConfRepository sysConfRepository;
	
	@Autowired
	private QueueDao queueDao;

	@Override
	public void queuePriorityChange(String userid, String callerno) {
		int count = queueDao.updateTSpecialCustomer(userid, callerno);
	}
	@Override
	@Transactional
	public void insertTSpecialCustomer(String userid, String callerno) {
		int count = queueDao.insertTSpecialCustomer(userid, callerno);
	}

	@Override
	@Transactional
	public void toChangePriority() throws Exception {
		DateFormat sf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		//TODO
//		Date waitbegin = sf.parse("2018/06/01 06:49:00");
		List<SysConf> sysConf = getSysConf();
		//TODO
//		Date lastwaitbegin = sf.parse("2018/06/01 06:40:00");
		Date lastwaitbegin = sysConf.get(0).getLastwaitbegin();
		
		List<String> newBeginDate = queueDao.getNewBeginDate();
		Date waitbegin = sf.parse(newBeginDate.get(0));
//		Date waitbegin = sysConf.get(0).getWaitBegin();
//		Calendar beforeTime = Calendar.getInstance();
//		beforeTime.add(Calendar.MINUTE, -1);// 1分钟之前的时间
//		Date lastwaitbegin = beforeTime.getTime();
		List<Object[]> callCount = queueDao.getCallCount(lastwaitbegin,waitbegin);
		for (Object[] objects : callCount) {
			String callerno = objects[0].toString();
			String userid = objects[1].toString();
			try {
				Integer count = getUserLevel(callerno);
				if(count==1) {
					this.insertTSpecialCustomer((Integer.valueOf(count)+1)+"", callerno);
				}else {
					this.queuePriorityChange((Integer.valueOf(count)+Integer.valueOf(userid))+"", callerno);
				}
			} catch (Exception e) {
				logger.error("呼入号码"+callerno+"更改客户级别失败.."+e.getMessage());
			}
		}
		try {
			queueDao.updateSysCong(sf.parse(sf.format(new Date())));
		} catch (Exception e) {
			logger.error("更新lastBegin失败"+e.getMessage());
			throw e;
		}
	
	}
	
	@Override
	public Integer getUserLevel(String callerno) {
		String userid = tspecialCustomerDao.getUserid(callerno);
		if(null==userid||"".equals(userid)) {
			userid="1";
		}
		Integer count = Integer.valueOf(userid);
		return count;
	}
	@Override
	public void clearCustomerPriority() {
		List<SysConf> config = this.getSysConf();
		Date waitbegin = config.get(0).getWaitBegin();
		Date lastwaitbegin = config.get(0).getLastwaitbegin();
		List<Object[]> callerNoList = queueDao.getUserForNeedBegin(waitbegin, lastwaitbegin);
		for (Object[] objects : callerNoList) {
			try {
				queueDao.delectTSpecialCustomer(objects[0].toString());
			} catch (Exception e) {
				logger.error("删除客户级别失败.."+e.getMessage());
			}
		}
	}
	private List<SysConf> getSysConf(){
		List<SysConf> list = new ArrayList<SysConf>();
		List<Object[]> config = sysRepository.getConfig("lastwaitbegin");
		for (Object[] objects : config) {
			SysConf sysConf = new SysConf();
			sysConf.setName(objects[0].toString());
			sysConf.setLastwaitbegin((Date)objects[1]);
			sysConf.setWaitBegin((Date)objects[2]);
			list.add(sysConf);
		}
		Date waitbegin = (Date)config.get(0)[2];
		Date lastwaitbegin = (Date)config.get(0)[1];
		return list;
		
	}
}
