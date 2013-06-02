/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.TabChangeEvent;

import com.em.ehr.attend.entity.AttendStatus;
import com.em.ehr.benefit.entity.AccuStatus;
import com.em.ehr.benefit.entity.BenefitStatus;
import com.em.ehr.human.entity.BargainTypeCode;
import com.em.ehr.human.entity.EmpStatusCode;
import com.em.ehr.human.entity.EmpTypeCode;
import com.em.ehr.human.entity.Employee;
import com.em.ehr.human.entity.EmployeeBargainArg;
import com.em.ehr.human.entity.EmployeeChangeArg;
import com.em.ehr.human.entity.EmployeeChangeNormalArg;
import com.em.ehr.human.entity.EmployeeInfo;
import com.em.ehr.human.entity.EmployeeInternChangeNormalArg;
import com.em.ehr.human.entity.EmployeeJoinArg;
import com.em.ehr.human.entity.EmployeeLeaveArg;
import com.em.ehr.human.entity.EmployeePhoto;
import com.em.ehr.human.entity.EmployeeReJoinArg;
import com.em.ehr.human.entity.person.EmployeePersonBaseEntity;
import com.em.ehr.human.entity.person.EmployeePersonList;
import com.em.ehr.salary.entity.SalaryStatus;
import com.zhjin.base.entity.OperateDataBase;
import com.zhjin.sys.entity.ViewObjectFieldProperty;
import com.zhjin.sys.manager.ObjectEditData;
import com.zhjin.sys.manager.ObjectEditManager;
import com.zhjin.sys.manager.TableData;
import com.zhjin.sys.manager.TableManager;
import com.zhjin.sys.manager.TreeManager;
import com.zhjin.sys.window.WindowData;
import com.zhjin.util.ArgMap;
import com.zhjin.util.BeanBase;
import com.zhjin.util.EUser;
import com.zhjin.util.EuserSelect;
import com.zhjin.util.SysUtil;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class EmployeeManager
 */
@Named
@Stateless
@LocalBean
public class EmployeeManager extends BeanBase {
	
	@EJB
	private TreeManager treeManager;
	
	@EJB
	private ObjectEditManager objectEditManager;
	
	@EJB
	private TableManager tableManager;
	
	@EJB
	private SysUtil sysUtil;
    
	/**
     * Default constructor. 
     */
    public EmployeeManager() {

    }
    
    // ----------------------- 新员工入职开始 -----------------------------------------------------------
    public void addNewEmployeeProcess(Object obj) throws Exception {
    	EmployeeJoinArg arg = (EmployeeJoinArg)obj;
    	if (arg.getGuideEmpId() > 0) {
    		EUser guideEmp = dbUtility.getEntity(EUser.class, arg.getGuideEmpId());
    		arg.setGuideName(guideEmp.getName());
    		arg.setGuideLoginName(guideEmp.getLoginName());
    	}
    	dbUtility.update(arg);
    	
    	EUser user = new EUser();
    	user.setLoginName(arg.getLoginName());
    	user.setName(arg.getName());
    	user.setForceChangePass(true);
    	user.setRegisterDate(new Date());
    	user.setPassword(Utility.encoderPassword(arg.getLoginName(), arg.getEmpCode().substring(arg.getEmpCode().length() - 6)));
    	user = dbUtility.update(user);
    	
    	Employee emp = new Employee();
    	emp.setId(user.getId());
    	emp.setArea(arg.getArea());
    	emp.setBeginDate(arg.getJoinDate());
    	emp.setChangeNormalDate(arg.getChangeNormalDate());
    	emp.setCompany(arg.getCompany());
    	emp.setCountry(arg.getCountry());
    	emp.setDepId(arg.getDepId());
    	emp.setEmpStatus(arg.getEmpStatus());
    	emp.setEmpType(arg.getEmpType());
    	emp.setGuideEmpId(arg.getGuideEmpId());
    	emp.setGuideLoginName(arg.getGuideLoginName());
    	emp.setGuideName(arg.getGuideName());
    	emp.setJobId(arg.getJobId());
    	emp.setLoginName(arg.getLoginName());
    	emp.setName(arg.getName());
    	emp.setPosition(arg.getPosition());
    	emp.setPositionLevel(arg.getPositionLevel());
    	emp.setPositionType(arg.getPositionType());
    	emp.setProbationNumber(arg.getProbationNumber());
    	dbUtility.save(emp);
    	
    	EmployeeInfo info = new EmployeeInfo();
    	info.setEmpId(user.getId());
    	info.setSex(arg.getSex());
    	info.setCode(arg.getEmpCode());
    	dbUtility.save(info);
    	
    	EmployeePhoto photo = new EmployeePhoto();
    	photo.setEmpId(user.getId());
    	dbUtility.update(photo);
    	
    	AccuStatus accu = new AccuStatus();
    	accu.setEmpId(user.getId());
    	dbUtility.update(accu);
    	
    	BenefitStatus benefit = new BenefitStatus();
    	benefit.setEmpId(user.getId());
    	dbUtility.update(benefit);
    	
    	AttendStatus attend = new AttendStatus();
    	attend.setEmpId(user.getId());
    	dbUtility.update(attend);
    	
    	SalaryStatus salary = new SalaryStatus();
    	salary.setEmpId(user.getId());
    	salary.setPayDepId(emp.getDepId());
    	salary.setPayCity(emp.getArea());
    	salary.setPayCountry(emp.getCountry());
    	salary.setPayJobId(emp.getJobId());
    	salary.setPayPosition(emp.getPosition());
    	salary.setPayPositionLevel(emp.getPositionLevel());
    	dbUtility.update(salary);
    	
    	this.getWindowData().closeWindow();
    	
    }
    
