
package cn.edu.ustc.ttcn.itsec.model;

import java.util.HashSet;
import java.util.Set;

public class TestSystem implements java.io.Serializable{
	private int autoId;
	private Systems system;
	private String backId;
	private String startDate;
	private String overDate;
	private String testResult;
	private int cpState;
	private String level;
	private int mark;
	private Projects project;
	
	private Set<TestObject> testObject = new HashSet<TestObject> ();
	private Set<TesterOfSystem>  sysTester = new HashSet<TesterOfSystem> ();
	
	private Set<Reports> report = new HashSet<Reports>();
	public Set<Reports> getReport() {
		return report;
	}

	public void setReport(Set<Reports> report) {
		this.report = report;
	}
	
	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public Systems getSystem() {
		return system;
	}

	public void setSystem(Systems system) {
		this.system = system;
	}

	public String getBackId() {
		return backId;
	}

	public void setBackId(String backId) {
		this.backId = backId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getOverDate() {
		return overDate;
	}

	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public Set<TesterOfSystem> getSysTester() {
		return sysTester;
	}

	public void setSysTester(Set<TesterOfSystem> sysTester) {
		this.sysTester = sysTester;
	}
	
	public int getCpState() {
		return cpState;
	}

	public void setCpState(int cpState) {
		this.cpState = cpState;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Set<TestObject> getTestObject() {
		return testObject;
	}

	public void setTestObject(Set<TestObject> testObject) {
		this.testObject = testObject;
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}
	
	

	
}

