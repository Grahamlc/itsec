package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.Company;

public interface CompanyService {
	/*��ѯ�����е�����λ
	 * */
	public List<Company> queryAllCompanys();
	/**
	 * ���ݵ�λ��������ѯ������������
	 *��λ���� @param corId
	 * ����λ������@return
	 */
	public Company queryMCompany(int corId);
	
	/**
	 * ɾ��ѡ�еĵ�λ
	 * @param corId
	 */
	public void delCompany(int corId);
	
	public void saveCompany(Company company);
	
	public void updateCompany(Company company);
}

