package ifer.web.shopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Shoplist;

public interface ShoplistRepo extends CrudRepository<Shoplist, Integer>, JpaSpecificationExecutor<Shoplist>, ShoplistRepoCustom {
	public Shoplist findByListid (int listid);
	public List<Shoplist> findAll(); 

}

