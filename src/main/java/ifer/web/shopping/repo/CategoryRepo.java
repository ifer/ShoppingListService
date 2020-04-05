package ifer.web.shopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;


import ifer.web.shopping.db.Category;



public interface CategoryRepo extends CrudRepository<Category, Integer>, JpaSpecificationExecutor<Category>, CategoryRepoCustom  {
	public Category findByCatid (int catid);
	public List<Category> findAll(); 
}