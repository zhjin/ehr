/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.em.ehr.base.CalcPK;
import com.zhjin.base.EntityBase;

@Entity
@IdClass(value = CalcPK.class)
public class EmployeeCard extends EntityBase {
	
	@Id
	private long empId;
	
	@Id
	private Date calcMonth;
	
	@Id
	private long company;
	
	@Column(length=40)
	private String cardNo;
	
	@Column(length=40)
	private String cardNo1;
	
	@Column(length=40)
	private String cardNo2;	
	
	@Column(length=20)
	private String name;
	
	@Column(length=40)
	private String loginName;
	
	@Column
	private long depId;
	
	@Column(length=60)
	private String remark;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getCardNo1() {
		return cardNo1;
	}

	public void setCardNo1(String cardNo1) {
		this.cardNo1 = cardNo1;
	}

	public String getCardNo2() {
		return cardNo2;
	}

	public void setCardNo2(String cardNo2) {
		this.cardNo2 = cardNo2;
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

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String getRowKey() {
		return this.empId + ":" + this.company + ":" + this.calcMonth;
	}

}
