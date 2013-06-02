/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class DepAttendCardParameter extends EntityBase {
	
	@Id
	private long depId;
	
	@Column
	private long managerEmpId;
	
	@Column(length=40)
	private String managerLoginName;
	
	@Column(length=20)
	private String managerName;
	
	@Column
	private boolean submit;
	
	@Column
	private long submitEmpId;
	
	@Column(length=40)
	private String submitLoginName;
	
	@Column(length=20)
	private String submitName;
	
	@Column
	private Date submitTime;
	
	@Column
	private boolean manual;
	
	@Column(length=40)
	private String dbName;
	
	@Column(length=120)
	private String dbUrl;
	
	@Column(length=40)
	private String dbUserName;
	
	@Column(length=40)
	private String dbPassword;
	
	@Column(length=200)
	private String queryString;
	
	@Column
	private int idBegin;
	
	@Column
	private int idEnd;
	
	@Column
	private int yearBegin;
	
	@Column
	private int yearEnd;
	
	@Column
	private int monthBegin;
	
	@Column
	private int monthEnd;
	
	@Column
	private int dayBegin;
	
	@Column
	private int dayEnd;
	
	@Column
	private int hourBegin;
	
	@Column
	private int hourEnd;
	
	@Column
	private int minuteBegin;
	
	@Column
	private int minuteEnd;
	
	@Column
	private int secondBegin;
	
	@Column
	private int secondEnd;
	
	@Column
	private int milliSecondBegin;
	
	@Column
	private int milliSecondEnd;
	
	@Column
	private int cardBegin;
	
	@Column
	private int cardEnd;


	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public int getYearBegin() {
		return yearBegin;
	}

	public void setYearBegin(int yearBegin) {
		this.yearBegin = yearBegin;
	}

	public int getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(int yearEnd) {
		this.yearEnd = yearEnd;
	}

	public int getMonthBegin() {
		return monthBegin;
	}

	public void setMonthBegin(int monthBegin) {
		this.monthBegin = monthBegin;
	}

	public int getMonthEnd() {
		return monthEnd;
	}

	public void setMonthEnd(int monthEnd) {
		this.monthEnd = monthEnd;
	}

	public int getDayBegin() {
		return dayBegin;
	}

	public void setDayBegin(int dayBegin) {
		this.dayBegin = dayBegin;
	}

	public int getDayEnd() {
		return dayEnd;
	}

	public void setDayEnd(int dayEnd) {
		this.dayEnd = dayEnd;
	}

	public int getHourBegin() {
		return hourBegin;
	}

	public void setHourBegin(int hourBegin) {
		this.hourBegin = hourBegin;
	}

	public int getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(int hourEnd) {
		this.hourEnd = hourEnd;
	}

	public int getMinuteBegin() {
		return minuteBegin;
	}

	public void setMinuteBegin(int minuteBegin) {
		this.minuteBegin = minuteBegin;
	}

	public int getMinuteEnd() {
		return minuteEnd;
	}

	public void setMinuteEnd(int minuteEnd) {
		this.minuteEnd = minuteEnd;
	}

	public int getSecondBegin() {
		return secondBegin;
	}

	public void setSecondBegin(int secondBegin) {
		this.secondBegin = secondBegin;
	}

	public int getSecondEnd() {
		return secondEnd;
	}

	public void setSecondEnd(int secondEnd) {
		this.secondEnd = secondEnd;
	}

	public int getMilliSecondBegin() {
		return milliSecondBegin;
	}

	public void setMilliSecondBegin(int milliSecondBegin) {
		this.milliSecondBegin = milliSecondBegin;
	}

	public int getMilliSecondEnd() {
		return milliSecondEnd;
	}

	public void setMilliSecondEnd(int milliSecondEnd) {
		this.milliSecondEnd = milliSecondEnd;
	}

	public int getCardBegin() {
		return cardBegin;
	}

	public void setCardBegin(int cardBegin) {
		this.cardBegin = cardBegin;
	}

	public int getCardEnd() {
		return cardEnd;
	}

	public void setCardEnd(int cardEnd) {
		this.cardEnd = cardEnd;
	}

	public long getManagerEmpId() {
		return managerEmpId;
	}

	public void setManagerEmpId(long managerEmpId) {
		this.managerEmpId = managerEmpId;
	}

	public boolean isSubmit() {
		return submit;
	}

	public void setSubmit(boolean submit) {
		this.submit = submit;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public boolean isManual() {
		return manual;
	}

	public void setManual(boolean manual) {
		this.manual = manual;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public long getSubmitEmpId() {
		return submitEmpId;
	}

	public void setSubmitEmpId(long submitEmpId) {
		this.submitEmpId = submitEmpId;
	}

	public String getManagerLoginName() {
		return managerLoginName;
	}

	public void setManagerLoginName(String managerLoginName) {
		this.managerLoginName = managerLoginName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getSubmitLoginName() {
		return submitLoginName;
	}

	public void setSubmitLoginName(String submitLoginName) {
		this.submitLoginName = submitLoginName;
	}

	public String getSubmitName() {
		return submitName;
	}

	public void setSubmitName(String submitName) {
		this.submitName = submitName;
	}

	public int getIdBegin() {
		return idBegin;
	}

	public void setIdBegin(int idBegin) {
		this.idBegin = idBegin;
	}

	public int getIdEnd() {
		return idEnd;
	}

	public void setIdEnd(int idEnd) {
		this.idEnd = idEnd;
	}

	@Override
	public String getRowKey() {
		return String.valueOf(this.depId);
	}
}
