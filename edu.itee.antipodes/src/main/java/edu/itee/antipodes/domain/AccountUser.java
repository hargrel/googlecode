package edu.itee.antipodes.domain;
import java.io.Serializable;


/**
 * A persistence class that stores user login details from the User table in DB. 
 *
 */
public class AccountUser {
	private int userID;
	private String userName;
	private String password;
	private String userType;
	
	public int getUserID(){
		return userID;
	}
	private void setUserID(int userID){
		this.userID=userID;
	}
	public String getUsername() {
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
	@Override
	public String toString() {
		return "AccountUser [userID=" + userID + ", password=" + password + ", userType=" + userType
				+ ", userName=" + userName + "]";
	}
}
