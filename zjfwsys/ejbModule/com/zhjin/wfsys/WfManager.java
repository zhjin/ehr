/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.wfsys;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.zip.ZipInputStream;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;
import javax.inject.Named;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.ReadOnlyProcessDefinition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.primefaces.model.UploadedFile;

import com.zhjin.base.entity.SysLargeText;
import com.zhjin.context.ConvManager;
import com.zhjin.sys.manager.ObjectEditManager;
import com.zhjin.sys.manager.TableManager;
import com.zhjin.sys.window.WindowData;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.SysUtil;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class WFManager
 */
@Named
@Stateless
@LocalBean
public class WfManager extends BeanBase {

	public static String WFDIALOG_DATA_STRING = "WFObjectData";
	public static String WFDIALOG_CONTROLDATA_STRING = "WFControlData";
	
	@EJB
	private TableManager tableManager;

	@EJB
	private ObjectEditManager objectEditManager;

	@EJB
	private SysUtil sysUtil;

    /**
     * Default constructor.
     */
    public WfManager() {
    }

    public Object getWFData() throws Exception {
    	return null;
    }

    public String saveWFData() throws Exception {
    	return null;
    }

    public void deployWorkflow(UploadedFile wffile, Object obj) throws Exception {

    	RepositoryService rs = WFUtil.processEngine.getRepositoryService();

    	Deployment deploy = rs.createDeployment().addZipInputStream(new ZipInputStream(wffile.getInputstream())).deploy();

    	WorkflowDefine wfd = (WorkflowDefine)obj;

    	ProcessDefinition pdf = rs.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();

    	InputStream imageInputStream = rs.getResourceAsStream(pdf.getDeploymentId(), pdf.getDiagramResourceName());
    	BufferedImage image = ImageIO.read(imageInputStream);
    	wfd.setImageWidth(image.getWidth());
    	wfd.setImageHeight(image.getHeight());
    	imageInputStream.close();

    	wfd.setWfKey(pdf.getKey());
    	wfd.setWfName(pdf.getName());
    	wfd.setDeployId(deploy.getId());
    	wfd.setDefineId(pdf.getId());

    	// 初始化流程节点
		try {

			ReadOnlyProcessDefinition procDef = ((RepositoryServiceImpl)rs).getDeployedProcessDefinition(pdf.getId());

			HashMap<String, Object> arg = new HashMap<String, Object>();
			StringBuffer _str = new StringBuffer();
			_str.append("(' '");

			int _nodeIndexNo = 0;

			for (PvmActivity act : procDef.getActivities()) {
				arg.clear();
				arg.put("wfId", wfd.getId());
				String _nodeName = (String)((ActivityImpl)act).getProperty("name");
				String _nodeId = ((ActivityImpl)act).getId();
				arg.put("nodeId", _nodeId);

				WFNodeProperty _node = dbUtility.getEntity("select * from wfnodeproperty where wfId = :wfId and nodeid = :nodeId",
						WFNodeProperty.class, arg);
				if (_node == null) {
					_node = new WFNodeProperty();
					_node.setWfId(wfd.getId());
					_node.setNodeName(_nodeName);
					_node.setNodeId(_nodeId);
					//_node.setNodeType(act.getType());

					if (_nodeName.equalsIgnoreCase("end")) {
						_node.setIndexNo(100000);
					} else {
						_nodeIndexNo = _nodeIndexNo + 10;
						_node.setIndexNo(_nodeIndexNo);
					}

				} else {
					_nodeIndexNo = _node.getIndexNo();
				}

				dbUtility.update(_node);
				_str.append(", '" + _nodeId + "'");
			}
			_str.append(")");
			dbUtility.executeUpdate("delete wfnodeproperty where wfid = " + Long.toString(wfd.getId()) + " and nodeid not in " + _str.toString(),
					new HashMap<String, Object>());

		} catch (Exception ex) {
			throw ex;
		} finally {
	    	if (wffile.getInputstream() != null) {
	    		wffile.getInputstream().close();
	    	}
	    }

    	dbUtility.update(wfd);

    }

