/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.organize.entity;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.zhjin.base.TreeEntityBase;
import com.zhjin.util.Utility;

@Entity
public class Department extends TreeEntityBase{

	@Column(length = 40)
	private String depShortName;

	@Column
	private long depLevel;

	@Column
	private long depType;

	@Column
	private long managerEmpId;
	@Column(length=40)
	private String managerLoginName;
	@Column(length=20)
	private String managerName;

	@Column
	private long manager1EmpId;
	@Column(length=40)
	private String manager1LoginName;
	@Column(length=20)
	private String manager1Name;

	@Column
	private long manager2EmpId;
	@Column(length=40)
	private String manager2LoginName;
	@Column(length=20)
	private String manager2Name;

	@Column
	private long manager3EmpId;
	@Column(length=40)
	private String manager3LoginName;
	@Column(length=20)
	private String manager3Name;

	@Column(length = 255)
	private String description;

	@Column
	private Date createDate;

	@Column
	private long createEmpId;

	@Column
	private Date destoryDate;

	@Column
	private long destoryEmpId;

	@Column
	private int descNumber;

	@Column
	private int budNumber;

	public String getDepShortName() {
		return depShortName;
	}

	public void setDepShortName(String depShortName) {
		this.depShortName = depShortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getCreateEmpId() {
		return createEmpId;
	}

	public void setCreateEmpId(long createEmpId) {
		this.createEmpId = createEmpId;
	}

	public Date getDestoryDate() {
		return destoryDate;
	}

	public void setDestoryDate(Date destoryDate) {
		this.destoryDate = destoryDate;
	}

	public long getDestoryEmpId() {
		return destoryEmpId;
	}

	public void setDestoryEmpId(long destoryEmpId) {
		this.destoryEmpId = destoryEmpId;
	}

	public int getDescNumber() {
		return descNumber;
	}

	public void setDescNumber(int descNumber) {
		this.descNumber = descNumber;
	}

	public int getBudNumber() {
		return budNumber;
	}

	public void setBudNumber(int budNumber) {
		this.budNumber = budNumber;
	}

	public long getDepLevel() {
		return depLevel;
	}

	public void setDepLevel(long depLevel) {
		this.depLevel = depLevel;
	}

	public long getDepType() {
		return depType;
	}

	public void setDepType(long depType) {
		this.depType = depType;
	}

	public long getManagerEmpId() {
		return managerEmpId;
	}

	public void setManagerEmpId(long managerEmpId) {
		this.managerEmpId = managerEmpId;
	}

	public long getManager1EmpId() {
		return manager1EmpId;
	}

	public void setManager1EmpId(long manager1EmpId) {
		this.manager1EmpId = manager1EmpId;
	}

	public long getManager2EmpId() {
		return manager2EmpId;
	}

	public void setManager2EmpId(long manager2EmpId) {
		this.manager2EmpId = manager2EmpId;
	}

	public long getManager3EmpId() {
		return manager3EmpId;
	}

	public void setManager3EmpId(long manager3EmpId) {
		this.manager3EmpId = manager3EmpId;
	}

	@Transient
	public int getDepartmentEmployeeCount() {
		return 0;
	}

	@Override
	public void insertCheck() throws Exception {
		if (this.getHighId() == 0) {
			throw new Exception("请选择上级部门!");
		}

		if (this.getLabel() == null || "".equals(this.getLabel().trim())) {
			throw new Exception("请输入部门名称!");
		}
	}

	public String getManagerLoginName() {
		return managerLoginName;
	}

	public void setManagerLoginName(String managerLoginName) {
		this.managerLoginName = managerLoginName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManager1LoginName() {
		return manager1LoginName;
	}

	public void setManager1LoginName(String manager1LoginName) {
		this.manager1LoginName = manager1LoginName;
	}

	public String getManager1Name() {
		return manager1Name;
	}

	public void setManager1Name(String manager1Name) {
		this.manager1Name = manager1Name;
	}

	public String getManager2LoginName() {
		return manager2LoginName;
	}

	public void setManager2LoginName(String manager2LoginName) {
		this.manager2LoginName = manager2LoginName;
	}

	public String getManager2Name() {
		return manager2Name;
	}

	public void setManager2Name(String manager2Name) {
		this.manager2Name = manager2Name;
	}

	public String getManager3LoginName() {
		return manager3LoginName;
	}

	public void setManager3LoginName(String manager3LoginName) {
		this.manager3LoginName = manager3LoginName;
	}

	public String getManager3Name() {
		return manager3Name;
	}

	public void setManager3Name(String manager3Name) {
		this.manager3Name = manager3Name;
	}

	@Override
	public void deleteCheck() throws Exception {
		HashMap<String, Object> arg = new HashMap<String, Object>();
		arg.put("depId", this.getId());

		if (Utility.getDBUtility().exists("select * from job where depid = :depId and enabled = 1", arg)) {
			throw new Exception("部门(" + this.getLabel() + ")内存在岗位，不能撤销!");
		}

		if (getDepartmentEmployeeCount() > 0) {
			throw new Exception("部门(" + this.getLabel() + ")内存在在职员工，不能撤销!");
		}
	}
}
