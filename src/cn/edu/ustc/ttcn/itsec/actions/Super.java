package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Company;
import cn.edu.ustc.ttcn.itsec.model.Menu;
import cn.edu.ustc.ttcn.itsec.model.Privilege;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.User;
import cn.edu.ustc.ttcn.itsec.service.CompanyService;
import cn.edu.ustc.ttcn.itsec.service.SuperService;

public class Super implements ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SuperService superService;
	private List<User> users;
	private List<Privilege> roles;
	private List<Tester> testers;
	private Tester tt;
	private List<Menu> menues; 
	private CompanyService companyService;
	
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
	
	public List<Tester> getTesters() {
		return testers;
	}
	public void setTesters(List<Tester> testers) {
		this.testers = testers;
	}
	public Tester getTt() {
		return tt;
	}
	public void setTt(Tester tt) {
		this.tt = tt;
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Privilege> getRoles() {
		return roles;
	}
	public void setRoles(List<Privilege> roles) {
		this.roles = roles;
	}
	
	public List<Menu> getMenues() {
		return menues;
	}
	public void setMenues(List<Menu> menues) {
		this.menues = menues;
	}
	
	public CompanyService getCompanyService() {
		return companyService;
	}
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
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
	
		*/
		return "success"; 
	}


	public String showRole(){
		/**超级管理员界面 输出所有的角色
		 * 
		 * **/		
		
		roles = new ArrayList<Privilege>();
		roles= superService.query_all_priv();
		 	
		menues = new ArrayList<Menu>();
		menues = superService.showAllMenu();
		return "success";
	}
	public String showTester(){
		/**超级管理员界面 输出所有的角色
		 * 
		 * **/		
		
		testers = new ArrayList<Tester>();
		testers= superService.query_all_tester();
		 		
		return "success";
	}
	public String editTester(){
		String[] testerIds = request.getParameterValues("testerId");
		for(int i=0; i<testerIds.length;i++){
			int id = Integer.valueOf(testerIds[i]);
			
//			Tester it = new Tester();
//			it = superService.queryMTester(id);
//			
			String name = request.getParameter("name"+id);
			String mcont = request.getParameter("mcont"+id);
			String pcont = request.getParameter("pcont"+id);
			
//			it.setName(name);
//			it.setPcont(pcont);
//			it.setMcont(mcont);
//			
			superService.updateTester(id, name,pcont,mcont);
			
		}
		return"sucEditTester";
	}
	public String add_user(){
		/**
		 * 1、处理从客户端传来的值
		 * 2、调用SuperService
		 */
		
		try{
			String userId = request.getParameter("userid");
			String passwd = request.getParameter("password");
			String name = request.getParameter("username");
			int corId = Integer.valueOf(request.getParameter("officename"));
			int role =Integer.valueOf(request.getParameter("roleid")) ;
			
			 String pcont = request.getParameter("telephone");
			 String mcont = request.getParameter("email");
			 tt = new Tester();
			 tt.setName(name);
			 tt.setPcont(pcont);
			 tt.setMcont(mcont);
			 
			 Company company = companyService.queryMCompany(corId);
			 tt.setCompany(company);
			 
			 superService.addTester(tt);
			
			superService.addUser(userId, corId, passwd, tt, role);
			return "sucAddUser";
		}
		catch(Exception e){
			System.out.println("failed to wirte to database!!!");
			 return "fail";
		}
	}
	
	public String add_tester(){
		/**超级管理员界面 添加新测评师
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
			 return "sucAddTester";
			
		 }
		 catch(Exception e){
			 System.out.println("failed to wirte to database!!!");
			 return "fail";
		 }
	}
	
	public String editRole(){
		/*
		 *更改某角色的功能模块
		 * */
		
		int id =Integer.valueOf(request.getParameter("roleId"));
		String str = request.getParameter("menues");
		String[] strList = request.getParameterValues("menu");

		System.out.println("editRole"+id+str);
		superService.updateRole(id, str,strList);
		return "sucEditRole";
		
	}
	public String addRole(){
		/**
		 * 添加系统角色
		 */
		String name = request.getParameter("roleName");
		Privilege it = new Privilege();
		it.setName(name);
		superService.addRole(it);
		return "sucAddRole";
	}
	
	public String showMenu(){
		
		menues = new ArrayList<Menu>();
		
		return"sucShowMenu";
	}
}
