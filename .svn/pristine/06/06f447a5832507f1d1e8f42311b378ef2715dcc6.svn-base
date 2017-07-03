package cn.edu.ustc.ttcn.itsec.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.ustc.ttcn.itsec.dao.InvestInforDao;
import cn.edu.ustc.ttcn.itsec.dao.CompanyDao;
import cn.edu.ustc.ttcn.itsec.dao.ShowSystemInfoDao;
import cn.edu.ustc.ttcn.itsec.model.AppSoft;
import cn.edu.ustc.ttcn.itsec.model.HostMemory;
import cn.edu.ustc.ttcn.itsec.model.MainData;
import cn.edu.ustc.ttcn.itsec.model.ManageFile;
import cn.edu.ustc.ttcn.itsec.model.NetDevice;
import cn.edu.ustc.ttcn.itsec.model.Physices;
import cn.edu.ustc.ttcn.itsec.model.Company;
import cn.edu.ustc.ttcn.itsec.model.RelaPeople;
import cn.edu.ustc.ttcn.itsec.model.SecDevice;
import cn.edu.ustc.ttcn.itsec.model.Systems;

public class InvestInforServiceImpl implements InvestInforService{
	private InvestInforDao investInforDao;
	private ShowSystemInfoDao showSystemInfoDao;
	private CompanyDao companyDao;
	public InvestInforDao getInvestInforDao() {
		return investInforDao;
	}

	public void setInvestInforDao(InvestInforDao investInforDao) {
		this.investInforDao = investInforDao;
	}
	
	public ShowSystemInfoDao getShowSystemInfoDao() {
		return showSystemInfoDao;
	}

	public void setShowSystemInfoDao(ShowSystemInfoDao showSystemInfoDao) {
		this.showSystemInfoDao = showSystemInfoDao;
	}
	

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public void insertMainData(int id) {
		// TODO Auto-generated method stub
		MainData tmp = new MainData();
		Company it = companyDao.selMCompany(id);
		tmp.setCompany(it);	
		investInforDao.saveMainData(tmp);
		
	}
	public void insertAppSoft(int id) {
		AppSoft tmp = new AppSoft();
		Company it = companyDao.selMCompany(id);
		tmp.setCompany(it);	
		investInforDao.saveAppSoft(tmp);
	}


	public void insertHostMemory(int id) {
		HostMemory tmp = new HostMemory();
		Company it = companyDao.selMCompany(id);
		tmp.setCompany(it);	
		investInforDao.saveHostMemory(tmp);
		
	}

	
	public void insertSecDevice(int id) {
		SecDevice tmp = new SecDevice();
		Company it = companyDao.selMCompany(id);
		tmp.setCompany(it);	
		investInforDao.saveSecDevice(tmp);
	}

	
	public void insertNetDevice(int id) {
		
		NetDevice tmp = new NetDevice();
		Company it = companyDao.selMCompany(id);
		tmp.setCompany(it);
		investInforDao.saveNetDevice(tmp);
	}	
	public void insertRelaPeople(int id) {
		RelaPeople tmp = new RelaPeople();
		Company it = companyDao.selMCompany(id);
		tmp.setCompany(it);	
		investInforDao.saveRelaPeople(tmp);
		
	}	
	public void insertManageFile(int id) {
		ManageFile tmp = new ManageFile();
		Company it = companyDao.selMCompany(id);
		tmp.setCompany(it);
		investInforDao.saveManageFile(tmp);
	}
	
