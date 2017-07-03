package cn.edu.ustc.ttcn.itsec.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Privilege;
import cn.edu.ustc.ttcn.itsec.model.Role;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.User;
import cn.edu.ustc.ttcn.itsec.service.SuperService;

public class AddTester implements ServletRequestAware, ServletResponseAware {

	private Tester tt;
	private SuperService superService;
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	
	public Tester getTt() {
		return tt;
	}

	public void setTt(Tester tt) {
		this.tt = tt;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public SuperService getSuperService() {
		return superService;
	}

	public void setSuperService(SuperService superService) {
		this.superService = superService;
	}

	
	public String add_tester(){
		/**超级管理员界面 添加新角色
		 * 
		 * **/
		
		 String name = request.getParameter("testername");
		 String pcont = request.getParameter("telephone");
		 String mcont = request.getParameter("email");
		 
		 try{
			 tt = new Tester();
			 tt.setName(name);
			 tt.setPcont(pcont);
			 tt.setMcont(mcont);
			 superService.addTester(tt);
			 return "success";
			
		 }
		 catch(Exception e){
			 System.out.println("failed to wirte to database!!!");
			 return "fail";
		 }
	}
	
	
	

}
