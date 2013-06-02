/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author zhjin
 *	用户登录后保存在session基类
 */
public class User implements Serializable {

	/**
	 * 用户标识
	 */
	private long userId;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 登录密码
	 */
	private String password;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 是否已经登录系统并通过验证
	 */
	private boolean hasLogin;

	/**
	 * 成功登录系统时间
	 */
	private Date loginTime;

	private boolean canOperate;

	private long operOrgId1;

	private long operOrgId2;

	private long operOrgId3;

	private long operOrgId4;

	private long operOrgId5;

	private long operOrgId6;

	private long operOrgId7;

	private long operOrgId8;

	private long operOrgId9;

	private long operOrgId10;

	private Object userData;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHasLogin() {
		return hasLogin;
	}

	public void setHasLogin(boolean hasLogin) {
		this.hasLogin = hasLogin;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public boolean isCanOperate() {
		return canOperate;
	}

	public void setCanOperate(boolean canOperate) {
		this.canOperate = canOperate;
	}

	public long getOperOrgId1() {
		return operOrgId1;
	}

	public void setOperOrgId1(long operOrgId1) {
		this.operOrgId1 = operOrgId1;
	}

	public long getOperOrgId2() {
		return operOrgId2;
	}

	public void setOperOrgId2(long operOrgId2) {
		this.operOrgId2 = operOrgId2;
	}

	public long getOperOrgId3() {
		return operOrgId3;
	}

	public void setOperOrgId3(long operOrgId3) {
		this.operOrgId3 = operOrgId3;
	}

	public long getOperOrgId4() {
		return operOrgId4;
	}

	public void setOperOrgId4(long operOrgId4) {
		this.operOrgId4 = operOrgId4;
	}

	public long getOperOrgId5() {
		return operOrgId5;
	}

	public void setOperOrgId5(long operOrgId5) {
		this.operOrgId5 = operOrgId5;
	}

	public long getOperOrgId6() {
		return operOrgId6;
	}

	public void setOperOrgId6(long operOrgId6) {
		this.operOrgId6 = operOrgId6;
	}

	public long getOperOrgId7() {
		return operOrgId7;
	}

	public void setOperOrgId7(long operOrgId7) {
		this.operOrgId7 = operOrgId7;
	}

	public long getOperOrgId8() {
		return operOrgId8;
	}

	public void setOperOrgId8(long operOrgId8) {
		this.operOrgId8 = operOrgId8;
	}

	public long getOperOrgId9() {
		return operOrgId9;
	}

	public void setOperOrgId9(long operOrgId9) {
		this.operOrgId9 = operOrgId9;
	}

	public long getOperOrgId10() {
		return operOrgId10;
	}

	public void setOperOrgId10(long operOrgId10) {
		this.operOrgId10 = operOrgId10;
	}

	public Object getUserData() {
		return userData;
	}

	public void setUserData(Object userData) {
		this.userData = userData;
	}

}
