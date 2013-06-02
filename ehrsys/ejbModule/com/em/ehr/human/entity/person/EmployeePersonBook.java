/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeePersonBook extends EmployeePersonBaseEntity {
	
	@Column
	private Date bookDate;
	
	@Column(length=100)
	private String bookName;
	
	@Column(length=120)
	private String issue;
	
	@Column(length=120)
	private String publicOrg;
	
	@Column(length=100)
	private String publicMedia;
	
	@Column(length=120)
	private String bookNo;

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getPublicOrg() {
		return publicOrg;
	}

	public void setPublicOrg(String publicOrg) {
		this.publicOrg = publicOrg;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublicMedia() {
		return publicMedia;
	}

	public void setPublicMedia(String publicMedia) {
		this.publicMedia = publicMedia;
	}
}
