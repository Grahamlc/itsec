package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.Objects;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public class TestObjectDaoForMysql extends HibernateDaoSupport implements TestObjectDao{
private Device dd;
private TestSystem ts;
private TestObject to;
private Objects ob;

public Objects getOb() {
	return ob;
}
public void setOb(Objects ob) {
	this.ob = ob;
}
public Device getDd() {
	return dd;
}
public void setDd(Device dd) {
	this.dd = dd;
}
public TestSystem getTs() {
	return ts;
}
public void setTs(TestSystem ts) {
	this.ts = ts;
}
public TestObject getTo() {
	return to;
}
public void setTo(TestObject to) {
	this.to = to;
}

	
public TestObject newTestObject(int testSysId,String name, int objectId ) {

		dd = new Device();
		ts = new TestSystem();
		ob = new Objects();		
		to = new TestObject();
		
//		dd = (Device) this.getHibernateTemplate().find("from Device where autoId=?", deviceId).get(0);
		ts = (TestSystem) this.getHibernateTemplate().find("from TestSystem where autoId=?", testSysId).get(0);
		ob = (Objects)this.getHibernateTemplate().find("from Objects where autoId=?", objectId).get(0);
		
//		to.setDevice(dd);
		to.setPro(ts);
		to.setObject(ob);
		to.setName(name);
		this.getHibernateTemplate().save(to);
		return to;

	}
		
		
	@Override
	
	public void delete(int id) {
		// TODO Auto-generated method stub
			TestObject temp = (TestObject) this.getHibernateTemplate().find("from TestObject where autoId=?", id).get(0);
			this.getHibernateTemplate().delete(temp);
		
	}
	
	/**
	 * 输出某被测系统的所有测评对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TestObject> showObject(int testSysId) {
		// TODO Auto-generated method stub
//		String hql = "select distinct(it.object) from TestObject as it where it.pro.autoId =? order by it.object.autoId";
		
		String hql = "from TestObject as it where it.pro.autoId =? order by it.object.autoId";
		return (List<TestObject>) this.getHibernateTemplate().find(hql, testSysId);
	}
}