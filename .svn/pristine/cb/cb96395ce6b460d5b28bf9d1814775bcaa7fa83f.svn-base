package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.ItemCon;

public class ItemConDaoForMysql extends HibernateDaoSupport implements ItemConDao {

	@Override
	public List<ItemCon> showAll() {
		// TODO Auto-generated method stub
		return (List<ItemCon>) this.getHibernateTemplate().find("from ItemCon");
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ItemCon tmp = (ItemCon) this.getHibernateTemplate().find("from ItemCon where autoId=?",id).get(0);
		this.getHibernateTemplate().delete(tmp);
	}

	@Override
	public void save(ItemCon it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(it);
	}

	@Override
	public void update(ItemCon it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(it);
	}

}
