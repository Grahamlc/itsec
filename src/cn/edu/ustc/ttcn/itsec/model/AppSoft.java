package cn.edu.ustc.ttcn.itsec.model;

public class AppSoft {
	private int autoId;
	private Company company;
	private String name;
	private String usedFor;
	private String important;
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getAutoId() {
		return autoId;
	}
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsedFor() {
		return usedFor;
	}
	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}
	public String getImportant() {
		return important;
	}
	public void setImportant(String important) {
		this.important = important;
	}
	
}
