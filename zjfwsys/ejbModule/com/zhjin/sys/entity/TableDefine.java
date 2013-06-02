/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class TableDefine extends EntityHasIdBase {

	@Column(length=100)
	private String tableName;

	@Column(length=60)
	private String tableId;

	@Column
	private boolean readOnly;

	@Column(length=120)
	private String objectName;

	@Column
	private boolean javaBeanData;

	@Column(length=120)
	private String beanDataEL;

	@Column
	private boolean usePage;

	@Column(length=2000)
	private String queryString;

	@Column(length=1000)
	private String nativeString;

	@Column(length=255)
	private String orderString;

	@Column(length=1000)
	private String readOnlyColumns;

	@Column(length=1000)
	private String hideColumns;

	@Column(length=1000)
	private String showReadOnlyColumns;

	@Column(length=1000)
	private String showHideColumns;

	@Column(length=1000)
	private String newHideColumns;

	@Column(length=1000)
	private String newReadOnlyColumns;

	@Column
	private boolean canNew = false;

	@Column(length=120)
	private String canNewEL;
	@Column(length=120)
	private String initNewDataEL = "";
	@Column(length=120)
	private String saveNewDataEL = "";
	@Column(length=120)
	private String newDataPageURL;
	@Column
	private int newEditWidth;
	@Column
	private int newEditHeight;

	@Column(length=1000)
	private String updateReadOnlyColumns;
	@Column(length=1000)
	private String updateHideColumns;
	@Column
	private boolean canUpdate = false;
	@Column(length=120)
	private String canUpdateEL;
	@Column(length=120)
	private String initUpdateDataEL;
	@Column(length=120)
	private String updateDataEL;
	@Column(length=120)
	private String updatePageURL;
	@Column
	private int updateEditWidth;
	@Column
	private int updateEditHeight;

	@Column
	private boolean canDelete = false;
	@Column(length=120)
	private String canDeleteEL;
	@Column(length=120)
	private String deleteEL = "";
	@Column
	private boolean realDelete = false;

	@Column
	private boolean fastSearchEnabled = false;
	@Column(length=80)
	private String fastSearchField;
	@Column
	private int editWidth;
	@Column
	private int editHeight;

	@Column(length=120)
	private String includeComponent;

	@Column(length=120)
	private String tableHeaderEL;
	@Column(length=120)
	private String tableFooterEL;

	@Column
	private boolean canExportExcel;

	@Column(length=120)
	private String beforeOpenTableProcessEL;

	@Column(length=120)
	private String remark;

	@Column
	private boolean showCustomComponent;

	@Column
	private long customComponentId;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getOrderString() {
		return orderString;
	}

	public void setOrderString(String orderString) {
		this.orderString = orderString;
	}

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

	public String getNewHideColumns() {
		return newHideColumns;
	}

	public void setNewHideColumns(String newHideColumns) {
		this.newHideColumns = newHideColumns;
	}

	public String getNewReadOnlyColumns() {
		return newReadOnlyColumns;
	}

	public void setNewReadOnlyColumns(String newReadOnlyColumns) {
		this.newReadOnlyColumns = newReadOnlyColumns;
	}

	public boolean isCanNew() {
		return canNew;
	}

	public void setCanNew(boolean canNew) {
		this.canNew = canNew;
	}

	public String getCanNewEL() {
		return canNewEL;
	}

	public void setCanNewEL(String canNewEL) {
		this.canNewEL = canNewEL;
	}

	public String getInitNewDataEL() {
		return initNewDataEL;
	}

	public void setInitNewDataEL(String initNewDataEL) {
		this.initNewDataEL = initNewDataEL;
	}

	public String getSaveNewDataEL() {
		return saveNewDataEL;
	}

	public void setSaveNewDataEL(String saveNewDataEL) {
		this.saveNewDataEL = saveNewDataEL;
	}

	public String getNewDataPageURL() {
		return newDataPageURL;
	}

	public void setNewDataPageURL(String newDataPageURL) {
		this.newDataPageURL = newDataPageURL;
	}

	public int getNewEditWidth() {
		return newEditWidth;
	}

	public void setNewEditWidth(int newEditWidth) {
		this.newEditWidth = newEditWidth;
	}

	public int getNewEditHeight() {
		return newEditHeight;
	}

	public void setNewEditHeight(int newEditHeight) {
		this.newEditHeight = newEditHeight;
	}

	public String getUpdateReadOnlyColumns() {
		return updateReadOnlyColumns;
	}

	public void setUpdateReadOnlyColumns(String updateReadOnlyColumns) {
		this.updateReadOnlyColumns = updateReadOnlyColumns;
	}

	public String getUpdateHideColumns() {
		return updateHideColumns;
	}

	public void setUpdateHideColumns(String updateHideColumns) {
		this.updateHideColumns = updateHideColumns;
	}

	public boolean isCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(boolean canUpdate) {
		this.canUpdate = canUpdate;
	}

	public String getCanUpdateEL() {
		return canUpdateEL;
	}

	public void setCanUpdateEL(String canUpdateEL) {
		this.canUpdateEL = canUpdateEL;
	}

	public String getInitUpdateDataEL() {
		return initUpdateDataEL;
	}

	public void setInitUpdateDataEL(String initUpdateDataEL) {
		this.initUpdateDataEL = initUpdateDataEL;
	}

	public String getUpdateDataEL() {
		return updateDataEL;
	}

	public void setUpdateDataEL(String updateDataEL) {
		this.updateDataEL = updateDataEL;
	}

	public String getUpdatePageURL() {
		return updatePageURL;
	}

	public void setUpdatePageURL(String updatePageURL) {
		this.updatePageURL = updatePageURL;
	}

	public int getUpdateEditWidth() {
		return updateEditWidth;
	}

	public void setUpdateEditWidth(int updateEditWidth) {
		this.updateEditWidth = updateEditWidth;
	}

	public int getUpdateEditHeight() {
		return updateEditHeight;
	}

	public void setUpdateEditHeight(int updateEditHeight) {
		this.updateEditHeight = updateEditHeight;
	}

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	public String getCanDeleteEL() {
		return canDeleteEL;
	}

	public void setCanDeleteEL(String canDeleteEL) {
		this.canDeleteEL = canDeleteEL;
	}

	public String getDeleteEL() {
		return deleteEL;
	}

	public void setDeleteEL(String deleteEL) {
		this.deleteEL = deleteEL;
	}

	public boolean isRealDelete() {
		return realDelete;
	}

	public void setRealDelete(boolean realDelete) {
		this.realDelete = realDelete;
	}

	public boolean isFastSearchEnabled() {
		return fastSearchEnabled;
	}

	public void setFastSearchEnabled(boolean fastSearchEnabled) {
		this.fastSearchEnabled = fastSearchEnabled;
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

	public String getIncludeComponent() {
		return includeComponent;
	}

	public void setIncludeComponent(String includeComponent) {
		this.includeComponent = includeComponent;
	}

	public String getTableHeaderEL() {
		return tableHeaderEL;
	}

	public void setTableHeaderEL(String tableHeaderEL) {
		this.tableHeaderEL = tableHeaderEL;
	}

	public String getTableFooterEL() {
		return tableFooterEL;
	}

	public void setTableFooterEL(String tableFooterEL) {
		this.tableFooterEL = tableFooterEL;
	}

	public boolean isCanExportExcel() {
		return canExportExcel;
	}

	public void setCanExportExcel(boolean canExportExcel) {
		this.canExportExcel = canExportExcel;
	}

	public String getBeforeOpenTableProcessEL() {
		return beforeOpenTableProcessEL;
	}

	public void setBeforeOpenTableProcessEL(String beforeOpenTableProcessEL) {
		this.beforeOpenTableProcessEL = beforeOpenTableProcessEL;
	}

	public boolean isJavaBeanData() {
		return javaBeanData;
	}

	public void setJavaBeanData(boolean javaBeanData) {
		this.javaBeanData = javaBeanData;
	}

	public boolean isUsePage() {
		return usePage;
	}

	public void setUsePage(boolean usePage) {
		this.usePage = usePage;
	}

	public String getBeanDataEL() {
		return beanDataEL;
	}

	public void setBeanDataEL(String beanDataEL) {
		this.beanDataEL = beanDataEL;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNativeString() {
		return nativeString;
	}

	public void setNativeString(String nativeString) {
		this.nativeString = nativeString;
	}

	public String getFastSearchField() {
		return fastSearchField;
	}

	public void setFastSearchField(String fastSearchField) {
		this.fastSearchField = fastSearchField;
	}

	public String getShowReadOnlyColumns() {
		return showReadOnlyColumns;
	}

	public void setShowReadOnlyColumns(String showReadOnlyColumns) {
		this.showReadOnlyColumns = showReadOnlyColumns;
	}

	public String getShowHideColumns() {
		return showHideColumns;
	}

	public void setShowHideColumns(String showHideColumns) {
		this.showHideColumns = showHideColumns;
	}

	public boolean isShowCustomComponent() {
		return showCustomComponent;
	}

	public void setShowCustomComponent(boolean showCustomComponent) {
		this.showCustomComponent = showCustomComponent;
	}

	public long getCustomComponentId() {
		return customComponentId;
	}

	public void setCustomComponentId(long customComponentId) {
		this.customComponentId = customComponentId;
	}

}
