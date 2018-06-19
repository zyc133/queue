package com.cetccity.queue.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_conf")
public class SysConf {

	@Column
	@Id
	private String name;
	
	@Column
	private Date lastwaitbegin;
	
	private Date waitBegin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastwaitbegin() {
		return lastwaitbegin;
	}

	public void setLastwaitbegin(Date lastwaitbegin) {
		this.lastwaitbegin = lastwaitbegin;
	}

	public Date getWaitBegin() {
		return waitBegin;
	}

	public void setWaitBegin(Date waitBegin) {
		this.waitBegin = waitBegin;
	}
	
}
