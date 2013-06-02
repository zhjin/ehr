/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.CodeBase;

@Entity
public class AttendTimeCode extends CodeBase {
	
	@Column
	private long depId;
	
	@Column(length=20)
	private String amBeginTime;
	
	@Column(length=20)
	private String amEndTime;
	
	@Column(length=20)
	private String pmBeginTime;
	
	@Column(length=20)
	private String pmEndTime;

	public String getAmBeginTime() {
		return amBeginTime;
	}

	public void setAmBeginTime(String amBeginTime) {
		this.amBeginTime = amBeginTime;
	}

	public String getAmEndTime() {
		return amEndTime;
	}

	public void setAmEndTime(String amEndTime) {
		this.amEndTime = amEndTime;
	}

	public String getPmBeginTime() {
		return pmBeginTime;
	}

	public void setPmBeginTime(String pmBeginTime) {
		this.pmBeginTime = pmBeginTime;
	}

	public String getPmEndTime() {
		return pmEndTime;
	}

	public void setPmEndTime(String pmEndTime) {
		this.pmEndTime = pmEndTime;
	}

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}
}
