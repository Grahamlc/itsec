package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;




import cn.edu.ustc.ttcn.itsec.model.Objects;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;
import cn.edu.ustc.ttcn.itsec.service.ShowSystemInfoService;




public class ShowSysTester implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ShowSystemInfoService showSystemInfoService;
	private int id;
	private List<Systems> system;
	//被测系统
	private TestSystem testSys;
//	private TestSystemService testSystemService;
	//被测系统的测评师
	private Set<TesterOfSystem> sysTester;
	
	private List<Objects> objects;


	
	private Map<Objects,List<TestObject>> tempMap;
	private Map<Objects,List<TestObject>> map;

	private List<Tester> testers;


	private Map<String, Object> sysTestObject;

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

	public List<Tester> getTesters() {
		return testers;
	}
	public void setTesters(List<Tester> testers) {
		this.testers = testers;
	}
	

	
}
