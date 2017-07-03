package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;
import cn.edu.ustc.ttcn.itsec.service.TestSystemService;
import cn.edu.ustc.ttcn.itsec.service.TesterService;

public class ShowTester implements ServletRequestAware, ServletResponseAware{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private List<TestSystem> testSys;
	
	private TestSystemService testSystemService;
	private TesterService testerService;
	private List<Tester> testers;
	private String url;
	private List<Tester> manager;
	private int managerId;
	
	
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public List<Tester> getManager() {
		return manager;
	}

	public void setManager(List<Tester> manager) {
		this.manager = manager;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Tester> getTesters() {
		return testers;
	}

	public void setTesters(List<Tester> testers) {
		this.testers = testers;
	}

	public TesterService getTesterService() {
		return testerService;
	}

	public void setTesterService(TesterService testerService) {
		this.testerService = testerService;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request= arg0;
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
		
	public TestSystemService getTestSystemService() {
		return testSystemService;
	}

	public void setTestSystemService(TestSystemService testSystemService) {
		this.testSystemService = testSystemService;
	}
	
	
	public List<TestSystem> getTestSys() {
		return testSys;
	}

	public void setTestSys(List<TestSystem> testSys) {
		this.testSys = testSys;
	}

	/**
	 * 查询某系统的所有测评过程
	 * @return
	 */
	public String showTestes(){
		int sysId = Integer.valueOf(request.getParameter("id"));
		
		 testSys = new ArrayList<TestSystem >();
		 testSys = testSystemService.showTestSys(sysId);
		
		return "success";
		
	}
	
	/**
	 * 查询所有的测评师
	 * @return
	 */
	public String execute(){
		
//		try{
			url = request.getParameter("url");
			int testSysId = Integer.valueOf(request.getParameter("testSysId"));
			
			testers = testerService.queryAll();
			
//			Set<TesterOfSystem> tmp = testSystemService.queryMTestSys(testSysId).get(0).getSysTester();
//			for(TesterOfSystem it : tmp){
//				if(it.getRole().getRoleId() == 4){
//					manager.add(it.getTester());
//					
//				}
//			}
//			testers.removeAll(manager);
			
			return "testers";
			
//		}catch(Exception e){
//			return "fail";
//		}
	}

	
	
}
