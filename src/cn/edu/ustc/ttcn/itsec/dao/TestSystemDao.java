package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;


public interface TestSystemDao {
	/**
	 * �õ�ĳϵͳ�����в�����¼
	 * ϵͳId @param sysId
	 * @return
	 */
	public List<TestSystem> selAllTestSys(int sysId);
	
	/**
	 * ����AutoId����  ��ѯ�õ�TestSystem ������
	 * ����ϵͳId @param testSysId
	 * @return
	 */
	public List<TestSystem> selMTestSystem(int testSysId);

	/**
	 * ��ѯĳ��Ŀ�������������б���ϵͳ
	 * @param proId
	 * @return
	 */
	public List<TestSystem> selMTestSystems(int proId);
	/**
	 * ����TestSystem����
	 * @param testsystem
	 */
	public void saveTestSys(TestSystem testsystem);
	
	/**
	 * ɾ��TestSystem����
	 * @param testsystem
	 */
	public void delTestSys (TestSystem testsystem);

	
	public void update(TestSystem testSystem);
	
}
