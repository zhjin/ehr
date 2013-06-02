/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonWork extends EmployeePersonBaseEntity {
	@Column
	private Date beginTime;
	
	@Column
	private Date endTime;
	
	@Column(length=100)
	private String workPlace;
	
	@Column(length=100)
	private String workAddress;
	
	@Column(length=60)
	private String workJob;
	
	@Column(length=255)
	private String workContent;
	
	@Column(length=100)
	private String leaveReason;
	
	@Column(length=80)
	private String proveMan;
	
	@Column(length=60)
	private String proveManTele;
	
	@Column(length=100)
	private String workDepName;

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getProveMan() {
		return proveMan;
	}

	public void setProveMan(String proveMan) {
		this.proveMan = proveMan;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public String getWorkJob() {
		return workJob;
	}

	public void setWorkJob(String workJob) {
		this.workJob = workJob;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getProveManTele() {
		return proveManTele;
	}

	public void setProveManTele(String proveManTele) {
		this.proveManTele = proveManTele;
	}

	public String getWorkDepName() {
		return workDepName;
	}

	public void setWorkDepName(String workDepName) {
		this.workDepName = workDepName;
	}
	
}