    public void initWorkflowImage(Object obj) throws Exception {

    	WorkflowDefine wfd = dbUtility.getEntity(WorkflowDefine.class, ((WorkflowDefine)obj).getId());
    	this.getWindowData().getObjMap().put("workflowdefid", wfd.getDefineId());
    	Utility.openWindow("/workflow/workflowimage.jsf?wid=" + ConvManager.getCurrentConvId(), "workflowimageview", wfd.getImageWidth() - 3, wfd.getImageHeight() - 3);

    }

    public void cancelWFInstance(Object obj) throws Exception {

    	WFInstance instance = (WFInstance)obj;
    	ProcessInstance processInstance = WFUtil.processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(instance.getWfInstanceId()).singleResult();

    	if (processInstance != null && !processInstance.isEnded()) {

    		WFUtil.processEngine.getRuntimeService().deleteProcessInstance(instance.getWfInstanceId(), "管理员终止!");

    	}

    	if (!instance.isFinish()) {
    		instance.setEndStatus("管理员终止!");
    		instance.setEndTime(new Date());
    		instance.setFinish(true);
    		dbUtility.update(instance, true);

    		WFInstanceActor actor = new WFInstanceActor();
    		actor.setActorEmpId(this.getUser().getUserId());
    		actor.setActorLoginName(this.getUser().getLoginName());
    		actor.setActorName(this.getUser().getName());
    		actor.setBeginTime(new Date());
    		actor.setEndTime(new Date());
    		actor.setRealActorEmpId(this.getUser().getUserId());
    		actor.setRealActorLoginName(this.getUser().getLoginName());
    		actor.setRealActorName(this.getUser().getName());
    		actor.setWfInstanceId(instance.getWfInstanceId());
    		actor.setNodeId("终止");
    		actor.setNodeName("终止");
    		dbUtility.save(actor, true);

    		tableManager.tablefreshbuttonclick();
    	}

    	instanceFinishToHistory(instance);

    }

    private void instanceFinishToHistory(WFInstance instance) throws Exception {

    	dbUtility.executeUpdate("insert into wfinstancehistory select * from wfinstance where wfinstanceid = :instanceId", new ArgMap().add("instanceId", instance.getWfInstanceId()));
    	dbUtility.executeUpdate("insert into wfinstanceactorhistory select * from wfinstanceactor where wfinstanceid = :instanceId", new ArgMap().add("instanceId", instance.getWfInstanceId()));
    	dbUtility.executeUpdate("delete wfinstance where wfinstanceid = :instanceId", new ArgMap().add("instanceId", instance.getWfInstanceId()));
    	dbUtility.executeUpdate("delete wfinstanceactor where wfinstanceid = :instanceId", new ArgMap().add("instanceId", instance.getWfInstanceId()));

    }

    public void initWFInstanceImage(WindowData parentWindowData, Object obj, WindowData windowData) throws Exception {

    	windowData.setInData(obj);
    	WFInstance wfInstance = (WFInstance)obj;
    	WorkflowDefine wfd = dbUtility.getEntity(WorkflowDefine.class, wfInstance.getWfId());
    	windowData.getObjMap().put("workflowdefid", wfInstance.getWfDefineId());

    	ProcessInstance processInstance = WFUtil.processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(wfInstance.getWfInstanceId()).singleResult();

    	// 流程图
    	if (processInstance != null && !processInstance.isEnded()) {

    		ProcessDefinitionEntity def = (ProcessDefinitionEntity)((RepositoryServiceImpl)WFUtil.processEngine.getRepositoryService()).getDeployedProcessDefinition(wfd.getDefineId());



	    	TreeSet<String> _actNodeSet = new TreeSet<String>();
	    	for (String _nn : WFUtil.processEngine.getRuntimeService().getActiveActivityIds(wfInstance.getWfInstanceId())) {
	    		_actNodeSet.add(_nn);
	    	}

	    	List<ActivityImpl> actNode = new ArrayList<ActivityImpl>();

	    	List<ActivityImpl> activitiList = def.getActivities();
	    	for (ActivityImpl act : activitiList) {
	    		if (_actNodeSet.contains(act.getId())) {
	    			actNode.add(act);
	    		}
	    	}
	    	windowData.getObjMap().put("actNode", actNode);
	    	windowData.getObjMap().put("changeActor", true);

    	} else {

    		windowData.getObjMap().put("actNode", new ArrayList<ActivityImpl>());
    		windowData.getObjMap().put("changeActor", false);

    	}

    }
    
