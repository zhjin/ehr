/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonLanguage extends EmployeePersonBaseEntity {
	@Column(length=20)
	private String languageName;
	
	@Column(length=20)
	private String hold;
	
	@Column(length=40)
	private String cert;
	
	@Column
	private Date holdTime;
	
	@Column(length=20)
	private String audition;
	
	@Column(length=20)
	private String speak;
	
	@Column(length=20)
	private String readAbility;
	
	@Column(length=20)
	private String writeAbility;
	
	@Column(length=20)
	private String listenAbility;

	public String getAudition() {
		return audition;
	}

	public void setAudition(String audition) {
		this.audition = audition;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	public Date getHoldTime() {
		return holdTime;
	}

	public void setHoldTime(Date holdTime) {
		this.holdTime = holdTime;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getSpeak() {
		return speak;
	}

	public void setSpeak(String speak) {
		this.speak = speak;
	}

	public String getReadAbility() {
		return readAbility;
	}

	public void setReadAbility(String readAbility) {
		this.readAbility = readAbility;
	}

	public String getWriteAbility() {
		return writeAbility;
	}

	public void setWriteAbility(String writeAbility) {
		this.writeAbility = writeAbility;
	}

	public String getListenAbility() {
		return listenAbility;
	}

	public void setListenAbility(String listenAbility) {
		this.listenAbility = listenAbility;
	}

	
}
