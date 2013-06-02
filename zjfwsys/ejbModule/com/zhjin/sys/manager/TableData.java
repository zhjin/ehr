/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.model.SelectItem;

import org.primefaces.component.datatable.DataTable;

import com.zhjin.sys.entity.ViewObjectFieldProperty;
import com.zhjin.sys.entity.ViewObjectProperty;
import com.zhjin.util.Utility;

public class TableData implements Serializable{

	public static int EXPORT_EXCEL_MAX_NUMBER = 50000;

	private String tableId;

	private DataTable dataTable;

	private String remark;

	private boolean canOperate = true;

	/**
	 * 表格数据对象
	 */
	private ViewObjectProperty objectProperty;

	/**
	 * 表格数据对象列
	 */
	private List<ViewObjectFieldProperty> columnList;

	/**
	 * 表格数据
	 */
	private TableDataModel tableData = new TableDataModel();

	private int recordCount;

	private int currentPage;

	private int maxPage;

	private int pageRecord;

	private Object selectData;

	private boolean showCustomComponent;

	private String customURL;

	/**
	 * 只读数据列
	 */
	private String readOnlyColumns;
	private TreeSet<String> readOnlyColumnsTree = new TreeSet<String>();

	/**
	 * 隐藏数据列
	 */
	private String hideColumns;
	private TreeSet<String> hideColumnsTree = new TreeSet<String>();

	private String showHideColumns;
	private TreeSet<String> showHideColumnsTree = new TreeSet<String>();

	private String showReadOnlyColumns;
	private TreeSet<String> showReadOnlyColumnsTree = new TreeSet<String>();

	/**
	 * 编辑记录
	 */
	private Object editObject;

	private String editType;

	/**
	 * 是否可新建记录
	 */
	private boolean canNew = false;
	private String canNewEL;
	private String initNewDataEL = "";
	private String saveNewDataEL = "";
	private String newDataPageURL;
	private int newEditWidth;
	private int newEditHeight;

	/**
	 * 新建记录隐藏列
	 */
	private String newHideColumns;
	private TreeSet<String> newHideColumnsTree = new TreeSet<String>();

	/**
	 * 新建记录只读列
	 */
	private String newReadOnlyColumns;
	private TreeSet<String> newReadOnlyColumnsTree = new TreeSet<String>();

	/**
	 * 是否可更新
	 */
	private boolean canUpdate = false;
	private String canUpdateEL;
	private String initUpdateDataEL;
	private String updateDataEL;
	private String updatePageURL;
	private int updateEditWidth;
	private int updateEditHeight;

	private Object otherData;

	/**
	 * 更新表格数据只读列
	 */
	private String updateReadOnlyColumns;
	private TreeSet<String> updateReadOnlyColumnsTree = new TreeSet<String>();

	/**
	 * 更新表格数据隐藏列
	 */
	private String updateHideColumns;
	private TreeSet<String> updateHideColumnsTree = new TreeSet<String>();

	/**
	 * 是否可删除
	 */
	private boolean canDelete = false;
	private String canDeleteEL;
	private String deleteEL = "";
	private boolean realDelete = false;

	/**
	 * 表格数据查询语句
	 */
	private String queryString;

	private String nativeString;
	
	private String realQueryString;
	private HashMap<String, Object> queryArgument;

	/**
	 * 表格数据查询参数
	 */
	private HashMap<String, Object> queryArg;

	/**
	 * 表格数据过滤参数
	 */
	private HashMap<String, Object> filterArg;

	/**
	 * 过滤语句
	 */
	private String filterString = "";

	/**
	 * 排序语句
	 */
	private String orderString = "";

	private boolean readOnly = true;

	/**
	 * 是否允许快速查询
	 */
	private boolean fastSearchEnabled = false;

	/**
	 * 快速查询列名
	 */
	private String fastFilterName;

	private String fastFilterNameCN;

	/**
	 * 表格数据更新处理方法
	 */
	private String valueChangeEL;

	/**
	 * 记录编辑窗口宽度
	 */
	private int editWidth;

	/**
	 * 记录编辑窗口高度
	 */
	private int editHeight;

	private String includeComponent;

