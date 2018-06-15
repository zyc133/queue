package com.cetccity.queue.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetccity.queue.dao.QueueDao;

@Service
public class QueueDaoImpl implements QueueDao {

	@Autowired
	protected EntityManager em;
	
	@Override
	public List<Object[]> getCallCount(Date waitBegin,Date lastWaitBegin ) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append("SELECT t.callerNo, COUNT(1) call_count  ");
		sqlString.append("	FROM (SELECT DISTINCT callId, callerNo FROM tBillLog061  WHERE deviceType=1 AND partid='0601' AND callerNo!='12345' AND WAITBEGIN <=? and WAITBEGIN <=?) t ");
		sqlString.append(" GROUP BY callerNo ");
		sqlString.append(" ORDER  BY COUNT(1) DESC ");
		Query createNativeQuery = em.createNativeQuery(sqlString.toString());
		createNativeQuery.setParameter(1, waitBegin);
		createNativeQuery.setParameter(2, lastWaitBegin);
		List<Object[]> resultList = (List<Object[]>)createNativeQuery.getResultList();
		return resultList;
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
	public int insertTSpecialCustomer(String userid,String callerno) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append(" insert into tspecialcustomer (callerno,userid,subccno,vdn ) values (?,?,1,1)");
		Query createNativeQuery = em.createNativeQuery(sqlString.toString());
		createNativeQuery.setParameter(1, userid);
		createNativeQuery.setParameter(2,callerno);
		int executeUpdate = createNativeQuery.executeUpdate();
		return executeUpdate;
	}
}
