package ifer.web.shopping.config;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifer.web.shopping.db.User;
import ifer.web.shopping.repo.UserRepo;
import ifer.web.shopping.util.ShoppingListConstants;


/**
 * This class is used by spring controller to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
    private final StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
   
	public  final String enckey = "F3vgounTaKalyteraMasXr0nia";

    @Autowired
    private  UserRepo userRepo;
  

    public UserDetailServiceImpl() {
		super();
		encryptor.setPassword(ShoppingListConstants.enckey);
	}



	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {   
    	User curruser = userRepo.findByName(username);
    	
    	if (curruser == null)
    		throw new UsernameNotFoundException(ShoppingListConstants.UserNotFound);
    	
    	String decrypted = encryptor.decrypt(curruser.getPasswdhash()) ;
    	
 	
//        UserDetails user = new org.springframework.security.core.userdetails.User(username, decrypted, true, 
//        		true, true, true, AuthorityUtils.createAuthorityList(curruser.getRoles()));
        UserDetails user = new org.springframework.security.core.userdetails.User(username, decrypted, true, 
        		true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList(curruser.getRoles()));        
        
        
        return user;
    }
    
}