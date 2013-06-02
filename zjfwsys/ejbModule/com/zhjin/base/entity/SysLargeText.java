/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class SysLargeText extends EntityHasIdBase {

	@Lob
	private String textContent;

	@Column(length=200)
	private String remark;

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
