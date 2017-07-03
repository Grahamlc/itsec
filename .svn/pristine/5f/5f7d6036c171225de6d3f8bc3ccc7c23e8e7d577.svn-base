package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Tester;

public class TesterDaoForMysql extends HibernateDaoSupport implements TesterDao{

	public void save(Tester t) {
		
		this.getHibernateTemplate().save(t);
	}
	/**
	 * 查询所有测评师
	 */
	public List<Tester> selAllTester() {
		return (List<Tester>) this.getHibernateTemplate().find("from Tester");
		
	}
	/**
	 * 删除测评师
	 */
	public void delete(Tester t) {
		this.getHibernateTemplate().delete(t);
		
	}
	/**
	 * 选择某测评师
	 */
	@Override
	public List<Tester> selTester(int userId) {
		
		return  (List<Tester>) this.getHibernateTemplate().find("from Tester where userId=?", userId);
	}
	/**
	 * 更新测评师信息
	 */
	@Override
	public void update(Tester it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(it);
	}
	
	@Override
	public List<Tester> selMTesters(int testSysId) {
		// TODO Auto-generated method stub
		String hql = "from Tester as it where it.testerToSystem.testSys.autoId = ?";
		return (List<Tester>) this.getHibernateTemplate().find(hql, testSysId);
	}

}
