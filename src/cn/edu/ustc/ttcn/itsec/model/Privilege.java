package cn.edu.ustc.ttcn.itsec.model;

import java.util.HashSet;
import java.util.Set;

public class Privilege implements java.io.Serializable{
	private int autoId;
	private String name;	
	private Set<Menu_Priv> menuPriv = new HashSet<Menu_Priv>();
	private String menu;
	
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getAutoId() {
		return autoId;
	}
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Menu_Priv> getMenuPriv() {
		return menuPriv;
	}
	public void setMenuPriv(Set<Menu_Priv> menuPriv) {
		this.menuPriv = menuPriv;
	}
	
}
