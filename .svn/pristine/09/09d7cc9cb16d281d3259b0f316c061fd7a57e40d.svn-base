package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Projects;

public interface ProjectsDao {
	/**
	 * 查询所有的项目
	 * @return
	 */
	List<Projects> showAll();
	
	/**
	 * 根据某条件进行查询
	 * 项目主键@param projectId
	 * @return
	 */
	List<Projects> selMProject(int projectId);
	
	/**
	 * 查询与某单位相关的所有测评项目
	 * 单位Id 主键@param corId
	 * @return
	 */
	List<Projects> selMAll(int corId);
	
	void save(Projects project);
	
	void delete(Projects project);
	
	void update(Projects project);
}
