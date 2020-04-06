package ifer.web.shopping.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ifer.web.shopping.db.Category;
import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Shoplist;
import ifer.web.shopping.form.ShoplistForm;
import ifer.web.shopping.util.DataException;
import ifer.web.shopping.util.ShoppingListConstants;

public class ShoplistRepoImpl implements ShoplistRepoCustom {

	@Autowired
	private ShoplistRepo shoplistRepo;
	@Autowired
	private ProductRepo productRepo;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Shoplist addOrUpdateShoplist(ShoplistForm shoplistform) throws DataException {
		Shoplist shoplist;
		
		if (shoplistform.getListid() == null || shoplistform.getListid() == 0){
			if (shoplistform.getProdid() == null) {
				throw new DataException (ShoppingListConstants.ProductIdNotFound);
			}
			
			Product product;
			Optional<Product> optProd = productRepo.findById(shoplistform.getProdid());
			if (optProd.isPresent()) {
				product = optProd.get();
			}
			else {
				throw new DataException (ShoppingListConstants.ProductIdNotFound + " " + shoplistform.getProdid());
			}
			
			shoplist = new Shoplist();
			shoplist.setProduct(product);
		}
		else {
			Optional<Shoplist> optShop = shoplistRepo.findById(shoplistform.getListid());
			if (optShop.isPresent()) {
				shoplist = optShop.get();
			}
			else {
				throw new DataException (ShoppingListConstants.ShoplistIdNotFound + " " + shoplistform.getListid());
			}
		}


		shoplist = shoplistform.toShoplist(shoplist);
		
		shoplist = shoplistRepo.save(shoplist);
		
		return (shoplist);	
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteShoplist(Integer listid) throws DataException {
		Shoplist shoplist;
		Optional<Shoplist> optProd = shoplistRepo.findById(listid);
		if (optProd.isPresent()) {
			shoplist = optProd.get();
		}
		else {
			throw new DataException (ShoppingListConstants.ShoplistIdNotFound + " " + listid);
		}
		shoplistRepo.delete(shoplist);
		
	}


}
