/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.organize.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.CodeBase;

@Entity
public class Position extends CodeBase {

	@Column
	private long principalshipType;

	@Column
	private long principalshipLevel;

	public long getPrincipalshipType() {
		return principalshipType;
	}

	public void setPrincipalshipType(long principalshipType) {
		this.principalshipType = principalshipType;
	}

	public long getPrincipalshipLevel() {
		return principalshipLevel;
	}

	public void setPrincipalshipLevel(long principalshipLevel) {
		this.principalshipLevel = principalshipLevel;
	}

}
