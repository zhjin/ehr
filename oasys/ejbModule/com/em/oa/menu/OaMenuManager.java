/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.oa.menu;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

import com.zhjin.sys.entity.SysMenu;
import com.zhjin.sys.menu.SysMenuManager;
import com.zhjin.util.BeanBase;

/**
 * Session Bean implementation class OaMenuManager
 */
@Named
@Stateless
@LocalBean
public class OaMenuManager extends BeanBase {

	@EJB
	private SysMenuManager sysMenuManager;

    /**
     * Default constructor.
     */
    public OaMenuManager() {
    }

    public String initOAMenu() throws Exception {

    	SysMenu sysMenu = dbUtility.getEntity("select * from sysmenu where sysname = 'OA'", SysMenu.class, null);
    	if (sysMenu != null) {
    		sysMenuManager.initModuleList(sysMenu.getId());
    	} else {
    		throw new Exception("OA菜单不存在!");
    	}

    	return "/main.jsf?faces-redirect=true";
    }

}
