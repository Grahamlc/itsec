package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Score;

public interface ScoreDao {
	/**
	 * ��ѯĳ����ϵͳ�����в����������ƽ����
	 * @param testSysId
	 * @return
	 */
	public List<Score> selAll(int testSysId);
	/**
	 * ��ѯĳ����ϵͳ ĳ�������
	 * @param testSysId
	 * @param itemId
	 * @return
	 */
	public List<Score> selM(int testSysId,int itemId);
	
	/**
	 * ����ĳ��������Ϣ
	 * @param it
	 */
	public void update(Score it);
	
	public void save(Score it);
	
}
