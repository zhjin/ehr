/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.wfsys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class WFInstanceActor extends EntityHasIdBase {

	@Column(length=40)
	private String wfInstanceId;

	@Column(length=60)
	private String nodeId;

	@Column(length=80)
	private String nodeName;

	@Column
	private long preEmpId;

	@Column(length=40)
	private String preLoginName;

	@Column(length=20)
	private String preName;

	@Column(length=60)
	private String preNodeId;

	@Column
	private long actorEmpId;

	@Column(length=40)
	private String actorLoginName;

	@Column(length=20)
	private String actorName;

	@Column
	private long realActorEmpId;

	@Column(length=40)
	private String realActorLoginName;

	@Column(length=20)
	private String realActorName;

	@Column
	private Date beginTime;

	@Column
	private Date endTime;

	@Column(length=1000)
	private String applyRemark;

	@Column(length=20)
	private String applyResult;

	public String getWfInstanceId() {
		return wfInstanceId;
	}

	public void setWfInstanceId(String wfInstanceId) {
		this.wfInstanceId = wfInstanceId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public long getActorEmpId() {
		return actorEmpId;
	}

	public void setActorEmpId(long actorEmpId) {
		this.actorEmpId = actorEmpId;
	}

	public String getActorLoginName() {
		return actorLoginName;
	}

	public void setActorLoginName(String actorLoginName) {
		this.actorLoginName = actorLoginName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
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

	public String getApplyRemark() {
		return applyRemark;
	}

	public void setApplyRemark(String applyRemark) {
		this.applyRemark = applyRemark;
	}

	public String getApplyResult() {
		return applyResult;
	}

	public void setApplyResult(String applyResult) {
		this.applyResult = applyResult;
	}

	public long getRealActorEmpId() {
		return realActorEmpId;
	}

	public void setRealActorEmpId(long realActorEmpId) {
		this.realActorEmpId = realActorEmpId;
	}

	public String getRealActorLoginName() {
		return realActorLoginName;
	}

	public void setRealActorLoginName(String realActorLoginName) {
		this.realActorLoginName = realActorLoginName;
	}

	public String getRealActorName() {
		return realActorName;
	}

	public void setRealActorName(String realActorName) {
		this.realActorName = realActorName;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public long getPreEmpId() {
		return preEmpId;
	}

	public void setPreEmpId(long preEmpId) {
		this.preEmpId = preEmpId;
	}

	public String getPreLoginName() {
		return preLoginName;
	}

	public void setPreLoginName(String preLoginName) {
		this.preLoginName = preLoginName;
	}

	public String getPreName() {
		return preName;
	}

	public void setPreName(String preName) {
		this.preName = preName;
	}

	public String getPreNodeId() {
		return preNodeId;
	}

	public void setPreNodeId(String preNodeId) {
		this.preNodeId = preNodeId;
	}

}
