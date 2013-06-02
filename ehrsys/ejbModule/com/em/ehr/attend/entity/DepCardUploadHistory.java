/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.entity.OperateDataBase;
import com.zhjin.util.FileField;

@Entity
public class DepCardUploadHistory extends OperateDataBase {

	@Column
	private long cardDepId;
	
	@Column
	@FileField
	private long fileId;

	public long getCardDepId() {
		return cardDepId;
	}

	public void setCardDepId(long cardDepId) {
		this.cardDepId = cardDepId;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	
}
