/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.role;

import java.io.Serializable;

public class RoleItemObjectPK implements Serializable {

	private long roleId;
	
	private long menuId;
	
	private String objectId;

	@Override
	public boolean equals(Object obj) {
		RoleItemObjectPK pk = (RoleItemObjectPK)obj;
		return this.roleId == pk.getRoleId() && this.menuId == pk.getMenuId() && objectId != null && objectId.equals(pk.getObjectId());
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
	
}
