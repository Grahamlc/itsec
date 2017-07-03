package cn.edu.ustc.ttcn.itsec.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Role;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;

public class TestSystemDaoForMysql extends HibernateDaoSupport 
	implements TestSystemDao{

	private TestSystem testSystem;
	private TesterOfSystem tos;
	private Role role;
	private Tester tester;
	
	public TestSystem getTestSystem() {
		return testSystem;
	}

	public void setTestSystem(TestSystem testSystem) {
		this.testSystem = testSystem;
	}
	
	public TesterOfSystem getTos() {
		return tos;
	}

	public void setTos(TesterOfSystem tos) {
		this.tos = tos;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Tester getTester() {
		return tester;
	}

	public void setTester(Tester tester) {
		this.tester = tester;
	}

	@SuppressWarnings("unchecked")

	@Override
	public void saveTestSys(TestSystem testsystem) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(testsystem);
	}

	@Override
	public void delTestSys(TestSystem testsystem) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(testsystem);
	}

	@Override
	public List<TestSystem> selAllTestSys(int sysId) {
		// TODO Auto-generated method stub
		String hql = "from TestSystem as it where it.system.autoId = ?";
		return (List<TestSystem>) this.getHibernateTemplate().find(hql, sysId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestSystem> selMTestSystem(int testSysId) {
		// TODO Auto-generated method stub
		String hql = "from TestSystem as it where it.autoId = ?";
	
		return  (List<TestSystem>) this.getHibernateTemplate().find(hql, testSysId);
	}

	@Override
	public void update(TestSystem testSystem) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(testSystem);
	}

	@Override
	public List<TestSystem> selMTestSystems(int proId) {
		// TODO Auto-generated method stub
		String hql = "from TestSystem as it where it.project.autoId = ?";
		return (List<TestSystem>) this.getHibernateTemplate().find(hql, proId);
	}

	
}
