/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonLearn extends EmployeePersonBaseEntity {
	@Column
	private Date beginTime;
	
	@Column
	private Date endTime;
	
	@Column(length=100)
	private String learnCourse;
	
	@Column(length=100)
	private String learnContent;
	
	@Column(length=100)
	private String learnAddress;
	
	@Column(length=100)
	private String learnPlace;
	
	@Column(length=100)
	private String learnMode;
	
	@Column(length=100)
	private String learnType;
	
	@Column(length=100)
	private String learnResult;
	
	@Column(length=100)
	private String certNo;

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLearnAddress() {
		return learnAddress;
	}

	public void setLearnAddress(String learnAddress) {
		this.learnAddress = learnAddress;
	}

	public String getLearnContent() {
		return learnContent;
	}

	public void setLearnContent(String learnContent) {
		this.learnContent = learnContent;
	}

	public String getLearnPlace() {
		return learnPlace;
	}

	public void setLearnPlace(String learnPlace) {
		this.learnPlace = learnPlace;
	}

	public String getLearnType() {
		return learnType;
	}

	public void setLearnType(String learnType) {
		this.learnType = learnType;
	}

	public String getLearnCourse() {
		return learnCourse;
	}

	public void setLearnCourse(String learnCourse) {
		this.learnCourse = learnCourse;
	}

	public String getLearnMode() {
		return learnMode;
	}

	public void setLearnMode(String learnMode) {
		this.learnMode = learnMode;
	}

	public String getLearnResult() {
		return learnResult;
	}

	public void setLearnResult(String learnResult) {
		this.learnResult = learnResult;
	}
	
}
