/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.window;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.zhjin.base.entity.SysLargeText;
import com.zhjin.context.ConvManager;
import com.zhjin.sys.entity.ObjectEditDefine;
import com.zhjin.sys.entity.SysMenu;
import com.zhjin.sys.entity.TableDefine;
import com.zhjin.sys.entity.TreeDefine;
import com.zhjin.sys.entity.ViewObjectProperty;
import com.zhjin.sys.entity.WindowCommandDefine;
import com.zhjin.sys.entity.WindowDefine;
import com.zhjin.sys.manager.ObjectEditData;
import com.zhjin.sys.manager.ObjectEditManager;
import com.zhjin.sys.manager.TableData;
import com.zhjin.sys.manager.TableManager;
import com.zhjin.sys.manager.TreeData;
import com.zhjin.sys.manager.TreeManager;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.SysUtil;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class WindowManager
 */
@Named
@Stateless
@LocalBean
public class WindowManager extends BeanBase {

	@EJB
	private ObjectEditManager objectEditManager;

	@EJB
	private TableManager tableManager;
	
	@EJB
	private TreeManager treeManager;

	@EJB
	private SysUtil sysUtil;

    public WindowManager() {
    }

    public void openNewWindow(String convName, Object inData, long windowDefineId, String beforeWindowEL, boolean newWindow, String parentButtonId, boolean readOnly) throws Exception {
    	WindowDefine wd = dbUtility.getEntity(WindowDefine.class, windowDefineId);
    	openNewWindow(convName, inData, wd, beforeWindowEL, newWindow, parentButtonId, 20, readOnly);
    }

    public void openNewWindow(String convName, Object inData, long windowDefineId, String beforeWindowEL, boolean newWindow, String parentButtonId, int timeout, boolean readOnly) throws Exception {
    	WindowDefine wd = dbUtility.getEntity(WindowDefine.class, windowDefineId);
    	openNewWindow(convName, inData, wd, beforeWindowEL, newWindow, parentButtonId, timeout, readOnly);
    }

