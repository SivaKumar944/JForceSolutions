package com.hrs.bo;

public class VisitorRegBo {
	protected int visitorId;
	protected String visitorName;
	protected String password;
	protected String emailAddress;
	protected String mobileNumber;
	
	public VisitorRegBo() {
		super();
	}
	
	public VisitorRegBo(int visitorId, String visitorName, String password, String emailAddress, String mobileNumber) {
		super();
		this.visitorId = visitorId;
		this.visitorName = visitorName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
	}

	public int getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "VisitorRegBo [visitorId=" + visitorId + ", visitorName=" + visitorName + ", password=" + password
				+ ", emailAddress=" + emailAddress + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
