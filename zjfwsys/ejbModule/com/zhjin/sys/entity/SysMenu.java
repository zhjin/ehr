/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SysMenu extends com.zhjin.base.TreeEntityBase {

	@Column(length=80)
	private String convName;

	@Column(length=120)
	private String beforeOpenEL;

	@Column(length=120)
	private String afterOpenEL;

	@Column
	private long windowId;

	@Column
	private boolean visiabled;

	@Column(length=120)
	private String visiabledEL;

	@Column
	private boolean operate;

	@Column(length=120)
	private String operateEL;

	@Column
	private boolean allHave;

	@Column(length=60)
	private String icon;

	@Column(length=60)
	private String sysName;

	public SysMenu() {
		super();
		allHave = false;
	}

	public String getBeforeOpenEL() {
		return beforeOpenEL;
	}

	public void setBeforeOpenEL(String beforeOpenEL) {
		this.beforeOpenEL = beforeOpenEL;
	}

	public String getAfterOpenEL() {
		return afterOpenEL;
	}

	public void setAfterOpenEL(String afterOpenEL) {
		this.afterOpenEL = afterOpenEL;
	}

	public long getWindowId() {
		return windowId;
	}

	public void setWindowId(long windowId) {
		this.windowId = windowId;
	}

	public boolean isVisiabled() {
		return visiabled;
	}

	public void setVisiabled(boolean visiabled) {
		this.visiabled = visiabled;
	}

	public boolean isOperate() {
		return operate;
	}

	public void setOperate(boolean operate) {
		this.operate = operate;
	}

	public boolean isAllHave() {
		return allHave;
	}

	public void setAllHave(boolean allHave) {
		this.allHave = allHave;
	}

	public String getConvName() {
		return convName;
	}

	public void setConvName(String convName) {
		this.convName = convName;
	}

	public String getVisiabledEL() {
		return visiabledEL;
	}

	public void setVisiabledEL(String visiabledEL) {
		this.visiabledEL = visiabledEL;
	}

	public String getOperateEL() {
		return operateEL;
	}

	public void setOperateEL(String operateEL) {
		this.operateEL = operateEL;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
}