    public void openNewWindow(String convName, Object inData, WindowDefine wd, String beforeWindowEL, boolean newWindow, String parentButtonId, int timeout, boolean readOnly) throws Exception {

    	boolean inNewConv = false;
    	if (wd == null) {
    		throw new Exception("指定窗口不存在!");
    	}
    	
    	try {
	    	WindowData _data = null;
	    	if (Utility.notEmptyString(convName)) {
	    		WindowData parentWindowData = ConvManager.getConvData(WindowData.class);
	    		ConvManager.beginConv(convName, timeout);
	    		inNewConv = true;
	    		_data = this.getWindowData();
	    		_data.setNewConv(true);
	    		_data.setParentWindowData(parentWindowData);
	    		_data.setInData(inData);
	    		_data.setParentRefreshButton(parentButtonId);
	    	}
	    	
	    	if (_data == null) {
	    		_data = this.getWindowData();
	    	}
	    	
	    	_data.setConvName(ConvManager.getCurrentConvId());
	    	_data.setReadOnly(readOnly);
	
	    	_data.setBeforeOpenEL(wd.getBeforeOpenEL());
	    	_data.setConvName(ConvManager.getCurrentConvId());
	    	_data.setInitWindowEL(wd.getInitWindowEL());
	
	    	if (Utility.notEmptyString(beforeWindowEL)) {
	    		Utility.executeMethodExpression(beforeWindowEL, new Class[]{},	new Object[]{});
	    	}
	    	
	    	if (Utility.notEmptyString(_data.getInitWindowEL())) {
	    		Utility.executeMethodExpression(_data.getInitWindowEL(), new Class[]{},	new Object[]{});
	    	}
	
	    	_data.setWindowHeight(wd.getWindowHeight());
	    	_data.setWindowTitle((String)Utility.getELValue(wd.getWindowTitle()));
	    	_data.setWindowWidth(wd.getWindowWidth());
	
	    	if (Utility.notEmptyString(wd.getWindowURL())) {
	    		_data.setWindowURL(wd.getWindowURL());
	    	}
	
	    	if ("WINDOW_ONE_TABLE".equals(wd.getWindowType())) {
	
	    		// 表格窗口
	    		_data.setDefaultTableData(tableManager.initDataTable(inData, WindowData.TABLENAME, wd.getTable1()));
	    		_data.setWindowURL("/sys/windowonetable.jsf");
	
	    	} else if ("WINDOW_MASTER_DETAIL_TABLE".equals(wd.getWindowType())) {
	
	    	} else if ("WINDOW_ONE_OPERATEOBJECT".equals(wd.getWindowType())) {
	
	    		ObjectEditDefine _oed = dbUtility.getEntity(ObjectEditDefine.class, wd.getDialog1());
	
	    		if (_oed == null) {
	    			throw new Exception("编辑对象不存在!");
	    		}
	
	    		Object _objectEditData = null;
	    		if (Utility.notEmptyString(_oed.getInitEditEL())) {
	    			_objectEditData = Utility.executeMethodExpression(_oed.getInitEditEL(), new Class[]{Object.class},
	        						new Object[]{inData});
	    		} else if (Utility.notEmptyString(_oed.getObjectName())) {
	    			_objectEditData = Class.forName(dbUtility.getEntity(ViewObjectProperty.class, _oed.getObjectName()).getObjectClassName()).newInstance();
	    		} else {
	    			throw new Exception("未定义对象初始化方法!");
	    		}
	
	    		_data.setDefaultObjectEditData(objectEditManager.initObjectEditData(_objectEditData, wd.getDialog1()));
	    		
	    		if (_data.getWindowWidth() == 0 || _data.getWindowHeight() == 0) {
	    			ViewObjectProperty _vop = dbUtility.getEntity(ViewObjectProperty.class, _objectEditData.getClass().getSimpleName());
	    			_data.setWindowWidth(_vop.getEditWidth());
	    			_data.setWindowHeight(_vop.getEditHeight());
	    		}
	        	if (!Utility.notEmptyString(wd.getWindowURL())) {
	        		_data.setWindowURL("/sys/windowoneobject.jsf");
	        	}
	
	    	} else if ("WINDOW_TREE_TABLE".equals(wd.getWindowType())) {
	
	    		// 树，表格窗口
	    		TreeDefine _tree = dbUtility.getEntity(TreeDefine.class, wd.getTree1());
	    		if (_tree == null) {
	    			throw new Exception("树未定义!");
	    		}
	    		
	        	TreeData treeData = treeManager.initTreeData(WindowData.TREENAME, _tree.getObjectName(), (Long)Utility.getELValue(_tree.getRootIdEL()));
	        	treeData.setAddNodeEL(_tree.getAddNodeEL());
	        	treeData.setUpdateNodeEL(_tree.getUpdateNodeEL());
	        	treeData.setDeleteNodeEL(_tree.getDeleteNodeEL());
	        	treeData.setReadOnly(_tree.isReadOnly());
	        	if (Utility.notEmptyString(_tree.getSelectNodeEL())) {
	        		treeData.setSelectNodeEL(_tree.getSelectNodeEL());
	        	} else {
	        		treeData.setSelectNodeEL("#{windowManager.treeNodeSelect_WindowTreeTable}");
	        	}
	        	_data.setDefaultTreeData(treeData);
	        	
	        	// 表格
	    		_data.setDefaultTableData(tableManager.initDataTable(inData, WindowData.TABLENAME, wd.getTable1()));
	    		
	        	_data.setWindowURL("/sys/windowtreetable.jsf");
	        	
	    	} else if ("WINDOW_OBJECT_TABLE".equals(wd.getWindowType())) {
	
	    		// 对象，表格窗口
	    	} else if ("CUSTOM_WINDOW".equals(wd.getWindowType())) {
	
	    		if (!Utility.notEmptyString(_data.getWindowURL()) && wd.getCustomId() > 0) {
	    			SysLargeText _lt = dbUtility.getEntity(SysLargeText.class, wd.getCustomId());
	    			_data.setCustomId(_lt.getId());
	    			_data.setCustomVersion(_lt.getVersion());
	    			_data.setWindowURL("/sys/custom.jsf");
	    		}
	    	}
	
	    	if (!Utility.notEmptyString(_data.getWindowURL())) {
	    		throw new Exception("窗口链接未定义!");
	    	}
	
	    	// 显示窗口前处理
	    	if (Utility.notEmptyString(_data.getBeforeOpenEL())) {
	    		Utility.executeMethodExpression(_data.getBeforeOpenEL(), new Class[]{},	new Object[]{});
	    	}
	
	    	if (newWindow) {
		    	Utility.openWindow(_data.getWindowURL() + "?" + ConvManager.WID_NAME + "=" + ConvManager.getCurrentConvId(),
		    		ConvManager.getCurrentConvId(), _data.getWindowWidth(), _data.getWindowHeight());
	    	}
    	} catch(Exception ex) {
    		System.out.println(ConvManager.getCurrentConvId());
    		if (inNewConv) {
    			ConvManager.endCurrentConv();
    		}
    		throw ex;
    	}

    }


