/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.zhjin.sys.role.EUserRole;
import com.zhjin.sys.role.RoleDefine;
import com.zhjin.sys.window.WindowData;
import com.zhjin.util.ArgMap;
import com.zhjin.util.BeanBase;
import com.zhjin.util.EUser;
import com.zhjin.util.SysUtil;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class SysManager
 */
@Named
@Stateless
@LocalBean
public class SysManager extends BeanBase {
	
	@EJB
	private TableManager tableManager;
	
	@EJB
	private SysUtil sysUtil;
    /**
     * Default constructor. 
     */
    public SysManager() {
    }

    public void initRoleItem() throws Exception {
    	WindowData wdata = this.getWindowData();
    	RoleDefine rd = (RoleDefine)wdata.getInData();
    	dbUtility.executeUpdate("delete roleitemdefine where roleid = :roleId and menuid not in (select id from sysmenu where enabled = 1 and highid >= 0)", 
    			new ArgMap().add("roleId", rd.getId()));
    	dbUtility.executeUpdate("insert into roleitemdefine(roleid, menuid, visiabled, enabled, version, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10) " +
    			"select :roleId, id, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 from sysmenu " +
    			"where enabled = 1 and highid >= 0 and id not in (select menuid from roleitemdefine where roleid = :roleId)", 
    			new ArgMap().add("roleId", rd.getId()));
    }
    
	public Object newEUserRole() {	
		EUserRole role = new EUserRole();
		role.setUserId(((EUser)this.getWindowData().getParentWindowData().getInData()).getId());
		return role;
	}
	
	public void initUserPassword(Object obj) throws Exception {	
		EUser _user = (EUser)obj;
		String _pass = String.valueOf(new Random().nextInt(1000000));
		if (_pass.length() < 6) {
			_pass = new java.text.DecimalFormat("000000").format(Integer.parseInt(_pass));
		}
		_user.setPassword(Utility.encoderPassword(_user.getLoginName(), _pass));
		_user.setForceChangePass(true);
		dbUtility.update(_user);
		Utility.showAlertMessage(_user.getName() + " 密码初始化为 " + _pass );
	}
    
}
