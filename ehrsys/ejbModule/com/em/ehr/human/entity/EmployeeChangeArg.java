/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.em.ehr.organize.entity.Job;
import com.zhjin.base.entity.OperateDataBase;
import com.zhjin.util.Utility;

@Entity
public class EmployeeChangeArg extends OperateDataBase {

	/**
	 * 员工状态
	 */
	@Column
	private long empStatus;

	/**
	 * 部门
	 */
	@Column
	private long oldDepId;

	@Column
	private long newDepId;

	/**
	 * 岗位
	 */
	@Column
	private long oldJobId;

	@Column
	private long newJobId;
	
	/**
	 * 职务
	 */
	@Column
	private long oldPosition;
	@Column
	private long newPosition;
	
	/**
	 * 职务类型
	 */
	@Column
	private long oldPositionType;
	@Column
	private long newPositionType;
	
	/**
	 * 职务级别
	 */
	@Column
	private long oldPositionLevel;
	@Column
	private long newPositionLevel;

	/**
	 * 公司
	 */
	@Column
	private long oldCompany;

	@Column
	private long newCompany;

	/**
	 * 地区
	 */
	@Column
	private long oldArea;

	@Column
	private long newArea;
	
	/**
	 * 国家
	 */
	@Column
	private long oldCountry;
	@Column
	private long newCountry;

	/**
	 * 员工类型
	 */
	@Column
	private long oldEmpType;

	@Column
	private long newEmpType;

	/**
	 * 生效时间
	 */
	@Column
	private Date enabledDate;

	/**
	 * 变更类型
	 */
	@Column(length = 20)
	private String changeType;

	/**
	 * 是否直管
	 */
	@Column
	private boolean oldExpedite;
	@Column
	private boolean newExpedite;

	/**
	 * 直管部门
	 */
	@Column
	private long oldExpediteDepId;
	@Column
	private long newExpediteDepId;
	
	@Column
	private long oldChannel;
	@Column
	private long newChannel;

	@Column(length=20)
	private String oldBadge;
	@Column(length=20)
	private String newBadge;
	
	@Override
	public void insertCheck() throws Exception{
		if (newDepId == 0) {
			throw new Exception("请选择新部门!");
		}

		if (newCompany == 0) {
			throw new Exception("请选择新公司!");
		}

		if (newEmpType == 0) {
			throw new Exception("请选择员工类型!");
		}
		
		if (newCountry == 0)
			throw new Exception("请选择国家!");

		if (this.newJobId > 0) {
			Job _job = Utility.getDBUtility().getEntity(Job.class, this.newJobId);
			if (_job != null) {
				if (_job.getBudNumber() > 0) {
					HashMap<String, Object> arg = new HashMap<String, Object>();
					arg.put("jobId", this.newJobId);
					arg.put("empId", this.getEmpId());
					int _jobNum = Utility.getDBUtility().getRecordCount(
							"select count(*) from employeeactiveview where (jobid = :jobId) and (id != :empId)", arg);
					if (_jobNum  >= _job.getBudNumber()) {
						throw new Exception("在岗(" + _job.getLabel() + ")员工数已经达到预设标准！");
					}
				}
			}
		}

		if (this.isNewExpedite()) {
			if (this.newExpediteDepId == 0) {
				throw new Exception("请选择新直管部门");
			}
		} else {
			this.newExpediteDepId = 0;
		}

		if (!this.isOldExpedite()) {
			this.oldExpediteDepId = 0;
		}
	}

	public long getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(long empStatus) {
		this.empStatus = empStatus;
	}

	public long getOldDepId() {
		return oldDepId;
	}

	public void setOldDepId(long oldDepId) {
		this.oldDepId = oldDepId;
	}

	public long getNewDepId() {
		return newDepId;
	}

	public void setNewDepId(long newDepId) {
		this.newDepId = newDepId;
	}

	public long getOldJobId() {
		return oldJobId;
	}

	public void setOldJobId(long oldJobId) {
		this.oldJobId = oldJobId;
	}

