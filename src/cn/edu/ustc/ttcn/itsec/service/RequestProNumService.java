package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.ProjectsNumber;
public interface RequestProNumService {

	//��ȡ���µ�һ����Ŀ���
	public List<ProjectsNumber> getLastProNum();
	
	//��ѯ���е���Ŀ�����Ϣ
	public List<ProjectsNumber> queryAllProNum();
	
	//������Ŀ���
	public void saveProNum(ProjectsNumber proNum);
}
