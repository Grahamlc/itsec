package cn.edu.ustc.ttcn.itsec.service;

import cn.edu.ustc.ttcn.itsec.dao.LoginDao;
import cn.edu.ustc.ttcn.itsec.model.User;

public class LoginServiceImpl implements LoginService{
	//根据userid 查询用户数据
	private LoginDao loginDao;
	
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public User query(String userid){
			
		return loginDao.query(userid);
			
	}
}
