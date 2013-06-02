/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonCert extends EmployeePersonBaseEntity {

	@Column(length=80)
	private String certName;
	
	@Column
	private Date certDate;
	
	@Column
	private Date certEndDate;
	
	@Column
	private Integer certLimit;
	
	@Column(length=60)
	private String certNo;
	
	@Column(length=60)
	private String certLevel;
	
	@Column(length=60)
	private String certType;
	
	@Column(length=120)
	private String awardOrg;

	public String getAwardOrg() {
		return awardOrg;
	}

	public void setAwardOrg(String awardOrg) {
		this.awardOrg = awardOrg;
	}

	public Date getCertDate() {
		return certDate;
	}

	public void setCertDate(Date certDate) {
		this.certDate = certDate;
	}

	public Integer getCertLimit() {
		return certLimit;
	}

	public void setCertLimit(Integer certLimit) {
		this.certLimit = certLimit;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCertLevel() {
		return certLevel;
	}

	public void setCertLevel(String certLevel) {
		this.certLevel = certLevel;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public Date getCertEndDate() {
		return certEndDate;
	}

	public void setCertEndDate(Date certEndDate) {
		this.certEndDate = certEndDate;
	}

	
}
