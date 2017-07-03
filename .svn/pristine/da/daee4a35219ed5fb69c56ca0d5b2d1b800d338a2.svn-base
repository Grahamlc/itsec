package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.ConScore;

public interface ConScoreDao {

	/**
	 * 查询被测系统    有效的 被 测控制点的得分情况
	 * @param testSysId
	 * @return
	 */
	List<ConScore> selAll(int testSysId);
	
	/**
	 * 根据被测系统和测评层面查询
	 * 
	 * 被测系统@param testSysId
	 * 测评层面@param str
	 * @return
	 */
	List<ConScore> selMAll(int testSysId, String str);
	
	void save(ConScore it);
	
	void update(ConScore it);
}
