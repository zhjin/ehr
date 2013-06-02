/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhjin.util.Utility;

@WebServlet("/sys/showImage")
public class showImage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		long imageId = Integer.valueOf(req.getParameter("imageId"));
		InputStream fin = null;
		resp.reset();
		try {		
			if (imageId > 0) {
				fin = Utility.getSysUtil().getDownloadFileInputStream(imageId);

				byte[] buffer = new byte[65536];
				int i = 0;
			    while (( i = fin.read(buffer)) > 0 ) {
			    	resp.getOutputStream().write(buffer, 0, i);
			    }
			    resp.getOutputStream().flush();
			    resp.getOutputStream().close();
			}
		} catch (Exception e) {
		} finally {
			if (fin != null) fin.close();
			fin = null;
		}	
	}

}
