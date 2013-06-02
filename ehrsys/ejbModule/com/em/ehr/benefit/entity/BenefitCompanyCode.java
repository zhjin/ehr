/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.benefit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.CodeBase;

@Entity
public class BenefitCompanyCode extends CodeBase {
	
	@Column
	private long depId;

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}
	
}
