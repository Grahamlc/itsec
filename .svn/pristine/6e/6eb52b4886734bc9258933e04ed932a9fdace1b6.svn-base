package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.service.ShowItemService;

public class ShowItem implements ServletRequestAware, ServletResponseAware{

	private HttpServletResponse response;
	private HttpServletRequest request;
	private List<ItemSelRes> itemSelRes;
	private ShowItemService showItemService;
	private TestObject testObject;
	
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

	public List<ItemSelRes> getItemSelRes() {
		return itemSelRes;
	}

	public void setItemSelRes(List<ItemSelRes> itemSelRes) {
		this.itemSelRes = itemSelRes;
	}

	public ShowItemService getShowItemService() {
		return showItemService;
	}

	public void setShowItemService(ShowItemService showItemService) {
		this.showItemService = showItemService;
	}
	
	public TestObject getTestObject() {
		return testObject;
	}

	public void setTestObject(TestObject testObject) {
		this.testObject = testObject;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response= arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	public String execute(){
		
		/**
		 * 输入某一具体的测评表单
		 */
		int id =Integer.valueOf(request.getParameter("id")) ;//获得测评对象的Id
		itemSelRes = new ArrayList<ItemSelRes>();
		itemSelRes = showItemService.showItem(id);
		
		testObject = new TestObject();
		testObject = itemSelRes.get(0).getItemToObject();
		return "success";
	}

}
