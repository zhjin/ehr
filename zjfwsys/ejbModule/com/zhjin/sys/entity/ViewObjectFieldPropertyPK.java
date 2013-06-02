/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import java.io.Serializable;

public class ViewObjectFieldPropertyPK implements Serializable {

	private String objectName;
	
	private String fieldName;

	public ViewObjectFieldPropertyPK(String objectName, String fieldName) {
		super();
		this.objectName = objectName;
		this.fieldName = fieldName;
	}

	public ViewObjectFieldPropertyPK() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		ViewObjectFieldPropertyPK pk = (ViewObjectFieldPropertyPK)obj;
		return this.objectName != null && this.fieldName != null && this.objectName.equals(pk.getObjectName()) && this.fieldName.equals(pk.getFieldName());
	}

	@Override
	public int hashCode() {
		return (this.objectName + this.fieldName).hashCode();
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
