/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.wfsys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class WFInstance extends EntityBase {
	
	@Id
	@Column(length=40)
	private String wfInstanceId;
	
	@Column(length=60)
	private String wfDefineId;
	
	@Column
	private long reqEmpId;
	
	@Column(length=60)
	private String reqLoginName;
	
	@Column(length=40)
	private String reqName;
	
	@Column
	private long reqDepId;
	
	@Column
	private long wfId;
	
	@Column
	private long dataId;
	
	@Column
	private long attachFileId;
	
	@Column(length=80)
	private String wfName;
	
	@Column(length=80)
	private String wfNameCN;
	
	@Column(length=80)
	private String reqTitle;
	
	@Column
	private Date beginTime;
	
	@Column
	private Date endTime;
	
	@Column
	private boolean finish;
	
	@Column(length=20)
	private String endStatus;
	
	@Column(length=1000)
	private String remark;

	public String getWfInstanceId() {
		return wfInstanceId;
	}

	public void setWfInstanceId(String wfInstanceId) {
		this.wfInstanceId = wfInstanceId;
	}

	public long getWfId() {
		return wfId;
	}

	public void setWfId(long wfId) {
		this.wfId = wfId;
	}

	public String getWfNameCN() {
		return wfNameCN;
	}

	public void setWfNameCN(String wfNameCN) {
		this.wfNameCN = wfNameCN;
	}

	public String getReqTitle() {
		return reqTitle;
	}

	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
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

	public String getEndStatus() {
		return endStatus;
	}

	public void setEndStatus(String endStatus) {
		this.endStatus = endStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getDataId() {
		return dataId;
	}

	public void setDataId(long dataId) {
		this.dataId = dataId;
	}

	public String getWfName() {
		return wfName;
	}

	public void setWfName(String wfName) {
		this.wfName = wfName;
	}

	public long getReqEmpId() {
		return reqEmpId;
	}

	public void setReqEmpId(long reqEmpId) {
		this.reqEmpId = reqEmpId;
	}

	public String getReqLoginName() {
		return reqLoginName;
	}

	public void setReqLoginName(String reqLoginName) {
		this.reqLoginName = reqLoginName;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public long getReqDepId() {
		return reqDepId;
	}

	public void setReqDepId(long reqDepId) {
		this.reqDepId = reqDepId;
	}

	public String getWfDefineId() {
		return wfDefineId;
	}

	public void setWfDefineId(String wfDefineId) {
		this.wfDefineId = wfDefineId;
	}

	public long getAttachFileId() {
		return attachFileId;
	}

	public void setAttachFileId(long attachFileId) {
		this.attachFileId = attachFileId;
	}

	@Override
	public String getRowKey() {
		return this.wfInstanceId;
	}

}
