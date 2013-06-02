/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.manager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.zhjin.sys.entity.ObjectEditDefine;
import com.zhjin.sys.entity.ViewObjectFieldProperty;
import com.zhjin.sys.entity.ViewObjectProperty;
import com.zhjin.sys.window.WindowData;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.EuserSelect;
import com.zhjin.util.SysUtil;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class DialogManager
 */
@Named
@Stateless
@LocalBean
public class ObjectEditManager extends BeanBase {

	@EJB
	private SysUtil sysUtil;

    /**
     * Default constructor.
     */
    public ObjectEditManager() {

    }

    public ObjectEditData initObjectEditData(Object obj, long editId) throws Exception {

    	ObjectEditDefine oedefine = dbUtility.getEntity(ObjectEditDefine.class, editId);
    	if (oedefine == null) {
    		throw new Exception("编辑对象不存在!");
    	}

    	ObjectEditData oed = initObjectEditData(new ObjectEditData(), obj, oedefine.getDataProcessEL(), oedefine.getDataProcessCommandValue(),
    			oedefine.getEditTitle(), oedefine.getReadOnlyColumns(), oedefine.getHideColumns());

    	return oed;
    }

    public ObjectEditData initObjectEditData(Object obj, String processEL, String processCommandValue, String title, String readOnlyColumns, String hideColumns) throws Exception {
    	return initObjectEditData(new ObjectEditData(), obj, processEL, processCommandValue, title, readOnlyColumns, hideColumns);
    }

    public ObjectEditData initObjectEditData(ObjectEditData oed, Object obj, String processEL, String processCommandValue, String title, String readOnlyColumns, String hideColumns) throws Exception {

    	oed.setHideColumns((String)Utility.getELValue(hideColumns));
    	oed.setReadOnlyColumns((String)Utility.getELValue(readOnlyColumns));
    	oed.setProcessEL(processEL);
    	oed.setProcessCommandValue((String)Utility.getELValue(processCommandValue));

    	if (!Utility.notEmptyString(title)) {
    		oed.setEditTitle((String)Utility.getELValue(title));
    	}
    	oed.setViewObjectProperty(dbUtility.getEntity(ViewObjectProperty.class, obj.getClass().getSimpleName()));
    	oed.setHideColumnsTree(Utility.initColumnsTree(oed.getHideColumns()));
    	oed.setReadOnlyColumnsTree(Utility.initColumnsTree(oed.getReadOnlyColumns()));

    	oed.setFieldList(dbUtility.getDataList(
				"select * from viewobjectfieldproperty where objectname = :objectName and visiabled = 1 order by indexno",
				ViewObjectFieldProperty.class, new ArgMap().add("objectName", obj.getClass().getSimpleName())));

		// 设置只读数据列
		// 主键和版本控制字段为只读
		Class<?> _class = obj.getClass();
		Field[] _fields = null;

		TreeSet<String> _idSet = new TreeSet<String>();
		while (!_class.equals(Object.class)) {
			_fields = _class.getDeclaredFields();
			for (Field f : _fields) {
				if (f.isAnnotationPresent(Id.class) && f.isAnnotationPresent(GeneratedValue.class)) {
					_idSet.add(f.getName().toUpperCase());
				}
			}
			_class = _class.getSuperclass();
		}

		for (ViewObjectFieldProperty field : oed.getFieldList()) {

			// 如果是主键字段或者是版本控制字段则设置成只读
			field.setRunReadOnly(field.isReadOnly() || oed.getReadOnlyColumnsTree().contains(field.getFieldName().toUpperCase())
					|| _idSet.contains(field.getFieldName().toUpperCase()));
			field.setRunVisiabled(field.isVisiabled() && !oed.getHideColumnsTree().contains(field.getFieldName().toUpperCase()));
		}

		oed.setSelectUserTree(new TreeMap<String, EuserSelect>());
		List<ViewObjectFieldProperty> _visiabledFieldList = new ArrayList<ViewObjectFieldProperty>();
		for (ViewObjectFieldProperty field : oed.getFieldList()) {
			if (field.isRunVisiabled()) {
				_visiabledFieldList.add(field);
				
				if (field.getShowType().equals("SELECTUSER")) {
					oed.getSelectUserTree().put(field.getFieldName(), new EuserSelect());
				}
			}
		}

		oed.setFieldList(_visiabledFieldList);

		oed.setMenuList(new TreeMap<String, List<SelectItem>>());
		oed.setEditMenuList(new TreeMap<String, List<SelectItem>>());
		sysUtil.initMenuList(oed.getFieldList(), oed.getMenuList(), oed.getEditMenuList());
		oed.setEditData(obj);
		return oed;

    }

    @Audit
    public void okProcess(ActionEvent event) throws Exception {
    	ObjectEditData oed = this.getWindowData().getDefaultObjectEditData();
    	if (Utility.notEmptyString(oed.getProcessEL())) {
    		Utility.executeMethodExpression(oed.getProcessEL(), new Class[]{Object.class}, new Object[]{oed.getEditData()});
    	} else {
    		oed.setEditData(dbUtility.update(oed.getEditData()));
    	}
    	this.getWindowData().closeWindow();
    }

	public List<SelectItem> getFieldMenuList(String fieldName) {
		return null;
	}

}
