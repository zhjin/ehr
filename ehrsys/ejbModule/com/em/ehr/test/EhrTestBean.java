/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.em.ehr.attend.entity.AttendCalcTerm;
import com.em.ehr.attend.entity.AttendDay;
import com.zhjin.context.ConvManager;
import com.zhjin.util.Audit;
import com.zhjin.util.BeanBase;
import com.zhjin.util.Utility;

@Named
@Stateless
@LocalBean
public class EhrTestBean extends BeanBase {

    /**
     * Default constructor. 
     */
    public EhrTestBean() {
    }
    
    @Audit
    public void ehrTestClick(ActionEvent event) throws Exception {
    	ConvManager.beginConv("fileupload");
    	Utility.openWindow("/sys/fileupload.jsf?wid=" + ConvManager.getCurrentConvId(), "fileupload", 600, 115);
    }

}
