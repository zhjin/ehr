/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.NumberConverter;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.persistence.Id;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.component.column.Column;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.UploadedFile;

import com.zhjin.base.DataTableImpl;
import com.zhjin.base.entity.SysLargeText;
import com.zhjin.context.ConvManager;
import com.zhjin.faces.custom.components.UISelectOneMenuValueOutput;
import com.zhjin.sys.entity.TableDefine;
import com.zhjin.sys.entity.TableQueryArgDefine;
import com.zhjin.sys.entity.ViewObjectFieldProperty;
import com.zhjin.sys.entity.ViewObjectProperty;
import com.zhjin.sys.entity.WindowCommandDefine;
import com.zhjin.sys.entity.WindowDefine;
import com.zhjin.sys.window.WindowData;
import com.zhjin.sys.window.WindowManager;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.FileUploadData;
import com.zhjin.util.SysUtil;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class TableManager
 */
@Named
@Stateless
@LocalBean
public class TableManager extends BeanBase {

	@EJB
	private ObjectEditManager objectEditManager;

	@EJB
	private WindowManager windowManager;

	@EJB
	private SysUtil sysUtil;

	@EJB
	private TableQueryDialog queryDialog;

    /**
     * Default constructor.
     */
    public TableManager() {
    }

	public TableData initDataTable(Object inData, String tableId, long tableDefineId) throws Exception {

		TableDefine _table = dbUtility.getEntity(TableDefine.class, tableDefineId);

		if (_table == null) {
			throw new Exception("TableDefine : " + String.valueOf(tableDefineId) + " 不存在！");
		}

		TableData data = new TableData();

		try {

			data.setTableId(tableId);
			data.setReadOnly(_table.isReadOnly());

			data.setQueryString(_table.getQueryString());
			data.setNativeString(_table.getNativeString());
			data.setOrderString(_table.getOrderString());

			data.setReadOnlyColumns(_table.getReadOnlyColumns());
			data.setReadOnlyColumnsTree(Utility.initColumnsTree((String)Utility.getELValue(_table.getReadOnlyColumns())));

			data.setHideColumns(_table.getHideColumns());
			data.setHideColumnsTree(Utility.initColumnsTree((String)Utility.getELValue(_table.getHideColumns())));

			data.setShowReadOnlyColumns(_table.getShowReadOnlyColumns());
			data.setShowReadOnlyColumnsTree(Utility.initColumnsTree((String)Utility.getELValue(_table.getShowReadOnlyColumns())));

			data.setShowHideColumns(_table.getShowHideColumns());
			data.setShowHideColumnsTree(Utility.initColumnsTree((String)Utility.getELValue(_table.getShowHideColumns())));

			data.setNewHideColumns(_table.getNewHideColumns());
			data.setNewHideColumnsTree(Utility.initColumnsTree((String)Utility.getELValue(_table.getNewHideColumns())));
			data.setNewReadOnlyColumns(_table.getNewReadOnlyColumns());
			data.setNewReadOnlyColumnsTree(Utility.initColumnsTree((String)Utility.getELValue(_table.getNewReadOnlyColumns())));
			data.setCanNew(_table.isCanNew());
			data.setCanNewEL(_table.getCanNewEL());
			data.setInitNewDataEL(_table.getInitNewDataEL());
			data.setSaveNewDataEL(_table.getSaveNewDataEL());
			data.setNewDataPageURL((String)Utility.getELValue(_table.getNewDataPageURL()));
			data.setNewEditWidth(_table.getNewEditWidth());
			data.setNewEditHeight(_table.getNewEditHeight());

			data.setUpdateReadOnlyColumns(_table.getUpdateReadOnlyColumns());
			data.setUpdateReadOnlyColumnsTree(Utility.initColumnsTree((String)Utility.getELValue(_table.getUpdateReadOnlyColumns())));
			data.setUpdateHideColumns(_table.getUpdateHideColumns());
			data.setUpdateHideColumnsTree(Utility.initColumnsTree((String)Utility.getELValue(_table.getUpdateHideColumns())));
			data.setCanUpdate(_table.isCanUpdate());
			data.setCanUpdateEL(_table.getCanUpdateEL());
			data.setInitUpdateDataEL(_table.getInitUpdateDataEL());
			data.setUpdateDataEL(_table.getUpdateDataEL());
			data.setUpdatePageURL((String)Utility.getELValue(_table.getUpdatePageURL()));
			data.setUpdateEditWidth(_table.getUpdateEditWidth());
			data.setUpdateEditHeight(_table.getUpdateEditHeight());

			data.setCanDelete(_table.isCanDelete());
			data.setCanDeleteEL(_table.getCanDeleteEL());
			data.setDeleteEL(_table.getDeleteEL());
			data.setRealDelete(_table.isRealDelete());

			data.setEditWidth(_table.getEditWidth());
			data.setEditHeight(_table.getEditHeight());
			data.setIncludeComponent(_table.getIncludeComponent());

			data.setCanExportExcel(_table.isCanExportExcel());

			if (Utility.notEmptyString(_table.getBeforeOpenTableProcessEL())) {
				String _s = (String)Utility.getELValue(_table.getBeforeOpenTableProcessEL());
				if (_s.toUpperCase().startsWith("SQL:")) {

				} else {
					Utility.executeMethodExpression(_s, new Class[]{}, new Object[]{});
				}
			}

			data.setRemark(_table.getRemark());

			if (_table.isShowCustomComponent() && _table.getCustomComponentId() > 0) {
				SysLargeText _slt = dbUtility.getEntity(SysLargeText.class, _table.getCustomComponentId());
				if (Utility.notEmptyString(_slt.getTextContent())) {
					data.setShowCustomComponent(true);
					data.setCustomURL(Utility.baseURL() + "/sys/showdbpage?id=" + _table.getCustomComponentId() + "&v=" + _slt.getVersion());
				} else {
					data.setShowCustomComponent(false);
				}
			} else {
				data.setShowCustomComponent(false);
			}

			data.setDataTable(new DataTable());
			data.getDataTable().setEmptyMessage("");
			data.getDataTable().setValueExpression("value", Utility.getValueExpression("#{cc.attrs.value.tableData}"));
			data.getDataTable().setValueExpression("selection", Utility.getValueExpression("#{cc.attrs.value.selectData}"));
			data.getDataTable().setSelectionMode("single");

			data.getDataTable().setVar("row");
			data.getDataTable().setRows(15);

			data.setPageRecord(15);

			data.setObjectProperty(dbUtility.getEntity(ViewObjectProperty.class, _table.getObjectName()));

			// 设置只读数据列
			// 主键和版本控制字段为只读
			Class<?> _class = Class.forName(data.getObjectProperty().getObjectClassName());
			Field[] _fields = null;

			data.setKeySet(new TreeSet<String>());
			data.setKeyColumns("");
			while (!_class.equals(Object.class)) {
				_fields = _class.getDeclaredFields();
				for (Field f : _fields) {
					if (f.isAnnotationPresent(Id.class)) {
						data.getKeySet().add(f.getName().toUpperCase());
						data.setKeyColumns(data.getKeyColumns() + f.getName() + " ");
					}
				}
				_class = _class.getSuperclass();
			}

			data.setColumnList(dbUtility.getDataList(
					"select * from viewobjectfieldproperty where objectname = :objectName and visiabled = 1 order by indexno",
					ViewObjectFieldProperty.class, new ArgMap().add("objectName", data.getObjectProperty().getObjectName())));

			for (ViewObjectFieldProperty field : data.getColumnList()) {

				// 如果是主键字段或者是版本控制字段则设置成只读
				field.setRunReadOnly(data.isReadOnly()
						|| field.isReadOnly()
						|| data.getKeySet().contains(field.getFieldName().toUpperCase())
						|| data.getReadOnlyColumnsTree().contains(field.getFieldName().toUpperCase())
						|| data.getShowReadOnlyColumnsTree().contains(field.getFieldName().toUpperCase()));
				field.setRunVisiabled(field.isVisiabled() && !data.getHideColumnsTree().contains(field.getFieldName().toUpperCase())
						&& !data.getShowHideColumnsTree().contains(field.getFieldName().toUpperCase()));

			}

			if (_table.isFastSearchEnabled() && Utility.notEmptyString(_table.getFastSearchField())) {
				data.setFastSearchEnabled(true);
				data.setFastFilterName(_table.getFastSearchField());
				for (ViewObjectFieldProperty field : data.getColumnList()) {

					if (field.getFieldName().toUpperCase().equals(data.getFastFilterName().toUpperCase())) {
						data.setFastFilterNameCN(field.getFieldNameCN());
					}
				}
			} else {
				data.setFastSearchEnabled(false);
				data.setFastFilterName(null);
			}

			initTableColumns(data);

			if (Utility.notEmptyString(_table.getTableHeaderEL())) {
				data.getDataTable().setHeader(Utility.getOutputComponent(_table.getTableHeaderEL()));
			}

			if (Utility.notEmptyString(_table.getTableFooterEL())) {
				data.getDataTable().setFooter(Utility.getOutputComponent(_table.getTableFooterEL()));
			}

			// 设置表格查询参数
			data.setQueryArg(new HashMap<String, Object>());
			List<TableQueryArgDefine> _argList = dbUtility.getDataList("select * from tablequeryargdefine where tableid = :tableDefineId",
					TableQueryArgDefine.class,
					new ArgMap().add("tableDefineId", tableDefineId));

			for (TableQueryArgDefine _arg : _argList) {
				data.getQueryArg().put(_arg.getArgName(), PropertyUtils.getProperty(inData, _arg.getArgValue()));
			}

			// 表格参数设置完成
			data.setCurrentPage(1);
			this.queryData(data);

			// 表格按钮初始化
			data.setCommandGroup(new HtmlPanelGroup());
			List<WindowCommandDefine> _list = dbUtility.getDataList(
					"select * from windowcommanddefine where commandparenttype = 'TABLE' and parentid = :tableId order by indexno",
					WindowCommandDefine.class,
					new ArgMap().add("tableId", tableDefineId));

			for (WindowCommandDefine _comm : _list) {
				if (_comm.isVisiabled()) {

					CommandButton button = new CommandButton();
					button.setId("cid" + _comm.getId());
					button.setValueExpression("value", Utility.getValueExpression(_comm.getCommandValueEL()));

					if (_comm.getFileButtonType().equals("NOFILE")) {
						button.addActionListener(Utility.getActionListener("#{tableManager.tableCommandClick}"));
					} else if (_comm.getFileButtonType().equals("UPLOADFILE")) {
						button.addActionListener(Utility.getActionListener("#{tableManager.tableCommandUploadFileClick}"));
					} else if (_comm.getFileButtonType().equals("DOWNLOADFILE")) {
					
					}
					
					if ("AJAX".equals(_comm.getCommandType())) {
						button.setAjax(true);
					} else {
						button.setAjax(false);
					}
	
					button.getChildren().add(Utility.getUIParameter("tableId", tableId));
					button.getChildren().add(Utility.getUIParameter("commandId", _comm.getId()));
	
					if (Utility.notEmptyString(_comm.getOnclick())) {
						button.setOnclick((String)Utility.getELValue(_comm.getOnclick()));
					}
	
					if (Utility.notEmptyString(_comm.getUpdateComponent())) {
						button.setUpdate(_comm.getUpdateComponent());
					}
						
					if (Utility.notEmptyString(_comm.getIcon())) {
						button.setIcon(_comm.getIcon());
					}
						
					data.getCommandGroup().getChildren().add(button); 
				}

			}

			return data;

		} catch (Exception ex) {
			System.out.println(ex);
			throw new Exception("表格: " + String.valueOf(_table.getId()) + ", 初始化失败!");
		}
	}

