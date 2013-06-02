/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.zhjin.base.EntityHasIdBase;

@MappedSuperclass
public class CommandDefine extends EntityHasIdBase{

	@Column(nullable = false)
	private boolean selectRecord;
	
	/**
	 * 命令类型(AJAX, NORMAL)
	 */
	@Column(length=20)
	private String commandType;
	
	/**
	 * 按钮Id
	 */
	@Column(length=20)
	private String commandId;
	
	/**
	 * 按钮显示名称
	 */
	@Column(length=120)
	private String commandValueEL;

	/**
	 * 按钮处理方法
	 */
	@Column(length=120)
	private String actionListenerEL;
	
	/**
	 * 处理后重新显示区域
	 */
	@Column(length=120)
	private String updateComponent;
	
	/**
	 * 是否显示方法
	 */
	@Transient
	private boolean runVisiabled;
	
	@Column(nullable = false)
	private boolean visiabled;
	
	@Column(length=120)
	private String visiabledEL;
	
	/**
	 * 是否可用方法
	 */
	@Transient
	private boolean runDisabled;
	
	@Column(nullable = false)
	private boolean disabled;
	
	@Column(length=120)
	private String disabledEL;
	
	/**
	 * 点击按钮执行JavaScript脚本
	 */
	@Column(length=180)
	private String onclick;
	
	@Column(length=20)
	private String fileButtonType = "NOFILE";
	
	@Column(length=80)
	private String fileFileldName;
	
	@Column(length=80)
	private String fileAllowType;
	
	@Column
	private int fileLimitSize;
	
	@Column(length=80)
	private String parentButtonClick;
	
	@Column(length=120)
	private String fileProcessEL;
	
	@Column(length=80)
	private String filePath;
	
	/**
	 * 点击按钮执行action方法
	 */
	@Column(length=120)
	private String actionEL;
	
	@Column(length=80)
	private String styleClass;
	
	@Column(length=120)
	private String style;
	
	@Column(length=80)
	private String icon;

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public String getCommandValueEL() {
		return commandValueEL;
	}

	public void setCommandValueEL(String commandValueEL) {
		this.commandValueEL = commandValueEL;
	}

	public String getActionListenerEL() {
		return actionListenerEL;
	}

	public void setActionListenerEL(String actionListenerEL) {
		this.actionListenerEL = actionListenerEL;
	}

	public String getDisabledEL() {
		return disabledEL;
	}

	public void setDisabledEL(String disabledEL) {
		this.disabledEL = disabledEL;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getActionEL() {
		return actionEL;
	}

	public void setActionEL(String actionEL) {
		this.actionEL = actionEL;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isRunDisabled() {
		return runDisabled;
	}

	public void setRunDisabled(boolean runDisabled) {
		this.runDisabled = runDisabled;
	}

	public boolean isSelectRecord() {
		return selectRecord;
	}

	public void setSelectRecord(boolean selectRecord) {
		this.selectRecord = selectRecord;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getUpdateComponent() {
		return updateComponent;
	}

	public void setUpdateComponent(String updateComponent) {
		this.updateComponent = updateComponent;
	}

	public boolean isRunVisiabled() {
		return runVisiabled;
	}

	public void setRunVisiabled(boolean runVisiabled) {
		this.runVisiabled = runVisiabled;
	}

	public boolean isVisiabled() {
		return visiabled;
	}

	public void setVisiabled(boolean visiabled) {
		this.visiabled = visiabled;
	}

	public String getVisiabledEL() {
		return visiabledEL;
	}

	public void setVisiabledEL(String visiabledEL) {
		this.visiabledEL = visiabledEL;
	}

	public String getFileButtonType() {
		return fileButtonType;
	}

	public void setFileButtonType(String fileButtonType) {
		this.fileButtonType = fileButtonType;
	}

	public String getFileFileldName() {
		return fileFileldName;
	}

	public void setFileFileldName(String fileFileldName) {
		this.fileFileldName = fileFileldName;
	}

	public String getFileProcessEL() {
		return fileProcessEL;
	}

	public void setFileProcessEL(String fileProcessEL) {
		this.fileProcessEL = fileProcessEL;
	}

	public String getFileAllowType() {
		return fileAllowType;
	}

	public void setFileAllowType(String fileAllowType) {
		this.fileAllowType = fileAllowType;
	}

	public int getFileLimitSize() {
		return fileLimitSize;
	}

	public void setFileLimitSize(int fileLimitSize) {
		this.fileLimitSize = fileLimitSize;
	}

	public String getParentButtonClick() {
		return parentButtonClick;
	}

	public void setParentButtonClick(String parentButtonClick) {
		this.parentButtonClick = parentButtonClick;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