	public long getNewJobId() {
		return newJobId;
	}

	public void setNewJobId(long newJobId) {
		this.newJobId = newJobId;
	}

	public long getOldPosition() {
		return oldPosition;
	}

	public void setOldPosition(long oldPosition) {
		this.oldPosition = oldPosition;
	}

	public long getNewPosition() {
		return newPosition;
	}

	public void setNewPosition(long newPosition) {
		this.newPosition = newPosition;
	}

	public long getOldPositionType() {
		return oldPositionType;
	}

	public void setOldPositionType(long oldPositionType) {
		this.oldPositionType = oldPositionType;
	}

	public long getNewPositionType() {
		return newPositionType;
	}

	public void setNewPositionType(long newPositionType) {
		this.newPositionType = newPositionType;
	}

	public long getOldPositionLevel() {
		return oldPositionLevel;
	}

	public void setOldPositionLevel(long oldPositionLevel) {
		this.oldPositionLevel = oldPositionLevel;
	}

	public long getNewPositionLevel() {
		return newPositionLevel;
	}

	public void setNewPositionLevel(long newPositionLevel) {
		this.newPositionLevel = newPositionLevel;
	}

	public long getOldCompany() {
		return oldCompany;
	}

	public void setOldCompany(long oldCompany) {
		this.oldCompany = oldCompany;
	}

	public long getNewCompany() {
		return newCompany;
	}

	public void setNewCompany(long newCompany) {
		this.newCompany = newCompany;
	}

	public long getOldArea() {
		return oldArea;
	}

	public void setOldArea(long oldArea) {
		this.oldArea = oldArea;
	}

	public long getNewArea() {
		return newArea;
	}

	public void setNewArea(long newArea) {
		this.newArea = newArea;
	}

	public long getOldCountry() {
		return oldCountry;
	}

	public void setOldCountry(long oldCountry) {
		this.oldCountry = oldCountry;
	}

	public long getNewCountry() {
		return newCountry;
	}

	public void setNewCountry(long newCountry) {
		this.newCountry = newCountry;
	}

	public long getOldEmpType() {
		return oldEmpType;
	}

	public void setOldEmpType(long oldEmpType) {
		this.oldEmpType = oldEmpType;
	}

	public long getNewEmpType() {
		return newEmpType;
	}

	public void setNewEmpType(long newEmpType) {
		this.newEmpType = newEmpType;
	}

	public Date getEnabledDate() {
		return enabledDate;
	}

	public void setEnabledDate(Date enabledDate) {
		this.enabledDate = enabledDate;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public boolean isOldExpedite() {
		return oldExpedite;
	}

	public void setOldExpedite(boolean oldExpedite) {
		this.oldExpedite = oldExpedite;
	}

	public boolean isNewExpedite() {
		return newExpedite;
	}

	public void setNewExpedite(boolean newExpedite) {
		this.newExpedite = newExpedite;
	}

	public long getOldExpediteDepId() {
		return oldExpediteDepId;
	}

	public void setOldExpediteDepId(long oldExpediteDepId) {
		this.oldExpediteDepId = oldExpediteDepId;
	}

	public long getNewExpediteDepId() {
		return newExpediteDepId;
	}

	public void setNewExpediteDepId(long newExpediteDepId) {
		this.newExpediteDepId = newExpediteDepId;
	}

	public long getOldChannel() {
		return oldChannel;
	}

	public void setOldChannel(long oldChannel) {
		this.oldChannel = oldChannel;
	}

	public long getNewChannel() {
		return newChannel;
	}

	public void setNewChannel(long newChannel) {
		this.newChannel = newChannel;
	}

	public String getOldBadge() {
		return oldBadge;
	}

	public void setOldBadge(String oldBadge) {
		this.oldBadge = oldBadge;
	}

	public String getNewBadge() {
		return newBadge;
	}

	public void setNewBadge(String newBadge) {
		this.newBadge = newBadge;
	}

}