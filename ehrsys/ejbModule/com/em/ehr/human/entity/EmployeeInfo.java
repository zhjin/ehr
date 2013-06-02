/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class EmployeeInfo extends EntityBase {

	@Id
	private long empId;

	@Column(length = 40)
	private String code;

	@Column(length = 100)
	private String email;

	@Column
	private long degree;

	@Column(length=40)
	private String homePlace;

	@Column
	private long sex;

	@Column
	private Date birthday;

	@Column
	private float height;

	@Column
	private float weight;

	@Column(length = 40)
	private String mobile;

	@Column(length = 60)
	private String telephone;
	
	@Column(length = 60)
	private String homeTelephone;
	
	@Column(length = 60)
	private String workTelephone;

	@Column(length = 100)
	private String address;

	@Column
	private long residence;

	@Column
	private long blood;

	@Column
	private long nation;
	
	@Column
	private long education;

	@Column
	private boolean marriage;
	
	@Column
	private long compoType;
	
	@Column(length=120)
	private String compoRemark;

	@Column
	private Date beginWorkTime;

	@Column(length = 40)
	private String speciality;
	
	@Column(length=120)
	private String graduateSchool;
	
	@Column(length=40)
	private String graduateSpeciality;
	
	@Column
	private long polity;
	
	@Column
	private Date joinDate;
	
	@Column(length=80)
	private String specialityPosition;
	
	@Column(length=40)
	private String specialityPositionLevel;

	@Column(length = 40)
	private String postalcode;

	@Column(length = 100)
	private String residenceAddress;

	@Column(length = 100)
	private String residenceCity;
	
	@Column(length = 100)
	private String residenceCity1;
	
	@Column(length = 100)
	private String residenceCity2;

	@Column(length = 120)
	private String archivesCity;
	
	@Column(length=255)
	private String empRemark;
	
	@Column(length=120)
	private String otherRemark;

	@Column(length = 255)
	private String remark;
	
	@Column
	private boolean practitioners;
	
	@Column
	private Date beginPractitionersTime;

	@Column
	private boolean finish;
	
	@Column(length=40)
	private String lastName;
	
	@Column(length=40)
	private String givenName;
	
	@Column(length=40)
	private String studentId;
	
	@Column(length=40)
	private String passport;
	
	@Column(length=20)
	private String oldName;
	
	@Column(length=60)
	private String certNo;
	
	@Column
	private long joinType;
	
	@Column(length=120)
	private String linkManName;

	@Column(length=120)
	private String linkManRelation;
	
	@Column(length=120)
	private String linkManTele;
	
	@Column
	private long imageId;

	@Override
	public String getRowKey() {
		return Long.toString(this.empId);
	}

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

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHomeTelephone() {
		return homeTelephone;
	}

	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}

	public String getWorkTelephone() {
		return workTelephone;
	}

	public void setWorkTelephone(String workTelephone) {
		this.workTelephone = workTelephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getCompoRemark() {
		return compoRemark;
	}

	public void setCompoRemark(String compoRemark) {
		this.compoRemark = compoRemark;
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

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	public String getResidenceCity1() {
		return residenceCity1;
	}

	public void setResidenceCity1(String residenceCity1) {
		this.residenceCity1 = residenceCity1;
	}

	public String getResidenceCity2() {
		return residenceCity2;
	}

	public void setResidenceCity2(String residenceCity2) {
		this.residenceCity2 = residenceCity2;
	}

	public String getArchivesCity() {
		return archivesCity;
	}

	public void setArchivesCity(String archivesCity) {
		this.archivesCity = archivesCity;
	}

	public String getEmpRemark() {
		return empRemark;
	}

	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}

	public String getOtherRemark() {
		return otherRemark;
	}

	public void setOtherRemark(String otherRemark) {
		this.otherRemark = otherRemark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public long getJoinType() {
		return joinType;
	}

	public void setJoinType(long joinType) {
		this.joinType = joinType;
	}

	public String getLinkManName() {
		return linkManName;
	}

	public void setLinkManName(String linkManName) {
		this.linkManName = linkManName;
	}

	public String getLinkManRelation() {
		return linkManRelation;
	}

	public void setLinkManRelation(String linkManRelation) {
		this.linkManRelation = linkManRelation;
	}

	public String getLinkManTele() {
		return linkManTele;
	}

	public void setLinkManTele(String linkManTele) {
		this.linkManTele = linkManTele;
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

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

}
