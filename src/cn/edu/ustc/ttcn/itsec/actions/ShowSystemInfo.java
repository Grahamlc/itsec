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
	//����ϵͳ
	private TestSystem testSys;
	//��ʷ����
	private List<TestSystem> oldTestSys;
	//����ϵͳ�Ĳ���ʦ
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
	 * ����ϵͳ��������ѯĳϵͳ��Ϣ
	 * ������Ŀ��Ϣ������ʦ��
	 * @return
	 */
	public String execute(){
		
		 // �г����еĲ���ʦ����ѡ��
		testers = new ArrayList<Tester>();
		testers = superService.query_all_tester();
		
		//����ĳ��λ��ϵͳ �����ϵͳ�ľ��������Ϣ
		url = request.getParameter("url");
		id=Integer.valueOf(request.getParameter("sysId"));
		
		system = new ArrayList<Systems>();
		system = (List<Systems>) showSystemInfoService.ShowSysteminfo(id);

		/**
		 * ���õ�λĳϵͳ�Ѿ���ʼ���� 
		 * **/		
//		if(system.get(0).getState() > 0){
			
			testSys = new TestSystem();
			oldTestSys = new ArrayList<TestSystem>();

			Iterator<TestSystem> testSyses = system.get(0).getTestSystem().iterator(); 
			while(testSyses.hasNext()){
				TestSystem it = testSyses.next();
				if(it.getMark() == 1){
					testSys = it; //Ŀǰ���ڽ��еĲ�����Ŀ
				}else{
					oldTestSys.add(it); //��ʷ������Ŀ
				}
			}
			
			
			 //���Ѿ������˲���ʦ  ���������ʦ��Ϣ
			 
			if(testSys.getCpState() > 1){
				sysTester = new HashSet<TesterOfSystem>();
				sysTester =  testSys.getSysTester();
			}	

		return "success";
	}

}
