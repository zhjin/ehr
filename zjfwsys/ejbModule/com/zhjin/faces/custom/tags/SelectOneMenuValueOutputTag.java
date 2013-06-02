/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.faces.custom.tags;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

import com.zhjin.faces.custom.components.UISelectOneMenuValueOutput;

public class SelectOneMenuValueOutputTag extends UIComponentELTag {
	protected ValueExpression valueList;
	
	public SelectOneMenuValueOutputTag() {
		super();
	}

	public ValueExpression getValueList() {
		return valueList;
	}

	public void setValueList(ValueExpression valueList) {
		this.valueList = valueList;
	}

	@Override
	public String getComponentType() {
		return UISelectOneMenuValueOutput.COMPONENT_TYPE;
	}

	@Override
	public String getRendererType() {
		return UISelectOneMenuValueOutput.RENDERER_TYPE;
	}

	@Override
	public void setProperties(UIComponent arg0) {
		super.setProperties(arg0);
	}
	
	@Override
	public void release() {
		super.release();
		this.valueList = null;
	}

}
