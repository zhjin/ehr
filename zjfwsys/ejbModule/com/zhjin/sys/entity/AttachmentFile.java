/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.zhjin.base.EntityBase;

@Entity
@IdClass(value = AttachmentFileKey.class)
public class AttachmentFile extends EntityBase {
	
	@Id
	private long attachmentId;
	
	@Id
	private long uploadFileId;

	public AttachmentFile() {
	}

	public AttachmentFile(long attachmentId, long uploadFileId) {
		this.attachmentId = attachmentId;
		this.uploadFileId = uploadFileId;
	}

	public long getAttachmentId() {
		return attachmentId;
	}
	
	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public long getUploadFileId() {
		return uploadFileId;
	}

	public void setUploadFileId(long uploadFileId) {
		this.uploadFileId = uploadFileId;
	}

	@Override
	public String getRowKey() {
		return null;
	}

}
