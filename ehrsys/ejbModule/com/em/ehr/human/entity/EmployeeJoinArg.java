/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.em.ehr.organize.entity.Job;
import com.zhjin.base.entity.OperateDataBase;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Utility;


@Entity
public class EmployeeJoinArg extends OperateDataBase {

	/**
	 * 口令
	 */
	@Column(length = 40)
	private String password;


	/**
	 * 岗位
	 */
	@Column
	private long jobId;

	/**
	 * 职务
	 */
	@Column
	private long position;
	
	/**
	 * 职务类型
	 */
	@Column
	private long positionType;
	
	/**
	 * 职务级别
	 */
	@Column
	private long positionLevel;
	
	@Column
	private long country;
	
	/**
	 * 地区
	 */
	@Column
	private long area;

	/**
	 * 公司
	 */
	@Column
	private long company;

	/**
	 * 性别
	 */
	@Column
	private long sex;

	/**
	 * 学历
	 */
	@Column
	private long degree;

	/**
	 * 报到日期
	 */
	@Column
	private Date joinDate;

	/**
	 * 试用期
	 */
	@Column
	private int probationNumber;

	/**
	 * 转正日期
	 */
	@Column
	private Date changeNormalDate;

	/**
	 * 员工状态
	 */
	@Column
	private long empStatus;

	/**
	 * 身份证
	 */
	@Column(length = 20)
	private String empCode;

	/**
	 * 员工类型
	 */
	@Column
	private long empType;
	
	/**
	 * 户口
	 */
	@Column
	private long residence;
	
	@Column
	private long channel;
	
	@Column
	private long guideEmpId;
	
	@Column(length=40)
	private String guideLoginName;
	
	@Column(length=20)
	private String guideName;
	
	@Column(length=20)
	private String badge;


	@Override
	public void insertCheck() throws Exception{

		if (!Utility.notEmptyString(this.getName())) {
			throw new Exception("员工姓名不能为空");
		}

		if (!Utility.notEmptyString(this.getLoginName())) {
			throw new Exception("登录名不能为空");
		}

		this.setLoginName(this.getLoginName().trim());
		this.setName(this.getName().trim());
		
		if (Utility.getDBUtility().exists(
				"select * from euser where loginName = :loginName", new ArgMap().add("loginName", this.getLoginName()))) {
			throw new Exception(this.getLoginName() + " 登录名已存在,请重新输入");
		}

		if (Utility.notEmptyString(this.empCode) && this.empCode.length() >= 6) {
			if (Utility.getDBUtility().exists(
					"select * from employeeinfo where code = :code", new ArgMap().add("code", this.getEmpCode()))) {
				throw new Exception(this.getEmpCode() + " 身份证号码已存在,请重新输入");
			}
		} else {
			throw new Exception("身份证号码错误!");
		}
		
		if (this.getDepId() == 0) {
			throw new Exception("部门不能为空");
		}
		
		if (sex == 0) {
			throw new Exception("性别不能为空");
		}

		if (this.empStatus == 0) {
			throw new Exception("员工状态不能为空");
		}

		if (this.empType == 0) {
			throw new Exception("员工类型不能为空");
		}

		if (joinDate == null) {
			throw new Exception("入司日期不能为空");
		}

		EmpStatusCode statusCode = Utility.getDBUtility().getEntity(EmpStatusCode.class, this.getEmpStatus());
		if ("PROB".equals(statusCode.getStrId())) {
			// 试用			
			if (this.getProbationNumber() == 0 ) {
				throw new Exception("请输入试用期!");
			}
		} else if ("NORM".equals(statusCode.getStrId())) {
			// 正常员工
			if (this.probationNumber > 0) {
				throw new Exception("试用期错误!");
			}
		}

		if (this.changeNormalDate == null) {
			throw new Exception("转正日期不能为空");
		}
		
		if (this.jobId > 0) {
			Job _job = Utility.getDBUtility().getEntity(Job.class, this.jobId);
			if (_job != null) {
				if (_job.getBudNumber() > 0) {
					HashMap<String, Object> arg = new HashMap<String, Object>();
					arg.put("jobId", this.jobId);
					arg.put("empId", this.getEmpId());
					int _jobNum = Utility.getDBUtility().getRecordCount(
							"select count(*) from employeeactiveview where (jobid = :jobId) and (id != :empId)", arg);
					if (_jobNum  >= _job.getBudNumber()) {
						throw new Exception("在岗(" + _job.getLabel() + ")员工数超过预设标准！");
					}
				}
			}
		}

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	
	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public long getPositionType() {
		return positionType;
	}

	public void setPositionType(long positionType) {
		this.positionType = positionType;
	}

	public long getPositionLevel() {
		return positionLevel;
	}

	public void setPositionLevel(long positionLevel) {
		this.positionLevel = positionLevel;
	}

	public long getCountry() {
		return country;
	}

	public void setCountry(long country) {
		this.country = country;
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	public long getCompany() {
		return company;
	}

	public void setCompany(long company) {
		this.company = company;
	}

	public long getSex() {
		return sex;
	}

	public void setSex(long sex) {
		this.sex = sex;
	}

	public long getDegree() {
		return degree;
	}

	public void setDegree(long degree) {
		this.degree = degree;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public int getProbationNumber() {
		return probationNumber;
	}

	public void setProbationNumber(int probationNumber) {
		this.probationNumber = probationNumber;
	}

	public Date getChangeNormalDate() {
		return changeNormalDate;
	}

	public void setChangeNormalDate(Date changeNormalDate) {
		this.changeNormalDate = changeNormalDate;
	}

	public long getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(long empStatus) {
		this.empStatus = empStatus;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public long getEmpType() {
		return empType;
	}

	public void setEmpType(long empType) {
		this.empType = empType;
	}

	public long getResidence() {
		return residence;
	}

	public void setResidence(long residence) {
		this.residence = residence;
	}

	public long getChannel() {
		return channel;
	}

	public void setChannel(long channel) {
		this.channel = channel;
	}

	public long getGuideEmpId() {
		return guideEmpId;
	}

	public void setGuideEmpId(long guideEmpId) {
		this.guideEmpId = guideEmpId;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getGuideLoginName() {
		return guideLoginName;
	}

	public void setGuideLoginName(String guideLoginName) {
		this.guideLoginName = guideLoginName;
	}

	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

}

