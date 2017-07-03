package cn.edu.ustc.ttcn.itsec.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Company;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.service.SystemService;

public class AddSystem implements ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SystemService systemService;
	private Systems ss;
	private Company pp;
	private int corId;
	private String url;
	
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
	
	
	public SystemService getSystemService() {
		return systemService;
	}
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	public Systems getSs() {
		return ss;
	}
	public void setSs(Systems ss) {
		this.ss = ss;
	}
	
	public Company getPp() {
		return pp;
	}
	public void setPp(Company pp) {
		this.pp = pp;
	}
	
	
	public int getCorId() {
		return corId;
	}
	public void setCorId(int corId) {
		this.corId = corId;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String execute(){
		url = request.getParameter("url");
		String sysName = request.getParameter("sysName");
		String secLevel = request.getParameter("secLevel");
		String backId = request.getParameter("backId");
		String cor = request.getParameter("corId");//获得当前单位id
		String sLevel = request.getParameter("sLevel");
		String gLevel = request.getParameter("gLevel");
		String aLevel = request.getParameter("aLevel");
		String level = sLevel+aLevel+gLevel;
		
		try{
			corId = Integer.valueOf(cor);
			pp = new Company();
			pp.setCorId(corId);
			
			ss = new Systems();
			ss.setCompany(pp);
			ss.setSysName(sysName);
			ss.setSecLevel(secLevel);
			ss.setBackId(backId);
			ss.setLevel(level);
			
			systemService.addSystem(ss);
			return "success";
		}catch(Exception e){
			return "fail";
		}
		
		
	}
}	
