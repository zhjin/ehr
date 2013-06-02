/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.window;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.html.HtmlPanelGroup;
import javax.inject.Named;

import com.zhjin.context.ConvManager;
import com.zhjin.context.ConvScoped;
import com.zhjin.sys.manager.ObjectEditData;
import com.zhjin.sys.manager.TableData;
import com.zhjin.sys.manager.TreeData;
import com.zhjin.util.Utility;

@Named
@ConvScoped
public class WindowData implements Serializable {

	public static String OBJECTNAME = "editobj";
	public static String TREENAME = "tree";
	public static String TABLENAME = "table";
	public static String MASTERTABLENAME = "mastertable";
	public static String DETAILTABLENAME = "detailtable";

	private WindowData parentWindowData;

	private Object inData;

	private String windowTitle;

	private String initWindowEL;

	private String beforeOpenEL;

	private String closeWindowEL;

	private String convName;

	private String windowURL;

	private int windowWidth;

	private int windowHeight;

	private HtmlPanelGroup commandGroup;

	private boolean hasCancelButton;
	private boolean newConv;
	private boolean readOnly;

	//private Map<String, TableData> tableMap = new HashMap<String, TableData>();

	private Map<String, Object> objMap = new HashMap<String, Object>();

	private long customId;
	private long customVersion;
	private String parentRefreshButton;

	public WindowData() {
		super();
		commandGroup = new HtmlPanelGroup();
		commandGroup.setId("commandgroup");
		hasCancelButton = false;
	}
	
	public void closeWindow() throws Exception {	
		if (Utility.notEmptyString(this.parentRefreshButton)) {
			Utility.closeWindowAndRefreshParent(this.parentRefreshButton);
		} else {
			Utility.closeWindow();
		}
		this.initClose();
	}
	
	public void cancelWindow() throws Exception {
		Utility.executeJavaScript("window.close();");
		this.initClose();
	}
	
	private void initClose() throws Exception {
		this.parentRefreshButton = null;
		this.inData = null;
		if (this.newConv) {
			ConvManager.endCurrentConv();	
		}		
	}
	
	public ObjectEditData getObjectEditData(String objectId) {
		return (ObjectEditData)this.getObjMap().get(objectId);
	}
	
	public ObjectEditData getDefaultObjectEditData() {
		return (ObjectEditData)this.getObjMap().get(OBJECTNAME);
	}

	public TreeData getTreeData(String treeId) {
		return (TreeData)this.getObjMap().get(treeId);
	}
	
	public TreeData getDefaultTreeData() {
		return (TreeData)this.getObjMap().get(TREENAME);
	}
	
	public TableData getTableData(String tableId) {
		return (TableData)this.getObjMap().get(tableId);
	}
	
	public TableData getDefaultTableData() {
		return (TableData)this.getObjMap().get(TABLENAME);
	}
	
	public TableData getDefaultMasterTableData() {
		return (TableData)this.getObjMap().get(MASTERTABLENAME);
	}
	
	public TableData getDefaultDetailTableData() {
		return (TableData)this.getObjMap().get(DETAILTABLENAME);
	}
	
	public void setDefaultObjectEditData(ObjectEditData data) {
		this.getObjMap().put(OBJECTNAME, data);
	}

	public void setDefaultTreeData(TreeData data) {
		this.getObjMap().put(TREENAME, data);
	}
	public void setDefaultTableData(TableData data) {
		this.getObjMap().put(TABLENAME, data);
	}
	public void setDefaultMasterTableData(TableData data) {
		this.getObjMap().put(MASTERTABLENAME, data);
	}
	public void setDefaultDetailTableData(TableData data) {
		this.getObjMap().put(DETAILTABLENAME, data);
	}
	
	public String getWindowTitle() {
		return windowTitle;
	}

	public void setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
	}

	public String getInitWindowEL() {
		return initWindowEL;
	}

	public void setInitWindowEL(String initWindowEL) {
		this.initWindowEL = initWindowEL;
	}

	public String getBeforeOpenEL() {
		return beforeOpenEL;
	}

	public void setBeforeOpenEL(String beforeOpenEL) {
		this.beforeOpenEL = beforeOpenEL;
	}

	public String getCloseWindowEL() {
		return closeWindowEL;
	}

	public void setCloseWindowEL(String closeWindowEL) {
		this.closeWindowEL = closeWindowEL;
	}

	public String getConvName() {
		return convName;
	}

	public void setConvName(String convName) {
		this.convName = convName;
	}

	public String getWindowURL() {
		return windowURL;
	}

	public void setWindowURL(String windowURL) {
		this.windowURL = windowURL;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}

	public WindowData getParentWindowData() {
		return parentWindowData;
	}

	public void setParentWindowData(WindowData parentWindowData) {
		this.parentWindowData = parentWindowData;
	}

	public Object getInData() {
		return inData;
	}

	public void setInData(Object inData) {
		this.inData = inData;
	}

	public Map<String, Object> getObjMap() {
		return objMap;
	}

	public void setObjMap(Map<String, Object> objMap) {
		this.objMap = objMap;
	}

	public HtmlPanelGroup getCommandGroup() {
		return commandGroup;
	}

	public void setCommandGroup(HtmlPanelGroup commandGroup) {
		this.commandGroup = commandGroup;
	}

	public boolean isHasCancelButton() {
		return hasCancelButton;
	}

	public void setHasCancelButton(boolean hasCancelButton) {
		this.hasCancelButton = hasCancelButton;
	}

	public long getCustomId() {
		return customId;
	}

	public void setCustomId(long customId) {
		this.customId = customId;
	}

	public long getCustomVersion() {
		return customVersion;
	}

	public void setCustomVersion(long customVersion) {
		this.customVersion = customVersion;
	}

	public String getParentRefreshButton() {
		return parentRefreshButton;
	}

	public void setParentRefreshButton(String parentRefreshButton) {
		this.parentRefreshButton = parentRefreshButton;
	}

	public boolean isNewConv() {
		return newConv;
	}

	public void setNewConv(boolean newConv) {
		this.newConv = newConv;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

}
