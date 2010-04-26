package edu.itee.antipodes.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TourOperator {
	private int operatorID;
	private String operatorName;
	private String companyInfo;
	private Date membershipExpired;
	private String email;
	private String currency;
	private AccountUser accountUser;
	private Set<ListedTour> listedTour = new HashSet<ListedTour>(0);
	
	public TourOperator(){}
	
	public TourOperator(String operatorName,
			String companyInfo, Date membershipExpired, String email,
			String currency, AccountUser accountUser) {
		this.operatorName = operatorName;
		this.companyInfo = companyInfo;
		this.membershipExpired = membershipExpired;
		this.email = email;
		this.currency = currency;
		this.accountUser = accountUser;
	}
	
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
	public AccountUser getAccountUser() {
		return accountUser;
	}
	public void setAccountUser(AccountUser accountUser) {
		this.accountUser = accountUser;
	}
	public Set<ListedTour> getListedTour() {
		return listedTour;
	}
	public void setListedTour(Set<ListedTour> listedTour) {
		this.listedTour = listedTour;
	}
	
	@Override
	public String toString() {
		return "TourOperator [operatorID=" + operatorID + ", operatorName=" + operatorName
				+ ", companyInfo=" + companyInfo + ", membershipExpired=" + membershipExpired
				+ ", email=" + email + ", currency"+currency+"]";
	}
}
