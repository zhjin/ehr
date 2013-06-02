/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.wfsys;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class WFNodeProperty extends EntityHasIdBase {
	
	@Column
	private long wfId;
	
	@Column(length=60)
	private String wfName;
	
	@Column(length=60)
	private String nodeId;
	
	@Column(length=80)
	private String nodeName;
	
	@Column(length=40)
	private String nodeType;
	
	@Column(length=60)
	private String nodeRoleName;
	
	@Column(length=120)
	private String actorEL;
	
	@Column(length=2000)
	private String actorQueryString;
	
	@Column(length=1000)
	private String hideColumns;
	
	@Column(length=1000)
	private String readOnlyColumns;
	
	@Column(length=60)
	private String title;
	
	@Column(length=40)
	private String okCommandTitle;
	
	@Column
	private boolean cancelEnabled = true;
	
	@Column(length=80)
	private String applyEL;
	
	@Column
	private boolean readOnly = true;
	
	@Column(length=255)
	private String applyURL;
	
	@Column
	private int dialogWidth;
	
	@Column
	private int dialogHeight;
	
	@Column
	private boolean endWhenCancel;
	
	@Column(length=1000)
	private String remark;
	
	@Column
	private int indexNo;

	public long getWfId() {
		return wfId;
	}

	public void setWfId(long wfId) {
		this.wfId = wfId;
	}

	public String getWfName() {
		return wfName;
	}

	public void setWfName(String wfName) {
		this.wfName = wfName;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getHideColumns() {
		return hideColumns;
	}

	public void setHideColumns(String hideColumns) {
		this.hideColumns = hideColumns;
	}

	public String getReadOnlyColumns() {
		return readOnlyColumns;
	}

	public void setReadOnlyColumns(String readOnlyColumns) {
		this.readOnlyColumns = readOnlyColumns;
	}

	public int getDialogWidth() {
		return dialogWidth;
	}

	public void setDialogWidth(int dialogWidth) {
		this.dialogWidth = dialogWidth;
	}

	public int getDialogHeight() {
		return dialogHeight;
	}

	public void setDialogHeight(int dialogHeight) {
		this.dialogHeight = dialogHeight;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getOkCommandTitle() {
		return okCommandTitle;
	}

	public void setOkCommandTitle(String okCommandTitle) {
		this.okCommandTitle = okCommandTitle;
	}

	public String getApplyEL() {
		return applyEL;
	}

	public void setApplyEL(String applyEL) {
		this.applyEL = applyEL;
	}

	public String getNodeRoleName() {
		return nodeRoleName;
	}

	public void setNodeRoleName(String nodeRoleName) {
		this.nodeRoleName = nodeRoleName;
	}

	public boolean isEndWhenCancel() {
		return endWhenCancel;
	}

	public void setEndWhenCancel(boolean endWhenCancel) {
		this.endWhenCancel = endWhenCancel;
	}

	public String getActorEL() {
		return actorEL;
	}

	public void setActorEL(String actorEL) {
		this.actorEL = actorEL;
	}

	public String getActorQueryString() {
		return actorQueryString;
	}

	public void setActorQueryString(String actorQueryString) {
		this.actorQueryString = actorQueryString;
	}

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isCancelEnabled() {
		return cancelEnabled;
	}

	public void setCancelEnabled(boolean cancelEnabled) {
		this.cancelEnabled = cancelEnabled;
	}

	public String getApplyURL() {
		return applyURL;
	}

	public void setApplyURL(String applyURL) {
		this.applyURL = applyURL;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

}