	/**
	 * 取消窗口操作（新建和更新窗口取消按钮点击触发
	 * @param event
	 * @throws Exception
	 */
	@Audit
	public void cancelEditClick(ActionEvent event) throws Exception {
		WindowData wdata = this.getWindowData();
		wdata.setParentWindowData(null);
		wdata.setInData(null);
		Utility.executeJavaScript("window.close();");
		if (wdata.isNewConv()) {
			ConvManager.endCurrentConv();
		}
	}


	/**
	 * 初始化窗口定义 - 系统菜单
	 * @param parentWindowData
	 * @param inData
	 * @param wdata
	 */
	public void initSysMenuWindowDefine() throws Exception {

		// 窗口对象属性
		WindowData wdata = this.getWindowData();
		WindowDefine _wd = null;

		SysMenu _menu = (SysMenu)wdata.getInData();

		if (dbUtility.getRecordCount("select count(*) from sysmenu where enabled = 1 and highid = :id",
				new ArgMap().add("id", _menu.getId())) > 0) {
			throw new Exception(_menu.getLabel() + " : 存在下级菜单，不能进行窗口定义!");
		}

		if (_menu.getWindowId() > 0) {
			_wd = dbUtility.getEntity(WindowDefine.class, _menu.getWindowId());
		}

		if (_wd == null) {
			_wd = new WindowDefine();
		}

		initWindowDefine(wdata, _wd);

	}

	/**
	 * 初始化命令按钮窗口定义 - 系统菜单
	 * @param parentWindowData
	 * @param inData
	 * @param wdata
	 */
	public void initCommandWindowDefine() throws Exception {

		// 窗口对象属性
		WindowData wdata = this.getWindowData();
		WindowDefine _wd = null;

		WindowCommandDefine _command = (WindowCommandDefine)wdata.getInData();

		if (_command.getWindowId() > 0) {
			_wd = dbUtility.getEntity(WindowDefine.class, _command.getWindowId());
		}

		if (_wd == null) {
			_wd = new WindowDefine();
		}

		initWindowDefine(wdata, _wd);

	}

