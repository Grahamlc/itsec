package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;
import java.util.Map;

import cn.edu.ustc.ttcn.itsec.model.MainData;

public interface InvestInforService {
	/**
	 * 插入一条空数据
	 * @param mark
	 */
	public void insertMainData(int id);
	public void insertAppSoft(int id);
	public void insertHostMemory(int id);
	public void insertSecDevice(int id);
	public void insertNetDevice(int id);
	public void insertRelaPeople(int id);
	public void insertManageFile(int id);
	public void insertPhy(int id);
	/**
	 * 删除一条数据
	 */
	public void delMainData(int id);
	public void delAppSoft(int id);
	public void delHostMemory(int id);
	public void delSecDevice(int id);
	public void delNetDevice(int id);
	public void delRelaPeople(int id);
	public void delManageFile(int id);
	public void delPhy(int id);
	/**
	 * 查询 所有的前期调查表信息
	 * @param corId
	 * @return Map<String,Object>
	 */
	public Map<String,Object> showAll(int corId);
	
	/**
	 * 查询某单位  选择的测评对象
	 * @param corId  单位Id
	 * @return Map<String,Object>
	 */
	public Map<String,Object> showMAll(int corId);
	/**
	 * 更新前期调查表数据
	 * @param id 主键（自动增长）
	 * @param dataType 数据类型
	 * @param appSoft 应用软件
	 * @param hostMemory 主机/存储
	 * @param important 重要性
	 */
	public void updateMainData(int id, String dataType,String appSoft,String hostMemory,String important,String url);
	public void updateAppSoft(int id, String name,String usedFor,String important, String url);
	public void updateHostMemory(int id, String name,String osSystem,String usedFor, String url);
	public void updateNetDevice(int id, String madeFrom,String usedFor,String important, String url);
	public void updateSecDevice(int id, String madeFrom,String usedFor,String important, String url);
	public void updateRelaPeople(int id, String name,String position,String contact, String url);
	public void updateManageFile(int id, String name,String mainPoint,String url);
	public void updatePhy(int id,String name,String location,String url);
	
	/**
	 * 将各个前期调查表数据写入数据库
	 * @param dataType
	 * @param appSoft
	 * @param hostMemory
	 */
	public void saveMainData(int proId,List<Object> list);
	public void saveAppSoft(int proId,List<Object> list);
	public void saveHostMemory(int proId,List<Object> list);
	public void saveNetDevice(int proId,List<Object> list);
	public void saveSecDevice(int proId, List<Object> list);
	public void saveRelaPeople(int proId, List<Object> list);
	public void saveManageFile(int proId, List<Object> list);
	public void savePhy(int proId,List<Object> list);
	/**
	 * 选择测评方案
	 * 在提交的信息调查表中，选择适当的对象进行测评
	 * @param id
	 */
	public void chooseMainData(String[] mdIds, int SysId);
	public void chooseAppSoft(String[] asIds, int SysId);
	public void chooseHostMemory(String[] hmIds, int SysId);
	public void chooseNetDevice(String[] ndIds, int SysId);
	public void chooseSecDevice(String[] sdIds, int SysId);
	public void chooseRelaPeople(String[] rpIds, int SysId);
	public void chooseManageFile(String[] mfIds, int SysId);
	public void choosePhy(String[] phyIds, int SysId);
	
	/**
	 * 将前期调查表的数据  打包成Map  整体放入数据库中
	 */
	public void saveWholePackage(int proId, Map<String,List<List<Object>>> it);
}
