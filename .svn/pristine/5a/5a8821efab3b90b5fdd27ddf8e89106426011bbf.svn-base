package cn.edu.ustc.ttcn.itsec.dao;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.AppSoft;
import cn.edu.ustc.ttcn.itsec.model.HostMemory;
import cn.edu.ustc.ttcn.itsec.model.MainData;
import cn.edu.ustc.ttcn.itsec.model.ManageFile;
import cn.edu.ustc.ttcn.itsec.model.NetDevice;
import cn.edu.ustc.ttcn.itsec.model.Physices;
import cn.edu.ustc.ttcn.itsec.model.RelaPeople;
import cn.edu.ustc.ttcn.itsec.model.SecDevice;

public interface InvestInforDao {
	
	public void savePhy(Physices it);
	public void delPhy(Physices it);
	/**
	 * 根据主键查询某
	 * @param id
	 * @return
	 */
	public Physices selPhy(int id);

	/**
	 * 查询某单位 的 物理机房
	 * @param corId
	 * @return List<Physices>
	 */
	public List<Physices> selAllPhy(int corId);
	
	/**
	 * 查询某单位的  作为测评对象的  <物理机房 >
	 * @param corId
	 * @return List<Physices>
	 */
	public List<Physices> selPhys(int corId);
	
	/**
	 * 保存  关键数据 对象
	 * @param it
	 */
	public void saveMainData(MainData it);
	public void delMainData(MainData it);
	
	public MainData selMainData(int id);
	/**
	 * 查询某单位所有的对象
	 * @param corId
	 * @return
	 */
	public List<MainData> selAllMainData(int corId);
	/**
	 * 查询某单位 作为测评对象的 对象 <关键数据>
	 * @param corId
	 * @return
	 */
	public List<MainData> selMainDatas(int corId);
	
	public void saveAppSoft(AppSoft it);
	public void delAppSoft(AppSoft it);
	
	public AppSoft selAppSoft(int id);
	public List<AppSoft> selAllAppSoft(int corId);
	
	/**
	 *  查询某单位 作为测评对象的 对象 <应用软件>
	 * @param corId
	 * @return
	 */
	public List<AppSoft> selAppSofts(int corId);
	
	public void saveSecDevice(SecDevice it);
	public void delSecDevice(SecDevice it);
	public SecDevice selSecDevice(int id);
	public List<SecDevice> selAllSecDevice(int corId);
	
	/**
	 * 查询某单位 作为测评对象的 对象  <安全设备>
	 * @param corId
	 * @return
	 */
	public List<SecDevice> selSecDevices(int corId);
	
	public void saveNetDevice(NetDevice it);
	public void delNetDevice(NetDevice it);
	public NetDevice selNetDevice(int id);
	public List<NetDevice> selAllNetDevice(int corId);
	
	/**
	 * 查询某单位 作为测评对象的 对象   <网络设备>
	 * @param corId
	 * @return
	 */
	public List<NetDevice> selNetDevices(int corId);
	
	public void saveHostMemory(HostMemory it);
	public void delHostMemory(HostMemory it);
	public HostMemory selHostMemory(int id);
	public List<HostMemory> selAllHostMemory(int corId);
	
	/**
	 * 查询某单位 作为测评对象的 对象 <主机和存储>
	 * @param corId 
	 * @return
	 */
	public List<HostMemory> selHostMemorys(int corId);
	
	public void saveManageFile(ManageFile it);
	public void delManageFile(ManageFile it);
	public ManageFile selManageFile(int id);
	public List<ManageFile> selAllManageFile(int corId);
	
	/**
	 * 查询某单位 作为测评对象的 对象 <管理文件>
	 * @param corId
	 * @return
	 */
	public List<ManageFile> selManageFiles(int corId);
	
	public void saveRelaPeople(RelaPeople it);
	public void delRelaPeople(RelaPeople it);
	public RelaPeople selRelaPeople(int id);
	public List<RelaPeople> selAllRelaPeople(int corId);
	
	/**
	 * 查询某单位 作为测评对象的 对象 <安全人员>
	 * @param corId
	 * @return
	 */
	public List<RelaPeople> selRelaPeoples(int corId);
}
