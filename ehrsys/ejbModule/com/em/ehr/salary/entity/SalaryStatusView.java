/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.salary.entity;

public class SalaryStatusView extends SalaryStatus {

	private String name;

	private String loginName;

	private long depId;

	private long jobId;

	private long position;

	private long positionLevel;

	private long positionType;

	private long city;

	private long country;

	private long empStatus;

	private long empType;

	private boolean expedite;

	private long expediteDepId;

	private long sex;

	private String code;
	
	private long channel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public long getPositionLevel() {
		return positionLevel;
	}

	public void setPositionLevel(long positionLevel) {
		this.positionLevel = positionLevel;
	}

	public long getPositionType() {
		return positionType;
	}

	public void setPositionType(long positionType) {
		this.positionType = positionType;
	}

	public long getCity() {
		return city;
	}

	public void setCity(long city) {
		this.city = city;
	}

	public long getCountry() {
		return country;
	}

	public void setCountry(long country) {
		this.country = country;
	}

	public long getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(long empStatus) {
		this.empStatus = empStatus;
	}

	public long getEmpType() {
		return empType;
	}

	public void setEmpType(long empType) {
		this.empType = empType;
	}

	public boolean isExpedite() {
		return expedite;
	}

	public void setExpedite(boolean expedite) {
		this.expedite = expedite;
	}

	public long getExpediteDepId() {
		return expediteDepId;
	}

	public void setExpediteDepId(long expediteDepId) {
		this.expediteDepId = expediteDepId;
	}

	public long getSex() {
		return sex;
	}

	public void setSex(long sex) {
		this.sex = sex;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getChannel() {
		return channel;
	}

	public void setChannel(long channel) {
		this.channel = channel;
	}

}
