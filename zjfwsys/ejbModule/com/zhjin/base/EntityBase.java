/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class EntityBase implements Serializable, DataTableImpl {

	@Column(nullable = false)
	private boolean enabled;

	@Version
	private long version;

	public EntityBase() {
		super();
		enabled = true;
	}
	
	public void deleteCheck() throws Exception {}
	public void insertCheck() throws Exception {}
	public void updateCheck() throws Exception {}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	
	
}
