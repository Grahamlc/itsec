package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;

public interface ShowItemService {
	/*
	 * ���ĳĳ�����豸�ľ��������
	 * �� itemselres ���и��� ObjectId ����ѡ��
	 * */
	public List<ItemSelRes> showItem(int id);
}
