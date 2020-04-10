package ifer.web.shopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Shopitem;

public interface ShopitemRepo extends CrudRepository<Shopitem, Integer>, JpaSpecificationExecutor<Shopitem>, ShopitemRepoCustom {
	public Shopitem findByItemid (int itemid);
	public List<Shopitem> findAll(); 

}

