package cn.edu.ustc.ttcn.itsec.model;

public class ManageFile {
	private int autoId;
	private Company company;
	private String name;
	private String mainPoint;
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
	public String getMainPoint() {
		return mainPoint;
	}
	public void setMainPoint(String mainPoint) {
		this.mainPoint = mainPoint;
	}
	
}
