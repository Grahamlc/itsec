package cn.edu.ustc.ttcn.itsec.actions;

import java.util.List;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.service.RequestProNumService;
import cn.edu.ustc.ttcn.itsec.model.ProjectsNumber;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.service.TesterService;

public class GetProNumbers implements ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private  RequestProNumService requestProNumService;
	private TesterService testerService;
	private int userId;
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.setResponse(arg0);
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.setRequest(arg0);
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public RequestProNumService getRequestProNumService() {
		return requestProNumService;
	}

	public void setRequestProNumService(RequestProNumService requestProNumService) {
		this.requestProNumService = requestProNumService;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public TesterService getTesterService(){
		return testerService;
	}
	public void setTesterService(TesterService testerService){
		this.testerService = testerService;
	}

	//从前端申请一个项目编号
	/**
	 * 1 从数据库中查询到当前最新的项目编号-currentId
	 * 2 生成最新的项目编号，返回到前端。
	 * @return
	 */
	public String execute(){
		
		//try{
			int temp;
			String comment = request.getParameter("comment");
			/*
			List<ProjectsNumber> tempPro = requestProNumService.getLastProNum();
			if (!tempPro.isEmpty()){
				String currenId = requestProNumService.getLastProNum().get(0).getProjectnumber();
				temp =Integer.valueOf(currenId)+1;
				
			}else{
				temp = 20170001;
			}
			*/
			temp = 20170001;
			String Pronumber = String.valueOf(temp);
			
			userId = Integer.valueOf(request.getParameter("responsor"));
			Tester tester = testerService.queryMTester(userId).get(0); //申请人
			
			Date time = new java.sql.Date(new java.util.Date().getTime()); //申请编号的时间
			
			ProjectsNumber proNum = new ProjectsNumber();
			
			proNum.setResponsor(tester);
			proNum.setDate(time);
			proNum.setProjectnumber(Pronumber);
			proNum.setComment(comment);
			requestProNumService.saveProNum(proNum);
			
			return Pronumber;
	//	}catch(Exception e){
		//	return "fail";
		//}
		
		
	}





}
