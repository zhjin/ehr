/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import java.io.Serializable;
import java.util.HashMap;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.zhjin.sys.menu.SysMenuData;

@Named
@SessionScoped
public class UserSession implements Serializable {

	private User user;

	private HashMap<String, SysMenuData> menuMap;

	public UserSession() {
		super();
		user = new User();
		menuMap = new HashMap<String, SysMenuData>();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HashMap<String, SysMenuData> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(HashMap<String, SysMenuData> menuMap) {
		this.menuMap = menuMap;
	}

}
