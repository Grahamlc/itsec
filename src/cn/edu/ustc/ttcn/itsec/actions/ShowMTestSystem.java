package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.service.TestSystemService;

public class ShowMTestSystem implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private TestSystemService testSystemService;
	private List<TestSystem> testSystem;
	private String url;
	
	
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
	
	public TestSystemService getTestSystemService() {
		return testSystemService;
	}
	public void setTestSystemService(TestSystemService testSystemService) {
		this.testSystemService = testSystemService;
	}
	public List<TestSystem> getTestSystem() {
		return testSystem;
	}
	public void setTestSystem(List<TestSystem> testSystem) {
		this.testSystem = testSystem;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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

	/**
	 * 根据被测系统的Id 查询被测系统信息
	 * @return
	 */
	public String execute(){
		
//		try{
			int testSysId = Integer.valueOf(request.getParameter("testSysId"));
			url = request.getParameter("url");
			
			System.out.println("url"+url+"testsysId"+testSysId);
			
			testSystem = new ArrayList<TestSystem>();
			testSystem = testSystemService.queryMTestSys(testSysId);
			
			System.out.println("testSystem"+testSystem);
			return "testSystem";
			
//		}catch(Exception e){
//			return "fail";
//		}
		
		
	}
}
