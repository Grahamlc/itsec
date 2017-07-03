package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.service.DeviceService;
import cn.edu.ustc.ttcn.itsec.service.CompanyService;

public class ShowAllDevice implements ServletRequestAware, ServletResponseAware{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private List<Device> device;

	
	private DeviceService deviceService;

	
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

	

	public List<Device> getDevice() {
		return device;
	}

	public void setDevice(List<Device> device) {
		this.device = device;
	}

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}


	public String execute(){
		/**测评结果界面显示出 数据库中所有的设备，以供选择 
		 * 
		 * **/
	
		device = new ArrayList<Device>();
		
	    device = (List<Device>)deviceService.showAllDevice();
	    return "success";
		
//		for(String s : device){
//			
////			System.out.println("hell"+s.getDeviceName());
//			System.out.println("hell"+s);
//		}
//		return device;
	}
	
	
	
}
