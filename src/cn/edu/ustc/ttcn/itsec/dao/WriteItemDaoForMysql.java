package cn.edu.ustc.ttcn.itsec.dao;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.Item;
import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;
import cn.edu.ustc.ttcn.itsec.model.TestObject;

public class WriteItemDaoForMysql extends HibernateDaoSupport 
	implements WriteItemDao{
	
	private ItemSelRes isr;
	
	public ItemSelRes getIsr() {
		return isr;
	}
	public void setIsr(ItemSelRes isr) {
		this.isr = isr;
	}
	/**���ݿ��itemselres
	 * ��������д��itemselres����
	 */
	@Override
	public void writeItem(TestObject to, List<Item> it) {
		// TODO Auto-generated method stub
		for(Item temp : it){
			isr = new ItemSelRes();
			isr.setItem(temp);
			isr.setItemToObject(to);
			
			this.getHibernateTemplate().save(isr);
			
		}
		
	}
	/**
	 * ���²����������
	 */
	@Override
	public void updateItem(ItemSelRes it){
		this.getHibernateTemplate().update(it);
	}

	
}

