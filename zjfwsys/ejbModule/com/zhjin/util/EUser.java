/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.zhjin.base.EntityHasIdBase;

@Entity
public class EUser extends EntityHasIdBase {

	@Column(length=80, unique=true)
	private String loginName;

	@Column(length=40)
	private String name;

	@Column(length=60)
	private String password;
	
	@Column
	private long depId;

	@Column
	private Date registerDate;

	@Column
	private Date validDate;

	@Column
	private boolean locked;

	@Column
	private boolean forceChangePass;

	@Column
	private long u1;

	@Column
	private long u2;

	@Column
	private long u3;

	@Column
	private long u4;

	@Column
	private long u5;

	@Column(length=80)
	private String u6;

	@Column(length=80)
	private String u7;

	@Column(length=80)
	private String u8;

	@Column(length=80)
	private String u9;

	@Column(length=80)
	private String u10;

	@Column(length=120)
	private String remark;

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isForceChangePass() {
		return forceChangePass;
	}

	public void setForceChangePass(boolean forceChangePass) {
		this.forceChangePass = forceChangePass;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getU1() {
		return u1;
	}

	public void setU1(long u1) {
		this.u1 = u1;
	}

	public long getU2() {
		return u2;
	}

	public void setU2(long u2) {
		this.u2 = u2;
	}

	public long getU3() {
		return u3;
	}

	public void setU3(long u3) {
		this.u3 = u3;
	}

	public long getU4() {
		return u4;
	}

	public void setU4(long u4) {
		this.u4 = u4;
	}

	public long getU5() {
		return u5;
	}

	public void setU5(long u5) {
		this.u5 = u5;
	}

	public String getU6() {
		return u6;
	}

	public void setU6(String u6) {
		this.u6 = u6;
	}

	public String getU7() {
		return u7;
	}

	public void setU7(String u7) {
		this.u7 = u7;
	}

	public String getU8() {
		return u8;
	}

	public void setU8(String u8) {
		this.u8 = u8;
	}

	public String getU9() {
		return u9;
	}

	public void setU9(String u9) {
		this.u9 = u9;
	}

	public String getU10() {
		return u10;
	}

	public void setU10(String u10) {
		this.u10 = u10;
	}

}
