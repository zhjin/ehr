/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.context;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ConversationData implements Serializable {

	private Map<String, Object> convData;
	
	private Long lastTime;
	
	private int timeout;

	public ConversationData() {
		super();
		this.convData = new HashMap<String, Object>();
		lastTime = System.currentTimeMillis();
		this.timeout = ConvManager.CONV_TIMEOUT;
	}
	
	public ConversationData(int timeout) {
		super();
		this.convData = new HashMap<String, Object>();
		lastTime = System.currentTimeMillis();
		this.timeout = timeout;
	}

	public Map<String, Object> getConvData() {
		return convData;
	}

	public void setConvData(Map<String, Object> convData) {
		this.convData = convData;
	}

	public Long getLastTime() {
		return lastTime;
	}

	public void setLastTime(Long lastTime) {
		this.lastTime = lastTime;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
}
