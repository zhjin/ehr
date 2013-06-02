/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import com.zhjin.base.EntityBase;
import com.zhjin.base.TreeEntityBase;

/**
 * Session Bean implementation class DBUtility
 */
@Stateless
@LocalBean
public class DBUtility {

	@EJB
	private SysUtil sysUtil;
	
	@PersistenceContext(unitName="em")
	private EntityManager em;

	@Resource(name = "emdbDS", mappedName = "java:/emdbDS")
	private DataSource ds;
    /**
     * Default constructor.
     */
    public DBUtility() {
    }

	public void delete(Object obj, boolean real) throws Exception {
		if (obj instanceof EntityBase) {
			delete(obj, real, false);
		}
	}

	public void delete(Object obj, boolean real, boolean autoFlush) throws Exception {
		if (!(obj instanceof EntityBase)) return;
		((EntityBase)obj).deleteCheck();
		if (obj instanceof TreeEntityBase) {
			deleteTreeEntity((TreeEntityBase)obj, autoFlush);
		} else {
			if (real) {	
				obj = em.merge(obj);
				em.remove(obj);
		    	TreeMap<String, Field> fieldList = Utility.getClassFieldTree(obj.getClass());
		    	for (String fname : fieldList.keySet()) {
		    		if (fieldList.get(fname).isAnnotationPresent(FileField.class)) {
		    			sysUtil.deleteFile(fieldList.get(fname).getLong(obj));
		    		}
		    	}
			} else {
				((EntityBase)obj).setEnabled(false);
				obj = em.merge(obj);
			}
			if (autoFlush) {
				em.flush();
			}
		}
	}

	public String executeStoreProcedure(String spCommand, HashMap<String, Object> arg) throws Exception{
		String ret = null;
		if (spCommand.trim().startsWith("{")) {
			// Oracle存储过程
			ret = executeOracleStoreProcedure(spCommand, arg); 
		} else {
			List<?> _list = this.getDataList(spCommand, arg);
			ret = (String)_list.get(_list.size() - 1);
		}

		if (ret != null && ret.startsWith("0:")) {
			throw new Exception(ret.substring(2));
		} else {
			return ret;
		}
	}
	
	private String executeOracleStoreProcedure(String spCommand, HashMap<String, Object> arg) throws Exception {
		String ret = "";		
		try (Connection conn = ds.getConnection();
				CallableStatement st = conn.prepareCall(spCommand);){
			for (String s : arg.keySet()) {
				switch (arg.get(s).getClass().getSimpleName()) {
					case "long" : st.setLong(s, (long)arg.get(s)); break;
					case "Long" : st.setLong(s, (Long)arg.get(s)); break;
					case "int"  : st.setInt(s, (int)arg.get(s)); break;
					case "Integer" : st.setInt(s, (Integer)arg.get(s)); break;
					case "String" : st.setString(s, (String)arg.get(s)); break;
					case "BigDecimal" : st.setBigDecimal(s, (BigDecimal)arg.get(s)); break;
					case "Date" : st.setDate(s, new java.sql.Date(((Date)arg.get(s)).getTime())); break;
				}
			}
			st.registerOutParameter("retVal", java.sql.Types.VARCHAR);

			st.execute();
			ret = st.getString("retVal");
		}catch (Exception ex) {
			throw ex;
		}
		return ret;
	}

	public int executeUpdate(String queryString, HashMap<String, Object> arg) throws Exception {
		Query query = this.prepareQuery(queryString, arg);
		return query.executeUpdate();
	}

	public int executeUpdate(String queryString, List<?> arg) throws Exception {
		return 0;
	}

	public List<?> getDataList(String queryString, HashMap<String, Object> arg) {
		Query query = this.prepareQuery(queryString, arg);
		return query.getResultList();
	}

