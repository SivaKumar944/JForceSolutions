package com.hrs.bo;

public class AdminBo {
	protected int adminId;
	protected String name;
	protected String password;
	
public AdminBo(int adminId, String name, String password) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.password = password;
	}
	public AdminBo() {
		super();
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminBo [adminId=" + adminId + ", name=" + name + ", password=" + password + "]";
	}
	
	

}
