package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.ustc.ttcn.itsec.model.AppSoft;
import cn.edu.ustc.ttcn.itsec.model.HostMemory;
import cn.edu.ustc.ttcn.itsec.model.MainData;
import cn.edu.ustc.ttcn.itsec.model.ManageFile;
import cn.edu.ustc.ttcn.itsec.model.NetDevice;
import cn.edu.ustc.ttcn.itsec.model.Physices;
import cn.edu.ustc.ttcn.itsec.model.RelaPeople;
import cn.edu.ustc.ttcn.itsec.model.SecDevice;

public class InvestInforDaoForMysql extends HibernateDaoSupport implements InvestInforDao{

	
	public void saveMainData(MainData it) {
		this.getHibernateTemplate().save(it);		
	}

	
	public void delMainData(MainData it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(it);
	}

	
	public MainData selMainData(int id) {
		// TODO Auto-generated method stub
		String hql="from MainData where autoId=?";
		return (MainData) this.getHibernateTemplate().find(hql, id).get(0);
	}

	
	public void saveAppSoft(AppSoft it) {
		this.getHibernateTemplate().save(it);
		
	}

	
	public void delAppSoft(AppSoft it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(it);
	}

	
	public AppSoft selAppSoft(int id) {
		// TODO Auto-generated method stub
		String hql="from AppSoft where autoId=?";
		return (AppSoft) this.getHibernateTemplate().find(hql, id).get(0);
	}

	
	public void saveSecDevice(SecDevice it) {
		
		this.getHibernateTemplate().save(it);
	}

	
	public void delSecDevice(SecDevice it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(it);
	}

	
	public SecDevice selSecDevice(int id) {
		// TODO Auto-generated method stub
		String hql="from SecDevice where autoId=?";
		return (SecDevice) this.getHibernateTemplate().find(hql, id).get(0);
	}

	
	public void saveNetDevice(NetDevice it) {
		
		this.getHibernateTemplate().save(it);
	}


	public void delNetDevice(NetDevice it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(it);
	}

	
	public NetDevice selNetDevice(int id) {
		// TODO Auto-generated method stub
		String hql="from NetDevice where autoId=?";
		return (NetDevice) this.getHibernateTemplate().find(hql, id).get(0);
	}

	
	public void saveHostMemory(HostMemory it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(it);
	}


	public void delHostMemory(HostMemory it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(it);
	}


	public HostMemory selHostMemory(int id) {
		// TODO Auto-generated method stub
		String hql="from HostMemory where autoId=?";
		return (HostMemory) this.getHibernateTemplate().find(hql, id).get(0);
	}


	public void saveManageFile(ManageFile it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(it);
	}


	public void delManageFile(ManageFile it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(it);
	}


	public ManageFile selManageFile(int id) {
		// TODO Auto-generated method stub
		String hql="from ManageFile where autoId=?";
		return (ManageFile) this.getHibernateTemplate().find(hql, id).get(0);
	}


	public void saveRelaPeople(RelaPeople it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(it);
		
	}

	
	public void delRelaPeople(RelaPeople it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(it);		
	}


	public RelaPeople selRelaPeople(int id) {
		String hql="from RelaPeople where autoId=?";
		return (RelaPeople) this.getHibernateTemplate().find(hql, id).get(0);
	}


	@Override
	public List<MainData> selAllMainData(int corId) {
		// TODO Auto-generated method stub
		String hql = "from MainData as it where it.company.corId=?";
		return (List<MainData>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<AppSoft> selAllAppSoft(int corId) {
		// TODO Auto-generated method stub
		String hql="from AppSoft as it where it.company.corId=?";
		return (List<AppSoft>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<SecDevice> selAllSecDevice(int corId) {
		// TODO Auto-generated method stub
		String hql="from SecDevice as it where it.company.corId=?";
		return (List<SecDevice>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<NetDevice> selAllNetDevice(int corId) {
		// TODO Auto-generated method stub
		String hql="from NetDevice as it where it.company.corId=?";
		return (List<NetDevice>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<HostMemory> selAllHostMemory(int corId) {
		// TODO Auto-generated method stub
		String hql="from HostMemory as it where it.company.corId=?";
		List<HostMemory> tmp = (List<HostMemory>) this.getHibernateTemplate().find(hql, corId);
//		if(tmp.size()==0){
//			String hql1 = "insert into HostMemory  where system.autoId = ?";
//			this.getHibernateTemplate().find(hql1, corId);
//			tmp = (List<HostMemory>) this.getHibernateTemplate().find(hql, corId); 
//		}
		return tmp;
	}


	@Override
	public List<ManageFile> selAllManageFile(int corId) {
		// TODO Auto-generated method stub
		String hql="from ManageFile as it where it.company.corId=?";
		return (List<ManageFile>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<RelaPeople> selAllRelaPeople(int corId) {
		// TODO Auto-generated method stub
		String hql="from RelaPeople as it where it.company.corId=?";
		return (List<RelaPeople>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public void savePhy(Physices it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(it);
	}


	@Override
	public void delPhy(Physices it) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(it);
	}


	@Override
	public Physices selPhy(int id) {
		// TODO Auto-generated method stub
		String hql="from Physices as it where it.autoId = ? ";
		return (Physices) this.getHibernateTemplate().find(hql, id).get(0);
	}


	@Override
	public List<Physices> selAllPhy(int corId) {
		// TODO Auto-generated method stub
		String hql ="from Physices as it where it.company.corId=?";
		return (List<Physices>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<Physices> selPhys(int corId) {
		// TODO Auto-generated method stub
		String hql ="from Physices as it where it.company.corId=? and it.status =1";
		return (List<Physices>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<MainData> selMainDatas(int corId) {
		// TODO Auto-generated method stub
		String hql = "from MainData as it where it.company.corId=? and it.status =1";
		return (List<MainData>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<AppSoft> selAppSofts(int corId) {
		// TODO Auto-generated method stub
		String hql = "from AppSoft as it where it.company.corId=? and it.status = 1";
		return (List<AppSoft>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<SecDevice> selSecDevices(int corId) {
		// TODO Auto-generated method stub
		String hql = "from SecDevice as it where it.company.corId=? and it.status = 1";
		return (List<SecDevice>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<NetDevice> selNetDevices(int corId) {
		// TODO Auto-generated method stub
		String hql = "from NetDevice as it where it.company.corId=? and it.status = 1";
		return (List<NetDevice>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<HostMemory> selHostMemorys(int corId) {
		// TODO Auto-generated method stub
		String hql = "from HostMemory as it where it.company.corId=? and it.status = 1";
		return (List<HostMemory>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<ManageFile> selManageFiles(int corId) {
		// TODO Auto-generated method stub
		String hql = "from ManageFile as it where it.company.corId=? and it.status = 1";
		return (List<ManageFile>) this.getHibernateTemplate().find(hql, corId);
	}


	@Override
	public List<RelaPeople> selRelaPeoples(int corId) {
		// TODO Auto-generated method stub
		String hql = "from RelaPeople as it where it.company.corId=? and it.status = 1";
		return (List<RelaPeople>) this.getHibernateTemplate().find(hql, corId);
	}


}
