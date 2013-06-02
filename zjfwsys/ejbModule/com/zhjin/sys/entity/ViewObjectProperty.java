/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PreRemove;

import com.zhjin.base.EntityBase;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Utility;

@Entity
public class ViewObjectProperty extends EntityBase {

	@Id
	@Column(length=80)
	private String objectName;
	
	@Column(length=120)
	private String objectClassName;
	
	@Column(length=120)
	private String objectNameCN;
	
	@Column
	private int editWidth;
	
	@Column
	private int editHeight;
	
	@Column(length=120)
	private String remark;

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectClassName() {
		return objectClassName;
	}

	public void setObjectClassName(String objectClassName) {
		this.objectClassName = objectClassName;
	}

	public String getObjectNameCN() {
		return objectNameCN;
	}

	public void setObjectNameCN(String objectNameCN) {
		this.objectNameCN = objectNameCN;
	}

	public int getEditWidth() {
		return editWidth;
	}

	public void setEditWidth(int editWidth) {
		this.editWidth = editWidth;
	}

	public int getEditHeight() {
		return editHeight;
	}

	public void setEditHeight(int editHeight) {
		this.editHeight = editHeight;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String getRowKey() {
		return this.objectName;
	}
	
	@PreRemove
	public void preDelete() throws Exception {
		Utility.getDBUtility().executeUpdate("delete viewobjectfieldproperty where objectname = :objectName", new ArgMap().add("objectName", this.getObjectName()));
	}
	
}
