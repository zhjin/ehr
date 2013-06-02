/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.zhjin.base.EntityHasIdBase;

@MappedSuperclass
public class CalcTermBase extends EntityHasIdBase {
	@Column
	private Date term;
	
	@Column
	private Date closeTime;
	
	@Column
	private long closeEmpId;
	
	@Column(length=40)
	private String closeLoginName;
	
	@Column(length=20)
	private String closeName;
	
	@Column
	private boolean termClose;

	public Date getTerm() {
		return term;
	}

	public void setTerm(Date term) {
		this.term = term;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public long getCloseEmpId() {
		return closeEmpId;
	}

	public void setCloseEmpId(long closeEmpId) {
		this.closeEmpId = closeEmpId;
	}

	public String getCloseLoginName() {
		return closeLoginName;
	}

	public void setCloseLoginName(String closeLoginName) {
		this.closeLoginName = closeLoginName;
	}

	public String getCloseName() {
		return closeName;
	}

	public void setCloseName(String closeName) {
		this.closeName = closeName;
	}

	public boolean isTermClose() {
		return termClose;
	}

	public void setTermClose(boolean termClose) {
		this.termClose = termClose;
	}
}
