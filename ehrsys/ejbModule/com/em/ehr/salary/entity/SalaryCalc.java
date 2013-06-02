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
import javax.persistence.IdClass;

import com.em.ehr.base.CalcPK;
import com.zhjin.base.EntityBase;

@Entity
@IdClass(value = CalcPK.class)
public class SalaryCalc extends EntityBase {

	@Id
	private long empId;
	
	@Id
	private long company;
	
	@Id
	private Date calcMonth;
	
	@Column(length=20)
	private String name;
	
	@Column(length=40)
	private String loginName;
	
	@Column
	private long empStatus;
	
	@Column
	private long empType;
	
	@Column
	private long depId;
	
	@Column
	private long payDepId;
	
	@Column
	private long jobId;
	
	@Column
	private long position;
	
	@Column
	private long positionLevel;
	
	@Column
	private long city;
	
	@Column
	private long country;
	
	@Column
	private long bankId;
	
	@Column(length=40)
	private String bankCardNo;
	
	@Column
	private boolean expedite;
	
	@Column
	private long expediteDepId;
	
	@Column
	private boolean agreeSalary;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal standard;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal factStandard;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal supplyBeforeTotal;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal deductBeforeTotal;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal supplyBeforeTotal1;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal deductBeforeTotal1;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal supplyAfterTotal;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal deductAfterTotal;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal supplyAfterTotal1;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal deductAfterTotal1;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal absentTotal;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal payBeforeTax;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal tax;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal factPay;
	
	@Column
	private int probDays;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal probPay;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal probDaysPay;
	
	@Column
	private int normalDays;
	
	@Column
	private int workDays;
	
	@Column
	private BigDecimal normalDaysPay;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal accumulationSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal accumulationCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal annuitiesCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal medicalCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal idlenessCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal compoCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal babySelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal babyCorp;
	@Column(precision = 10, scale = 2)
	private BigDecimal otherSelf;
	@Column(precision = 10, scale = 2)
	private BigDecimal otherCorp;

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
	@Column(precision = 10, scale = 2)
	private BigDecimal v6;
	@Column(precision = 10, scale = 2)
	private BigDecimal v7;
	@Column(precision = 10, scale = 2)
	private BigDecimal v8;
	@Column(precision = 10, scale = 2)
	private BigDecimal v9;
	@Column(precision = 10, scale = 2)
	private BigDecimal v10;
	@Column(precision = 10, scale = 2)
	private BigDecimal v11;
	@Column(precision = 10, scale = 2)
	private BigDecimal v12;
	@Column(precision = 10, scale = 2)
	private BigDecimal v13;
	@Column(precision = 10, scale = 2)
	private BigDecimal v14;
	@Column(precision = 10, scale = 2)
	private BigDecimal v15;
	@Column(precision = 10, scale = 2)
	private BigDecimal v16;
	@Column(precision = 10, scale = 2)
	private BigDecimal v17;
	@Column(precision = 10, scale = 2)
	private BigDecimal v18;
	@Column(precision = 10, scale = 2)
	private BigDecimal v19;
	@Column(precision = 10, scale = 2)
	private BigDecimal v20;
	@Column(precision = 10, scale = 2)
	private BigDecimal v21;
	@Column(precision = 10, scale = 2)
	private BigDecimal v22;
	@Column(precision = 10, scale = 2)
	private BigDecimal v23;
	@Column(precision = 10, scale = 2)
	private BigDecimal v24;
	@Column(precision = 10, scale = 2)
	private BigDecimal v25;
	@Column(precision = 10, scale = 2)
	private BigDecimal v26;
	@Column(precision = 10, scale = 2)
	private BigDecimal v27;
	@Column(precision = 10, scale = 2)
	private BigDecimal v28;
	@Column(precision = 10, scale = 2)
	private BigDecimal v29;
	@Column(precision = 10, scale = 2)
	private BigDecimal v30;
	@Column(precision = 10, scale = 2)
	private BigDecimal v31;
	@Column(precision = 10, scale = 2)
	private BigDecimal v32;
	@Column(precision = 10, scale = 2)
	private BigDecimal v33;
	@Column(precision = 10, scale = 2)
	private BigDecimal v34;
	@Column(precision = 10, scale = 2)
	private BigDecimal v35;
	@Column(precision = 10, scale = 2)
	private BigDecimal v36;
	@Column(precision = 10, scale = 2)
	private BigDecimal v37;
	@Column(precision = 10, scale = 2)
	private BigDecimal v38;
	@Column(precision = 10, scale = 2)
	private BigDecimal v39;
	@Column(precision = 10, scale = 2)
	private BigDecimal v40;
	@Column(precision = 10, scale = 2)
	private BigDecimal v41;
	@Column(precision = 10, scale = 2)
	private BigDecimal v42;
	@Column(precision = 10, scale = 2)
	private BigDecimal v43;
	@Column(precision = 10, scale = 2)
	private BigDecimal v44;
	@Column(precision = 10, scale = 2)
	private BigDecimal v45;
	@Column(precision = 10, scale = 2)
	private BigDecimal v46;
	@Column(precision = 10, scale = 2)
	private BigDecimal v47;
	@Column(precision = 10, scale = 2)
	private BigDecimal v48;
	@Column(precision = 10, scale = 2)
	private BigDecimal v49;
	@Column(precision = 10, scale = 2)
	private BigDecimal v50;
	@Column(precision = 10, scale = 2)
	private BigDecimal v51;
	@Column(precision = 10, scale = 2)
	private BigDecimal v52;
	@Column(precision = 10, scale = 2)
	private BigDecimal v53;
	@Column(precision = 10, scale = 2)
	private BigDecimal v54;
	@Column(precision = 10, scale = 2)
	private BigDecimal v55;
	@Column(precision = 10, scale = 2)
	private BigDecimal v56;
	@Column(precision = 10, scale = 2)
	private BigDecimal v57;
	@Column(precision = 10, scale = 2)
	private BigDecimal v58;
	@Column(precision = 10, scale = 2)
	private BigDecimal v59;
	@Column(precision = 10, scale = 2)
	private BigDecimal v60;
	
