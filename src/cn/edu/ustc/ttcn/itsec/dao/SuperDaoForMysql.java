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
	
	/**====================��   ��====================*/
	
	/**
	 * ����  ��½�û� 
	 */
	@Override
	public void saveUser(User it) {
		
		this.getHibernateTemplate().save(it);
	}
	/**
	 * �����û�id��ѯĳ�û�
	 * @param str
	 * @return
	 */
	public User selectUser(String str){
		return (User) this.getHibernateTemplate().find("from User where userId=?", str).get(0);
	}	
	/**
	 * ��ѯ�����û�
	 */
	@SuppressWarnings("unchecked")
	public List<User> query_all(){
		
		return (List<User>) this.getHibernateTemplate().find("from User");
	}
	/**
	 * ɾ���û�
	 */
	@Override
	public void delete_user(int id) {
		
		User it = new User();
		it = (User) this.getHibernateTemplate().find("from User where AutoId=?", id).get(0);	
		this.getHibernateTemplate().delete(it);
	}
	/**�����û�**/
	@Override
	public void updateUser(User it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(it);
	}
	/**==========================ϵͳ��ɫ=========================*/
	
	/**
	 * ��� ϵͳ��ɫ   privilege ���ݱ�
	 */
	@Override
	public void savePrivilege(Privilege priv) {
		
		this.getHibernateTemplate().save(priv);
	}	
	/**
	 * ��ѯ���� ϵͳ��ɫ
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> query_all_priv() {
		
		return (List<Privilege>) this.getHibernateTemplate().find("from Privilege");
	}
	/**
	 * ��ѯĳϵͳ��ɫ
	 */
	@Override
	public Privilege selectPrivilege(int id) {
		
		return (Privilege) this.getHibernateTemplate().find("from Privilege where autoId=?", id).get(0);
	}
	
	/**==========================����ʦ=========================*/
	/**
	 * ���� ����ʦ��Ϣ
	 */	
	@Override
	public void saveTester(Tester t) {
		
		this.getHibernateTemplate().save(t);
	}
	/**
	 * ��ѯ���в���ʦ
	 */
	public List<Tester> query_all_tester() {
		return (List<Tester>) this.getHibernateTemplate().find("from Tester");
		
	}
	/**
	 * ɾ������ʦ
	 */
	public void delete_tester(Tester t) {
		this.getHibernateTemplate().delete(t);
		
	}
	/**
	 * ѡ��ĳ����ʦ
	 */
	@Override
	public Tester selectTester(int id) {
		
		return (Tester) this.getHibernateTemplate().find("from Tester where userId=?", id).get(0);
	}
	/**
	 * ���²���ʦ��Ϣ
	 */
	@Override
	public void updateTester(Tester it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(it);
	}
	/**==========================����ģ����ϵͳ��ɫ�Ķ�Ӧ��ϵ=========================*/
	
	/**
	 * ���� ĳ�� ����ģ�����ɫ�Ķ�Ӧ
	 */
	@Override
	public void writeMenuPriv(Menu_Priv it) {
		
		this.getHibernateTemplate().save(it);
	}
	
	/**
	 * ��ѯĳϵͳ��ɫ�����й���ģ��
	 */
	@Override
	public List<Menu_Priv> showMenuPriv(int id) {
		
		return (List<Menu_Priv>) this.getHibernateTemplate().find("from Menu_Priv it where it.privilege.autoId=? ", id);
	}
	/**
	 * ɾ��  ĳ�� ����ģ�����ɫ�Ķ�Ӧ
	 */
	@Override
	public void deleteMenuPriv(Menu_Priv it) {
		
		this.getHibernateTemplate().delete(it);
	}
	
	/**==========================����ģ��=========================*/
	/**
	 * ��ѯĳ����ģ��
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
