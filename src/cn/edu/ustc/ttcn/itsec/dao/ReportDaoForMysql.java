package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Reports;

public class ReportDaoForMysql extends HibernateDaoSupport implements ReportDao {

	@Override
	public void saveReport(Reports it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(it);
	}

	@Override
	public List<Reports> showMReport(int testSysId) {
		// TODO Auto-generated method stub
		String hql = "from Reports as it where it.testSystem.autoId = ?";
		return (List<Reports>) this.getHibernateTemplate().find(hql,testSysId);
	}

	@Override
	public List<Reports> showAllReport(int sysId) {
		// TODO Auto-generated method stub
		String hql = "from Reports as it where it.testSystem.system.autoId = ?";
		return (List<Reports>) this.getHibernateTemplate().find(hql, sysId);
	}

}
