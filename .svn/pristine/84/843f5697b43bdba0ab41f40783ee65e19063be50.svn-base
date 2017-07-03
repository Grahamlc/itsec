package cn.edu.ustc.ttcn.itsec.service;

import cn.edu.ustc.ttcn.itsec.dao.SystemDao;
import cn.edu.ustc.ttcn.itsec.model.Systems;

public class SystemServiceImpl implements SystemService{
	private SystemDao systemDao;
	
	
	public SystemDao getSystemDao() {
		return systemDao;
	}

	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}

	@Override
	public void addSystem(Systems s) {
		// TODO Auto-generated method stub
		systemDao.addSystem(s);
	}

	@Override
	public void delSystem(int sysId) {
		// TODO Auto-generated method stub
		Systems tmp = new Systems();
		tmp = systemDao.queryMSystem(sysId);
		systemDao.delSystem(tmp);
	}
	
}