	@Column(length=120)
	private String remark;
	
	@Column(length=120)
	private String statusRemark;
	
	public Date getCalcMonth() {
		return calcMonth;
	}
	public void setCalcMonth(Date calcMonth) {
		this.calcMonth = calcMonth;
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
	public boolean isAgreeSalary() {
		return agreeSalary;
	}
	public void setAgreeSalary(boolean agreeSalary) {
		this.agreeSalary = agreeSalary;
	}
	public BigDecimal getStandard() {
		return standard;
	}
	public void setStandard(BigDecimal standard) {
		this.standard = standard;
	}
	public BigDecimal getSupplyBeforeTotal() {
		return supplyBeforeTotal;
	}
	public void setSupplyBeforeTotal(BigDecimal supplyBeforeTotal) {
		this.supplyBeforeTotal = supplyBeforeTotal;
	}
	public BigDecimal getDeductBeforeTotal() {
		return deductBeforeTotal;
	}
	public void setDeductBeforeTotal(BigDecimal deductBeforeTotal) {
		this.deductBeforeTotal = deductBeforeTotal;
	}
	public BigDecimal getSupplyAfterTotal() {
		return supplyAfterTotal;
	}
	public void setSupplyAfterTotal(BigDecimal supplyAfterTotal) {
		this.supplyAfterTotal = supplyAfterTotal;
	}
	public BigDecimal getDeductAfterTotal() {
		return deductAfterTotal;
	}
	public void setDeductAfterTotal(BigDecimal deductAfterTotal) {
		this.deductAfterTotal = deductAfterTotal;
	}
	public BigDecimal getAbsentTotal() {
		return absentTotal;
	}
	public void setAbsentTotal(BigDecimal absentTotal) {
		this.absentTotal = absentTotal;
	}
	public BigDecimal getPayBeforeTax() {
		return payBeforeTax;
	}
	public void setPayBeforeTax(BigDecimal payBeforeTax) {
		this.payBeforeTax = payBeforeTax;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public BigDecimal getFactPay() {
		return factPay;
	}
	public void setFactPay(BigDecimal factPay) {
		this.factPay = factPay;
	}
	public BigDecimal getAccumulationSelf() {
		return accumulationSelf;
	}
	public void setAccumulationSelf(BigDecimal accumulationSelf) {
		this.accumulationSelf = accumulationSelf;
	}
	public BigDecimal getAnnuitiesSelf() {
		return annuitiesSelf;
	}
	public void setAnnuitiesSelf(BigDecimal annuitiesSelf) {
		this.annuitiesSelf = annuitiesSelf;
	}
	public BigDecimal getMedicalSelf() {
		return medicalSelf;
	}
	public void setMedicalSelf(BigDecimal medicalSelf) {
		this.medicalSelf = medicalSelf;
	}
	public BigDecimal getIdlenessSelf() {
		return idlenessSelf;
	}
	public void setIdlenessSelf(BigDecimal idlenessSelf) {
		this.idlenessSelf = idlenessSelf;
	}
	public BigDecimal getCompoSelf() {
		return compoSelf;
	}
	public void setCompoSelf(BigDecimal compoSelf) {
		this.compoSelf = compoSelf;
	}
	public BigDecimal getBabySelf() {
		return babySelf;
	}
	public void setBabySelf(BigDecimal babySelf) {
		this.babySelf = babySelf;
	}
	public BigDecimal getOtherSelf() {
		return otherSelf;
	}
	public void setOtherSelf(BigDecimal otherSelf) {
		this.otherSelf = otherSelf;
	}
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
	public BigDecimal getV6() {
		return v6;
	}
	public void setV6(BigDecimal v6) {
		this.v6 = v6;
	}
	public BigDecimal getV7() {
		return v7;
	}
	public void setV7(BigDecimal v7) {
		this.v7 = v7;
	}
	public BigDecimal getV8() {
		return v8;
	}
	public void setV8(BigDecimal v8) {
		this.v8 = v8;
	}
	public BigDecimal getV9() {
		return v9;
	}
	public void setV9(BigDecimal v9) {
		this.v9 = v9;
	}
	public BigDecimal getV10() {
		return v10;
	}
	public void setV10(BigDecimal v10) {
		this.v10 = v10;
	}
	public BigDecimal getV11() {
		return v11;
	}
	public void setV11(BigDecimal v11) {
		this.v11 = v11;
	}
	public BigDecimal getV12() {
		return v12;
	}
	public void setV12(BigDecimal v12) {
		this.v12 = v12;
	}
	public BigDecimal getV13() {
		return v13;
	}
	public void setV13(BigDecimal v13) {
		this.v13 = v13;
	}
	public BigDecimal getV14() {
		return v14;
	}
	public void setV14(BigDecimal v14) {
		this.v14 = v14;
	}
	public BigDecimal getV15() {
		return v15;
	}
	public void setV15(BigDecimal v15) {
		this.v15 = v15;
	}
	public BigDecimal getV16() {
		return v16;
	}
	public void setV16(BigDecimal v16) {
		this.v16 = v16;
	}
	public BigDecimal getV17() {
		return v17;
	}
	public void setV17(BigDecimal v17) {
		this.v17 = v17;
	}
	public BigDecimal getV18() {
		return v18;
	}
	public void setV18(BigDecimal v18) {
		this.v18 = v18;
	}
	public BigDecimal getV19() {
		return v19;
	}
	public void setV19(BigDecimal v19) {
		this.v19 = v19;
	}
	public BigDecimal getV20() {
		return v20;
	}
	public void setV20(BigDecimal v20) {
		this.v20 = v20;
	}
	public BigDecimal getV21() {
		return v21;
	}
	public void setV21(BigDecimal v21) {
		this.v21 = v21;
	}
	public BigDecimal getV22() {
		return v22;
	}
	public void setV22(BigDecimal v22) {
		this.v22 = v22;
	}
	public BigDecimal getV23() {
		return v23;
	}
	public void setV23(BigDecimal v23) {
		this.v23 = v23;
	}
	public BigDecimal getV24() {
		return v24;
	}
	public void setV24(BigDecimal v24) {
		this.v24 = v24;
	}
	public BigDecimal getV25() {
		return v25;
	}
	public void setV25(BigDecimal v25) {
		this.v25 = v25;
	}
	public BigDecimal getV26() {
		return v26;
	}
	public void setV26(BigDecimal v26) {
		this.v26 = v26;
	}
	public BigDecimal getV27() {
		return v27;
	}
	public void setV27(BigDecimal v27) {
		this.v27 = v27;
	}
	public BigDecimal getV28() {
		return v28;
	}
	public void setV28(BigDecimal v28) {
		this.v28 = v28;
	}
	public BigDecimal getV29() {
		return v29;
	}
	public void setV29(BigDecimal v29) {
		this.v29 = v29;
	}
	public BigDecimal getV30() {
		return v30;
	}
	public void setV30(BigDecimal v30) {
		this.v30 = v30;
	}
	public BigDecimal getV31() {
		return v31;
	}
	public void setV31(BigDecimal v31) {
		this.v31 = v31;
	}
	public BigDecimal getV32() {
		return v32;
	}
	public void setV32(BigDecimal v32) {
		this.v32 = v32;
	}
	public BigDecimal getV33() {
		return v33;
	}
	public void setV33(BigDecimal v33) {
		this.v33 = v33;
	}
	public BigDecimal getV34() {
		return v34;
	}
	public void setV34(BigDecimal v34) {
		this.v34 = v34;
	}
	public BigDecimal getV35() {
		return v35;
	}
	public void setV35(BigDecimal v35) {
		this.v35 = v35;
	}
	public BigDecimal getV36() {
		return v36;
	}
	public void setV36(BigDecimal v36) {
		this.v36 = v36;
	}
	public BigDecimal getV37() {
		return v37;
	}
	public void setV37(BigDecimal v37) {
		this.v37 = v37;
	}
	public BigDecimal getV38() {
		return v38;
	}
	public void setV38(BigDecimal v38) {
		this.v38 = v38;
	}
	public BigDecimal getV39() {
		return v39;
	}
	public void setV39(BigDecimal v39) {
		this.v39 = v39;
	}
	public BigDecimal getV40() {
		return v40;
	}
	public void setV40(BigDecimal v40) {
		this.v40 = v40;
	}
	public BigDecimal getV41() {
		return v41;
	}
	public void setV41(BigDecimal v41) {
		this.v41 = v41;
	}
	public BigDecimal getV42() {
		return v42;
	}
	public void setV42(BigDecimal v42) {
		this.v42 = v42;
	}
	public BigDecimal getV43() {
		return v43;
	}
	public void setV43(BigDecimal v43) {
		this.v43 = v43;
	}
	public BigDecimal getV44() {
		return v44;
	}
	public void setV44(BigDecimal v44) {
		this.v44 = v44;
	}
	public BigDecimal getV45() {
		return v45;
	}
	public void setV45(BigDecimal v45) {
		this.v45 = v45;
	}
	public BigDecimal getV46() {
		return v46;
	}
	public void setV46(BigDecimal v46) {
		this.v46 = v46;
	}
	public BigDecimal getV47() {
		return v47;
	}
	public void setV47(BigDecimal v47) {
		this.v47 = v47;
	}
	public BigDecimal getV48() {
		return v48;
	}
	public void setV48(BigDecimal v48) {
		this.v48 = v48;
	}
	public BigDecimal getV49() {
		return v49;
	}
	public void setV49(BigDecimal v49) {
		this.v49 = v49;
	}
	public BigDecimal getV50() {
		return v50;
	}
	public void setV50(BigDecimal v50) {
		this.v50 = v50;
	}
	public int getProbDays() {
		return probDays;
	}
	public void setProbDays(int probDays) {
		this.probDays = probDays;
	}
	public int getNormalDays() {
		return normalDays;
	}
	public void setNormalDays(int normalDays) {
		this.normalDays = normalDays;
	}

	public boolean isExpedite() {
		return expedite;
	}
	public void setExpedite(boolean expedite) {
		this.expedite = expedite;
	}

	public BigDecimal getProbPay() {
		return probPay;
	}
	public void setProbPay(BigDecimal probPay) {
		this.probPay = probPay;
	}
	public BigDecimal getProbDaysPay() {
		return probDaysPay;
	}
	public void setProbDaysPay(BigDecimal probDaysPay) {
		this.probDaysPay = probDaysPay;
	}
	public BigDecimal getNormalDaysPay() {
		return normalDaysPay;
	}
	public void setNormalDaysPay(BigDecimal normalDaysPay) {
		this.normalDaysPay = normalDaysPay;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public BigDecimal getFactStandard() {
		return factStandard;
	}
	public void setFactStandard(BigDecimal factStandard) {
		this.factStandard = factStandard;
	}
	public int getWorkDays() {
		return workDays;
	}
	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}
	public BigDecimal getAccumulationCorp() {
		return accumulationCorp;
	}
	public void setAccumulationCorp(BigDecimal accumulationCorp) {
		this.accumulationCorp = accumulationCorp;
	}
	public BigDecimal getAnnuitiesCorp() {
		return annuitiesCorp;
	}
	public void setAnnuitiesCorp(BigDecimal annuitiesCorp) {
		this.annuitiesCorp = annuitiesCorp;
	}
	public BigDecimal getMedicalCorp() {
		return medicalCorp;
	}
	public void setMedicalCorp(BigDecimal medicalCorp) {
		this.medicalCorp = medicalCorp;
	}
	public BigDecimal getIdlenessCorp() {
		return idlenessCorp;
	}
	public void setIdlenessCorp(BigDecimal idlenessCorp) {
		this.idlenessCorp = idlenessCorp;
	}
	public BigDecimal getCompoCorp() {
		return compoCorp;
	}
	public void setCompoCorp(BigDecimal compoCorp) {
		this.compoCorp = compoCorp;
	}
	public BigDecimal getBabyCorp() {
		return babyCorp;
	}
	public void setBabyCorp(BigDecimal babyCorp) {
		this.babyCorp = babyCorp;
	}
	public BigDecimal getOtherCorp() {
		return otherCorp;
	}
	public void setOtherCorp(BigDecimal otherCorp) {
		this.otherCorp = otherCorp;
	}
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	public String getStatusRemark() {
		return statusRemark;
	}
	public void setStatusRemark(String statusRemark) {
		this.statusRemark = statusRemark;
	}
	public BigDecimal getSupplyBeforeTotal1() {
		return supplyBeforeTotal1;
	}
	public void setSupplyBeforeTotal1(BigDecimal supplyBeforeTotal1) {
		this.supplyBeforeTotal1 = supplyBeforeTotal1;
	}
	public BigDecimal getDeductBeforeTotal1() {
		return deductBeforeTotal1;
	}
	public void setDeductBeforeTotal1(BigDecimal deductBeforeTotal1) {
		this.deductBeforeTotal1 = deductBeforeTotal1;
	}
	public BigDecimal getSupplyAfterTotal1() {
		return supplyAfterTotal1;
	}
	public void setSupplyAfterTotal1(BigDecimal supplyAfterTotal1) {
		this.supplyAfterTotal1 = supplyAfterTotal1;
	}
	public BigDecimal getDeductAfterTotal1() {
		return deductAfterTotal1;
	}
	public void setDeductAfterTotal1(BigDecimal deductAfterTotal1) {
		this.deductAfterTotal1 = deductAfterTotal1;
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
	public long getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(long empStatus) {
		this.empStatus = empStatus;
	}
	public long getEmpType() {
		return empType;
	}
	public void setEmpType(long empType) {
		this.empType = empType;
	}
	public long getDepId() {
		return depId;
	}
	public void setDepId(long depId) {
		this.depId = depId;
	}
	public long getPayDepId() {
		return payDepId;
	}
	public void setPayDepId(long payDepId) {
		this.payDepId = payDepId;
	}
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public long getPosition() {
		return position;
	}
	public void setPosition(long position) {
		this.position = position;
	}
	public long getPositionLevel() {
		return positionLevel;
	}
	public void setPositionLevel(long positionLevel) {
		this.positionLevel = positionLevel;
	}
	public long getCity() {
		return city;
	}
	public void setCity(long city) {
		this.city = city;
	}
	public long getCountry() {
		return country;
	}
	public void setCountry(long country) {
		this.country = country;
	}
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public long getExpediteDepId() {
		return expediteDepId;
	}
	public void setExpediteDepId(long expediteDepId) {
		this.expediteDepId = expediteDepId;
	}
	public BigDecimal getV51() {
		return v51;
	}
	public void setV51(BigDecimal v51) {
		this.v51 = v51;
	}
	public BigDecimal getV52() {
		return v52;
	}
	public void setV52(BigDecimal v52) {
		this.v52 = v52;
	}
	public BigDecimal getV53() {
		return v53;
	}
	public void setV53(BigDecimal v53) {
		this.v53 = v53;
	}
	public BigDecimal getV54() {
		return v54;
	}
	public void setV54(BigDecimal v54) {
		this.v54 = v54;
	}
	public BigDecimal getV55() {
		return v55;
	}
	public void setV55(BigDecimal v55) {
		this.v55 = v55;
	}
	public BigDecimal getV56() {
		return v56;
	}
	public void setV56(BigDecimal v56) {
		this.v56 = v56;
	}
	public BigDecimal getV57() {
		return v57;
	}
	public void setV57(BigDecimal v57) {
		this.v57 = v57;
	}
	public BigDecimal getV58() {
		return v58;
	}
	public void setV58(BigDecimal v58) {
		this.v58 = v58;
	}
	public BigDecimal getV59() {
		return v59;
	}
	public void setV59(BigDecimal v59) {
		this.v59 = v59;
	}
	public BigDecimal getV60() {
		return v60;
	}
	public void setV60(BigDecimal v60) {
		this.v60 = v60;
	}
	
	@Override
	public String getRowKey() {
		return this.empId + ":" + this.company + ":" + this.calcMonth;
	}

}