    /**
     * 判断入职员工身份证号码是否已存在
     * @param event
     * @throws Exception
     */
    public void codeValueChangeListener(ValueChangeEvent event) throws Exception {
    	EmployeeJoinArg arg = (EmployeeJoinArg)(this.getWindowData().getDefaultObjectEditData()).getEditData();
    	if (arg.getEmpCode() != null && dbUtility.exists("select * from employeeinfo where code is not null and code = :code", 
    			new ArgMap().add("code", arg.getEmpCode()))) {
    		throw new Exception ("身份证号码重复,请您检查后重新输入!");
    	}
    }
    
    public List<EuserSelect> guideSelect(String query) {
    	List<EuserSelect> ret = new ArrayList<EuserSelect>();
    	ret = dbUtility.getDataList("select a.id empId, a.loginname, a.name, b.label depName from employee a," +
    			" (select * from department where enabled = 1 start with id = :operId connect by prior id = highid) b where a.depid = b.id and a.loginname like :loginName", 
    			EuserSelect.class, new ArgMap().add("operId", this.getUser().getOperOrgId1()).add("loginName", Utility.likeString(query)), 1, 8);
    	return ret;
    }
    
    public void calcEmployeeChangeNormalDate(ValueChangeEvent event) throws Exception {
    	EmployeeJoinArg arg = (EmployeeJoinArg)((ObjectEditData)this.getWindowData().getDefaultObjectEditData()).getEditData();
    	if (arg.getProbationNumber() == 0) {
    		arg.setChangeNormalDate(arg.getJoinDate());
    	} else {
    		arg.setChangeNormalDate(Utility.addDay(Utility.addMonth(arg.getJoinDate(), arg.getProbationNumber()), 1));
    	}
    }
    
    public void loginValueChangeListener(ValueChangeEvent event) throws Exception {
    	EmployeeJoinArg arg = (EmployeeJoinArg)((ObjectEditData)this.getWindowData().getDefaultObjectEditData()).getEditData();
    	if (arg.getLoginName() != null && dbUtility.exists("select * from euser where loginName = :loginName", 
    			new ArgMap().add("loginName", arg.getLoginName()))) {
    		throw new Exception ("登录名重复,请重新输入!");
    	}
    }
    
    public void empStatusValueChangeListener(ValueChangeEvent event) throws Exception {	
    	ObjectEditData oed = (ObjectEditData)this.getWindowData().getDefaultObjectEditData();
    	EmployeeJoinArg arg = (EmployeeJoinArg)oed.getEditData();
    	if (arg.getEmpStatus() > 0) {
    		EmpStatusCode status = dbUtility.getEntity(EmpStatusCode.class, arg.getEmpStatus());
    		if ("NORM".equals(status.getStrId())) {
    			// 正常
    			arg.setProbationNumber(0);
    			arg.setChangeNormalDate(arg.getJoinDate());
    			oed.getViewObjectFieldProperty("probationNumber").setRunReadOnly(true);
    		} else if ("PROB".equals(status.getStrId())) {
    			// 试用
    			oed.getViewObjectFieldProperty("probationNumber").setRunReadOnly(false);
    			calcEmployeeChangeNormalDate(event);
    		}
    	}
    }
    
