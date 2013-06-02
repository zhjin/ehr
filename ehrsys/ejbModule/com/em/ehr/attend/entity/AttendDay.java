/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class AttendDay extends EntityBase {
	
	@Id
	private Date attendDay;
	
	@Column
	private long dayType;
	
	@Column(length=120)
	private String remark;

	public Date getAttendDay() {
		return attendDay;
	}

	public void setAttendDay(Date attendDay) {
		this.attendDay = attendDay;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getDayType() {
		return dayType;
	}

	public void setDayType(long dayType) {
		this.dayType = dayType;
	}

	@Override
	public String getRowKey() {
		return this.attendDay.toString();
	}
}
