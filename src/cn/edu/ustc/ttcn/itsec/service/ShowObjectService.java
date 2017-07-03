package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.TestObject;

public interface ShowObjectService {
	/*
	 * 在testobject表中 根据ProId，ObjectId进行选择
	 * 根据某系统Id，测评对象类型Id  得到整条数据项
	 * 从而定位到具体的测评对象设备
	 * *
	 */
	public List<TestObject> showObject(int id_1,int id_2);
}
