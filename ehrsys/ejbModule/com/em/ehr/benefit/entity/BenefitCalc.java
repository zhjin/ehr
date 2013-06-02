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
public class BenefitCalc extends EntityBase {
	
	@Id
	private Date calcMonth;
	
	@Id
	private long empId;
	
	@Id
	private long area;
	
	@Id 
	private long company;
	
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
	private boolean annuitiesEnabled;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesSelfBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesCorpBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesSelfReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesSelfSum;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesCorpReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesCorpSum;
	
	@Column
	private boolean medicalEnabled;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalSelfBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalCorpBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalSelfReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalSelfSum;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalCorpReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalCorpSum;	
	
	@Column
	private boolean idlenessEnabled;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessSelfBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessCorpBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessSelfReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessSelfSum;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessCorpReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessCorpSum;	
	
	@Column
	private boolean compoEnabled;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoSelfBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoCorpBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoSelfReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoSelfSum;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoCorpReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoCorpSum;
	
	@Column
	private boolean babyEnabled;
	@Column(precision = 10, scale = 2)
	private BigDecimal babyBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal babySelfBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal babyCorpBase;
	@Column(precision = 10, scale = 2)
	private BigDecimal babySelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal babySelfReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal babySelfSum;
	@Column(precision = 10, scale = 2)
	private BigDecimal babyCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal babyCorpReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal babyCorpSum;
	
	@Column
	private boolean otherEnabled;
	@Column(precision = 10, scale = 2)
	private BigDecimal otherSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal otherSelfReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal otherSelfSum;
	@Column(precision = 10, scale = 2)
	private BigDecimal otherCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal otherCorpReme;
	@Column(precision = 10, scale = 2)
	private BigDecimal otherCorpSum;
	
	@Column(length=120)
	private String societyRemark;
	
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

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
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

	public boolean isAnnuitiesEnabled() {
		return annuitiesEnabled;
	}

	public void setAnnuitiesEnabled(boolean annuitiesEnabled) {
		this.annuitiesEnabled = annuitiesEnabled;
	}

	public BigDecimal getAnnuitiesBase() {
		return annuitiesBase;
	}

	public void setAnnuitiesBase(BigDecimal annuitiesBase) {
		this.annuitiesBase = annuitiesBase;
	}

	public BigDecimal getAnnuitiesSelf() {
		return annuitiesSelf;
	}

	public void setAnnuitiesSelf(BigDecimal annuitiesSelf) {
		this.annuitiesSelf = annuitiesSelf;
	}

	public BigDecimal getAnnuitiesSelfReme() {
		return annuitiesSelfReme;
	}

	public void setAnnuitiesSelfReme(BigDecimal annuitiesSelfReme) {
		this.annuitiesSelfReme = annuitiesSelfReme;
	}

	public BigDecimal getAnnuitiesSelfSum() {
		return annuitiesSelfSum;
	}

	public void setAnnuitiesSelfSum(BigDecimal annuitiesSelfSum) {
		this.annuitiesSelfSum = annuitiesSelfSum;
	}

	public BigDecimal getAnnuitiesCorp() {
		return annuitiesCorp;
	}

	public void setAnnuitiesCorp(BigDecimal annuitiesCorp) {
		this.annuitiesCorp = annuitiesCorp;
	}

	public BigDecimal getAnnuitiesCorpReme() {
		return annuitiesCorpReme;
	}

	public void setAnnuitiesCorpReme(BigDecimal annuitiesCorpReme) {
		this.annuitiesCorpReme = annuitiesCorpReme;
	}

	public BigDecimal getAnnuitiesCorpSum() {
		return annuitiesCorpSum;
	}

	public void setAnnuitiesCorpSum(BigDecimal annuitiesCorpSum) {
		this.annuitiesCorpSum = annuitiesCorpSum;
	}

	public boolean isMedicalEnabled() {
		return medicalEnabled;
	}

	public void setMedicalEnabled(boolean medicalEnabled) {
		this.medicalEnabled = medicalEnabled;
	}

	public BigDecimal getMedicalBase() {
		return medicalBase;
	}

	public void setMedicalBase(BigDecimal medicalBase) {
		this.medicalBase = medicalBase;
	}

	public BigDecimal getMedicalSelf() {
		return medicalSelf;
	}

