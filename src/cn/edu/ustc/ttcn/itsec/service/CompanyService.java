package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.Company;

public interface CompanyService {
	/*查询出所有的商务单位
	 * */
	public List<Company> queryAllCompanys();
	/**
	 * 根据单位的主键查询出整条数据项
	 *单位主键 @param corId
	 * ”单位“对象@return
	 */
	public Company queryMCompany(int corId);
	
	/**
	 * 删除选中的单位
	 * @param corId
	 */
	public void delCompany(int corId);
	
	public void saveCompany(Company company);
	
	public void updateCompany(Company company);
}

