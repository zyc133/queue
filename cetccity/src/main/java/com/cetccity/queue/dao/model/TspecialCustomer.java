package com.cetccity.queue.dao.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tspecialcustomer")
public class TspecialCustomer {
	@Column
	@Id
    private String callerno;

	@Column
    private String userid;

	@Column
    private String username;
	
	@Column
    private String cataloglanguage;
	
	@Column
    private String company;

	@Column
    private String address;

	@Column
    private String area;

	@Column
    private String userinfo;

	@Column
    private String flowno;

	@Column
    private String skilldesc;

	@Column
    private BigDecimal agentid;

	@Column
    private String emailaddr;

	@Column
    private String webaddr;

	@Column
    private BigDecimal subccno;

	@Column
    private BigDecimal vdn;

    public String getCallerno() {
        return callerno;
    }

    public void setCallerno(String callerno) {
        this.callerno = callerno == null ? null : callerno.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCataloglanguage() {
        return cataloglanguage;
    }

    public void setCataloglanguage(String cataloglanguage) {
        this.cataloglanguage = cataloglanguage == null ? null : cataloglanguage.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo == null ? null : userinfo.trim();
    }

    public String getFlowno() {
        return flowno;
    }

    public void setFlowno(String flowno) {
        this.flowno = flowno == null ? null : flowno.trim();
    }

    public String getSkilldesc() {
        return skilldesc;
    }

    public void setSkilldesc(String skilldesc) {
        this.skilldesc = skilldesc == null ? null : skilldesc.trim();
    }

    public BigDecimal getAgentid() {
        return agentid;
    }

    public void setAgentid(BigDecimal agentid) {
        this.agentid = agentid;
    }

    public String getEmailaddr() {
        return emailaddr;
    }

    public void setEmailaddr(String emailaddr) {
        this.emailaddr = emailaddr == null ? null : emailaddr.trim();
    }

    public String getWebaddr() {
        return webaddr;
    }

    public void setWebaddr(String webaddr) {
        this.webaddr = webaddr == null ? null : webaddr.trim();
    }

    public BigDecimal getSubccno() {
        return subccno;
    }

    public void setSubccno(BigDecimal subccno) {
        this.subccno = subccno;
    }

    public BigDecimal getVdn() {
        return vdn;
    }

    public void setVdn(BigDecimal vdn) {
        this.vdn = vdn;
    }
}