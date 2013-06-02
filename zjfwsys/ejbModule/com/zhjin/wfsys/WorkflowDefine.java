/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.wfsys;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class WorkflowDefine extends EntityHasIdBase {

	@Column(length=40)
	private String deployId;

	@Column(length=60)
	private String defineId;

	@Column(length=60)
	private String wfName;

	@Column(length=60)
	private String wfKey;

	@Column(length=60)
	private String wfNameCN;

	@Column
	private boolean visiabled;

	@Column(length=100)
	private String visiableEL;

	@Column(length=120)
	private String variableObjectName;

	@Column(length=255)
	private String remark;

	@Column(length=20)
	private String wfType;

	@Column
	private int indexNo;

	@Column
	private boolean alwaysHave;

	@Column(length=80)
	private String alwaysHaveEL;

	@Column(length=1000)
	private String empQueryString;

	@Column
	private boolean empSelected;

	@Column(length=60)
	private String empSelectCommandEL;

	@Column(length=1000)
	private String empSelectQueryString;

	@Column(length=120)
	private String empSelectEL;

	@Column
	private long fileId;

	@Column
	private long wfImageId;

	@Column
	private int imageWidth;

	@Column
	private int imageHeight;

	@Column
	private boolean attachFile;

	@Column(length=120)
	private String url;

	@Column(length=80)
	private String objectName;

	@Column
	private long tableId;

	@Column(length=120)
	private String relationship;

	@Column
	private int width;

	@Column
	private int height;

	@Column
	private long dataShow;

	public String getDeployId() {
		return deployId;
	}

	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}

	public String getWfName() {
		return wfName;
	}

	public void setWfName(String wfName) {
		this.wfName = wfName;
	}

	public String getWfKey() {
		return wfKey;
	}

	public void setWfKey(String wfKey) {
		this.wfKey = wfKey;
	}

	public String getWfNameCN() {
		return wfNameCN;
	}

	public void setWfNameCN(String wfNameCN) {
		this.wfNameCN = wfNameCN;
	}

	public boolean isVisiabled() {
		return visiabled;
	}

	public void setVisiabled(boolean visiabled) {
		this.visiabled = visiabled;
	}

	public String getVisiableEL() {
		return visiableEL;
	}

	public void setVisiableEL(String visiableEL) {
		this.visiableEL = visiableEL;
	}

	public String getVariableObjectName() {
		return variableObjectName;
	}

	public void setVariableObjectName(String variableObjectName) {
		this.variableObjectName = variableObjectName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWfType() {
		return wfType;
	}

	public void setWfType(String wfType) {
		this.wfType = wfType;
	}

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public boolean isAlwaysHave() {
		return alwaysHave;
	}

	public void setAlwaysHave(boolean alwaysHave) {
		this.alwaysHave = alwaysHave;
	}

	public String getAlwaysHaveEL() {
		return alwaysHaveEL;
	}

	public void setAlwaysHaveEL(String alwaysHaveEL) {
		this.alwaysHaveEL = alwaysHaveEL;
	}

	public String getEmpQueryString() {
		return empQueryString;
	}

	public void setEmpQueryString(String empQueryString) {
		this.empQueryString = empQueryString;
	}

	public boolean isEmpSelected() {
		return empSelected;
	}

	public void setEmpSelected(boolean empSelected) {
		this.empSelected = empSelected;
	}

	public String getEmpSelectCommandEL() {
		return empSelectCommandEL;
	}

	public void setEmpSelectCommandEL(String empSelectCommandEL) {
		this.empSelectCommandEL = empSelectCommandEL;
	}

	public String getEmpSelectQueryString() {
		return empSelectQueryString;
	}

	public void setEmpSelectQueryString(String empSelectQueryString) {
		this.empSelectQueryString = empSelectQueryString;
	}

	public String getEmpSelectEL() {
		return empSelectEL;
	}

	public void setEmpSelectEL(String empSelectEL) {
		this.empSelectEL = empSelectEL;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public long getWfImageId() {
		return wfImageId;
	}

	public void setWfImageId(long wfImageId) {
		this.wfImageId = wfImageId;
	}

	public boolean isAttachFile() {
		return attachFile;
	}

	public void setAttachFile(boolean attachFile) {
		this.attachFile = attachFile;
	}

	public String getDefineId() {
		return defineId;
	}

	public void setDefineId(String defineId) {
		this.defineId = defineId;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getDataShow() {
		return dataShow;
	}

	public void setDataShow(long dataShow) {
		this.dataShow = dataShow;
	}
}
