package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;
import java.util.Map;

import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;
import cn.edu.ustc.ttcn.itsec.model.Reports;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestObject;

public interface ReportService {
	/**
	 * 根据被测系统Id 得到系统测评信息
	 * 
	 * @param id
	 *            系统Id
	 * @return 被测系统信息
	 */
	public Systems systemInfo(int id);

	/*
	 * 输出某某测评设备的具体测评项 在 itemselres 表中根据 ObjectId 进行选择
	 */
	public List<ItemSelRes> showItem(int testObjectId);

	/**
	 * 数据库表testobject 根据系统Id、测评对象类别 查询 被测系统Id@param proId 测评对象类别@param objectId
	 * List<TestObject>@return
	 */
	public List<TestObject> testObjectItem(int proId, int objectId);

/**
	 * 统计测评项中“测评项”、“符合”、“基本符合”、“不符合”个数
	 * 测评对象Id@param testObjectId
	 * Map
	 * <'All':'';'Yes':'';'YesOrNo':'';'No':''>@return
	 * @return 
	 */
	public Map<String, String> countResult(int testObjectId);

	/**
	 * 保存 输出报告信息
	 * 
	 * @param it
	 */
	public void saveReport(Reports it);

	/**
	 * 输出某被测系统的所有报告
	 * 
	 * 被测系统的Id @param testSysId
	 * @return
	 */
	public List<Reports> showMReport(int testSysId);

	/**
	 * 查询某系统生成的截止目前的 所有的 报告
	 * @param sysId
	 * @return
	 */
	
	public List<Reports> showAllReport(int sysId);
	/**
	 * 1、客户端传入需要导出报告的 被测系统id
	 * 
	 * 2、导出报告 返回 报告的名称
	 * 
	 * @param testSysId
	 * @return
	 */
	public String exportReport(Map<String, Object> map, int testSysId);

	// 测评报告 结果记录
	// public Map<String, Object> report_Result_Record(int ProId, int
	// ObjectId,int control_point_num);
}
