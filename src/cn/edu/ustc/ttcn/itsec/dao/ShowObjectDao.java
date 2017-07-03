package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.TestObject;

public interface ShowObjectDao {
	public List<TestObject>showObject(int id_1,int id_2);
}
