package cn.edu.ustc.ttcn.itsec.model;

public class Reports implements java.io.Serializable{
	private int autoId;
	/**
	 * system 代表被测系统 
	 */
	private TestSystem testSystem;
	private String name;
	private String time;
	private String fileName;
	
	public int getAutoId() {
		return autoId;
	}
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	
	public TestSystem getTestSystem() {
		return testSystem;
	}
	public void setTestSystem(TestSystem testSystem) {
		this.testSystem = testSystem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
