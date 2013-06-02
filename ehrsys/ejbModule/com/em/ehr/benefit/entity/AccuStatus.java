/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.benefit.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class AccuStatus extends EntityBase {

	/**
	 * 员工标识
	 */
	@Id
	private long empId;
	
	/**
	 * 公积金状态
	 */
	@Column
	private boolean accuEnabled;
	
	@Column
	private long accuCompany;
	
	/**
	 * 公积金缴纳城市
	 */
	@Column
	private long accuCity;

	/**
	 * 公积金基数
	 */
	@Column(precision = 10, scale = 2)
	private BigDecimal accuBase;

	/**
	 * 公积金个人编号
	 */
	@Column(length=40)
	private String accuNo;

	/**
	 * 建立时间
	 */
	@Column
	private Date accuFirstDate;
	
	@Column
	private Date createDate;

	/**
	 * 建立类型(新建,转入)
	 */
	@Column
	private long createType;

	/**
	 * 停止时间
	 */
	@Column
	private Date stopDate;

	/**
	 * 停止类型(停止,转出)
	 */
	@Column
	private long stopType;

	/**
	 * 停止原因
	 */
	@Column
	private long stopReason;

	/**
	 * 购房
	 */
	@Column
	private long buyHouse;

	/**
	 * 贷款类型(一次性,分期)
	 */
	@Column
	private long loanType;

	/**
	 * 帐户余额
	 */
	@Column(precision = 10, scale = 2)
	private BigDecimal accuMoney;
	
	@Column(length = 120)
	private String accuRemark;
	
	@Column(length = 255)
	private String remark;

	@Override
	public String getRowKey() {
		return String.valueOf(this.empId);
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public boolean isAccuEnabled() {
		return accuEnabled;
	}

	public void setAccuEnabled(boolean accuEnabled) {
		this.accuEnabled = accuEnabled;
	}

	public long getAccuCompany() {
		return accuCompany;
	}

	public void setAccuCompany(long accuCompany) {
		this.accuCompany = accuCompany;
	}

	public long getAccuCity() {
		return accuCity;
	}

	public void setAccuCity(long accuCity) {
		this.accuCity = accuCity;
	}

	public BigDecimal getAccuBase() {
		return accuBase;
	}

	public void setAccuBase(BigDecimal accuBase) {
		this.accuBase = accuBase;
	}

	public String getAccuNo() {
		return accuNo;
	}

	public void setAccuNo(String accuNo) {
		this.accuNo = accuNo;
	}

	public Date getAccuFirstDate() {
		return accuFirstDate;
	}

	public void setAccuFirstDate(Date accuFirstDate) {
		this.accuFirstDate = accuFirstDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getCreateType() {
		return createType;
	}

	public void setCreateType(long createType) {
		this.createType = createType;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public long getStopType() {
		return stopType;
	}

	public void setStopType(long stopType) {
		this.stopType = stopType;
	}

	public long getStopReason() {
		return stopReason;
	}

	public void setStopReason(long stopReason) {
		this.stopReason = stopReason;
	}

	public long getBuyHouse() {
		return buyHouse;
	}

	public void setBuyHouse(long buyHouse) {
		this.buyHouse = buyHouse;
	}

	public long getLoanType() {
		return loanType;
	}

	public void setLoanType(long loanType) {
		this.loanType = loanType;
	}

	public BigDecimal getAccuMoney() {
		return accuMoney;
	}

	public void setAccuMoney(BigDecimal accuMoney) {
		this.accuMoney = accuMoney;
	}

	public String getAccuRemark() {
		return accuRemark;
	}

	public void setAccuRemark(String accuRemark) {
		this.accuRemark = accuRemark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
