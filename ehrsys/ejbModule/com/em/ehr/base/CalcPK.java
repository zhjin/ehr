/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.base;

import java.io.Serializable;
import java.util.Date;

public class CalcPK implements Serializable {

	private long empId;
	
	private long company;
	
	private Date calcMonth;

	public long getEmpId() {
		return empId;
	}

	@Override
	public boolean equals(Object obj) {
		CalcPK pk = (CalcPK)obj;
		return this.empId == pk.getEmpId() && this.company == pk.getCompany() && this.calcMonth.equals(pk.getCalcMonth());
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

	public Date getCalcMonth() {
		return calcMonth;
	}

	public void setCalcMonth(Date calcMonth) {
		this.calcMonth = calcMonth;
	}
	
}
