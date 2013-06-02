/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.benefit.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PreRemove;

import com.zhjin.base.EntityBase;

@Entity
@IdClass(value=BenefitCityPK.class)
public class BenefitCity extends EntityBase {	
	@Id
	private long area;
	
	@Id
	private long company;
	
	@Column
	private Date calcMonth;

	@Column
	private long accuManagerEmpId;
	
	@Column(length=40)
	private String accuManagerLoginName;
	
	@Column(length=20)
	private String accuManagerName;
	
	@Column
	private boolean accuSubmit;
	
	@Column
	private Date accuSubmitTime;
	
	@Column
	private long accuSubmitEmpId;
	
	@Column(length=40)
	private String accuSubmitLoginName;
	
	@Column(length=20)
	private String accuSubmitName;
	
	@Column
	private long benefitManagerEmpId;
	
	@Column(length=40)
	private String benefitManagerLoginName;
	
	@Column(length=20)
	private String benefitManagerName;
	
	@Column
	private boolean benefitSubmit;
	
	@Column
	private Date benefitSubmitTime;
	
	@Column
	private long benefitSubmitEmpId;
	
	@Column(length=40)
	private String benefitSubmitLoginName;
	
	@Column(length=20)
	private String benefitSubmitName;

	/**
	 * 公积金
	 */
	@Column(precision=10, scale=4)
	private BigDecimal accumulationSelf;
	@Column(precision=10, scale=4)
	private BigDecimal accumulationCorp;
	@Column(precision=10, scale=2)
	private BigDecimal accumulationSelfMin;
	@Column(precision=10, scale=2)
	private BigDecimal accumulationSelfMax;
	@Column(precision=10, scale=2)
	private BigDecimal accumulationCorpMin;
	@Column(precision=10, scale=2)
	private BigDecimal accumulationCorpMax;
	@Column
	private int accumulationDecimal;
	@Column
	private long accumulationRound;

	/**
	 * 养老金
	 */
	@Column(precision=10, scale=4)
	private BigDecimal annuitiesSelf;
	@Column(precision=10, scale=4)
	private BigDecimal annuitiesCorp;
	@Column(precision=10, scale=2)
	private BigDecimal annuitiesSelfMin;
	@Column(precision=10, scale=2)
	private BigDecimal annuitiesSelfMax;
	@Column(precision=10, scale=2)
	private BigDecimal annuitiesCorpMin;
	@Column(precision=10, scale=2)
	private BigDecimal annuitiesCorpMax;
	@Column
	private int annuitiesDecimal;
	@Column
	private long annuitiesRound;

	/**
	 * 医疗金
	 */
	@Column(precision=10, scale=4)
	private BigDecimal medicalSelf;
	@Column(precision=10, scale=4)
	private BigDecimal medicalCorp;
	@Column(precision=10, scale=2)
	private BigDecimal medicalSelfMin;
	@Column(precision=10, scale=2)
	private BigDecimal medicalSelfMax;
	@Column(precision=10, scale=2)
	private BigDecimal medicalCorpMin;
	@Column(precision=10, scale=2)
	private BigDecimal medicalCorpMax;
	@Column
	private int medicalDecimal;
	@Column
	private long medicalRound;
	
	/**
	 * 重特病统筹
	 */
	@Column(precision=10, scale=2)
	private BigDecimal medical1Self;
	@Column(precision=10, scale=2)
	private BigDecimal medical1Corp;

	/**
	 * 失业险
	 */
	@Column(precision=10, scale=4)
	private BigDecimal idlenessSelf;
	@Column(precision=10, scale=4)
	private BigDecimal idlenessCorp;
	@Column(precision=10, scale=2)
	private BigDecimal idlenessSelfMin;
	@Column(precision=10, scale=2)
	private BigDecimal idlenessSelfMax;
	@Column(precision=10, scale=2)
	private BigDecimal idlenessCorpMin;
	@Column(precision=10, scale=2)
	private BigDecimal idlenessCorpMax;
	@Column
	private int idlenessDecimal;
	@Column
	private long idlenessRound;

	/**
	 * 工伤险
	 */
	@Column(precision=10, scale=4)
	private BigDecimal compoSelf;
	@Column(precision=10, scale=4)
	private BigDecimal compoCorp;
	@Column(precision=10, scale=2)
	private BigDecimal compoSelfMin;
	@Column(precision=10, scale=2)
	private BigDecimal compoSelfMax;
	@Column(precision=10, scale=2)
	private BigDecimal compoCorpMin;
	@Column(precision=10, scale=2)
	private BigDecimal compoCorpMax;
	@Column
	private int compoDecimal;
	@Column
	private long compoRound;