	/**
	 * 是否可以选择员工
	 */
	private boolean selectEmployeeEnabled = false;

	/**
	 * 选择员工后处理方法
	 */
	private String selectEmployeeProcessEL = "";

	/**
	 * 是否显示表格标题
	 */
	private boolean showTableHeader = false;

	/**
	 * 表格标题EL
	 */
	private String tableHeaderEL;


	private boolean showTableFooter = false;

	/**
	 * 表格footer EL
	 */
	private String tableFooterEL;

	private String columnClasses = "";

	private boolean canExportExcel;

	private String keyColumns;
	private TreeSet<String> keySet = new TreeSet<String>();

	// --------------------- 表格过滤(开始) ---------------------------------------

	/**
	 * 条件列表
	 */
	private List<TableQueryItem> queryList;

	/**
	 * 选中列
	 */
	private String querySelectedColumn;

	private List<SelectItem> queryColumnList;

	private List<SelectItem> queryConditionList;

	private List<SelectItem> queryOperatorList;

	// --------------------- 表格过滤(结束) ---------------------------------------

	private HtmlPanelGroup commandGroup;

	public TableData() {
		super();
		realDelete = false;
	}

	public DataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public ViewObjectProperty getObjectProperty() {
		return objectProperty;
	}

	public void setObjectProperty(ViewObjectProperty objectProperty) {
		this.objectProperty = objectProperty;
	}

