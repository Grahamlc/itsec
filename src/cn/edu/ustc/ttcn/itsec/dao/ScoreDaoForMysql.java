package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import cn.edu.ustc.ttcn.itsec.model.Score;

public class ScoreDaoForMysql extends HibernateDaoSupport implements ScoreDao{

	@Override
	public List<Score> selAll(int testSysId) {
		// TODO Auto-generated method stub
		String hql = "from Score as it where it.testSystem.autoId = ?";
		return (List<Score>) this.getHibernateTemplate().find(hql, testSysId);
	}

	@Override
	public void update(Score it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(it);
	}

	@Override
	public void save(Score it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(it);
	}

	@Override
	public List<Score> selM(int testSysId, int itemId) {
		// TODO Auto-generated method stub
		String hql = "from Score as it where it.testSystem.autoId = ? and it.item.itemId =?";
		return (List<Score>) this.getHibernateTemplate().find(hql, testSysId,itemId);
	}



}
