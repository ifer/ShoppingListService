package ifer.web.shopping.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ifer.web.shopping.db.Category;
import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Shopitem;
import ifer.web.shopping.form.ShopitemForm;
import ifer.web.shopping.util.DataException;
import ifer.web.shopping.util.ShoppingListConstants;

public class ShopitemRepoImpl implements ShopitemRepoCustom {

	@Autowired
	private ShopitemRepo shopitemRepo;
	@Autowired
	private ProductRepo productRepo;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Shopitem addOrUpdateShopitem(ShopitemForm shopitemform) throws DataException {
		Shopitem shopitem;
		
		if (shopitemform.getItemid() == null || shopitemform.getItemid() == 0){
			if (shopitemform.getProdid() == null) {
				throw new DataException (ShoppingListConstants.ProductIdNotFound);
			}
			
			Product product;
			Optional<Product> optProd = productRepo.findById(shopitemform.getProdid());
			if (optProd.isPresent()) {
				product = optProd.get();
			}
			else {
				throw new DataException (ShoppingListConstants.ProductIdNotFound + " " + shopitemform.getProdid());
			}
			
			shopitem = new Shopitem();
			shopitem.setProduct(product);
		}
		else {
			Optional<Shopitem> optShop = shopitemRepo.findById(shopitemform.getItemid());
			if (optShop.isPresent()) {
				shopitem = optShop.get();
			}
			else {
				throw new DataException (ShoppingListConstants.ShopitemIdNotFound + " " + shopitemform.getItemid());
			}
		}


		shopitem = shopitemform.toShopitem(shopitem);
		
		shopitem = shopitemRepo.save(shopitem);
		
		return (shopitem);	
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteShopitem(Integer itemid) throws DataException {
		Shopitem shopitem;
		Optional<Shopitem> optProd = shopitemRepo.findById(itemid);
		if (optProd.isPresent()) {
			shopitem = optProd.get();
		}
		else {
			throw new DataException (ShoppingListConstants.ShopitemIdNotFound + " " + itemid);
		}
		shopitemRepo.delete(shopitem);
		
	}


}
