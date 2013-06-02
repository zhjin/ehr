/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.CodeBase;

@Entity
public class CompanyCode extends CodeBase {

	@Column(length=40)
	private String shortName;

	@Column(length=20)
	private String area;

	@Column
	private long depId;

	@Column
	private long bankId;

	@Column(length=20)
	private String corpNo;

	@Column(length=20)
	private String managerName;

	@Column(length=20)
	private String corporation;

	@Column(length=40)
	private String account;

	@Column(length=20)
	private String bankCode;

	@Column(length=40)
	private String accountBank;

	@Column(length=80)
	private String registerCity;

	@Column(length=40)
	private String charter;

	@Column(length=40)
	private String organize;

	@Column(length=40)
	private String accumulationNo;

	@Column(length=40)
	private String insuranceNo;

	@Column
	private Date createDate;

	@Column
	private Date destoryDate;


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getAccountBank() {
		return accountBank;
	}


	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}


	public String getAccumulationNo() {
		return accumulationNo;
	}


	public void setAccumulationNo(String accumulationNo) {
		this.accumulationNo = accumulationNo;
	}


	public String getBankCode() {
		return bankCode;
	}


	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}


	public String getCharter() {
		return charter;
	}


	public void setCharter(String charter) {
		this.charter = charter;
	}

	public String getCorporation() {
		return corporation;
	}


	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getDestoryDate() {
		return destoryDate;
	}


	public void setDestoryDate(Date destoryDate) {
		this.destoryDate = destoryDate;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}


	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}


	public String getManagerName() {
		return managerName;
	}


	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public String getOrganize() {
		return organize;
	}

	public void setOrganize(String organize) {
		this.organize = organize;
	}


	public String getRegisterCity() {
		return registerCity;
	}


	public void setRegisterCity(String registerCity) {
		this.registerCity = registerCity;
	}

	public String getShortName() {
		return shortName;
	}


	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public long getDepId() {
		return depId;
	}


	public void setDepId(long depId) {
		this.depId = depId;
	}


	public String getCorpNo() {
		return corpNo;
	}


	public void setCorpNo(String corpNo) {
		this.corpNo = corpNo;
	}


	public long getBankId() {
		return bankId;
	}


	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

}
