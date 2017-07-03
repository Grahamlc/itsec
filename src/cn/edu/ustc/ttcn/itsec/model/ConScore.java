package cn.edu.ustc.ttcn.itsec.model;

public class ConScore {
	
	private int autoId;
	private TestSystem testSystem;
	private ItemCon itemCon;
	private float itemConScore;
	private float weighs;
	
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
	public ItemCon getItemCon() {
		return itemCon;
	}
	public void setItemCon(ItemCon itemCon) {
		this.itemCon = itemCon;
	}
	public float getItemConScore() {
		return itemConScore;
	}
	public void setItemConScore(float itemConScore) {
		this.itemConScore = itemConScore;
	}
	public float getWeighs() {
		return weighs;
	}
	public void setWeighs(float weighs) {
		this.weighs = weighs;
	}
	
	
}
