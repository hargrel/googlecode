package edu.itee.antipodes.domain;

import java.util.Date;

public class TourOperator {
	private int operatorID;
	private String operatorName;
	private String companyInfo;
	private Date membershipExpired;
	private String email;
	private String currency;
	public int getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	public Date getMembershipExpired() {
		return membershipExpired;
	}
	public void setMembershipExpired(Date membershipExpired) {
		this.membershipExpired = membershipExpired;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "TourOperator [operatorID=" + operatorID + ", operatorName=" + operatorName
				+ ", companyInfo=" + companyInfo + ", membershipExpired=" + membershipExpired
				+ ", email=" + email + ", currency"+currency+"]";
	}
}
