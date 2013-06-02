/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class ObjectEditDefine extends EntityHasIdBase {
	
	@Column(length=120)
	private String editTitle;
	
	@Column(length=1000)
	private String readOnlyColumns;
	
	@Column(length=1000)
	private String hideColumns;
	
	@Column(length=80)
	private String objectName;
	
	@Column(length=120)
	private String initEditEL;
	
	@Column(length=80)
	private String dataProcessEL;
	
	@Column(length=30)
	private String dataProcessCommandValue;
	
	@Column(length=120)
	private String parentButtonName;
	
	@Column
	private boolean selectUser;
	
	@Column(length=120)
	private String selectUserCommandEL;
	
	@Column(length=1000)
	private String selectUserQueryString;
	
	@Column(length=120)
	private String selectUserProcessEL;
	
	@Column(length=120)
	private String remark;
	
	@Column
	private int editWidth;
	
	@Column
	private int editHeight;

	public String getReadOnlyColumns() {
		return readOnlyColumns;
	}

	public void setReadOnlyColumns(String readOnlyColumns) {
		this.readOnlyColumns = readOnlyColumns;
	}

	public String getHideColumns() {
		return hideColumns;
	}

	public void setHideColumns(String hideColumns) {
		this.hideColumns = hideColumns;
	}

	public String getDataProcessEL() {
		return dataProcessEL;
	}

	public void setDataProcessEL(String dataProcessEL) {
		this.dataProcessEL = dataProcessEL;
	}

	public String getDataProcessCommandValue() {
		return dataProcessCommandValue;
	}

	public void setDataProcessCommandValue(String dataProcessCommandValue) {
		this.dataProcessCommandValue = dataProcessCommandValue;
	}

	public String getParentButtonName() {
		return parentButtonName;
	}

	public void setParentButtonName(String parentButtonName) {
		this.parentButtonName = parentButtonName;
	}

	public boolean isSelectUser() {
		return selectUser;
	}

	public void setSelectUser(boolean selectUser) {
		this.selectUser = selectUser;
	}

	public String getSelectUserCommandEL() {
		return selectUserCommandEL;
	}

	public void setSelectUserCommandEL(String selectUserCommandEL) {
		this.selectUserCommandEL = selectUserCommandEL;
	}

	public String getSelectUserQueryString() {
		return selectUserQueryString;
	}

	public void setSelectUserQueryString(String selectUserQueryString) {
		this.selectUserQueryString = selectUserQueryString;
	}

	public String getSelectUserProcessEL() {
		return selectUserProcessEL;
	}

	public void setSelectUserProcessEL(String selectUserProcessEL) {
		this.selectUserProcessEL = selectUserProcessEL;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getInitEditEL() {
		return initEditEL;
	}

	public void setInitEditEL(String initEditEL) {
		this.initEditEL = initEditEL;
	}

	public String getEditTitle() {
		return editTitle;
	}

	public void setEditTitle(String editTitle) {
		this.editTitle = editTitle;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	
}
