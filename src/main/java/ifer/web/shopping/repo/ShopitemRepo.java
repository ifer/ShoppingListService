package ifer.web.shopping.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Shopitem;

public interface ShopitemRepo extends CrudRepository<Shopitem, Integer>, JpaSpecificationExecutor<Shopitem>, ShopitemRepoCustom {
	public Shopitem findByItemid (int itemid);
	public List<Shopitem> findAll(); 
	public void deleteAll();
	
	@Query("from Shopitem s join s.product p join p.category c order by c.descr, p.descr")
	public List<Shopitem> findShopitemPrintList ();


}