	@Override
	public Map<String,Object> showAll(int corId) {
		// TODO Auto-generated method stub
		Map<String, Object> it = new HashMap();
		
		List<Physices> phy = new ArrayList<Physices>();
		phy = investInforDao.selAllPhy(corId);
		it.put("phy", phy);
		
		List<MainData> md = new ArrayList<MainData>();
		md =  investInforDao.selAllMainData(corId);
		
		//若MainData数据表无数据，新建一条空的数据项
//		if(md.size() == 0){
//			insertMainData(corId);						
//		}
		it.put("mainData", md);
		List<AppSoft> as = new ArrayList<AppSoft>();
		as = investInforDao.selAllAppSoft(corId);
		if(as !=null){
			it.put("appSoft", as);
		}
		
		List<HostMemory> hm = new ArrayList<HostMemory>();
		hm = investInforDao.selAllHostMemory(corId);
		if(hm!=null){
			it.put("hostMemory", hm);
		}
		
		List<SecDevice> sd = new ArrayList<SecDevice>();
		sd = investInforDao.selAllSecDevice(corId);
		if(sd!=null){
			it.put("secDevice", sd);
		}
		
		List<NetDevice> nd = new ArrayList<NetDevice>();
		nd = investInforDao.selAllNetDevice(corId);
		if(nd!=null){
			it.put("netDevice", nd);
		}
		
		List<RelaPeople> rp = new ArrayList<RelaPeople>();
		rp = investInforDao.selAllRelaPeople(corId);	
		if(rp!=null){
			it.put("relaPeople", rp);
		}
		
		List<ManageFile> mf = new ArrayList<ManageFile>();
		mf = investInforDao.selAllManageFile(corId);
		if(mf!=null){
			it.put("manageFile", mf);
		}
		
		return it;
	}

	@Override
	public void delMainData(int id) {
		
		MainData temp = investInforDao.selMainData(id);
		investInforDao.delMainData(temp);
	}

	@Override
	public void delAppSoft(int id) {
		
		AppSoft temp = investInforDao.selAppSoft(id);
		investInforDao.delAppSoft(temp);
	}

	@Override
	public void delHostMemory(int id) {
		HostMemory temp = investInforDao.selHostMemory(id);
		investInforDao.delHostMemory(temp);
	}

	@Override
	public void delSecDevice(int id) {
		SecDevice temp = investInforDao.selSecDevice(id);
		investInforDao.delSecDevice(temp);
		
	}

	@Override
	public void delNetDevice(int id) {
		NetDevice temp = investInforDao.selNetDevice(id);
		investInforDao.delNetDevice(temp);
	}

	@Override
	public void delRelaPeople(int id) {
		RelaPeople temp = investInforDao.selRelaPeople(id);
		investInforDao.delRelaPeople(temp);
	}

	@Override
	public void delManageFile(int id) {
		ManageFile temp = investInforDao.selManageFile(id);
		investInforDao.delManageFile(temp);
	}

	@Override
	public void updateMainData(int id, String dataType, String appSoft,
			String hostMemory, String important, String url) {
		// TODO Auto-generated method stub
		MainData tmp = investInforDao.selMainData(id);
		
			tmp.setName(dataType);
			tmp.setAppSoft(appSoft);
			tmp.setHostMemory(hostMemory);
			tmp.setImportant(important);
			investInforDao.saveMainData(tmp);
	}

	@Override
	public void updateAppSoft(int id, String name, String usedFor,
			String important, String url) {
		AppSoft tmp = investInforDao.selAppSoft(id);
		
			tmp.setName(name);
			tmp.setUsedFor(usedFor);
			tmp.setImportant(important);
	
			investInforDao.saveAppSoft(tmp);
	}

	@Override
	public void updateHostMemory(int id, String name, String osSystem,
			String usedFor, String url) {
		HostMemory tmp = investInforDao.selHostMemory(id);
		
			tmp.setName(name);
			tmp.setOsSystem(osSystem);
			tmp.setUsedFor(usedFor);			
		
		investInforDao.saveHostMemory(tmp);
	}

	@Override
	public void updateNetDevice(int id, String madeFrom, String usedFor,
			String important, String url) {
		NetDevice tmp = investInforDao.selNetDevice(id);
		
			tmp.setName(madeFrom);
			tmp.setUsedFor(usedFor);
			tmp.setImportant(important);
		
		investInforDao.saveNetDevice(tmp);				
	}

