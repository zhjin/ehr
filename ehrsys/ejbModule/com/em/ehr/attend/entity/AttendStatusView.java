/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import java.util.Date;

public class AttendStatusView extends AttendStatus {
	private String loginName;
	private String name;
	private long depId;
	private long position;
	private long jobId;
	private long sex;
	private long empStatus;
	private long empType;
	private Date joinDate;
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
	public long getPosition() {
		return position;
	}
	public void setPosition(long position) {
		this.position = position;
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
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
