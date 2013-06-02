/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.context.protocol.db;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler extends URLStreamHandler {

	public Handler() {
		super();
		System.out.println("custom protocol");
	}

	@Override
	protected URLConnection openConnection(URL u) throws IOException {
	    URL resourceUrl = ClassLoader.getSystemClassLoader().getResource(u.getPath());
	    System.out.println(resourceUrl);
        return resourceUrl.openConnection();
	}
	

}
