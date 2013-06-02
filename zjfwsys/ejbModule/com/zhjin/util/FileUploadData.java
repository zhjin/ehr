/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import java.io.Serializable;

public class FileUploadData implements Serializable {

	private String fileUploadProcess;
	
	private int sizeLimit;
	
	private String allowTypes;
	
	private String fileSavePath;
	
	private String parentButtonName;
	
	private String validatorMessage;
	
	private String label;
	
	private String invalidSizeMessage;
	
	private String invalidFileMessage;
	
	private Object parentData;
	
	private String fileField;

	public String getFileUploadProcess() {
		return fileUploadProcess;
	}

	public void setFileUploadProcess(String fileUploadProcess) {
		this.fileUploadProcess = fileUploadProcess;
	}

	public int getSizeLimit() {
		return sizeLimit;
	}

	public void setSizeLimit(int sizeLimit) {
		this.sizeLimit = sizeLimit;
	}

	public String getAllowTypes() {
		return allowTypes;
	}

	public void setAllowTypes(String allowTypes) {
		this.allowTypes = allowTypes;
	}

	public String getParentButtonName() {
		return parentButtonName;
	}

	public void setParentButtonName(String parentButtonName) {
		this.parentButtonName = parentButtonName;
	}

	public String getValidatorMessage() {
		return validatorMessage;
	}

	public void setValidatorMessage(String validatorMessage) {
		this.validatorMessage = validatorMessage;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getInvalidSizeMessage() {
		return invalidSizeMessage;
	}

	public void setInvalidSizeMessage(String invalidSizeMessage) {
		this.invalidSizeMessage = invalidSizeMessage;
	}

	public String getInvalidFileMessage() {
		return invalidFileMessage;
	}

	public void setInvalidFileMessage(String invalidFileMessage) {
		this.invalidFileMessage = invalidFileMessage;
	}

	public Object getParentData() {
		return parentData;
	}

	public void setParentData(Object parentData) {
		this.parentData = parentData;
	}

	public String getFileField() {
		return fileField;
	}

	public void setFileField(String fileField) {
		this.fileField = fileField;
	}

	public String getFileSavePath() {
		return fileSavePath;
	}

	public void setFileSavePath(String fileSavePath) {
		this.fileSavePath = fileSavePath;
	}
	
}
