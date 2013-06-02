/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity.person;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.util.FileField;

@Entity
public class EmployeePersonArchive extends EmployeePersonBaseEntity {
	
	@Column(length=120)
	private String archiveName;
	
	@Column
	@FileField
	private long archiveId;

	public String getArchiveName() {
		return archiveName;
	}

	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}

	public long getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(long archiveId) {
		this.archiveId = archiveId;
	}

}
