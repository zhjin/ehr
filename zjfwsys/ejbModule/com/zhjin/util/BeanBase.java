/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import javax.ejb.EJB;
import javax.inject.Inject;

import com.zhjin.context.ConvManager;
import com.zhjin.sys.window.WindowData;

public class BeanBase {

	@EJB
	protected DBUtility dbUtility;
	
	@Inject
	private UserSession userSession;
	
	@Inject
	private ApplicationPara appParameter;
	
	@Inject
	private WindowData windowData;
	
	public User getUser() {
		return userSession.getUser();
	}

	public void setUser(User user) {
		userSession.setUser(user);
	}
	
	public UserSession getUserSession() {
		return this.userSession;
	}

	public ApplicationPara getAppParameter() {
		return appParameter;
	}

	public void setAppParameter(ApplicationPara appParameter) {
		this.appParameter = appParameter;
	}	
	
	public WindowData getWindowData() {
		return this.windowData;
	}
    
}
