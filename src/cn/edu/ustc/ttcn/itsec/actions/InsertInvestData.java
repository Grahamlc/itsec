package cn.edu.ustc.ttcn.itsec.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.service.InvestInforService;

public class InsertInvestData implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private InvestInforService investInforService;
	private int sysId;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSysId() {
		return sysId;
	}
	public void setSysId(int sysId) {
		this.sysId = sysId;
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
	public InvestInforService getInvestInforService() {
		return investInforService;
	}
	public void setInvestInforService(InvestInforService investInforService) {
		this.investInforService = investInforService;
	}
	/**
	 * 添加数据
	 * @return
	 */
	public String insertMainData(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		investInforService.insertMainData(sysId);
		return "success";
	}
	
	public String insertAppSoft(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		investInforService.insertAppSoft(sysId);
		return "success";
	}
	public String insertHostMemory(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		investInforService.insertHostMemory(sysId);
		return "success";
	}
	
	public String insertNetDevice(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		investInforService.insertNetDevice(sysId);
		return "success";
	}
	public String insertSecDevice(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		investInforService.insertSecDevice(sysId);
		return "success";
	}
	
	public String insertRelaPeople(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		investInforService.insertRelaPeople(sysId);
		return "success";
	}
	public String insertManageFile(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		investInforService.insertManageFile(sysId);
		return "success";
	}
	
	public String insertPhy(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		investInforService.insertPhy(sysId);
		return "success";
	}
	/**
	 * 删除某条数据
	 * @return
	 */	
	public String delKeyData(){
//		try{
		
			sysId = Integer.valueOf(request.getParameter("corId"));
			
			//删除关键数据
			String[] mdids = request.getParameterValues("delmdId");
			if(mdids != null){
				dels(mdids,"delmdId");
			}
			
			//删除业务应用软件
			String[] asids = request.getParameterValues("delasId");
			if(asids != null){
				dels(asids,"delasId");
			}
			
			String[] hmids = request.getParameterValues("delhmId");
			if(hmids != null){
				dels(hmids,"delhmId");
			}
			
			String[] ndids = request.getParameterValues("delndId");
			System.out.println(ndids);
			if(ndids != null){
				dels(ndids,"delndId");
			}
			
			String[] sdids = request.getParameterValues("delsdId");
			if(sdids != null){
				dels(sdids,"delsdId");
			}
			
			String[] rpids = request.getParameterValues("delrpId");
			if(rpids != null){			
				dels(rpids,"delrpId");
			}
			
			String[] mfids = request.getParameterValues("delmfId");
			if(mfids != null){
				dels(mfids,"delmfId");
			}
			
			String[] phyids =request.getParameterValues("delphyId");
			if(phyids != null){
				System.out.println("ceshi"+phyids);
				dels(phyids,"delphyId");
			}
//		}catch(Exception e){
//			return "fail";
//		}	
		return "success";
	}
	public void dels(String[] strs,String strId){
		for(int i=0;i<strs.length;i++){
			int id = Integer.valueOf(strs[i]);
			
			switch(strId){
			case "delphyId":
				investInforService.delPhy(id);
				break;
			case "delmdId":
				investInforService.delMainData(id);
				break;
			case "delasId":
				investInforService.delAppSoft(id);
				break;
			case "delhmId":
				investInforService.delHostMemory(id);
				break;
			case "delndId":
				investInforService.delNetDevice(id);
				break;
			case "delsdId":
				investInforService.delSecDevice(id);
				break;
			case "delrpId":
				investInforService.delRelaPeople(id);
				break;
			case "delmfId":
				investInforService.delManageFile(id);
				break;
			default:
				break;
				
			}
			
		}
	}
	/*
	public String delAppSoft(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		String[] ids = request.getParameterValues("delasId");
		
		for(int i=0;i<ids.length;i++){
			int id = Integer.valueOf(ids[i]);
			investInforService.delAppSoft(id);
		}	
		return "success";
	}
	public String delHostMemory(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		String[] ids = request.getParameterValues("delhmId");
		
		for(int i=0;i<ids.length;i++){
			int id = Integer.valueOf(ids[i]);
			investInforService.delHostMemory(id);
		}	
		
		return "success";
	}
	public String delNetDevice(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		String[] ids = request.getParameterValues("delndId");
		
		for(int i=0;i<ids.length;i++){
			int id = Integer.valueOf(ids[i]);
			investInforService.delNetDevice(id);
		}	
		
		return "success";
	}
	public String delSecDevice(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		int id = Integer.valueOf(request.getParameter("delsdId"));
		investInforService.delSecDevice(id);
		return "success";
	}
	public String delRelaPeople(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		int id = Integer.valueOf(request.getParameter("delrpId"));
		investInforService.delRelaPeople(id);
		return "success";
	}
	public String delManageFile(){
		sysId = Integer.valueOf(request.getParameter("corId"));
		int id = Integer.valueOf(request.getParameter("delmfId"));
		investInforService.delManageFile(id);
		return "success";
	}
	*/
	/**
	 * 提交数据
	 */
	
	public String submit() {
		
		String[] mdIds = request.getParameterValues("mdId");
		String[] asIds = request.getParameterValues("asId");
		String[] hmIds = request.getParameterValues("hmId");
		String[] ndIds = request.getParameterValues("ndId");
		String[] sdIds = request.getParameterValues("sdId");
		String[] rpIds = request.getParameterValues("rpId");
		String[] mfIds = request.getParameterValues("mfId");
		String[] phyIds = request.getParameterValues("phyId");
		
		url = request.getParameter("url");
		sysId = Integer.valueOf(request.getParameter("corId"));
		if(url.equals("Information.jsp")){
			
		if(phyIds != null){
			for(int i = 0;i< phyIds.length;i++){
				int id = Integer.valueOf(phyIds[i]);
				
				String name = " ";
				String location = " ";
				name = request.getParameter("phy_name"+id);
				location = request.getParameter("phy_location"+id);
				
				investInforService.updatePhy(id, name, location, url);
			}
		}
			
		if(mdIds != null){
			for(int i=0;i<mdIds.length;i++) {
				int id = Integer.valueOf(mdIds[i]);
				String dataType = " ";
				String appSoft =" ";
				String hostMemory = " ";
				String important =" ";
//				if(url.equals("Information.jsp")){				
					 dataType= request.getParameter("md_dataType"+id);
					 appSoft = request.getParameter("md_appSoft"+id);
					 hostMemory = request.getParameter("md_hostMemory"+id);
					 important = request.getParameter("md_important"+id);
				
					 investInforService.updateMainData(id, dataType, appSoft, hostMemory, important,url);			
//				}
		
//				if(url.equals("Cp_fangan.jsp")){
//					
//					investInforService.chooseMainData(id, sysId);
//				}
				
			}
//			if(url.equals("Cp_fangan.jsp")){
//				investInforService.chooseMainData(mdIds, sysId);
//			}
		}

		
		if(asIds != null){
			for(int i=0;i<asIds.length;i++){
				int id = Integer.valueOf(asIds[i]);
				String name=" ";
				String usedFor = " ";
				String important = " ";
//				if(url.equals("Information.jsp")){
					name = request.getParameter("as_name"+id);
					usedFor = request.getParameter("as_usedFor"+id);
					important = request.getParameter("as_important"+id);
//				}
				investInforService.updateAppSoft(id, name, usedFor, important,url);
			}
		}
		
		if(hmIds != null){
			for(int i=0;i<hmIds.length;i++){
				int id = Integer.valueOf(hmIds[i]);
				String name =" ";
				String osSystem = " ";
				String usedFor =" ";
//				if(url.equals("Information.jsp")){
					name = request.getParameter("hm_name"+id);
					osSystem = request.getParameter("hm_osSystem"+id);
					usedFor = request.getParameter("hm_usedFor"+id);
//				}
					investInforService.updateHostMemory(id, name, osSystem, usedFor,url);
			}
		}
		
		if(ndIds != null){
			for(int i=0;i<ndIds.length;i++){
				int id = Integer.valueOf(ndIds[i]);
				String madeFrom = " ";
				String usedFor=" ";
				String important = " ";
//				if(url.equals("Information.jsp")){
					madeFrom = request.getParameter("nd_madeFrom"+id);
					usedFor = request.getParameter("nd_usedFor"+id);
					important = request.getParameter("nd_important"+id);
//				}
					investInforService.updateNetDevice(id, madeFrom, usedFor, important,url);
			}
		}
		if(sdIds != null){
			for(int i=0;i<sdIds.length;i++){
				int id = Integer.valueOf(sdIds[i]);
				String madeFrom = " ";
				String usedFor=" ";
				String important = " ";
//				if(url.equals("Information.jsp")){
					madeFrom = request.getParameter("sd_madeFrom"+id);
					usedFor = request.getParameter("sd_usedFor"+id);
					important = request.getParameter("sd_important"+id);
//				}
					investInforService.updateSecDevice(id, madeFrom, usedFor, important,url); 
			}
		}
		
		if(rpIds !=null){
			for(int i=0;i<rpIds.length;i++){
				int id = Integer.valueOf(rpIds[i]);
				String name=" ";
				String position = " ";
				String contact = " ";
				
				name = request.getParameter("rp_name"+id);
				position = request.getParameter("rp_position"+id);
				contact = request.getParameter("rp_contact"+id);
				
				investInforService.updateRelaPeople(id, name, position, contact,url);
			}
		}
		
		if(mfIds != null){
			for(int i=0;i<mfIds.length;i++){
				int id= Integer.valueOf(mfIds[i]);
				String name = " ";
				String mainPoint = " ";
				
				name = request.getParameter("mf_name"+id);
							
				investInforService.updateManageFile(id, name, mainPoint,url);
			}
		}
		}
		/**
		 * 选择测评对象进行测评
		 */
		if(url.equals("Cp_3.jsp")){
			investInforService.choosePhy(phyIds, sysId);
			investInforService.chooseMainData(mdIds, sysId);
			investInforService.chooseAppSoft(asIds, sysId);
			investInforService.chooseHostMemory(hmIds, sysId);
			investInforService.chooseNetDevice(ndIds, sysId);
			investInforService.chooseSecDevice(sdIds, sysId);
			investInforService.chooseRelaPeople(rpIds, sysId);
			investInforService.chooseManageFile(mfIds, sysId);
		}
		return "success";
	}
}
