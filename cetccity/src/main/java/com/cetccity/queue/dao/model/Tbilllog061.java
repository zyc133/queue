package com.cetccity.queue.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbilllog061")
public class Tbilllog061 {
	
	@Column
	@Id
    private String partid;

	@Column
    private String callid;

	@Column
    private Short callidnum;

	@Column
    private String callerno;

	@Column
    private String calleeno;

	@Column
    private Date waitbegin;

	@Column
    private Date waitend;

	@Column
    private Date ackbegin;

	@Column
    private Date ackend;

	@Column
    private Date callbegin;

	@Column
    private Date callend;

	@Column
    private Integer serviceno;

	@Column
    private Integer trkno;

	@Column
    private Short trkgrpno;

	@Column
    private Short modno;

	@Column
    private Short devicetype;

	@Column
    private Integer deviceno;

	@Column
    private String devicein;

	@Column
    private Short calltype;

	@Column
    private Short waitcause;

	@Column
    private Integer releasecause;

	@Column
    private Integer subccno;

	@Column
    private Short vdn;

	@Column
    private Short mediatype;

	@Column
    private Long uvid;

	@Column
    private Integer orgccno;

	@Column
    private String orgcallid;

	@Column
    private String orgcalleeno;

	@Column
    private Integer orgserviceno;

	@Column
    private Integer serccno;

	@Column
    private Integer serservice;

	@Column
    private Short userlevel;

	@Column
    private Short usertype;

	@Column
    private Long callincause;
	
	@Column
    private Long enterreason;

	@Column
    private Long leavereason;

	@Column
    private Long billinfo;

	@Column
    private Long preserviceno;

	@Column
    private Long predevicetype;

	@Column
    private Long predeviceno;

	@Column
    private String predevicein;

	@Column
    private Long mediainfotype;

	@Column
    private Long skillid;

	@Column
    private Integer locationid;

	@Column
	private Long billinfo1;

	@Column
    private Long billinfo2;

	@Column
    private Long billinfo3;

	@Column
    private Long billinfo4;

	@Column
    private String obsserviceid;

	@Column
    private String obsuniqueid;

	@Column
    private Integer currentskillid;

	@Column
    private Short uapid;

	@Column
    private Integer netentid;

	@Column
    private Short submediatype;

	@Column
    private Short initvdnid;

	
    public String getPartid() {
        return partid;
    }

    
    //setter and getter
    public void setPartid(String partid) {
        this.partid = partid == null ? null : partid.trim();
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid == null ? null : callid.trim();
    }

    public Short getCallidnum() {
        return callidnum;
    }

    public void setCallidnum(Short callidnum) {
        this.callidnum = callidnum;
    }

    public String getCallerno() {
        return callerno;
    }

    public void setCallerno(String callerno) {
        this.callerno = callerno == null ? null : callerno.trim();
    }

    public String getCalleeno() {
        return calleeno;
    }

    public void setCalleeno(String calleeno) {
        this.calleeno = calleeno == null ? null : calleeno.trim();
    }

    public Date getWaitbegin() {
        return waitbegin;
    }

    public void setWaitbegin(Date waitbegin) {
        this.waitbegin = waitbegin;
    }

    public Date getWaitend() {
        return waitend;
    }

    public void setWaitend(Date waitend) {
        this.waitend = waitend;
    }

    public Date getAckbegin() {
        return ackbegin;
    }

    public void setAckbegin(Date ackbegin) {
        this.ackbegin = ackbegin;
    }

    public Date getAckend() {
        return ackend;
    }

    public void setAckend(Date ackend) {
        this.ackend = ackend;
    }

    public Date getCallbegin() {
        return callbegin;
    }

    public void setCallbegin(Date callbegin) {
        this.callbegin = callbegin;
    }

    public Date getCallend() {
        return callend;
    }

    public void setCallend(Date callend) {
        this.callend = callend;
    }

    public Integer getServiceno() {
        return serviceno;
    }

    public void setServiceno(Integer serviceno) {
        this.serviceno = serviceno;
    }

    public Integer getTrkno() {
        return trkno;
    }

    public void setTrkno(Integer trkno) {
        this.trkno = trkno;
    }

    public Short getTrkgrpno() {
        return trkgrpno;
    }

    public void setTrkgrpno(Short trkgrpno) {
        this.trkgrpno = trkgrpno;
    }

    public Short getModno() {
        return modno;
    }

    public void setModno(Short modno) {
        this.modno = modno;
    }

    public Short getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(Short devicetype) {
        this.devicetype = devicetype;
    }

    public Integer getDeviceno() {
        return deviceno;
    }

    public void setDeviceno(Integer deviceno) {
        this.deviceno = deviceno;
    }

    public String getDevicein() {
        return devicein;
    }

    public void setDevicein(String devicein) {
        this.devicein = devicein == null ? null : devicein.trim();
    }

    public Short getCalltype() {
        return calltype;
    }

    public void setCalltype(Short calltype) {
        this.calltype = calltype;
    }

    public Short getWaitcause() {
        return waitcause;
    }

    public void setWaitcause(Short waitcause) {
        this.waitcause = waitcause;
    }

    public Integer getReleasecause() {
        return releasecause;
    }

    public void setReleasecause(Integer releasecause) {
        this.releasecause = releasecause;
    }