    public void newWorkFlow(String wfKey, WFDataBase wfData, List<Integer> fileIdList, int empId) throws Exception {

    	if (wfData != null) {
    		wfData.validData();
    	}

    	WorkflowDefine wfd = dbUtility.getEntity("select * from workflowdefine where wfKey = :wfKey", WorkflowDefine.class, new ArgMap().add("wfKey", wfKey));

    	RuntimeService runtime = WFUtil.processEngine.getRuntimeService();

    	ProcessInstance processInstance = runtime.startProcessInstanceByKey(wfd.getWfKey());

    	WFInstance instance = new WFInstance();
    	instance.setBeginTime(new Date());
    	instance.setEnabled(true);
    	instance.setFinish(false);
    	instance.setWfId(wfd.getId());
    	instance.setWfInstanceId(processInstance.getId());
    	instance.setWfName(wfd.getWfName());
    	instance.setWfNameCN(wfd.getWfNameCN());
    	instance.setWfDefineId(wfd.getDefineId());

    	WFInstanceActor actor = new WFInstanceActor();
    	actor.setActorEmpId(empId);
    	actor.setRealActorEmpId(empId);
    	actor.setBeginTime(new Date());
    	actor.setEndTime(actor.getBeginTime());
    	actor.setNodeId("start");
    	actor.setNodeName("开始");
    	actor.setApplyResult("申请");
    	actor.setWfInstanceId(processInstance.getId());
    	dbUtility.save(actor, true);

    	if (wfData != null) {
    		wfData.validData();
    		wfData.saveData();
    	}

    	instance.setDataId(wfData.getDataId());
    	initActivityNode(processInstance, empId, "");

    	dbUtility.save(instance);

    }

    private void initActivityNode(ProcessInstance processInstance, int preEmpId, String preNodeId) throws Exception {

    	RuntimeService runtime = WFUtil.processEngine.getRuntimeService();

    	ProcessDefinition processDefine = WFUtil.processEngine.getRepositoryService().createProcessDefinitionQuery().processDefinitionId(processInstance.getProcessDefinitionId()).singleResult();

    	WorkflowDefine wfd = dbUtility.getEntity("select * from workflowdefine where wfkey = :wfKey", WorkflowDefine.class, new ArgMap().add("wfKey", processDefine.getKey()));

    	for (String _nn : runtime.getActiveActivityIds(processInstance.getId())) {

    		WFInstanceActor actor = dbUtility.getEntity("select * from wfinstanceactor where wfInstanceId = :wfInstanceId and nodeId = :nodeId and endtime is not null ",
    				WFInstanceActor.class, new ArgMap().add("wfInstanceId", processInstance.getProcessInstanceId()).add("nodeId", _nn));

    		if (actor == null) {

    			actor = new WFInstanceActor();
    			actor.setWfInstanceId(processInstance.getProcessInstanceId());
    			actor.setNodeId(_nn);
    			actor.setNodeName(dbUtility.getEntity("select * from wfnodeproperty where wfId = :wfId and nodeId = :nodeId",
    					WFNodeProperty.class, new ArgMap().add("wfId", wfd.getId()).add("nodeId", _nn)).getNodeName());
    			actor.setBeginTime(new Date());
    			actor.setPreEmpId(preEmpId);

    			dbUtility.save(actor);

    		}

    	}

    }

    public void testWrokFlow(Object obj) throws Exception {
    	newWorkFlow(((WorkflowDefine)obj).getWfKey(), (WFDataBase)Class.forName(((WorkflowDefine)obj).getObjectName()).newInstance(), new ArrayList<Integer>(), 100);
    }
    
    

