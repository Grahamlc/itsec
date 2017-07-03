package cn.edu.ustc.ttcn.itsec.service;

import cn.edu.ustc.ttcn.itsec.dao.AddProjectDao;
import cn.edu.ustc.ttcn.itsec.model.Company;

public class AddProjectServiceImpl implements AddProjectService{
//	添加商务项目
	private AddProjectDao addProjectDao;
		
	public AddProjectDao getAddProjectDao() {
			return addProjectDao;
	}

	public void setAddProjectDao(AddProjectDao addProjectDao) {
			this.addProjectDao = addProjectDao;
	}

		
	public void addProject(Company project){
			
			addProjectDao.addProject(project);
	}
}
