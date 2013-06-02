/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.salary.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class DepartmentPayArg extends EntityBase {
	
	@Id
	private long depId;
	
	@Column
	private boolean submit;
	
	@Column
	private Date submitTime;
	
	@Column
	private long submitEmpId;
	
	@Column(length=40)
	private String submitLoginName;
	
	@Column(length=20)
	private String submitName;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal v1;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal v2;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal v3;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal v4;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal v5;
	
	@Column(length=120)
	private String remark;

	public BigDecimal getV1() {
		return v1;
	}

	public void setV1(BigDecimal v1) {
		this.v1 = v1;
	}

	public BigDecimal getV2() {
		return v2;
	}

	public void setV2(BigDecimal v2) {
		this.v2 = v2;
	}

	public BigDecimal getV3() {
		return v3;
	}

	public void setV3(BigDecimal v3) {
		this.v3 = v3;
	}

	public BigDecimal getV4() {
		return v4;
	}

	public void setV4(BigDecimal v4) {
		this.v4 = v4;
	}

	public BigDecimal getV5() {
		return v5;
	}

	public void setV5(BigDecimal v5) {
		this.v5 = v5;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isSubmit() {
		return submit;
	}

	public void setSubmit(boolean submit) {
		this.submit = submit;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getSubmitLoginName() {
		return submitLoginName;
	}

	public void setSubmitLoginName(String submitLoginName) {
		this.submitLoginName = submitLoginName;
	}

	public String getSubmitName() {
		return submitName;
	}

	public void setSubmitName(String submitName) {
		this.submitName = submitName;
	}

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public long getSubmitEmpId() {
		return submitEmpId;
	}

	public void setSubmitEmpId(long submitEmpId) {
		this.submitEmpId = submitEmpId;
	}

	@Override
	public String getRowKey() {
		return String.valueOf(this.depId);
	}
	
}
