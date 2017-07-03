package cn.edu.ustc.ttcn.itsec.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;
import cn.edu.ustc.ttcn.itsec.service.WriteItemService;

public class WriteItem implements ServletRequestAware, ServletResponseAware {
	private HttpServletResponse response;
	private HttpServletRequest request;
	private WriteItemService writeItemService;
	private ItemSelRes it;
	private int id;

	public ItemSelRes getIt() {
		return it;
	}

	public void setIt(ItemSelRes it) {
		this.it = it;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public WriteItemService getWriteItemService() {
		return writeItemService;
	}

	public void setWriteItemService(WriteItemService writeItemService) {
		this.writeItemService = writeItemService;
	}

	public String execute() {
		String con; //测评结果记录
		String notice; //测评结果判定
		
		id = Integer.valueOf(request.getParameter("id"));
		String[] ids = request.getParameterValues("autoId");
		
		for (int i = 0; i < ids.length; i++) {
			it = new ItemSelRes();

			if(request.getParameter("con" + ids[i]) == null){
				con = " ";
			}else{
				con = request.getParameter("con" + ids[i]);
			}
			
			if(request.getParameter("notice" + ids[i]) == null){
				notice = "不适用";
			}else{
				notice = request.getParameter("notice" + ids[i]);
			}
			

			int id = Integer.valueOf(ids[i]);
			it.setAutoId(id);
			it.setResult(con);
			it.setNotice(notice);
			writeItemService.submitItem(it);
		}

		/*
		 * 获得客户端传来的所有parameters Enumeration<String> notices =
		 * request.getParameterNames();
		 * 
		 * for(;notices.hasMoreElements();){ String o = notices.nextElement();
		 * System.out.println(o); } String con = request.getParameter("con");
		 */
		return "success";
	}

}
