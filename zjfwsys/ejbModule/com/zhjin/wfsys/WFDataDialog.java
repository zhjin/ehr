/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.wfsys;

import java.util.List;

import javax.faces.model.SelectItem;

public class WFDataDialog {

	private WFInstanceActor actor;
	private WFNodeProperty nodeProperty;
	private WorkflowDefine workflowDefine;
	
	private List<WFInstanceActor> actorHistory;
	
	private List<SelectItem> wfAttachFileList;
	
	private Long currentAttachFile;
	
	private String applyButtonResult;
	private List<SelectItem> applyButtonItems;
	private String applyOpinion;
	
	private String backNodeId;
	private List<SelectItem> backNodeList;
	
	private WFInstanceActor changeInstanceActor;
	
	public List<SelectItem> getWfAttachFileList() {
		return wfAttachFileList;
	}
	public void setWfAttachFileList(List<SelectItem> wfAttachFileList) {
		this.wfAttachFileList = wfAttachFileList;
	}
	public Long getCurrentAttachFile() {
		return currentAttachFile;
	}
	public void setCurrentAttachFile(Long currentAttachFile) {
		this.currentAttachFile = currentAttachFile;
	}
	public String getApplyButtonResult() {
		return applyButtonResult;
	}
	public void setApplyButtonResult(String applyButtonResult) {
		this.applyButtonResult = applyButtonResult;
	}
	public List<SelectItem> getApplyButtonItems() {
		return applyButtonItems;
	}
	public void setApplyButtonItems(List<SelectItem> applyButtonItems) {
		this.applyButtonItems = applyButtonItems;
	}
	public String getApplyOpinion() {
		return applyOpinion;
	}
	public void setApplyOpinion(String applyOpinion) {
		this.applyOpinion = applyOpinion;
	}
	public String getBackNodeId() {
		return backNodeId;
	}
	public void setBackNodeId(String backNodeId) {
		this.backNodeId = backNodeId;
	}
	public List<SelectItem> getBackNodeList() {
		return backNodeList;
	}
	public void setBackNodeList(List<SelectItem> backNodeList) {
		this.backNodeList = backNodeList;
	}
	public WFInstanceActor getActor() {
		return actor;
	}
	public void setActor(WFInstanceActor actor) {
		this.actor = actor;
	}
	public WFNodeProperty getNodeProperty() {
		return nodeProperty;
	}
	public void setNodeProperty(WFNodeProperty nodeProperty) {
		this.nodeProperty = nodeProperty;
	}
	public WorkflowDefine getWorkflowDefine() {
		return workflowDefine;
	}
	public void setWorkflowDefine(WorkflowDefine workflowDefine) {
		this.workflowDefine = workflowDefine;
	}
	public List<WFInstanceActor> getActorHistory() {
		return actorHistory;
	}
	public void setActorHistory(List<WFInstanceActor> actorHistory) {
		this.actorHistory = actorHistory;
	}
	public WFInstanceActor getChangeInstanceActor() {
		return changeInstanceActor;
	}
	public void setChangeInstanceActor(WFInstanceActor changeInstanceActor) {
		this.changeInstanceActor = changeInstanceActor;
	}

}