    /**
     * 新员工入职初始化
     * @param pdata
     * @param inData
     * @return
     * @throws Exception
     */
    public Object newEmployeeJoinArg(Object inData) throws Exception {
    	EmployeeJoinArg arg = new EmployeeJoinArg();
    	EmpStatusCode status = dbUtility.getEntity("select * from empstatuscode where strid = 'PROB'", 
    			EmpStatusCode.class, null);
    	arg.setEmpStatus(status.getId());	
    	return arg;
    }

    /**
     * 新员工入职打开窗口前处理
     * @param pwdata
     * @param inData
     * @param wdata
     * @throws Exception
     */
    public void openEmployeeJoinWindow() throws Exception {
    	ObjectEditData oed = (ObjectEditData)this.getWindowData().getDefaultObjectEditData();
    	oed.getEditMenuList().put("empStatus", 
    			sysUtil.getSelectItemList("select id, label from empstatuscode where strid in ('NORM', 'PROB')", null));
    }
    
    public void depChangeValueListener(ValueChangeEvent event) throws Exception {
    	queryJobList("jobId", ((EmployeeJoinArg)(this.getWindowData().getDefaultObjectEditData().getEditData())).getDepId());
    }
     
    // ----------------------- 新员工入职结束 -----------------------------------------------------------
    
    // ----------------------- 试用期转正开始 -----------------------------------------------------------
    public Object newEmployeeChangeNormalArg(Object inData) throws Exception {
    	EmployeeView emp = (EmployeeView)inData;
    	if (!"PROB".equals(dbUtility.getEntity(EmpStatusCode.class, emp.getEmpStatus()).getStrId())) {
    		throw new Exception(emp.getName() + "不是试用期员工,不能操作!");
    	}
    	EmployeeChangeNormalArg arg = new EmployeeChangeNormalArg();
    	this.initOperateDataBase(arg, emp);
    	arg.setJoinDate(emp.getBeginDate());
    	arg.setProbationNumber(emp.getProbationNumber());
    	arg.setChangeNormalDate(emp.getChangeNormalDate());
    	arg.setEmpStatus(emp.getEmpStatus());
    	arg.setEmpType(emp.getEmpType());
    	return arg;
    }
    
    public void addEmployeeChangeNormalProcess(Object obj) throws Exception {
    	EmployeeChangeNormalArg arg = (EmployeeChangeNormalArg)obj;
    	dbUtility.update(arg);
    	Employee emp = dbUtility.getEntity(Employee.class, arg.getEmpId());
    	emp.setProbationNumber(arg.getProbationNumber());
    	emp.setChangeNormalDate(arg.getChangeNormalDate());
    	emp.setEmpStatus(dbUtility.getEntity("select * from empstatuscode where strid = 'NORM'", EmpStatusCode.class, null).getId());
    	dbUtility.update(emp);
    	this.getWindowData().closeWindow();
    }
    // ----------------------- 试用期转正结束 -----------------------------------------------------------
    
    // ----------------------- 实习生转正开始 -----------------------------------------------------------
    public Object newEmployeeInternChangeNormalArg(Object inData) throws Exception {
    	EmployeeView emp = (EmployeeView)inData;
    	if ("NORM".equals(dbUtility.getEntity(EmpTypeCode.class, emp.getEmpType()).getStrId())) {
    		throw new Exception(emp.getName() + "是正式员工,不能操作!");
    	}
    	EmployeeInternChangeNormalArg arg = new EmployeeInternChangeNormalArg();
    	this.initOperateDataBase(arg, emp);
    	arg.setChangeNormalDate(emp.getChangeNormalDate());
    	arg.setEmpStatus(emp.getEmpStatus());
    	arg.setEmpType(emp.getEmpType());
    	arg.setJobId(emp.getJobId());
    	arg.setJoinDate(emp.getBeginDate());
    	return arg;
    }
    
