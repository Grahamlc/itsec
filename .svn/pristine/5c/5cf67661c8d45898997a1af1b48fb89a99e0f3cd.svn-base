package cn.edu.ustc.ttcn.itsec.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.User;

public class LoginDaoForMysql extends HibernateDaoSupport
	implements LoginDao{

	//根据userid查询User表中数据
	public User query(String userid){
		return (User)this.getHibernateTemplate().find("from User where userId =?", userid).get(0);
	}

}
