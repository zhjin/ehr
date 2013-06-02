/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.view.facelets.ResourceResolver;

public class SysResourceResolver extends ResourceResolver {
	
	private ResourceResolver parent;

	public SysResourceResolver(ResourceResolver parent) {
		super();
		this.parent = parent;
	}

	@Override
	public URL resolveUrl(String arg0) {
		URL url = parent.resolveUrl(arg0);

		if (url == null) {
			try {
				url = new URL("http://localhost:8080/zjfwWeb/sys/showdbpage");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return url;
	}

}
