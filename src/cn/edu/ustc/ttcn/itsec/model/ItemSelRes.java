package cn.edu.ustc.ttcn.itsec.model;

import javax.persistence.Column;

public class ItemSelRes {
	private int autoId;
	private TestObject itemToObject;
	private Item item;
	private String result;
	private String notice;
	public int getAutoId() {
		return autoId;
	}
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	@Column(updatable=false)
	public TestObject getItemToObject() {
		return itemToObject;
	}
	public void setItemToObject(TestObject itemToObject) {
		this.itemToObject = itemToObject;
	}
	@Column(updatable=false)
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	
	
	
}
