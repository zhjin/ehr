/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class WindowCommandDefine extends CommandDefine  {
	
	@Column(length=60)
	private String conversationName;
	
	@Column(length=60)
	private String commandParentType;
	
	/**
	 * 窗口标识
	 */
	@Column
	private long windowId;
	
	@Column
	private long parentId;
	
	@Column(length=80)
	private String dataProcessEL;
	
	@Column(length=120)
	private String newConvDataProcessEL;

	/**
	 * 按钮显示次序
	 */
	@Column
	private int indexNo;

	public String getConversationName() {
		return conversationName;
	}

	public void setConversationName(String conversationName) {
		this.conversationName = conversationName;
	}

	public long getWindowId() {
		return windowId;
	}

	public void setWindowId(long windowId) {
		this.windowId = windowId;
	}

	public String getDataProcessEL() {
		return dataProcessEL;
	}

	public void setDataProcessEL(String dataProcessEL) {
		this.dataProcessEL = dataProcessEL;
	}

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public String getCommandParentType() {
		return commandParentType;
	}

	public void setCommandParentType(String commandParentType) {
		this.commandParentType = commandParentType;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getNewConvDataProcessEL() {
		return newConvDataProcessEL;
	}

	public void setNewConvDataProcessEL(String newConvDataProcessEL) {
		this.newConvDataProcessEL = newConvDataProcessEL;
	}

}
