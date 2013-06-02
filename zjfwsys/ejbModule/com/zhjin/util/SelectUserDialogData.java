/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named
@ConversationScoped
public class SelectUserDialogData implements Serializable {
	
	private String dialogTitle;
	private String queryString;
	private String queryResult;
	private List<SelectItem> resultList;
	private Long userId;
	private String confirmEL;
	private String parentWindowButtonId;
	
	public String getDialogTitle() {
		return dialogTitle;
	}
	public void setDialogTitle(String dialogTitle) {
		this.dialogTitle = dialogTitle;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public String getQueryResult() {
		return queryResult;
	}
	public void setQueryResult(String queryResult) {
		this.queryResult = queryResult;
	}
	public List<SelectItem> getResultList() {
		return resultList;
	}
	public void setResultList(List<SelectItem> resultList) {
		this.resultList = resultList;
	}
	public String getConfirmEL() {
		return confirmEL;
	}
	public void setConfirmEL(String confirmEL) {
		this.confirmEL = confirmEL;
	}
	public String getParentWindowButtonId() {
		return parentWindowButtonId;
	}
	public void setParentWindowButtonId(String parentWindowButtonId) {
		this.parentWindowButtonId = parentWindowButtonId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
