package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Tester;

public interface TesterDao {
	/**
	 * ����������ѯ����ʦ
	 * @param userId
	 * @return
	 */	
	public List<Tester> selTester(int userId);
	
	public void save(Tester tester);
	
	public void delete(Tester tester);
	/**
	 * ��ѯ���еĲ���ʦ
	 * @return
	 */
	public List<Tester> selAllTester();
	
	public void update(Tester tester);
	
	/**
	 * ��ѯĳ����ϵͳ�Ĳ���ʦ
	 * @param proId
	 * @return
	 */
	public List<Tester>selMTesters(int testSysId);
}
