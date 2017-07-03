package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;


public interface TestSystemDao {
	/**
	 * 得到某系统的所有测评记录
	 * 系统Id @param sysId
	 * @return
	 */
	public List<TestSystem> selAllTestSys(int sysId);
	
	/**
	 * 根据AutoId主键  查询得到TestSystem 数据项
	 * 被测系统Id @param testSysId
	 * @return
	 */
	public List<TestSystem> selMTestSystem(int testSysId);

	/**
	 * 查询某项目的所包括的所有被测系统
	 * @param proId
	 * @return
	 */
	public List<TestSystem> selMTestSystems(int proId);
	/**
	 * 保存TestSystem对象
	 * @param testsystem
	 */
	public void saveTestSys(TestSystem testsystem);
	
	/**
	 * 删除TestSystem对象
	 * @param testsystem
	 */
	public void delTestSys (TestSystem testsystem);

	
	public void update(TestSystem testSystem);
	
}
