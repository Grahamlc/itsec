package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;

public interface TestSystemService {
	
	/**
	 * ���ĳϵͳ����ʷ����ǰ�Ĳ�����¼
	 * ϵͳId  @param sysId
	 * @return
	 */
	public List<TestSystem> showTestSys(int sysId);

	
	/**
	 * ��ʼ����
	 * �������ʦ
	 * ��TestSystem ���е�Cpstate ��Ϊ1
	 * 
	 * ����ϵͳ����@param id
	 * backId@param str_1
	 * level@param str_2
	 * Tester@param maps
	 */
	public void writeTestSys(int testSysId,String backId,String level,Map<String,String> maps );
	
	/**
	 * Ϊ����ϵͳ������Ŀ����
	 *����ϵͳ    @param testSysId
	 * ��Ŀ����Id  @param userId
	 * ��Ŀ�����ɫID @param roleID
	 */
	public void setManager(int testSysId, int userId, int roleID);
	/**
	 * ����TestSystem ����
	 * 
	 * @param it
	 */
	public void saveTestSys(TestSystem it);
	
	/**
	 * ɾ��TestSystem ����
	 * @param it
	 */
	public void delTestSys(TestSystem it);
	
	/**
	 * ��ѯĳһ����ϵͳ
	 *  ����ϵͳId @param testSysId
	 * @return
	 */
	public List<TestSystem> queryMTestSys(int testSysId);
}
