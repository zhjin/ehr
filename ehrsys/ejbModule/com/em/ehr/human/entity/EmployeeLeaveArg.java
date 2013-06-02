/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.entity.OperateDataBase;

@Entity
public class EmployeeLeaveArg extends OperateDataBase {
	
	/**
	 * 公司
	 */
	@Column
	private long company;

	/**
	 * 员工状态
	 */
	@Column
	private long empStatus;

	/**
	 * 岗位
	 */
	@Column
	private long jobId;

	/**
	 * 员工类型
	 */
	@Column
	private long empType;

	/**
	 * 入职日期
	 */
	@Column
	private Date joinDate;

	/**
	 * 薪资截止日
	 */
	@Column
	private Date stopPayDate;

	/**
	 * 离职日期
	 */
	@Column
	private Date leaveDate;

	/**
	 * 离职类型
	 */
	@Column
	private long leaveType;

	/**
	 * 离职原因
	 */
	@Column
	private long leaveReason;

	/**
	 * 离职补偿
	 */
	@Column(precision = 10, scale = 2)
	private BigDecimal leaveCompensate;

	/**
	 * 违约金
	 */
	@Column(precision = 10, scale = 2)
	private BigDecimal leaveBreach;

	/**
	 * 合同终止
	 */
	@Column
	private boolean stopBargain;

	/**
	 * 离职办妥
	 */
	@Column
	private boolean leaveFinish;

	@Override
	public void insertCheck() throws Exception{
		
		if (this.leaveDate == null) {
			throw new Exception("请输入离职日期");
		}
		
		if (this.leaveType == 0) {
			throw new Exception("请选择离职类型");
		}
		
		if (this.leaveReason == 0) {
			throw new Exception("请选择离职原因");
		}
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

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
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

	public Date getStopPayDate() {
		return stopPayDate;
	}

	public void setStopPayDate(Date stopPayDate) {
		this.stopPayDate = stopPayDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public long getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(long leaveType) {
		this.leaveType = leaveType;
	}

	public long getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(long leaveReason) {
		this.leaveReason = leaveReason;
	}

	public BigDecimal getLeaveCompensate() {
		return leaveCompensate;
	}

	public void setLeaveCompensate(BigDecimal leaveCompensate) {
		this.leaveCompensate = leaveCompensate;
	}

	public BigDecimal getLeaveBreach() {
		return leaveBreach;
	}

	public void setLeaveBreach(BigDecimal leaveBreach) {
		this.leaveBreach = leaveBreach;
	}

	public boolean isStopBargain() {
		return stopBargain;
	}

	public void setStopBargain(boolean stopBargain) {
		this.stopBargain = stopBargain;
	}

	public boolean isLeaveFinish() {
		return leaveFinish;
	}

	public void setLeaveFinish(boolean leaveFinish) {
		this.leaveFinish = leaveFinish;
	}
	
}