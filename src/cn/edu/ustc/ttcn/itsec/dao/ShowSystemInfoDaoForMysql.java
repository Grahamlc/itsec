package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
//���ݵ�λ��Ϣ��ѯ��λ��ϵͳ��Ϣ
public class ShowSystemInfoDaoForMysql extends HibernateDaoSupport implements ShowSystemInfoDao {
		
	@SuppressWarnings("unchecked")
	public List<Systems> ShowSysteminfo(int id){

		String hql="from Systems as s where s.autoId=? ";			
		return (List<Systems>)this.getHibernateTemplate().find(hql, id);
	}


}
