/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonEdu extends EmployeePersonBaseEntity {
	
	@Column
	private Date beginTime;

	@Column
	private Date endTime;
	
	@Column
	private Date graduateTime;
	
	@Column(length=20)
	private String schoolKind;
	
	@Column(length=20)
	private String studyType;
	
	@Column
	private long studyTypeCode;
	
	@Column
	private long degree;
	
	@Column
	private long degree1;
	
	@Column(length=20)
	private String schoolLength;
	
	@Column
	private int schoolLengthCode;
	
	@Column(length=20)
	private String graduateType;
	
	@Column(length=40)
	private String certNo;
	
	@Column(length=40)
	private String certNo1;
	
	@Column(length=40)
	private String speciality;
	
	@Column(length=80)
	private String schoolName;
	
	@Column(length=100)
	private String schoolAddress;

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getGraduateTime() {
		return graduateTime;
	}

	public void setGraduateTime(Date graduateTime) {
		this.graduateTime = graduateTime;
	}

	public String getSchoolKind() {
		return schoolKind;
	}

	public void setSchoolKind(String schoolKind) {
		this.schoolKind = schoolKind;
	}

	public String getStudyType() {
		return studyType;
	}

	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}

	public long getStudyTypeCode() {
		return studyTypeCode;
	}

	public void setStudyTypeCode(long studyTypeCode) {
		this.studyTypeCode = studyTypeCode;
	}

	public long getDegree() {
		return degree;
	}

	public void setDegree(long degree) {
		this.degree = degree;
	}

	public long getDegree1() {
		return degree1;
	}

	public void setDegree1(long degree1) {
		this.degree1 = degree1;
	}

	public String getSchoolLength() {
		return schoolLength;
	}

	public void setSchoolLength(String schoolLength) {
		this.schoolLength = schoolLength;
	}

	public int getSchoolLengthCode() {
		return schoolLengthCode;
	}

	public void setSchoolLengthCode(int schoolLengthCode) {
		this.schoolLengthCode = schoolLengthCode;
	}

	public String getGraduateType() {
		return graduateType;
	}

	public void setGraduateType(String graduateType) {
		this.graduateType = graduateType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCertNo1() {
		return certNo1;
	}

	public void setCertNo1(String certNo1) {
		this.certNo1 = certNo1;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
		
}
