/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.MethodExpressionActionListener;
import javax.faces.event.MethodExpressionValueChangeListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;

import sun.misc.BASE64Encoder;

import com.zhjin.sys.entity.WindowCommandDefine;
import com.zhjin.sys.manager.ObjectEditManager;

public class Utility {

	public static InitialContext ctx;

	public static String widName;

	static {
		try {

			ctx = new InitialContext();

			widName = "wid";

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static Object getSessionBean(String beanName) {
		Object obj = null;
		try {
			obj = ctx.lookup(beanName);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static DBUtility getDBUtility() {
		return (DBUtility)getSessionBean("java:module/DBUtility");
	}

	public static SysUtil getSysUtil() {
		return (SysUtil)getSessionBean("java:module/SysUtil");
	}

	public static ObjectEditManager getObjectEditManager() {
		return (ObjectEditManager)getSessionBean("java:module/ObjectEditManager");
	}

	public static String encoderPassword(String loginName, String password) {
		String returnValue = "";
		try {
			byte[] plainText = ("abc" + loginName + password + "123").getBytes("UTF8");
			BASE64Encoder encoder = new BASE64Encoder();
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.update(plainText);
			returnValue = encoder.encode(messageDigest.digest());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public static int sortGB(String s1, String s2) {
		try {
			return new String(s1.getBytes("GB2312"), "ISO-8859-1").compareTo(new String(s2.getBytes("GB2312"),
					"ISO-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static void showMessage(String mType, String m) {
		executeJavaScript("alert('" + m + "');");
	}
	
	public static void showAlertMessage(String m) {
		executeJavaScript("alert('" + m + "');");
	}

	public static void showAlertMessage(Exception ex) {
		showAlertMessage(getSourceException(ex).getMessage());
	}

	public static void openWindow(String url, String windowName, int width, int height) {
		executeJavaScript("openWindowWithName('" + baseURL() + url + "','"
				+ windowName + "', " + String.valueOf(width) + ", " + String.valueOf(height) + ");");
	}

	public static void closeWindowAndRefreshParent(String refreshButton) {
		executeJavaScript("parentWindowButtonClick('" + refreshButton + "');window.close();");
	}
	
	public static void closeWindow() {
		executeJavaScript("window.close();");
	}

	public static void executeJavaScript(String jsString) {
		RequestContext.getCurrentInstance().execute(jsString);
	}

	public static void updateComponent(String updateId) {
		RequestContext.getCurrentInstance().update(updateId);
	}

	public static void openDialog(String url, String dialogName, int dialogWidth, int dialogHeight) {

	}

	public static Throwable getSourceException(Exception ex) {
		Throwable ex1 = ex;
		while (ex1.getCause() != null) {
			ex1 = ex1.getCause();
		}
		return ex1;
	}

	public static MethodExpression getMethodExpression(String el, Class<?>[] c) {
		return FacesContext.getCurrentInstance().getApplication().getExpressionFactory().createMethodExpression(
				FacesContext.getCurrentInstance().getELContext(), el, Object.class, c);
	}

	public static ActionListener getActionListener(String el) {
		return new MethodExpressionActionListener(getMethodExpression(el, new Class[]{ActionEvent.class}));
	}

	public static ValueChangeListener getValueChangeListener(String el) {
		return new MethodExpressionValueChangeListener(getMethodExpression(el, new Class[]{ValueChangeEvent.class}));
	}

	public static Object executeMethodExpression(String el, Class<?>[] c, Object[] v) {
		return FacesContext.getCurrentInstance().getApplication()
			.getExpressionFactory().createMethodExpression(
					FacesContext.getCurrentInstance().getELContext(), el,
					Object.class,
					c).invoke(FacesContext.getCurrentInstance().getELContext(), v);
	}

	public static ValueExpression getValueExpression(String el) {
		return getValueExpression(el, Object.class);
	}

	public static <T> ValueExpression getValueExpression(String el, Class<T> returnType) {
		ValueExpression ve = FacesContext.getCurrentInstance().getApplication().getExpressionFactory().createValueExpression(
				FacesContext.getCurrentInstance().getELContext(), el, returnType);
		return ve;
	}

	public static Object getELValue(String el) {
		if (Utility.notEmptyString(el)) {
			return getValueExpression(el).getValue(FacesContext.getCurrentInstance().getELContext());
		} else {
			return null;
		}
	}

	public static String baseURL() {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String baseURL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		return baseURL;
	}

	public static String getUTF8(String fileName) {
		try {
			return URLEncoder.encode(fileName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String likeString(String s) {
		String returnValue = "%";
		for (int i = 0; i < s.length(); i++) {
			returnValue = returnValue + s.charAt(i) + "%";
		}
		return returnValue;
	}

	private static String getSpaceString(int num, String s) {
		StringBuffer _buffer = new StringBuffer();
		for (int i = 0; i < num; i++ ) {
			_buffer.append(s);
		}
		return _buffer.toString();
	}

	public static boolean notEmptyString(String s) {
		return (s != null) && !"".equals(s.trim());
	}

	public static TreeSet<String> initColumnsTree(String columns) {
		TreeSet<String> t = new TreeSet<String>();
		if (columns == null) {
			return t;
		}
		String _columns = (String)Utility.getELValue(columns);

		if (_columns != null) {
			String[] _cs = _columns.split(" ");
			for (String obj : _cs) {
				if (!"".equals(obj.trim())) {
					t.add(obj.trim().toUpperCase());
				}
			}
		}
		return t;
	}

	public static String convertString(TreeSet<String> _tree) {
		String ret = " ";
		for (String s : _tree) {
			ret = ret + s;
		}
		return ret;
	}

	public static HtmlOutputText getOutputComponent(String el) {
		HtmlOutputText _output = new HtmlOutputText();
		_output.setValueExpression("value", Utility.getValueExpression(el));
		return _output;
	}

	public static Object isnull(Object obj, Object ret) {
		if (obj == null) {
			return ret;
		} else {
			if (obj instanceof String) {
				if ("".equals(((String)obj).trim())) {
					return ret;
				} else {
					return obj;
				}
			} else {
				return obj;
			}
		}
	}

	public static String addString(String a, String b) {

		if (a == null && b == null) {
			return null;
		}

		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		return a + b;
	}

	public static void printMap(Map<String, Object> arg) {
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("Print Map : " + arg.getClass());
		for (Object o : arg.keySet()) {
			System.out.println((String)o + " : " + arg.get(o));
		}
		System.out.println("");
	}

	public static Map<String, Object> getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}

	public static String lowerFirstChar(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static SelectItem getSelectItem(String label, Object value) {
		SelectItem item = new SelectItem();
		item.setLabel(label);
		item.setValue(value);
		return item;
	}

	public static List<SelectItem> getSelectItems(List<?> objList) throws Exception {
		List<SelectItem> _list = new ArrayList<SelectItem>();
		for (Object o : objList) {
			Object[] ol = (Object[])o;
			_list.add(getSelectItem((String)ol[0], ol[1]));
		}
		return _list;
	}

	public static CommandButton getCommandButton(String value, String actionListenerEl) {

		CommandButton button = new CommandButton();
		button.setValue(value);
		button.addActionListener(Utility.getActionListener(actionListenerEl));
		return button;

	}

	public static CommandButton getCommandButton(String id, String value, String actionListenerEl, String icon) {

		CommandButton button = new CommandButton();
		button.setId(id);
		button.setValue(value);
		button.addActionListener(Utility.getActionListener(actionListenerEl));
		if (notEmptyString(icon)) {
			button.setIcon(icon);
		}
		return button;

	}

	public static UIParameter getUIParameter(String name, Object obj) {
		UIParameter para = new UIParameter();
		para.setName(name);
		para.setValue(obj);
		return para;
	}

	public static CommandButton getCommandButton(WindowCommandDefine comm) {

		CommandButton button = new CommandButton();

		button.setRendered(true);

		button.setValueExpression("value", Utility.getValueExpression(comm.getCommandValueEL()));

		if (Utility.notEmptyString(comm.getActionListenerEL())) {
			button.addActionListener(Utility.getActionListener(comm.getActionListenerEL()));
		}

		if (Utility.notEmptyString(comm.getActionEL())) {
			button.setActionExpression(Utility.getMethodExpression(comm.getActionEL(), new Class[]{}));
		}

		if ("AJAX".equals(comm.getCommandType())) {
			button.setAjax(true);
		} else {
			button.setAjax(false);
		}

		return button;

	}

	/**
	 * 判断身份证号码是否有效，通过最后一位校验码来判断
	 * @param code
	 * @throws Exception
	 */
	public static void checkCode(String code) throws Exception {

		if (code.length() != 18) {
			throw new Exception("身份证号码长度错误!");
		}

		System.out.println(codeLastChar(code));
		if (code.charAt(17) != codeLastChar(code)) {
			throw new Exception("身份证号码错误!");
		}

	}

	private static char codeLastChar(String code) {
		int[] keys = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		char[] vi = {'1','0','X','9','8','7','6','5','4','3','2'};
		int p = 0;
		for (int i=0; i < 17; i++) {
			p = p + Integer.parseInt(String.valueOf(code.charAt(i))) * keys[i];
		}
		return vi[p % 11];
	}

	public static UIComponent findComponent(UIComponent base, String id) {

		if (id.equals(base.getId())) {
			return base;
		}

		UIComponent kid = null;
		UIComponent result = null;

		Iterator<UIComponent> kids = base.getFacetsAndChildren();
		while ( kids.hasNext() && result == null ) {
			kid = kids.next();
			if (id.equals(kid.getId())) {
				result = kid;
				break;
			}
			result = findComponent(kid, id);
			if (result != null) {
				break;
			}
		}
		return result;
	}
	
	public static TreeMap<String, Field> getClassFieldTree(Class<?> classType) {
		TreeMap<String, Field> fieldMap = new TreeMap<String, Field>();
		Field[] _fields = null;
		Class<?> _class = classType;
		while (!_class.equals(Object.class)) {
			_fields = _class.getDeclaredFields();
			for (Field o : _fields) {
				o.setAccessible(true);
				fieldMap.put(o.getName().toUpperCase(), o);
			}
			_class = _class.getSuperclass();
		}
		return fieldMap;
	}
	
	public static Date addMonth(Date date, int num) {
		if (date == null) {
			return null;
		}
		Calendar _c = Calendar.getInstance();
		_c.setTime(date);
		_c.add(Calendar.MONTH, num);
		return _c.getTime();
	}
	
	public static Date addDay(Date date, int num) {
		if (date == null) {
			return null;
		}
		Calendar _c = Calendar.getInstance();
		_c.setTime(date);
		_c.add(Calendar.DAY_OF_MONTH, num);
		return _c.getTime();
	}
	
	public static Date addYear(Date date, int num) {
		if (date == null) {
			return null;
		}
		Calendar _c = Calendar.getInstance();
		_c.setTime(date);
		_c.add(Calendar.YEAR, num);
		return _c.getTime();
	}
	
	public static BigDecimal addBigDecimal(BigDecimal a, BigDecimal b) {
		if (a != null && b != null) {
			return a.add(b);
		}
		
		if (a == null) {
			return b;
		} else {
			return a;
		}
	}
	
}