	public void setMedicalSelf(BigDecimal medicalSelf) {
		this.medicalSelf = medicalSelf;
	}

	public BigDecimal getMedicalSelfReme() {
		return medicalSelfReme;
	}

	public void setMedicalSelfReme(BigDecimal medicalSelfReme) {
		this.medicalSelfReme = medicalSelfReme;
	}

	public BigDecimal getMedicalSelfSum() {
		return medicalSelfSum;
	}

	public void setMedicalSelfSum(BigDecimal medicalSelfSum) {
		this.medicalSelfSum = medicalSelfSum;
	}

	public BigDecimal getMedicalCorp() {
		return medicalCorp;
	}

	public void setMedicalCorp(BigDecimal medicalCorp) {
		this.medicalCorp = medicalCorp;
	}

	public BigDecimal getMedicalCorpReme() {
		return medicalCorpReme;
	}

	public void setMedicalCorpReme(BigDecimal medicalCorpReme) {
		this.medicalCorpReme = medicalCorpReme;
	}

	public BigDecimal getMedicalCorpSum() {
		return medicalCorpSum;
	}

	public void setMedicalCorpSum(BigDecimal medicalCorpSum) {
		this.medicalCorpSum = medicalCorpSum;
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

	public BigDecimal getIdlenessSelf() {
		return idlenessSelf;
	}

	public void setIdlenessSelf(BigDecimal idlenessSelf) {
		this.idlenessSelf = idlenessSelf;
	}

	public BigDecimal getIdlenessSelfReme() {
		return idlenessSelfReme;
	}

	public void setIdlenessSelfReme(BigDecimal idlenessSelfReme) {
		this.idlenessSelfReme = idlenessSelfReme;
	}

	public BigDecimal getIdlenessSelfSum() {
		return idlenessSelfSum;
	}

	public void setIdlenessSelfSum(BigDecimal idlenessSelfSum) {
		this.idlenessSelfSum = idlenessSelfSum;
	}

	public BigDecimal getIdlenessCorp() {
		return idlenessCorp;
	}

	public void setIdlenessCorp(BigDecimal idlenessCorp) {
		this.idlenessCorp = idlenessCorp;
	}

	public BigDecimal getIdlenessCorpReme() {
		return idlenessCorpReme;
	}

	public void setIdlenessCorpReme(BigDecimal idlenessCorpReme) {
		this.idlenessCorpReme = idlenessCorpReme;
	}

	public BigDecimal getIdlenessCorpSum() {
		return idlenessCorpSum;
	}

	public void setIdlenessCorpSum(BigDecimal idlenessCorpSum) {
		this.idlenessCorpSum = idlenessCorpSum;
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

	public BigDecimal getCompoSelf() {
		return compoSelf;
	}

	public void setCompoSelf(BigDecimal compoSelf) {
		this.compoSelf = compoSelf;
	}

	public BigDecimal getCompoSelfReme() {
		return compoSelfReme;
	}

	public void setCompoSelfReme(BigDecimal compoSelfReme) {
		this.compoSelfReme = compoSelfReme;
	}

	public BigDecimal getCompoSelfSum() {
		return compoSelfSum;
	}

	public void setCompoSelfSum(BigDecimal compoSelfSum) {
		this.compoSelfSum = compoSelfSum;
	}

	public BigDecimal getCompoCorp() {
		return compoCorp;
	}

	public void setCompoCorp(BigDecimal compoCorp) {
		this.compoCorp = compoCorp;
	}

	public BigDecimal getCompoCorpReme() {
		return compoCorpReme;
	}

	public void setCompoCorpReme(BigDecimal compoCorpReme) {
		this.compoCorpReme = compoCorpReme;
	}

	public BigDecimal getCompoCorpSum() {
		return compoCorpSum;
	}

	public void setCompoCorpSum(BigDecimal compoCorpSum) {
		this.compoCorpSum = compoCorpSum;
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

	public BigDecimal getBabySelf() {
		return babySelf;
	}

	public void setBabySelf(BigDecimal babySelf) {
		this.babySelf = babySelf;
	}

	public BigDecimal getBabySelfReme() {
		return babySelfReme;
	}

	public void setBabySelfReme(BigDecimal babySelfReme) {
		this.babySelfReme = babySelfReme;
	}

	public BigDecimal getBabySelfSum() {
		return babySelfSum;
	}

	public void setBabySelfSum(BigDecimal babySelfSum) {
		this.babySelfSum = babySelfSum;
	}

	public BigDecimal getBabyCorp() {
		return babyCorp;
	}

	public void setBabyCorp(BigDecimal babyCorp) {
		this.babyCorp = babyCorp;
	}

	public BigDecimal getBabyCorpReme() {
		return babyCorpReme;
	}

	public void setBabyCorpReme(BigDecimal babyCorpReme) {
		this.babyCorpReme = babyCorpReme;
	}

	public BigDecimal getBabyCorpSum() {
		return babyCorpSum;
	}

	public void setBabyCorpSum(BigDecimal babyCorpSum) {
		this.babyCorpSum = babyCorpSum;
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

	public BigDecimal getOtherSelfReme() {
		return otherSelfReme;
	}

	public void setOtherSelfReme(BigDecimal otherSelfReme) {
		this.otherSelfReme = otherSelfReme;
	}

	public BigDecimal getOtherSelfSum() {
		return otherSelfSum;
	}

	public void setOtherSelfSum(BigDecimal otherSelfSum) {
		this.otherSelfSum = otherSelfSum;
	}

	public BigDecimal getOtherCorp() {
		return otherCorp;
	}

	public void setOtherCorp(BigDecimal otherCorp) {
		this.otherCorp = otherCorp;
	}

	public BigDecimal getOtherCorpReme() {
		return otherCorpReme;
	}

	public void setOtherCorpReme(BigDecimal otherCorpReme) {
		this.otherCorpReme = otherCorpReme;
	}

	public BigDecimal getOtherCorpSum() {
		return otherCorpSum;
	}

	public void setOtherCorpSum(BigDecimal otherCorpSum) {
		this.otherCorpSum = otherCorpSum;
	}

	public String getSocietyRemark() {
		return societyRemark;
	}

	public void setSocietyRemark(String societyRemark) {
		this.societyRemark = societyRemark;
	}

	public boolean isSubmit() {
		return submit;
	}

	public void setSubmit(boolean submit) {
		this.submit = submit;
	}

	public BigDecimal getAnnuitiesSelfBase() {
		return annuitiesSelfBase;
	}

	public void setAnnuitiesSelfBase(BigDecimal annuitiesSelfBase) {
		this.annuitiesSelfBase = annuitiesSelfBase;
	}

	public BigDecimal getAnnuitiesCorpBase() {
		return annuitiesCorpBase;
	}

	public void setAnnuitiesCorpBase(BigDecimal annuitiesCorpBase) {
		this.annuitiesCorpBase = annuitiesCorpBase;
	}

	public BigDecimal getMedicalSelfBase() {
		return medicalSelfBase;
	}

	public void setMedicalSelfBase(BigDecimal medicalSelfBase) {
		this.medicalSelfBase = medicalSelfBase;
	}

	public BigDecimal getMedicalCorpBase() {
		return medicalCorpBase;
	}

	public void setMedicalCorpBase(BigDecimal medicalCorpBase) {
		this.medicalCorpBase = medicalCorpBase;
	}

	public BigDecimal getIdlenessSelfBase() {
		return idlenessSelfBase;
	}

	public void setIdlenessSelfBase(BigDecimal idlenessSelfBase) {
		this.idlenessSelfBase = idlenessSelfBase;
	}

	public BigDecimal getIdlenessCorpBase() {
		return idlenessCorpBase;
	}

	public void setIdlenessCorpBase(BigDecimal idlenessCorpBase) {
		this.idlenessCorpBase = idlenessCorpBase;
	}

	public BigDecimal getCompoSelfBase() {
		return compoSelfBase;
	}

	public void setCompoSelfBase(BigDecimal compoSelfBase) {
		this.compoSelfBase = compoSelfBase;
	}

	public BigDecimal getCompoCorpBase() {
		return compoCorpBase;
	}

	public void setCompoCorpBase(BigDecimal compoCorpBase) {
		this.compoCorpBase = compoCorpBase;
	}

	public BigDecimal getBabySelfBase() {
		return babySelfBase;
	}

	public void setBabySelfBase(BigDecimal babySelfBase) {
		this.babySelfBase = babySelfBase;
	}

	public BigDecimal getBabyCorpBase() {
		return babyCorpBase;
	}

	public void setBabyCorpBase(BigDecimal babyCorpBase) {
		this.babyCorpBase = babyCorpBase;
	}

}
