package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Reports;
import cn.edu.ustc.ttcn.itsec.service.ReportService;

public class Report implements ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ReportService reportService;
	private int sysId;
	private int testSysId;
	
	private List<Reports> reports;
	
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

	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}
	
	public int getTestSysId() {
		return testSysId;
	}

	public void setTestSysId(int testSysId) {
		this.testSysId = testSysId;
	}

	public List<Reports> getReports() {
		return reports;
	}

	public void setReports(List<Reports> reports) {
		this.reports = reports;
	}
	
	
	public String execute(){
				
		try{
			reports = new ArrayList<Reports>();
			
			if(request.getParameter("testSysId") == null){
				
				sysId = Integer.valueOf(request.getParameter("sysId"));
				reports = reportService.showAllReport(sysId);
				
			}else{
				
				testSysId = Integer.valueOf(request.getParameter("testSysId"));
				reports = reportService.showMReport(testSysId);
				
				int Cpstate = reports.get(0).getTestSystem().getCpState();//被测系统的测评状态
				
				if(reports.size() == 0 && Cpstate ==7){ //只有被测系统达到一定状态  才可以生成报告
					return "noreports";
				}
			}
			return "report";
			
		}catch(Exception e){
			return "fail";
		}
		
		
				
	}
}
