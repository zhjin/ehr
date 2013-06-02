/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.test;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlPanelGroup;
import javax.inject.Named;

@Named
@SessionScoped
public class TestData implements Serializable {

	private String abc;
	int count;

	private HtmlPanelGroup panelGroup;

	public TestData() {
		super();
		abc = "测试";
		panelGroup = new HtmlPanelGroup();
		panelGroup.setId("panel");
		panelGroup.setId("testdynamic");
		count = 0;
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}

	public HtmlPanelGroup getPanelGroup() {
		return panelGroup;
	}

	public void setPanelGroup(HtmlPanelGroup panelGroup) {
		this.panelGroup = panelGroup;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
