package ifer.web.shopping.repo;

import ifer.web.shopping.db.User;
import ifer.web.shopping.form.UserForm;
import ifer.web.shopping.util.DataException;

public interface UserRepoCustom {
	public User addOrUpdateUser (UserForm userForm) throws DataException;
	public void deleteUser (Integer uid) throws Exception;
	public User updatePassword(UserForm userForm) throws DataException;
}
