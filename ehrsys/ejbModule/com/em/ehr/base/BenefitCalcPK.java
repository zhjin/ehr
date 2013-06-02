/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.base;

import java.io.Serializable;
import java.util.Date;

public class BenefitCalcPK implements Serializable {
	private long empId;
	private Date calcMonth;
	private long company;
	private long area;

	@Override
	public boolean equals(Object obj) {
		BenefitCalcPK _pk = (BenefitCalcPK) obj;
		return this.calcMonth.equals(_pk.getCalcMonth())
				&& this.empId == _pk.getEmpId()
				&& this.company == _pk.getCompany()
				&& this.area == _pk.getArea();
	}

	public Date getCalcMonth() {
		return calcMonth;
	}

	public void setCalcMonth(Date calcMonth) {
		this.calcMonth = calcMonth;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getCompany() {
		return company;
	}

	public void setCompany(long company) {
		this.company = company;
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

}
