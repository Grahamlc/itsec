package cn.edu.ustc.ttcn.itsec.model;

import java.util.Date;


@SuppressWarnings("serial")
public class ProjectsNumber implements java.io.Serializable{
	
	private int autoId;
	private String projectnumber;
	private Date date;

	private Tester responsor;
	private String comment;
	

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getProjectnumber() {
		return projectnumber;
	}

	public void setProjectnumber(String projectnumber) {
		this.projectnumber = projectnumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