	@Override
	public void updateSecDevice(int id, String madeFrom, String usedFor,
			String important, String url) {
		SecDevice tmp = investInforDao.selSecDevice(id);
	
			tmp.setName(madeFrom);
			tmp.setUsedFor(usedFor);
			tmp.setImportant(important);
		
		investInforDao.saveSecDevice(tmp);		
	}

	@Override
	public void updateRelaPeople(int id, String name, String position,
			String contact, String url) {
		RelaPeople tmp = investInforDao.selRelaPeople(id);
		
			tmp.setName(name);
			tmp.setPosition(position);
			tmp.setContact(contact);
		
		investInforDao.saveRelaPeople(tmp);
	}

	@Override
	public void updateManageFile(int id, String name, String mainPoint, String url) {
		ManageFile tmp = investInforDao.selManageFile(id);
		
			tmp.setName(name);
			tmp.setMainPoint(mainPoint);
		
			investInforDao.saveManageFile(tmp);
	}

	@Override
	public void chooseMainData(String[] mdIds, int SysId) {
		List<MainData> md = new ArrayList<MainData>();
		/**
		 * 查询出所有的数据，与从客户端传来的值进行比较
		 */
		md =  investInforDao.selAllMainData(SysId);
		
		if(md.size() >0){
			for(int i=0; i< md.size(); i++){
				
				MainData tmp = md.get(i);
				int autoId = tmp.getAutoId();
				int mark = 0;//作为标记
				
				/**
				 * 将从客户端传来的数据项对应的status设为1
				 */
				if(mdIds != null){
					int length = mdIds.length;
					for(int j=0; j<length; j++){
						int id = Integer.valueOf(mdIds[j]);
						if(autoId == id){
							tmp.setStatus(1);
							investInforDao.saveMainData(tmp);
							mark = 1;
						}
					}
				}
				/**
				 * 其他数据项对应的status设为0
				 */
				if(mark ==0){
					tmp.setStatus(0);
					investInforDao.saveMainData(tmp);
				}
			}
		}
	}

	@Override
	public void chooseAppSoft(String[] asIds, int SysId) {
		List<AppSoft> as = new ArrayList<AppSoft>();
		as = investInforDao.selAllAppSoft(SysId);
		if(as.size() >0){
			for(int i=0; i< as.size(); i++){
				AppSoft tmp = as.get(i);
				int autoId = tmp.getAutoId();
				int mark = 0;
				 
				if(asIds != null){
					int length = asIds.length;
					for(int j=0; j<length; j++){
						int id = Integer.valueOf(asIds[i]);
						if(autoId == id){
							tmp.setStatus(1);
							investInforDao.saveAppSoft(tmp);
							mark =1;
						}
					}
				}
				
				if(mark == 0){
					tmp.setStatus(0);
					investInforDao.saveAppSoft(tmp);
				}				
			}
		}
	}

	@Override
	public void chooseHostMemory(String[] hmIds , int SysId) {
		List<HostMemory> hm = new ArrayList<HostMemory>();
		hm = investInforDao.selAllHostMemory(SysId);
		if(hm.size() >0){
			for(int i=0; i< hm.size(); i++){
				HostMemory tmp = hm.get(i);
				int autoId = tmp.getAutoId();
				int mark = 0;
				 
				if(hmIds != null){
					int length = hmIds.length;
					for(int j =0; j<length; j++){
						int id = Integer.valueOf(hmIds[j]);
						if(autoId == id){
							tmp.setStatus(1);
							investInforDao.saveHostMemory(tmp);
							mark = 1;
						}
					}
				}
				
				if(mark == 0){
					tmp.setStatus(0);
					investInforDao.saveHostMemory(tmp);
				}
			}
		}
	}


