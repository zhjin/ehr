/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class SystemParameter extends EntityBase {

	@Id
	@Column(length=80)
	private String paraName;
	
	@Column(length=120)
	private String paraValue;
	
	@Column(length=255)
	private String remark;
	
	
	@Override
	public String getRowKey() {
		return this.paraName;
	}


	public String getParaName() {
		return paraName;
	}


	public void setParaName(String paraName) {
		this.paraName = paraName;
	}


	public String getParaValue() {
		return paraValue;
	}


	public void setParaValue(String paraValue) {
		this.paraValue = paraValue;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

}
