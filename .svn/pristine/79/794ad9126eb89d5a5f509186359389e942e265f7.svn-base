package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Privilege;
import cn.edu.ustc.ttcn.itsec.model.Role;
//import antlr.collections.List;
import cn.edu.ustc.ttcn.itsec.model.User;
import cn.edu.ustc.ttcn.itsec.service.SuperService;

public class Control implements ServletRequestAware, ServletResponseAware{
	private SuperService superService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private List<User> users;
	private List<Privilege> roles;
	
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

	public List<Privilege> getRoles() {
		return roles;
	}

	public void setRoles(List<Privilege> roles) {
		this.roles = roles;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public SuperService getSuperService() {
		return superService;
	}

	public void setSuperService(SuperService superService) {
		this.superService = superService;
	}

	public String showUser(){
		/**超级管理员界面 输出所有的用户
		 * 
		 * **/
		
		//List<User> users 初始化，   利用ArrayList类实例化List  users集合
		users = new ArrayList<User>();
		
		users = (List<User>) superService.query_all();
/*
		if(users!=null){
			return "success";
		}
		else{
		//测试数据，mean nothing
			users=new ArrayList<User> ();
			User user=new User("test","123","123");
			
			users.add(user);
			User user_1=new User("test","13","113");
			
			users.add(user_1);			
			return "success";
			
		}
		*/
		return "success"; 
	}


	public String showRole(){
		/**超级管理员界面 输出所有的角色
		 * 
		 * **/		
		
		roles = new ArrayList<Privilege>();
		roles= superService.query_all_priv();
		 		
		return "success";
	}
	


}
