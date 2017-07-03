package cn.edu.ustc.ttcn.itsec.service;

import java.util.ArrayList;
import java.util.List;

import cn.edu.ustc.ttcn.itsec.dao.LoginDao;
import cn.edu.ustc.ttcn.itsec.dao.CompanyDao;
import cn.edu.ustc.ttcn.itsec.dao.SuperDao;
import cn.edu.ustc.ttcn.itsec.model.Menu;
import cn.edu.ustc.ttcn.itsec.model.Menu_Priv;
import cn.edu.ustc.ttcn.itsec.model.Privilege;
import cn.edu.ustc.ttcn.itsec.model.Company;
import cn.edu.ustc.ttcn.itsec.model.Role;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.User;

public class SuperServiceImpl implements SuperService {
	
	private SuperDao superDao;
	private LoginDao loginDao;
	private CompanyDao companyDao;
	public SuperDao getSuperDao() {
		return superDao;
	}
	public void setSuperDao(SuperDao superDao) {
		this.superDao = superDao;
	}		
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	//添加用户

	public CompanyDao getCompanyDao() {
		return companyDao;
	}
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	public void addUser(String userId,int corId,String passwd,Tester tester,int roleId) {			
		/**
		 * 1、查询出角色对象
		 * 2、查询出所属单位对象
		 * 3、将单位、角色等字段放入user对象
		 * 4、保存user对象		
		 */
		Privilege role = new Privilege();
		role = superDao.selectPrivilege(roleId);
		
		Company account = new Company();
		account = companyDao.selMCompany(corId);
		
		User it = new User();
		it.setUserId(userId);		
		it.setAccount(account);		
		it.setTester(tester);
		it.setPasswd(passwd);
		it.setLevel(role);
		
		superDao.saveUser(it);
	}
	public void addRole(Privilege priv){
		superDao.savePrivilege(priv);
	}
			
	//查询数据库中的所有数据
	public List<User> query_all(){
		return superDao.query_all();
	}

	@Override
	public List<Privilege> query_all_priv() {
		// TODO Auto-generated method stub
		return superDao.query_all_priv();
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		superDao.delete_user(id);
	}
	@Override
	public void addTester(Tester t) {
		// TODO Auto-generated method stub
		superDao.saveTester(t);
	}
	@Override
	public void updateRole(int id, String str,String[] strList) {
		/**
		 * 1、根据主键查出角色Privilege  更新
		 * 2、根据主键查询功能菜单Menu
		 * 3、将角色、功能菜单写入 Menu_Priv
		 * 		3、1若Menu_Priv中已经存在某角色的功能，删除
		 * 		3、2重新写入更新的某角色的功能
		 */
		//1
		Privilege priv = superDao.selectPrivilege(id);
		priv.setMenu(str);

		//3.1
		List<Menu_Priv> mp = new ArrayList<Menu_Priv>();
		mp = superDao.showMenuPriv(id);
		if(mp.size()!=0){
			for(Menu_Priv itt : mp){
				
				itt.getPrivilege().getMenuPriv().remove(itt);
				itt.setPrivilege(null);
				superDao.deleteMenuPriv(itt);
			}
			
		}
		for(int i=0; i<strList.length; i++){
			
			//2
			Menu it = new Menu();
			int menuId = Integer.valueOf(strList[i]);
			it = superDao.selectMenu(menuId);
			//3
			Menu_Priv temp = new Menu_Priv();
			temp.setPrivilege(priv);
			temp.setMenu(it);
			
			//1
			priv.getMenuPriv().add(temp);
		}
		superDao.savePrivilege(priv);
	}
	
	public void modifyPasswd(String userId, String newPass) {
		
		User it = loginDao.query(userId);
		it.setPasswd(newPass);
		superDao.saveUser(it);
	}
	
	public List<Tester> query_all_tester() {
		
		return superDao.query_all_tester();
	}
	
	public void delete_tester(int testerId) {
		Tester t = superDao.selectTester(testerId);
		superDao.delete_tester(t);
	}
	@Override
	public List<Menu> showAllMenu() {
		// TODO Auto-generated method stub
		return superDao.queryAll();
	}
	
	@Override
	public Tester queryMTester(int id){
		return superDao.selectTester(id);
	}
	@Override
	public void updateTester(int id, String name, String pcont, String mcont) {
		// TODO Auto-generated method stub
		Tester t = superDao.selectTester(id);
//		if(!t.getName().equals(name) or !t.getMcont().equals(mcont)){
//			t.setName(name);
//		}
		t.setName(name);
		t.setMcont(mcont);
		t.setPcont(pcont);
	
		superDao.updateTester(t);
	}

}
