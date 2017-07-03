package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.TestObject;

public class ShowObjectDaoForMysql extends HibernateDaoSupport implements ShowObjectDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<TestObject> showObject(int id_1, int id_2) {
		// TODO Auto-generated method stub
		String hql = "from TestObject as to where to.pro.autoId =? and to.object.autoId=? order by to.autoId";
		
		return (List<TestObject>)this.getHibernateTemplate().find(hql, id_1,id_2);
	}

}
