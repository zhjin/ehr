/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import java.util.List;

import javax.faces.model.SelectItem;

public class TableQueryItem {

	/**
	 * 逻辑运算符, 与 - AND, 或 - OR, 非 - NOT
	 */
	private String condition;

	/*
	 * 左括号
	 */
	private boolean leftParentheses;

	/**
	 * 字段显示名称
	 */
	private String fieldNameCN;

	/**
	 * 字段名称
	 */
	private String field;

	/**
	 * 操作符
	 */
	private String operator;

	private String showType;

	private String dataType;
	
	private String pattern;

	private List<SelectItem> dropList;

	/**
	 * 值
	 */
	private Object value;

	/**
	 * 右括号
	 */
	private boolean rightParentheses;

	private boolean deleteBit;

	public boolean isDeleteBit() {
		return deleteBit;
	}

	public void setDeleteBit(boolean deleteBit) {
		this.deleteBit = deleteBit;
	}

	public List<SelectItem> getDropList() {
		return dropList;
	}

	public void setDropList(List<SelectItem> dropList) {
		this.dropList = dropList;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldNameCN() {
		return fieldNameCN;
	}

	public void setFieldNameCN(String fieldNameCN) {
		this.fieldNameCN = fieldNameCN;
	}

	public boolean isLeftParentheses() {
		return leftParentheses;
	}

	public void setLeftParentheses(boolean leftParentheses) {
		this.leftParentheses = leftParentheses;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public boolean isRightParentheses() {
		return rightParentheses;
	}

	public void setRightParentheses(boolean rightParentheses) {
		this.rightParentheses = rightParentheses;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public boolean isSelectOneChoice() {
		return "SELECTMENU".equals(showType.toUpperCase());
	}

	public boolean isDate() {
		return "DATE".equals(showType.toUpperCase()) || "DATETIME".equals(dataType.toUpperCase());
	}

	public boolean isText() {
		return ("TEXT".equals(showType.toUpperCase()) 
				|| "TEXTAREA".equals(showType.toUpperCase()));
	}

	public boolean isNumber() {
		return "BIGDECIMAL".equals(showType.toUpperCase()) || "NUMBER".equals(showType.toUpperCase());
	}

	public boolean isCheckBox() {
		return "CHECKBOX".equals(showType.toUpperCase());
	}
	
	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
