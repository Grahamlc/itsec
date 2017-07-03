package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.dao.ObjectDao;
import cn.edu.ustc.ttcn.itsec.model.Objects;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public class ObjectServiceImpl implements ObjectService{
	private ObjectDao objectDao;
	
	public ObjectDao getObjectDao() {
		return objectDao;
	}

	public void setObjectDao(ObjectDao objectDao) {
		this.objectDao = objectDao;
	}

	@Override
	public List<Objects> showAllObjects() {
		// TODO Auto-generated method stub
		return objectDao.showAllObjects();
	}

	
}
