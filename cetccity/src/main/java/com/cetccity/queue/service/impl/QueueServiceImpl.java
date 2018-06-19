package com.cetccity.queue.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cetccity.queue.dao.CustLevelRepository;
import com.cetccity.queue.dao.QueueDao;
import com.cetccity.queue.dao.SysConfRepository;
import com.cetccity.queue.dao.Tbilllog061Repository;
import com.cetccity.queue.dao.TspecialCustomerRepository;
import com.cetccity.queue.dao.model.SysConf;
import com.cetccity.queue.service.QueueService;
import com.cetccity.queue.utils.DateUtils;
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

		// TODO
		// Date waitbegin = sf.parse("2018/06/01 06:49:00");
		// Date lastwaitbegin = sf.parse("2018/06/01 06:40:00");
		// Date waitbegin = sysConf.get(0).getWaitBegin();
		// Calendar beforeTime = Calendar.getInstance();
		// beforeTime.add(Calendar.MINUTE, -1);// 1分钟之前的时间
		// Date lastwaitbegin = beforeTime.getTime();
		
		List<SysConf> sysConf = getSysConf();
		Date lastwaitbegin = sysConf.get(0).getLastwaitbegin();
		// 不是当天,考虑跨天问题，需要考虑跨表
		boolean today = DateUtils.isToday(lastwaitbegin);
		List<Object[]> callCount = new ArrayList<Object[]>();
		if (!today) {
			//前天的数据查询
			Map<String, String> tablemap = this.getTableName(lastwaitbegin);
			String table=tablemap.get("tableName");
			String partId=tablemap.get("partId");
		
			//最后一秒
			Date waitbegin = DateUtils.getLastDateTime(lastwaitbegin);
			
			List<Object[]> callCount2 = queueDao.getCallCount(lastwaitbegin, waitbegin,table,partId);
			callCount.addAll(callCount2);
			
			//今天的数据查询
			Map<String, String> tablemap1 = this.getTableName(new Date());
			String table1=tablemap.get("tableName");
			String partId1=tablemap.get("partId");
			
			//当天时间的第一秒
			Date lastwaitbegin2 = DateUtils.getFirstDateTime(new Date());
			
			List<String[]> tablemap2 = queueDao.getMaxDateAndMinDateFromTbilllog(table1);
			Date waitbegin2=  sf.parse(tablemap2.get(0)[0]);
			List<Object[]> callCount3 = queueDao.getCallCount(lastwaitbegin2, waitbegin2, table1, partId1);
			callCount.addAll(callCount3);
			
		}else {
			Map<String, String> tablemap = this.getTableName(lastwaitbegin);
			String table=tablemap.get("tableName");
			String partId=tablemap.get("partId");
			List<String[]> dateList = queueDao.getMaxDateAndMinDateFromTbilllog(table);
			Date waitbegin=  sf.parse(dateList.get(0)[0]);
			callCount= queueDao.getCallCount(lastwaitbegin, waitbegin,table,partId);
		}
		
		for (Object[] objects : callCount) {
			String callerno = objects[0].toString();
			String userid = objects[1].toString();
			try {
				Integer count = getUserLevel(callerno);
				if (count == 1) {
					this.insertTSpecialCustomer((Integer.valueOf(count) + 1) + "", callerno);
				} else {
					this.queuePriorityChange((Integer.valueOf(count) + Integer.valueOf(userid)) + "", callerno);
				}
			} catch (Exception e) {
				logger.error("呼入号码" + callerno + "更改客户级别失败.." + e.getMessage());
			}
		}
		try {
			queueDao.updateSysCong(sf.parse(sf.format(new Date())));
		} catch (Exception e) {
			logger.error("更新lastBegin失败" + e.getMessage());
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
	public void clearCustomerPriority(){
		DateFormat sf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		List<SysConf> config = this.getSysConf();
		Date lastwaitbegin = config.get(0).getLastwaitbegin();
		// 不是当天,考虑跨天问题，需要考虑跨表
		boolean today = DateUtils.isToday(lastwaitbegin);
		List<Object[]> callerNoList = new ArrayList<Object[]>();
		if(!today) {
			//前天的数据查询
			Map<String, String> tablemap = this.getTableName(lastwaitbegin);
			String table=tablemap.get("tableName");
			String partId=tablemap.get("partId");
		
			//最后一秒
			Date waitbegin = DateUtils.getLastDateTime(lastwaitbegin);
			
			List<Object[]> callerNoList2 = queueDao.getUserForNeedBegin(lastwaitbegin, waitbegin,table,partId);
			callerNoList.addAll(callerNoList2);
			
			//今天的数据查询
			Map<String, String> tablemap1 = this.getTableName(new Date());
			String table1=tablemap.get("tableName");
			String partId1=tablemap.get("partId");
			
			//当天时间的第一秒
			Date lastwaitbegin2 = DateUtils.getFirstDateTime(new Date());
			List<String[]> tablemap2 = queueDao.getMaxDateAndMinDateFromTbilllog(table1);
			try {
				Date waitbegin2 = sf.parse(tablemap2.get(0)[0]);
				List<Object[]> callerNoList3 = queueDao.getUserForNeedBegin(lastwaitbegin2, waitbegin2, table1, partId1);
				callerNoList.addAll(callerNoList3);
			} catch (ParseException e) {
				logger.error(e.getMessage());
			}
			
			
			
		}else {
			Map<String, String> tablemap = this.getTableName(lastwaitbegin);
			String table=tablemap.get("tableName");
			String partId=tablemap.get("partId");
			List<String[]> dateList = queueDao.getMaxDateAndMinDateFromTbilllog(table);
			try {
				Date waitbegin = sf.parse(dateList.get(0)[0]);
				callerNoList=queueDao.getUserForNeedBegin(lastwaitbegin, waitbegin, table, partId);
			} catch (ParseException e) {
				logger.error(e.getMessage());
			}
		}
		
		for (Object[] objects : callerNoList) {
			try {
				queueDao.delectTSpecialCustomer(objects[0].toString());
			} catch (Exception e) {
				logger.error("删除客户级别失败.." + e.getMessage());
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
	
	private Map<String,String> getTableName(Date date) {
		Map<String,String> map = new HashMap<String,String>();
		StringBuilder tableName = new StringBuilder("tBillLog");
		StringBuilder partId = new StringBuilder();
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		int month = instance.get(Calendar.MONTH);
		month++;
		if(month<10) {
			tableName.append("0"+month);
			partId.append("0"+month);
		}else {
			tableName.append(month);
			partId.append(month);
		}
		int day_of_month = instance.get(Calendar.DAY_OF_MONTH);
		if(day_of_month<=10){
			tableName.append("1");
		}else if(day_of_month>10&&day_of_month<=20) {
			tableName.append("2");
		}else {
			tableName.append("3");
		}
		if(day_of_month<10) {
			partId.append("0").append(day_of_month);
		}else {
			partId.append(day_of_month);
		}
		map.put("tableName",tableName.toString());
		map.put("partId",partId.toString());
		
		return map;
	}
}
