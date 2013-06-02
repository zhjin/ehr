/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human;

import java.util.Date;

import com.em.ehr.human.entity.Employee;

public class EmployeeView extends Employee {
	
	private long empId;

	private String code;

	private String email;

	private long degree;

	private String homePlace;

	private long sex;

	private Date birthday;

	private long residence;

	private long blood;

	private long nation;
	
	private long education;

	private boolean marriage;
	
	private long compoType;
	
	private Date beginWorkTime;

	private String speciality;
	
	private String graduateSchool;
	
	private String graduateSpeciality;
	
	private long polity;
	
	private Date joinDate;
	
	private String specialityPosition;
	
	private String specialityPositionLevel;

	private String postalcode;
	
	private boolean practitioners;
	
	private Date beginPractitionersTime;

	private boolean finish;
	
	private int age;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDegree() {
		return degree;
	}

	public void setDegree(long degree) {
		this.degree = degree;
	}

	public String getHomePlace() {
		return homePlace;
	}

	public void setHomePlace(String homePlace) {
		this.homePlace = homePlace;
	}

	public long getSex() {
		return sex;
	}

	public void setSex(long sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public long getResidence() {
		return residence;
	}

	public void setResidence(long residence) {
		this.residence = residence;
	}

	public long getBlood() {
		return blood;
	}

	public void setBlood(long blood) {
		this.blood = blood;
	}

	public long getNation() {
		return nation;
	}

	public void setNation(long nation) {
		this.nation = nation;
	}

	public long getEducation() {
		return education;
	}

	public void setEducation(long education) {
		this.education = education;
	}

	public boolean isMarriage() {
		return marriage;
	}

	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}

	public long getCompoType() {
		return compoType;
	}

	public void setCompoType(long compoType) {
		this.compoType = compoType;
	}

	public Date getBeginWorkTime() {
		return beginWorkTime;
	}

	public void setBeginWorkTime(Date beginWorkTime) {
		this.beginWorkTime = beginWorkTime;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public String getGraduateSpeciality() {
		return graduateSpeciality;
	}

	public void setGraduateSpeciality(String graduateSpeciality) {
		this.graduateSpeciality = graduateSpeciality;
	}

	public long getPolity() {
		return polity;
	}

	public void setPolity(long polity) {
		this.polity = polity;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getSpecialityPosition() {
		return specialityPosition;
	}

	public void setSpecialityPosition(String specialityPosition) {
		this.specialityPosition = specialityPosition;
	}

	public String getSpecialityPositionLevel() {
		return specialityPositionLevel;
	}

	public void setSpecialityPositionLevel(String specialityPositionLevel) {
		this.specialityPositionLevel = specialityPositionLevel;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public boolean isPractitioners() {
		return practitioners;
	}

	public void setPractitioners(boolean practitioners) {
		this.practitioners = practitioners;
	}

	public Date getBeginPractitionersTime() {
		return beginPractitionersTime;
	}

	public void setBeginPractitionersTime(Date beginPractitionersTime) {
		this.beginPractitionersTime = beginPractitionersTime;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
