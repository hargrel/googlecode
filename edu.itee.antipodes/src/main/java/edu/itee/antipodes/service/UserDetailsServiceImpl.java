package edu.itee.antipodes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.*;
import org.springframework.stereotype.Service;


import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.service.AccountManager;

@Service("userDetailsService") 
public class UserDetailsServiceImpl implements UserDetailsService {
	
  public UserDetails loadUserByUsername(String username) {
	
	//AccountUserDao aud = DaoManager.getAccountUserDao();
	AccountManager aud = new SimpleAccountManager();
	
	
	AccountUser userEntity = aud.getAccountByUsername(username);
    
    if (userEntity == null)
      throw new UsernameNotFoundException("user not found");


	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    if(userEntity.getUserType().equalsIgnoreCase("admin")){
		authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
    }else
		authorities.add(new GrantedAuthorityImpl("ROLE_OPERATOR"));
    

    UserDetails user = new User(userEntity.getUserName(), userEntity.getPassword(), true,
    		true, true, true, authorities.toArray(new GrantedAuthority[] {}));
    
    return user;
  }
  
}