	private void initWindowDefine(WindowData wdata, WindowDefine _wd) throws Exception {

		ObjectEditData _wd_oed = new ObjectEditData();

		objectEditManager.initObjectEditData(_wd_oed, _wd, "", "", "窗口属性", "", "");

		wdata.getObjMap().put("WindowDefine", _wd_oed);

		// 主表格定义
		TableDefine _td_master = null;
		if (_wd.getTable1() > 0) {
			_td_master = dbUtility.getEntity(TableDefine.class, _wd.getTable1());
		}

		if (_td_master == null) {
			_td_master = new TableDefine();
		}

		ObjectEditData _td_master_oed = new ObjectEditData();
		objectEditManager.initObjectEditData(_td_master_oed, _td_master, "", "", "主表格属性", "", "");
		wdata.getObjMap().put("MasterTable", _td_master_oed);

		// 从表格定义
		TableDefine _td_detail = null;
		if (_wd.getTable2() > 0) {
			_td_detail = dbUtility.getEntity(TableDefine.class, _wd.getTable1());
		}
		if (_td_detail == null) {
			_td_detail = new TableDefine();
		}

		ObjectEditData _td_detail_oed = new ObjectEditData();
		objectEditManager.initObjectEditData(_td_detail_oed, _td_detail, "", "", "从表格属性", "", "");
		wdata.getObjMap().put("DetailTable", _td_detail_oed);

		// 树定义
		ObjectEditData _tree_oed = new ObjectEditData();
		TreeDefine _treeDefine = null;
		if (_wd.getTree1() > 0) {
			_treeDefine = dbUtility.getEntity(TreeDefine.class, _wd.getTree1());
		} else {
			_treeDefine = new TreeDefine();
		}
		objectEditManager.initObjectEditData(_tree_oed, _treeDefine, "", "", "树属性", "", "");
		wdata.getObjMap().put("tree", _tree_oed);
		
		// 对象定义
		ObjectEditDefine _oed = null;
		ObjectEditData _wd_objedit = new ObjectEditData();

		if (_wd.getDialog1() > 0) {
			_oed = dbUtility.getEntity(ObjectEditDefine.class, _wd.getDialog1());
		}

		if (_oed == null) {
			_oed = new ObjectEditDefine();
		}
		objectEditManager.initObjectEditData(_wd_objedit, _oed, "", "对象属性", "", _oed.getReadOnlyColumns(), _oed.getHideColumns());
		wdata.getObjMap().put("objectEditDefine", _wd_objedit);

		// 定制页面
		SysLargeText lt = null;
		if (_wd.getCustomId() > 0) {
			lt = dbUtility.getEntity(SysLargeText.class, _wd.getCustomId());
		} else {
			lt = new SysLargeText();
		}
		wdata.getObjMap().put("CustomPageText", lt);

	}

