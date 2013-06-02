/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.human.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.zhjin.base.entity.OperateDataBase;
import com.zhjin.util.Utility;

@Entity
public class EmployeeBargainArg extends OperateDataBase {
	
	@Column
	private long jobId;

	@Column
	private long company;
	
	@Column
	private long oldCompany;

	@Column
	private long empStatus;
	
	@Column
	private long empType;
	
	@Column
	private Date joinDate;

	@Column
	private long oldBargainType;

	@Column
	private Date oldBeginDate;

	@Column
	private Date oldEndDate;

	@Column
	private long bargainStopType;

	@Column
	private long bargainType;

	@Column
	private Date beginDate;

	@Column
	private Date endDate;

	@Column
	private boolean backCheck;

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public long getCompany() {
		return company;
	}

	public void setCompany(long company) {
		this.company = company;
	}

	public long getOldCompany() {
		return oldCompany;
	}

	public void setOldCompany(long oldCompany) {
		this.oldCompany = oldCompany;
	}

	public long getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(long empStatus) {
		this.empStatus = empStatus;
	}

	public long getEmpType() {
		return empType;
	}

	public void setEmpType(long empType) {
		this.empType = empType;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public long getOldBargainType() {
		return oldBargainType;
	}

	public void setOldBargainType(long oldBargainType) {
		this.oldBargainType = oldBargainType;
	}

	public Date getOldBeginDate() {
		return oldBeginDate;
	}

	public void setOldBeginDate(Date oldBeginDate) {
		this.oldBeginDate = oldBeginDate;
	}

	public Date getOldEndDate() {
		return oldEndDate;
	}

	public void setOldEndDate(Date oldEndDate) {
		this.oldEndDate = oldEndDate;
	}

	public long getBargainStopType() {
		return bargainStopType;
	}

	public void setBargainStopType(long bargainStopType) {
		this.bargainStopType = bargainStopType;
	}

	public long getBargainType() {
		return bargainType;
	}

	public void setBargainType(long bargainType) {
		this.bargainType = bargainType;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isBackCheck() {
		return backCheck;
	}

	public void setBackCheck(boolean backCheck) {
		this.backCheck = backCheck;
	}

	@Override
	public void insertCheck() throws Exception{
		if (beginDate == null && this.bargainType == 0) {
			// 终止合同不续签
			this.company = 0;
			this.bargainType = 0;
		} else {
			if (this.bargainType == 0) {
				throw new Exception("请选择合同类型");
			}			
			
			if (this.beginDate == null) {
				throw new Exception("请输入合同开始日期!");
			}
			
			BargainTypeCode typeCode = Utility.getDBUtility().getEntity(BargainTypeCode.class, this.bargainType);
			if ("LIMI".equals(typeCode.getStrId())) {
				// 固定期限劳动合同
				if (this.endDate == null) {
					throw new Exception("请输入合同终止日期!");
				}
			} else if ("NOLI".equals(typeCode.getStrId()) && this.endDate != null) {
				throw new Exception("合同终止日期错误：无固定期限劳动合同");
			}
			
		}

	}

}