	@Override
	public void chooseNetDevice(String[] ndIds, int SysId) {
		List<NetDevice> nd = new ArrayList<NetDevice>();
		nd = investInforDao.selAllNetDevice(SysId);
		if(nd.size() >0){
			for(int i=0; i< nd.size(); i++){
				NetDevice tmp = nd.get(i);
				int autoId = tmp.getAutoId();
				int mark = 0;
				
				
				if(ndIds != null){
					int length = ndIds.length;
					for(int j =0; j<length; j++){
						int id = Integer.valueOf(ndIds[j]);
						if(autoId == id){
							tmp.setStatus(1);
							investInforDao.saveNetDevice(tmp);
							mark = 1;
						}
					}
				}
				if(mark == 0){
					tmp.setStatus(0);
					investInforDao.saveNetDevice(tmp);
				}				
			}
		}
	}

	@Override
	public void chooseSecDevice(String[] sdIds, int SysId) {
		List<SecDevice> sd = new ArrayList<SecDevice>();
		sd = investInforDao.selAllSecDevice(SysId);
		if(sd.size() >0){
			for(int i=0; i< sd.size(); i++){
				SecDevice tmp = sd.get(i);
				int autoId = tmp.getAutoId();
				int mark = 0;
				
				
				if(sdIds != null){
					int length = sdIds.length;
					for(int j =0; j<length; j++){
						int id = Integer.valueOf(sdIds[j]);
						if(autoId == id){
							tmp.setStatus(1);
							investInforDao.saveSecDevice(tmp);
							mark = 1;
						}
					}
				}
				if(mark == 0){
					tmp.setStatus(0);
					investInforDao.saveSecDevice(tmp);
				}				
			}
		}
	}

	@Override
	public void chooseRelaPeople(String[] rpIds, int SysId) {
		List<RelaPeople> rp = new ArrayList<RelaPeople>();
		rp = investInforDao.selAllRelaPeople(SysId);
		if(rp.size() >0){
			for(int i=0; i< rp.size(); i++){
				RelaPeople tmp = rp.get(i);
				int autoId = tmp.getAutoId();
				int mark = 0;
				
				
				if(rpIds != null){
					int length = rpIds.length;
					for(int j =0; j<length; j++){
						int id = Integer.valueOf(rpIds[j]);
						if(autoId == id){
							tmp.setStatus(1);
							investInforDao.saveRelaPeople(tmp);
							mark = 1;
						}
					}
				}
				if(mark == 0){
					tmp.setStatus(0);
					investInforDao.saveRelaPeople(tmp);
				}
				
			}
		}
	}

	@Override
	public void chooseManageFile(String[] mfIds, int SysId) {
		List<ManageFile> mf = new ArrayList<ManageFile>();
		mf = investInforDao.selAllManageFile(SysId);
		if(mf.size() >0){
			for(int i=0; i< mf.size(); i++){
				ManageFile tmp = mf.get(i);
				int autoId = tmp.getAutoId();
				int mark = 0;
								
				if(mfIds != null){
					int length = mfIds.length;
					for(int j =0; j<length; j++){
						int id = Integer.valueOf(mfIds[j]);
						if(autoId == id){
							tmp.setStatus(1);
							investInforDao.saveManageFile(tmp);
							mark = 1;
						}
					}
				}
				if(mark == 0){
					tmp.setStatus(0);
					investInforDao.saveManageFile(tmp);
				}
			}
		}
	}

	@Override
	public void saveMainData(int corId,List<Object> list) {
		// TODO Auto-generated method stub
		String dataType = list.get(0).toString();
		String appSoft = list.get(1).toString();
		String hostMemory = list.get(2).toString();
		String important =list.get(3).toString();
		
		MainData tmp = new MainData();
		Company it = companyDao.selMCompany(corId);
		
		tmp.setCompany(it);
		tmp.setAppSoft(appSoft);
		tmp.setImportant(important);
		tmp.setHostMemory(hostMemory);
		tmp.setName(dataType);
		
		investInforDao.saveMainData(tmp);
	}

