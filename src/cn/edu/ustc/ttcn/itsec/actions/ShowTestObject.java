package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.AppSoft;
import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.HostMemory;
import cn.edu.ustc.ttcn.itsec.model.MainData;
import cn.edu.ustc.ttcn.itsec.model.ManageFile;
import cn.edu.ustc.ttcn.itsec.model.NetDevice;
import cn.edu.ustc.ttcn.itsec.model.Objects;
import cn.edu.ustc.ttcn.itsec.model.Physices;
import cn.edu.ustc.ttcn.itsec.model.RelaPeople;
import cn.edu.ustc.ttcn.itsec.model.SecDevice;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;
import cn.edu.ustc.ttcn.itsec.service.InvestInforService;
import cn.edu.ustc.ttcn.itsec.service.ObjectService;
import cn.edu.ustc.ttcn.itsec.service.ShowObjectService;
import cn.edu.ustc.ttcn.itsec.service.ShowSystemInfoService;
import cn.edu.ustc.ttcn.itsec.service.TestObjectService;
import cn.edu.ustc.ttcn.itsec.service.TestSystemService;

public class ShowTestObject implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ShowObjectService showObjectService;
	private TestObjectService testObjectService;
	private int testSysId;
	private ObjectService objectService;
	private List<Objects> objects;
	private List<TestObject> CpObject;
	
	private List<Physices> phy;
	private List<MainData> mds;
	private List<AppSoft> ass;
	private List<HostMemory> hms;
	private List<NetDevice> nds;
	private List<SecDevice> sds;
	private List<ManageFile> mfs;
	private List<RelaPeople> rps;
	
	
	private Systems system;
	private ShowSystemInfoService showSystemInfoService;
	private List<TestSystem> testSyses;
	private Set<TesterOfSystem> sysTester;
	private Map<String, Object> sysTestObject;
	private InvestInforService investInforService;
	
	private String url;
	private int id;
	private int mark;
	
	private TestSystemService testSystemService;
	
	public TestSystemService getTestSystemService() {
		return testSystemService;
	}
	public void setTestSystemService(TestSystemService testSystemService) {
		this.testSystemService = testSystemService;
	}
	public List<Physices> getPhy() {
		return phy;
	}
	public void setPhy(List<Physices> phy) {
		this.phy = phy;
	}
	public List<HostMemory> getHms() {
		return hms;
	}
	public void setHms(List<HostMemory> hms) {
		this.hms = hms;
	}
	public List<NetDevice> getNds() {
		return nds;
	}
	public void setNds(List<NetDevice> nds) {
		this.nds = nds;
	}
	public List<SecDevice> getSds() {
		return sds;
	}
	public void setSds(List<SecDevice> sds) {
		this.sds = sds;
	}
	public List<ManageFile> getMfs() {
		return mfs;
	}
	public void setMfs(List<ManageFile> mfs) {
		this.mfs = mfs;
	}
	public List<RelaPeople> getRps() {
		return rps;
	}
	public void setRps(List<RelaPeople> rps) {
		this.rps = rps;
	}
	public List<MainData> getMds() {
		return mds;
	}
	public void setMds(List<MainData> mds) {
		this.mds = mds;
	}
	
	
	public List<AppSoft> getAss() {
		return ass;
	}
	public void setAss(List<AppSoft> ass) {
		this.ass = ass;
	}
	public TestObjectService getTestObjectService() {
		return testObjectService;
	}
	public void setTestObjectService(TestObjectService testObjectService) {
		this.testObjectService = testObjectService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public InvestInforService getInvestInforService() {
		return investInforService;
	}
	public void setInvestInforService(InvestInforService investInforService) {
		this.investInforService = investInforService;
	}
	public Map<String, Object> getSysTestObject() {
		return sysTestObject;
	}
	public void setSysTestObject(Map<String, Object> sysTestObject) {
		this.sysTestObject = sysTestObject;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response  = arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public ShowObjectService getShowObjectService() {
		return showObjectService;
	}
	public void setShowObjectService(ShowObjectService showObjectService) {
		this.showObjectService = showObjectService;
	}
	
	
	public List<TestSystem> getTestSyses() {
		return testSyses;
	}
	public void setTestSyses(List<TestSystem> testSyses) {
		this.testSyses = testSyses;
	}
	public ShowSystemInfoService getShowSystemInfoService() {
		return showSystemInfoService;
	}
	public void setShowSystemInfoService(ShowSystemInfoService showSystemInfoService) {
		this.showSystemInfoService = showSystemInfoService;
	}
	
	public Systems getSystem() {
		return system;
	}
	public void setSystem(Systems system) {
		this.system = system;
	}
	public int getTestSysId() {
		return testSysId;
	}
	public void setTestSysId(int testSysId) {
		this.testSysId = testSysId;
	}
	public ObjectService getObjectService() {
		return objectService;
	}
	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}
	public List<Objects> getObjects() {
		return objects;
	}
	public void setObjects(List<Objects> objects) {
		this.objects = objects;
	}
	
	public List<TestObject> getCpObject() {
		return CpObject;
	}
	public void setCpObject(List<TestObject> cpObject) {
		CpObject = cpObject;
	}
	
	public Set<TesterOfSystem> getSysTester() {
		return sysTester;
	}
	public void setSysTester(Set<TesterOfSystem> sysTester) {
		this.sysTester = sysTester;
	}
	@SuppressWarnings("unchecked")
	public String execute(){
		
		/**
		 * 输出某系统所有的历史、当前的被测记录
		 */
		url = request.getParameter("url");
		mark = Integer.valueOf(request.getParameter("mark"));//标记历史测评OR当前测评信息
		
		/**
		 * 输出项目经理筛选出的所有测评对象
		 */
		if(request.getParameter("corId") != null){
			int corId = Integer.valueOf(request.getParameter("corId"));
			sysTestObject = new LinkedHashMap<String, Object>();
			sysTestObject = investInforService.showAll(corId);
			
			phy = (List<Physices>) sysTestObject.get("phy");
			mds = (List<MainData>) sysTestObject.get("mainData");
			ass = (List<AppSoft>) sysTestObject.get("appSoft");
//			System.out.println(ass.get(0).getName());
			
			hms = (List<HostMemory>) sysTestObject.get("hostMemory");
			nds = (List<NetDevice>) sysTestObject.get("netDevice");
			sds = (List<SecDevice>) sysTestObject.get("secDevice");
			rps = (List<RelaPeople>) sysTestObject.get("relaPeople");
			mfs = (List<ManageFile>) sysTestObject.get("manageFile");
		}
		
		/**
		 * 列举出所有的测评对象
		 
		 * 物理安全、网络全局、应用安全、主机安全、数据库安全、数据安全、管理等
		 */
		 objects = new ArrayList<Objects>();
		 objects = objectService.showAllObjects();
		 
		 
		
		if(request.getParameter("testSysId") == null){
			
			id = Integer.valueOf(request.getParameter("sysId"));
			
			system =  showSystemInfoService.ShowSysteminfo(id).get(0);
						
			testSyses = new ArrayList<TestSystem>();
			
			/**
			 * 得到当前被测评系统记录
			 */
//			if(system.get(0).getTestSystem() != null){
				
				Iterator<TestSystem> it = system.getTestSystem().iterator();
				
				while(it.hasNext()){
					TestSystem ts = it.next();
					if(ts.getMark() == mark){
		
						testSyses.add(ts);
					}
				}
				
				
				/**
				 * 获得 不同层次的测评对象 信息
				 * 输出数据库testobject表中某一特定被测系统（ProId）下所有测评对象类型（ObjectId）
				 * 
				 */			
				if(mark == 1 && testSyses.size() > 0){
					/**
					 * 当前测评情况
					 * 测评人员
					 */
					testSysId = testSyses.get(0).getAutoId();
					
					sysTester = new HashSet<TesterOfSystem>();
					sysTester =  testSyses.get(0).getSysTester();
					
				}
				if(mark == 0 && testSyses.size() > 0){
					//历史测评情况
					testSysId = Integer.valueOf(request.getParameter("testSysId"));
				}
				
//			}//if(system.get(0).getTestSystem() != null)

				
		}else{
			testSysId = Integer.valueOf(request.getParameter("testSysId"));
			
			sysTester = new HashSet<TesterOfSystem>();
			sysTester = testSystemService.queryMTestSys(testSysId).get(0).getSysTester();
			
			system = testSystemService.queryMTestSys(testSysId).get(0).getSystem();
		} 
		//待修整
		CpObject = new ArrayList<TestObject>();
		CpObject = testObjectService.showTestObject(testSysId);
	
		
		
		
		return "success";
	}

	
	/**
	 * 查询历史测评
	 * @return
	 */
	public String showHistory(){
		
		url = request.getParameter("url");
		mark = Integer.valueOf(request.getParameter("mark"));//标记历史测评OR当前测评信息
				
		id = Integer.valueOf(request.getParameter("sysId"));
		
		
		system =  showSystemInfoService.ShowSysteminfo(id).get(0);
		
		testSyses = new ArrayList<TestSystem>();
		
		/**
		 * 得到当前被测评系统记录
		 */
		Iterator<TestSystem> it = system.getTestSystem().iterator();
		
		while(it.hasNext()){
			TestSystem ts = it.next();
			if(ts.getMark() == mark){

				testSyses.add(ts);
			}
		}
	
		return "history";
		
	}
}
