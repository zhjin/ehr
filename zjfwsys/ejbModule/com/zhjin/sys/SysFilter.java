/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.zhjin.context.ConvManager;
import com.zhjin.context.ConversationData;
import com.zhjin.util.UserSession;

@WebFilter(urlPatterns="/*")
public class SysFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)arg0;
		
		//  判断是否已经登录
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if (userSession != null && userSession.getUser().isHasLogin()) {
			
		} else {
			//跳转到登录页
			
		}
		
		String wid = (String)request.getParameter(ConvManager.WID_NAME);

		if (wid != null) {
			request.setAttribute(ConvManager.CURRENTCONVID, wid);
		}

		if (wid != null
				&& !request.getRequestURI().startsWith(request.getContextPath() + "/javax.faces.resource")
				&& !request.getRequestURI().startsWith(request.getContextPath() + "/resources")) {

			HashMap<String, ConversationData> convMap = (HashMap<String, ConversationData>)request.getSession().getAttribute(ConvManager.CONV_MAP_NAME);
			if (convMap != null) {
				List<String> _l = new ArrayList<String>();
				for (Object o : convMap.keySet()) {
					ConversationData data = convMap.get(o);
					if (data != null) {
						if (System.currentTimeMillis() - data.getLastTime() > data.getTimeout() * 60 * 1000) {
							_l.add((String)o);
						}
					}
				}
				for (String s : _l) {
					convMap.remove(s);
				}
			}
		}

		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