	public DataTable initDataTable(String tableId, String objectName, String readColumns, String hideColumns) {
		TreeSet<String> hideColumnTree = Utility.initColumnsTree((String)Utility.getELValue(hideColumns));
		DataTable table = new DataTable();
		table.setEmptyMessage("");
		//table.setSelectionMode("single");

		table.setVar("row");

		List<ViewObjectFieldProperty> _columnList = dbUtility.getDataList(
				"select * from viewobjectfieldproperty where objectname = :objectName and visiabled = 1 order by indexno", 
				ViewObjectFieldProperty.class, new ArgMap().add("objectName", objectName));
		Column _column = null;

		table.getChildren().clear();
		for (ViewObjectFieldProperty field : _columnList) {

			if (field.isVisiabled() && !"VERSION".equals(field.getFieldName().toUpperCase())
					&& !hideColumnTree.contains(field.getFieldName().toUpperCase())) {

				_column = new Column();
				_column.setId(tableId + "_" + field.getFieldName());
				_column.setRendered(true);
				HtmlOutputText _output = new HtmlOutputText();
				_output.setValue(field.getFieldNameCN());
				_column.setHeader(_output);
				_column.setStyleClass("column" + field.getAlign());

				_column.getChildren().add(tableCellComponent(tableId, field));
				table.getChildren().add(_column);

			}
		}
		
		return table;
	}
	
