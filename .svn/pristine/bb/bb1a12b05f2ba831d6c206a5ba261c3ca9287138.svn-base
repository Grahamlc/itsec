package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Objects;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public class ObjectDaoForMysql extends HibernateDaoSupport
	implements ObjectDao{

	/**
	 * 输出所有的测评对象
	 * 物理安全、网络全局、应用安全、主机安全、数据库安全、数据安全、管理等
	 */
	@Override
	public List<Objects> showAllObjects() {
		// TODO Auto-generated method stub
		String hql = "from Objects";
		return (List<Objects>) this.getHibernateTemplate().find(hql);
	}

	
}
