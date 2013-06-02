/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.wfsys;

/**
 * 流程数据基类
 * @author zhjin
 */
public abstract class WFDataBase {

	private String wfInstanceId;

	private String nodeId;

	private String url;

	private long attachmentId;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWfInstanceId() {
		return wfInstanceId;
	}

	public void setWfInstanceId(String wfInstanceId) {
		this.wfInstanceId = wfInstanceId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String nextTransaction(String nodeName) {return null;}

	public String toHtml() { return "";}

	public void validData() throws Exception {}

	public abstract void initWFDataComponent() throws Exception;

	public abstract void initData(Object obj) throws Exception;

	public abstract void loadData(long dataId) throws Exception;

	public abstract long getDataId();

	public abstract void saveData() throws Exception;

	public abstract void dataProcess() throws Exception;

}
