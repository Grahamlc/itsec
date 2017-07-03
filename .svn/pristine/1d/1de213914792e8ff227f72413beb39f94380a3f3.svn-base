package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;

public class ShowItemDaoForMysql extends HibernateDaoSupport implements ShowItemDao {

	@SuppressWarnings("unchecked")
	
	public List<ItemSelRes> showItem(int id) {
		
		String hql = "from ItemSelRes  as it where it.itemToObject.autoId=?";
		return (List<ItemSelRes>) this.getHibernateTemplate().find(hql, id);
	}

	@SuppressWarnings("unchecked")
	public List<ItemSelRes> showMItem(int id, String str) {
		String hql = "select count(*) from ItemSelRes as it where it.itemToObject.autoId=? and it.notice like '?'";
		return (List<ItemSelRes>) this.getHibernateTemplate().find(hql, id,str);
	}

}
