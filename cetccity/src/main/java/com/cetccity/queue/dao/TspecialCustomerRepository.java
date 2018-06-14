package com.cetccity.queue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cetccity.queue.dao.model.Tbilllog061;
import com.cetccity.queue.dao.model.TspecialCustomer;

@Repository
public interface TspecialCustomerRepository extends 	JpaRepository<TspecialCustomer, String>{

	@Query(value="SELECT userid FROM TSPECIALCUSTOMER where CALLERNO=:callerno",nativeQuery=true)  
    public String getUserid(@Param("callerno") String callerno);  
	
//	@Query("select p from Person p where p.name=:name and p.address=:address")
//	TCustLevel withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);
	
	@Modifying
    @Query(value = "update t_sys_user set status=0 where user_id=?1",nativeQuery = true)
    int updateUserStatus(@Param("user_id") String user_id);
	
}
