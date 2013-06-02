/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhjin.base.entity.SysLargeText;
import com.zhjin.util.Utility;

@WebServlet(urlPatterns="/sys/showdbpage")
public class ShowDBPage extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SysLargeText lt = null;

		try (ServletOutputStream outputStream = response.getOutputStream()){

			long customId = Long.valueOf(request.getParameter("id"));

			if (customId > 0) {
				lt = Utility.getDBUtility().getEntity(SysLargeText.class, customId);

				response.reset();
				response.setHeader("Pragma","no-cache");
				response.setHeader("Cache-Control","no-cache");
				response.setHeader("Expires","0");
				response.setHeader("Content-Type", "text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"");
				out.println("      xmlns:h=\"http://java.sun.com/jsf/html\"");
				out.println("      xmlns:f=\"http://java.sun.com/jsf/core\"");
				out.println("      xmlns:ui=\"http://java.sun.com/jsf/facelets\"");
				out.println("      xmlns:zhjin=\"http://java.sun.com/jsf/composite/component\"");
				out.println("      xmlns:composite=\"http://java.sun.com/jsf/composite\"");
				out.println("      xmlns:p=\"http://primefaces.org/ui\" ");
				out.println("      xmlns:zh=\"http://www.zhjin.com/custom\"> ");
				if (lt != null) {
					out.println(lt.getTextContent());
				}

				out.println("</ui:composition>");
				out.flush();
				out.close();
			}

		} catch (Exception e) {
			System.out.println("ShowDBPage Error:");
		}

	}

}
