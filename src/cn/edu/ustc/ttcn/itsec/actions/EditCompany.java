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
	 * ����ĳ��λ��Ϣ
	 * @return
	 */
	public String execute(){
		/**������Ա�½���λ��Ϣ
		 * 
		 * �д�����
		 * **/
		try{
			corId = Integer.valueOf(request.getParameter("corId"));
			
			String corName = request.getParameter("corName");  //���ⵥλ
			String corAdd = request.getParameter("corAdd");  //����ϵͳ
			String connUser = request.getParameter("connUser"); //���ⵥλ��ϵ��
			String connPhon = request.getParameter("connPhon"); //���ⵥλ��ϵ����ϵ��ʽ
			String connMail = request.getParameter("connMail"); 
			String postCode = request.getParameter("postId");
			String area = request.getParameter("area"); //��λ��������
			String userBm = request.getParameter("userBm");//��������
			String corTel = request.getParameter("corTel"); //�칫�绰
			String userTitle = request.getParameter("userTitle");//ְ��/ְλ	
			
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