	@Audit
	public void saveWindowDefine(ActionEvent event) throws Exception {

		WindowDefine _wd = (WindowDefine)(((ObjectEditData)this.getWindowData().getObjMap().get("WindowDefine")).getEditData());
		TableDefine _df = null;
		ObjectEditDefine _oed = null;

    	if ("WINDOW_ONE_TABLE".equals(_wd.getWindowType())) {

    		_df = (TableDefine)(((ObjectEditData)this.getWindowData().getObjMap().get("MasterTable")).getEditData());
    		_df = dbUtility.update(_df, true);
    		_wd.setTable1(_df.getId());

    	} else if ("WINDOW_MASTER_DETAIL_TABLE".equals(_wd.getWindowType())) {

    		_df = (TableDefine)(((ObjectEditData)this.getWindowData().getObjMap().get("MasterTable")).getEditData());
    		_df = dbUtility.update(_df, true);
    		_wd.setTable1(_df.getId());
    		_df = (TableDefine)(((ObjectEditData)this.getWindowData().getObjMap().get("DetailTable")).getEditData());
    		_df = dbUtility.update(_df, true);
    		_wd.setTable2(_df.getId());

    	} else if ("WINDOW_ONE_OPERATEOBJECT".equals(_wd.getWindowType())) {
    		ObjectEditData _wd_objedit = (ObjectEditData)this.getWindowData().getObjMap().get("objectEditDefine");
    		ObjectEditDefine oed = (ObjectEditDefine)dbUtility.update(_wd_objedit.getEditData(), true);
    		_wd.setDialog1(oed.getId());
    	} else if ("WINDOW_TREE_TABLE".equals(_wd.getWindowType())) {

    		// 树，表格窗口
    		TreeDefine _treeDefine = (TreeDefine)dbUtility.update(((ObjectEditData)this.getWindowData().getObjMap().get("tree")).getEditData(), true);
    		_wd.setTree1(_treeDefine.getId());
    		_df = (TableDefine)(((ObjectEditData)this.getWindowData().getObjMap().get("MasterTable")).getEditData());
    		_df = dbUtility.update(_df, true);
    		_wd.setTable1(_df.getId());
    	} else if ("WINDOW_OBJECT_TABLE".equals(_wd.getWindowType())) {

    		// 对象，表格窗口
    		_oed = (ObjectEditDefine)(((ObjectEditData)this.getWindowData().getObjMap().get("ObjectEditDefine")).getEditData());
    		_oed = dbUtility.update(_oed, true);
    		_wd.setDialog1(_oed.getId());

    	} else if ("CUSTOM_WINDOW".equals(_wd.getWindowType())) {

    	}

		SysLargeText lt = (SysLargeText)this.getWindowData().getObjMap().get("CustomPageText");
		if (Utility.notEmptyString(lt.getTextContent())) {
			lt = dbUtility.update(lt, true);
			_wd.setCustomId(lt.getId());
		}

		_wd = dbUtility.update(_wd);

		if (this.getWindowData().getInData() instanceof SysMenu) {

			SysMenu _menu = (SysMenu)this.getWindowData().getInData();
			if (_menu.getWindowId() != _wd.getId()) {
				_menu.setWindowId(_wd.getId());
				dbUtility.update(_menu);
			}

		} else if (this.getWindowData().getInData() instanceof WindowCommandDefine) {

			WindowCommandDefine _comm = (WindowCommandDefine)this.getWindowData().getInData();
			if (_comm.getWindowId() != _wd.getId()) {
				_comm.setWindowId(_wd.getId());
				dbUtility.update(_comm);
			}

		}

		this.getWindowData().closeWindow();

	}

	@Audit
	public void initMasterTableCommand(ActionEvent event) throws Exception {

		TableDefine _df = (TableDefine)(((ObjectEditData)this.getWindowData().getObjMap().get("MasterTable")).getEditData());
		if (_df.getId() == 0) {
			throw new Exception("请先保存主表格定义!");
		}

		WindowDefine _wf = dbUtility.getEntity("select * from windowdefine where windowsysname = 'SYS_WINDOW_COMMANDDEFINE'", WindowDefine.class, null);
		openNewWindow(ConvManager.getCurrentConvId() + "_MasterTableCommand", _df, _wf.getId(), null, true, "", this.getWindowData().isReadOnly());

	}

	@Audit
	public void initCustomComponent(ActionEvent event) throws Exception {

	}

	@Audit
	public void initDetailTableCommand(ActionEvent event) throws Exception {

		TableDefine _df = (TableDefine)(((ObjectEditData)this.getWindowData().getObjMap().get("DetailTable")).getEditData());
		if (_df.getId() == 0) {
			throw new Exception("请先保存从表格定义!");
		}

		WindowDefine _wf = dbUtility.getEntity("select * from windowdefine where windowsysname = 'SYS_WINDOW_COMMANDDEFINE'", WindowDefine.class, null);
		openNewWindow(ConvManager.getCurrentConvId() + "_DetailTableCommand", _df, _wf.getId(), null, true, "", this.getWindowData().isReadOnly());

	}

	public void treeNodeSelect_WindowTreeTable(TreeData treeData) throws Exception {
		TableData td = this.getWindowData().getDefaultTableData();
		td.setRealQueryString("");
		tableManager.goFirst(td);
		Utility.updateComponent("tableform");
	}
}
