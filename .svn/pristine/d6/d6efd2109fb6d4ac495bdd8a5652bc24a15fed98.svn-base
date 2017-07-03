package cn.edu.ustc.ttcn.itsec.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Company;
import cn.edu.ustc.ttcn.itsec.service.CompanyService;



public class EditCompany implements ServletRequestAware, ServletResponseAware{
	
	private CompanyService companyService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String returnJson;
	private int corId;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
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
	public String getReturnJson() {
		return returnJson;
	}
	public void setReturnJson(String returnJson) {
		this.returnJson = returnJson;
	}
	
	public int getCorId() {
		return corId;
	}

	public void setCorId(int corId) {
		this.corId = corId;
	}

	/**
	 * 更新某单位信息
	 * @return
	 */
	public String execute(){
		/**商务人员新建单位信息
		 * 
		 * 有待完善
		 * **/
		try{
			corId = Integer.valueOf(request.getParameter("corId"));
			
			String corName = request.getParameter("corName");  //被测单位
			String corAdd = request.getParameter("corAdd");  //被测系统
			String connUser = request.getParameter("connUser"); //被测单位联系人
			String connPhon = request.getParameter("connPhon"); //被测单位联系人联系方式
			String connMail = request.getParameter("connMail"); 
			String postCode = request.getParameter("postId");
			String area = request.getParameter("area"); //单位所属地区
			String userBm = request.getParameter("userBm");//所属部门
			String corTel = request.getParameter("corTel"); //办公电话
			String userTitle = request.getParameter("userTitle");//职称/职位	
			
//			Company company = companyService.queryMCompany(corId) ;
			Company company = new Company();
			
			company.setCorId(corId);
			company.setCorName(corName);
			company.setCorAdd(corAdd);
			company.setConnUser(connUser);

			company.setConnPhon(connPhon);
			company.setConnMail(connMail);
			company.setPostCode(postCode);
			company.setArea(area);
			company.setUserBm(userBm);

			company.setCorTel(corTel);
			company.setUserTitle(userTitle);
			
			companyService.updateCompany(company);
			
			return "mCompanyInfo";
			
		}catch(Exception e){
			return "fail";
		}
		
	}

}
