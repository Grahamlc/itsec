package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;

public interface ShowItemDao {
	public List<ItemSelRes> showItem (int id);
	
	public List<ItemSelRes> showMItem(int id,String str);
}