    public void addEmployeeInternChangeNormalProcess(Object obj) throws Exception {
    	EmployeeInternChangeNormalArg arg = (EmployeeInternChangeNormalArg)obj;
    	dbUtility.update(arg);
    	
    	Employee emp = dbUtility.getEntity(Employee.class, arg.getEmpId());
    	emp.setEmpType(dbUtility.getEntity("select * from emptypecode where strid = 'NORM'", EmpTypeCode.class, null).getId());
    	dbUtility.update(emp);
    	this.getWindowData().closeWindow();
    }
    // ----------------------- 实习生转正结束 -----------------------------------------------------------
    
    // ----------------------- 员工变动开始 -----------------------------------------------------------
    public Object newEmployeeChangeArg(Object inData) throws Exception {
    	EmployeeView emp = (EmployeeView)inData;
    	EmployeeChangeArg arg = new EmployeeChangeArg();
    	this.initOperateDataBase(arg, emp);
    	
    	arg.setOldJobId(emp.getJobId());
    	arg.setNewJobId(emp.getJobId());
    	arg.setOldArea(emp.getArea());
    	arg.setNewArea(emp.getArea());
    	arg.setOldCompany(emp.getCompany());
    	arg.setNewCompany(emp.getCompany());
    	arg.setOldCountry(emp.getCountry());
    	arg.setNewCountry(emp.getCountry());
    	arg.setOldDepId(emp.getDepId());
    	arg.setNewDepId(emp.getDepId());
    	arg.setOldPosition(emp.getPosition());
    	arg.setNewPosition(emp.getPosition());
    	arg.setOldPositionLevel(emp.getPositionLevel());
    	arg.setNewPositionLevel(emp.getPositionLevel());
    	arg.setOldPositionType(emp.getPositionType());
    	arg.setNewPositionType(emp.getPositionType());
    	arg.setNewEmpType(emp.getEmpType());
    	return arg;
    }
    
    public void addEmployeeChangeProcess(Object obj) throws Exception {
    	EmployeeChangeArg arg = (EmployeeChangeArg)obj;
    	dbUtility.update(arg);
    	
    	Employee emp = dbUtility.getEntity(Employee.class, arg.getEmpId());
    	emp.setJobId(arg.getNewJobId());
    	emp.setArea(arg.getNewArea());
    	emp.setCompany(arg.getNewCompany());
    	emp.setCountry(arg.getNewCountry());
    	emp.setDepId(arg.getNewDepId());
    	emp.setPosition(arg.getNewPosition());
    	emp.setPositionLevel(arg.getNewPositionLevel());
    	emp.setPositionType(arg.getNewPositionType());
    	dbUtility.update(emp);
    	
    	this.getWindowData().closeWindow();
    }
    
    public void newDepChangeValueListener(ValueChangeEvent event) throws Exception {
    	queryJobList("newJobId", ((EmployeeChangeArg)(this.getWindowData().getDefaultObjectEditData().getEditData())).getNewDepId());
    }
    
    // ----------------------- 员工变动结束 -----------------------------------------------------------
    
    // ----------------------- 合同办理开始 -----------------------------------------------------------
    public Object newEmployeeBargainArg(Object inData) throws Exception {
    	EmployeeView emp = (EmployeeView)inData;
    	EmployeeBargainArg arg = new EmployeeBargainArg();
    	this.initOperateDataBase(arg, emp);
    	
    	arg.setBargainType(emp.getBargainType());
    	arg.setCompany(emp.getBargainCompany());
    	arg.setEmpStatus(emp.getEmpStatus());
    	arg.setEmpType(emp.getEmpType());
    	arg.setJobId(emp.getJobId());
    	arg.setJoinDate(emp.getBeginDate());
    	arg.setOldBargainType(emp.getBargainType());
    	arg.setOldBeginDate(emp.getBargainBeginDate());
    	arg.setOldCompany(emp.getBargainCompany());
    	arg.setOldEndDate(emp.getBargainEndDate());
    	return arg;
    }
    
