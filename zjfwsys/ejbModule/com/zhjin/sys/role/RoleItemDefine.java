/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.sys.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.zhjin.base.EntityBase;

@Entity
@IdClass(value=RoleItemPK.class)
public class RoleItemDefine extends EntityBase {
	
	@Id
	@Column
	private long roleId;
	
	@Id
	@Column
	private long menuId;

	@Column(length=80)
	private String roleItemName;
	
	@Column
	private boolean visiabled;
	
	@Column(length=120)
	private String visiableEL;
	
	@Column(length=120)
	private String enabledEL;
	
	@Column
	private long r1;
	
	@Column
	private long r2;
	
	@Column
	private long r3;
	
	@Column
	private long r4;
	
	@Column
	private long r5;
	
	@Column
	private long r6;
	
	@Column
	private long r7;
	
	@Column
	private long r8;
	
	@Column
	private long r9;
	
	@Column
	private long r10;
	
	@Column(length=60)
	private String role1;
	
	@Column(length=60)
	private String role2;
	
	@Column(length=60)
	private String role3;
	
	@Column(length=60)
	private String role4;
	
	@Column(length=60)
	private String role5;
	
	@Column(length=60)
	private String role6;
	
	@Column(length=60)
	private String role7;
	
	@Column(length=60)
	private String role8;
	
	@Column(length=60)
	private String role9;
	
	@Column(length=60)
	private String role10;
	
	@Column(length=120)
	private String remark;
	
	@Override
	public String getRowKey() {
		return this.roleId + ":" + this.menuId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public String getRoleItemName() {
		return roleItemName;
	}

	public void setRoleItemName(String roleItemName) {
		this.roleItemName = roleItemName;
	}

	public long getR1() {
		return r1;
	}

	public void setR1(long r1) {
		this.r1 = r1;
	}

	public long getR2() {
		return r2;
	}

	public void setR2(long r2) {
		this.r2 = r2;
	}

	public long getR3() {
		return r3;
	}

	public void setR3(long r3) {
		this.r3 = r3;
	}

	public long getR4() {
		return r4;
	}

	public void setR4(long r4) {
		this.r4 = r4;
	}

	public long getR5() {
		return r5;
	}

	public void setR5(long r5) {
		this.r5 = r5;
	}

	public long getR6() {
		return r6;
	}

	public void setR6(long r6) {
		this.r6 = r6;
	}

	public long getR7() {
		return r7;
	}

	public void setR7(long r7) {
		this.r7 = r7;
	}

	public long getR8() {
		return r8;
	}

	public void setR8(long r8) {
		this.r8 = r8;
	}

	public long getR9() {
		return r9;
	}

	public void setR9(long r9) {
		this.r9 = r9;
	}

	public long getR10() {
		return r10;
	}

	public void setR10(long r10) {
		this.r10 = r10;
	}

	public String getRole1() {
		return role1;
	}

	public void setRole1(String role1) {
		this.role1 = role1;
	}

	public String getRole2() {
		return role2;
	}

	public void setRole2(String role2) {
		this.role2 = role2;
	}

	public String getRole3() {
		return role3;
	}

	public void setRole3(String role3) {
		this.role3 = role3;
	}

	public String getRole4() {
		return role4;
	}

	public void setRole4(String role4) {
		this.role4 = role4;
	}

	public String getRole5() {
		return role5;
	}

	public void setRole5(String role5) {
		this.role5 = role5;
	}

	public String getRole6() {
		return role6;
	}

	public void setRole6(String role6) {
		this.role6 = role6;
	}

	public String getRole7() {
		return role7;
	}

	public void setRole7(String role7) {
		this.role7 = role7;
	}

	public String getRole8() {
		return role8;
	}

	public void setRole8(String role8) {
		this.role8 = role8;
	}

	public String getRole9() {
		return role9;
	}

	public void setRole9(String role9) {
		this.role9 = role9;
	}

	public String getRole10() {
		return role10;
	}

	public void setRole10(String role10) {
		this.role10 = role10;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVisiableEL() {
		return visiableEL;
	}

	public void setVisiableEL(String visiableEL) {
		this.visiableEL = visiableEL;
	}

	public String getEnabledEL() {
		return enabledEL;
	}

	public void setEnabledEL(String enabledEL) {
		this.enabledEL = enabledEL;
	}

	public boolean isVisiabled() {
		return visiabled;
	}

	public void setVisiabled(boolean visiabled) {
		this.visiabled = visiabled;
	}

}
