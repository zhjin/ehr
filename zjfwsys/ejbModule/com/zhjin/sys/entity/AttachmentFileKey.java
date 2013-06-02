/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.entity;

import java.io.Serializable;

public class AttachmentFileKey implements Serializable {
	
	private long attachmentId;
	private long uploadFileId;
	
	public AttachmentFileKey() {
	}
	
	public AttachmentFileKey(int attachmentId, int uploadFileId) {
		super();
		this.attachmentId = attachmentId;
		this.uploadFileId = uploadFileId;
	}

	@Override
	public boolean equals(Object obj) {
		AttachmentFileKey key = (AttachmentFileKey)obj;
		return this.attachmentId == key.getAttachmentId() && this.uploadFileId == key.getUploadFileId();
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

	
}