	@Override
	public void saveAppSoft(int corId,List<Object> list) {
		// TODO Auto-generated method stub
		
		String name = list.get(0).toString();
		String usedFor = list.get(1).toString();
		String important = list.get(2).toString();
		
		AppSoft tmp = new AppSoft();
		Company it = companyDao.selMCompany(corId);
		
		tmp.setCompany(it);
		tmp.setName(name);
		tmp.setImportant(important);
		tmp.setUsedFor(usedFor);
		
		investInforDao.saveAppSoft(tmp);
	}

	@Override
	public void saveHostMemory(int corId,List<Object> list ) {
		// TODO Auto-generated method stub
		
		String name = list.get(0).toString();
		String osSystem = list.get(1).toString();
		String usedFor = list.get(2).toString();
		
		HostMemory tmp = new HostMemory();
		Company it = companyDao.selMCompany(corId);
		
		tmp.setCompany(it);
		tmp.setName(name);
		tmp.setOsSystem(osSystem);
		tmp.setUsedFor(usedFor);
		
		investInforDao.saveHostMemory(tmp);
	}

	@Override
	public void saveNetDevice(int corId, List<Object> list ) {
		// TODO Auto-generated method stub
		
		String madeFrom = list.get(0).toString();
		String usedFor = list.get(1).toString();
		String important = list.get(2).toString();
		
		NetDevice tmp = new NetDevice();
		Company it = companyDao.selMCompany(corId);
		
		tmp.setCompany(it);
		tmp.setName(madeFrom);
		tmp.setUsedFor(usedFor);
		tmp.setImportant(important);
		
		investInforDao.saveNetDevice(tmp);
	}

	@Override
	public void saveSecDevice(int corId, List<Object> list) {
		// TODO Auto-generated method stub
		String madeFrom = list.get(0).toString();
		String usedFor = list.get(1).toString();
		String important = list.get(2).toString();
		
		SecDevice tmp = new SecDevice();
		Company it = companyDao.selMCompany(corId);
		
		tmp.setCompany(it);
		tmp.setName(madeFrom);
		tmp.setUsedFor(usedFor);
		tmp.setImportant(important);
		
		investInforDao.saveSecDevice(tmp);
	}

	@Override
	public void saveRelaPeople(int corId, List<Object> list) {
		// TODO Auto-generated method stub
		
		 String name = list.get(0).toString(); 
		 String position = list.get(1).toString();
		 String contact = list.get(2).toString();
		 
		RelaPeople tmp = new RelaPeople();
		Company it = companyDao.selMCompany(corId);
		
		tmp.setCompany(it);
		tmp.setName(name);
		tmp.setPosition(position);
		tmp.setContact(contact);
		
		investInforDao.saveRelaPeople(tmp);
	}

	@Override
	public void saveManageFile(int corId,List<Object> list ) {
		// TODO Auto-generated method stub
		String name = list.get(0).toString();
		String mainPoint = "";
		
		ManageFile tmp = new ManageFile();
		Company it = companyDao.selMCompany(corId);
		
		tmp.setCompany(it);
		tmp.setMainPoint(mainPoint);
		tmp.setName(name);
		
		investInforDao.saveManageFile(tmp);
	}

