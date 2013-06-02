/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.entity.OperateDataBase;

@Entity
public class EmployeeLostCard extends OperateDataBase {
	
	@Column
	private Date cardTime;
	
	@Column(length=40)
	private String cardNo;
	
	@Column(length=40)
	private String cardNo1;
	
	@Column(length=40)
	private String cardNo2;	
	
	@Column
	private long lostReason;

	public Date getCardTime() {
		return cardTime;
	}

	public void setCardTime(Date cardTime) {
		this.cardTime = cardTime;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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

	public long getLostReason() {
		return lostReason;
	}

	public void setLostReason(long lostReason) {
		this.lostReason = lostReason;
	}

}