    public void addEmployeeBargainProcess(Object obj) throws Exception {
    	EmployeeBargainArg arg = (EmployeeBargainArg)obj;
    	dbUtility.update(arg);
    	
    	Employee emp = dbUtility.getEntity(Employee.class, arg.getEmpId());
    	emp.setBargainBeginDate(arg.getBeginDate());
    	emp.setBargainCompany(arg.getCompany());
    	emp.setBargainEndDate(arg.getEndDate());
    	emp.setBargainType(arg.getBargainType());
    	dbUtility.update(emp);
    	this.getWindowData().closeWindow();
    }
    
    public void bargainTypeValueChangeListener(ValueChangeEvent event) throws Exception {	
    	ObjectEditData oed = (ObjectEditData)this.getWindowData().getDefaultObjectEditData();
    	EmployeeBargainArg arg = (EmployeeBargainArg)oed.getEditData();
    	if (arg.getBargainType() > 0) {
    		BargainTypeCode status = dbUtility.getEntity(BargainTypeCode.class, arg.getBargainType());
    		if ("NOLI".equals(status.getStrId())) {
    			// 无固定期限劳动合同
    			arg.setEndDate(null);
    			oed.getViewObjectFieldProperty("endDate").setRunReadOnly(true);
    		} else {
    			// 非无固定期限劳动合同
    			oed.getViewObjectFieldProperty("endDate").setRunReadOnly(false);
    		}
    	}
    }
    
    public void openBargainWindow() throws Exception {
    	EmployeeBargainArg arg = (EmployeeBargainArg)this.getWindowData().getDefaultObjectEditData().getEditData();
    	List<EmployeeBargainArg> history = dbUtility.getDataList("select * from employeebargainarg where empid = :empId order by begindate desc", 
    			EmployeeBargainArg.class, new ArgMap().add("empId", arg.getEmpId()));
    	this.getWindowData().getObjMap().put("bargainHistory", history);
    	this.getWindowData().getObjMap().put("historyCount", history.size());
    	DataTable historyTable = tableManager.initDataTable("historyTable", "EmployeeBargainArg", 
    			"", 
    			"joinDate empstatus emptype depid jobid oldbargaintype loginname bargainstoptype oldbegindate oldcompany oldenddate remark opertime");
    	
    	historyTable.setValue(history);
    	this.getWindowData().getObjMap().put("historyTable", historyTable);
    }
    
    // ----------------------- 合同办理结束 -----------------------------------------------------------
    
    // ----------------------- 员工离职开始 -----------------------------------------------------------
    public Object newEmployeeLeaveArg(Object inData) throws Exception {
    	EmployeeView emp = (EmployeeView)inData;
    	EmployeeLeaveArg arg = new EmployeeLeaveArg();
    	this.initOperateDataBase(arg, emp);
    	
    	arg.setCompany(emp.getCompany());
    	arg.setEmpStatus(emp.getEmpStatus());
    	arg.setEmpType(emp.getEmpType());
    	arg.setJobId(emp.getJobId());
    	arg.setJoinDate(emp.getBeginDate());

    	return arg;
    }  
    
    public void addEmployeeLeaveProcess(Object obj) throws Exception {
    	EmployeeLeaveArg arg = (EmployeeLeaveArg)obj;
    	dbUtility.update(arg);
    	
    	
    	Employee emp = dbUtility.getEntity(Employee.class, arg.getEmpId());
    	EmpStatusCode leaveCode = dbUtility.getEntity("select * from empstatuscode where strid = 'LEAV'", 
    			EmpStatusCode.class, null);
    	emp.setLeaveDate(arg.getLeaveDate());
    	emp.setEmpStatus(leaveCode.getId());
    	this.getWindowData().closeWindow();
    }
    // ----------------------- 员工离职结束 -----------------------------------------------------------
    
    // ----------------------- 员工复职开始 -----------------------------------------------------------
    public Object newEmployeeReJoinArg(Object inData) throws Exception {
    	EmployeeView emp = (EmployeeView)inData;
    	EmployeeReJoinArg arg = new EmployeeReJoinArg();
    	this.initOperateDataBase(arg, emp);
    	
    	arg.setDepId(0);
    	
    	return arg;
    }
    
