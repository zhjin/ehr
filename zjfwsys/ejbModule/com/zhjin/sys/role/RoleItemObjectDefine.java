/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.zhjin.base.EntityBase;

@Entity
@IdClass(value=RoleItemObjectPK.class)
public class RoleItemObjectDefine extends EntityBase {

	@Id
	@Column
	private long roleId;
	
	@Id
	@Column
	private long menuId;
	
	@Id
	@Column(length=80)
	private String objectId;
	
	@Column(length=80)
	private String roleItemObjectName;
	
	@Column
	private boolean visiabled;
	
	@Column(length=120)
	private String visiableEL;
	
	@Column(length=120)
	private String enabledEL;
	
	@Column(length=120)
	private String remark;
	
	@Override
	public String getRowKey() {
		return this.roleId + ":" + this.menuId + ":" + this.objectId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getRoleItemObjectName() {
		return roleItemObjectName;
	}

	public void setRoleItemObjectName(String roleItemObjectName) {
		this.roleItemObjectName = roleItemObjectName;
	}

	public String getVisiableEL() {
		return visiableEL;
	}

	public void setVisiableEL(String visiableEL) {
		this.visiableEL = visiableEL;
	}

	public String getEnabledEL() {
		return enabledEL;
	}

	public void setEnabledEL(String enabledEL) {
		this.enabledEL = enabledEL;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isVisiabled() {
		return visiabled;
	}

	public void setVisiabled(boolean visiabled) {
		this.visiabled = visiabled;
	}

}
