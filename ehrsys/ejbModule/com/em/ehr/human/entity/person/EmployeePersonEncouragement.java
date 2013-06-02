/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonEncouragement extends EmployeePersonBaseEntity {
	@Column(length=20)
	private String encouragementType;
	
	@Column(length=60)
	private String place;
	
	@Column
	private Date encouragementTime;
	
	@Column(length=100)
	private String reason;
	
	@Column(length=100)
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEncouragementTime() {
		return encouragementTime;
	}

	public void setEncouragementTime(Date encouragementTime) {
		this.encouragementTime = encouragementTime;
	}

	public String getEncouragementType() {
		return encouragementType;
	}

	public void setEncouragementType(String encouragementType) {
		this.encouragementType = encouragementType;
	}


	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
