package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Projects;

public class ProjectsDaoForMysql extends HibernateDaoSupport implements ProjectsDao {

	@Override
	public List<Projects> showAll() {
		// TODO Auto-generated method stub
		return (List<Projects>) this.getHibernateTemplate().find("from Projects");
	}

	@Override
	public List<Projects> selMProject(int projectId) {
		// TODO Auto-generated method stub
		String hql ="from Projects as it where it.autoId = ?";
		return (List<Projects>) this.getHibernateTemplate().find(hql, projectId);
	}

	@Override
	public void save(Projects project) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(project);
	}

	@Override
	public void delete(Projects project) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(project);
	}

	@Override
	public void update(Projects project) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(project);
	}

	@Override
	public List<Projects> selMAll(int corId) {
		// TODO Auto-generated method stub
		String hql= "from Projects as it where it.company.corId = ?";
		return (List<Projects>) this.getHibernateTemplate().find(hql, corId);
	}

}
