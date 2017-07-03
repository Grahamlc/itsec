package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.TestObject;


public interface TestObjectService {
	
	/**
	 * 输出某被测系统的说有测评对象
	 * @param testSysId
	 * @return 
	 */
	public List<TestObject> showTestObject(int testSysId);
	
	/**数据库testobject
	 *1、将device， testSys，object写入testobject
	 *2、从Item中选出测评项
	 *3、将1、2 的主键写入itemselres
	 * 
	 * 被测系统Id@param testSysId
	 * 测评对象设备Id@param deviceId
	 * S@param s
	 * A@param a
	 * G@param g
	 * 测评对象类别@param objectId
	 */
	public void newObject(int testSysId,String name, String s, String a,String g,int objectId);
	
	/**
	 * 根据主键删除testobject
	 * 级联删除 itemselres中对应的测评项
	 * @param id
	 */
	public void delete(int id);
}
