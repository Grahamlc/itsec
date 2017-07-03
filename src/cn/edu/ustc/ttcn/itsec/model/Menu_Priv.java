package cn.edu.ustc.ttcn.itsec.model;

public class Menu_Priv implements java.io.Serializable{
	private int autoId;
	private Privilege privilege;
	private Menu menu;
	public int getAutoId() {
		return autoId;
	}
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	public Privilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
			
}
