/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class AttendStatus extends EntityBase{
	
	@Id
	private long empId;
	
	@Column
	private long attendTime;
	
	@Column
	private boolean attendEnabled;
	
	@Column
	private boolean punchClock;
	
	@Column(length=40)
	private String cardNo;
	
	@Column(length=40)
	private String cardNo1;
	
	@Column(length=40)
	private String cardNo2;	
	
	@Column(length=128)
	private String remark;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getAttendTime() {
		return attendTime;
	}

	public void setAttendTime(long attendTime) {
		this.attendTime = attendTime;
	}

	public boolean isPunchClock() {
		return punchClock;
	}

	public void setPunchClock(boolean punchClock) {
		this.punchClock = punchClock;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public boolean isAttendEnabled() {
		return attendEnabled;
	}

	public void setAttendEnabled(boolean attendEnabled) {
		this.attendEnabled = attendEnabled;
	}

	@Override
	public String getRowKey() {
		return this.empId + ":" + this.attendTime;
	}
}
