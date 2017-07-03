package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.dao.ProjectsDao;
import cn.edu.ustc.ttcn.itsec.model.Projects;

public class ProjectsServiceImpl implements ProjectsService {
	private  ProjectsDao projectsDao;
	
	public ProjectsDao getProjectsDao() {
		return projectsDao;
	}

	public void setProjectsDao(ProjectsDao projectsDao) {
		this.projectsDao = projectsDao;
	}

	@Override
	public List<Projects> queryAll() {
		// TODO Auto-generated method stub
		return projectsDao.showAll();
	}

	@Override
	public List<Projects> queryMProject(int projectsId) {
		// TODO Auto-generated method stub
		return projectsDao.selMProject(projectsId);
	}

	@Override
	public List<Projects> queryMProjectS(int corId) {
		// TODO Auto-generated method stub
		return projectsDao.selMAll(corId);
	}

	@Override
	public void saveProjects(Projects project) {
		// TODO Auto-generated method stub
		projectsDao.save(project);
	}

}
