/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.zhjin.base.TreeEntityBase;
import com.zhjin.sys.entity.ViewObjectFieldProperty;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.SysUtil;
import com.zhjin.util.Utility;

@Stateless
@Named
@LocalBean
public class TableQueryDialog extends BeanBase {
	
	@EJB
	private SysUtil sysUtil;
	
	/**
	 * 初始化
	 */
	public void initDialog(TableData data) {
		data.setQueryConditionList(new ArrayList<SelectItem>());
		data.getQueryConditionList().add(new SelectItem(" and ", "并且"));
		data.getQueryConditionList().add(new SelectItem(" or ", "或者"));
		data.getQueryConditionList().add(new SelectItem(" not ", "否"));
		data.setQueryOperatorList(new ArrayList<SelectItem>());
		data.getQueryOperatorList().add(new SelectItem(" = ", "等于"));
		data.getQueryOperatorList().add(new SelectItem(" < ", "小于"));
		data.getQueryOperatorList().add(new SelectItem(" <= ", "小于等于"));
		data.getQueryOperatorList().add(new SelectItem(" > ", "大于"));
		data.getQueryOperatorList().add(new SelectItem(" >= ", "大于等于"));
		data.getQueryOperatorList().add(new SelectItem(" like ", "类似"));
		data.setQuerySelectedColumn("");
		data.setQueryList(new ArrayList<TableQueryItem>());
		data.setQueryColumnList(new ArrayList<SelectItem>());
		for (ViewObjectFieldProperty obj : data.getColumnList()) {
			data.getQueryColumnList().add(new SelectItem(obj.getFieldName(), obj.getFieldNameCN()));
		}
	}

	public void addColumn(ActionEvent event) {
		TableData data = this.getWindowData().getDefaultTableData();
		if (data.getQueryList().size() >= 8) {
			return;
		}
		
		String column = data.getQuerySelectedColumn();
		if (column != null && !"".equals(column)) {
			TableQueryItem item = new TableQueryItem();
			item.setField(column);
			ViewObjectFieldProperty ofp = this.getField(column);
			item.setFieldNameCN(ofp.getFieldNameCN());
			item.setCondition(" and ");
			item.setLeftParentheses(false);
			item.setRightParentheses(false);
			item.setShowType(ofp.getShowType());
			item.setDataType(ofp.getFieldJavaType());
			item.setPattern(ofp.getShowFormat());

			if (ofp.getShowType().equals("TEXT") 
					&& ofp.getFieldJavaType().toUpperCase().equals("STRING")) {

				// 缺省操作符号为类似
				item.setOperator(" like ");
			} else {

				// 缺省操作符号为等于
				item.setOperator(" = ");
			}
			
			if (item.isSelectOneChoice()) {
				if (ofp.getEditDataSource() > 0) {
					item.setDropList(sysUtil.getViewObjectFieldSelectList(ofp.getEditDataSource()));
				} else {
					item.setDropList(sysUtil.getViewObjectFieldSelectList(ofp.getDataSource()));
				}
				
				if (item.getDataType().equals("int") || item.getDataType().equals("long")) {
					item.setValue("");
				}
			}
			data.getQueryList().add(item);	
		}
		Utility.updateComponent("filterArea");
	}
	
	private ViewObjectFieldProperty getField(String fieldName) {
		TableData data = this.getWindowData().getDefaultTableData();
		ViewObjectFieldProperty returnValue = null;
		for (ViewObjectFieldProperty obj : data.getColumnList()) {
			if (obj.getFieldName().equals(fieldName)) {
				returnValue = obj;
				break;
			}
		}
		return returnValue;
	}
	
	public void deleteColumn(ActionEvent event) {
		TableData data = this.getWindowData().getDefaultTableData();
		List<TableQueryItem> newQueryList = new ArrayList<TableQueryItem>();
		for (TableQueryItem o : data.getQueryList()) {
			if (!o.isDeleteBit()) {
				newQueryList.add(o);
			}
		}
		data.setQueryList(newQueryList);	
		Utility.updateComponent("filterArea");
	}
	
	@Audit
	public void okActionListener(ActionEvent event) throws Exception {
		TableData data = this.getWindowData().getDefaultTableData();
		StringBuffer buffer = new StringBuffer();
		HashMap<String, Object> filterArg = new HashMap<String, Object>();
		int argId = 0;
		try {
			for (TableQueryItem item : data.getQueryList()) {
				if (item.getValue() == null) {
					throw new Exception(item.getFieldNameCN() + ": 请输入查询条件值!");
				}
			}
			
			for (TableQueryItem item : data.getQueryList()) {
				if (buffer.length() > 0 || item.getCondition().equals(" not ")) {
					
					// 不是第一个条件，增加条件
					buffer.append(item.getCondition());
				}
				
				// 判断是否有左括号
				if (item.isLeftParentheses()) 
					buffer.append(" ( ");
				
				String _queryColumnArg = "_" + item.getField() + String.valueOf(argId);
				
				if (Class.forName(data.getObjectProperty().getObjectClassName()).newInstance() instanceof TreeEntityBase
						&& (item.getField().toUpperCase().equals("ID"))) {
					
					if (((String)this.getAppParameter().getSysPara().get("DBNAME")).toUpperCase().equals("ORACLE")) {
						buffer.append(" (" + item.getField() + "  in (select id from " + data.getObjectProperty().getObjectName() 
								+ " where enabled = 1 start with id = :" + _queryColumnArg + " connect by prior id = highid))");
					}

				} else if (item.getField().toUpperCase().endsWith("DEPID")) {
					if (((String)this.getAppParameter().getSysPara().get("DBNAME")).toUpperCase().equals("ORACLE")) {
						buffer.append(" (" + item.getField() + "  in (select id from department" 
								+ " where enabled = 1 start with id = :" + _queryColumnArg + " connect by prior id = highid))");
					}
				} else {
				// 增加查询字段
					buffer.append(item.getField());
					
					// 增加运算符
					buffer.append(item.getOperator());
					
					// 增加值
					buffer.append(":" + _queryColumnArg);
				}
				
				if (item.getOperator().equals(" like ")) {
					filterArg.put(_queryColumnArg, Utility.likeString((String)item.getValue()));
				} else {
					filterArg.put(_queryColumnArg, item.getValue());
				}
				
				// 增加右括号
				if (item.isRightParentheses())
					buffer.append(" ) ");	
				
				argId++;
			}
			
			data.setFilterArg(filterArg);
			data.setFilterString(buffer.toString());
			data.setRealQueryString("");
						
			this.getWindowData().closeWindow();
		} catch (Exception ex) {
			data.setFilterArg(null);
			data.setFilterString("");
			ex.printStackTrace();
			throw ex;
		}
	}


}
