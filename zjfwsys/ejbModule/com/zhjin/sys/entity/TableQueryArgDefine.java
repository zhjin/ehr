/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class TableQueryArgDefine extends EntityHasIdBase {

	@Column
	private long tableId;
	
	@Column(length=60)
	private String argName;
	
	@Column(length=80)
	private String argValue;

	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}

	public String getArgName() {
		return argName;
	}

	public void setArgName(String argName) {
		this.argName = argName;
	}

	public String getArgValue() {
		return argValue;
	}

	public void setArgValue(String argValue) {
		this.argValue = argValue;
	}
	
}
