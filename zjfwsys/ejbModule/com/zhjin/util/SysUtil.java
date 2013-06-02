/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Version;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

import com.zhjin.base.entity.SelectCodeList;
import com.zhjin.base.entity.SysLargeText;
import com.zhjin.base.entity.SysUploadFile;
import com.zhjin.context.ConvManager;
import com.zhjin.sys.entity.AttachmentFile;
import com.zhjin.sys.entity.AttachmentFileKey;
import com.zhjin.sys.entity.ViewObjectFieldProperty;
import com.zhjin.sys.entity.ViewObjectProperty;
import com.zhjin.sys.window.WindowData;

/**
 * Session Bean implementation class SysUtil
 */
@Named
@Stateless
@LocalBean
public class SysUtil extends BeanBase {

	@Inject
	private ApplicationPara appPara;

	@Resource private SessionContext sessionContext;

	@Resource(mappedName="java:jboss/mail/Default")
	private javax.mail.Session mailSession;

	/**
     * Default constructor.
     */
    public SysUtil() {
    }

    public SessionContext getSessionContext() {
		return sessionContext;
	}

	public List<SelectItem> getSelectMenuList(String objectName, String fieldName, Boolean readOnly) {
    	List<SelectItem> ret = null;

    	ViewObjectFieldProperty vofp = dbUtility.getEntity(
    			"select * from ViewObjectFieldProperty where objectName = :objectName and fieldName = :fieldName",
    			ViewObjectFieldProperty.class, new ArgMap().add("objectName", objectName).add("fieldName", fieldName));
    	if (vofp != null) {
    		if (readOnly) {
    			ret = getViewObjectFieldSelectList(vofp.getDataSource());
    		} else {
    			if (vofp.getEditDataSource() > 0) {
    				ret = getViewObjectFieldSelectList(vofp.getEditDataSource());
    			} else {
    				ret = getViewObjectFieldSelectList(vofp.getDataSource());
    			}
    		}
    	} else {
    		ret = new ArrayList<SelectItem>();
    	}

    	return ret;
    }

	public void downloadFile(long fileId, String downloadType) throws Exception {

		SysUploadFile fu = dbUtility.getEntity(SysUploadFile.class, fileId);
		if (fu == null) {
			throw new Exception("文件不存在!");
		}

		File file = null;
		FileInputStream fin = null;

		// 从磁盘文件下载
		file = new File(appPara.getSysPara().get("UPLOADFILE_ROOT") + Utility.isnull(fu.getSavePath(), "") + "/" + fu.getFileDiskName());
		
		if (file.exists()) {
			fin = new FileInputStream(file);
		}
		if (fin == null) {
			throw new Exception("文件不存在!");
		}

        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

        response.reset();

		response.setContentType("application/octet-stream;");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Expires", "0");

		if ("INLINE".equals(downloadType.toUpperCase())) {
			response.setHeader("Content-disposition","inline;filename=" + Utility.getUTF8(fu.getFileName()));
		} else {
			response.setHeader("Content-disposition","attachment;filename=" + Utility.getUTF8(fu.getFileName()));
		}

		try {
			byte[] buffer = new byte[65536];
			int i = 0;
		          while (( i = fin.read(buffer)) > 0 ) {
		          	response.getOutputStream().write(buffer, 0, i);
		       }
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			throw new Exception("文件下载失败!");
		} finally {
			FacesContext.getCurrentInstance().responseComplete();
			file = null;
			if (fin != null) fin.close();
			fin = null;
		}

	}
	
	public void deleteFile(long fileId) throws Exception {
		SysUploadFile fu = null;
		File _file = null;
		if (fileId > 0) {
			fu = dbUtility.getEntity(SysUploadFile.class, fileId);
			if (fu != null) {

				// 文件保存在硬盘中
		
				
				if (Utility.notEmptyString(fu.getFileDiskName())) {
		
					// 原来有文件保存在磁盘中,上传前先删除原文件
					try {
						_file = new File(appPara.getSysPara().get("UPLOADFILE_ROOT") + Utility.isnull(fu.getSavePath(), "") + "/" + fu.getFileDiskName());
						if (_file.exists()) {
							_file.delete();
						}
					} catch (Exception ex) {
						throw ex;
					} finally {
						_file = null;
					}
				}
			}
			dbUtility.delete(fu, true);
		}
	}
	
