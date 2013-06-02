/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Audit
@Interceptor
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AuditInterceptor {
	
	@EJB private SysUtil sysUtil;
	
	@AroundInvoke
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Object auditProcess(InvocationContext context) throws Exception {
		
		try {			
			return context.proceed();
		} catch (Exception ex) {
			sysUtil.getSessionContext().setRollbackOnly();
			Utility.showAlertMessage(ex);
			return null;	
		}
	}	
}
