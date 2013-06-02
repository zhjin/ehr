/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.zhjin.context.ConvManager;
import com.zhjin.sys.entity.SysMenu;
import com.zhjin.sys.window.WindowData;
import com.zhjin.sys.window.WindowManager;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.EUser;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class SysMenuManager
 */
@Named
@Stateless
@LocalBean
public class SysMenuManager extends BeanBase {

	@Inject
	private WindowData windowData;

	@EJB
	private WindowManager windowManager;

    /**
     * Default constructor.
     */
    public SysMenuManager() {

    }

    public void initModuleList(long i) throws Exception {

    	// 初始化系统模块
    	SysMenuData menuData = new SysMenuData();
    	List<SysMenu> menuList = dbUtility.getDataList(
    			"select * from sysmenu " +
    			"	where enabled = 1 and highid = :highId and visiabled = 1 and " +
    			"	id in (select menuid from roleitemdefine where roleid in " +
    			"	(select id from roledefine where enabled = 1 and (allhave = 1 or id in " +
    			"	(select roleid from euserrole where enabled = 1 and userid = :userId))) group by menuid having sum(visiabled) > 0) " +
    			"	order by indexno",
    			SysMenu.class, new ArgMap().add("highId", i).add("userId", this.getUser().getUserId()));
    	menuData.setModuleList(new ArrayList<SysMenu>());
    	for (SysMenu m : menuList) {
    		if (Utility.notEmptyString(m.getVisiabledEL())) {
    			if ((Boolean)Utility.getELValue(m.getVisiabledEL())) {
    				menuData.getModuleList().add(m);
    			}
    		} else {
    			menuData.getModuleList().add(m);
    		}
    	}

    	this.getUserSession().getMenuMap().put("SYSTEM", menuData);
    	if (menuData.getModuleList().size() > 0) {
    		menuData.setMenuList(this.moduleMenuList(menuData.getModuleList().get(0).getId()));
    	}

    }

    public String moduleClick() throws Exception {

    	String menuIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("menuId");
    	this.getUserSession().getMenuMap().get("SYSTEM").setMenuList(this.moduleMenuList(Long.valueOf(menuIdStr)));
    	return "/left.jsf";
    }

    public MenuModel moduleMenuList(long moduleId) {

    	MenuModel model = new DefaultMenuModel();

    	List<SysMenu> _list = dbUtility.getDataList(
    			"select * from sysmenu where enabled = 1 and id != :id and visiabled = 1 and id in (select menuid from roleitemdefine where roleid in " +
    			"	(select id from roledefine where enabled = 1 and (allhave = 1 or id in " +
    			"	(select roleid from euserrole where enabled = 1 and userid = :userId))) group by menuid having sum(visiabled) > 0) " +
    			"	connect by highid = prior id start with id = :id order siblings by indexno, label",
    			SysMenu.class, new ArgMap().add("id", moduleId).add("userId", this.getUser().getUserId()));

    	for (int i = 0; i < _list.size(); i++) {

    		SysMenu m = _list.get(i);

    		if (Utility.notEmptyString(m.getVisiabledEL())) {
    			if (!(Boolean)Utility.getELValue(m.getVisiabledEL())) {
    				continue;
    			}
    		}
    		
    		if (m.getHighId() == moduleId) {

    			DefaultSubMenu _menu = new DefaultSubMenu();
    			_menu.setLabel(m.getLabel());
    			model.addElement(_menu);
    			addSubmenu(_menu, m.getId(), _list);
    		}
    	}

    	return model;

    }

