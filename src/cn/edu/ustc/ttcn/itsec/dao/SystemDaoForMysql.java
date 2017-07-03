package cn.edu.ustc.ttcn.itsec.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Systems;

public class SystemDaoForMysql extends HibernateDaoSupport implements SystemDao {

	@Override
	public void addSystem(Systems s) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(s);
	}

	@Override
	public void delSystem(Systems s) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public Systems queryMSystem(int sysId) {
		// TODO Auto-generated method stub
		return (Systems) this.getHibernateTemplate().find("from Systems as it where it.autoId = ? ", sysId).get(0);
	}

}
