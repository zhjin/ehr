/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;


@Entity
public class SysUploadFile extends EntityHasIdBase {

	@Column(length=120)
	private String fileName;
	
	@Column
	private long fileSize;
	
	@Column(length=150)
	private String contentType;
	
	@Column(length=20)
	private String saveType;
	
	@Column(length=255)
	private String savePath;
	
	@Column(length=80)
	private String fileDiskName;
	
	@Column
	private Date uploadTime;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getSaveType() {
		return saveType;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileDiskName() {
		return fileDiskName;
	}

	public void setFileDiskName(String fileDiskName) {
		this.fileDiskName = fileDiskName;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}
