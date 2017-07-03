package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Objects;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public interface ObjectService {
	
	/**
	 * 输出所有的测评对象
	 * 物理安全、网络全局、应用安全、主机安全、数据库安全、数据安全、管理等
	 */
	public List<Objects> showAllObjects();
	
}
