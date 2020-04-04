package ifer.web.shopping.repo;



import java.util.Optional;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ifer.web.shopping.db.User;
import ifer.web.shopping.form.UserForm;
import ifer.web.shopping.util.DataException;
import ifer.web.shopping.util.ShoppingListConstants;

public class UserRepoImpl implements UserRepoCustom {
	@Autowired
	private UserRepo userRepo;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public User addOrUpdateUser (UserForm userForm) throws DataException{
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(ShoppingListConstants.enckey);
		
		Integer uid = userForm.getUserid();
//		Optional<User> user;
		User user;
		
		if (uid == null){
			user = new User();
			
			User duplicate = userRepo.findByName(userForm.getName());
			if (duplicate != null){
				throw new DataException (ShoppingListConstants.DuplicateUser + ": " + userForm.getName());
			}
		}
		else {
			Optional<User> optUser = userRepo.findById(uid);
			
			if (optUser.isPresent()){
				user = optUser.get();
			}
			else {
				throw new DataException (ShoppingListConstants.UserIdNotFound + ": " + userForm.getUserid());
			}	
			
// Alternative syntax			
//			user = userRepo.findById(uid)
//					.orElseThrow(() -> new DataException (ShoppingListConstants.UserIdNotFound + ": " + userForm.getUserid()));
			
		}
		
		
		user.setName(userForm.getName());
		
		if (userForm.getPasswd() != null){
			user.setPasswdhash(encryptor.encrypt(userForm.getPasswd()));
		}
		
		user.setRoles(userForm.getRoles());
		
		user = userRepo.save(user);
		
		return (user);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public User updatePassword (UserForm userForm) throws DataException{
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(ShoppingListConstants.enckey);
		

		User user = userRepo.findByName(userForm.getName());
		
		if (user == null){
			throw new DataException (ShoppingListConstants.UserIdNotFound + ": " + userForm.getUserid());
		}			

		
		if (userForm.getPasswd() != null){
			System.out.println ("Encoding and setting password");
			user.setPasswdhash(encryptor.encrypt(userForm.getPasswd()));
		}
		else
			throw new DataException (ShoppingListConstants.PasswordEmpty);
		
		
		user = userRepo.save(user);
		
		return (user);
	}	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteUser (Integer uid) throws Exception {

		Optional<User> optUser = userRepo.findById(uid);
		
		if (optUser.isPresent()){
			User user = optUser.get();
			userRepo.delete(user);
		}
		else {
			throw new DataException (ShoppingListConstants.UserIdNotFound + ": " +uid);
		}	
		
	}	

}