    @Audit
    public void changeActor(ActionEvent event) throws Exception {

    	WFInstanceActor actor = ((WFDataDialog)this.getWindowData().getObjMap().get("WFControlData")).getChangeInstanceActor();
    	if (actor == null) {
    		throw new Exception("请选择要修改审批人的节点!");
    	}

    	if (actor.getRealActorEmpId() > 0) {
    		Utility.showAlertMessage("已完成节点不能修改审批人!");
    	} else {
    		Utility.executeJavaScript("actorDialog.show();");
    	}

    }

    @Audit
    public void refreshActor(ActionEvent event) throws Exception {

    	WFInstance wfInstance = (WFInstance)this.getWindowData().getInData();
    	List<WFInstanceActor> _actorList = dbUtility.getDataList("select * from (select * from wfinstanceactor where wfinstanceid = :instanceId " +
    			"union select * from wfinstanceactorhistory where wfinstanceid = :instanceId) a order by begintime", WFInstanceActor.class,
    			new ArgMap().add("instanceId", wfInstance.getWfInstanceId()));
    	this.getWindowData().getObjMap().put("actorList", _actorList);

    }

    public void initApplyWFDialogData(WindowData parentWindowData, Object obj, WindowData windowData) throws Exception {

    	WFInstance instance = (WFInstance)obj;

    	// 未实现流程代理人审批, 增加功能时修改
    	List<WFInstanceActor> actorList = dbUtility.getDataList("select * from wfinstanceactor where endtime is null and realactorempid = 0 and wfinstanceid = :wfinstanceid and actorempid = :actorEmpId",
    			WFInstanceActor.class, new ArgMap().add("wfinstanceid", instance.getWfInstanceId()).add("actorEmpId", this.getUser().getUserId()));

    	WFInstanceActor actor = null;
    	if (actorList.size() > 0) {
    		actor = actorList.get(0);
    	}

    	if (instance.getReqEmpId() == this.getUser().getUserId() || actor == null) {
    		initWFData(instance, "startevent1", instance.getDataId(), true);
    	} else {
    		initWFData(instance, actor.getNodeId(), instance.getDataId(), false);
    	}

    }

    public void initWFData(WFInstance instance, String nodeId, long dataId, boolean readOnly) throws Exception {

    	WorkflowDefine wfd = dbUtility.getEntity(WorkflowDefine.class, instance.getWfId());
    	WFDataBase wfData = (WFDataBase)Class.forName(wfd.getVariableObjectName()).newInstance();

    	if (wfData.getClass() == WFObjectData.class) {
    		((WFObjectData)wfData).setObjectName(wfd.getObjectName());
    	}

    	wfData.setWfInstanceId(instance.getWfInstanceId());
    	wfData.setNodeId(nodeId);
    	wfData.loadData(dataId);

    	if (wfData instanceof WFObjectData) {
    		initWFObjectDialogComponent(wfData);
    	}

    }

    private void initWFObjectDialogComponent(WFDataBase data) throws Exception {
    	WFObjectData wfData = (WFObjectData)data;
       	WFNodeProperty nodeProperty = dbUtility.getEntity("select * from wfnodeproperty where wfid = :wfId and nodeid = :nodeId",
       			WFNodeProperty.class,
       			new ArgMap().add("wfId", dbUtility.getEntity(WFInstance.class, wfData.getWfInstanceId()).getWfId())
       			.add("nodeId", wfData.getNodeId()));
       	objectEditManager.initObjectEditData(wfData.getObjectData(), wfData.getObjectData().getEditData(), "", "", "Title",
       			nodeProperty.getReadOnlyColumns(), nodeProperty.getHideColumns());
       	this.getWindowData().getObjMap().put("WFObjectData", wfData);
    }