	public long uploadFile(long fileId, String path, UploadedFile data) throws Exception {

		if (data.getInputstream() == null || data.getSize() == 0) {
			throw new Exception("请选择上传文件!");
		}

		SysUploadFile fu = null;
		File _file = null;
		
		deleteFile(fileId);

		fu = new SysUploadFile();
		
		InputStream in = null;
		FileOutputStream fos = null;

		try {
			_file = new File(appPara.getSysPara().get("UPLOADFILE_ROOT") + Utility.isnull(path, ""));
			if (!_file.exists()) {
				_file.mkdirs();
			}
			fu.setFileDiskName(new DecimalFormat("00000000").format(this.getUser().getUserId())
					+ new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
			_file = new File(appPara.getSysPara().get("UPLOADFILE_ROOT") + Utility.isnull(path, "") + "/" + fu.getFileDiskName());
			byte[] buffer = new byte[65536];
			in = data.getInputstream();
			fos = new FileOutputStream(_file);
			int i = 0;
	           while (( i = in.read(buffer)) > 0 ) {
	           	fos.write(buffer, 0, i);
	           }
	           fos.flush();
		} catch (Exception ex) {
			throw new Exception("文件上传失败,请重新上传文件!");
		} finally {
			if (_file != null) {
				_file = null;
			}
			if (in != null) {
				in.close();
			}
			in = null;
			if (fos != null) {
				fos.close();
			}
			fos = null;
		}

		fu.setSavePath(path);
		fu.setContentType(data.getContentType());
		fu.setFileName(data.getFileName());
		fu.setFileSize(data.getSize());
		fu.setUploadTime(new Date());

		fu = dbUtility.update(fu, true);

		return fu.getId();
	}

	public InputStream getDownloadFileInputStream(long fileId) throws Exception {

		InputStream is = null;
		SysUploadFile fu = dbUtility.getEntity(SysUploadFile.class, fileId);

		if (fu == null) return null;
		is = new FileInputStream(new File(appPara.getSysPara().get("UPLOADFILE_ROOT") + Utility.isnull(fu.getSavePath(), "") + "/" + fu.getFileDiskName()));
		return is;
	}

	public Session getMailSession() {
		return mailSession;
	}

	/**
	 * 发送邮件
	 */
	public void sendMail(String toMail, String subject, String content) throws Exception {
		sendMail(toMail, subject, content, 3);
	}

	public void sendMail(String toMail, String subject, String content, int priority) throws Exception {
		sendMail(toMail, "", subject, content, priority);
	}

	public void sendMail(String toMail, String ccMail, String subject, String content) throws Exception {
		sendMail(toMail, ccMail, subject, content, 3);
	}

	public void sendMail(String toMail, String ccMail, String subject, String content, int priority) throws Exception {
		MimeMessage msg = new MimeMessage(mailSession);
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));

		if (Utility.notEmptyString(ccMail)) {
			msg.addRecipient(Message.RecipientType.CC, new InternetAddress(ccMail));
		}
		msg.setSentDate(new Date());
		msg.setSubject(subject);
		msg.addHeader("X-Priority",Integer.toString(priority));

		StringBuffer _buffer = new StringBuffer();

		_buffer.append("<font size=2>");
		_buffer.append("<strong>注：本邮件由系统自动生成，请您不要直接回复本邮件!</strong><p/>");
		_buffer.append(content);
		_buffer.append("</font>");

		msg.setContent(_buffer.toString(), "text/html;charset=utf-8");

