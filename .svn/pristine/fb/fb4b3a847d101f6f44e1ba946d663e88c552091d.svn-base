package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Device;

public class DeviceDaoForMysql extends HibernateDaoSupport implements DeviceDao {
	@SuppressWarnings("unchecked")
	public List<Device> showAllDevice(){
		return (List<Device>)this.getHibernateTemplate().find("from Device");
	}
}
