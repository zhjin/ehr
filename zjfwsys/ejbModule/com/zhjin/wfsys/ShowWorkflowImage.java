/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.wfsys;

import java.io.IOException;
import java.io.InputStream;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.repository.ProcessDefinition;

import com.zhjin.context.ConvManager;
import com.zhjin.sys.window.WindowData;
import com.zhjin.util.DBUtility;

@WebServlet(urlPatterns="/workflow/showworkflowimage")
public class ShowWorkflowImage extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InputStream iStream = null;

		try {
			response.reset();
			response.setHeader("Pragma","no-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setHeader("Expires","0");
			
	    	ProcessDefinition pdf = WFUtil.processEngine.getRepositoryService().createProcessDefinitionQuery().processDefinitionId((String)request.getParameter("wfid")).singleResult();
	    	iStream = WFUtil.processEngine.getRepositoryService().getResourceAsStream(pdf.getDeploymentId(), pdf.getDiagramResourceName());
	    	
			byte[] bytes = new byte[65536];
			ServletOutputStream outputStream = response.getOutputStream();
			int len = -1; 
			while((len = iStream.read(bytes, 0, 65536)) != -1) {  
				outputStream.write(bytes, 0, len);  
			}     
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			System.out.println("ShowImage Error:");
			//e.printStackTrace();
		} finally {
			if (iStream != null) {
				iStream.close();
			}
		}
	}

}
