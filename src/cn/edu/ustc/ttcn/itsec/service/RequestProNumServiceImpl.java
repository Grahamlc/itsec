package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.ProjectsNumber;
import cn.edu.ustc.ttcn.itsec.dao.ProjectsNumberDao;

public class RequestProNumServiceImpl implements RequestProNumService {
	
	private ProjectsNumberDao proNumDao;
	
	@Override
	public List<ProjectsNumber> getLastProNum() {
		// TODO Auto-generated method stub
		return proNumDao.selLastProNum();
	}

	@Override
	public List<ProjectsNumber> queryAllProNum() {
		// TODO Auto-generated method stub
		return proNumDao.showAll();
	}

	public ProjectsNumberDao getProNumDao() {
		return proNumDao;
	}

	public void setProNumDao(ProjectsNumberDao proNumDao) {
		this.proNumDao = proNumDao;
	}


	@Override
	public void saveProNum(ProjectsNumber proNum) {
		// TODO Auto-generated method stub
		proNumDao.save(proNum);
	}

}
