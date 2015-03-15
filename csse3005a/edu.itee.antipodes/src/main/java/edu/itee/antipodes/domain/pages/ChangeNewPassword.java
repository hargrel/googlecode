package edu.itee.antipodes.domain.pages;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.IAccountManager;
import edu.itee.antipodes.service.PasswordHash;
import edu.itee.antipodes.utils.SpringApplicationContext;

public final class ChangeNewPassword {

	@NotBlank
	@Length(max = 20)
	private String oldPassword;

	@NotBlank
	@Length(max = 20)
	private String newPassword;

	@NotBlank
	@Length(max = 20)
	private String retypePassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}


	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "newPassword")
    private boolean comparePassword() {	
		if(newPassword.equals(retypePassword))
			return true;
		else
			return false;
    }
	private IAccountManager accountUserManager;
	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "oldPassword")
    private boolean compareOldPassword() throws Exception {	
		CurrentUser curUser = new CurrentUser();
		accountUserManager = SpringApplicationContext.getAccountManager();
		
		PasswordHash hash = new PasswordHash();
		
		oldPassword = hash.Hash(oldPassword);
		
		if(oldPassword.equals(accountUserManager.getAccountByID(curUser.getCurrentUserID()).getPassword()))
			return true;
		else
			return false;
    }
	
}
