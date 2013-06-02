/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.zhjin.base.EntityHasIdBase;

@MappedSuperclass
public class OperateDataBase extends EntityHasIdBase {
	
	@Column(nullable = false)
	private long operEmpId;
	
	@Column(length=60)
	private String operLoginName;
	
	@Column(length=40)
	private String operName;
	
	@Column
	private Date operTime;
		
	@Column(nullable = false)
	private long empId;
	
	@Column(length=60)
	private String loginName;
	
	@Column(length=40)
	private String name;
	
	@Column(nullable = false)
	private long depId;
	
	@Column(length=120)
	private String remark;
	
	@Column(length=40)
	private String wfInstanceId;

	@PrePersist
	@PreUpdate
	public void save() throws Exception {
		insertCheck();
		if (this.operTime == null) {
			this.operTime = new Date();
		}
	}

	public long getOperEmpId() {
		return operEmpId;
	}

	public void setOperEmpId(long operEmpId) {
		this.operEmpId = operEmpId;
	}

	public String getOperLoginName() {
		return operLoginName;
	}

	public void setOperLoginName(String operLoginName) {
		this.operLoginName = operLoginName;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWfInstanceId() {
		return wfInstanceId;
	}

	public void setWfInstanceId(String wfInstanceId) {
		this.wfInstanceId = wfInstanceId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

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
	
}
