package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Objects;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public interface ObjectService {
	
	/**
	 * ������еĲ�������
	 * ����ȫ������ȫ�֡�Ӧ�ð�ȫ��������ȫ�����ݿⰲȫ�����ݰ�ȫ�������
	 */
	public List<Objects> showAllObjects();
	
}
