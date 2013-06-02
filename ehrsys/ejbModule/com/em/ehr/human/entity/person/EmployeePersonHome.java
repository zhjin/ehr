/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonHome extends EmployeePersonBaseEntity {
	@Column(length=40)
	private String name;
	
	@Column(length=20)
	private String code;
	
	@Column(length=20)
	private String relation;
	
	@Column(length=100)
	private String workPlace;
	
	@Column(length=40)
	private String telephone;
	
	@Column(length=40)
	private String mobile;
	
	@Column(length=100)
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
