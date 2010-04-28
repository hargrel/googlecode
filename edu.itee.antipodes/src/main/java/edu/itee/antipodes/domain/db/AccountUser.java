package edu.itee.antipodes.domain.db;

import java.io.Serializable;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

/**
 * A persistence class that stores user login details from the User table in DB. 
 *
 */

@SuppressWarnings("serial")
public class AccountUser implements Serializable {
	private int userID;
	
	@NotBlank
	@Length(max = 20)
	@RegExp(value = "[a-zA-Z0-9_.]*")
	private String userName;
	
	@NotBlank
	@Length(max = 20)
	private String password;
	private String userType;
	private TourOperator operator;
	
	public AccountUser(){}		
	
	public AccountUser(String name, String pwd, String userType){
		this.userName = name;
		this.password = pwd;
		this.userType = userType;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public TourOperator getOperator() {
		return operator;
	}

	public void setOperator(TourOperator operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "AccountUser [userID=" + userID + ", password=" + password + ", userType=" + userType
				+ ", userName=" + userName + "]";
	}
}
