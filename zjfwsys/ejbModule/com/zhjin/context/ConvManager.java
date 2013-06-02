/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.context;

import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.zhjin.util.Utility;

public class ConvManager {

	public static String CONV_MAP_NAME = "zhjin_conv_map";
	public static int CONV_TIMEOUT = 30;
	public static String WID_NAME = "wid";
	public static long widCount = 0;
	public static String CURRENTCONVID = "currentConvId";
	
	public static void beginConv() {
		widCount = widCount + 1;
		beginConv(Long.toString(widCount));
	}
	
	public static void updateCurrentConvId(String id) {
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest(); 
		req.setAttribute(CURRENTCONVID, id);
	}
	
	public static void beginConv(String cid) {
		getConvMap().put(cid, new ConversationData());
		updateCurrentConvId(cid);
	}
	
	public static void beginConv(String cid, int timeout) {
		getConvMap().put(cid, new ConversationData(timeout));
		updateCurrentConvId(cid);
	}
		
	public static ConversationData getConv(String cid) {
		
		ConversationData data = getConvMap().get(cid);
		
		if (data == null) {
			data = new ConversationData();
			data.setTimeout(CONV_TIMEOUT);
			getConvMap().put(cid, data);
		}
		
		return data;
		
	}
	
	public static <T> T getConvData(String cid, Class<T> t) {
		ConversationData data = getConv(cid);
		if (t.isAnnotationPresent(Named.class)) {
			return (T)data.getConvData().get(Utility.lowerFirstChar(t.getSimpleName()));
		} else {
			return null;
		}
	}
	
	public static <T> T getConvData(Class<T> t) {
		return getConvData(getCurrentConvId(), t);
	}
	
	public static void setConvData(String cid, Object obj) {
		
		ConversationData data = getConv(cid);
		
		if (obj.getClass().isAnnotationPresent(Named.class)) {
			data.getConvData().put(Utility.lowerFirstChar(obj.getClass().getSimpleName()), obj);
		}
		
	}
	
	public static void setConvData(String cid, Object obj, int timeout) {
		
		ConversationData data = getConv(cid);
		
		if (obj.getClass().isAnnotationPresent(Named.class)) {
			data.getConvData().put(Utility.lowerFirstChar(obj.getClass().getSimpleName()), obj);
		}
		
		data.setTimeout(timeout);
	}
	
	public static void endConv(String cid) {
		getConvMap().remove(cid);
		updateCurrentConvId(null);
	}
	
	public static void endCurrentConv() {
		getConvMap().remove(getCurrentConvId());
	}
	
	public static void setConvTimeOut(String cid, int timeout) {
		getConvMap().get(cid).setTimeout(timeout);
	}
	
	public static void clearConv() {
		
	}
	
	public static String getCurrentConvId() {
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest(); 
		return (String)req.getAttribute(CURRENTCONVID);
	}
	
	public static HashMap<String, ConversationData> getConvMap() {
		
		HashMap<String, ConversationData> _map = (HashMap<String, ConversationData>)Utility.getSessionMap().get(CONV_MAP_NAME);
		
		if (_map == null) {
			_map = new HashMap<String, ConversationData>();			
			Utility.getSessionMap().put(CONV_MAP_NAME, _map);
		} 
		
		return _map;
		
	}
	
	
}