	/**
	 * 生育险个人
	 */
	@Column(precision=10, scale=4)
	private BigDecimal babySelf;
	@Column(precision=10, scale=4)
	private BigDecimal babyCorp;
	@Column(precision=10, scale=2)
	private BigDecimal babySelfMin;
	@Column(precision=10, scale=2)
	private BigDecimal babySelfMax;
	@Column(precision=10, scale=2)
	private BigDecimal babyCorpMin;
	@Column(precision=10, scale=2)
	private BigDecimal babyCorpMax;
	@Column
	private int babyDecimal;
	@Column
	private long babyRound;
	
	/**
	 * 其它
	 */
	@Column(precision=10, scale=2)
	private BigDecimal otherSelfMin;
	@Column(precision=10, scale=2)
	private BigDecimal otherSelfMax;
	@Column(precision=10, scale=2)
	private BigDecimal otherCorpMin;
	@Column(precision=10, scale=2)
	private BigDecimal otherCorpMax;
	@Column
	private int otherDecimal;
	@Column
	private long otherRound;
	
	@Column(length=100)
	private String remark;
	
	public BenefitCity() {
		super();
		this.accumulationDecimal = 2;
		this.annuitiesDecimal = 2;
		this.medicalDecimal = 2;
		this.compoDecimal = 2;
		this.idlenessDecimal = 2;
		this.babyDecimal = 2;
		this.otherDecimal = 2;
	}

