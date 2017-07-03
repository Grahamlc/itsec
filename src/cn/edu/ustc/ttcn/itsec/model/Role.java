package cn.edu.ustc.ttcn.itsec.model;

import java.util.HashSet;
import java.util.Set;

/*table s_cp_role*/

public class Role implements java.io.Serializable{
	private int roleId;
	private String roleName;

	private Set<TesterOfSystem> testerOfSystem  = new HashSet<TesterOfSystem>();
	

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	public Set<TesterOfSystem> getTesterOfSystem() {
		return testerOfSystem;
	}
	public void setTesterOfSystem(Set<TesterOfSystem> testerOfSystem) {
		this.testerOfSystem = testerOfSystem;
	}
	public Role(){}
	
	public Role(int id, String rolename){
		roleId = id;
		roleName = rolename;
	}

	
}
