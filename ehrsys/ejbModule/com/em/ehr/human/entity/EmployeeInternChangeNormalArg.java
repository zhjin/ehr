/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.entity.OperateDataBase;

@Entity
public class EmployeeInternChangeNormalArg extends OperateDataBase {
	
	@Column
	private long jobId;
	
	@Column
	private long empStatus;
	
	@Column
	private long empType;

	@Column
	private Date joinDate;
	
	@Column
	private Date changeNormalDate;

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
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

	public Date getChangeNormalDate() {
		return changeNormalDate;
	}

	public void setChangeNormalDate(Date changeNormalDate) {
		this.changeNormalDate = changeNormalDate;
	}

}
