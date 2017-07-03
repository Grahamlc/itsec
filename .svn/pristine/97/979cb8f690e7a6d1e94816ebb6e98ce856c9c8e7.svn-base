package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.AppSoft;
import cn.edu.ustc.ttcn.itsec.model.HostMemory;
import cn.edu.ustc.ttcn.itsec.model.MainData;
import cn.edu.ustc.ttcn.itsec.model.ManageFile;
import cn.edu.ustc.ttcn.itsec.model.NetDevice;
import cn.edu.ustc.ttcn.itsec.model.Physices;
import cn.edu.ustc.ttcn.itsec.model.RelaPeople;
import cn.edu.ustc.ttcn.itsec.model.SecDevice;
import cn.edu.ustc.ttcn.itsec.service.InvestInforService;

public class Investigation implements ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private InvestInforService investInforService;
	private Map<String, Object> informations;
	private List<Physices> phy;
	private List<MainData> md ;
	private List<AppSoft> as;
	private List<HostMemory> hm;
	private List<ManageFile> mf;
	private List<NetDevice> nd;
	private List<SecDevice> sd;
	private List<RelaPeople> rp;
	private String url;
	private int corId;
	
	
	public List<Physices> getPhy() {
		return phy;
	}

	public void setPhy(List<Physices> phy) {
		this.phy = phy;
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

	public List<AppSoft> getAs() {
		return as;
	}

	public void setAs(List<AppSoft> as) {
		this.as = as;
	}

	public List<HostMemory> getHm() {
		return hm;
	}

	public void setHm(List<HostMemory> hm) {
		this.hm = hm;
	}

	public List<ManageFile> getMf() {
		return mf;
	}

	public void setMf(List<ManageFile> mf) {
		this.mf = mf;
	}

	public List<NetDevice> getNd() {
		return nd;
	}

	public void setNd(List<NetDevice> nd) {
		this.nd = nd;
	}

	public List<SecDevice> getSd() {
		return sd;
	}

	public void setSd(List<SecDevice> sd) {
		this.sd = sd;
	}

	public List<RelaPeople> getRp() {
		return rp;
	}

	public void setRp(List<RelaPeople> rp) {
		this.rp = rp;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}
	
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

	public Map<String, Object> getInformations() {
		return informations;
	}

	public void setInformations(Map<String, Object> informations) {
		this.informations = informations;
	}
	
	public List<MainData> getMd() {
		return md;
	}

	public void setMd(List<MainData> md) {
		this.md = md;
	}

	public String showInvest(){
		/**
		 * 根据某系统Id 查找与其相关的所有（前期调查表）用到的数据
		 */
		informations = new HashMap<String, Object>();
		corId = Integer.valueOf(request.getParameter("corId"));
		url = request.getParameter("url");
		informations = investInforService.showAll(corId);
		
		phy = (List<Physices>) informations.get("phy");
		md = (List<MainData>) informations.get("mainData");
		as = (List<AppSoft>) informations.get("appSoft");
		hm = (List<HostMemory>) informations.get("hostMemory");
		nd = (List<NetDevice>) informations.get("netDevice");
		sd = (List<SecDevice>) informations.get("secDevice");
		rp = (List<RelaPeople>) informations.get("relaPeople");		
		mf = (List<ManageFile>) informations.get("manageFile");
		/*
		if(url.equalsIgnoreCase("Information.jsp")){
			return "information";
		}
		if(url.equals("Myjob.jsp")){
			return "Myjob";
		}
		*/
	
			return "success";
	}
}
