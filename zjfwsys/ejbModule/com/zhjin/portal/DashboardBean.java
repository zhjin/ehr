/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.portal;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@Named
@SessionScoped
public class DashboardBean implements Serializable {
	
	private DashboardModel model;

	public DashboardBean() {
		model = new DefaultDashboardModel();
		DashboardColumn column = new DefaultDashboardColumn();
		column.addWidget("message");
		column.addWidget("workitem");
		model.addColumn(column);
		column = new DefaultDashboardColumn();
		column.addWidget("info");
		column.addWidget("otherinfo");
		model.addColumn(column);
	}

	public DashboardModel getModel() {
		return model;
	}

	public void setModel(DashboardModel model) {
		this.model = model;
	}
	
}