	public TableData getCurrentTableData() {
		String tableId = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("tableId");
		TableData data = this.getWindowData().getTableData(tableId);
		return data;
	}

	private void initTableColumns(TableData data) {
		Column _column = null;

		data.getDataTable().getChildren().clear();
		for (ViewObjectFieldProperty field : data.getColumnList()) {

			if (field.isRunVisiabled() && !"VERSION".equals(field.getFieldName().toUpperCase())) {

				_column = new Column();
				_column.setId(data.getTableId() + "_" + field.getFieldName());
				_column.setRendered(true);
				HtmlOutputText _output = new HtmlOutputText();
				_output.setValue(field.getFieldNameCN());
				_column.setHeader(_output);
				_column.setStyleClass("column" + field.getAlign());

				_column.getChildren().add(tableCellComponent(data.getTableId(), field));
				data.getDataTable().getChildren().add(_column);

			}
		}
	}

	private UIComponent tableCellComponent(String tableId, ViewObjectFieldProperty field) {

		UIComponent comp = null;
		HtmlOutputText _output = new HtmlOutputText();
		_output.setEscape(false);

		if (field.getShowType().equals("NUMBER")) {

			NumberConverter _conv = new NumberConverter();
			if (Utility.notEmptyString(field.getShowFormat())) {
				_conv.setPattern(field.getShowFormat());
			} else {
				_conv.setPattern("##,##0");
			}
			_output.setConverter(_conv);
			comp = _output;

		} else if (field.getShowType().equals("BIGCECIMAL")) {

			NumberConverter _conv = new NumberConverter();
			if (Utility.notEmptyString(field.getShowFormat())) {
				_conv.setPattern(field.getShowFormat());
			} else {
				_conv.setPattern("##,##0.00");
			}
			_output.setConverter(_conv);
			comp = _output;

		} else if (field.getShowType().equals("DATE")) {
			DateTimeConverter _conv = new DateTimeConverter();
			_conv.setTimeZone(TimeZone.getDefault());
			if (Utility.notEmptyString(field.getShowFormat())) {
				_conv.setPattern(field.getShowFormat());
			} else {
				_conv.setPattern("yyyy-MM-dd");
			}
			_output.setConverter(_conv);
			comp = _output;

		} else if (field.getShowType().equals("DATETIME")) {
			
			DateTimeConverter _conv = new DateTimeConverter();
			_conv.setTimeZone(TimeZone.getDefault());
			if (Utility.notEmptyString(field.getShowFormat())) {
				_conv.setPattern(field.getShowFormat());
			} else {
				_conv.setPattern("yyyy-MM-dd HH:mm:ss");
			}
			_output.setConverter(_conv);
			comp = _output;

		} else if (field.getShowType().equals("CHECKBOX")) {

			HtmlSelectBooleanCheckbox _checkbox = new HtmlSelectBooleanCheckbox();
			_checkbox.setDisabled(field.isRunReadOnly());
			_checkbox.setStyleClass("tcheckbox");
			comp = _checkbox;

		} else if (field.getShowType().equals("SELECTMENU")) {

			UISelectOneMenuValueOutput _select = new UISelectOneMenuValueOutput();
			_select.setValueList(sysUtil.getViewObjectFieldSelectList(field.getDataSource()));
			comp = _select;

		} else {

			comp = _output;
		}

		comp.setRendered(true);
		comp.setValueExpression("value", Utility.getValueExpression("#{row." + field.getFieldName() + "}"));
		return comp;

	}

    /**
     * 设置快速查询字段
     */
    public void setFastFieldSearch(String fieldName) {
//    	this.setFastSearchEnabled(false);
//    	if (fieldName == null) {
//    		return;
//    	}
//    	try {
//	    	for (ViewObjectFieldProperty field : this.getColumnList()) {
//	    		if (field.getFieldName().toUpperCase().equals(fieldName.toUpperCase())
//	    				&& field.getFieldJavaType().toUpperCase().equals("STRING")) {
//	    			this.setFastFilterName(field.getFieldName());
//	    			this.setFastFilterNameCN(field.getFieldNameCN());
//	    			this.setFastSearchEnabled(true);
//	    			break;
//	    		}
//	    	}
//    	} catch (Exception ex) {
//    	}
    }

	/**
	 * 刷新表格数据
	 * @param event
	 */
    @Audit
	public void refreshPage(ActionEvent event) throws Exception {
		//this.initTableColumns(data);
		refreshPage(this.getCurrentTableData());
	}
    
    public void refreshPage(TableData data) throws Exception {
		this.queryData(data);
    }

    @Audit
	public void refreshTableData(ActionEvent event) throws Exception {
		this.queryData(this.getCurrentTableData());
	}

