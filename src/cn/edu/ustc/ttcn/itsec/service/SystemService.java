package cn.edu.ustc.ttcn.itsec.service;

import cn.edu.ustc.ttcn.itsec.model.Systems;

public interface SystemService {
	/**
	 * ����System����
	 * @param s  
	 */
	public void addSystem (Systems s);
	
	/**
	 * ɾ����sysIdΪ������ϵͳ��Ϣ
	 * @param sysId
	 */
	public void delSystem(int sysId);
}
