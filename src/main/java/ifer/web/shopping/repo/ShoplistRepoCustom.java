package ifer.web.shopping.repo;

import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Shoplist;
import ifer.web.shopping.form.ProductForm;
import ifer.web.shopping.form.ShoplistForm;
import ifer.web.shopping.util.DataException;

public interface ShoplistRepoCustom {
	public Shoplist addOrUpdateShoplist (ShoplistForm shoplistform) throws DataException;
	public void deleteShoplist (Integer listid) throws DataException;
}
