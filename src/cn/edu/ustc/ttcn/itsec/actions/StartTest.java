package cn.edu.ustc.ttcn.itsec.actions;

import java.util.LinkedHashMap;
import java.util.Map;



import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;
import cn.edu.ustc.ttcn.itsec.service.TestSystemService;

public class StartTest implements ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TestSystemService testSystemService;
	private Map<String,String> maps ;
	private String url;
	private int proId;
	
	public Map<String, String> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request =  arg0;
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
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	
	/**
	 * 项目经理分配测评师
	 * @return
	 */
	public String execute(){
		int id = Integer.valueOf(request.getParameter("testSysId"));
		String backId = request.getParameter("backId");
		String sLevel = request.getParameter("sLevel");
		String gLevel = request.getParameter("gLevel");
		String aLevel = request.getParameter("aLevel");
		String level = sLevel+aLevel+gLevel;
		System.out.println(level);
		
		String manager_p = request.getParameter("manager_p");
		
		String host_p = request.getParameter("host_p");
		
		String db_p = request.getParameter("db_p");
		
		String app_p = request.getParameter("app_p");
		
		String net_p = request.getParameter("net_p");
		
		String ph_p = request.getParameter("ph_p");
		
		String manag_p = request.getParameter("manag_p");
		
		maps = new LinkedHashMap<String,String>();
		maps.put("4", manager_p);
		maps.put("6",host_p);
		maps.put("7", db_p);
		maps.put("8", app_p);
		maps.put("9",net_p);
		maps.put("10", ph_p);
		maps.put("11", manag_p);
		
		
		
		testSystemService.writeTestSys(id,backId,level,maps);
		return "success";
	}
	
	/**
	 * 商务人员指派项目经理
	 * @return
	 */
	public String setManager(){
//		try{
			int testSysId = Integer.valueOf(request.getParameter("testSysId"));
			int userId = Integer.valueOf(request.getParameter("userId"));
			proId = Integer.valueOf(request.getParameter("proId"));
			
			url = request.getParameter("backUrl");
						
			int roleId = 4; //4 代表项目经理
			testSystemService.setManager(testSysId, userId, roleId);
			
			return "mProjectInfo"; //action 结束后跳转到项目信息模块
//		}catch(Exception e){
//			return "fail";
//		}
	}
}
