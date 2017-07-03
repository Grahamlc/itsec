package cn.edu.ustc.ttcn.itsec.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.service.DeviceService;
import cn.edu.ustc.ttcn.itsec.service.ReportService;
import cn.edu.ustc.ttcn.itsec.service.ShowItemService;
import cn.edu.ustc.ttcn.itsec.service.ShowObjectService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class WordBuild implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;

	private Configuration configuration = null;
	private int testSysId;
	private DeviceService deviceService;
	private List<Device> device;

	private ShowItemService showItemService;
	private List<ItemSelRes> itemselres;

	private ShowObjectService showObjectService;
	private List<TestObject> testobject;// 等待数据库查询

	private ReportService reportService;

	private int sysId;
	private String timeStr;// 唯一代表报告名称

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getTimeStr() {
		return timeStr;
	}

	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}

	public ShowObjectService getShowObjectService() {
		return showObjectService;
	}

	public int getTestSysId() {
		return testSysId;
	}

	public void setTestSysId(int testSysId) {
		this.testSysId = testSysId;
	}

	public void setShowObjectService(ShowObjectService showObjectService) {
		this.showObjectService = showObjectService;
	}

	public ShowItemService getShowItemService() {
		return showItemService;
	}

	public void setShowItemService(ShowItemService showItemService) {
		this.showItemService = showItemService;
	}

	public List<ItemSelRes> getItemselres() {
		return itemselres;
	}

	public void setItemselres(List<ItemSelRes> itemselres) {
		this.itemselres = itemselres;
	}

	public ShowObjectService getShowobject() {
		return showObjectService;
	}

	public void setShowobject(ShowObjectService showObjectService) {
		this.showObjectService = showObjectService;
	}

	public List<TestObject> getTestobject() {
		return testobject;
	}

	public void setTestobject(List<TestObject> testobject) {
		this.testobject = testobject;
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

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
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

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public List<Device> getDevice() {
		return device;
	}

	public void setDevice(List<Device> device) {
		this.device = device;
	}
	
	/**
	 * 输出报告
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String createWord() throws UnsupportedEncodingException {

		testSysId = Integer.valueOf(request.getParameter("testSysId"));
//		sysId = Integer.valueOf(request.getParameter("sysId"));

		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		timeStr = reportService.exportReport(dataMap, testSysId);
		
		if(timeStr.equals("false")){
			return "fail";
		}else{
			configuration.setClassForTemplateLoading(this.getClass(), "/template"); // FTL文件所存在的位置
			Template t = null;
			try {
				t = configuration.getTemplate("test712.ftl"); // 文件名
				t.setEncoding("UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
//			System.out.println(request.getSession().getServletContext().getRealPath("")); 
//			request.getRealPath("/")
			File outFile = new File(request.getSession().getServletContext().getRealPath("/") + "out/" + timeStr
					+ ".doc");
			Writer out = null;
//			System.out.println(request.getRealPath("/"));
			try {
				out = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(outFile), "UTF-8"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			try {
				t.process(dataMap, out);
			} catch (TemplateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "success";
		}
		
	}

	

}
