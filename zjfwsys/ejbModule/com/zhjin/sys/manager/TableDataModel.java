/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import java.util.List;

import javax.faces.model.ListDataModel;
import com.zhjin.base.DataTableImpl;

import org.primefaces.model.SelectableDataModel;

public class TableDataModel extends ListDataModel<Object> implements SelectableDataModel<Object> {

	
	public TableDataModel() {
	}

	public TableDataModel(List<Object> list) {
		super(list);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getRowData(String arg0) {

		List<Object> ds = (List<Object>)this.getWrappedData();
		
		for (Object en : ds) {
			if (arg0.equals(((DataTableImpl)en).getRowKey().replaceAll("_", "."))) {
				return en;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(Object arg0) {
		return ((DataTableImpl)arg0).getRowKey().replaceAll("_", ".");
	}

}
