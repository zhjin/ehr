/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonProject extends EmployeePersonBaseEntity {
	@Column
	private Date beginDate;
	
	@Column
	private Date endDate;
	
	@Column(length=128)
	private String projectName;
	
	@Column(length=60)
	private String projectRole;

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}
}