	@PreRemove
	public void preDelete() throws Exception {
		HashMap<String, Object> arg = new HashMap<String, Object>();
		arg.put("company", this.company);
		arg.put("city", this.area);

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

	public Date getCalcMonth() {
		return calcMonth;
	}

	public void setCalcMonth(Date calcMonth) {
		this.calcMonth = calcMonth;
	}

	public long getAccuManagerEmpId() {
		return accuManagerEmpId;
	}

	public void setAccuManagerEmpId(long accuManagerEmpId) {
		this.accuManagerEmpId = accuManagerEmpId;
	}

	public boolean isAccuSubmit() {
		return accuSubmit;
	}

	public void setAccuSubmit(boolean accuSubmit) {
		this.accuSubmit = accuSubmit;
	}

	public Date getAccuSubmitTime() {
		return accuSubmitTime;
	}

	public void setAccuSubmitTime(Date accuSubmitTime) {
		this.accuSubmitTime = accuSubmitTime;
	}

	public long getAccuSubmitEmpId() {
		return accuSubmitEmpId;
	}

	public void setAccuSubmitEmpId(long accuSubmitEmpId) {
		this.accuSubmitEmpId = accuSubmitEmpId;
	}

	public long getBenefitManagerEmpId() {
		return benefitManagerEmpId;
	}

	public void setBenefitManagerEmpId(long benefitManagerEmpId) {
		this.benefitManagerEmpId = benefitManagerEmpId;
	}

	public boolean isBenefitSubmit() {
		return benefitSubmit;
	}

	public void setBenefitSubmit(boolean benefitSubmit) {
		this.benefitSubmit = benefitSubmit;
	}

	public Date getBenefitSubmitTime() {
		return benefitSubmitTime;
	}

	public void setBenefitSubmitTime(Date benefitSubmitTime) {
		this.benefitSubmitTime = benefitSubmitTime;
	}

	public long getBenefitSubmitEmpId() {
		return benefitSubmitEmpId;
	}

	public void setBenefitSubmitEmpId(long benefitSubmitEmpId) {
		this.benefitSubmitEmpId = benefitSubmitEmpId;
	}

	public BigDecimal getAccumulationSelf() {
		return accumulationSelf;
	}

	public void setAccumulationSelf(BigDecimal accumulationSelf) {
		this.accumulationSelf = accumulationSelf;
	}

	public BigDecimal getAccumulationCorp() {
		return accumulationCorp;
	}

	public void setAccumulationCorp(BigDecimal accumulationCorp) {
		this.accumulationCorp = accumulationCorp;
	}

	public BigDecimal getAccumulationSelfMin() {
		return accumulationSelfMin;
	}

	public void setAccumulationSelfMin(BigDecimal accumulationSelfMin) {
		this.accumulationSelfMin = accumulationSelfMin;
	}

	public BigDecimal getAccumulationSelfMax() {
		return accumulationSelfMax;
	}

	public void setAccumulationSelfMax(BigDecimal accumulationSelfMax) {
		this.accumulationSelfMax = accumulationSelfMax;
	}

	public BigDecimal getAccumulationCorpMin() {
		return accumulationCorpMin;
	}

	public void setAccumulationCorpMin(BigDecimal accumulationCorpMin) {
		this.accumulationCorpMin = accumulationCorpMin;
	}

	public BigDecimal getAccumulationCorpMax() {
		return accumulationCorpMax;
	}

	public void setAccumulationCorpMax(BigDecimal accumulationCorpMax) {
		this.accumulationCorpMax = accumulationCorpMax;
	}

	public int getAccumulationDecimal() {
		return accumulationDecimal;
	}

	public void setAccumulationDecimal(int accumulationDecimal) {
		this.accumulationDecimal = accumulationDecimal;
	}

	public BigDecimal getAnnuitiesSelf() {
		return annuitiesSelf;
	}

	public void setAnnuitiesSelf(BigDecimal annuitiesSelf) {
		this.annuitiesSelf = annuitiesSelf;
	}

	public BigDecimal getAnnuitiesCorp() {
		return annuitiesCorp;
	}

	public void setAnnuitiesCorp(BigDecimal annuitiesCorp) {
		this.annuitiesCorp = annuitiesCorp;
	}

	public BigDecimal getAnnuitiesSelfMin() {
		return annuitiesSelfMin;
	}

	public void setAnnuitiesSelfMin(BigDecimal annuitiesSelfMin) {
		this.annuitiesSelfMin = annuitiesSelfMin;
	}

	public BigDecimal getAnnuitiesSelfMax() {
		return annuitiesSelfMax;
	}

	public void setAnnuitiesSelfMax(BigDecimal annuitiesSelfMax) {
		this.annuitiesSelfMax = annuitiesSelfMax;
	}

	public BigDecimal getAnnuitiesCorpMin() {
		return annuitiesCorpMin;
	}

	public void setAnnuitiesCorpMin(BigDecimal annuitiesCorpMin) {
		this.annuitiesCorpMin = annuitiesCorpMin;
	}

	public BigDecimal getAnnuitiesCorpMax() {
		return annuitiesCorpMax;
	}

	public void setAnnuitiesCorpMax(BigDecimal annuitiesCorpMax) {
		this.annuitiesCorpMax = annuitiesCorpMax;
	}

	public int getAnnuitiesDecimal() {
		return annuitiesDecimal;
	}

	public void setAnnuitiesDecimal(int annuitiesDecimal) {
		this.annuitiesDecimal = annuitiesDecimal;
	}


	public BigDecimal getMedicalSelf() {
		return medicalSelf;
	}

	public void setMedicalSelf(BigDecimal medicalSelf) {
		this.medicalSelf = medicalSelf;
	}

	public BigDecimal getMedicalCorp() {
		return medicalCorp;
	}

	public void setMedicalCorp(BigDecimal medicalCorp) {
		this.medicalCorp = medicalCorp;
	}

	public BigDecimal getMedicalSelfMin() {
		return medicalSelfMin;
	}

	public void setMedicalSelfMin(BigDecimal medicalSelfMin) {
		this.medicalSelfMin = medicalSelfMin;
	}

	public BigDecimal getMedicalSelfMax() {
		return medicalSelfMax;
	}

	public void setMedicalSelfMax(BigDecimal medicalSelfMax) {
		this.medicalSelfMax = medicalSelfMax;
	}

	public BigDecimal getMedicalCorpMin() {
		return medicalCorpMin;
	}

	public void setMedicalCorpMin(BigDecimal medicalCorpMin) {
		this.medicalCorpMin = medicalCorpMin;
	}

	public BigDecimal getMedicalCorpMax() {
		return medicalCorpMax;
	}

	public void setMedicalCorpMax(BigDecimal medicalCorpMax) {
		this.medicalCorpMax = medicalCorpMax;
	}

	public int getMedicalDecimal() {
		return medicalDecimal;
	}

	public void setMedicalDecimal(int medicalDecimal) {
		this.medicalDecimal = medicalDecimal;
	}


	public BigDecimal getMedical1Self() {
		return medical1Self;
	}

	public void setMedical1Self(BigDecimal medical1Self) {
		this.medical1Self = medical1Self;
	}

	public BigDecimal getMedical1Corp() {
		return medical1Corp;
	}

	public void setMedical1Corp(BigDecimal medical1Corp) {
		this.medical1Corp = medical1Corp;
	}

	public BigDecimal getIdlenessSelf() {
		return idlenessSelf;
	}

	public void setIdlenessSelf(BigDecimal idlenessSelf) {
		this.idlenessSelf = idlenessSelf;
	}

	public BigDecimal getIdlenessCorp() {
		return idlenessCorp;
	}

	public void setIdlenessCorp(BigDecimal idlenessCorp) {
		this.idlenessCorp = idlenessCorp;
	}

	public BigDecimal getIdlenessSelfMin() {
		return idlenessSelfMin;
	}

	public void setIdlenessSelfMin(BigDecimal idlenessSelfMin) {
		this.idlenessSelfMin = idlenessSelfMin;
	}

	public BigDecimal getIdlenessSelfMax() {
		return idlenessSelfMax;
	}

	public void setIdlenessSelfMax(BigDecimal idlenessSelfMax) {
		this.idlenessSelfMax = idlenessSelfMax;
	}

	public BigDecimal getIdlenessCorpMin() {
		return idlenessCorpMin;
	}

	public void setIdlenessCorpMin(BigDecimal idlenessCorpMin) {
		this.idlenessCorpMin = idlenessCorpMin;
	}

	public BigDecimal getIdlenessCorpMax() {
		return idlenessCorpMax;
	}

	public void setIdlenessCorpMax(BigDecimal idlenessCorpMax) {
		this.idlenessCorpMax = idlenessCorpMax;
	}

	public int getIdlenessDecimal() {
		return idlenessDecimal;
	}

	public void setIdlenessDecimal(int idlenessDecimal) {
		this.idlenessDecimal = idlenessDecimal;
	}

	public BigDecimal getCompoSelf() {
		return compoSelf;
	}

	public void setCompoSelf(BigDecimal compoSelf) {
		this.compoSelf = compoSelf;
	}

	public BigDecimal getCompoCorp() {
		return compoCorp;
	}

	public void setCompoCorp(BigDecimal compoCorp) {
		this.compoCorp = compoCorp;
	}

	public BigDecimal getCompoSelfMin() {
		return compoSelfMin;
	}

	public void setCompoSelfMin(BigDecimal compoSelfMin) {
		this.compoSelfMin = compoSelfMin;
	}

	public BigDecimal getCompoSelfMax() {
		return compoSelfMax;
	}

	public void setCompoSelfMax(BigDecimal compoSelfMax) {
		this.compoSelfMax = compoSelfMax;
	}

	public BigDecimal getCompoCorpMin() {
		return compoCorpMin;
	}

	public void setCompoCorpMin(BigDecimal compoCorpMin) {
		this.compoCorpMin = compoCorpMin;
	}

	public BigDecimal getCompoCorpMax() {
		return compoCorpMax;
	}

	public void setCompoCorpMax(BigDecimal compoCorpMax) {
		this.compoCorpMax = compoCorpMax;
	}

	public int getCompoDecimal() {
		return compoDecimal;
	}

	public void setCompoDecimal(int compoDecimal) {
		this.compoDecimal = compoDecimal;
	}

	public BigDecimal getBabySelf() {
		return babySelf;
	}

	public void setBabySelf(BigDecimal babySelf) {
		this.babySelf = babySelf;
	}

	public BigDecimal getBabyCorp() {
		return babyCorp;
	}

	public void setBabyCorp(BigDecimal babyCorp) {
		this.babyCorp = babyCorp;
	}

	public BigDecimal getBabySelfMin() {
		return babySelfMin;
	}

	public void setBabySelfMin(BigDecimal babySelfMin) {
		this.babySelfMin = babySelfMin;
	}

	public BigDecimal getBabySelfMax() {
		return babySelfMax;
	}

	public void setBabySelfMax(BigDecimal babySelfMax) {
		this.babySelfMax = babySelfMax;
	}

	public BigDecimal getBabyCorpMin() {
		return babyCorpMin;
	}

	public void setBabyCorpMin(BigDecimal babyCorpMin) {
		this.babyCorpMin = babyCorpMin;
	}

	public BigDecimal getBabyCorpMax() {
		return babyCorpMax;
	}

	public void setBabyCorpMax(BigDecimal babyCorpMax) {
		this.babyCorpMax = babyCorpMax;
	}

	public int getBabyDecimal() {
		return babyDecimal;
	}

	public void setBabyDecimal(int babyDecimal) {
		this.babyDecimal = babyDecimal;
	}

	public BigDecimal getOtherSelfMin() {
		return otherSelfMin;
	}

	public void setOtherSelfMin(BigDecimal otherSelfMin) {
		this.otherSelfMin = otherSelfMin;
	}

	public BigDecimal getOtherSelfMax() {
		return otherSelfMax;
	}

	public void setOtherSelfMax(BigDecimal otherSelfMax) {
		this.otherSelfMax = otherSelfMax;
	}

	public BigDecimal getOtherCorpMin() {
		return otherCorpMin;
	}

	public void setOtherCorpMin(BigDecimal otherCorpMin) {
		this.otherCorpMin = otherCorpMin;
	}

	public BigDecimal getOtherCorpMax() {
		return otherCorpMax;
	}

	public void setOtherCorpMax(BigDecimal otherCorpMax) {
		this.otherCorpMax = otherCorpMax;
	}

	public int getOtherDecimal() {
		return otherDecimal;
	}

	public void setOtherDecimal(int otherDecimal) {
		this.otherDecimal = otherDecimal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getAccumulationRound() {
		return accumulationRound;
	}

	public void setAccumulationRound(long accumulationRound) {
		this.accumulationRound = accumulationRound;
	}

	public long getAnnuitiesRound() {
		return annuitiesRound;
	}

	public void setAnnuitiesRound(long annuitiesRound) {
		this.annuitiesRound = annuitiesRound;
	}

	public long getMedicalRound() {
		return medicalRound;
	}

	public void setMedicalRound(long medicalRound) {
		this.medicalRound = medicalRound;
	}

	public long getIdlenessRound() {
		return idlenessRound;
	}

	public void setIdlenessRound(long idlenessRound) {
		this.idlenessRound = idlenessRound;
	}

	public long getCompoRound() {
		return compoRound;
	}

	public void setCompoRound(long compoRound) {
		this.compoRound = compoRound;
	}

	public long getBabyRound() {
		return babyRound;
	}

	public void setBabyRound(long babyRound) {
		this.babyRound = babyRound;
	}

	public long getOtherRound() {
		return otherRound;
	}

	public void setOtherRound(long otherRound) {
		this.otherRound = otherRound;
	}

	public String getAccuManagerLoginName() {
		return accuManagerLoginName;
	}

	public void setAccuManagerLoginName(String accuManagerLoginName) {
		this.accuManagerLoginName = accuManagerLoginName;
	}

	public String getAccuManagerName() {
		return accuManagerName;
	}

	public void setAccuManagerName(String accuManagerName) {
		this.accuManagerName = accuManagerName;
	}

	public String getAccuSubmitLoginName() {
		return accuSubmitLoginName;
	}

	public void setAccuSubmitLoginName(String accuSubmitLoginName) {
		this.accuSubmitLoginName = accuSubmitLoginName;
	}

	public String getAccuSubmitName() {
		return accuSubmitName;
	}

	public void setAccuSubmitName(String accuSubmitName) {
		this.accuSubmitName = accuSubmitName;
	}

	public String getBenefitManagerLoginName() {
		return benefitManagerLoginName;
	}

	public void setBenefitManagerLoginName(String benefitManagerLoginName) {
		this.benefitManagerLoginName = benefitManagerLoginName;
	}

	public String getBenefitManagerName() {
		return benefitManagerName;
	}

	public void setBenefitManagerName(String benefitManagerName) {
		this.benefitManagerName = benefitManagerName;
	}

	public String getBenefitSubmitLoginName() {
		return benefitSubmitLoginName;
	}

	public void setBenefitSubmitLoginName(String benefitSubmitLoginName) {
		this.benefitSubmitLoginName = benefitSubmitLoginName;
	}

	public String getBenefitSubmitName() {
		return benefitSubmitName;
	}

	public void setBenefitSubmitName(String benefitSubmitName) {
		this.benefitSubmitName = benefitSubmitName;
	}

	@Override
	public String getRowKey() {
		return String.valueOf(this.area) + ":" + String.valueOf(this.company);
	}

}
