package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.TestObject;


public interface TestObjectDao {
	
	/**���ݿ��testobject
	 * ��������ɾ��
	 * autoId@param id
	 */
	public void delete(int id);
	/**
	 * ���ݿ�� testobject
	 * �½�������
	 * ����ϵͳId @param testSysId
	 * ���������豸Id @param deviceId
	 * ������������Id @param objectId
	 * @return
	 */
	public TestObject newTestObject(int testSysId,String name, int objectId );
	
	/**
	 * ĳ����ϵͳ�����в�������
	 * @param testSysId
	 * @return
	 */
	public List<TestObject> showObject(int testSysId);
}
