package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Tester;

public interface TesterService {
	public void saveTester(Tester tester);
	public void delTester(Tester tester);
	public void updateTester(Tester tester);
	
	/**
	 * 根据测评师 主键进行查询
	 * @param userId  主键Id
	 * @return
	 */
	public List<Tester> queryMTester(int userId);
	
	/**
	 * 查询所有的测评师
	 * @return
	 */
	public List<Tester> queryAll();
	
	/**
	 * 查询某被测系统的所有测评师
	 * @param testSysId  被测系统主键Id
	 * @return
	 */
	public List<Tester> queryMTesters(int testSysId); 
	
}
