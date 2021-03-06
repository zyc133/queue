package com.cetccity.queue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cetccity.queue.dao.model.SysConf;
import com.cetccity.queue.dao.model.Tbilllog061;

@Repository
public interface SysConfRepository extends 	JpaRepository<SysConf, String> {

	
	@Query(value="select t.name,t.lastwaitbegin,sysdate as waitBegin from T_SYS_CONF t where name =:name",nativeQuery=true)  
    public List<Object[]> getConfig(@Param("name") String name);
}
