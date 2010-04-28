package edu.itee.antipodes.domain.pages;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;

public class CompanyInfo {

	private int operatorID;
	
	@NotBlank
	@Length(max = 40)
	@RegExp(value = "[a-zA-Z0-9 ]*")
	private String operatorName;
	
	@NotBlank
	@Length(max = 200)
	private String companyDesc;
	
	@NotBlank
	@Length(max = 50)
	private String address;
	
	@NotBlank
	@Length(max = 10)
	@RegExp(value = "[0-9]*")
	private String telephone;
	
	@NotBlank
	@Length(max = 30)
	@Email
	private String email;
	
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
	public String getCompanyDesc() {
		return companyDesc;
	}
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
