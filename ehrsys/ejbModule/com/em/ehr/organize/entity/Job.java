/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.organize.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.TreeEntityBase;
import com.zhjin.util.Utility;

@Entity
public class Job extends TreeEntityBase{

	@Column
	private long depId;

	@Column(length=180)
	private String description;

	@Column
	private long jobLevel;

	@Column
	private long jobType;

	@Column
	private int budNumber;

	@Column
	private long positionCode;

	@Column
	private long positionLevelCode;

	@Column
	private long positionTypeCode;

	@Column
	private Date createDate;

	@Column
	private Date destoryDate;

	@Column(precision = 10, scale = 2)
	private BigDecimal jobPay;

	@Column(precision = 10, scale = 2)
	private BigDecimal jobPay1;

	@Column(precision = 10, scale = 2)
	private BigDecimal jobPay2;

	@Column(precision = 10, scale = 2)
	private BigDecimal jobPay3;

	@Column(precision = 10, scale = 2)
	private BigDecimal jobPay4;

	@Column(precision = 10, scale = 2)
	private BigDecimal jobPay5;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDestoryDate() {
		return destoryDate;
	}

	public void setDestoryDate(Date destoryDate) {
		this.destoryDate = destoryDate;
	}

	public long getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(long jobLevel) {
		this.jobLevel = jobLevel;
	}

	public long getJobType() {
		return jobType;
	}

	public void setJobType(long jobType) {
		this.jobType = jobType;
	}

	public long getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(long positionCode) {
		this.positionCode = positionCode;
	}

	public long getPositionLevelCode() {
		return positionLevelCode;
	}

	public void setPositionLevelCode(long positionLevelCode) {
		this.positionLevelCode = positionLevelCode;
	}

	public long getPositionTypeCode() {
		return positionTypeCode;
	}

	public void setPositionTypeCode(long positionTypeCode) {
		this.positionTypeCode = positionTypeCode;
	}

	public int getBudNumber() {
		return budNumber;
	}

	public void setBudNumber(int budNumber) {
		this.budNumber = budNumber;
	}

	public BigDecimal getJobPay() {
		return jobPay;
	}

	public void setJobPay(BigDecimal jobPay) {
		this.jobPay = jobPay;
	}

	public BigDecimal getJobPay1() {
		return jobPay1;
	}

	public void setJobPay1(BigDecimal jobPay1) {
		this.jobPay1 = jobPay1;
	}

	public BigDecimal getJobPay2() {
		return jobPay2;
	}

	public void setJobPay2(BigDecimal jobPay2) {
		this.jobPay2 = jobPay2;
	}

	public BigDecimal getJobPay3() {
		return jobPay3;
	}

	public void setJobPay3(BigDecimal jobPay3) {
		this.jobPay3 = jobPay3;
	}

	public BigDecimal getJobPay4() {
		return jobPay4;
	}

	public void setJobPay4(BigDecimal jobPay4) {
		this.jobPay4 = jobPay4;
	}

	public BigDecimal getJobPay5() {
		return jobPay5;
	}

	public void setJobPay5(BigDecimal jobPay5) {
		this.jobPay5 = jobPay5;
	}

	@Override
	public void deleteCheck() throws Exception {
		super.deleteCheck();
		System.out.println("abc");
		HashMap<String, Object> arg = new HashMap<String, Object>();
		arg.put("highId", this.getId());
		// 是否存在下级岗位
		if (Utility.getDBUtility().getRecordCount("select count(*) from job where highId = :highId and enabled = 1", arg) > 0) {
			throw new Exception(this.getLabel() + "存在下级岗位，不能删除！");
		}

		// 是否存在在职员工
		if (Utility.getDBUtility().getRecordCount("select count(*) from employeeactiveview where jobid = :highId", arg) > 0) {
			throw new Exception(this.getLabel() + "有在职员工，不能删除！");
		}
	}
	
}