    /**
     * 打开流程实例初始化方法
     * @param parentWindowData
     * @param obj
     * @param windowData
     * @throws Exception
     */
    public void initWorkflowDialog(WindowData parentWindowData, Object obj, WindowData windowData) throws Exception {

    	windowData.setInData(obj);
    	WFInstance instance = (WFInstance)obj;
    	WorkflowDefine wfd = dbUtility.getEntity(WorkflowDefine.class, instance.getWfId());
    	WFDataDialog controlData = new WFDataDialog();
    	controlData.setWorkflowDefine(wfd);

    	WFDataBase wfData = (WFDataBase)Class.forName(wfd.getVariableObjectName()).newInstance();

    	windowData.getObjMap().put(WFDIALOG_DATA_STRING, Class.forName(wfd.getVariableObjectName()).newInstance());

    	initApplyWFDialogData(parentWindowData, obj, windowData);
    	initWFInstanceImage(parentWindowData, obj, windowData);

    	// 已批复意见

    	// 流程附件

    	// 审核结果按钮
    	List<SelectItem> applyButtonItems = new ArrayList<SelectItem>();
    	applyButtonItems.add(Utility.getSelectItem("同意", "ACCEPT"));
    	applyButtonItems.add(Utility.getSelectItem("拒绝", "DENY"));
    	applyButtonItems.add(Utility.getSelectItem("驳回", "ROLLBACK"));
    	applyButtonItems.add(Utility.getSelectItem("审阅", "REVIEW"));
    	controlData.setApplyButtonItems(applyButtonItems);

    	// 审批明细
    	List<WFInstanceActor> _actorList = dbUtility.getDataList("select * from (select * from wfinstanceactor where wfinstanceid = :instanceId " +
    			"union select * from wfinstanceactorhistory where wfinstanceid = :instanceId) a order by begintime", WFInstanceActor.class,
    			new ArgMap().add("instanceId", instance.getWfInstanceId()));
    	controlData.setActorHistory(_actorList);

    	// 驳回明细
    	List<SelectItem> rollbackList = new ArrayList<SelectItem>();
    	for (WFInstanceActor act : _actorList) {
    		if (act.getEndTime() != null) {
    			boolean _rollbacknodeExist = false;
    			for (SelectItem a1 : rollbackList) {
    				if (act.getNodeId().equals((String)a1.getValue())) {
    					_rollbacknodeExist = true;
    					break;
    				}
    			}
    			if (!_rollbacknodeExist) {
    				rollbackList.add(Utility.getSelectItem(act.getNodeName(), act.getNodeId()));
    			}
    		}
    	}
    	controlData.setBackNodeList(rollbackList);
    	controlData.setBackNodeId("");

    	// 流程数据
    	windowData.setWindowTitle(wfd.getWfNameCN() + " : " + instance.getWfInstanceId());
    	windowData.setWindowWidth(wfd.getImageWidth() + 3);
    	windowData.setWindowHeight(wfd.getImageHeight() + 32);

    	SysLargeText slt = dbUtility.getEntity(SysLargeText.class, wfd.getDataShow());
    	if (slt.getId() == 0) {
    		windowData.setCustomId(0);
    	} else {
    		windowData.setCustomId(slt.getId());
    		windowData.setCustomVersion(slt.getVersion());
    	}

    	// 流程附件下拉列表

    	windowData.getObjMap().put(WFDIALOG_CONTROLDATA_STRING, controlData);

    	Utility.openWindow("/workflow/wfinstanceimage.jsf?wid=" + ConvManager.getCurrentConvId(), "workflowinstanceimageview",
    			windowData.getWindowWidth(), windowData.getWindowHeight());

    }

    public void openWFDataContent(WindowData parentWindowData, Object obj, WindowData windowData) throws Exception {
    	WorkflowDefine wfd = (WorkflowDefine)obj;
    	SysLargeText slt = null;
    	if (wfd.getDataShow() == 0) {
    		slt = new SysLargeText();
    	} else {
    		slt = dbUtility.getEntity(SysLargeText.class, wfd.getDataShow());
    	}
    	windowData.getObjMap().put("datashow", slt);
    	windowData.setHasCancelButton(true);
    }

    @Audit
    public void saveWFDataContent(ActionEvent event) throws Exception {
    	WorkflowDefine wfd = (WorkflowDefine)this.getWindowData().getInData();
    	SysLargeText slt = (SysLargeText)this.getWindowData().getObjMap().get("datashow");
		slt = dbUtility.update(slt, true);
    	if (wfd.getDataShow() == 0) {
    		wfd.setDataShow(slt.getId());
    		dbUtility.update(wfd);
    	}
    	this.getWindowData().closeWindow();
    }

}
