/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys;

import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.zhjin.context.ConvManager;
import com.zhjin.util.Utility;

public class ZhjinViewHandler extends ViewHandlerWrapper {

	private ViewHandler wrapped;
	
	public ZhjinViewHandler(ViewHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ViewHandler getWrapped() {
		return wrapped;
	}

	@Override
	public UIViewRoot restoreView(FacesContext context, String viewId) {
		UIViewRoot root = null;
		root = wrapped.restoreView(context, viewId);
		if (root == null) {
			System.out.println("Create View : " + viewId);
			root = createView(context, viewId);
		}
		return root;
	}

	@Override
	public String getActionURL(FacesContext context, String viewId) {
		HttpServletRequest _request = (HttpServletRequest)context.getExternalContext().getRequest();
		String _qStr = _request.getQueryString();
		String _oldUrl = wrapped.getActionURL(context, viewId);
		if (_qStr == null) {
			if (Utility.notEmptyString(ConvManager.getCurrentConvId())) {
				return _oldUrl + "?" + ConvManager.WID_NAME + "=" + ConvManager.getCurrentConvId();
			} else {
				return _oldUrl;
			}
		} else {
			return _oldUrl + "?" + _qStr;
		}
	}

}
