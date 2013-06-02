/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.benefit.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.em.ehr.base.BenefitCalcPK;
import com.zhjin.base.EntityBase;

@Entity
@IdClass(value = BenefitCalcPK.class)
public class AccuCalc extends EntityBase {
	
	@Id
	private Date calcMonth;
	
	@Id
	private long empId;
	
	@Id 
	private long company;
	
	@Id
	private long area;
	
	@Column(length=40)
	private String loginName;
	
	@Column(length=20)
	private String name;
	
	@Column
	private long calcEmpId;
	
	@Column(length=40)
	private String calcLoginName;
	
	@Column(length=20)
	private String calcName;
	
	@Column
	private long depId;
	
	@Column
	private boolean accuEnabled;
	@Column(precision = 10, scale = 2)
	private BigDecimal accuBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal accuSelfBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal accuCorpBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal accuSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal accuSelfReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal accuSelfSum;
	@Column(precision = 10, scale = 2)
	private BigDecimal accuCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal accuCorpReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal accuCorpSum;
	
	@Column(length=120)
	private String accuRemark;
	
	@Column
	private boolean submit;

	@Override
	public String getRowKey() {
		return new SimpleDateFormat("yyyyMMdd").format(this.calcMonth) + ":" + String.valueOf(this.empId) + ":" + String.valueOf(this.company);
	}

	public Date getCalcMonth() {
		return calcMonth;
	}

	public void setCalcMonth(Date calcMonth) {
		this.calcMonth = calcMonth;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getCompany() {
		return company;
	}

	public void setCompany(long company) {
		this.company = company;
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

	public long getCalcEmpId() {
		return calcEmpId;
	}

	public void setCalcEmpId(long calcEmpId) {
		this.calcEmpId = calcEmpId;
	}

	public String getCalcLoginName() {
		return calcLoginName;
	}

	public void setCalcLoginName(String calcLoginName) {
		this.calcLoginName = calcLoginName;
	}

	public String getCalcName() {
		return calcName;
	}

	public void setCalcName(String calcName) {
		this.calcName = calcName;
	}

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	public boolean isAccuEnabled() {
		return accuEnabled;
	}

	public void setAccuEnabled(boolean accuEnabled) {
		this.accuEnabled = accuEnabled;
	}

	public BigDecimal getAccuBase() {
		return accuBase;
	}

	public void setAccuBase(BigDecimal accuBase) {
		this.accuBase = accuBase;
	}

	public BigDecimal getAccuSelf() {
		return accuSelf;
	}

	public void setAccuSelf(BigDecimal accuSelf) {
		this.accuSelf = accuSelf;
	}

	public BigDecimal getAccuSelfReme() {
		return accuSelfReme;
	}

	public void setAccuSelfReme(BigDecimal accuSelfReme) {
		this.accuSelfReme = accuSelfReme;
	}

	public BigDecimal getAccuSelfSum() {
		return accuSelfSum;
	}

	public void setAccuSelfSum(BigDecimal accuSelfSum) {
		this.accuSelfSum = accuSelfSum;
	}

	public BigDecimal getAccuCorp() {
		return accuCorp;
	}

	public void setAccuCorp(BigDecimal accuCorp) {
		this.accuCorp = accuCorp;
	}

	public BigDecimal getAccuCorpReme() {
		return accuCorpReme;
	}

	public void setAccuCorpReme(BigDecimal accuCorpReme) {
		this.accuCorpReme = accuCorpReme;
	}

	public BigDecimal getAccuCorpSum() {
		return accuCorpSum;
	}

	public void setAccuCorpSum(BigDecimal accuCorpSum) {
		this.accuCorpSum = accuCorpSum;
	}

	public String getAccuRemark() {
		return accuRemark;
	}

	public void setAccuRemark(String accuRemark) {
		this.accuRemark = accuRemark;
	}

	public boolean isSubmit() {
		return submit;
	}

	public void setSubmit(boolean submit) {
		this.submit = submit;
	}

	public BigDecimal getAccuSelfBase() {
		return accuSelfBase;
	}

	public void setAccuSelfBase(BigDecimal accuSelfBase) {
		this.accuSelfBase = accuSelfBase;
	}

	public BigDecimal getAccuCorpBase() {
		return accuCorpBase;
	}

	public void setAccuCorpBase(BigDecimal accuCorpBase) {
		this.accuCorpBase = accuCorpBase;
	}

}
