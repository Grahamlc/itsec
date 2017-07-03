package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Item;

public class SelectObjectDaoForMysql extends HibernateDaoSupport implements SelectObjectDao {

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 数据库表item
	 * 根据测评对象等级（Class）（SAG）、测评对象类别（SecConLaySN）进行筛选
	 */
	public List<Item> SelectObject(String s, String a, String g, int duiX) {
		// TODO Auto-generated method stub
		String hql="from Item as it where it.object=? and it.leiBie in (?,?,?)";
		return (List<Item>) this.getHibernateTemplate().find(hql, duiX , s , a , g );
	}

}
