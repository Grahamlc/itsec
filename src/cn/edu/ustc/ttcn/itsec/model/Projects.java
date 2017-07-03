package cn.edu.ustc.ttcn.itsec.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Projects implements java.io.Serializable{
	
	private int autoId;
	private Company company;
	private Date date;
	private int state;
	private Tester responsor;
	
	private Set<TestSystem> testSystems = new HashSet<TestSystem>();

	public int getAutoId() {
		return autoId;
	}

	/**
	 * 项目主键
	 * @param autoId
	 */
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public Company getCompany() {
		return company;
	}

	/**
	 * 关联单位
	 * @param company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<TestSystem> getTestSystems() {
		return testSystems;
	}

	public void setTestSystems(Set<TestSystem> testSystems) {
		this.testSystems = testSystems;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	/**
	 * 创建该项目的商务负责人
	 * @return
	 */
	public Tester getResponsor() {
		return responsor;
	}

	public void setResponsor(Tester responsor) {
		this.responsor = responsor;
	}
	
}
