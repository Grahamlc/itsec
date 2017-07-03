package cn.edu.ustc.ttcn.itsec.dao;

import cn.edu.ustc.ttcn.itsec.model.User;

public interface LoginDao {
	public User query(String userid);
}
