package cn.edu.ustc.ttcn.itsec.service;

public interface MOService {

	/**
	 * 追加任务单
	 * 
	 * 将System表中的state 设为1
	 * 将信息写入testSystem 表中并将 Cpstate 设为0
	 * 
	 * @sysId
	 * 
	 */
	public void Distribute(int sysId, int proId);
	
	/**
	 * 撤销任务单
	 * 根据被测系统testSysId在TestSystem表中查询出  已经派发的任务单
	 * 删除TestSystem表中的记录
	 * 将System表中的state设为0
	 * 
	 * 如果该系统是project项目表中最后一个被测系统，则删除被测系统的同时， 删除该项目记录 返回字符串”noPro“
	 * 如果该系统不是project项目表中最后一个被测系统，则只删除该被测系统 返回该项目Id
	 * @sysId
	 * @return 返回的字符串noPro  proId
	 */
	public String Undo(int testSysId);
	
	/**
	 * 结束该测评工作
	 * @param testSysId 被测系统Id
	 * 如果该系统是project项目表中最后一个被测系统， 结束该被测系统的同时
	 *   即：（被测系统表CpState 设置为10 表示测评工作 ； 系统表Systems state 设为 0 回到初始状态）
	 *  
	 *  将project 表state 设为1 表示该项目结束。
	 *  
	 * 如果该系统不是project项目表中最后一个被测系统，只结束该被测系统
	 */
	public void finishTest(int testSysId);
	
}
