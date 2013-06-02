/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonSkill extends EmployeePersonBaseEntity {

	@Column(length=40)
	private String skillName;
	
	@Column(length=20)
	private String hold;
	
	@Column(length=100)
	private String description;
	
	@Column(length=40)
	private String certNo;
	
	@Column
	private Date skillTime;
	
	@Column
	private Integer limit;

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Date getSkillTime() {
		return skillTime;
	}

	public void setSkillTime(Date skillTime) {
		this.skillTime = skillTime;
	}
	
}
