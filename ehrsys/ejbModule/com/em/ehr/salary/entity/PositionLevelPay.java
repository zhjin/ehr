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
public class PositionLevelPay extends EntityBase {
	
	@Id
	private long positionId;
	
	@Column
	private int indexNo;
	
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
	
	@Column(length=120)
	private String remark;

	public long getPositionId() {
		return positionId;
	}

	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
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

	@Override
	public String getRowKey() {
		return String.valueOf(this.positionId);
	}
	
}
