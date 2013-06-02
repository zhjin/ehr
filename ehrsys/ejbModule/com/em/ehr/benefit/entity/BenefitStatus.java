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
public class BenefitStatus extends EntityBase {
	/**
	 * 员工标识
	 */
	@Id
	private long empId;
	
	/**
	 * 社保缴纳城市
	 */
	@Column
	private long benefitCompany;
	
	@Column
	private long benefitCity;
	
	@Column(length=40)
	private String benefitNo;
	
	// 医疗	
	
	@Column
	private Date medicalFirstDate;
	
	@Column
	private boolean medicalEnabled;
	
	@Column(length=40)
	private String medicalNo;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalBase;
	
	@Column
	private Date medicalCreateDate;
	
	@Column
	private long medicalCreateType;
	
	@Column
	private Date medicalStopDate;
	
	@Column
	private long medicalStopType;
	
	// 养老
	
	@Column
	private Date annuitiesFirstDate;
	
	@Column
	private boolean annuitiesEnabled;
	
	@Column(length=40)
	private String annuitiesNo;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesBase;
	
	@Column
	private Date annuitiesCreateDate;
	
	@Column
	private long annuitiesCreateType;
	
	@Column
	private Date annuitiesStopDate;
	
	@Column
	private long annuitiesStopType;	
	
	// 失业
	
	@Column
	private Date idlenessFirstDate;
	
	@Column
	private boolean idlenessEnabled;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessBase;
	
	@Column
	private Date idlenessCreateDate;
	
	@Column
	private long idlenessCreateType;
	
	@Column
	private Date idlenessStopDate;
	
	@Column
	private long idlenessStopType;
	
	@Column(length=40)
	private String idlenessCode;
	
	// 工伤
	
	@Column
	private Date compoFirstDate;
	
	@Column
	private boolean compoEnabled;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal compoBase;
	
	@Column
	private Date compoCreateDate;
	
	@Column
	private long compoCreateType;
	
	@Column
	private Date compoStopDate;
	
	@Column
	private long compoStopType;	
	
	// 生育
	
	@Column
	private Date babyFirstDate;
	
	@Column
	private boolean babyEnabled;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal babyBase;
	
	@Column
	private Date babyCreateDate;
	
	@Column
	private long babyCreateType;
	
	@Column
	private Date babyStopDate;
	
	@Column
	private long babyStopType;
	
	// 其它
	@Column
	private Date otherFirstDate;
	
	@Column
	private boolean otherEnabled;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal otherSelf;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal otherCorp;
	
	@Column
	private Date otherCreateDate;
	
	@Column
	private long otherCreateType;
	
	@Column
	private Date otherStopDate;
	
	@Column
	private long otherStopType;

	/**
	 * 备注
	 */
	
	@Column(length = 120)
	private String societyRemark;
	
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

	public long getBenefitCompany() {
		return benefitCompany;
	}

	public void setBenefitCompany(long benefitCompany) {
		this.benefitCompany = benefitCompany;
	}

	public long getBenefitCity() {
		return benefitCity;
	}

	public void setBenefitCity(long benefitCity) {
		this.benefitCity = benefitCity;
	}

	public String getBenefitNo() {
		return benefitNo;
	}

	public void setBenefitNo(String benefitNo) {
		this.benefitNo = benefitNo;
	}

	public Date getMedicalFirstDate() {
		return medicalFirstDate;
	}

	public void setMedicalFirstDate(Date medicalFirstDate) {
		this.medicalFirstDate = medicalFirstDate;
	}

	public boolean isMedicalEnabled() {
		return medicalEnabled;
	}

	public void setMedicalEnabled(boolean medicalEnabled) {
		this.medicalEnabled = medicalEnabled;
	}

	public String getMedicalNo() {
		return medicalNo;
	}

	public void setMedicalNo(String medicalNo) {
		this.medicalNo = medicalNo;
	}

	public BigDecimal getMedicalBase() {
		return medicalBase;
	}

	public void setMedicalBase(BigDecimal medicalBase) {
		this.medicalBase = medicalBase;
	}

	public Date getMedicalCreateDate() {
		return medicalCreateDate;
	}

