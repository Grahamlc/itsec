package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.ProjectsNumber;

public class ProjectsNumberDaoForMysql extends HibernateDaoSupport implements ProjectsNumberDao{

	@Override
	public List<ProjectsNumber> showAll() {
		// TODO Auto-generated method stub
		return (List<ProjectsNumber>) this.getHibernateTemplate().find("from ProjectsNumber");
	}

	@Override
	public List<ProjectsNumber> selLastProNum() {
		// TODO Auto-generated method stub
		return (List<ProjectsNumber>) this.getHibernateTemplate().find("from ProjectsNumber order by autoId DESC");
	}

	@Override
	public void save(ProjectsNumber proNum) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(proNum);
	}

	@Override
	public void update(ProjectsNumber proNum) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(proNum);
	}

	@Override
	public void delete(ProjectsNumber proNum) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(proNum);
	}

}
