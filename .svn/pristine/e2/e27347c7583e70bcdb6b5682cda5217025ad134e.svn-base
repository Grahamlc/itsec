package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Company;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class CompanyDaoForMysql extends HibernateDaoSupport implements CompanyDao{

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Company> selAllCompany(){
			return (List<Company>) this.getHibernateTemplate().find("from Company");
		}

	@Override
	public Company selMCompany(int id){
	
			return (Company) this.getHibernateTemplate().find("from Company where corId=?", id).get(0);
		
	}

	@Override
	public void save(Company company) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(company);
	}

	@Override
	public void delete(Company company) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(company);
	}

	@Override
	public void update(Company company) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(company);
	}
	
}
