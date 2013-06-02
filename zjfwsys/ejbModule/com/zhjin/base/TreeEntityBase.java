/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class TreeEntityBase extends EntityHasIdBase {

	@Column
	private long highId;
	
	@Column(length=120)
	private String label;
	
	@Column(length=250)
	private String remark;
	
	@Column
	private int indexNo;

	public long getHighId() {
		return highId;
	}

	public void setHighId(long highId) {
		this.highId = highId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}
}
