package cn.edu.ustc.ttcn.itsec.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;

public class SystemTesterDaoForMysql extends HibernateDaoSupport
implements SystemTesterDao{

	@Override
	public void writeSysTester(TesterOfSystem it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(it);
	}

}
