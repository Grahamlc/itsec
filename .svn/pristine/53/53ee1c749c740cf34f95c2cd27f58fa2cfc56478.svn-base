package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.service.SystemService;
import cn.edu.ustc.ttcn.itsec.service.MOService;
import cn.edu.ustc.ttcn.itsec.service.ShowSystemInfoService;
import cn.edu.ustc.ttcn.itsec.service.TestSystemService;


public class MO implements ServletRequestAware, ServletResponseAware {
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String corId;
	private String[] sysIds;
	private int testSysId;
	private int sysId;
	private SystemService addSystemService;
	private ShowSystemInfoService showSystemInfoService;
	private TestSystemService testSystemService;
	private MOService moService;
	private int proId; //项目主键
	
	
	public int getSysId() {
		return sysId;
	}
	public void setSysId(int sysId) {
		this.sysId = sysId;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public MOService getMoService() {
		return moService;
	}
	public void setMoService(MOService moService) {
		this.moService = moService;
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
	public String getCorId() {
		return corId;
	}
	public void setCorId(String corId) {
		this.corId = corId;
	}
	
	public String[] getSysIds() {
		return sysIds;
	}
	public void setSysIds(String[] sysIds) {
		this.sysIds = sysIds;
	}
	public SystemService getAddSystemService() {
		return addSystemService;
	}
	public void setAddSystemService(SystemService addSystemService) {
		this.addSystemService = addSystemService;
	}
	public ShowSystemInfoService getShowSystemInfoService() {
		return showSystemInfoService;
	}
	public void setShowSystemInfoService(ShowSystemInfoService showSystemInfoService) {
		this.showSystemInfoService = showSystemInfoService;
	}
	
	
	public int getTestSysId() {
		return testSysId;
	}
	public void setTestSysId(int testSysId) {
		this.testSysId = testSysId;
	}
	public TestSystemService getTestSystemService() {
		return testSystemService;
	}
	public void setTestSystemService(TestSystemService testSystemService) {
		this.testSystemService = testSystemService;
	}
	
	
	
	public String Distribute(){
		
		/**
		 * 追加任务单
		 * 
		 * 将System表中的state 设为1
		 * 将信息写入testSystem 表中并将 Cpstate 设为0
		 */
//		corId = request.getParameter("corId");
		sysIds = request.getParameterValues("sysId");
		proId = Integer.valueOf(request.getParameter("proId"));
		
		int length = sysIds.length;
		if(length >0){
			for(int i=0; i<length; i++){

				sysId = Integer.valueOf(sysIds[i]);
				/*
				Systems sys = showSystemInfoService.ShowSysteminfo(sysId).get(0);
				
				TestSystem tsys = new TestSystem(); 
				tsys.setSystem(sys);
				tsys.setCpState(0);
				tsys.setMark(1);
				testSystemService.saveTestSys(tsys);	
				
				sys.setState(1);
				addSystemService.addSystem(sys);
				*/
				moService.Distribute(sysId,proId);
			}
			
		}
		
		return "mProjectInfo";
	}
	
	public String Undo(){
		
		/**
		 * 撤销任务单
		 * 在TestSystem表中查询出  已经派发的任务单
		 * 删除TestSystem表中的记录
		 * 将System表中的state设为0
		 */	
		try{
			testSysId = Integer.valueOf(request.getParameter("testSysId"));
			String str = moService.Undo(testSysId);
			if(str.equals("noPro")){
				
				return "firstPage"; //该项目已经没有任何被测系统，跳转到首页
			
			}else{
				proId = Integer.valueOf(str);
				return "mProjectInfo";//跳转到项目信息 模块
			}
			
		}catch(Exception e){
			return "fail";
		}
			
	}
	
	public String Finish(){
		try{
			proId = Integer.valueOf(request.getParameter("proId"));
			testSysId = Integer.valueOf(request.getParameter("testSysId"));
			moService.finishTest(testSysId);
			
			return "mProjectInfo";
		}catch(Exception e){
			return "fail";
		}
	}

}
