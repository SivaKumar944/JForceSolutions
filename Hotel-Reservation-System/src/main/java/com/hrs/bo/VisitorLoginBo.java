package com.hrs.bo;

public class VisitorLoginBo {
	
	protected String emailAddress;
	protected String password;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "VisitorLoginBo [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	
}
