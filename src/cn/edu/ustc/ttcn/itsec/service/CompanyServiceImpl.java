package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.dao.DeviceDao;
import cn.edu.ustc.ttcn.itsec.dao.CompanyDao;
import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.Company;

public class CompanyServiceImpl implements CompanyService{

	private CompanyDao companyDao;

	

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public List<Company> queryAllCompanys() {
		
		return companyDao.selAllCompany();
	}

	@Override
	public Company queryMCompany(int id) {
		
		return companyDao.selMCompany(id);
	}

	@Override
	public void delCompany(int corId) {
		// TODO Auto-generated method stub
		Company company = companyDao.selMCompany(corId);
		companyDao.delete(company);
		
	}

	@Override
	public void saveCompany(Company company) {
		// TODO Auto-generated method stub
		companyDao.save(company);
	}

	@Override
	public void updateCompany(Company company) {
		// TODO Auto-generated method stub
		companyDao.update(company);
	}

}