	public void tablefreshbuttonclick() {
		Utility.executeJavaScript("windowButtonClick('" + this.getCurrentTableData().getTableClientId() + "');");
	}

	/**
	 * 到首页
	 * @return
	 */
	@Audit
	public void goFirst(ActionEvent event) throws Exception {
		goFirst(this.getCurrentTableData());
	}
	
	public void goFirst(TableData data) throws Exception {
		data.setCurrentPage(1);
		this.queryData(data);
	}

	/**
	 * 下一页
	 * @return
	 */
	public void goNext(ActionEvent event) throws Exception {
		goNext(this.getCurrentTableData());
	}
	
	public void goNext(TableData data) throws Exception {
		data.setCurrentPage(data.getCurrentPage() + 1);
		this.queryData(data);
	}

	/**
	 * 上一页
	 * @return
	 */
	public void goPrevious(ActionEvent event) throws Exception {
		goPrevious(this.getCurrentTableData());
	}
	
	public void goPrevious(TableData data) throws Exception {
		data.setCurrentPage(data.getCurrentPage() - 1);
		this.queryData(data);
	}

	/**
	 * 最后一页
	 * @return
	 * @throws NamingException
	 */
	public void goLast(ActionEvent event) throws Exception {
		goLast(this.getCurrentTableData());
	}
	
	public void goLast(TableData data) throws Exception {
		data.setCurrentPage(100000000);
		this.queryData(data);
	}

	/**
	 * 过滤
	 * @param event
	 */
	@Audit
	public void filterTableClick(ActionEvent event) throws Exception {

		TableData tdata = this.getCurrentTableData();

		WindowDefine wd = new WindowDefine();
		
		wd.setWindowURL("/sys/tableQueryDialog.jsf");
		wd.setWindowWidth(650);
		wd.setWindowHeight(371);
		wd.setWindowTitle(tdata.getObjectProperty().getObjectNameCN() + " : 过滤");
		wd.setBeforeOpenEL("#{tableManager.initFilterTableRecord}");
		
		windowManager.openNewWindow(ConvManager.getCurrentConvId() + tdata.getTableId() + "_filter", 
				tdata, wd, null, true, event.getComponent().findComponent("refreshtable").getClientId(), 20, false);	
		
	}
	
	public void initFilterTableRecord() throws Exception {
		WindowData data = this.getWindowData();
		TableData tdata = (TableData)data.getInData();
		
		data.setDefaultTableData(tdata);
		queryDialog.initDialog(data.getDefaultTableData());
	}

	/**
	 * 取消过滤
	 * @param event
	 */
	public void cancelFilterTableClick(ActionEvent event) {
		TableData data = this.getCurrentTableData();
		data.setFilterArg(null);
		data.setFilterString("");
		data.setRealQueryString("");
		this.queryData(data);
	}

	@Audit
	public void updateDataEditClick(ActionEvent event) throws Exception {

		TableData tdata = this.getCurrentTableData();

		if (tdata.getSelectData() == null) {
			throw new Exception("请选择需要操作的记录!");
		}

		WindowDefine wd = new WindowDefine();
		
		if (tdata.getUpdateEditWidth() > 0) {
			wd.setWindowWidth(tdata.getUpdateEditWidth());
		} else {
			wd.setWindowWidth(tdata.getObjectProperty().getEditWidth());
		}

		if (tdata.getUpdateEditHeight() > 0) {
			wd.setWindowHeight(tdata.getUpdateEditHeight());
		} else {
			wd.setWindowHeight(tdata.getObjectProperty().getEditHeight());
		}

		wd.setWindowTitle(tdata.getObjectProperty().getObjectNameCN() + " : 更新");
		if (Utility.notEmptyString(tdata.getUpdatePageURL())) {
			wd.setWindowURL(tdata.getUpdatePageURL());
		} else {
			wd.setWindowURL("/sys/tabledatadialog.jsf");
		}
		wd.setBeforeOpenEL("#{tableManager.initUpdateTableRecord}");

		windowManager.openNewWindow(ConvManager.getCurrentConvId() + "_" + tdata.getTableId() + "_updaterecord", 
				tdata, wd, null, true, event.getComponent().findComponent("refreshtable").getClientId(), 20, false);

	}
	
	public void initUpdateTableRecord() throws Exception {
		WindowData wdata = this.getWindowData();
		TableData tdata = (TableData)wdata.getInData();
		
		Object editData = null;

		if (Utility.notEmptyString(tdata.getInitUpdateDataEL())) {
			editData = Utility.executeMethodExpression(tdata.getInitUpdateDataEL(), new Class[]{Object.class}, new Object[]{tdata.getSelectData()});
		} else {
			editData = tdata.getSelectData();
		}

		ObjectEditData oed = new ObjectEditData();
		objectEditManager.initObjectEditData(oed, editData, tdata.getUpdateDataEL(), "", tdata.getObjectProperty().getObjectNameCN() + " : 更新",
				(String)Utility.getELValue(tdata.getKeyColumns() + " " + (String)Utility.isnull(tdata.getUpdateReadOnlyColumns(), "")),
				(String)Utility.getELValue((String)Utility.isnull(tdata.getUpdateHideColumns(), "")));

		oed.setButtonclick(tdata.getTableId());
		wdata.setDefaultObjectEditData(oed);
		wdata.setHasCancelButton(true);

		wdata.getCommandGroup().getChildren().add(Utility.getCommandButton("updateandnext", "更新后继续", "#{tableManager.updateRecordAndNext}", "ui-icon-disk"));
		wdata.getCommandGroup().getChildren().add(Utility.getCommandButton("updateandclose", "更新后关闭", "#{tableManager.updateRecordAndClose}", "ui-icon-check"));

	}

