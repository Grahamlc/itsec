package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.ConScore;

public class ConScoreDaoForMysql extends HibernateDaoSupport implements ConScoreDao{

	@Override
	public List<ConScore> selAll(int testSysId) {
		// TODO Auto-generated method stub
		String hql = "from ConScore as it where it.testSystem.autoId=? and it.itemConScore != null";
		return (List<ConScore>) this.getHibernateTemplate().find(hql, testSysId);
	}

	@Override
	public void save(ConScore it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(it);
	}

	@Override
	public void update(ConScore it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(it);
	}

	@Override
	public List<ConScore> selMAll(int testSysId, String str) {
		// TODO Auto-generated method stub
		
		String hql = "from ConScore as it where it.itemConScore != null and it.testSystem.autoId = ?"
				+ " and it.itemCon.itemCon = ? ";
		return (List<ConScore>) this.getHibernateTemplate().find(hql, testSysId, str);
	}

}
