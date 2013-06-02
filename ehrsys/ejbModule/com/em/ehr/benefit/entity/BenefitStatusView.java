/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.benefit.entity;

import java.util.Date;

public class BenefitStatusView extends BenefitStatus {
	private String loginName;
	private String name;
	private long depId;
	private long position;
	private long positionType;
	private long positionLevel;
	private long jobId;
	private long sex;
	private int age;
	private long empStatus;
	private long empType;
	private Date beginDate;
	private String code;
	private long residence;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public long getSex() {
		return sex;
	}
	public void setSex(long sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getResidence() {
		return residence;
	}
	public void setResidence(long residence) {
		this.residence = residence;
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
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
}