	@Audit
	public void newDataEditClick(ActionEvent event) throws Exception {

		TableData tdata = this.getCurrentTableData();
		
		WindowDefine wd = new WindowDefine();
				
		if (tdata.getNewEditWidth() > 0) {
			wd.setWindowWidth(tdata.getNewEditWidth());
		} else {
			wd.setWindowWidth(tdata.getObjectProperty().getEditWidth());
		}

		if (tdata.getNewEditHeight() > 0) {
			wd.setWindowHeight(tdata.getNewEditHeight());
		} else {
			wd.setWindowHeight(tdata.getObjectProperty().getEditHeight());
		}

		wd.setWindowTitle(tdata.getObjectProperty().getObjectNameCN() + " : 新建");
		if (Utility.notEmptyString(tdata.getNewDataPageURL())) {
			wd.setWindowURL(tdata.getNewDataPageURL());
		} else {
			wd.setWindowURL("/sys/tabledatadialog.jsf");
		}
		wd.setBeforeOpenEL("#{tableManager.initNewTableRecord}");
		
		windowManager.openNewWindow(ConvManager.getCurrentConvId() + "_" + tdata.getTableId() + "_newrecord", 
				tdata, wd, null, true, event.getComponent().findComponent("refreshtable").getClientId(), 20, false);


	}
	
	public void initNewTableRecord() throws Exception {
		WindowData wdata = this.getWindowData();
		TableData tdata = (TableData)this.getWindowData().getInData();
		Object editData = null;

		if (Utility.notEmptyString(tdata.getInitNewDataEL())) {
			editData = Utility.executeMethodExpression(tdata.getInitNewDataEL(), new Class[]{},
					new Object[]{});
		} else {
			editData = Class.forName(tdata.getObjectProperty().getObjectClassName()).newInstance();
		}

		ObjectEditData oed = new ObjectEditData();
		objectEditManager.initObjectEditData(oed, editData, tdata.getSaveNewDataEL(), "", tdata.getObjectProperty().getObjectNameCN() + " : 新建",
				(String)Utility.getELValue((String)Utility.isnull(tdata.getNewReadOnlyColumns(), "")),
				(String)Utility.getELValue((String)Utility.isnull(tdata.getNewHideColumns(), "")));

		oed.setButtonclick(tdata.getTableId());
		wdata.setDefaultObjectEditData(oed);
		wdata.setHasCancelButton(true);

		wdata.getCommandGroup().getChildren().clear();
		wdata.getCommandGroup().getChildren().add(Utility.getCommandButton("save", "保存", "#{tableManager.saveRecord}", "ui-icon-disk"));

	}

	@Audit
	public void deleteRecord(ActionEvent event) throws Exception {

		TableData tdata = this.getCurrentTableData();

		if (tdata.getSelectData() == null) {
			throw new Exception("请选择需要操作的记录!");
		}

		if (Utility.notEmptyString(tdata.getDeleteEL())) {
			Utility.executeMethodExpression(tdata.getDeleteEL(), new Class[]{Object.class}, new Object[]{tdata.getSelectData()});
		} else {
			dbUtility.delete(tdata.getSelectData(), tdata.isRealDelete());
		}

		this.refreshPage(event);

	}

	/**
	 * 新建记录保存
	 */
	@Audit
	public void saveRecord(ActionEvent event) throws Exception {

		ObjectEditData data = this.getWindowData().getDefaultObjectEditData();

		if (Utility.notEmptyString(data.getProcessEL())) {
			Utility.executeMethodExpression(data.getProcessEL(), new Class[]{Object.class},
					new Object[]{data.getEditData()});
		} else {
			dbUtility.save(data.getEditData());
		}

		this.getWindowData().closeWindow();

	}

	@Audit
	public void updateRecordAndNext(ActionEvent event) throws Exception {

		ObjectEditData data = this.getWindowData().getDefaultObjectEditData();

		if (Utility.notEmptyString(data.getProcessEL())) {
			Utility.executeMethodExpression(data.getProcessEL(), new Class[]{Object.class},
					new Object[]{data.getEditData()});
		} else {
			dbUtility.update(data.getEditData());
		}

		DataTableImpl d1 = (DataTableImpl)data.getEditData();
		boolean _hasNext = false;
		List<?> _list = (List<?>)(((TableData)this.getWindowData().getInData()).getTableData().getWrappedData());
		for (int i = 0; i < _list.size(); i++) {
			if (((DataTableImpl)_list.get(i)).getRowKey().equals(d1.getRowKey()) && i < _list.size() - 1 ) {

				TableData tdata = (TableData)this.getWindowData().getInData();
				if (Utility.notEmptyString(tdata.getInitUpdateDataEL())) {
					data.setEditData(Utility.executeMethodExpression(tdata.getInitUpdateDataEL(), new Class[]{Object.class}, new Object[]{_list.get(i + 1)}));
				} else {
					data.setEditData(_list.get(i + 1));
				}

				_hasNext = true;
				break;
			}
		}

		if (_hasNext) {
			Utility.updateComponent("form");
		} else {
			this.getWindowData().closeWindow();
		}

	}

	@Audit
	public void updateRecordAndClose(ActionEvent event) throws Exception {

		ObjectEditData data = this.getWindowData().getDefaultObjectEditData();;

		if (Utility.notEmptyString(data.getProcessEL())) {
			Utility.executeMethodExpression(data.getProcessEL(), new Class[]{Object.class},
					new Object[]{data.getEditData()});
		} else {
			dbUtility.update(data.getEditData());
		}

		this.getWindowData().closeWindow();

	}

	public void fastSearchValueChange(ValueChangeEvent event) throws Exception {

		TableData data = this.getCurrentTableData();
		if (event.getNewValue() == null || "".equals(event.getNewValue().toString().trim())) {
			return;
		}
		data.setFilterArg(new HashMap<String, Object>());
		data.getFilterArg().put("_fs" + data.getFastFilterName(), Utility.likeString((String)event.getNewValue()));
		data.setFilterString(data.getFastFilterName() + " like :" + "_fs" + data.getFastFilterName());
		((HtmlInputText)event.getComponent()).setValue("");
		data.setRealQueryString("");
		this.goFirst(data);

	}

