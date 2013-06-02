/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.zhjin.base.EntityBase;

@Entity
public class EmployeePersonList extends EntityBase {

	@Id
	@Column(length=80)
	private String objectName;
	
	@Column(length=60)
	private String objectNameCN;
	
	@Column
	private long tableId;
	
	@Column
	private int indexNo;
	
	@Override
	public String getRowKey() {
		return this.objectName;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public String getObjectNameCN() {
		return objectNameCN;
	}

	public void setObjectNameCN(String objectNameCN) {
		this.objectNameCN = objectNameCN;
	}

	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}

}
