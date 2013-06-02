/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.context;

import java.lang.annotation.Annotation;

import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.faces.context.FacesContext;
import com.zhjin.util.User;

public class ConvContext implements Context {
	
	public static String ZHJIN_CONV_NAME = "zhjin_conv";

	@Override
	public <T> T get(Contextual<T> arg0) {
		
		return null;
		
	}

	@Override
	public <T> T get(Contextual<T> arg0, CreationalContext<T> arg1) {
		
		ConversationData _data = null;
		
		Bean<T> bean = (Bean<T>)arg0;

		String _name = bean.getName();
		
		if ( _name == null ) {
			_name = bean.getBeanClass().getSimpleName();
		}
		
		String _wid = ConvManager.getCurrentConvId();
		
		
		if (_wid == null) {
			return null;
		}
		
		_data = ConvManager.getConv(_wid);
		_data.setLastTime(System.currentTimeMillis());
		
		if (_data.getConvData().get(_name) != null) {
			
			return (T)_data.getConvData().get(_name);
			
		} else {
			T t = bean.create(arg1);
			
			_data.getConvData().put(_name,  t);
			
			return t;
		}

	}

	@Override
	public Class<? extends Annotation> getScope() {
		return ConvScoped.class;
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
