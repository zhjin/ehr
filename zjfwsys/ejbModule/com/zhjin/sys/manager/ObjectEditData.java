/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.faces.model.SelectItem;

import org.apache.commons.beanutils.PropertyUtils;

import com.zhjin.sys.entity.ViewObjectFieldProperty;
import com.zhjin.sys.entity.ViewObjectProperty;
import com.zhjin.util.EUser;
import com.zhjin.util.EuserSelect;
import com.zhjin.util.Utility;

public class ObjectEditData {

	private Object editData;

	private String editTitle;

	private List<ViewObjectFieldProperty> fieldList;

	private ViewObjectProperty viewObjectProperty;

	private String readOnlyColumns;

	private String hideColumns;

	private TreeSet<String> readOnlyColumnsTree;

	private TreeSet<String> hideColumnsTree;

	private String processCommandValue;

	private String processEL;

	private String buttonclick;

	private String remark;

	private TreeMap<String, List<SelectItem>> menuList;
	private TreeMap<String, List<SelectItem>> editMenuList;
	private TreeMap<String, EuserSelect> selectUserTree;
	
	public ViewObjectFieldProperty getField(String fieldName) {
		ViewObjectFieldProperty ret = null;
		for (ViewObjectFieldProperty  vop : this.getFieldList()) {
			if (vop.getFieldName().equals(fieldName)) {
				ret = vop;
				break;
			}
		}
		return ret;
	}

	public ViewObjectFieldProperty getViewObjectFieldProperty(String fieldName) {
		ViewObjectFieldProperty voep = null;
		for (ViewObjectFieldProperty v : fieldList) {
			if (v.getFieldName().equalsIgnoreCase(fieldName)) {
				voep = v;
				break;
			}
		}
		return voep;
	}
	
	public Object getEditData() {
		if (selectUserTree != null) {
			for (String fieldName : selectUserTree.keySet()) {
				try {
					if (selectUserTree.get(fieldName) == null || selectUserTree.get(fieldName).getEmpId() == 0L) {	
						if (fieldName.equals("empId")) {
							PropertyUtils.setProperty(editData, fieldName, 0L);
							PropertyUtils.setProperty(editData, fieldName.replaceAll("empId", "loginName"), null);
							PropertyUtils.setProperty(editData, fieldName.replaceAll("empId", "name"), null);							
						} else {
							PropertyUtils.setProperty(editData, fieldName, 0L);
							PropertyUtils.setProperty(editData, fieldName.replaceAll("EmpId", "LoginName"), null);
							PropertyUtils.setProperty(editData, fieldName.replaceAll("EmpId", "Name"), null);
						}
					} else {
						if (fieldName.equals("empId")) {
							PropertyUtils.setProperty(editData, fieldName, selectUserTree.get(fieldName).getEmpId());
							PropertyUtils.setProperty(editData, fieldName.replaceAll("empId", "loginName"), selectUserTree.get(fieldName).getLoginName());
							PropertyUtils.setProperty(editData, fieldName.replaceAll("empId", "name"), selectUserTree.get(fieldName).getName());							
						} else {
							PropertyUtils.setProperty(editData, fieldName, selectUserTree.get(fieldName).getEmpId());
							PropertyUtils.setProperty(editData, fieldName.replaceAll("EmpId", "LoginName"), selectUserTree.get(fieldName).getLoginName());
							PropertyUtils.setProperty(editData, fieldName.replaceAll("EmpId", "Name"), selectUserTree.get(fieldName).getName());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return editData;
	}
	
	public void setEditData(Object editData) {
		if (this.selectUserTree != null) {
			for (String fieldName : this.selectUserTree.keySet()) {
				try {
					long userId = ((Long)PropertyUtils.getProperty(editData, fieldName)).longValue();
					EuserSelect _selected = new EuserSelect();
					if (userId > 0) {
						EUser _user = Utility.getDBUtility().getEntity(EUser.class, userId);
						if (_user != null) {
							_selected.setEmpId(_user.getId());
							_selected.setLoginName(_user.getLoginName());
							_selected.setName(_user.getName());
						}
					}
					this.selectUserTree.put(fieldName, _selected);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		this.editData = editData;
	}
	
	public List<ViewObjectFieldProperty> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<ViewObjectFieldProperty> fieldList) {
		this.fieldList = fieldList;
	}
	public ViewObjectProperty getViewObjectProperty() {
		return viewObjectProperty;
	}
	public void setViewObjectProperty(ViewObjectProperty viewObjectProperty) {
		this.viewObjectProperty = viewObjectProperty;
	}
	public String getReadOnlyColumns() {
		return readOnlyColumns;
	}
	public void setReadOnlyColumns(String readOnlyColumns) {
		this.readOnlyColumns = readOnlyColumns;
	}
	public String getHideColumns() {
		return hideColumns;
	}
	public void setHideColumns(String hideColumns) {
		this.hideColumns = hideColumns;
	}
	public TreeSet<String> getReadOnlyColumnsTree() {
		return readOnlyColumnsTree;
	}
	public void setReadOnlyColumnsTree(TreeSet<String> readOnlyColumnsTree) {
		this.readOnlyColumnsTree = readOnlyColumnsTree;
	}
	public TreeSet<String> getHideColumnsTree() {
		return hideColumnsTree;
	}
	public void setHideColumnsTree(TreeSet<String> hideColumnsTree) {
		this.hideColumnsTree = hideColumnsTree;
	}
	public TreeMap<String, List<SelectItem>> getMenuList() {
		return menuList;
	}
	public void setMenuList(TreeMap<String, List<SelectItem>> menuList) {
		this.menuList = menuList;
	}
	public TreeMap<String, List<SelectItem>> getEditMenuList() {
		return editMenuList;
	}
	public void setEditMenuList(TreeMap<String, List<SelectItem>> editMenuList) {
		this.editMenuList = editMenuList;
	}
	public String getEditTitle() {
		return editTitle;
	}
	public void setEditTitle(String editTitle) {
		this.editTitle = editTitle;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProcessEL() {
		return processEL;
	}
	public void setProcessEL(String processEL) {
		this.processEL = processEL;
	}
	public String getButtonclick() {
		return buttonclick;
	}
	public void setButtonclick(String buttonclick) {
		this.buttonclick = buttonclick;
	}
	public String getProcessCommandValue() {
		return processCommandValue;
	}
	public void setProcessCommandValue(String processCommandValue) {
		this.processCommandValue = processCommandValue;
	}
	public TreeMap<String, EuserSelect> getSelectUserTree() {
		return selectUserTree;
	}
	public void setSelectUserTree(TreeMap<String, EuserSelect> selectUserTree) {
		this.selectUserTree = selectUserTree;
	}

}
