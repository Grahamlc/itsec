package cn.edu.ustc.ttcn.itsec.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Company;
import cn.edu.ustc.ttcn.itsec.service.AddProjectService;


public class AddCompany implements ServletRequestAware, ServletResponseAware{
	
	private AddProjectService addProjectService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String returnJson;
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	
	public AddProjectService getAddProjectService() {
		return addProjectService;
	}

	public void setAddProjectService(AddProjectService addProjectService) {
		this.addProjectService = addProjectService;
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
	public String getReturnJson() {
		return returnJson;
	}
	public void setReturnJson(String returnJson) {
		this.returnJson = returnJson;
	}
	/**
	 * 新建客户单位信息
	 * @return
	 */
	public String execute(){
		/**商务人员新建单位信息
		 * 
		 * 有待完善
		 * **/
		
		//从客户端拿到数据
		
		String corName = request.getParameter("corName");  //被测单位
		String corAdd = request.getParameter("corAdd");  //被测系统
		String connUser = request.getParameter("connUser"); //被测单位联系人
		String connPhon = request.getParameter("connPhon"); //被测单位联系人联系方式
		String connMail = request.getParameter("connMail"); 
		String postCode = request.getParameter("postId");
		String area = request.getParameter("area"); //单位所属地区
		String userBm = request.getParameter("userBm");//所属部门
		String corTel = request.getParameter("corTel"); //办公电话
		String userTitle = request.getParameter("userTitle");//职称/职位	
		try{			
			Company company = new Company();
			
			company.setCorName(corName);
			company.setCorAdd(corAdd);
			company.setConnUser(connUser);
			if(connPhon != null){
				company.setConnPhon(connPhon);
			}
			company.setConnMail(connMail);
			company.setPostCode(postCode);
			company.setArea(area);
			company.setUserBm(userBm);
			if(corTel !=null){
				company.setCorTel(corTel);
			}
			company.setUserTitle(userTitle);
		//根据新建的Project对象将数据写入数据库
			addProjectService.addProject(company);
			return "addcompany";
		}
		catch(Exception e){
			return "fail";
		}
		
	}



}
