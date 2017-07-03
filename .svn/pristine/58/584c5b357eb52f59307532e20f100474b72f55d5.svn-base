package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Projects;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.service.ProjectsService;

public class ShowProjects  implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;

	private List<Projects> allProjects;
	private ProjectsService projectsService;
	
	private Set<Systems> nonSystems; //未被派发的系统
	private Set<TestSystem> testSystem; //目前被测评的系统
	private String url;

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
	public List<Projects> getAllProjects() {
		return allProjects;
	}
	public void setAllProjects(List<Projects> allProjects) {
		this.allProjects = allProjects;
	}
	public ProjectsService getProjectsService() {
		return projectsService;
	}
	public void setProjectsService(ProjectsService projectsService) {
		this.projectsService = projectsService;
	}
	public Set<Systems> getNonSystems() {
		return nonSystems;
	}
	public void setNonSystems(Set<Systems> nonSystems) {
		this.nonSystems = nonSystems;
	}
	public Set<TestSystem> getTestSystem() {
		return testSystem;
	}
	public void setTestSystem(Set<TestSystem> testSystem) {
		this.testSystem = testSystem;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 查询所有的项目
	 * @return
	 */
	public String execute(){
		try{
			url = request.getParameter("url");
			allProjects = new ArrayList<Projects>();
			allProjects = projectsService.queryAll();
			
			return "allProjects";
			
		}catch(Exception e){
			return "fail";
		}
		
	}
	
	/**
	 * 根据proId查询某一个项目
	 * @return
	 */
	public String showMPro(){
		
		int proId = Integer.valueOf(request.getParameter("proId"));
		url = request.getParameter("url");
		
		try{
			allProjects = new ArrayList<Projects>();
			allProjects = projectsService.queryMProject(proId);
						
			nonSystems = allProjects.get(0).getCompany().getSystems();
			testSystem = allProjects.get(0).getTestSystems();
			
			for(TestSystem it : testSystem){
			nonSystems.remove(it.getSystem());
			}
			
			return "Mproject";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/**
	 * 查询某单位corId的所有测评项目
	 * @return
	 */
	public String showMPros(){
		try{
			int corId = Integer.valueOf(request.getParameter("corId"));
			url = request.getParameter("url");
			allProjects = projectsService.queryMProjectS(corId);
			
			return "Mprojects";
		}catch(Exception e){
			return "fail";
		}
		
	}



}
