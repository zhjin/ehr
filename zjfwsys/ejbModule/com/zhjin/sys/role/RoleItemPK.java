/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.role;

import java.io.Serializable;

public class RoleItemPK implements Serializable {

	private long roleId;
	
	private long menuId;

	@Override
	public boolean equals(Object obj) {	
		RoleItemPK key = (RoleItemPK)obj;
		return this.roleId == key.getRoleId() && this.menuId == key.getMenuId();
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
	
	
}