		Transport.send(msg);
	}

	public List<SelectItem> getViewObjectFieldSelectList(long selectId) {
		List<SelectItem> ret = null;
		try {
			SelectCodeList codeList = dbUtility.getEntity(SelectCodeList.class, selectId);
			if (Utility.notEmptyString(codeList.getCodeEL())) {
				ret = (List<SelectItem>)Utility.getELValue(codeList.getCodeEL());
			} else if (Utility.notEmptyString(codeList.getQueryString())) {
				ret = this.getSelectItemList((String)Utility.getELValue(codeList.getQueryString()), null);
			} else {
				ret = new ArrayList<SelectItem>();
			}
			if (codeList.isHasEmpty()) {
				ret.add(0, new SelectItem(0L, ""));
			}
		} catch (Exception ex) {
			ret = new ArrayList<SelectItem>();
		}	
		return ret;
	}

	public 	void initMenuList(List<ViewObjectFieldProperty> columnList, TreeMap<String, List<SelectItem>> _menuList, TreeMap<String, List<SelectItem>> _editMenuList) {
		for (ViewObjectFieldProperty field : columnList) {
			if ("SELECTMENU".equals(field.getShowType())) {
				try {
					_menuList.put(field.getFieldName(), getViewObjectFieldSelectList(field.getDataSource()));
					if (field.getEditDataSource() > 0 && !field.isRunEditReadOnly()) {
						_editMenuList.put(field.getFieldName(), getViewObjectFieldSelectList(field.getEditDataSource()));
					} else {
						_editMenuList.put(field.getFieldName(), _menuList.get(field.getFieldName()));
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					_menuList.put(field.getFieldName(), new ArrayList<SelectItem>());
				}
			}
		}

	}
	
	public List<SelectItem> getSelectItemList(String queryString, HashMap<String, Object> arg, boolean empty) {
		List<SelectItem> returnValue = new ArrayList<SelectItem>();
		List<?> _list = dbUtility.getDataList(queryString, arg);
		for (Object o : _list) {
			Object[] row = (Object[])o;
			SelectItem item = new SelectItem();
			if (row[0] instanceof BigDecimal) {
				item.setValue(((BigDecimal)row[0]).longValue());
			} else {
				item.setValue(row[0]);
			}
			if (row[1] == null) {
				item.setLabel("");
			} else {
				item.setLabel(String.valueOf(row[1]));
			}
			returnValue.add(item);
		}

		if (empty) {
			returnValue.add(0, new SelectItem(0, ""));
		}
		
		return returnValue;
	}
	
	public List<SelectItem> getSelectItemList(String queryString, HashMap<String, Object> arg) {
		return this.getSelectItemList(queryString, arg, false);
	}

	public void initViewObjectProperty(String className) throws Exception {
		this.initViewObjectProperty(Class.forName(className));
	}

	public void initViewObjectProperty(Class<?> _class) throws Exception {

		String _cname = _class.getSimpleName();
		ViewObjectProperty viewObject = dbUtility.getEntity(ViewObjectProperty.class, _class.getSimpleName());
		if (viewObject == null) {
			viewObject = new ViewObjectProperty();
			viewObject.setObjectClassName(_class.getName());
			viewObject.setObjectName(_cname);
			viewObject.setObjectNameCN(_cname);
			dbUtility.save(viewObject);
		}

		List<Field> _objFieldList = new ArrayList<Field>();

		Field[] _fields = null;

		while (!_class.equals(Object.class)) {
			_fields = _class.getDeclaredFields();
			for (Field f : _fields) {
				if (!f.isAnnotationPresent(Version.class)
						) {
					_objFieldList.add(f);
				}
			}
			_class = _class.getSuperclass();
		}

		// 数据库中定义字段
		List<ViewObjectFieldProperty> _dbFieldList = dbUtility.getDataList(
				"select * from viewobjectfieldproperty where objectname = :objectName", ViewObjectFieldProperty.class,
				new ArgMap().add("objectName", _cname));

		for (ViewObjectFieldProperty dbField : _dbFieldList) {

			// 删除不存在的字段
			Field _f = null;
			for (Field f : _objFieldList) {
				if (f.getName().equals(dbField.getFieldName())) {
					_f = f;
					break;
				}
			}

			if (_f == null) {

				// 字段不存在,删除数据库中记录
				dbUtility.delete(dbField,true);
			} else {
				if (!_f.getType().getSimpleName().equals(dbField.getFieldJavaType())) {
					dbField.setFieldJavaType(_f.getType().getSimpleName());
					dbUtility.update(dbField);
				}
			}
		}

		for (Field f : _objFieldList) {
			ViewObjectFieldProperty _tmp = null;
			for (ViewObjectFieldProperty _field : _dbFieldList) {
				if (f.getName().equals(_field.getFieldName())) {
					_tmp = _field;
					break;
				}
			}
			if (_tmp == null) {
				ViewObjectFieldProperty _vop = new ViewObjectFieldProperty();
				_vop.setEnabled(true);
				_vop.setObjectName(_cname);
				_vop.setFieldName(f.getName());
				_vop.setFieldNameCN(f.getName());
				_vop.setFieldId(f.getName());
				_vop.setFieldJavaType(f.getType().getSimpleName());
				_vop.setAlign("left");
				_vop.setVisiabled(false);
				_vop.setReadOnly(false);
				_vop.setStyleCSS("e1");

				if (_vop.getFieldJavaType().toUpperCase().equals("STRING")) {

					// 文本
					_vop.setShowType("TEXT");
					_vop.setAlign("left");
				} else if (_vop.getFieldJavaType().toUpperCase().equals("INT")
						|| _vop.getFieldJavaType().toUpperCase().equals("LONG")
						|| _vop.getFieldJavaType().toUpperCase().equals("INTEGER")) {

					// 数字
					_vop.setShowType("NUMBER");
					_vop.setAlign("left");
					_vop.setShowFormat("##,##0");
				} else if (_vop.getFieldJavaType().equals("Date")) {

					// 日期
					_vop.setShowType("DATE");
					_vop.setAlign("center");
					_vop.setShowFormat("yyyy-MM-dd");
				} else if (_vop.getFieldJavaType().toUpperCase().equals("BIGDECIMAL")) {

					// 浮点数
					_vop.setShowType("BIGDECIMAL");
					_vop.setAlign("right");
					_vop.setShowFormat("##,##0.00");
				} else if (_vop.getFieldJavaType().toUpperCase().equals("BOOLEAN")) {

					// 检查框
					_vop.setShowType("CHECKBOX");
					_vop.setAlign("center");
				}

				dbUtility.save(_vop);
			}
		}
	}

	public void initViewObjectFieldProperty(Object obj) throws Exception {

		ViewObjectProperty vop = (ViewObjectProperty)obj;
		this.initViewObjectProperty(vop.getObjectClassName());

	}

	public void sendJMSQueueMessage(String requestQueueName, String responseQueueName, javax.jms.Message msg, String responeProcessEL) throws Exception {

//		if (Utility.notEmptyString(responseQueueName)) {
//			sendJMSQueueMessage(new ActiveMQQueue(requestQueueName), new ActiveMQQueue(responseQueueName), msg, responeProcessEL);
//		} else {
//			sendJMSQueueMessage(new ActiveMQQueue(requestQueueName), null, msg, "");
//		}

	}

	public void sendJMSQueueMessage(Queue requestQ, Queue responseQ, javax.jms.Message msg, String responeProcessEL) throws Exception {

		QueueConnectionFactory connectionFactory = null;
		QueueConnection qConnect = null;
		QueueSession qSession = null;

		String filter = null;

		try {

	    	Properties props = new Properties();
	    	props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
	    	props.put(Context.PROVIDER_URL, this.getAppParameter().getSysPara().get("JMS_URL"));
	    	InitialContext context = new InitialContext(props);
	    	connectionFactory = (QueueConnectionFactory)context.lookup("QueueConnectionFactory");
	    	qConnect = connectionFactory.createQueueConnection(this.getAppParameter().getSysPara().get("JMS_CONNECT_USERNAME"),
	    			this.getAppParameter().getSysPara().get("JMS_CONNECT_PASSWORD"));

	    	qSession = qConnect.createQueueSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
	    	qConnect.start();

	    	QueueSender qSender = qSession.createSender(requestQ);

	    	if (responseQ != null) {
	    		msg.setJMSReplyTo(responseQ);
	    	}

	    	qSender.send(msg);

	    	if (responseQ != null) {
	    		filter = "JMSCorrelationID = '" + msg.getJMSMessageID() + "'";
	    		QueueReceiver qReceiver = qSession.createReceiver(responseQ, filter);
	    		javax.jms.Message rmsg = qReceiver.receive(30000);
	    		if (rmsg == null) {
	    			throw new Exception("服务无响应!");
	    		} else {
	    			Utility.executeMethodExpression(responeProcessEL, new Class[]{javax.jms.Message.class}, new Object[]{rmsg});
	    		}
	    	}

		}catch (Exception ex) {
    		throw ex;
    	} finally {
	    	qSession.close();
	    	qConnect.stop();
	    	qConnect.close();
    	}
	}

    @Audit
    public void uploadAttachFile(FileUploadEvent event) throws Exception {

//    	long attachmentId = (Long)UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("attachmentId");
//    	AttachmentFile file = new AttachmentFile(attachmentId, this.uploadFile(0, event.getFile()));
//    	file = dbUtility.update(file, true);
//    	((UIInput)event.getComponent().findComponent("attachfile")).setValue(file.getUploadFileId());

    }

    @Audit
    public void deleteAttachFile(ActionEvent event) throws Exception {

    	int attachmentId = (Integer)UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("attachmentId");
    	int uploadFileId = Integer.parseInt((String)(((UIInput)event.getComponent().findComponent("attachfile")).getValue()));

    	AttachmentFile file = dbUtility.getEntity(AttachmentFile.class, new AttachmentFileKey(attachmentId, uploadFileId));
    	this.deleteFile(uploadFileId);
    	dbUtility.delete(file, true);

    }

    @Audit
    public void openAttachFile(ActionEvent event) throws Exception {

    	int uploadFileId = Integer.parseInt((String)(((UIInput)event.getComponent().findComponent("attachfile")).getValue()));
    	this.downloadFile(uploadFileId, "");

    }

    public List<SelectItem> getAttachmentFileList(int attachmentId) {

    	List<?> attachFileList = dbUtility.getDataList(
    			"select filename, id from sysuploadfile where id in (select uploadfileid from attachmentfile where attachmentid = :attachmentId) order by id desc",
    			new ArgMap().add("attachmentId", attachmentId));
    	List<SelectItem> _list = null;
    	try {
    		_list = Utility.getSelectItems(attachFileList);
    	} catch (Exception ex) {
    		_list = new ArrayList<SelectItem>();
    	}
    	if (_list.size() == 0) {
    		_list.add(Utility.getSelectItem("",  0));
    	}

    	return _list;

    }
    
	@Audit
	public void saveFieldLargeText(ActionEvent event) throws Exception {
		String dialogId = (String)event.getComponent().getAttributes().get("dialogId");
		SysLargeText slt = (SysLargeText)this.getWindowData().getObjMap().get("largeTextEdit");
		slt = dbUtility.update(slt, true);
		BeanUtils.setProperty(event.getComponent().getAttributes().get("obj"),
				(String)event.getComponent().getAttributes().get("fieldName"), slt.getId());
		Utility.executeJavaScript(dialogId + ".hide();");
	}
	
	@SuppressWarnings("unchecked")
	public List<EuserSelect> userSelectComplete(String query) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String custel = (String)UIComponent.getCurrentComponent(facesContext).getAttributes().get("selectUserEL");
		if (Utility.notEmptyString(custel)) {
			if (!custel.startsWith("#")) {
				custel = "#{" + custel + "}";
			}
			return (List<EuserSelect>)facesContext.getApplication().getExpressionFactory().createMethodExpression(
					facesContext.getELContext(), custel, List.class, new Class[]{String.class}).invoke(facesContext.getELContext(), new Object[]{query});
		}
		else {
			return new ArrayList<EuserSelect>();
		}
	}
	
	public void handleEuserSelect(SelectEvent event) { 
		Object obj = event.getComponent().getAttributes().get("entity");
		String fieldName = (String)event.getComponent().getAttributes().get("fieldName");
		EuserSelect user = (EuserSelect)event.getObject();
		try {
			PropertyUtils.setProperty(obj, fieldName, user.getEmpId());
		} catch (Exception e) {
		}
	} 
	
	@Audit
	public void handleValueChangeListener(ValueChangeEvent event) throws Exception {
		event.getComponent().processUpdates(FacesContext.getCurrentInstance());
		String changeEL = (String)event.getComponent().getAttributes().get("valueChangeEL");
		if (!Utility.notEmptyString(changeEL)) {
			return;
		}
		Utility.executeMethodExpression(changeEL, new Class[]{ValueChangeEvent.class}, new Object[]{event});
		String update = (String)event.getComponent().getAttributes().get("update");
		if (Utility.notEmptyString(update)) {
			List<String> _updateList = new ArrayList<String>();
			String[] _sp = update.replaceAll(",", " ").split(" ");
			String _id = null;
			for (String _uid : _sp) {
				if (Utility.notEmptyString(_uid.trim())) {
					try {
						_id = (String)Utility.getELValue("#{p:component('" + _uid.trim() + "')}");
					} catch (Exception ex) {
					}
					if (Utility.notEmptyString(_id)) {
						_updateList.add(_id);
					}
				}
			}
			RequestContext.getCurrentInstance().update(_updateList);
		} else {
			//RequestContext.getCurrentInstance().update(ComponentUtils.findParentForm(FacesContext.getCurrentInstance(), event.getComponent()).getClientId());
		}
	}
	
	public void openFileUploadWindow(FileUploadData data) {
		WindowData parentWindowData = this.getWindowData();
		
		ConvManager.beginConv("fileUpload");
		this.getWindowData().setParentWindowData(parentWindowData);
		this.getWindowData().setInData(data);
		this.getWindowData().setParentRefreshButton(data.getParentButtonName());
		
		Utility.openWindow("/sys/fileupload.jsf?wid=" + ConvManager.getCurrentConvId(), "fileupload", 600, 115);
		
	}
	
	@Audit
	public void fileUploadProcess(FileUploadEvent event) throws Exception {
		FileUploadData fData = (FileUploadData)this.getWindowData().getInData();

		if (Utility.notEmptyString(fData.getFileUploadProcess())) {
			Utility.executeMethodExpression(fData.getFileUploadProcess(), 
					new Class[]{FileUploadData.class, UploadedFile.class}, 
					new Object[]{fData, event.getFile()});
		}
		this.getWindowData().closeWindow();
	}
	
}