	public List<ViewObjectFieldProperty> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<ViewObjectFieldProperty> columnList) {
		this.columnList = columnList;
	}

	public TableDataModel getTableData() {
		return tableData;
	}

	public void setTableData(TableDataModel tableData) {
		this.tableData = tableData;
	}

	public boolean isCanNew() {
		return canNew;
	}

	public void setCanNew(boolean canNew) {
		this.canNew = canNew;
	}

	public boolean isCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(boolean canUpdate) {
		this.canUpdate = canUpdate;
	}

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	public String getDeleteEL() {
		return deleteEL;
	}

	public void setDeleteEL(String deleteEL) {
		this.deleteEL = deleteEL;
	}

	public boolean isRealDelete() {
		return realDelete;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getNewEditWidth() {
		return newEditWidth;
	}

	public void setNewEditWidth(int newEditWidth) {
		this.newEditWidth = newEditWidth;
	}

	public int getNewEditHeight() {
		return newEditHeight;
	}

	public void setNewEditHeight(int newEditHeight) {
		this.newEditHeight = newEditHeight;
	}

	public int getUpdateEditWidth() {
		return updateEditWidth;
	}

	public void setUpdateEditWidth(int updateEditWidth) {
		this.updateEditWidth = updateEditWidth;
	}

	public int getUpdateEditHeight() {
		return updateEditHeight;
	}

	public void setUpdateEditHeight(int updateEditHeight) {
		this.updateEditHeight = updateEditHeight;
	}

	public void setRealDelete(boolean realDelete) {
		this.realDelete = realDelete;
	}

	public String getQueryString() {
		return this.queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public HashMap<String, Object> getQueryArg() {
		return queryArg;
	}

	public void setQueryArg(HashMap<String, Object> queryArg) {
		this.queryArg = queryArg;
	}

	public HashMap<String, Object> getFilterArg() {
		return filterArg;
	}

	public void setFilterArg(HashMap<String, Object> filterArg) {
		this.filterArg = filterArg;
	}

	public String getFilterString() {
		return filterString;
	}

	public void setFilterString(String filterString) {
		this.filterString = filterString;
	}

	public String getOrderString() {
		return orderString;
	}

	public void setOrderString(String orderString) {
		this.orderString = orderString;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isFastSearchEnabled() {
		return fastSearchEnabled;
	}

	public void setFastSearchEnabled(boolean fastSearchEnabled) {
		this.fastSearchEnabled = fastSearchEnabled;
	}

	public String getFastFilterName() {
		return fastFilterName;
	}

	public void setFastFilterName(String fastFilterName) {
		this.fastFilterName = fastFilterName;
	}

	public String getValueChangeEL() {
		return valueChangeEL;
	}

	public void setValueChangeEL(String valueChangeEL) {
		this.valueChangeEL = valueChangeEL;
	}

	public int getEditWidth() {
		return editWidth;
	}

	public void setEditWidth(int editWidth) {
		this.editWidth = editWidth;
	}

	public int getEditHeight() {
		return editHeight;
	}

	public void setEditHeight(int editHeight) {
		this.editHeight = editHeight;
	}

	public boolean isSelectEmployeeEnabled() {
		return selectEmployeeEnabled;
	}

	public void setSelectEmployeeEnabled(boolean selectEmployeeEnabled) {
		this.selectEmployeeEnabled = selectEmployeeEnabled;
	}

	public String getSelectEmployeeProcessEL() {
		return selectEmployeeProcessEL;
	}

	public void setSelectEmployeeProcessEL(String selectEmployeeProcessEL) {
		this.selectEmployeeProcessEL = selectEmployeeProcessEL;
	}

	public boolean isShowTableHeader() {
		return showTableHeader;
	}

	public void setShowTableHeader(boolean showTableHeader) {
		this.showTableHeader = showTableHeader;
	}

	public String getTableHeaderEL() {
		return tableHeaderEL;
	}

	public void setTableHeaderEL(String tableHeaderEL) {
		this.tableHeaderEL = tableHeaderEL;
	}

	public boolean isShowTableFooter() {
		return showTableFooter;
	}

	public String getTableFooterEL() {
		return tableFooterEL;
	}

	public void setTableFooterEL(String tableFooterEL) {
		this.tableFooterEL = tableFooterEL;
	}

	public String getReadOnlyColumns() {
		return readOnlyColumns;
	}

	public void setReadOnlyColumns(String readOnlyColumns) {
		this.readOnlyColumns = readOnlyColumns;
		this.readOnlyColumnsTree = Utility.initColumnsTree(readOnlyColumns);
	}

	public String getHideColumns() {
		return hideColumns;
	}

	public void setHideColumns(String hideColumns) {
		this.hideColumns = hideColumns;
		this.hideColumnsTree = Utility.initColumnsTree(hideColumns);
	}

	public String getNewHideColumns() {
		return newHideColumns;
	}

	public void setNewHideColumns(String newHideColumns) {
		this.newHideColumns = newHideColumns;
	}

	public String getNewReadOnlyColumns() {
		return newReadOnlyColumns;
	}

	public void setNewReadOnlyColumns(String newReadOnlyColumns) {
		this.newReadOnlyColumns = newReadOnlyColumns;
	}

	public String getUpdateReadOnlyColumns() {
		return updateReadOnlyColumns;
	}

	public void setUpdateReadOnlyColumns(String updateReadOnlyColumns) {
		this.updateReadOnlyColumns = updateReadOnlyColumns;
	}

	public String getUpdateHideColumns() {
		return updateHideColumns;
	}

	public void setUpdateHideColumns(String updateHideColumns) {
		this.updateHideColumns = updateHideColumns;
	}

	public String getColumnClasses() {
		return columnClasses;
	}


	public void setColumnClasses(String columnClasses) {
		this.columnClasses = columnClasses;
	}

	public String getFastFilterNameCN() {
		return fastFilterNameCN;
	}


	public void setFastFilterNameCN(String fastFilterNameCN) {
		this.fastFilterNameCN = fastFilterNameCN;
	}


	public List<TableQueryItem> getQueryList() {
		return queryList;
	}


	public void setQueryList(List<TableQueryItem> queryList) {
		this.queryList = queryList;
	}


	public String getQuerySelectedColumn() {
		return querySelectedColumn;
	}


	public void setQuerySelectedColumn(String querySelectedColumn) {
		this.querySelectedColumn = querySelectedColumn;
	}


	public List<SelectItem> getQueryConditionList() {
		return queryConditionList;
	}


	public void setQueryConditionList(List<SelectItem> queryConditionList) {
		this.queryConditionList = queryConditionList;
	}


	public List<SelectItem> getQueryOperatorList() {
		return queryOperatorList;
	}


	public void setQueryOperatorList(List<SelectItem> queryOperatorList) {
		this.queryOperatorList = queryOperatorList;
	}


	public List<SelectItem> getQueryColumnList() {
		return queryColumnList;
	}

	public void setQueryColumnList(List<SelectItem> queryColumnList) {
		this.queryColumnList = queryColumnList;
	}

	public Object getEditObject() {
		return editObject;
	}

	public void setEditObject(Object editObject) {
		this.editObject = editObject;
	}

	public String getEditType() {
		return editType;
	}

	public void setEditType(String editType) {
		this.editType = editType;
	}

	public boolean isCanExportExcel() {
		return canExportExcel;
	}

	public void setCanExportExcel(boolean canExportExcel) {
		this.canExportExcel = canExportExcel;
	}

	public TreeSet<String> getKeySet() {
		return keySet;
	}

	public void setKeySet(TreeSet<String> keySet) {
		this.keySet = keySet;
	}

	public Object getOtherData() {
		return otherData;
	}

	public void setOtherData(Object otherData) {
		this.otherData = otherData;
	}

	public String getIncludeComponent() {
		return includeComponent;
	}

	public void setIncludeComponent(String includeComponent) {
		this.includeComponent = includeComponent;
	}

	public boolean isCanOperate() {
		return canOperate;
	}

	public void setCanOperate(boolean canOperate) {
		this.canOperate = canOperate;
	}

	public TreeSet<String> getReadOnlyColumnsTree() {
		return readOnlyColumnsTree;
	}

	public void setReadOnlyColumnsTree(TreeSet<String> readOnlyColumnsTree) {
		this.readOnlyColumnsTree = readOnlyColumnsTree;
	}

	public TreeSet<String> getHideColumnsTree() {
		return hideColumnsTree;
	}

	public void setHideColumnsTree(TreeSet<String> hideColumnsTree) {
		this.hideColumnsTree = hideColumnsTree;
	}

	public TreeSet<String> getNewHideColumnsTree() {
		return newHideColumnsTree;
	}

	public void setNewHideColumnsTree(TreeSet<String> newHideColumnsTree) {
		this.newHideColumnsTree = newHideColumnsTree;
	}

	public TreeSet<String> getNewReadOnlyColumnsTree() {
		return newReadOnlyColumnsTree;
	}

	public void setNewReadOnlyColumnsTree(TreeSet<String> newReadOnlyColumnsTree) {
		this.newReadOnlyColumnsTree = newReadOnlyColumnsTree;
	}

	public TreeSet<String> getUpdateReadOnlyColumnsTree() {
		return updateReadOnlyColumnsTree;
	}

	public void setUpdateReadOnlyColumnsTree(TreeSet<String> updateReadOnlyColumnsTree) {
		this.updateReadOnlyColumnsTree = updateReadOnlyColumnsTree;
	}

	public TreeSet<String> getUpdateHideColumnsTree() {
		return updateHideColumnsTree;
	}

	public void setUpdateHideColumnsTree(TreeSet<String> updateHideColumnsTree) {
		this.updateHideColumnsTree = updateHideColumnsTree;
	}

	public String getUpdatePageURL() {
		return updatePageURL;
	}

	public void setUpdatePageURL(String updatePageURL) {
		this.updatePageURL = updatePageURL;
	}

	public String getCanNewEL() {
		return canNewEL;
	}

	public void setCanNewEL(String canNewEL) {
		this.canNewEL = canNewEL;
	}

	public String getInitNewDataEL() {
		return initNewDataEL;
	}

	public void setInitNewDataEL(String initNewDataEL) {
		this.initNewDataEL = initNewDataEL;
	}

	public String getSaveNewDataEL() {
		return saveNewDataEL;
	}

	public void setSaveNewDataEL(String saveNewDataEL) {
		this.saveNewDataEL = saveNewDataEL;
	}

	public String getNewDataPageURL() {
		return newDataPageURL;
	}

	public void setNewDataPageURL(String newDataPageURL) {
		this.newDataPageURL = newDataPageURL;
	}

	public String getCanUpdateEL() {
		return canUpdateEL;
	}

	public void setCanUpdateEL(String canUpdateEL) {
		this.canUpdateEL = canUpdateEL;
	}

	public String getInitUpdateDataEL() {
		return initUpdateDataEL;
	}

	public void setInitUpdateDataEL(String initUpdateDataEL) {
		this.initUpdateDataEL = initUpdateDataEL;
	}

	public String getUpdateDataEL() {
		return updateDataEL;
	}

	public void setUpdateDataEL(String updateDataEL) {
		this.updateDataEL = updateDataEL;
	}

	public String getCanDeleteEL() {
		return canDeleteEL;
	}

	public void setCanDeleteEL(String canDeleteEL) {
		this.canDeleteEL = canDeleteEL;
	}

	public void setShowTableFooter(boolean showTableFooter) {
		this.showTableFooter = showTableFooter;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public Object getSelectData() {
		return selectData;
	}

	public void setSelectData(Object selectData) {
		this.selectData = selectData;
	}

	public int getPageRecord() {
		return pageRecord;
	}

	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}

	public String getKeyColumns() {
		return keyColumns;
	}

	public void setKeyColumns(String keyColumns) {
		this.keyColumns = keyColumns;
	}

	public HtmlPanelGroup getCommandGroup() {
		return commandGroup;
	}

	public void setCommandGroup(HtmlPanelGroup commandGroup) {
		this.commandGroup = commandGroup;
	}

	public String getNativeString() {
		return nativeString;
	}

	public void setNativeString(String nativeString) {
		this.nativeString = nativeString;
	}

	public String getShowHideColumns() {
		return showHideColumns;
	}

	public void setShowHideColumns(String showHideColumns) {
		this.showHideColumns = showHideColumns;
	}

	public TreeSet<String> getShowHideColumnsTree() {
		return showHideColumnsTree;
	}

	public void setShowHideColumnsTree(TreeSet<String> showHideColumnsTree) {
		this.showHideColumnsTree = showHideColumnsTree;
	}

	public String getShowReadOnlyColumns() {
		return showReadOnlyColumns;
	}

	public void setShowReadOnlyColumns(String showReadOnlyColumns) {
		this.showReadOnlyColumns = showReadOnlyColumns;
	}

	public TreeSet<String> getShowReadOnlyColumnsTree() {
		return showReadOnlyColumnsTree;
	}

	public void setShowReadOnlyColumnsTree(TreeSet<String> showReadOnlyColumnsTree) {
		this.showReadOnlyColumnsTree = showReadOnlyColumnsTree;
	}

	public boolean isShowCustomComponent() {
		return showCustomComponent;
	}

	public void setShowCustomComponent(boolean showCustomComponent) {
		this.showCustomComponent = showCustomComponent;
	}

	public String getCustomURL() {
		return customURL;
	}

	public void setCustomURL(String customURL) {
		this.customURL = customURL;
	}

	public String getTableClientId() {
		return dataTable.getClientId();
	}

	public String getRealQueryString() {
		if (!Utility.notEmptyString(this.realQueryString)) {
			this.queryArgument = new HashMap<String, Object>();
			if (this.getQueryArg() != null) {
				for (String o : this.getQueryArg().keySet()) {
					this.queryArgument.put(o, this.getQueryArg().get(o));
				}
			}
			if (this.getFilterArg() != null) {
				for (String o : this.getFilterArg().keySet()) {
					this.queryArgument.put(o, this.getFilterArg().get(o));
				}
			}

			String _queryString = "";
			if (this.getQueryString().toLowerCase().indexOf("where") >= 0) {
				if ("".equals(this.getFilterString().trim())) {
					_queryString = this.getQueryString();
				} else {
					_queryString = this.getQueryString() + " and (" + this.getFilterString() + ") ";
				}
			} else {
				if ("".equals(this.getFilterString().trim())) {
					_queryString = this.getQueryString();
				} else {
					_queryString = this.getQueryString() + " where (" + this.getFilterString() + ") ";
				}
			}
			_queryString = (_queryString + " " + (String)Utility.isnull(this.getNativeString(), "")).trim() + " ";
			
			_queryString = (String)Utility.getELValue(_queryString);
			this.realQueryString = _queryString;
			
		}
		return this.realQueryString;
	}

	public void setRealQueryString(String realQueryString) {
		this.realQueryString = realQueryString;
	}

	public HashMap<String, Object> getQueryArgument() {
		return queryArgument;
	}

	public void setQueryArgument(HashMap<String, Object> queryArgument) {
		this.queryArgument = queryArgument;
	}

}
