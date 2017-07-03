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

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.MainData;
import cn.edu.ustc.ttcn.itsec.model.Objects;
import cn.edu.ustc.ttcn.itsec.model.Company;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;
import cn.edu.ustc.ttcn.itsec.service.DeviceService;
import cn.edu.ustc.ttcn.itsec.service.InvestInforService;
import cn.edu.ustc.ttcn.itsec.service.ObjectService;
import cn.edu.ustc.ttcn.itsec.service.ShowObjectService;
import cn.edu.ustc.ttcn.itsec.service.ShowSystemInfoService;
import cn.edu.ustc.ttcn.itsec.service.SuperService;




public class ShowSystemInfo implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ShowSystemInfoService showSystemInfoService;
	private int id;
	private List<Systems> system;
	private String url;
	//被测系统
	private TestSystem testSys;
	//历史测评
	private List<TestSystem> oldTestSys;
	//被测系统的测评师
	private Set<TesterOfSystem> sysTester;
	
	private List<Objects> objects;
	private ObjectService objectService;
	private ShowObjectService showObjectService;

	
	private Map<Objects,List<TestObject>> tempMap;
	private Map<Objects,List<TestObject>> map;

	private List<Tester> testers;
	private SuperService superService;

	private Map<String, Object> sysTestObject;
	private InvestInforService investInforService;
	
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
	public Map<Objects, List<TestObject>> getMap() {
		return map;
	}
	public void setMap(Map<Objects, List<TestObject>> map) {
		this.map = map;
	}

	public Map<Objects, List<TestObject>> getTempMap() {
		return tempMap;
	}
	public void setTempMap(Map<Objects, List<TestObject>> tempMap) {
		this.tempMap = tempMap;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public List<TestSystem> getOldTestSys() {
		return oldTestSys;
	}
	public void setOldTestSys(List<TestSystem> oldTestSys) {
		this.oldTestSys = oldTestSys;
	}
	public List<Systems> getSystem() {
		return system;
	}
	public void setSystem(List<Systems> system) {
		this.system = system;
	}
	public ShowSystemInfoService getShowSystemInfoService() {
		return showSystemInfoService;
	}
	public void setShowSystemInfoService(ShowSystemInfoService showSystemInfoService) {
		this.showSystemInfoService = showSystemInfoService;
	}
	
	public TestSystem getTestSys() {
		return testSys;
	}
	public void setTestSys(TestSystem testSys) {
		this.testSys = testSys;
	}
	
	
	public Set<TesterOfSystem> getSysTester() {
		return sysTester;
	}
	public void setSysTester(Set<TesterOfSystem> sysTester) {
		this.sysTester = sysTester;
	}
	
	public List<Objects> getObjects() {
		return objects;
	}
	public void setObjects(List<Objects> objects) {
		this.objects = objects;
	}
	
	public ObjectService getObjectService() {
		return objectService;
	}
	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}
	
	public ShowObjectService getShowObjectService() {
		return showObjectService;
	}
	public void setShowObjectService(ShowObjectService showObjectService) {
		this.showObjectService = showObjectService;
	}
	
	public List<Tester> getTesters() {
		return testers;
	}
	public void setTesters(List<Tester> testers) {
		this.testers = testers;
	}
	
	
	
	public SuperService getSuperService() {
		return superService;
	}
	public void setSuperService(SuperService superService) {
		this.superService = superService;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 根据系统的主键查询某系统信息
	 * 被测项目信息、测评师等
	 * @return
	 */
	public String execute(){
		
		 // 列出所有的测评师，供选择
		testers = new ArrayList<Tester>();
		testers = superService.query_all_tester();
		
		//根据某单位的系统 输出该系统的具体测评信息
		url = request.getParameter("url");
		id=Integer.valueOf(request.getParameter("sysId"));
		
		system = new ArrayList<Systems>();
		system = (List<Systems>) showSystemInfoService.ShowSysteminfo(id);

		/**
		 * 若该单位某系统已经开始测评 
		 * **/		
//		if(system.get(0).getState() > 0){
			
			testSys = new TestSystem();
			oldTestSys = new ArrayList<TestSystem>();

			Iterator<TestSystem> testSyses = system.get(0).getTestSystem().iterator(); 
			while(testSyses.hasNext()){
				TestSystem it = testSyses.next();
				if(it.getMark() == 1){
					testSys = it; //目前正在进行的测评项目
				}else{
					oldTestSys.add(it); //历史测评项目
				}
			}
			
			
			 //若已经分配了测评师  则输出测评师信息
			 
			if(testSys.getCpState() > 1){
				sysTester = new HashSet<TesterOfSystem>();
				sysTester =  testSys.getSysTester();
			}	

		return "success";
	}

}
