package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Reports;

public interface ReportDao {
	/**
	 * 将报告信息写入report表中
	 * 记录输出报告信息
	 */
	public void saveReport(Reports it);
	
	/**
	 * 输出某系统的所有报告
	 * 系统 @param sysId
	 * @return
	 */
	public List<Reports> showAllReport(int sysId);
	
	/**
	 * 输出某被测系统的报告
	 * 被测系统 @param testSysId
	 * @return
	 */
	public List<Reports> showMReport(int testSysId);
}
