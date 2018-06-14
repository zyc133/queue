//package com.cetccity.queue.dao.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import com.cetccity.queue.dao.Tbilllog061Repository;
//
//@Service
//public class Tbilllog061RepositoryImpl implements Tbilllog061Repository {
//	
//	@Autowired
//	protected EntityManager em;
//
//	@Override
//	public List<Object[]> getCount() {
//		
//		String sqlString="SELECT t.callerNo, COUNT(1) call_count " + 
//				"	FROM (SELECT DISTINCT callId, callerNo FROM tBillLog061  WHERE deviceType=1 AND partid='0604' AND callerNo!='12345') t " + 
//				"	GROUP BY callerNo\r\n" + 
//				"	ORDER  BY COUNT(1) DESC";
//		Query createNativeQuery = em.createNativeQuery(sqlString);
//		
//		List<Object[]> resultList = (List<Object[]>)createNativeQuery.getResultList();
//		
//		return resultList;
//	}
//
//}
