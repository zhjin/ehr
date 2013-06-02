/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.wfsys;

import com.zhjin.base.EntityHasIdBase;
import com.zhjin.sys.entity.ViewObjectProperty;
import com.zhjin.sys.manager.ObjectEditData;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Utility;

public class WFObjectData extends WFDataBase {

	private ObjectEditData objectData;

	private String objectName;

	public WFObjectData() {
		super();
		objectData = new ObjectEditData();
	}

	public ObjectEditData getObjectData() {
		return objectData;
	}

	public void setObjectData(ObjectEditData objectData) {
		this.objectData = objectData;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	@Override
	public void dataProcess() throws Exception {

	}

	@Override
	public void loadData(long dataId) throws Exception {
		ViewObjectProperty vop = Utility.getDBUtility().getEntity(ViewObjectProperty.class, this.getObjectName());
		this.getObjectData().setEditData(Utility.getDBUtility().getEntity("select * from " + this.getObjectName() + " where id = :id",
				Class.forName(vop.getObjectClassName()), new ArgMap().add("id", dataId)));
	}

	@Override
	public void saveData() throws Exception {
		this.getObjectData().setEditData(Utility.getDBUtility().update(this.getObjectData().getEditData(), true));
	}

	@Override
	public void initWFDataComponent() throws Exception {

       	WFNodeProperty nodeProperty = Utility.getDBUtility().getEntity("select * from wfnodeproperty where wfid = :wfId and nodeid = :nodeId",
       			WFNodeProperty.class,
       			new ArgMap().add("wfId", Utility.getDBUtility().getEntity(WFInstance.class, this.getWfInstanceId()).getWfId())
       			.add("nodeId", this.getNodeId()));
       	Utility.getObjectEditManager().initObjectEditData(this.getObjectData(), this.getObjectData().getEditData(), "", "", "Title",
       			nodeProperty.getReadOnlyColumns(), nodeProperty.getHideColumns());
	}

	@Override
	public void initData(Object obj) throws Exception {
		ViewObjectProperty vop = Utility.getDBUtility().getEntity(ViewObjectProperty.class, this.getObjectName());
		this.getObjectData().setEditData(Class.forName(vop.getObjectClassName()).newInstance());
	}

	@Override
	public long getDataId() {
		return ((EntityHasIdBase)this.getObjectData().getEditData()).getId();
	}

}
