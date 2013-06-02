/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class TreeDefine extends EntityHasIdBase {

	@Column(length=80)
	private String objectName;
	
	@Column
	private long rootId;
	
	@Column
	private boolean readOnly;
	
	@Column(length=40)
	private String orientation;
	
	@Column(length=80)
	private String rootIdEL;
	
	@Column(length=80)
	private String addNodeEL;
	
	@Column(length=80)
	private String updateNodeEL;
	
	@Column(length=80)
	private String deleteNodeEL;
	
	@Column(length=80)
	private String selectNodeEL;
	
	@Column(length=80)
	private String refreshNodeEL;
	
	@Column(length=120)
	private String remark;

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public long getRootId() {
		return rootId;
	}

	public void setRootId(long rootId) {
		this.rootId = rootId;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getAddNodeEL() {
		return addNodeEL;
	}

	public void setAddNodeEL(String addNodeEL) {
		this.addNodeEL = addNodeEL;
	}

	public String getDeleteNodeEL() {
		return deleteNodeEL;
	}

	public void setDeleteNodeEL(String deleteNodeEL) {
		this.deleteNodeEL = deleteNodeEL;
	}

	public String getSelectNodeEL() {
		return selectNodeEL;
	}

	public void setSelectNodeEL(String selectNodeEL) {
		this.selectNodeEL = selectNodeEL;
	}

	public String getRefreshNodeEL() {
		return refreshNodeEL;
	}

	public void setRefreshNodeEL(String refreshNodeEL) {
		this.refreshNodeEL = refreshNodeEL;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUpdateNodeEL() {
		return updateNodeEL;
	}

	public void setUpdateNodeEL(String updateNodeEL) {
		this.updateNodeEL = updateNodeEL;
	}

	public String getRootIdEL() {
		return rootIdEL;
	}

	public void setRootIdEL(String rootIdEL) {
		this.rootIdEL = rootIdEL;
	}
	
}
