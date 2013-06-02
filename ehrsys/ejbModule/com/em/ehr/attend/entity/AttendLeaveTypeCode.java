/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.CodeBase;

@Entity
public class AttendLeaveTypeCode extends CodeBase {
	
	/**
	 * 请假计算类型
	 * 1 - 按时计算
	 * 2 - 按天计算
	 */
	@Column
	private long leaveCalcType;
	
	@Column(length=40)
	private String calcColumnName;

	public long getLeaveCalcType() {
		return leaveCalcType;
	}

	public void setLeaveCalcType(long leaveCalcType) {
		this.leaveCalcType = leaveCalcType;
	}

	public String getCalcColumnName() {
		return calcColumnName;
	}

	public void setCalcColumnName(String calcColumnName) {
		this.calcColumnName = calcColumnName;
	}

}
