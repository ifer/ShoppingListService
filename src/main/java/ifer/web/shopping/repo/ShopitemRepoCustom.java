package ifer.web.shopping.repo;

import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Shopitem;
import ifer.web.shopping.form.ProductForm;
import ifer.web.shopping.form.ShopitemForm;
import ifer.web.shopping.util.DataException;

public interface ShopitemRepoCustom {
	public Shopitem addOrUpdateShopitem (ShopitemForm shopitemform) throws DataException;
	public void deleteShopitem (Integer itemid) throws DataException;
}
