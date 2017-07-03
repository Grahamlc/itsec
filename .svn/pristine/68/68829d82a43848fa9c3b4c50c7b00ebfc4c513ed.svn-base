package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;

public interface TestSystemService {
	
	/**
	 * 输出某系统的历史、当前的测评记录
	 * 系统Id  @param sysId
	 * @return
	 */
	public List<TestSystem> showTestSys(int sysId);

	
	/**
	 * 开始测评
	 * 分配测评师
	 * 将TestSystem 表中的Cpstate 设为1
	 * 
	 * 被测系统主键@param id
	 * backId@param str_1
	 * level@param str_2
	 * Tester@param maps
	 */
	public void writeTestSys(int testSysId,String backId,String level,Map<String,String> maps );
	
	/**
	 * 为被测系统分配项目经理
	 *被测系统    @param testSysId
	 * 项目经理Id  @param userId
	 * 项目经理角色ID @param roleID
	 */
	public void setManager(int testSysId, int userId, int roleID);
	/**
	 * 保存TestSystem 对象
	 * 
	 * @param it
	 */
	public void saveTestSys(TestSystem it);
	
	/**
	 * 删除TestSystem 对象
	 * @param it
	 */
	public void delTestSys(TestSystem it);
	
	/**
	 * 查询某一被测系统
	 *  被测系统Id @param testSysId
	 * @return
	 */
	public List<TestSystem> queryMTestSys(int testSysId);
}
