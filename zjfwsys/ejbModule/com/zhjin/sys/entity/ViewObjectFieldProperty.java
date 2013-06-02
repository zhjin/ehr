/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;

import com.zhjin.base.EntityBase;

@Entity
@IdClass(value = ViewObjectFieldPropertyPK.class)
public class ViewObjectFieldProperty extends EntityBase {

	@Id
	@Column(length=80)
	private String objectName;
	
	@Id
	@Column(length=80)
	private String fieldName;
	
	@Column(length=40)
	private String fieldJavaType;
	
	@Column(length=80, nullable=false)
	private String fieldNameCN;
	
	@Column(length=20)
	private String showType;
	
	@Column(length=120)
	private String style;
	
	@Column(length=80)
	private String styleCSS;
	
	@Column(length=20)
	private String align;
	
	@Column
	private long dataSource;
	
	@Column
	private long editDataSource;
	
	@Column
	private boolean readOnly;
	
	@Column(length=120)
	private String readOnlyEL;
	
	@Column
	private boolean visiabled;
	
	@Column(length=120)
	private String visiabledEL;
	
	@Column(length=60)
	private String showFormat;
	
	@Column
	private int indexNo;
	
	@Column(length=80)
	private String valueChangeEL;
	
	@Column(length=60)
	private String reRender;
	
	@Column(length=40)
	private String fieldId;
	
	@Column(length=120)
	private String selectUserEL;
	
	@Column
	private boolean fixed;
	
	@Transient
	private boolean runReadOnly;
	
	@Transient
	private boolean runVisiabled;
	
	@Transient
	private boolean runEditReadOnly;
	
	@Transient
	private boolean runEditVisiabled;
	
	@Transient
	private String runBodyStyle;
	
	@Transient
	private String orderType;

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

	public String getFieldJavaType() {
		return fieldJavaType;
	}

	public void setFieldJavaType(String fieldJavaType) {
		this.fieldJavaType = fieldJavaType;
	}

	public String getFieldNameCN() {
		return fieldNameCN;
	}

	public void setFieldNameCN(String fieldNameCN) {
		this.fieldNameCN = fieldNameCN;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyleCSS() {
		return styleCSS;
	}

	public void setStyleCSS(String styleCSS) {
		this.styleCSS = styleCSS;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public long getDataSource() {
		return dataSource;
	}

	public void setDataSource(long dataSource) {
		this.dataSource = dataSource;
	}

	public long getEditDataSource() {
		return editDataSource;
	}

	public void setEditDataSource(long editDataSource) {
		this.editDataSource = editDataSource;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getReadOnlyEL() {
		return readOnlyEL;
	}

	public void setReadOnlyEL(String readOnlyEL) {
		this.readOnlyEL = readOnlyEL;
	}

	public boolean isVisiabled() {
		return visiabled;
	}

	public void setVisiabled(boolean visiabled) {
		this.visiabled = visiabled;
	}

	public String getVisiabledEL() {
		return visiabledEL;
	}

	public void setVisiabledEL(String visiabledEL) {
		this.visiabledEL = visiabledEL;
	}

	public String getShowFormat() {
		return showFormat;
	}

	public void setShowFormat(String showFormat) {
		this.showFormat = showFormat;
	}

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public String getValueChangeEL() {
		return valueChangeEL;
	}

	public void setValueChangeEL(String valueChangeEL) {
		this.valueChangeEL = valueChangeEL;
	}

	public String getReRender() {
		return reRender;
	}

	public void setReRender(String reRender) {
		this.reRender = reRender;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public boolean isRunReadOnly() {
		return runReadOnly;
	}

	public String getSelectUserEL() {
		return selectUserEL;
	}

	public void setSelectUserEL(String selectUserEL) {
		this.selectUserEL = selectUserEL;
	}

	public void setRunReadOnly(boolean runReadOnly) {
		this.runReadOnly = runReadOnly;
	}

	public boolean isRunVisiabled() {
		return runVisiabled;
	}

	public void setRunVisiabled(boolean runVisiabled) {
		this.runVisiabled = runVisiabled;
	}

	public boolean isRunEditReadOnly() {
		return runEditReadOnly;
	}

	public void setRunEditReadOnly(boolean runEditReadOnly) {
		this.runEditReadOnly = runEditReadOnly;
	}

	public boolean isRunEditVisiabled() {
		return runEditVisiabled;
	}

	public void setRunEditVisiabled(boolean runEditVisiabled) {
		this.runEditVisiabled = runEditVisiabled;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public String getRunBodyStyle() {
		if (this.align == null) {
			return "";
		} else if (this.align.toUpperCase().equals("LEFT")) {
			return "columnleft";
		} else if (this.align.toUpperCase().equals("RIGHT")) {
			return "columnright";
		} else if (this.align.toUpperCase().equals("CENTER")) {
			return "columncenter";
		} else {
			return "";
		}
	}

	public void setRunBodyStyle(String runBodyStyle) {
		this.runBodyStyle = runBodyStyle;
	}

	@Override
	public String getRowKey() {
		return this.objectName + ":" + this.fieldName;
	}
	
}
