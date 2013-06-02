/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.attend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import com.em.ehr.attend.entity.AttendStatus;
import com.em.ehr.attend.entity.AttendStatusChangeArg;
import com.em.ehr.attend.entity.AttendStatusView;
import com.em.ehr.attend.entity.DepAttendCardParameter;
import com.em.ehr.attend.entity.DepCardUploadHistory;
import com.zhjin.util.ArgMap;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.FileUploadData;
import com.zhjin.util.SysUtil;
import com.zhjin.util.Utility;

@Named
@Stateless
@LocalBean
public class AttendManager extends BeanBase {
	
	@EJB
	private SysUtil sysUtil;

    /**
     * Default constructor. 
     */
    public AttendManager() {

    }

    public void updateAttendStatus(Object obj) throws Exception {  	
    	AttendStatusView view = (AttendStatusView)obj;
    	
    	AttendStatusChangeArg arg = new AttendStatusChangeArg();
    	arg.setEmpId(view.getEmpId());
    	arg.setLoginName(view.getLoginName());
    	arg.setName(view.getName());
    	arg.setDepId(view.getDepId());
    	arg.setAttendTime(view.getAttendTime());
    	arg.setCardNo(view.getCardNo());
    	arg.setCardNo1(view.getCardNo1());
    	arg.setCardNo2(view.getCardNo2());
    	arg.setPunchClock(view.isPunchClock());
    	arg.setRemark(view.getRemark());
    	arg.setAttendEnabled(view.isAttendEnabled());
    	
    	arg = dbUtility.update(arg);
    	
    	AttendStatus status = dbUtility.getEntity(AttendStatus.class, view.getEmpId());
    	status.setAttendTime(view.getAttendTime());
    	status.setCardNo(view.getCardNo());
    	status.setCardNo1(view.getCardNo1());
    	status.setCardNo2(view.getCardNo2());
    	status.setPunchClock(view.isPunchClock());
    	status.setRemark(view.getRemark());
    	status.setAttendEnabled(view.isAttendEnabled());
    	dbUtility.update(status);
    }
    
    public void beforeEmployeeCardWindow() throws Exception {
    	
    	List<SelectItem> _depList = sysUtil.getSelectItemList("select a.depId, a.depName from table(getuserdeplist(:operId)) a, depattendcardparameter b where a.depid = b.depid order by a.indexno, a.depname ",
    			new ArgMap().add("operId", this.getUser().getOperOrgId1()), false);
    	this.getWindowData().getObjMap().put("depList", _depList);

    }
    
    @Audit
    public void uploadCardItemClick(ActionEvent event) throws Exception {

    	FileUploadData fData = new FileUploadData();
    	DepCardUploadHistory history = new DepCardUploadHistory();
    	history.setCardDepId((Long)event.getComponent().getAttributes().get("depId"));
    	fData.setParentData(history);
    	fData.setFileField("fileId");
    	fData.setAllowTypes("");
    	fData.setFileSavePath("/attend/card");
    	fData.setParentButtonName(event.getComponent().findComponent("refreshtable").getClientId());
    	fData.setFileUploadProcess("#{attendManager.employeeCardFileProcess}");
    	sysUtil.openFileUploadWindow(fData);
    	
    }
    
    public void employeeCardFileProcess(FileUploadData fData, UploadedFile uploadFile) throws Exception {
    	DepCardUploadHistory history = (DepCardUploadHistory)fData.getParentData();
    	history.setFileId(sysUtil.uploadFile(history.getFileId(), fData.getFileSavePath(), uploadFile));
    	dbUtility.update(history);
    	
    	DepAttendCardParameter para = dbUtility.getEntity(DepAttendCardParameter.class, history.getCardDepId());
    	BufferedReader reader = new BufferedReader(new InputStreamReader(uploadFile.getInputstream(), "GBK"));
    	String line = null;
    	String cardLine = null;
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	dbUtility.executeUpdate("delete cardtmp where depid = :depId", new ArgMap().add("depId", history.getCardDepId()));

    	while ((line = reader.readLine()) != null) {
    		line = line.replaceAll("\t", " ");
    		try {
    			cardLine = line.substring(para.getYearBegin() - 1, para.getYearEnd()) + "-" 
    					+ line.substring(para.getMonthBegin() - 1, para.getMonthEnd()) + "-"
    					+ line.substring(para.getDayBegin() - 1, para.getDayEnd()) + " "
    					+ line.substring(para.getHourBegin() - 1, para.getHourEnd()) + ":"
    					+ line.substring(para.getMinuteBegin() - 1, para.getMinuteEnd()) + ":"
    					+ line.substring(para.getSecondBegin() - 1, para.getSecondEnd());
    			Date d = dateFormat.parse(cardLine);
    			cardLine = line.substring(para.getIdBegin() - 1, para.getIdEnd());
	    		dbUtility.executeUpdate("insert into cardtmp(depid,  cardinfo, cardtime, empid) values(:depId, :cardInfo, :cardTime, 0)",
	    				new ArgMap().add("depId", history.getCardDepId()).add("cardInfo", cardLine.trim()).add("cardTime", d));
    		} catch (Exception ex) {    			
    		}
    	}
    	reader.close();
		String ret = dbUtility.executeStoreProcedure("{call hrsp_uploadcard(:depId, :retVal)}", new ArgMap().add("depId", history.getCardDepId()));
    	Utility.showAlertMessage(ret);
    }
    
    public void attendDayCalc(Object obj) throws Exception {
    	String ret = dbUtility.executeStoreProcedure("{call hrsp_attenddaycalc(:userId, :retVal)}", new ArgMap().add("userId", this.getUser().getUserId()));
    	Utility.showAlertMessage(ret);
    }
    
    public void attendMonthCalc(Object obj) throws Exception {
    	String ret = dbUtility.executeStoreProcedure("{call hrsp_attendmonthcalc(:userId, :retVal)}", new ArgMap().add("userId", this.getUser().getUserId()));
    	Utility.showAlertMessage(ret);
    }
    
    public void attendClose(Object obj) throws Exception {
    	
    }
    
}
