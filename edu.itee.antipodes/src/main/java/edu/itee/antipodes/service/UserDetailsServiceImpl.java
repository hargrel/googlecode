package edu.itee.antipodes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.User;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.itee.antipodes.domain.db.AccountUser;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private static ApplicationContext currentApplicationContext;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private AccountManager accountManager;

	public UserDetails loadUserByUsername(String username) {
		if (currentApplicationContext == null)
			currentApplicationContext = applicationContext;
		
		System.out.println("+++ 90 "+applicationContext);
		// AccountUserDao aud = DaoManager.getAccountUserDao();
		//AccountManager aud = new SimpleAccountManager();

		AccountUser userEntity = accountManager.getAccountByUsername(username);

		if (userEntity == null)
			throw new UsernameNotFoundException("user not found");

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (userEntity.getUserType().equalsIgnoreCase("admin")) {
			authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		} else
			authorities.add(new GrantedAuthorityImpl("ROLE_OPERATOR"));

		UserDetails user = new User(userEntity.getUserName(), userEntity
				.getPassword(), true, true, true, true, authorities
				.toArray(new GrantedAuthority[] {}));

		return user;
	}


	public static ApplicationContext getCurrentApplicationContext() {
		return currentApplicationContext;
	}

	public static void setCurrentApplicationContext(
			ApplicationContext currentApplicationContext) {
		UserDetailsServiceImpl.currentApplicationContext = currentApplicationContext;
	}
	
	public static AccountManager getAccountManager(){
		if (currentApplicationContext == null)
			return null;
		
		return (AccountManager)currentApplicationContext.getBean("accountUserManager");
	}

}