    public void addEmployeeReJoinProcess(Object obj) throws Exception {
    	EmployeeReJoinArg arg = (EmployeeReJoinArg)obj;
    	dbUtility.update(arg);
    	
    	EUser user = dbUtility.getEntity(EUser.class, arg.getEmpId());
    	EmployeeInfo info = dbUtility.getEntity(EmployeeInfo.class, arg.getEmpId());
    	user.setForceChangePass(true);
    	if (Utility.notEmptyString(info.getCode()) && info.getCode().length() >= 6 ) {
    		user.setPassword(Utility.encoderPassword(arg.getLoginName(), info.getCode().substring(info.getCode().length() - 6)));
    	}
    	user = dbUtility.update(user);
    	
    	Employee emp = dbUtility.getEntity(Employee.class, arg.getEmpId());
    	emp.setArea(arg.getArea());
    	emp.setBeginDate(arg.getJoinDate());
    	emp.setChangeNormalDate(arg.getChangeNormalDate());
    	emp.setCompany(arg.getCompany());
    	emp.setCountry(arg.getCountry());
    	emp.setDepId(arg.getDepId());
    	emp.setEmpStatus(arg.getEmpStatus());
    	emp.setEmpType(arg.getEmpType());
    	emp.setGuideEmpId(arg.getGuideEmpId());
    	emp.setGuideLoginName(arg.getGuideLoginName());
    	emp.setGuideName(arg.getGuideName());
    	emp.setJobId(arg.getJobId());
    	emp.setPosition(arg.getPosition());
    	emp.setPositionLevel(arg.getPositionLevel());
    	emp.setPositionType(arg.getPositionType());
    	emp.setProbationNumber(arg.getProbationNumber());
    	emp.setLeaveDate(null);
    	
    	dbUtility.update(emp);

    	this.getWindowData().closeWindow();    	
    }
    
    public void openEmployeeReJoinWindow() throws Exception {
    	ObjectEditData oed = (ObjectEditData)this.getWindowData().getDefaultObjectEditData();
    	oed.getEditMenuList().put("empStatus", 
    			sysUtil.getSelectItemList("select id, label from empstatuscode where strid in ('NORM', 'PROB')", null));
    }
    
    public void calcEmployeeChangeNormalDate_EmployeeReJoin(ValueChangeEvent event) throws Exception {
    	EmployeeReJoinArg arg = (EmployeeReJoinArg)((ObjectEditData)this.getWindowData().getDefaultObjectEditData()).getEditData();
    	if (arg.getProbationNumber() == 0) {
    		arg.setChangeNormalDate(arg.getJoinDate());
    	} else {
    		arg.setChangeNormalDate(Utility.addDay(Utility.addMonth(arg.getJoinDate(), arg.getProbationNumber()), 1));
    	}
    }
    
    public void empStatusValueChangeListener_EmployeeReJoin(ValueChangeEvent event) throws Exception {	
    	ObjectEditData oed = (ObjectEditData)this.getWindowData().getDefaultObjectEditData();
    	EmployeeReJoinArg arg = (EmployeeReJoinArg)oed.getEditData();
    	if (arg.getEmpStatus() > 0) {
    		EmpStatusCode status = dbUtility.getEntity(EmpStatusCode.class, arg.getEmpStatus());
    		if ("NORM".equals(status.getStrId())) {
    			// 正常
    			arg.setProbationNumber(0);
    			arg.setChangeNormalDate(arg.getJoinDate());
    			oed.getViewObjectFieldProperty("probationNumber").setRunReadOnly(true);
    		} else if ("PROB".equals(status.getStrId())) {
    			// 试用
    			oed.getViewObjectFieldProperty("probationNumber").setRunReadOnly(false);
    			calcEmployeeChangeNormalDate_EmployeeReJoin(event);
    		}
    	}
    }
    
    public void depChangeValueListener_EmployeeReJoin(ValueChangeEvent event) throws Exception {
    	queryJobList("jobId", ((EmployeeReJoinArg)(this.getWindowData().getDefaultObjectEditData().getEditData())).getDepId());
    }
    
    // ----------------------- 员工复职结束 -----------------------------------------------------------
    
    // ----------------------- 员工背景信息开始 -----------------------------------------------------------
    
