/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.organize;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.em.ehr.organize.entity.Department;
import com.em.ehr.organize.entity.Job;
import com.zhjin.sys.entity.SysMenu;
import com.zhjin.sys.entity.WindowDefine;
import com.zhjin.sys.manager.ObjectEditData;
import com.zhjin.sys.manager.ObjectEditManager;
import com.zhjin.sys.manager.TableData;
import com.zhjin.sys.manager.TableManager;
import com.zhjin.sys.manager.TreeData;
import com.zhjin.sys.manager.TreeManager;
import com.zhjin.sys.manager.TreeNodeData;
import com.zhjin.sys.window.WindowData;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.EuserSelect;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class DepManager
 */
@Named
@Stateless
@LocalBean
public class DepManager extends BeanBase {
	
	@EJB
	private TreeManager treeManager;
	
	@EJB
	private ObjectEditManager objectEditManager;
	
	@EJB
	private TableManager tableManager;

    /**
     * Default constructor. 
     */
    public DepManager() {
    }

    public void initDepManagerData() throws Exception {

    	WindowData wd = this.getWindowData();
    	// 初始化部门树
    	Department dep = dbUtility.getEntity("select * from Department where id = :depId", 
    			Department.class, 
    			new ArgMap().add("depId", this.getUser().getOperOrgId1()));

    	TreeData treeData = treeManager.initTreeData(WindowData.TREENAME, "Department", dep.getId());
    	treeData.setAddNodeEL("#{depManager.addDepartment}");
    	treeData.setSelectNodeEL("#{depManager.selectDepartment}");
    	treeData.setDeleteNodeEL("#{depManager.deleteDepartment}");
    	wd.setDefaultTreeData(treeData);
    	
    	treeData.getRootNode().getChildren().get(0).setSelected(true);
    	treeData.setSelectedNode(treeData.getRootNode().getChildren().get(0));

    	// 初始化部门属性编辑
    	dep = dbUtility.getEntity(Department.class, treeData.getSelectNodeId());
    	ObjectEditData oed = objectEditManager.initObjectEditData(dep, "", "更新", "", "", "");
    	wd.setDefaultObjectEditData(oed);
    	
    	// 初始化岗位表 
    	long tableId = dbUtility.getEntity(WindowDefine.class, ((SysMenu)wd.getInData()).getWindowId()).getTable1();
    	TableData jobTable = tableManager.initDataTable(wd.getInData(), "table", tableId);
    	wd.setDefaultTableData(jobTable);

    }
    
    public void addDepartment(TreeData treeData, Object obj) throws Exception {
    	
    }
    
    public void selectDepartment(TreeData treeData) throws Exception {
    	Department dep = dbUtility.getEntity(Department.class, treeData.getSelectNodeId());
    	((ObjectEditData)this.getWindowData().getObjMap().get(WindowData.OBJECTNAME)).setEditData(dep);
    	TableData jobTable = (TableData)this.getWindowData().getDefaultTableData();
    	jobTable.setRealQueryString(null);
    	tableManager.goFirst(jobTable);
    	RequestContext requestContext = RequestContext.getCurrentInstance();
    	requestContext.update("depdetailf");
    }
    
    public void deleteDepartment(TreeData treeData) throws Exception {

    }
    
    @Audit
    public void updateDepartment(ActionEvent event) throws Exception {	
    	Department dep = (Department)((ObjectEditData)this.getWindowData().getObjMap().get(WindowData.OBJECTNAME)).getEditData();

    	dep = dbUtility.update(dep);
    	((ObjectEditData)this.getWindowData().getObjMap().get(WindowData.OBJECTNAME)).setEditData(dep);
    	TreeData treeData = (TreeData)this.getWindowData().getObjMap().get("tree");
    	treeManager.refreshTree(treeData);
    }
    
    public Object newJob() throws Exception {
    	TreeData treeData = this.getWindowData().getParentWindowData().getDefaultTreeData();
    	
    	if (treeData.getSelectedNode() == null) {
    		throw new Exception("请先选择部门!");
    	}
    	
    	Job job = new Job();
    	job.setDepId(((TreeNodeData)treeData.getSelectedNode().getData()).getId());
    	return job;	
    }
    
    public List<EuserSelect> managerSelect(String query) {
    	List<EuserSelect> ret = new ArrayList<EuserSelect>();
    	ret = dbUtility.getDataList("select a.id empId, a.loginname, a.name, b.label depName from employeeactiveview a, department b where a.depid = b.id and a.loginname like :loginName", 
    			EuserSelect.class, new ArgMap().add("loginName", Utility.likeString(query)));
    	return ret;
    }
    
}
