package cn.edu.ustc.ttcn.itsec.dao;


import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Menu;
import cn.edu.ustc.ttcn.itsec.model.Menu_Priv;
import cn.edu.ustc.ttcn.itsec.model.Privilege;
import cn.edu.ustc.ttcn.itsec.model.Company;
import cn.edu.ustc.ttcn.itsec.model.Role;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.User;

/**
 * 定义对数据库的操作包括CRUD操作
 * @author ZYZ
 * 注：实现针对数据库中不同表的数据库操作，DAO对象
 */
public interface SuperDao {
	
	//登陆用户
	public void saveUser(User it);
	public List<User> query_all();//输出所有的登陆用户
	public void delete_user(int id);
	public User selectUser(String str);
	public void updateUser(User it);//更新
	
	/*测评师*/
	public Tester selectTester(int id);//根据主键查询测评师
	public void saveTester(Tester t);
	public void delete_tester(Tester t);
	public List<Tester> query_all_tester();
	public void updateTester(Tester it);
	
	//系统角色
	public void savePrivilege(Privilege priv);//待修改
	public Privilege selectPrivilege(int id);//根据主键查出一条 角色 数据项
	public List<Privilege> query_all_priv(); //输出所有的系统角色
	
	//功能模块与角色对应关系
	public List<Menu_Priv> showMenuPriv(int id);//根据某一角色删选出该角色的所有功能
	public void writeMenuPriv(Menu_Priv it);
	public void deleteMenuPriv(Menu_Priv it);
	
	//功能模块
	public Menu selectMenu(int id);//根据主键查询某一功能菜单
	/**
	 * 查询所有的功能模块
	 * @return
	 */
	public List<Menu> queryAll();
}
