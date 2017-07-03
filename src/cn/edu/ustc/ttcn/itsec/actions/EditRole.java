package cn.edu.ustc.ttcn.itsec.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.service.SuperService;

public class EditRole implements ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SuperService superService;
	
	
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
	
	public String excute(){
		int id =Integer.valueOf(request.getParameter("roleId"));
		String str = request.getParameter("menues");
		String[] strList = request.getParameterValues("menu");

		System.out.println("editRole"+id+str);
		superService.updateRole(id, str,strList);
		return "success";
		
	}
}
