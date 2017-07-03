package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Projects;

public interface ProjectsService {
	/**
	 * 查询截至当前的所有的项目
	 * @return
	 */
	public List<Projects> queryAll();
	
	/**
	 * 根据项目Id查询某项目的信息
	 * 项目Id @param projectsId
	 * @return
	 */
	public List<Projects> queryMProject(int projectsId);
	
	/**
	 * 根据单位Id查询相关的所有项目信息
	 * 单位Id@param corId
	 * @return
	 */
	public List<Projects> queryMProjectS(int corId);
	
	public void saveProjects(Projects project);
}
