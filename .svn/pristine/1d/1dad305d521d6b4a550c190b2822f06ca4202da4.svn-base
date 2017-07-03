package cn.edu.ustc.ttcn.itsec.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.User;
import cn.edu.ustc.ttcn.itsec.service.LoginService;
import cn.edu.ustc.ttcn.itsec.service.SuperService;

public class ChangePasswd implements ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SuperService superService;
	private LoginService loginService;
	
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
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;		
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;		
	}
	
	public String execute(){
		String userId = request.getParameter("userId");
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		
//		try{
			User it = new User();
			it = loginService.query(userId);
		
			if(it.getPasswd().equals(oldPass)){
				superService.modifyPasswd(userId, newPass);
				return "success";
			}
			else
				return "fail";
//		}catch(Exception e){
//			return "fail";
//		}		
	}
}
