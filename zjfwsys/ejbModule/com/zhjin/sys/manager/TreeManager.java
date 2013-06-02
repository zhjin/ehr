/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.zhjin.base.TreeEntityBase;
import com.zhjin.context.ConvManager;
import com.zhjin.sys.entity.ViewObjectProperty;
import com.zhjin.sys.window.WindowData;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.SysUtil;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class TreeManager
 */

@Named
@Stateless
@LocalBean
public class TreeManager extends BeanBase {

	@EJB
	private SysUtil sysUtil;
	
	@EJB
	private ObjectEditManager objectEditManager;

    /**
     * Default constructor.
     */
    public TreeManager() {
    }

    public <T> TreeData initTreeData(String treeName, String objName, long rootId) throws Exception {

    	TreeData data = new TreeData();
    	data.setTreeName(treeName);
    	data.setRootNode(queryTree(objName, rootId));

    	data.setObjectName(objName);
    	data.setRootId(rootId);
    	data.getRootNode().getChildren().get(0).setSelected(true);
    	data.setSelectedNode(data.getRootNode().getChildren().get(0));
    	
    	return data;

    }

    private DefaultTreeNode queryTree(String objName, long rootId) throws Exception {
    	DefaultTreeNode root = null;
    	List<?> obj = dbUtility.getDataList("select id, label from " + objName + " where enabled = 1 and id = :id",
    			new ArgMap().add("id", rootId));
    	if (obj == null || obj.size() == 0) {
    		throw new Exception("Root不存在!");
    	}

    	Object[] _ol = (Object[])obj.get(0);
    	TreeNodeData _nodeData = new TreeNodeData(((BigDecimal)_ol[0]).intValue(), (String)_ol[1]);

    	root = new DefaultTreeNode();
    	root.setData(_nodeData);

    	queryTreeNodeChildren(root, objName);

    	DefaultTreeNode root1 = new DefaultTreeNode();
    	root1.setData(root.getData());
    	root1.getChildren().add(root);
    	root.setParent(root1);

    	if (root.getChildCount() > 0) {
    		root.setExpanded(true);
    	}

    	return root1;
    }

    private void queryTreeNodeChildren(TreeNode node, String objName) throws Exception {

    	List<?> _list = dbUtility.getDataList("select id, label, highid from " + objName + " where enabled = 1 and highid > 0 and id != :id " +
    			" connect by highid = prior id start with id = :id order siblings by indexno, label",
    			new ArgMap().add("id",((TreeNodeData)node.getData()).getId()));
    	
    	Stack<TreeNode> _parentStack = new Stack<TreeNode>();
    	_parentStack.push(node);

    	for (Object _o : _list) {
    		
    		Object[] _ol = (Object[])_o;
    		TreeNodeData _nodeData = new TreeNodeData(((BigDecimal)_ol[0]).intValue(), (String)_ol[1]);
    		int _highId = ((BigDecimal)_ol[2]).intValue();

    		while (!_parentStack.empty() && _highId != ((TreeNodeData)_parentStack.peek().getData()).getId()) {
    			_parentStack.pop();
    		}

    		_nodeData.setLevel(_parentStack.size());
    		DefaultTreeNode _t = new DefaultTreeNode();
    		_t.setData(_nodeData);
    		_t.setParent(_parentStack.peek());
    		_parentStack.peek().getChildren().add(_t);
    		_parentStack.push(_t);
    	}

    }

    public void onTreeNodeExpand(NodeExpandEvent event) throws Exception {
    }

    public void onTreeNodeCollapse(NodeCollapseEvent event) throws Exception {
    	event.getTreeNode().setExpanded(false);
    }

    public void onNodeSelect(NodeSelectEvent event) throws Exception {
    	
    	TreeData data = getCurrentTreeData();
    	
    	if (Utility.notEmptyString(data.getSelectNodeEL())) {
    		Utility.executeMethodExpression(data.getSelectNodeEL(), new Class[]{TreeData.class}, new TreeData[]{data});
    	}
   
    }

    public void onNodeUnselect(NodeUnselectEvent event) throws Exception {

    }

    public void entireTree(TreeNode node) throws Exception {

    	System.out.println(BeanUtils.getProperty(node.getData(), "label"));
    	for (TreeNode _node : node.getChildren()) {
    		entireTree(_node);
    	}

    }