	public List<?> getDataList(String queryString, HashMap<String, Object> arg, int firstPosition, int maxResult) {
		Query query = this.prepareQuery(queryString, arg);
		query.setFirstResult(firstPosition);
		query.setMaxResults(maxResult);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getDataList(String queryString, Class<T> classType, HashMap<String, Object> arg) {
		if (classType.isAnnotationPresent(Entity.class)) {
			Query query = this.prepareQuery(queryString, classType, arg);
			return query.getResultList();
		} else {
			return getDataListUseJDBC(queryString, classType, arg);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getDataList(String queryString, Class<T> classType, HashMap<String, Object> arg,
			int firstPosition, int maxResult) {
		if (classType.isAnnotationPresent(Entity.class)) {
			Query query = this.prepareQuery(queryString, classType, arg);
			query.setFirstResult(firstPosition);
			query.setMaxResults(maxResult);
			return query.getResultList();
		} else {
			return getDataListUseJDBC(queryString, classType, arg, firstPosition, maxResult);
		}
	}

	public Object getData(String queryString, HashMap<String, Object> arg) {
		Query query = this.prepareQuery(queryString, arg);
		List<?> _list = query.getResultList();
		if (_list.size() > 0) {
			return _list.get(0);
		} else {
			return null;
		}
	}
	
	public <T> T getData(String queryString, Class<T> classType, HashMap<String, Object> arg) {
		List<T> _list = null;
		if (classType.isAnnotationPresent(Entity.class)) {
			Query query = this.prepareQuery(queryString, classType, arg);
			_list = query.getResultList();
		} else {
			_list = getDataListUseJDBC(queryString, classType, arg);
		}		
		if (_list.size() > 0) {
			return _list.get(0);
		} else {
			return null;
		}
	}

	public boolean exists(String queryString, HashMap<String, Object> arg) {
		Object _obj = getData("select 1 from dual where exists(" + queryString + ")", arg);
		if (_obj != null) {
			return true;
		} else {
			return false;
		}
	}

	public <T> T getEntity(Class<T> classType, Object arg) throws Exception {
		return em.find(classType, arg);
	}

	public <T> T getEntity(String queryString, Class<T> classType, HashMap<String, Object> arg) {
		try {
			return this.getDataList(queryString, classType, arg).get(0);
		} catch (Exception ex) {
			return null;
		}
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public int getRecordCount(String queryString, HashMap<String, Object> arg) {
		Query query = this.prepareQuery(queryString, arg);
		Object ret = query.getSingleResult();
		if (ret instanceof BigDecimal) {
			return ((BigDecimal)ret).intValue();
		} else {
			return (Integer)query.getSingleResult();
		}
	}

	public void save(Object obj) throws Exception {
		if (!(obj instanceof EntityBase)) return;
		save(obj, false);
	}

	public void save(Object obj, boolean autoFlash) throws Exception {
		if (!(obj instanceof EntityBase)) return;
		((EntityBase)obj).insertCheck();
		em.persist(obj);
		if (autoFlash) {
			em.flush();			
		}
	}

	public <T> T update(T obj) throws Exception {
		return update(obj, false);
	}

	public <T> T update(T obj, boolean autoFlush) throws Exception {
		((EntityBase)obj).updateCheck();
		if (obj instanceof TreeEntityBase) {
			this.updateTreeEntity((TreeEntityBase)obj);
			obj = em.merge(obj);
			em.flush();
		} else {
			obj = em.merge(obj);
			if (autoFlush) {
				em.flush();
			}
		}
		return obj;
	}

	private void updateTreeEntity(TreeEntityBase entityName) throws Exception {
		TreeEntityBase _entity = (TreeEntityBase) entityName;
		TreeEntityBase highObj = this.getEntity(entityName.getClass(), _entity.getHighId());
		if (highObj == null)
			return;
		if (entityName.getHighId() > 0) {
			if (this.exists(
					"select id from " + entityName.getClass().getSimpleName() + " where enabled = 1 and id = :highId start with id = :id connect by prior id = highid", 
					new ArgMap().add("id", entityName.getId()).add("highId", entityName.getHighId()))) {
				throw new Exception("上级不能是自身或自身的下级!");
			}
		}
	}

	private void deleteTreeEntity(TreeEntityBase node, boolean autoFlush) throws Exception{
		if (this.exists("select id from " + node.getClass().getSimpleName()
				+ " where (highId = :highId and enabled = 1)", new ArgMap().add("highId", node.getId()))) {
			throw new Exception(node.getLabel() + "存在子节点,不能删除!");
		}
		node.setEnabled(false);
		node = em.merge(node);
		if (autoFlush) {
			em.flush();
		}
	}

	private Query prepareQuery(String queryString, HashMap<String, Object> arg) {
		Query query = em.createNativeQuery(queryString);
		if (arg != null) {
			for (Object o : arg.keySet()) {
				query.setParameter((String) o, arg.get(o));
			}
		}
		return query;
	}

	private <T> Query prepareQuery(String queryString, Class<T> classType, HashMap<String, Object> arg) {
		Query query = em.createNativeQuery(queryString, classType);
		if (arg != null) {
			for (Object o : arg.keySet()) {
				query.setParameter((String) o, arg.get(o));
			}
		}
		return query;
	}
	
	private <T> List<T> getDataListUseJDBC(String queryString, Class<T> classType, HashMap<String, Object> arg,
			int firstPosition, int maxResult) {
		
		String oraclePerPage = "select * from (select op.*, rownum orn from (" + queryString + ") op where rownum < " 
			+ Integer.toString(firstPosition + maxResult) + ") where orn >= " + Integer.toString(firstPosition);

		return getDataListUseJDBC(oraclePerPage, classType, arg);
	}
	
	private <T> List<T> getDataListUseJDBC(String queryString, Class<T> classType, HashMap<String, Object> arg) {
		List<T> ret = new ArrayList<T>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try (Connection conn = ds.getConnection();){			
			TreeMap<Integer, String> sear = new TreeMap<Integer, String>();
			if (arg != null) {				
				for (String argname : arg.keySet()) {
					argTrans(queryString, argname, sear);
					queryString = queryString.replace(":" + argname, "?");
				}
			}
			
			st = conn.prepareStatement(queryString, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			
			if (arg != null) {
				int argnum = 1;
				for (Integer i : sear.keySet()) {
					Object obj = arg.get(sear.get(i));
					switch (obj.getClass().getSimpleName()) {
						case "long" : st.setLong(argnum, (long)obj); break;
						case "Long" : st.setLong(argnum, (Long)obj); break;
						case "int"  : st.setInt(argnum, (int)obj); break;
						case "Integer" : st.setInt(argnum, (Integer)obj); break;
						case "String" : st.setString(argnum, (String)obj); break;
						case "BigDecimal" : st.setBigDecimal(argnum, (BigDecimal)obj); break;
						case "Date" : st.setDate(argnum, new java.sql.Date(((Date)obj).getTime())); break;
					}
					argnum = argnum + 1;
				}
			}
			
			rs = st.executeQuery();
			ResultSetMetaData metaData= st.getMetaData();
			
			TreeMap<String, Field> fieldMap = Utility.getClassFieldTree(classType);
			Field _f = null;
			while (rs.next()) {
				Object obj = classType.newInstance();
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					_f = fieldMap.get(metaData.getColumnLabel(i).toUpperCase());
					if (_f != null) {
						switch (_f.getType().getSimpleName()) {
							case "long" : _f.set(obj, rs.getLong(metaData.getColumnLabel(i))); break;
							case "Long" : _f.set(obj, rs.getLong(metaData.getColumnLabel(i))); break;
							case "int"  : _f.set(obj, rs.getInt(metaData.getColumnLabel(i))); break;
							case "Integer"  : _f.set(obj, rs.getInt(metaData.getColumnLabel(i))); break;
							case "boolean" : 
								if (((BigDecimal)rs.getObject(metaData.getColumnLabel(i))).intValue() == 1) {
									_f.set(obj, true);
								} else {
									_f.set(obj, false);
								}
								break;
							case "BigDecimal" : _f.set(obj, rs.getBigDecimal(metaData.getColumnLabel(i))); break;
							case "String" : _f.set(obj, rs.getObject(metaData.getColumnLabel(i))); break;
							case "Date" : _f.set(obj, rs.getDate(metaData.getColumnLabel(i))); break;
						}
					}
				}
				
				ret.add((T)obj);
			}
			st.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ret;
	}
	
	private void argTrans(String s, String argname, TreeMap<Integer, String> sear) {
		int length = argname.length();
		int position = 0;
		while ((position = s.indexOf(":" + argname, position)) != -1 ) {
			sear.put(position, argname);
			position = position + length;
		}
	}

}
