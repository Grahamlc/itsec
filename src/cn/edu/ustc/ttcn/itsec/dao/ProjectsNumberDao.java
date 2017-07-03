package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.ProjectsNumber;

public interface ProjectsNumberDao {

	/** 查询所有的项目编号 */
	List<ProjectsNumber> showAll() ;

	/**  查询最近的一个项目编号 */
	List<ProjectsNumber> selLastProNum();
	
	/** 保存一个项目编号 */
	void save(ProjectsNumber proNum);
	
	/** 更新一个项目编号信息 */
	void update(ProjectsNumber proNum);
	
	/** 删除一个项目编号 */
	void delete(ProjectsNumber proNum);
	
	
}
