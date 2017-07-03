package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Menu;
import cn.edu.ustc.ttcn.itsec.model.Menu_Priv;
import cn.edu.ustc.ttcn.itsec.model.Privilege;
import cn.edu.ustc.ttcn.itsec.model.Role;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.User;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class SuperDaoForMysql extends HibernateDaoSupport implements SuperDao {
	
	private User it;
	private Privilege pp;
	
	public Privilege getPp() {
		return pp;
	}
	public void setPp(Privilege pp) {
		this.pp = pp;
	}
	public User getIt() {
		return it;
	}
	public void setIt(User it) {
		this.it = it;
	}
	
	/**====================用   户====================*/
	
	/**
	 * 保存  登陆用户 
	 */
	@Override
	public void saveUser(User it) {
		
		this.getHibernateTemplate().save(it);
	}
	/**
	 * 根据用户id查询某用户
	 * @param str
	 * @return
	 */
	public User selectUser(String str){
		return (User) this.getHibernateTemplate().find("from User where userId=?", str).get(0);
	}	
	/**
	 * 查询所有用户
	 */
	@SuppressWarnings("unchecked")
	public List<User> query_all(){
		
		return (List<User>) this.getHibernateTemplate().find("from User");
	}
	/**
	 * 删除用户
	 */
	@Override
	public void delete_user(int id) {
		
		User it = new User();
		it = (User) this.getHibernateTemplate().find("from User where AutoId=?", id).get(0);	
		this.getHibernateTemplate().delete(it);
	}
	/**更新用户**/
	@Override
	public void updateUser(User it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(it);
	}
	/**==========================系统角色=========================*/
	
	/**
	 * 添加 系统角色   privilege 数据表
	 */
	@Override
	public void savePrivilege(Privilege priv) {
		
		this.getHibernateTemplate().save(priv);
	}	
	/**
	 * 查询所有 系统角色
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> query_all_priv() {
		
		return (List<Privilege>) this.getHibernateTemplate().find("from Privilege");
	}
	/**
	 * 查询某系统角色
	 */
	@Override
	public Privilege selectPrivilege(int id) {
		
		return (Privilege) this.getHibernateTemplate().find("from Privilege where autoId=?", id).get(0);
	}
	
	/**==========================测评师=========================*/
	/**
	 * 保存 测评师信息
	 */	
	@Override
	public void saveTester(Tester t) {
		
		this.getHibernateTemplate().save(t);
	}
	/**
	 * 查询所有测评师
	 */
	public List<Tester> query_all_tester() {
		return (List<Tester>) this.getHibernateTemplate().find("from Tester");
		
	}
	/**
	 * 删除测评师
	 */
	public void delete_tester(Tester t) {
		this.getHibernateTemplate().delete(t);
		
	}
	/**
	 * 选择某测评师
	 */
	@Override
	public Tester selectTester(int id) {
		
		return (Tester) this.getHibernateTemplate().find("from Tester where userId=?", id).get(0);
	}
	/**
	 * 更新测评师信息
	 */
	@Override
	public void updateTester(Tester it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(it);
	}
	/**==========================功能模块与系统角色的对应关系=========================*/
	
	/**
	 * 保存 某条 功能模块与角色的对应
	 */
	@Override
	public void writeMenuPriv(Menu_Priv it) {
		
		this.getHibernateTemplate().save(it);
	}
	
	/**
	 * 查询某系统角色的所有功能模块
	 */
	@Override
	public List<Menu_Priv> showMenuPriv(int id) {
		
		return (List<Menu_Priv>) this.getHibernateTemplate().find("from Menu_Priv it where it.privilege.autoId=? ", id);
	}
	/**
	 * 删除  某条 功能模块与角色的对应
	 */
	@Override
	public void deleteMenuPriv(Menu_Priv it) {
		
		this.getHibernateTemplate().delete(it);
	}
	
	/**==========================功能模块=========================*/
	/**
	 * 查询某功能模块
	 */
	@Override
	public Menu selectMenu(int id) {
		
		return (Menu) this.getHibernateTemplate().find("from Menu where autoId=?", id).get(0);
	}
	
	
	@Override
	public List<Menu> queryAll() {
		// TODO Auto-generated method stub
		return (List<Menu>) this.getHibernateTemplate().find("from Menu");
	}
	
	


}
