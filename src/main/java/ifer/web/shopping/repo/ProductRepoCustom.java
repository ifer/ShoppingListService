package ifer.web.shopping.repo;


import ifer.web.shopping.db.Product;
import ifer.web.shopping.form.ProductForm;
import ifer.web.shopping.util.DataException;

public interface ProductRepoCustom {
	public Product addOrUpdateProduct (ProductForm prodform) throws DataException;
	public void deleteProduct (Integer prodid) throws DataException;
}
