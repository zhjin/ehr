/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.entity.OperateDataBase;

/**
 * 员工转正参数
 * @author zhjin
 *
 */
@Entity
public class EmployeeChangeNormalArg extends OperateDataBase {
	
	/**
	 * 公司
	 */
	@Column
	private long company;

	
	/**
	 * 岗位
	 */
	@Column
	private long jobId;
	
	/**
	 * 员工状态
	 */
	@Column
	private long empStatus;
	
	@Column
	private long empType;
	
	/**
	 * 入职时间
	 */
	@Column
	private Date joinDate;
	
	/**
	 * 试用期
	 */
	@Column
	private int probationNumber;
	
	/**
	 * 转正日期
	 */
	@Column
	private Date changeNormalDate;

	@Override
	public void insertCheck() throws Exception {
		
		if (this.changeNormalDate == null) {
			throw new Exception("转正日期不能为空");
		}
		
		if (this.changeNormalDate.before(joinDate)) {
			throw new Exception("转正日期必须在入职日期之后");
		}

	}

	public long getCompany() {
		return company;
	}

	public void setCompany(long company) {
		this.company = company;
	}

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

}