package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public interface ShowSystemInfoService {
	/**
	 * ���ݿ���systems��
	 * ����AutoId������ѯ����������õ�ϵͳ����Ϣ
	 * @param id
	 * @return
	 */
	public List<Systems> ShowSysteminfo(int id);
}
