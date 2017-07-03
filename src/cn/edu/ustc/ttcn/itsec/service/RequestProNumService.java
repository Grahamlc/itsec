package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.ProjectsNumber;
public interface RequestProNumService {

	//获取最新的一个项目编号
	public List<ProjectsNumber> getLastProNum();
	
	//查询所有的项目编号信息
	public List<ProjectsNumber> queryAllProNum();
	
	//保存项目编号
	public void saveProNum(ProjectsNumber proNum);
}
