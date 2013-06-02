/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import org.primefaces.model.TreeNode;

public class TreeData {

	private String treeName;
	
	private String objectName;

	private long rootId;

	private TreeNode rootNode;

	private TreeNode selectedNode;
	
	private boolean readOnly = false;
	
	private String orientation = "vertical";
	
	private String addNodeEL;
	
	private String deleteNodeEL;
	
	private String updateNodeEL;
	
	private String selectNodeEL;
	
	private String refreshTreeEL;
	
	public long getSelectNodeId() {
		
		if (this.selectedNode != null) {
			return ((TreeNodeData)this.selectedNode.getData()).getId();
		} else {
			return 0;
		}
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public long getRootId() {
		return rootId;
	}

	public void setRootId(long rootId) {
		this.rootId = rootId;
	}

	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getAddNodeEL() {
		return addNodeEL;
	}

	public void setAddNodeEL(String addNodeEL) {
		this.addNodeEL = addNodeEL;
	}

	public String getDeleteNodeEL() {
		return deleteNodeEL;
	}

	public void setDeleteNodeEL(String deleteNodeEL) {
		this.deleteNodeEL = deleteNodeEL;
	}

	public String getSelectNodeEL() {
		return selectNodeEL;
	}

	public void setSelectNodeEL(String selectNodeEL) {
		this.selectNodeEL = selectNodeEL;
	}

	public String getRefreshTreeEL() {
		return refreshTreeEL;
	}

	public void setRefreshTreeEL(String refreshTreeEL) {
		this.refreshTreeEL = refreshTreeEL;
	}

	public String getUpdateNodeEL() {
		return updateNodeEL;
	}

	public void setUpdateNodeEL(String updateNodeEL) {
		this.updateNodeEL = updateNodeEL;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}

}
