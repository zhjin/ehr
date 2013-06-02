/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.salary.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class SalaryStatus extends EntityBase {

	@Id
	private long empId;
	
	@Column
	private long payDepId;
	
	@Column
	private long payJobId;
	
	@Column
	private long payPosition;
	
	@Column
	private long payPositionLevel;
	
	@Column
	private long payCity;
	
	@Column
	private long payCountry;
	
	@Column
	private long payType;

	@Column
	private long bankId;
	
	@Column(length=40)
	private String bankCardNo;
	
	@Column
	private long bankId2;
	
	@Column(length=40)
	private String bandCardNo2;
	
	@Column
	private long bankId3;
	
	@Column(length=40)
	private String bandCardNo3;
	
	@Column
	private long bankId1;
	
	@Column(length=40)
	private String bandCardNo1;
	
	@Column
	private boolean realPay;
	
	@Column
	private boolean realPay1;
	
	@Column
	private boolean realPay2;
	
	@Column
	private boolean realPay3;
	
	@Column
	private boolean realPay4;
	
	@Column
	private boolean agreeSalary;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal agreeStandard;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal probPay;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal standard;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal supply1;
	@Column(precision = 10, scale = 2)
	private BigDecimal supply2;
	@Column(precision = 10, scale = 2)
	private BigDecimal supply3;
	@Column(precision = 10, scale = 2)
	private BigDecimal supply4;
	@Column(precision = 10, scale = 2)
	private BigDecimal supply5;
	@Column(precision = 10, scale = 2)
	private BigDecimal supply6;
	@Column(precision = 10, scale = 2)
	private BigDecimal supply7;
	@Column(precision = 10, scale = 2)
	private BigDecimal supply8;
	@Column(precision = 10, scale = 2)
	private BigDecimal supply9;
	@Column(precision = 10, scale = 2)
	private BigDecimal supply10;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct1;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct2;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct3;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct4;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct5;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct6;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct7;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct8;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct9;
	@Column(precision = 10, scale = 2)
	private BigDecimal deduct10;
	
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
	
	@Column(length=120)
	private String remark;
	
	@Column(length=120)
	private String remark1;

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

	public long getPayDepId() {
		return payDepId;
	}

	public void setPayDepId(long payDepId) {
		this.payDepId = payDepId;
	}

	public long getPayJobId() {
		return payJobId;
	}

	public void setPayJobId(long payJobId) {
		this.payJobId = payJobId;
	}

	public long getPayPosition() {
		return payPosition;
	}

	public void setPayPosition(long payPosition) {
		this.payPosition = payPosition;
	}

	public long getPayPositionLevel() {
		return payPositionLevel;
	}

	public void setPayPositionLevel(long payPositionLevel) {
		this.payPositionLevel = payPositionLevel;
	}

	public long getPayCity() {
		return payCity;
	}

	public void setPayCity(long payCity) {
		this.payCity = payCity;
	}

	public long getPayCountry() {
		return payCountry;
	}

	public void setPayCountry(long payCountry) {
		this.payCountry = payCountry;
	}

	public long getPayType() {
		return payType;
	}

	public void setPayType(long payType) {
		this.payType = payType;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public long getBankId2() {
		return bankId2;
	}

	public void setBankId2(long bankId2) {
		this.bankId2 = bankId2;
	}

	public String getBandCardNo2() {
		return bandCardNo2;
	}

	public void setBandCardNo2(String bandCardNo2) {
		this.bandCardNo2 = bandCardNo2;
	}

	public long getBankId3() {
		return bankId3;
	}

	public void setBankId3(long bankId3) {
		this.bankId3 = bankId3;
	}

	public String getBandCardNo3() {
		return bandCardNo3;
	}

	public void setBandCardNo3(String bandCardNo3) {
		this.bandCardNo3 = bandCardNo3;
	}

	public long getBankId1() {
		return bankId1;
	}

	public void setBankId1(long bankId1) {
		this.bankId1 = bankId1;
	}

	public String getBandCardNo1() {
		return bandCardNo1;
	}

	public void setBandCardNo1(String bandCardNo1) {
		this.bandCardNo1 = bandCardNo1;
	}

	public boolean isRealPay() {
		return realPay;
	}

	public void setRealPay(boolean realPay) {
		this.realPay = realPay;
	}

	public boolean isRealPay1() {
		return realPay1;
	}

	public void setRealPay1(boolean realPay1) {
		this.realPay1 = realPay1;
	}

	public boolean isRealPay2() {
		return realPay2;
	}

	public void setRealPay2(boolean realPay2) {
		this.realPay2 = realPay2;
	}

	public boolean isRealPay3() {
		return realPay3;
	}

	public void setRealPay3(boolean realPay3) {
		this.realPay3 = realPay3;
	}

	public boolean isRealPay4() {
		return realPay4;
	}

	public void setRealPay4(boolean realPay4) {
		this.realPay4 = realPay4;
	}

	public boolean isAgreeSalary() {
		return agreeSalary;
	}

	public void setAgreeSalary(boolean agreeSalary) {
		this.agreeSalary = agreeSalary;
	}

	public BigDecimal getAgreeStandard() {
		return agreeStandard;
	}

	public void setAgreeStandard(BigDecimal agreeStandard) {
		this.agreeStandard = agreeStandard;
	}

	public BigDecimal getProbPay() {
		return probPay;
	}

	public void setProbPay(BigDecimal probPay) {
		this.probPay = probPay;
	}

	public BigDecimal getStandard() {
		return standard;
	}

	public void setStandard(BigDecimal standard) {
		this.standard = standard;
	}

	public BigDecimal getSupply1() {
		return supply1;
	}

	public void setSupply1(BigDecimal supply1) {
		this.supply1 = supply1;
	}

	public BigDecimal getSupply2() {
		return supply2;
	}

	public void setSupply2(BigDecimal supply2) {
		this.supply2 = supply2;
	}

	public BigDecimal getSupply3() {
		return supply3;
	}

	public void setSupply3(BigDecimal supply3) {
		this.supply3 = supply3;
	}

	public BigDecimal getSupply4() {
		return supply4;
	}

	public void setSupply4(BigDecimal supply4) {
		this.supply4 = supply4;
	}

	public BigDecimal getSupply5() {
		return supply5;
	}

	public void setSupply5(BigDecimal supply5) {
		this.supply5 = supply5;
	}

	public BigDecimal getSupply6() {
		return supply6;
	}

	public void setSupply6(BigDecimal supply6) {
		this.supply6 = supply6;
	}

	public BigDecimal getSupply7() {
		return supply7;
	}

	public void setSupply7(BigDecimal supply7) {
		this.supply7 = supply7;
	}

	public BigDecimal getSupply8() {
		return supply8;
	}

	public void setSupply8(BigDecimal supply8) {
		this.supply8 = supply8;
	}

	public BigDecimal getSupply9() {
		return supply9;
	}

	public void setSupply9(BigDecimal supply9) {
		this.supply9 = supply9;
	}

	public BigDecimal getSupply10() {
		return supply10;
	}

	public void setSupply10(BigDecimal supply10) {
		this.supply10 = supply10;
	}

	public BigDecimal getDeduct1() {
		return deduct1;
	}

	public void setDeduct1(BigDecimal deduct1) {
		this.deduct1 = deduct1;
	}

	public BigDecimal getDeduct2() {
		return deduct2;
	}

	public void setDeduct2(BigDecimal deduct2) {
		this.deduct2 = deduct2;
	}

	public BigDecimal getDeduct3() {
		return deduct3;
	}

	public void setDeduct3(BigDecimal deduct3) {
		this.deduct3 = deduct3;
	}

	public BigDecimal getDeduct4() {
		return deduct4;
	}

	public void setDeduct4(BigDecimal deduct4) {
		this.deduct4 = deduct4;
	}

	public BigDecimal getDeduct5() {
		return deduct5;
	}

	public void setDeduct5(BigDecimal deduct5) {
		this.deduct5 = deduct5;
	}

	public BigDecimal getDeduct6() {
		return deduct6;
	}

	public void setDeduct6(BigDecimal deduct6) {
		this.deduct6 = deduct6;
	}

	public BigDecimal getDeduct7() {
		return deduct7;
	}

	public void setDeduct7(BigDecimal deduct7) {
		this.deduct7 = deduct7;
	}

	public BigDecimal getDeduct8() {
		return deduct8;
	}

	public void setDeduct8(BigDecimal deduct8) {
		this.deduct8 = deduct8;
	}

	public BigDecimal getDeduct9() {
		return deduct9;
	}

	public void setDeduct9(BigDecimal deduct9) {
		this.deduct9 = deduct9;
	}

	public BigDecimal getDeduct10() {
		return deduct10;
	}

	public void setDeduct10(BigDecimal deduct10) {
		this.deduct10 = deduct10;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	
}
