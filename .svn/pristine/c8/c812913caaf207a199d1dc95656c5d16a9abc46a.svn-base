package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Tester;

public interface TesterDao {
	/**
	 * 根据主键查询测评师
	 * @param userId
	 * @return
	 */	
	public List<Tester> selTester(int userId);
	
	public void save(Tester tester);
	
	public void delete(Tester tester);
	/**
	 * 查询所有的测评师
	 * @return
	 */
	public List<Tester> selAllTester();
	
	public void update(Tester tester);
	
	/**
	 * 查询某被测系统的测评师
	 * @param proId
	 * @return
	 */
	public List<Tester>selMTesters(int testSysId);
}
