/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class WindowDefine extends EntityHasIdBase {

	@Column(length=40)
	private String convName;

	@Column(length=80)
	private String windowSysName;

	@Column(length=120)
	private String windowName;

	@Column(length=120)
	private String windowTitle;

	@Column(length=120)
	private String initWindowEL;

	@Column(length=120)
	private String beforeOpenEL;

	@Column(length=200)
	private String windowURL;

	@Column(nullable = false)
	private int windowWidth;

	@Column(nullable = false)
	private int windowHeight;

	@Column(length=60)
	private String windowType;

	@Column
	private long table1;

	@Column
	private long table2;

	@Column
	private long dialog1;

	@Column
	private long tree1;

	@Column
	private long customId;

	@Column(length=120)
	private String remark;

	public String getConvName() {
		return convName;
	}

	public void setConvName(String convName) {
		this.convName = convName;
	}

	public String getWindowTitle() {
		return windowTitle;
	}

	public void setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
	}

	public String getInitWindowEL() {
		return initWindowEL;
	}

	public void setInitWindowEL(String initWindowEL) {
		this.initWindowEL = initWindowEL;
	}

	public String getBeforeOpenEL() {
		return beforeOpenEL;
	}

	public void setBeforeOpenEL(String beforeOpenEL) {
		this.beforeOpenEL = beforeOpenEL;
	}

	public String getWindowURL() {
		return windowURL;
	}

	public void setWindowURL(String windowURL) {
		this.windowURL = windowURL;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}

	public String getWindowType() {
		return windowType;
	}

	public void setWindowType(String windowType) {
		this.windowType = windowType;
	}

	public String getWindowName() {
		return windowName;
	}

	public void setWindowName(String windowName) {
		this.windowName = windowName;
	}

	public long getTable1() {
		return table1;
	}

	public void setTable1(long table1) {
		this.table1 = table1;
	}

	public long getTable2() {
		return table2;
	}

	public void setTable2(long table2) {
		this.table2 = table2;
	}

	public long getDialog1() {
		return dialog1;
	}

	public void setDialog1(long dialog1) {
		this.dialog1 = dialog1;
	}

	public long getTree1() {
		return tree1;
	}

	public void setTree1(long tree1) {
		this.tree1 = tree1;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWindowSysName() {
		return windowSysName;
	}

	public void setWindowSysName(String windowSysName) {
		this.windowSysName = windowSysName;
	}

	public long getCustomId() {
		return customId;
	}

	public void setCustomId(long customId) {
		this.customId = customId;
	}

}
