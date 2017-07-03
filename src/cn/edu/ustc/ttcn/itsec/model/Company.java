package cn.edu.ustc.ttcn.itsec.model;
import java.util.HashSet;
import java.util.Set;


import java.util.HashSet;
import java.util.Set;



import cn.edu.ustc.ttcn.itsec.model.Systems;

/*测评单位以及测评项目知识库表*/

@SuppressWarnings("serial")
public class Company implements java.io.Serializable {
	private int corId;
	private String corName;
	private String corAdd;
	private String connUser;
	private String userBm;
	private String corTel;
	private String connPhon;
	private String connMail;
	private String postCode;
	private int status;
	private String Area;
	private String userTitle;
	
	private Set<Systems> systems = new HashSet<Systems>();
	private Set<Projects> projects = new HashSet<Projects>();
	
	public Set<Systems> getSystems() {
		return systems;
	}
	public void setSystems(Set<Systems> systems) {
		this.systems = systems;
	}
	public String getUserBm() {
		return userBm;
	}
	public void setUserBm(String userBm) {
		this.userBm = userBm;
	}
	public String getCorTel() {
		return corTel;
	}
	public void setCorTel(String corTel) {
		this.corTel = corTel;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}


	public int getCorId() {
		return corId;
	}
	public void setCorId(int corId) {
		this.corId = corId;
	}
	public String getCorName() {
		return corName;
	}
	public void setCorName(String corName) {
		this.corName = corName;
	}
	public String getCorAdd() {
		return corAdd;
	}
	public void setCorAdd(String corAdd) {
		this.corAdd = corAdd;
	}
	
	public String getConnUser() {
		return connUser;
	}
	public void setConnUser(String connUser) {
		this.connUser = connUser;
	}
	public String getConnPhon() {
		return connPhon;
	}
	public void setConnPhon(String connPhon) {
		this.connPhon = connPhon;
	}
	public String getConnMail() {
		return connMail;
	}
	public void setConnMail(String connMail) {
		this.connMail = connMail;
	}
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}		
	public String getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}
	public Set<Projects> getProjects() {
		return projects;
	}
	public void setProjects(Set<Projects> projects) {
		this.projects = projects;
	}
	
}