	public void saveWholePackage(int corId, Map<String, List<List<Object>>> it) {
		// TODO Auto-generated method stub
		for(int s=0; s<it.size();s++){
			List<List<Object>> tmp = (List<List<Object>>) it.get(String.valueOf(s));//得到一个sheet表
			int length = tmp.size(); //获得一个sheet表中数据行数
//			System.out.println("s"+s+"length"+length);
			if(length >0){
				for(int i=0; i<length;i++){
					List<Object> j = tmp.get(i);//得到某个sheet表中   第i行（从0开始）的数据
					switch(s){
					case 0:
						savePhy(corId, j);
						break;
					case 1:
						saveMainData(corId, j);
						break;
					case 2:
						saveAppSoft(corId,j);
						break;
					case 3:
						saveHostMemory(corId,j);
						break;
					case 4:
						saveNetDevice(corId,j);
						break;
					case 5:
						saveSecDevice(corId,j);
						break;
						
					case 6:
						saveRelaPeople(corId,j);
						break;
					case 7:
						saveManageFile(corId, j);
						break;
					default:
						break;
					}
					
				}
			}
		}
		
		
		
		
		
	}

	@Override
	public void insertPhy(int id) {
		// TODO Auto-generated method stub
		Physices tmp = new Physices();
		
		Company it = companyDao.selMCompany(id);
		
		tmp.setCompany(it);
		investInforDao.savePhy(tmp);
	}

	@Override
	public void delPhy(int id) {
		// TODO Auto-generated method stub
		Physices tmp = investInforDao.selPhy(id);
		investInforDao.delPhy(tmp);
	}

	@Override
	public void updatePhy(int id, String name, String location, String url) {
		// TODO Auto-generated method stub
		Physices tmp = investInforDao.selPhy(id);
		tmp.setName(name);
		tmp.setLocation(location);
		
		investInforDao.savePhy(tmp);
	}

	@Override
	public void savePhy(int corId, List<Object> list) {
		// TODO Auto-generated method stub
		String name = list.get(0).toString();
		String location = list.get(1).toString();
		
		Physices tmp = new Physices();
		
		Company it = companyDao.selMCompany(corId);
		
		tmp.setCompany(it);
		tmp.setName(name);
		tmp.setLocation(location);
		investInforDao.savePhy(tmp);
	}

	@Override
	public void choosePhy(String[] phyIds, int SysId) {
		// TODO Auto-generated method stub
		List<Physices> tmp = investInforDao.selAllPhy(SysId);
		for(int i=0; i<tmp.size();i++){
			Physices it = tmp.get(i);
			int id = it.getAutoId();
			
			int mark=0;
			
			
			for(int j=0;j<phyIds.length;j++){
				if(Integer.valueOf(phyIds[j]) == id){
					it.setStatus(1);
					investInforDao.savePhy(it);
					mark = 1;
				}
			}
			if(mark == 0){
				it.setStatus(0);
				investInforDao.savePhy(it);
			}
		}
	}

	@Override
	public Map<String, Object> showMAll(int corId) {
		// TODO Auto-generated method stub
		Map<String, Object> it = new HashMap();
		List<Physices> phy = new ArrayList<Physices>();
		phy = investInforDao.selPhys(corId);
		it.put("phy", phy);
		
		List<MainData> md = new ArrayList<MainData>();
		md =  investInforDao.selMainDatas(corId);
		
		it.put("mainData", md);
		List<AppSoft> as = new ArrayList<AppSoft>();
		as = investInforDao.selAppSofts(corId);
		
		it.put("appSoft", as);

		
		List<HostMemory> hm = new ArrayList<HostMemory>();
		hm = investInforDao.selHostMemorys(corId);
	
		it.put("hostMemory", hm);
	
		
		List<SecDevice> sd = new ArrayList<SecDevice>();
		sd = investInforDao.selSecDevices(corId);

		it.put("secDevice", sd);

		
		List<NetDevice> nd = new ArrayList<NetDevice>();
		nd = investInforDao.selNetDevices(corId);

		it.put("netDevice", nd);

		
		List<RelaPeople> rp = new ArrayList<RelaPeople>();
		rp = investInforDao.selRelaPeoples(corId);	
	
		it.put("relaPeople", rp);

		
		List<ManageFile> mf = new ArrayList<ManageFile>();
		mf = investInforDao.selManageFiles(corId);

		it.put("manageFile", mf);

		return it;
	}


}