    private void addSubmenu(DefaultSubMenu parentComponent, long highId, List<SysMenu> _list) {

    	for (int i = 0; i < _list.size(); i++) {

    		SysMenu m = _list.get(i);
    		
    		if (Utility.notEmptyString(m.getVisiabledEL())) {
    			if (!(Boolean)Utility.getELValue(m.getVisiabledEL())) {
    				continue;
    			}
    		}
    		
    		if (m.getHighId() == highId) {

    			if (i < _list.size() - 1 && _list.get(i + 1).getHighId() == _list.get(i).getId()) {
    				DefaultSubMenu _menu = new DefaultSubMenu();
        			_menu.setLabel(m.getLabel());
        			parentComponent.addElement(_menu);
        			addSubmenu(_menu, m.getId(), _list);
    			} else {
    				DefaultMenuItem item = new DefaultMenuItem();
    				item.setId("menu" + m.getId());
    				if (Utility.notEmptyString(m.getIcon())) {
    					item.setIcon(m.getIcon().trim());
    				} else {
    					item.setIcon("ui-icon-stop");
    				}
    				item.setValue(m.getLabel());
    				item.setCommand("#{sysMenuManager.menuClick(" + m.getId() + ")}");
    				item.setAjax(false);
    				parentComponent.addElement(item);
    			}
    		}
    	}

    }

    public String menuClick(long menuId) throws Exception {

//    	String menuIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("menuId");
//
//    	SysMenu menu = dbUtility.getEntity(SysMenu.class, Long.valueOf(menuIdStr));
    	
    	SysMenu menu = dbUtility.getEntity(SysMenu.class, menuId);
    	boolean readOnly = true;
    	
    	if (dbUtility.exists("select menuid from roleitemdefine " +
    			"where roleid in (select id from roledefine where enabled = 1 and " +
    			"(allhave = 1 or id in (select roleid from euserrole where enabled = 1 and userid = :userId))) " +
    			"and visiabled = 1 and menuid = :menuId group by menuid having sum(enabled) > 0", 
    			new ArgMap().add("userId", this.getUser().getUserId()).add("menuId", menu.getId()))) {
    		readOnly = false;
    	} else {
    		readOnly = true;
    	}
    	
    	String convName = null;

    	if (Utility.notEmptyString((String)Utility.getELValue(menu.getConvName()))) {
    		convName = (String)Utility.getELValue(menu.getConvName());
    	} else {
    		convName= "menu_" + Long.toString(menu.getId());
    	}
    	
    	if (Utility.notEmptyString(menu.getBeforeOpenEL())) {
    		Utility.executeMethodExpression(menu.getBeforeOpenEL(), new Class[]{}, new Object[]{});
    	}
    	
    	windowManager.openNewWindow(convName, menu, menu.getWindowId(), menu.getBeforeOpenEL(), false, "", 120, readOnly);
    	windowData.setParentWindowData(null);

    	if (Utility.notEmptyString(menu.getAfterOpenEL())) {
    		Utility.executeMethodExpression(menu.getAfterOpenEL(), new Class[]{}, new Object[]{});
    	}
    	
    	return windowData.getWindowURL() + "?"
    		+ ConvManager.WID_NAME + "=" + ConvManager.getCurrentConvId() + "&faces-redirect=true";

    }
    
    @Audit
    public String loginClick() throws Exception {
    	if (!Utility.notEmptyString(this.getUser().getLoginName()) || !Utility.notEmptyString(this.getUser().getPassword())) {
    		throw new Exception("请输入用户名和密码!");
    	}
    	EUser user = dbUtility.getEntity("select * from euser where loginname = :loginName", 
    			EUser.class, new ArgMap().add("loginName", this.getUser().getLoginName()));
    	if (user != null) {
    		if (Utility.encoderPassword(this.getUser().getLoginName(), this.getUser().getPassword()).equals(user.getPassword())) {
    			
    			if (dbUtility.exists("select * from employeeview_leave where id = :id", new ArgMap().add("id", user.getId()))) {
    				throw new Exception("离职员工,不能登录系统!");
    			}
    			if (user.isLocked()) {
    				throw new Exception("账户已锁定,请联系系统管理员!");
    			}
    			
    			this.getUser().setUserId(user.getId());
    			this.getUser().setLoginName(user.getLoginName());
    			this.getUser().setName(user.getName());
    			this.getUser().setHasLogin(true);
    			this.getUser().setLoginTime(new Date());
    			this.getUser().setOperOrgId1(1082);
    			
    			this.initModuleList(1);
    			return "/main.jsf?faces-redirect=true";
    		} else {
    			throw new Exception("登录失败!");
    		}
    	} else {
    		throw new Exception("登录失败!");
    	}
    }

}