	public void setMedicalCreateDate(Date medicalCreateDate) {
		this.medicalCreateDate = medicalCreateDate;
	}

	public long getMedicalCreateType() {
		return medicalCreateType;
	}

	public void setMedicalCreateType(long medicalCreateType) {
		this.medicalCreateType = medicalCreateType;
	}

	public Date getMedicalStopDate() {
		return medicalStopDate;
	}

	public void setMedicalStopDate(Date medicalStopDate) {
		this.medicalStopDate = medicalStopDate;
	}

	public long getMedicalStopType() {
		return medicalStopType;
	}

	public void setMedicalStopType(long medicalStopType) {
		this.medicalStopType = medicalStopType;
	}

	public Date getAnnuitiesFirstDate() {
		return annuitiesFirstDate;
	}

	public void setAnnuitiesFirstDate(Date annuitiesFirstDate) {
		this.annuitiesFirstDate = annuitiesFirstDate;
	}

	public boolean isAnnuitiesEnabled() {
		return annuitiesEnabled;
	}

	public void setAnnuitiesEnabled(boolean annuitiesEnabled) {
		this.annuitiesEnabled = annuitiesEnabled;
	}

	public String getAnnuitiesNo() {
		return annuitiesNo;
	}

	public void setAnnuitiesNo(String annuitiesNo) {
		this.annuitiesNo = annuitiesNo;
	}

	public BigDecimal getAnnuitiesBase() {
		return annuitiesBase;
	}

	public void setAnnuitiesBase(BigDecimal annuitiesBase) {
		this.annuitiesBase = annuitiesBase;
	}

	public Date getAnnuitiesCreateDate() {
		return annuitiesCreateDate;
	}

	public void setAnnuitiesCreateDate(Date annuitiesCreateDate) {
		this.annuitiesCreateDate = annuitiesCreateDate;
	}

	public long getAnnuitiesCreateType() {
		return annuitiesCreateType;
	}

	public void setAnnuitiesCreateType(long annuitiesCreateType) {
		this.annuitiesCreateType = annuitiesCreateType;
	}

	public Date getAnnuitiesStopDate() {
		return annuitiesStopDate;
	}

	public void setAnnuitiesStopDate(Date annuitiesStopDate) {
		this.annuitiesStopDate = annuitiesStopDate;
	}

	public long getAnnuitiesStopType() {
		return annuitiesStopType;
	}

	public void setAnnuitiesStopType(long annuitiesStopType) {
		this.annuitiesStopType = annuitiesStopType;
	}

	public Date getIdlenessFirstDate() {
		return idlenessFirstDate;
	}

	public void setIdlenessFirstDate(Date idlenessFirstDate) {
		this.idlenessFirstDate = idlenessFirstDate;
	}

	public boolean isIdlenessEnabled() {
		return idlenessEnabled;
	}

	public void setIdlenessEnabled(boolean idlenessEnabled) {
		this.idlenessEnabled = idlenessEnabled;
	}

	public BigDecimal getIdlenessBase() {
		return idlenessBase;
	}

	public void setIdlenessBase(BigDecimal idlenessBase) {
		this.idlenessBase = idlenessBase;
	}

	public Date getIdlenessCreateDate() {
		return idlenessCreateDate;
	}

	public void setIdlenessCreateDate(Date idlenessCreateDate) {
		this.idlenessCreateDate = idlenessCreateDate;
	}

	public long getIdlenessCreateType() {
		return idlenessCreateType;
	}

	public void setIdlenessCreateType(long idlenessCreateType) {
		this.idlenessCreateType = idlenessCreateType;
	}

	public Date getIdlenessStopDate() {
		return idlenessStopDate;
	}

	public void setIdlenessStopDate(Date idlenessStopDate) {
		this.idlenessStopDate = idlenessStopDate;
	}

	public long getIdlenessStopType() {
		return idlenessStopType;
	}

	public void setIdlenessStopType(long idlenessStopType) {
		this.idlenessStopType = idlenessStopType;
	}

	public String getIdlenessCode() {
		return idlenessCode;
	}

	public void setIdlenessCode(String idlenessCode) {
		this.idlenessCode = idlenessCode;
	}