    public Integer getSubccno() {
        return subccno;
    }

    public void setSubccno(Integer subccno) {
        this.subccno = subccno;
    }

    public Short getVdn() {
        return vdn;
    }

    public void setVdn(Short vdn) {
        this.vdn = vdn;
    }

    public Short getMediatype() {
        return mediatype;
    }

    public void setMediatype(Short mediatype) {
        this.mediatype = mediatype;
    }

    public Long getUvid() {
        return uvid;
    }

    public void setUvid(Long uvid) {
        this.uvid = uvid;
    }

    public Integer getOrgccno() {
        return orgccno;
    }

    public void setOrgccno(Integer orgccno) {
        this.orgccno = orgccno;
    }

    public String getOrgcallid() {
        return orgcallid;
    }

    public void setOrgcallid(String orgcallid) {
        this.orgcallid = orgcallid == null ? null : orgcallid.trim();
    }

    public String getOrgcalleeno() {
        return orgcalleeno;
    }

    public void setOrgcalleeno(String orgcalleeno) {
        this.orgcalleeno = orgcalleeno == null ? null : orgcalleeno.trim();
    }

    public Integer getOrgserviceno() {
        return orgserviceno;
    }

    public void setOrgserviceno(Integer orgserviceno) {
        this.orgserviceno = orgserviceno;
    }

    public Integer getSerccno() {
        return serccno;
    }

    public void setSerccno(Integer serccno) {
        this.serccno = serccno;
    }

    public Integer getSerservice() {
        return serservice;
    }

    public void setSerservice(Integer serservice) {
        this.serservice = serservice;
    }

    public Short getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(Short userlevel) {
        this.userlevel = userlevel;
    }

    public Short getUsertype() {
        return usertype;
    }

    public void setUsertype(Short usertype) {
        this.usertype = usertype;
    }

    public Long getCallincause() {
        return callincause;
    }

    public void setCallincause(Long callincause) {
        this.callincause = callincause;
    }

    public Long getEnterreason() {
        return enterreason;
    }

    public void setEnterreason(Long enterreason) {
        this.enterreason = enterreason;
    }

    public Long getLeavereason() {
        return leavereason;
    }

    public void setLeavereason(Long leavereason) {
        this.leavereason = leavereason;
    }

    public Long getBillinfo() {
        return billinfo;
    }

    public void setBillinfo(Long billinfo) {
        this.billinfo = billinfo;
    }

    public Long getPreserviceno() {
        return preserviceno;
    }

    public void setPreserviceno(Long preserviceno) {
        this.preserviceno = preserviceno;
    }

    public Long getPredevicetype() {
        return predevicetype;
    }

    public void setPredevicetype(Long predevicetype) {
        this.predevicetype = predevicetype;
    }

    public Long getPredeviceno() {
        return predeviceno;
    }

    public void setPredeviceno(Long predeviceno) {
        this.predeviceno = predeviceno;
    }

    public String getPredevicein() {
        return predevicein;
    }

    public void setPredevicein(String predevicein) {
        this.predevicein = predevicein == null ? null : predevicein.trim();
    }

    public Long getMediainfotype() {
        return mediainfotype;
    }

    public void setMediainfotype(Long mediainfotype) {
        this.mediainfotype = mediainfotype;
    }

    public Long getSkillid() {
        return skillid;
    }

    public void setSkillid(Long skillid) {
        this.skillid = skillid;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public Long getBillinfo1() {
        return billinfo1;
    }

    public void setBillinfo1(Long billinfo1) {
        this.billinfo1 = billinfo1;
    }

    public Long getBillinfo2() {
        return billinfo2;
    }

    public void setBillinfo2(Long billinfo2) {
        this.billinfo2 = billinfo2;
    }

    public Long getBillinfo3() {
        return billinfo3;
    }

    public void setBillinfo3(Long billinfo3) {
        this.billinfo3 = billinfo3;
    }

    public Long getBillinfo4() {
        return billinfo4;
    }

    public void setBillinfo4(Long billinfo4) {
        this.billinfo4 = billinfo4;
    }

    public String getObsserviceid() {
        return obsserviceid;
    }

    public void setObsserviceid(String obsserviceid) {
        this.obsserviceid = obsserviceid == null ? null : obsserviceid.trim();
    }

    public String getObsuniqueid() {
        return obsuniqueid;
    }

    public void setObsuniqueid(String obsuniqueid) {
        this.obsuniqueid = obsuniqueid == null ? null : obsuniqueid.trim();
    }

    public Integer getCurrentskillid() {
        return currentskillid;
    }

    public void setCurrentskillid(Integer currentskillid) {
        this.currentskillid = currentskillid;
    }

    public Short getUapid() {
        return uapid;
    }

    public void setUapid(Short uapid) {
        this.uapid = uapid;
    }

    public Integer getNetentid() {
        return netentid;
    }

    public void setNetentid(Integer netentid) {
        this.netentid = netentid;
    }

    public Short getSubmediatype() {
        return submediatype;
    }

    public void setSubmediatype(Short submediatype) {
        this.submediatype = submediatype;
    }

    public Short getInitvdnid() {
        return initvdnid;
    }

    public void setInitvdnid(Short initvdnid) {
        this.initvdnid = initvdnid;
    }
}