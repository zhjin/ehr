/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonBookmaking extends EmployeePersonBaseEntity {
	@Column(length=100)
	private String bookmaking;
	
	@Column(length=100)
	private String depname;
	
	@Column(length=100)
	private String article;
	
	@Column(length=100)
	private String publication;
	
	@Column
	private Date bookTime;
	
	@Column(length=20)
	private String finishType;

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getBookmaking() {
		return bookmaking;
	}

	public void setBookmaking(String bookmaking) {
		this.bookmaking = bookmaking;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public String getFinishType() {
		return finishType;
	}

	public void setFinishType(String finishType) {
		this.finishType = finishType;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}
}
