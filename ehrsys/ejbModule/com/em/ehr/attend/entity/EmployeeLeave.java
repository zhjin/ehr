/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.entity.OperateDataBase;

@Entity
public class EmployeeLeave extends OperateDataBase {
	
	@Column
	private long leaveType;
	
	@Column
	private long leaveCalcType;
	
	@Column
	private Date beginTime;
	
	@Column
	private Date endTime;
	
	@Column
	private boolean finish;

	@Override
	public void insertCheck() throws Exception {
		super.insertCheck();
	}

	@Override
	public void updateCheck() throws Exception {
		super.updateCheck();
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public long getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(long leaveType) {
		this.leaveType = leaveType;
	}

	public long getLeaveCalcType() {
		return leaveCalcType;
	}

	public void setLeaveCalcType(long leaveCalcType) {
		this.leaveCalcType = leaveCalcType;
	}

}
