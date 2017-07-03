package cn.edu.ustc.ttcn.itsec.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Company;

public class AddProjectDaoForMysql extends HibernateDaoSupport
	implements AddProjectDao {

	@Override
	public void addProject(Company project) {
		// TODO Auto-generated method stub
			
			this.getHibernateTemplate().save(project);		
	}

}
