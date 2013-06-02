/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonCommunity extends EmployeePersonBaseEntity {
	@Column(length=120)
	private String unitname;
	
	@Column(length=60)
	private String depname;
	
	@Column(length=40)
	private String principalship;
	
	@Column
	private Date beginTime;
	
	@Column
	private Date endTime;
	
	@Column
	private boolean valid;

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPrincipalship() {
		return principalship;
	}

	public void setPrincipalship(String principalship) {
		this.principalship = principalship;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
