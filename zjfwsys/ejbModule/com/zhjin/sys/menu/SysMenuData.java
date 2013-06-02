/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.menu;

import java.io.Serializable;
import java.util.List;

import org.primefaces.model.menu.MenuModel;

import com.zhjin.sys.entity.SysMenu;

public class SysMenuData implements Serializable{

	private List<SysMenu> moduleList;
	
	private MenuModel menuList;

	public List<SysMenu> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<SysMenu> moduleList) {
		this.moduleList = moduleList;
	}

	public MenuModel getMenuList() {
		return menuList;
	}

	public void setMenuList(MenuModel menuList) {
		this.menuList = menuList;
	}
	
}
