package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.Company;

public interface CompanyDao {
	
	public List<Company> selAllCompany();
	
	public Company selMCompany(int corId);
	
	public void save(Company company);
	
	public void delete(Company company);
	
	public void update(Company company);
}