	public Date getCompoFirstDate() {
		return compoFirstDate;
	}

	public void setCompoFirstDate(Date compoFirstDate) {
		this.compoFirstDate = compoFirstDate;
	}

	public boolean isCompoEnabled() {
		return compoEnabled;
	}

	public void setCompoEnabled(boolean compoEnabled) {
		this.compoEnabled = compoEnabled;
	}

	public BigDecimal getCompoBase() {
		return compoBase;
	}

	public void setCompoBase(BigDecimal compoBase) {
		this.compoBase = compoBase;
	}

	public Date getCompoCreateDate() {
		return compoCreateDate;
	}

	public void setCompoCreateDate(Date compoCreateDate) {
		this.compoCreateDate = compoCreateDate;
	}

	public long getCompoCreateType() {
		return compoCreateType;
	}

	public void setCompoCreateType(long compoCreateType) {
		this.compoCreateType = compoCreateType;
	}

	public Date getCompoStopDate() {
		return compoStopDate;
	}

	public void setCompoStopDate(Date compoStopDate) {
		this.compoStopDate = compoStopDate;
	}

	public long getCompoStopType() {
		return compoStopType;
	}

	public void setCompoStopType(long compoStopType) {
		this.compoStopType = compoStopType;
	}

	public Date getBabyFirstDate() {
		return babyFirstDate;
	}

	public void setBabyFirstDate(Date babyFirstDate) {
		this.babyFirstDate = babyFirstDate;
	}

	public boolean isBabyEnabled() {
		return babyEnabled;
	}

	public void setBabyEnabled(boolean babyEnabled) {
		this.babyEnabled = babyEnabled;
	}

	public BigDecimal getBabyBase() {
		return babyBase;
	}

	public void setBabyBase(BigDecimal babyBase) {
		this.babyBase = babyBase;
	}

	public Date getBabyCreateDate() {
		return babyCreateDate;
	}

	public void setBabyCreateDate(Date babyCreateDate) {
		this.babyCreateDate = babyCreateDate;
	}

	public long getBabyCreateType() {
		return babyCreateType;
	}

	public void setBabyCreateType(long babyCreateType) {
		this.babyCreateType = babyCreateType;
	}

	public Date getBabyStopDate() {
		return babyStopDate;
	}

	public void setBabyStopDate(Date babyStopDate) {
		this.babyStopDate = babyStopDate;
	}

	public long getBabyStopType() {
		return babyStopType;
	}

	public void setBabyStopType(long babyStopType) {
		this.babyStopType = babyStopType;
	}

	public Date getOtherFirstDate() {
		return otherFirstDate;
	}

	public void setOtherFirstDate(Date otherFirstDate) {
		this.otherFirstDate = otherFirstDate;
	}

	public boolean isOtherEnabled() {
		return otherEnabled;
	}

	public void setOtherEnabled(boolean otherEnabled) {
		this.otherEnabled = otherEnabled;
	}

	public BigDecimal getOtherSelf() {
		return otherSelf;
	}

	public void setOtherSelf(BigDecimal otherSelf) {
		this.otherSelf = otherSelf;
	}

	public BigDecimal getOtherCorp() {
		return otherCorp;
	}

	public void setOtherCorp(BigDecimal otherCorp) {
		this.otherCorp = otherCorp;
	}

	public Date getOtherCreateDate() {
		return otherCreateDate;
	}

	public void setOtherCreateDate(Date otherCreateDate) {
		this.otherCreateDate = otherCreateDate;
	}

	public long getOtherCreateType() {
		return otherCreateType;
	}

	public void setOtherCreateType(long otherCreateType) {
		this.otherCreateType = otherCreateType;
	}

	public Date getOtherStopDate() {
		return otherStopDate;
	}

	public void setOtherStopDate(Date otherStopDate) {
		this.otherStopDate = otherStopDate;
	}

	public long getOtherStopType() {
		return otherStopType;
	}

	public void setOtherStopType(long otherStopType) {
		this.otherStopType = otherStopType;
	}

	public String getSocietyRemark() {
		return societyRemark;
	}

	public void setSocietyRemark(String societyRemark) {
		this.societyRemark = societyRemark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
