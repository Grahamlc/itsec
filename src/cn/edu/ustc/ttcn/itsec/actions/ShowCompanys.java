/**
 * 在商务、主任等界面列出所有 （当前洽谈、当前进行、已经完结） 项目
 */
package cn.edu.ustc.ttcn.itsec.actions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.ustc.ttcn.itsec.model.Company;
import cn.edu.ustc.ttcn.itsec.model.Projects;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.service.ObjectService;
import cn.edu.ustc.ttcn.itsec.service.CompanyService;
import cn.edu.ustc.ttcn.itsec.service.ProjectsService;
import cn.edu.ustc.ttcn.itsec.model.Systems;


public class ShowCompanys implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private List<Company> companys;
	private List<Projects> allProjects;
	private CompanyService companyService;
	private ProjectsService projectsService;
	private Set<Systems> nonSystems; //未被派发的系统
	private Set<TestSystem> testSystem; //目前被测评的系统
	private String url;
	
	
	public Set<TestSystem> getTestSystem() {
		return testSystem;
	}

	public void setTestSystem(Set<TestSystem> testSystem) {
		this.testSystem = testSystem;
	}

	public Set<Systems> getNonSystems() {
		return nonSystems;
	}

	public void setNonSystems(Set<Systems> nonSystems) {
		this.nonSystems = nonSystems;
	}

	private ObjectService objectService;

	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}

	
	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
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

	

	public List<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(List<Company> companys) {
		this.companys = companys;
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

	public String execute(){
		/**测评师  商务人员工作界面 输出所有单位信息
		 * 
		 * **/
		
		companys = new ArrayList<Company>();		
		companys = (List<Company>)companyService.queryAllCompanys();
		
		allProjects = new ArrayList<Projects>();
		allProjects = projectsService.queryAll();
		
		url = request.getParameter("url");
		if(url != null & url.equals("Maleft.jsp")){
			return "super";
		}
		
		return "success";
	}
	
/**
 * 查询某单位信息
 * @return
 */
	public String showMCom(){
		
		int corId = Integer.valueOf(request.getParameter("corId"));
		url = request.getParameter("url");
		try{
			companys = new ArrayList<Company>();
			companys.add(companyService.queryMCompany(corId));
			
			//将结果放入session中
			 
			ActionContext ctx = ActionContext.getContext();
			Map session = ctx.getSession();
			session.put("project", companys.get(0));
			session.put("systems", companys.get(0).getSystems());
			
			return "success";
		}catch(Exception e){
			return "fail";
		}
		
 	}
	
	/**
	 * 查询某一个项目
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