    @Audit
    public void addTreeNode(ActionEvent event) throws Exception {
    	TreeData treeData = getCurrentTreeData();
    	
    	if (treeData.getSelectedNode() == null) {
    		throw new Exception("请选择上级节点!");
    	}
    	
    	WindowData parentWindowData = ConvManager.getConvData(WindowData.class);

		ConvManager.beginConv(ConvManager.getCurrentConvId() + "_" + treeData.getObjectName() + "_newnode");

		WindowData wdata = this.getWindowData();
		wdata.setParentWindowData(parentWindowData);
		wdata.setParentRefreshButton(event.getComponent().findComponent("refreshtree").getClientId());
    	wdata.setInData(treeData);
    	
    	ViewObjectProperty vop = dbUtility.getEntity(ViewObjectProperty.class, treeData.getObjectName());
    	TreeEntityBase obj = (TreeEntityBase)Class.forName(vop.getObjectClassName()).newInstance();
    	obj.setHighId(((TreeNodeData)treeData.getSelectedNode().getData()).getId());
    	ObjectEditData oed = objectEditManager.initObjectEditData(obj, "#{treeManager.addTreeNodeProcess}", "新增", "新增", "", "");
    	
    	wdata.setDefaultObjectEditData(oed);
		wdata.setHasCancelButton(true);
		wdata.setWindowWidth(vop.getEditWidth());
		wdata.setWindowHeight(vop.getEditHeight());
		wdata.setWindowTitle("新增节点 (上级节点：" + ((TreeNodeData)treeData.getSelectedNode().getData()).getLabel() + ")");
		
		Utility.openWindow("/sys/windowoneobject.jsf?" + ConvManager.WID_NAME + "=" + ConvManager.getCurrentConvId(),
				ConvManager.getCurrentConvId(), this.getWindowData().getWindowWidth(), this.getWindowData().getWindowHeight());
		
    }
    
    public void addTreeNodeProcess(Object nodeData) throws Exception {
    	TreeEntityBase data = (TreeEntityBase)dbUtility.update(nodeData, true);
    	TreeData treeData = (TreeData)this.getWindowData().getInData();
    	if (Utility.notEmptyString(treeData.getAddNodeEL())) {
    		Utility.executeMethodExpression(treeData.getAddNodeEL(),  new Class[]{TreeData.class, Object.class}, new Object[]{treeData, data});
    	}
    	this.getWindowData().closeWindow();
    }

    @Audit
    public void deleteTreeNode(ActionEvent event) throws Exception {

    	TreeData data = getCurrentTreeData();
    	if (data.getSelectedNode() == null) {
    		throw new Exception("请选择要删除的节点!");
    	}
    	
    	ViewObjectProperty vop = dbUtility.getEntity(ViewObjectProperty.class, data.getObjectName());
    	Object obj = dbUtility.getEntity(Class.forName(vop.getObjectClassName()), ((TreeNodeData)data.getSelectedNode().getData()).getId());

    	if (obj != null) {
    		
    		if (obj instanceof TreeEntityBase) {
    			if (((TreeEntityBase)obj).getHighId() == 0) {
    				throw new Exception("根节点，不能删除");
    			}
    		}
    		
    		dbUtility.delete(obj, true);
    		
        	if (Utility.notEmptyString(data.getDeleteNodeEL())) {
        		Utility.executeMethodExpression(data.getDeleteNodeEL(),  new Class[]{TreeData.class}, new TreeData[]{data});
        	}
    		
    		this.refreshTree(data);
    		
    	}
    }

    @Audit
    public void refreshTree(ActionEvent event) throws Exception {
    	TreeData data = getCurrentTreeData();
    	refreshTree(data);
    }
    
    public void refreshTree(TreeData data) throws Exception {
    	TreeSet<Long> _expandNodeTree = new TreeSet<Long>();
    	rememberExpandNode(data.getRootNode(), _expandNodeTree);
    	data.setRootNode(queryTree(data.getObjectName(), data.getRootId()));
   		applyExpandNode(data.getRootNode(), _expandNodeTree, data);
    	if (Utility.notEmptyString(data.getRefreshTreeEL())) {
    		Utility.executeMethodExpression(data.getRefreshTreeEL(),  new Class[]{TreeData.class}, new TreeData[]{data});
    	}
    }

    private void rememberExpandNode(TreeNode node, TreeSet<Long> remTree) {
    	if (node.getChildCount() > 0) {
    		if (node.isExpanded()) {
    			remTree.add(((TreeNodeData)node.getData()).getId());
    		}
    		for (TreeNode _node : node.getChildren()) {
    			rememberExpandNode(_node, remTree);
    		}
    	}
    }

    private void applyExpandNode(TreeNode node, TreeSet<Long> remTree, TreeData treeData) {
    	if (treeData.getSelectedNode() != null && ((TreeNodeData)node.getData()).getId() == treeData.getSelectNodeId()) {
    		treeData.setSelectedNode(node);
    		node.setSelected(true);
    	}
    	if (node.getChildCount() > 0) {
    		if (remTree.contains(((TreeNodeData)node.getData()).getId())) {
    			node.setExpanded(true);
    		}
    		for (TreeNode _node : node.getChildren()) {
    			applyExpandNode(_node, remTree, treeData);
    		}
    	}
    }

    @Audit
    public void expanedAllTreeNode(ActionEvent event) throws Exception {
    	TreeData data = getCurrentTreeData();
    	expandAllNode(data.getRootNode());
    }

    private void expandAllNode(TreeNode node) throws Exception {
    	if (node.getChildCount() > 0) {
    		node.setExpanded(true);
    		for (TreeNode _node : node.getChildren()) {
    			expandAllNode(_node);
    		}
    	}
    }

    private TreeData getCurrentTreeData() {
    	String _treeName = (String)UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("treeId");
    	return (TreeData)this.getWindowData().getObjMap().get(_treeName);
    }

}
