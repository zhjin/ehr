/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.CodeBase;

@Entity
public class CountryCode extends CodeBase {

	@Column(precision = 10, scale = 2)
	private BigDecimal taxBase;

	public BigDecimal getTaxBase() {
		return taxBase;
	}

	public void setTaxBase(BigDecimal taxBase) {
		this.taxBase = taxBase;
	}

}
