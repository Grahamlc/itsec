package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Score;

public interface ScoreDao {
	/**
	 * 查询某被测系统的所有测评项及测评项平均分
	 * @param testSysId
	 * @return
	 */
	public List<Score> selAll(int testSysId);
	/**
	 * 查询某被测系统 某测评项等
	 * @param testSysId
	 * @param itemId
	 * @return
	 */
	public List<Score> selM(int testSysId,int itemId);
	
	/**
	 * 更新某条数据信息
	 * @param it
	 */
	public void update(Score it);
	
	public void save(Score it);
	
}
