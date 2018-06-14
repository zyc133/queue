package com.cetccity.queue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cetccity.queue.dao.model.Tbilllog061;

@Repository
public interface Tbilllog061Repository extends 	JpaRepository<Tbilllog061, String>{

	@Query(value="SELECT count(partid) FROM TBILLLOG061 where partid=:partid",nativeQuery=true)  
    public long getTotalCount(@Param("partid") String partid);  
	
//	@Query("select p from Person p where p.name=:name and p.address=:address")
//	TCustLevel withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);
	
	@Modifying
    @Query(value = "update TBILLLOG061 set DEVICETYPE=0 where  CALLERNO=?1",nativeQuery = true)
    int updateUserStatus(String callerno);
	
}
