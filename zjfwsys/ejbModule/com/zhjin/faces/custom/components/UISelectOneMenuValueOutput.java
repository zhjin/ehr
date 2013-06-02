/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.faces.custom.components;

import java.util.List;
import java.util.TreeMap;

import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class UISelectOneMenuValueOutput extends UIOutput {
	public static final String COMPONENT_TYPE="zhjin.ui.SelectOneMenuValueOutput";
	public static final String RENDERER_TYPE = "zhjin.ui.SelectOneMenuValueOutputRenderer";
	private List<SelectItem> valueList;
	private TreeMap<Object, String> valueTree;

	
	public List<SelectItem> getValueList() {
		return valueList;
	}

	public void setValueList(List<SelectItem> valueList) {
		this.valueList = valueList;
		this.valueTree = new TreeMap<Object, String>();

		for (SelectItem _item : this.valueList) {
			this.valueTree.put(_item.getValue(), (String)_item.getLabel());
		}
	}

	public TreeMap<Object, String> getValueTree() {
		return valueTree;
	}

	public void setValueTree(TreeMap<Object, String> valueTree) {
		this.valueTree = valueTree;
	}

	public UISelectOneMenuValueOutput() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return COMPONENT_TYPE;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void restoreState(FacesContext context, Object state) {
		Object[] values = (Object[])state;
		int i = 0;
		super.restoreState(context, values[i++]);
		valueList = (List<SelectItem>)values[i++];
		valueTree = (TreeMap<Object, String>)values[i++];
	}
	
	@Override
	public Object saveState(FacesContext context) {
		return new Object[]{super.saveState(context), 
				valueList, valueTree};
	}
}