	/**
	 * 导出到Excel
	 * @return
	 */
	public void exportExcel() throws Exception {
		TableData data = this.getCurrentTableData();

		List<?> exportData = null;

		try {
			String _qs = null;
			
			if (data.getRealQueryString().toUpperCase().startsWith("SELECT")) {
				_qs = data.getRealQueryString();
			} else {
				_qs = "select * " + data.getRealQueryString();
			}

			// 查询数据
			exportData = dbUtility.getDataList(
					_qs + " " + Utility.isnull(this.getTableOrderString(data), "")
					, Class.forName(data.getObjectProperty().getObjectClassName()), data.getQueryArgument()
					, 0, TableData.EXPORT_EXCEL_MAX_NUMBER);

			// 查询数据

		} catch (Exception ex) {
			ex.printStackTrace();
			exportData = new ArrayList<Object>();
		}

		try {
	        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

			response.reset();
			response.setContentType("application/msexcel");
			response.setHeader("Content-disposition","attachment;filename=untitled.xlsx");

			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("First Sheet");

			int column = 0;
			int rownum = 0;

			List<TreeMap<Object, String>> _menuList = new ArrayList<TreeMap<Object, String>>();
			TreeMap<Object, String> tm = null;
			Row row = sheet.createRow(rownum);

			for (int col = 0; col < data.getColumnList().size(); col++) {
				if ("SELECTMENU".equals(data.getColumnList().get(col).getShowType())
						&& data.getColumnList().get(col).isVisiabled()) {
					List<SelectItem> _li = sysUtil.getViewObjectFieldSelectList(data.getColumnList().get(col).getDataSource());
					tm = new TreeMap<Object, String>();
					for (SelectItem si : _li) {
						tm.put(si.getValue(), si.getLabel());
					}
					_menuList.add(tm);
				} else {
					_menuList.add(null);
				}

				if (data.getColumnList().get(col).isVisiabled()) {
					row.createCell(column).setCellValue(data.getColumnList().get(col).getFieldNameCN());
					column ++;
				}
			}

			Class<?> _class = null;
			try {
				_class = Class.forName(data.getObjectProperty().getObjectClassName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			List<Method> methodList = new ArrayList<Method>();
			for (int col = 0; col < data.getColumnList().size(); col++) {
				if (data.getColumnList().get(col).isVisiabled()) {
					try {
						String methodName = data.getColumnList().get(col).getFieldName();
						methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1, methodName.length());
						if (data.getColumnList().get(col).getFieldJavaType().equals("boolean")) {
							methodList.add(_class.getMethod("is" + methodName, new Class[]{}));
						} else {
							methodList.add(_class.getMethod("get" + methodName, new Class[]{}));
						}
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				} else {
					methodList.add(null);
				}
			}

	        //导出
			for (int line = 0; line < exportData.size(); line++) {
				rownum = rownum + 1;
				row = sheet.createRow(rownum);
				column = 0;
				for (int col = 0; col < data.getColumnList().size(); col++) {
					if (data.getColumnList().get(col).isVisiabled()) {

						try {
							Object ret = methodList.get(col).invoke(exportData.get(line), new Object[]{});
							if (ret == null) {
								row.createCell(column).setCellValue("");
							} else {
								if (data.getColumnList().get(col).getShowType().equals("NUMBER")) {
									if (ret instanceof Integer) {
										row.createCell(column).setCellValue(new Double((Integer)ret));
									} else if (ret instanceof Long) {
										row.createCell(column).setCellValue(new Double((Long)ret));
									} else {
										row.createCell(column).setCellValue((Double)ret);
									}
								} else if (data.getColumnList().get(col).getShowType().equals("TEXT")) {
									row.createCell(column).setCellValue(ret.toString());
								} else if (data.getColumnList().get(col).getShowType().equals("CHECKBOX")) {
									if (ret instanceof Boolean) {
										if ((Boolean)ret) {
											row.createCell(column).setCellValue(1);
										} else {
											row.createCell(column).setCellValue(0);
										}
									}
								} else if (data.getColumnList().get(col).getShowType().equals("SELECTMENU")) {
									TreeMap<Object, String> _list = _menuList.get(col);
									row.createCell(column).setCellValue(_list.get(ret));
								} else if (data.getColumnList().get(col).getShowType().equals("BIGDECIMAL")) {
									if (ret instanceof BigDecimal) {
										row.createCell(column).setCellValue(((BigDecimal)ret).doubleValue());
									}
								} if (data.getColumnList().get(col).getShowType().equals("DATE")) {
									if (ret instanceof Date) {
										row.createCell(column).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(((Date)ret)));
									}
								} if (data.getColumnList().get(col).getShowType().equals("DATETIME")) {
									if (ret instanceof Date) {
										row.createCell(column).setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(((Date)ret)));
									}
								}
							}
						} catch (Exception ex) {
							ex.printStackTrace();
							row.createCell(column).setCellValue("");
						}
						column++;
					}
				}
			}


			workbook.write(response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();

	}

	@Audit
	public void recordChange(ValueChangeEvent event) throws Exception {
//		if (event.getOldValue() == null && (event.getNewValue() == null || "".equals(event.getNewValue()))) {
//			return;
//		}
//		if (event.getNewValue() instanceof Date) {
//			Date _d1 = (Date)event.getOldValue();
//			Date _d2 = (Date)event.getNewValue();
//			if (_d1.getTime() == _d2.getTime())
//				return;
//		}
//		String _tmp = event.getComponent().getClientId(FacesContext.getCurrentInstance());
//		int _pos = -1;
//		String[] _tmps = _tmp.split(":");
//		try {
//			_pos = Integer.parseInt(_tmps[2]);
//		} catch (Exception ex) {
//
//		}
//		event.getComponent().processUpdates(FacesContext.getCurrentInstance());
//		if (data.getValueChangeEL() != null && !"".equals(data.getValueChangeEL().trim())) {
//			Utility.executeMethodExpression(data.getValueChangeEL(),
//					new Class[]{Object.class}, new Object[]{data.getTableData().get(_pos)});
//		} else {
//			Object _obj = dbUtility.update(data.getTableData().get(_pos), true);
//			data.getTableData().set(_pos, _obj);
//		}
//		this.refreshPage(null);
	}


	public void pageChange(ValueChangeEvent event) throws Exception {
		event.getComponent().processUpdates(FacesContext.getCurrentInstance());
		String tableId = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("tableId");
		TableData data = this.getWindowData().getTableData(tableId);
		this.refreshPage(data);
	}

	@SuppressWarnings("unchecked")
	private void queryData(TableData data) {
		
		try {
			String _cs = "select count(*) " + data.getRealQueryString().substring(data.getRealQueryString().toUpperCase().indexOf("FROM"));
			String _qs = null;
			
			if (data.getRealQueryString().toUpperCase().startsWith("SELECT")) {
				_qs = data.getRealQueryString();
			} else {
				_qs = "select * " + data.getRealQueryString();
			}

			// 记录总数
			data.setRecordCount(dbUtility.getRecordCount(_cs, data.getQueryArgument()));

			// 设置最大页数
			if (data.getRecordCount() % data.getPageRecord() == 0) {
				data.setMaxPage(data.getRecordCount() / data.getPageRecord());
			} else {
				data.setMaxPage(data.getRecordCount() / data.getPageRecord() + 1);
			}

			// 根据新的最大页数确定当前页
			if (data.getCurrentPage() > data.getMaxPage()) {
				data.setCurrentPage(data.getMaxPage());
			}
			if (data.getCurrentPage() < 1) {
				data.setCurrentPage(1);
			}

			// 查询数据
			data.getTableData().setWrappedData((List<Object>)dbUtility.getDataList(
					_qs + " " + Utility.isnull(this.getTableOrderString(data), "")
					, Class.forName(data.getObjectProperty().getObjectClassName()), data.getQueryArgument()
					, (data.getCurrentPage() - 1) * data.getPageRecord(), data.getPageRecord()));


		} catch (Exception ex) {
			ex.printStackTrace();
			data.setRecordCount(0);
			data.setCurrentPage(1);
			data.setMaxPage(1);
			data.getTableData().setWrappedData(new ArrayList<Object>());
		}

	}

//	public List<SelectItem> getFieldMenuList(String tableId, String fieldName) {
//
//		TableData data = windowData.getTableData(tableId);
//
//		List<SelectItem> _list = data.getMenuList().get(fieldName);
//		if (_list != null) {
//			return _list;
//		} else {
//			return new ArrayList<SelectItem>();
//		}
//	}
//
//	public List<SelectItem> getFieldEditMenuList(String tableId, String fieldName) {
//
//		TableData data = windowData.getTableData(tableId);
//
//		List<SelectItem> _list = data.getEditMenuList().get(fieldName);
//		if (_list != null) {
//			return _list;
//		} else {
//			return new ArrayList<SelectItem>();
//		}
//	}

	@Audit
	public void columnHeaderClick(ActionEvent event) throws Exception {
		String tableId = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("tableId");
		TableData data = this.getWindowData().getTableData(tableId);

		for (ViewObjectFieldProperty field : data.getColumnList()) {
			if (event.getComponent().getId().equals(("th" + field.getFieldName()))) {
				if ("".equals(field.getOrderType())) {
					field.setOrderType("▼");
				} else if ("▲".equals(field.getOrderType())) {
					field.setOrderType("");
				} else if ("▼".equals(field.getOrderType())) {
					field.setOrderType("▲");
				}
			} else {
				field.setOrderType("");
			}
		}
		this.refreshPage(data);
	}

	private String getTableOrderString(TableData data) {
		String _ret = data.getOrderString();
		for (ViewObjectFieldProperty field : data.getColumnList()) {
			if (!"".equals(field.getOrderType())) {
				if ("▲".equals(field.getOrderType())) {
					_ret = " order by " + field.getFieldName();
					break;
				} else if ("▼".equals(field.getOrderType())) {
					_ret = "order by " + field.getFieldName() + " desc";
					break;
				}
			}
		}

		return _ret;
	}

	public void setTableReadOnly(String tableId) {

		TableData data = this.getWindowData().getTableData(tableId);
		data.setReadOnly(true);
		for (ViewObjectFieldProperty obj : data.getColumnList()) {
			obj.setRunReadOnly(true);
			obj.setRunEditReadOnly(true);
		}

	}

	@Audit
	public void tableCommandUploadFileClick(ActionEvent event) throws Exception {

		long commandId = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("commandId"));

		WindowCommandDefine comm = dbUtility.getEntity(WindowCommandDefine.class, commandId);
		
		TableData tdata = this.getCurrentTableData();

		if (comm.isSelectRecord()) {
			if (tdata.getSelectData() == null) {
				throw new Exception("请选择需要操作的记录!");
			}
		}

		if (Utility.notEmptyString(comm.getDataProcessEL())) {
			Utility.executeMethodExpression(comm.getDataProcessEL(), new Class[]{Object.class}, new Object[]{tdata.getSelectData()});
		}

		FileUploadData fData = new FileUploadData();
		
		if (comm.isSelectRecord()) {
			fData.setParentData(tdata.getSelectData());
			fData.setParentButtonName(event.getComponent().findComponent("refreshtable").getClientId());
			
		} else {
			fData.setParentData(null);
		}
		if (Utility.notEmptyString(comm.getFileAllowType())) {
			fData.setAllowTypes(comm.getFileButtonType());
		}
		fData.setSizeLimit(comm.getFileLimitSize());
		
		if (Utility.notEmptyString(comm.getFileFileldName())) {
			fData.setFileField(comm.getFileFileldName());
		}
		
		if (Utility.notEmptyString(comm.getFileProcessEL())) {
			fData.setFileUploadProcess(comm.getFileProcessEL());
		} else {
			fData.setFileUploadProcess("#{tableManager.tableCommandUploadFileProcess}");
		}
		
		if (Utility.notEmptyString(comm.getFilePath())) {
			fData.setFileSavePath(comm.getFilePath());
		}
		
		fData.setInvalidFileMessage("无效的文件类型!");
		fData.setInvalidSizeMessage("文件大小不能超过" + (int)Math.floor(fData.getSizeLimit() / 1024) + "K");
		
		if (Utility.notEmptyString(comm.getCommandValueEL())) {
		fData.setLabel((String)Utility.getELValue(comm.getCommandValueEL()));
		} else {
			fData.setLabel("上传文件");
		}
		
		fData.setValidatorMessage("");
		sysUtil.openFileUploadWindow(fData);
		
//		ConvManager.beginConv("UPLOADFILECONV");
//
//		windowData.setWindowTitle("上传文件: " + (String)Utility.getELValue(comm.getCommandValueEL()));
//		windowData.setParentWindowData(parentWindowData);
//
//		// 允许的文件类型
//		if (Utility.notEmptyString(comm.getFileAllowType())) {
//			windowData.getObjMap().put("fileallowtype", comm.getFileAllowType());
//		} else {
//			windowData.getObjMap().put("fileallowtype", "*");
//		}
//
//		// 文件大小限制 K
//		if (comm.getFileLimitSize() <= 0) {
//			windowData.getObjMap().put("filelimitsize", 999999999);
//		} else {
//			windowData.getObjMap().put("filelimitsize", comm.getFileLimitSize() * 1024);
//		}
//
//		// 文件处理方法
//		windowData.getObjMap().put("fileprocessel", comm.getFileProcessEL());
//
//		// 关闭窗口后父窗口按钮名称
//		windowData.getObjMap().put("parentbuttonname", tdata.getTableId() + ":table_refresh");
//
//		// 文件保存位置
//		windowData.getObjMap().put("filepath", comm.getFilePath());
//
//		windowData.getObjMap().put("tablerow", tableRowData);
//
//		windowData.getObjMap().put("field", comm.getFileFileldName());
//
//		Utility.openWindow("/sys/fileupload.jsf?wid=UPLOADFILECONV", "uploadfilewindow", 600, 300);

	}
	
	public void uploadFileChange(ValueChangeListener event) throws Exception {
		System.out.println("upload file change;");
	}

	public void tableCommandUploadFileProcess(FileUploadData fData, UploadedFile uFile) throws Exception {

		if (fData.getParentData() != null) {
			PropertyUtils.setProperty(fData.getParentData(), fData.getFileField(), 
					sysUtil.uploadFile((Long)PropertyUtils.getProperty(fData.getParentData(), fData.getFileField()), 
							(String)Utility.getELValue(fData.getFileSavePath()), 
							uFile));
			dbUtility.update(fData.getParentData());
		}
	}

	@Audit
	public void uploadFileWindowClose(ActionEvent event) throws Exception {
		this.getWindowData().closeWindow();
	}

	@Audit
	public void tableCommandClick(ActionEvent event) throws Exception {

		long commandId = Long.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("commandId"));

		WindowCommandDefine comm = dbUtility.getEntity(WindowCommandDefine.class, commandId);

		TableData tdata = this.getCurrentTableData();
		
		String refreshButtonId = event.getComponent().findComponent("refreshtable").getClientId();

		if (comm.isSelectRecord()) {

			if (tdata.getSelectData() == null) {
				throw new Exception("请选择需要操作的记录!");
			}

		}

		if (Utility.notEmptyString(comm.getDataProcessEL())) {
			if (comm.isSelectRecord()) {
				Utility.executeMethodExpression(comm.getDataProcessEL(), new Class[]{Object.class}, new Object[]{tdata.getSelectData()});
			} else {
				Utility.executeMethodExpression(comm.getDataProcessEL(), new Class[]{Object.class}, new Object[]{tdata});
			}
		}

		// 判断是否开启一个新的会话
		if (Utility.notEmptyString(comm.getNewConvDataProcessEL()) || comm.getWindowId() > 0) {

			if (comm.getWindowId() > 0) {
				if (Utility.notEmptyString((String)Utility.getELValue(comm.getConversationName()))) {
					windowManager.openNewWindow((String)Utility.getELValue(comm.getConversationName()), 
							tdata.getSelectData(), comm.getWindowId(), comm.getNewConvDataProcessEL(), true, refreshButtonId, this.getWindowData().isReadOnly());
				} else {
					windowManager.openNewWindow(ConvManager.getCurrentConvId() + "_cmd_" + commandId, 
							tdata.getSelectData(), comm.getWindowId(), comm.getNewConvDataProcessEL(), true, refreshButtonId, this.getWindowData().isReadOnly());
				}
				
			}

		}

		if (comm.getWindowId() == 0) {
			// 刷新表格
			refreshButtonClick(refreshButtonId);
		}

	}


	public void refreshButtonClick(String buttonId) {
		Utility.executeJavaScript("windowButtonClick('" + buttonId + "');");
	}

	public Object newTableQueryArgDefine() {

		TableQueryArgDefine a = new TableQueryArgDefine();
		TableDefine td = (TableDefine)this.getWindowData().getInData();
		a.setTableId(td.getId());
		return a;

	}

	public Object newTableCommandDefine() {
		WindowCommandDefine comm = new WindowCommandDefine();
		comm.setCommandParentType("TABLE");
		comm.setCommandType("AJAX");
		comm.setParentId(((TableDefine)this.getWindowData().getParentWindowData().getInData()).getId());
		return comm;
	}

	@Audit
	public void largeFieldEdit(ActionEvent event) throws Exception {
		String dialogId = (String)event.getComponent().getAttributes().get("dialogId");
		long largeId = (Long)event.getComponent().getAttributes().get("largeId");
		SysLargeText slt = null;
		if (largeId > 0) {
			slt = dbUtility.getEntity(SysLargeText.class, largeId);
		}
		if (slt == null) {
			slt = new SysLargeText();
		}
		this.getWindowData().getObjMap().put("largeTextEdit", slt);

		Utility.executeJavaScript(dialogId + ".show();");
	}

}
