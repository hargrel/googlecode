package edu.itee.antipodes.service;

import java.security.*;
import java.math.*;


public class PasswordHash {

	public String Hash(String password) throws Exception{
		MessageDigest m=MessageDigest.getInstance("MD5");
	    m.update(password.getBytes(),0,password.length());
	    String hashPwrd = new BigInteger(1,m.digest()).toString(16);
	    if(hashPwrd.length() == 31)
	    	hashPwrd = "0" + hashPwrd;
	    return hashPwrd;
	}
}
