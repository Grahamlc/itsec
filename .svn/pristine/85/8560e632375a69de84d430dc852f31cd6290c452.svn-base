package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.TestObject;


public interface TestObjectDao {
	
	/**数据库表testobject
	 * 根据主键删除
	 * autoId@param id
	 */
	public void delete(int id);
	/**
	 * 数据库表 testobject
	 * 新建数据项
	 * 被测系统Id @param testSysId
	 * 测评对象设备Id @param deviceId
	 * 测评对象类型Id @param objectId
	 * @return
	 */
	public TestObject newTestObject(int testSysId,String name, int objectId );
	
	/**
	 * 某被测系统的所有测评对象
	 * @param testSysId
	 * @return
	 */
	public List<TestObject> showObject(int testSysId);
}
