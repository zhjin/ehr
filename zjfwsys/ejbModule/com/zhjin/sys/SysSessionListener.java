/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SysSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

		HttpSession session = arg0.getSession();
		
		//ConvManager.sessionSet.add(session);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

		HttpSession session = arg0.getSession();
	
	}

}
