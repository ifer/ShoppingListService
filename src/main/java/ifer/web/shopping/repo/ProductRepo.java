package ifer.web.shopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ifer.web.shopping.db.Product;



public interface ProductRepo extends CrudRepository<Product, Integer>, JpaSpecificationExecutor<Product>, ProductRepoCustom {
	public Product findByProdid (int prodid);
	public List<Product> findAll(); 

}
