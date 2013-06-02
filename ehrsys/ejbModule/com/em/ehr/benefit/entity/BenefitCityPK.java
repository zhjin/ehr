/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.benefit.entity;

import java.io.Serializable;

public class BenefitCityPK implements Serializable {
	private long area;
	private long company;
	
	public BenefitCityPK(long area, long company) {
		super();
		this.area = area;
		this.company = company;
	}
	
	public BenefitCityPK() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		BenefitCityPK pk = (BenefitCityPK)obj;
		return this.area == pk.getArea() && this.company == pk.getCompany();
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	public long getCompany() {
		return company;
	}

	public void setCompany(long company) {
		this.company = company;
	}

}
