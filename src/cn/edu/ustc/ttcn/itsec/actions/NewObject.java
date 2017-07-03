package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.Item;
import cn.edu.ustc.ttcn.itsec.model.Objects;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.service.TestObjectService;
import cn.edu.ustc.ttcn.itsec.service.ObjectService;
import cn.edu.ustc.ttcn.itsec.service.WriteItemService;

public class NewObject implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TestObjectService testObjectService;
	private int objectId;
	private int deviceId;
	private int testSysId;
	
	private int mark;
	private String url;
	private int corId;
	private int sysId;
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
		
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}	
	
	public TestObjectService getTestObjectService() {
		return testObjectService;
	}
	public void setTestObjectService(TestObjectService testObjectService) {
		this.testObjectService = testObjectService;
	}
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getTestSysId() {
		return testSysId;
	}
	public void setTestSysId(int testSysId) {
		this.testSysId = testSysId;
	}
	
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getCorId() {
		return corId;
	}
	public void setCorId(int corId) {
		this.corId = corId;
	}
	
	public int getSysId() {
		return sysId;
	}
	public void setSysId(int sysId) {
		this.sysId = sysId;
	}
	/**
	 * 新建测评对象
	 * @return
	 */
	public String execute(){	
		String s = request.getParameter("sLevel");
		String a = request.getParameter("aLevel");
		String g = request.getParameter("gLevel");
		mark =Integer.valueOf(request.getParameter("mark"));
		url = request.getParameter("url");
		corId = Integer.valueOf(request.getParameter("corId"));
//		sysId = Integer.valueOf(request.getParameter("sysId"));
		
		testSysId =Integer.valueOf(request.getParameter("testSysId"));		
		
		objectId = Integer.valueOf(request.getParameter("object"));
//		deviceId = Integer.valueOf(request.getParameter("dName"));
		String name = request.getParameter("dName");
		
		testObjectService.newObject(testSysId,name, s, a, g, objectId);
		return "success";

		
	}
	
}
