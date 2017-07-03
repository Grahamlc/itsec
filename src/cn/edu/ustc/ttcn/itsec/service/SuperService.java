package cn.edu.ustc.ttcn.itsec.service;


import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Menu;
import cn.edu.ustc.ttcn.itsec.model.Privilege;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.User;

/**
 * 进行和用户有关的业务处理，Service经过业务处理之后调用相应的Dao
 * @author JXX
 *注：
 *（1）针对不用的业务需求实现相应的service类，
 */
public interface SuperService {
	
	
	/**
	 * 数据库中itsec表
	 * 添加登录用户
	 * @return
	 */
	public void addUser(String userId,int corId,String passwd,Tester tester,int roleId);

	/**
	 * 数据库中itsec表
	 * 全表查询所有用户
	 * @return
	 */
	public List<User> query_all();	

	/**
	 * 数据库中privilege表
	 * 查询系统角色
	 * @return
	 */
	public List<Privilege> query_all_priv();
	/**
	 * d_cp_user
	 * 查询所有的测评师
	 * @return
	 */
	public List<Tester> query_all_tester();
	
	/**
	 * 根据主键查找测评师
	 * @param id
	 * @return
	 */
	public Tester queryMTester(int id);
	/**
	 * 数据库汇总itsec表
	 * 删除选中的登陆用户
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 删除的d_cp_user 测评师
	 * @param testerId
	 */
	public void delete_tester(int testerId);
	
	/**数据库中privilege表
	 * 添加角色
	 * @return
	 */
	public void addRole(Privilege priv);
			
	/**
	 * 数据库中 d_cp_user
	 * 添加测评师
	 * @param t
	 */
	public void addTester(Tester t);
	/**
	 * 更新测评师信息
	 * @param t
	 */
	public void updateTester(int id, String name, String pcont, String mcont);
	
	/**
	 * 更改某一角色 所能查看的  功能块
	 * 角色Id 主键@param id
	 * @param str
	 */
	public void updateRole(int id,String str,String[] strList);
	
	/**
	 * 修改密码
	 * 用户Id@param userId
	 * 
	 * 新密码@param newPass
	 */
	public void modifyPasswd(String userId, String newPass);
	
	/**
	 * 输出所有的功能模块
	 * @return
	 */
	public List<Menu> showAllMenu();
	
}

