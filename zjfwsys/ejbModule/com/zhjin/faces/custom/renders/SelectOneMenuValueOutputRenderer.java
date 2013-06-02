/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.faces.custom.renders;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;
import javax.faces.render.Renderer;

import com.zhjin.faces.custom.components.UISelectOneMenuValueOutput;

public class SelectOneMenuValueOutputRenderer extends Renderer {
	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		super.encodeBegin(context, component);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		UISelectOneMenuValueOutput ui = (UISelectOneMenuValueOutput)component;

		Object value = ui.getValue();
		
		if (ui.getValueTree() == null) {
			
			if (ui.getValueList() == null) {
				ui.setValueList((List<SelectItem>)ui.getValueExpression("valueList").getValue(FacesContext.getCurrentInstance().getELContext()));
			}
			TreeMap<Object, String> _tree = new TreeMap<Object, String>();

			for (SelectItem _item : ui.getValueList()) {
				_tree.put(_item.getValue(), (String)_item.getLabel());
			}
			ui.setValueTree(_tree);

		}
		
		if (value != null) {
			
			ResponseWriter writer = context.getResponseWriter();

			String _s = ui.getValueTree().get(value);
			if (_s != null) {
				writer.write(_s);
			}
			writer.flush();
		}
	}

}
