/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.CodeBase;

@Entity
public class SelectCodeList extends CodeBase {

	@Column(length=128)
	private String codeEL;
	
	@Column(length=1500)
	private String queryString;
	
	@Column
	private boolean hasEmpty;

	public String getCodeEL() {
		return codeEL;
	}

	public void setCodeEL(String codeEL) {
		this.codeEL = codeEL;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public boolean isHasEmpty() {
		return hasEmpty;
	}

	public void setHasEmpty(boolean hasEmpty) {
		this.hasEmpty = hasEmpty;
	}
}
