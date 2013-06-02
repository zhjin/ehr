/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.base;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

import com.zhjin.util.ArgMap;
import com.zhjin.util.BeanBase;
import com.zhjin.util.EuserSelect;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class EhrUtil
 */
@Named
@Stateless
@LocalBean
public class EhrUtil extends BeanBase {

    /**
     * Default constructor. 
     */
    public EhrUtil() {
    }

    public List<EuserSelect> empSelect(String query) {
    	List<EuserSelect> ret = new ArrayList<EuserSelect>();
    	ret = dbUtility.getDataList("select a.id empId, a.loginname, a.name, b.label depName from employee a," +
    			" (select * from department where enabled = 1 start with id = :operId connect by prior id = highid) b where a.depid = b.id and a.loginname like :loginName", 
    			EuserSelect.class, new ArgMap().add("operId", this.getUser().getOperOrgId1()).add("loginName", Utility.likeString(query)), 1, 8);
    	return ret;
    }
    
}
