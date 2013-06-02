/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class Employee extends EntityBase {

	@Id
	private long id;
	
	@Column(length=40,nullable=false)
	private String name;
	
	@Column(length=60,nullable=false,unique=true)
	private String loginName;
	
	@Column(length=40)
	private String badge;

	@Column
	private long depId;
	
	@Column
	private long jobId;
	
	@Column
	private long position;
	
	@Column
	private long positionType;
	
	@Column
	private long positionLevel;

	@Column
	private long area;
	
	@Column
	private long company;

	@Column
	private long empStatus;
	
	@Column
	private long empType;
	
	@Column
	private Date beginDate;
	
	@Column
	private int probationNumber;
	
	@Column
	private Date changeNormalDate;
	
	@Column
	private Date leaveDate;
	
	@Column
	private Date stopPayDate;
	
	@Column
	private long bargainCompany;
	
	@Column
	private long bargainType;
	
	@Column
	private boolean backCheck;
	
	@Column
	private Date bargainBeginDate;
	
	@Column
	private Date bargainEndDate;
	
	@Column
	private boolean expedite = false;
	
	@Column
	private long expediteDepId;
	
	@Column
	private boolean sendOut;
	
	@Column
	private long country;
	
	@Column
	private long guideEmpId;
	
	@Column(length=40)
	private String guideLoginName;
	
	@Column(length=20)
	private String guideName;
	
	@Column
	private long channel;

	@Override
	public String getRowKey() {
		return Long.toString(id);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public long getPositionType() {
		return positionType;
	}

	public void setPositionType(long positionType) {
		this.positionType = positionType;
	}

	public long getPositionLevel() {
		return positionLevel;
	}

	public void setPositionLevel(long positionLevel) {
		this.positionLevel = positionLevel;
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	public long getCompany() {
		return company;
	}

	public void setCompany(long company) {
		this.company = company;
	}

	public long getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(long empStatus) {
		this.empStatus = empStatus;
	}

	public long getEmpType() {
		return empType;
	}

	public void setEmpType(long empType) {
		this.empType = empType;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public int getProbationNumber() {
		return probationNumber;
	}

	public void setProbationNumber(int probationNumber) {
		this.probationNumber = probationNumber;
	}

	public Date getChangeNormalDate() {
		return changeNormalDate;
	}

	public void setChangeNormalDate(Date changeNormalDate) {
		this.changeNormalDate = changeNormalDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public Date getStopPayDate() {
		return stopPayDate;
	}

	public void setStopPayDate(Date stopPayDate) {
		this.stopPayDate = stopPayDate;
	}

	public long getBargainCompany() {
		return bargainCompany;
	}

	public void setBargainCompany(long bargainCompany) {
		this.bargainCompany = bargainCompany;
	}

	public long getBargainType() {
		return bargainType;
	}

	public void setBargainType(long bargainType) {
		this.bargainType = bargainType;
	}

	public boolean isBackCheck() {
		return backCheck;
	}

	public void setBackCheck(boolean backCheck) {
		this.backCheck = backCheck;
	}

	public Date getBargainBeginDate() {
		return bargainBeginDate;
	}

	public void setBargainBeginDate(Date bargainBeginDate) {
		this.bargainBeginDate = bargainBeginDate;
	}

	public Date getBargainEndDate() {
		return bargainEndDate;
	}

	public void setBargainEndDate(Date bargainEndDate) {
		this.bargainEndDate = bargainEndDate;
	}

	public boolean isExpedite() {
		return expedite;
	}

	public void setExpedite(boolean expedite) {
		this.expedite = expedite;
	}

	public long getExpediteDepId() {
		return expediteDepId;
	}

	public void setExpediteDepId(long expediteDepId) {
		this.expediteDepId = expediteDepId;
	}

	public boolean isSendOut() {
		return sendOut;
	}

	public void setSendOut(boolean sendOut) {
		this.sendOut = sendOut;
	}

	public long getCountry() {
		return country;
	}

	public void setCountry(long country) {
		this.country = country;
	}

	public long getGuideEmpId() {
		return guideEmpId;
	}

	public void setGuideEmpId(long guideEmpId) {
		this.guideEmpId = guideEmpId;
	}

	public String getGuideLoginName() {
		return guideLoginName;
	}

	public void setGuideLoginName(String guideLoginName) {
		this.guideLoginName = guideLoginName;
	}

	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public long getChannel() {
		return channel;
	}

	public void setChannel(long channel) {
		this.channel = channel;
	}
	
}
