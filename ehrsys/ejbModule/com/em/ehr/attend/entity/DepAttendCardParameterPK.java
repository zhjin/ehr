/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend.entity;

import java.io.Serializable;

public class DepAttendCardParameterPK  implements Serializable {
	private int depId;
	private int attendCardParameterId;
	
	@Override
	public boolean equals(Object obj) {
		DepAttendCardParameterPK pk = (DepAttendCardParameterPK)obj;
		return pk.getDepId() == this.depId && pk.getAttendCardParameterId() == this.attendCardParameterId;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public int getAttendCardParameterId() {
		return attendCardParameterId;
	}
	public void setAttendCardParameterId(int attendCardParameterId) {
		this.attendCardParameterId = attendCardParameterId;
	}
	
	
}
