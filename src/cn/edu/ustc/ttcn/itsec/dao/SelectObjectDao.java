package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Item;

public interface SelectObjectDao {
	public List<Item> SelectObject(String s,String a,String g,int duiX);
}
