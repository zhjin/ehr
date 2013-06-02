/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.test;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import com.zhjin.sys.manager.TableManager;
import com.zhjin.sys.manager.TreeManager;
import com.zhjin.sys.menu.SysMenuManager;
import com.zhjin.sys.window.WindowData;
import com.zhjin.sys.window.WindowManager;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.SysUtil;

/**
 * Session Bean implementation class TestBean
 */
@Named
@Stateless
@LocalBean
public class TestBean extends BeanBase {

	@Inject
	private TestData testData;

	@EJB
	private SysUtil sysUtil;

	@EJB
	private TreeManager treeManager;

	@EJB
	private TableManager tableManager;

	@EJB
	private WindowManager windowManager;

	@EJB
	private SysMenuManager menuManager;

    @Audit
    public void testClick(ActionEvent event) throws Exception {

//    	FacesContext facesContext = FacesContext.getCurrentInstance();
//    	UIComponent ui = facesContext.getViewRoot().findComponent("f:panel");
//    	FaceletFactory ff = (FaceletFactory) RequestStateManager.get(facesContext, RequestStateManager.FACELET_FACTORY);
//
//    	FaceletCacheFactory cache = null;
//    	Facelet ft = ff.getFacelet("http://localhost/zjfwWeb/sys/showdbpage?id=3");
//    	System.out.println("Facelet : " + ft);
//    	System.out.println(ui.getFacetCount());
//    	ui.getChildren().clear();
//    	ft.apply(facesContext, ui);

    }

    @Audit
    public String loginClick() throws Exception {

    	
    	this.getUser().setUserId(1559L);
    	this.getUser().setLoginName("a2");
    	this.getUser().setName("a2");
    	this.getUser().setOperOrgId1(1082L);
    	menuManager.initModuleList(1);
    	return "/main.jsf?faces-redirect=true";
    }

    public void testWindow() throws Exception {
    	WindowData wd = this.getWindowData();

    }

    public void handleFileUpload(FileUploadEvent event) {
    	System.out.println(event.getFile().getFileName());
    	System.out.println("abc");
	}

    public void testAjax() {

    }

}
