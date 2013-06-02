/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.menu;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

import com.zhjin.sys.entity.SysMenu;
import com.zhjin.sys.menu.SysMenuManager;
import com.zhjin.util.BeanBase;

@Named
@Stateless
@LocalBean
public class EhrMenuManager extends BeanBase {

	@EJB
	private SysMenuManager sysMenuManager;

    /**
     * Default constructor.
     */
    public EhrMenuManager() {

    }

    public String initEHRMenu() throws Exception {

    	SysMenu sysMenu = dbUtility.getEntity("select * from sysmenu where sysname = 'EHR'", SysMenu.class, null);
    	if (sysMenu != null) {
    		sysMenuManager.initModuleList(sysMenu.getId());
    	} else {
    		throw new Exception("EHR菜单不存在!");
    	}
    	this.getUser().setHasLogin(true);
    	return "/main.jsf?faces-redirect=true";
    	
    }

}
