package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.ProjectsNumber;

public interface ProjectsNumberDao {

	/** ��ѯ���е���Ŀ��� */
	List<ProjectsNumber> showAll() ;

	/**  ��ѯ�����һ����Ŀ��� */
	List<ProjectsNumber> selLastProNum();
	
	/** ����һ����Ŀ��� */
	void save(ProjectsNumber proNum);
	
	/** ����һ����Ŀ�����Ϣ */
	void update(ProjectsNumber proNum);
	
	/** ɾ��һ����Ŀ��� */
	void delete(ProjectsNumber proNum);
	
	
}