    public void openEmployeeInfoWindow() throws Exception {
    	WindowData wData = this.getWindowData();
    	EmployeeView view = (EmployeeView)wData.getInData();
    	EmployeeInfo info = dbUtility.getEntity(EmployeeInfo.class, view.getEmpId());
    	ObjectEditData viewData = objectEditManager.initObjectEditData(view, "", "", "员工信息", "", 
    			"changeNormalDate leaveDate country area bargainCompany bargainType bargainBeginDate bargainEndDate " +
    			"sex birthday code degree education polity nation beginWorkTime homePlace residence speciality specialityPosition " +
    			"specialityPositionLevel graduateSchool graduateSpeciality");
    	for (ViewObjectFieldProperty field : viewData.getFieldList()) {
    		field.setRunReadOnly(true);
    	}
    	ObjectEditData infoData = objectEditManager.initObjectEditData(info, "", "更新背景信息", "背景信息", "", "");
    	wData.setDefaultObjectEditData(infoData);
    	wData.getObjMap().put("viewData", viewData);
    	
    	EmployeePhoto photo = dbUtility.getEntity(EmployeePhoto.class, view.getEmpId());
    	wData.getObjMap().put("photo", photo.getFileId());
    	
    	// 背景信息栏目明细
    	List<EmployeePersonList> _tabList = dbUtility.getDataList("select * from EmployeePersonList order by indexno", 
    			EmployeePersonList.class, null);
    	
    	wData.getObjMap().put("personList", _tabList);
    	for (EmployeePersonList pList : _tabList) {
    		if (pList.getTableId() > 0) {
    			wData.getObjMap().put(pList.getObjectName(), tableManager.initDataTable(this.getWindowData().getInData(), 
    					pList.getObjectName(), pList.getTableId()));
    		} else {
    			wData.getObjMap().put(pList.getObjectName(), new TableData());
    		}
    	}
    	
    }
    
    public void uploadEmployeePhoto(FileUploadEvent event) throws Exception {
    	EmployeeView view = (EmployeeView)this.getWindowData().getInData();
    	EmployeePhoto photo = dbUtility.getEntity(EmployeePhoto.class, view.getEmpId());
    	long fileId = sysUtil.uploadFile(photo.getFileId(), "/employeephoto", event.getFile());
    	if (fileId != photo.getFileId()) {
    		photo.setFileId(fileId);
    		dbUtility.update(photo);
    		this.getWindowData().getObjMap().put("photo", photo.getFileId());
    	}
    }
    
    public void onEmployeeInfoTabChange(TabChangeEvent event) throws Exception {
//    	TabView tv = (TabView)event.getComponent();
//    	List<EmployeePersonList> _tabList = (List<EmployeePersonList>)windowData.getObjMap().get("personList");
//    	if (tv.getActiveIndex() > 0 && _tabList.get(tv.getActiveIndex() - 1).getTableId() > 0) {
//    		TableData td = tableManager.initDataTable(windowData.getInData(), WindowData.TABLENAME, _tabList.get(tv.getActiveIndex() - 1).getTableId());
//    		windowData.setDefaultTableData(td);	
//    	} else {
//    		windowData.setDefaultTableData(new TableData());
//    	}
    }
    
    public void saveEmployeePeasonItem(Object obj) throws Exception {
    	EmployeePersonBaseEntity entity = (EmployeePersonBaseEntity)obj;
    	if (entity.getEmpId() == 0) {
    		entity.setEmpId(((EmployeeView)this.getWindowData().getParentWindowData().getInData()).getEmpId());
    	}
    	dbUtility.update(entity);
    }
    
    // ----------------------- 员工背景信息结束 -----------------------------------------------------------
        
    private void initOperateDataBase(OperateDataBase odb, EmployeeView emp) {
    	odb.setDepId(emp.getDepId());
    	odb.setEmpId(emp.getEmpId());
    	odb.setLoginName(emp.getLoginName());
    	odb.setName(emp.getName());
    }
    
    private void queryJobList(String jobFieldName, long depId) {
    	this.getWindowData().getDefaultObjectEditData().getEditMenuList().put(jobFieldName, 
    			sysUtil.getSelectItemList("select a.id, lpad('　', (level-1) * 2, '　')||a.label " +
    					"from job a, department b where a.depid = b.id and a.enabled = 1 start with (a.depid = :depId and a.highid not in (select id from job where depid = :depId))" +
    					"connect by prior a.id = a.highid order siblings by b.indexno, a.indexno, a.label", 
    					new ArgMap().add("depId", depId), true));

    }
    
}
