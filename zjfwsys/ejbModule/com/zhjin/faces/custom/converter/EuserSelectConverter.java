/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.faces.custom.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.zhjin.util.EUser;
import com.zhjin.util.EuserSelect;
import com.zhjin.util.Utility;

@FacesConverter("zhjin.EuserSelectConverter")
public class EuserSelectConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (!Utility.notEmptyString(arg2)) {
			return null;
		}
		EuserSelect ret = new EuserSelect();
		try {
			EUser user = Utility.getDBUtility().getEntity(EUser.class, Long.valueOf(arg2));
			if (user != null) {
				ret.setEmpId(user.getId());
				ret.setLoginName(user.getLoginName());
				ret.setName(user.getName());
			}
		} catch (Exception e) {
		}
		return ret;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return String.valueOf(((EuserSelect)arg2).getEmpId());
		} else {
			return null;
		}
	}

}
