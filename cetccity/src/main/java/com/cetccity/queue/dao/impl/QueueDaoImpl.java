package com.cetccity.queue.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetccity.queue.dao.QueueDao;

@Service
public class QueueDaoImpl implements QueueDao {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected EntityManager em;
	
	@Override
	public List<Object[]> getCallCount(Date lastWaitBegin,Date waitBegin ) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append("SELECT t.callerNo, COUNT(1) call_count  ");
		sqlString.append("	FROM (SELECT DISTINCT callId, callerNo FROM " );
		Map<String, String> tablemap = this.getTableName();
		String table=tablemap.get("tableName");
		String partId=tablemap.get("partId");
		sqlString.append(table);
		sqlString.append(" WHERE deviceType=1 AND PARTID =  ");
		sqlString.append(partId);
		sqlString.append(" AND callerNo!='12345'  AND callType!=10 AND WAITBEGIN >=? and WAITBEGIN <=?) t ");
		sqlString.append(" where not exists (select 1 from ");
		sqlString.append(table);
		sqlString.append(" c where c.callId=t.callId and c.deviceType=2 and releaseCause!=2 and releaseCause!=6 and CALLEND > CALLBEGIN )");
		sqlString.append("  and callerNo=13075967905 GROUP BY callerNo ");
		sqlString.append(" ORDER  BY COUNT(1) DESC ");
		Query createNativeQuery = em.createNativeQuery(sqlString.toString());
		createNativeQuery.setParameter(1, waitBegin);
		createNativeQuery.setParameter(2, lastWaitBegin);
		List<Object[]> resultList = (List<Object[]>)createNativeQuery.getResultList();
		return resultList;
	}
	@Override
	public List<Object[]> getUserForNeedBegin(Date waitBegin,Date lastWaitBegin) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append("SELECT callerNo ");
		sqlString.append("	FROM ");
		Map<String, String> tablemap = this.getTableName();
		String table=tablemap.get("tableName");
		String partId=tablemap.get("partId");
		sqlString.append(table);
		sqlString.append(" WHERE PARTID = ");
		sqlString.append(partId);
		sqlString.append(" AND CALLERNO!='12345' AND CALLTYPE!=10  AND DEVICETYPE=2 AND RELEASECAUSE!=2 AND RELEASECAUSE!=6 AND WAITBEGIN <=? and WAITBEGIN >=?");
		Query createNativeQuery = em.createNativeQuery(sqlString.toString());
		createNativeQuery.setParameter(1, waitBegin);
		createNativeQuery.setParameter(2, lastWaitBegin);
		List<Object[]> resultList = (List<Object[]>)createNativeQuery.getResultList();
		return resultList;
	}
	
	
	private Map<String,String> getTableName() {
		Map<String,String> map = new HashMap<String,String>();
		StringBuilder tableName = new StringBuilder("tBillLog");
		StringBuilder partId = new StringBuilder();
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
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

	@Override
	public int updateTSpecialCustomer(String userid,String callerno) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append(" UPDATE tspecialcustomer SET userid =? where callerno =?");
		Query createNativeQuery = em.createNativeQuery(sqlString.toString());
		createNativeQuery.setParameter(1, userid);
		createNativeQuery.setParameter(2,callerno);
		int executeUpdate = createNativeQuery.executeUpdate();
		return executeUpdate;
	}
	@Override
	public int updateSysCong(Date date) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append(" UPDATE T_SYS_CONF SET LASTWAITBEGIN =sysdate where name ='lastwaitbegin'");
		Query createNativeQuery = em.createNativeQuery(sqlString.toString());
//		createNativeQuery.setParameter(1, date);
		int executeUpdate = createNativeQuery.executeUpdate();
		return executeUpdate;
	}
	@Override
	@Transactional
	public int delectTSpecialCustomer(String callerno) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append(" delete from tspecialcustomer where callerno=?");
		Query createNativeQuery = em.createNativeQuery(sqlString.toString());
		createNativeQuery.setParameter(1, callerno);
		int executeUpdate = createNativeQuery.executeUpdate();
		return executeUpdate;
	}
	@Override
	public int insertTSpecialCustomer(String userid,String callerno) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append(" insert into tspecialcustomer (callerno,userid,subccno,vdn ) values (?,?,1,1)");
		Query createNativeQuery = em.createNativeQuery(sqlString.toString());
		createNativeQuery.setParameter(1, userid);
		createNativeQuery.setParameter(2,callerno);
		int executeUpdate = createNativeQuery.executeUpdate();
		return executeUpdate;
	}
	@Override
	public List<String> getNewBeginDate() {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append(" select  to_char(max(waitbegin),'yyyy/MM/dd HH24:mi:ss') as waitbeginstring  from  ");
		//TODO
//		Map<String, String> map = this.getTableName();
//		String tableName=map.get("tableName");
//		sqlString.append(tableName);
		
		sqlString.append("tbilllog061");
		Query createNativeQuery = em.createNativeQuery(sqlString.toString());
		List<String> resultList = createNativeQuery.getResultList();
		return resultList;
	}
	
	
}
