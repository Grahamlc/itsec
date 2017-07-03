package cn.edu.ustc.ttcn.itsec.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.service.SuperService;
import cn.edu.ustc.ttcn.itsec.service.SystemService;
import cn.edu.ustc.ttcn.itsec.service.TestObjectService;

public class Delete implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SuperService superService;
	private TestObjectService testObjectService;
	private SystemService systemService;
	private String url;
	private int sysId;
	private int mark;
	private int objectId;
	private int corId;
	
	public SystemService getSystemService() {
		return systemService;
	}
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	public TestObjectService getTestObjectService() {
		return testObjectService;
	}
	public void setTestObjectService(TestObjectService testObjectService) {
		this.testObjectService = testObjectService;
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
	public SuperService getSuperService() {
		return superService;
	}
	public void setSuperService(SuperService superService) {
		this.superService = superService;
	}
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
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSysId() {
		return sysId;
	}
	public void setSysId(int sysId) {
		this.sysId = sysId;
	}
	
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	
	public int getCorId() {
		return corId;
	}
	public void setCorId(int corId) {
		this.corId = corId;
	}
	public String delete_user(){
		 int id  = Integer.valueOf(request.getParameter("UserId"));
		 superService.delete(id); //É¾³ýÓÃ»§
		return "dUser";
	}
	
	public String delete_object(){
		
		url = request.getParameter("url");
		sysId = Integer.valueOf(request.getParameter("sysId"));
		mark = Integer.valueOf(request.getParameter("mark"));
		corId = Integer.valueOf(request.getParameter("corId"));
		
		objectId = Integer.valueOf(request.getParameter("objectId"));
		
		testObjectService.delete(objectId);
		
		return "dObject";
		
	}
	
	public String delete_tester(){
		int testerId = Integer.valueOf(request.getParameter("testerId"));
		superService.delete_tester(testerId);
		return "dTester";
	}
	
	public String delete_system(){
		String[] sysIds = request.getParameterValues("sysIds");
		int len = sysIds.length;
		
		try{
			for(int i = 0; i<len; i++){
				int sysId = Integer.valueOf(sysIds[i]);
				systemService.delSystem(sysId);
			}
			
			return "dSys";
		}catch(Exception e){
			return "fail";
		}
		
	}
}
