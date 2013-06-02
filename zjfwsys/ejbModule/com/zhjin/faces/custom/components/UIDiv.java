/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.faces.custom.components;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.zhjin.util.Utility;

@FacesComponent(value = "zhjin.Div")
public class UIDiv extends UIComponentBase {

	@Override
	public String getFamily() {
		return null;
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {

		ResponseWriter writer = context.getResponseWriter();
		writer.write("<div id=\"" + this.getClientId() + "\"");

		String _str = (String)this.getAttributes().get("style");
		if (Utility.notEmptyString(_str)) {
			writer.write(" style=\"" + _str + "\"");
		}

		_str = (String)this.getAttributes().get("styleClass");
		if (Utility.notEmptyString(_str)) {
			writer.write(" class=\"" + _str + "\"");
		}
		writer.write(">");

	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.write("</div>");
	}


}
