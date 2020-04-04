package ifer.web.shopping.repo;





import org.springframework.data.repository.CrudRepository;

import ifer.web.shopping.db.User;


public interface UserRepo extends CrudRepository<User, Integer>, UserRepoCustom {
	
    User findByName(String username);

}

