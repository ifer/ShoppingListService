package ifer.web.shopping.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Category;
import ifer.web.shopping.form.ProductForm;
import ifer.web.shopping.util.DataException;
import ifer.web.shopping.util.ShoppingListConstants;

public class ProductRepoImpl implements ProductRepoCustom {
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Product addOrUpdateProduct(ProductForm prodform) throws DataException {
		Product product;
		
		if (prodform.getCatid() == null) {
			throw new DataException (ShoppingListConstants.ProdCatIdNotFound);
		}

		if (prodform.getProdid() == null || prodform.getProdid() == 0){
			
//			Category category;
//			Optional<Category> optCat = categoryRepo.findById(prodform.getCatid());
//			if (optCat.isPresent()) {
//				category = optCat.get();
//			}
//			else {
//				throw new DataException (ShoppingListConstants.CategoryIdNotFound + " " + prodform.getCatid());
//			}
			
		
			product = new Product();
		}
		else {
			Optional<Product> optProd = productRepo.findById(prodform.getProdid());
			if (optProd.isPresent()) {
				product = optProd.get();
			}
			else {
				throw new DataException (ShoppingListConstants.ProductIdNotFound + " " + prodform.getProdid());
			}
		}


		product = prodform.toProduct(product);
		Category category = getCategoryById(prodform.getCatid());
		product.setCategory(category);
		
		product = productRepo.save(product);
		
		return (product);	
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteProduct(Integer prodid) throws DataException {
		Product product;
		Optional<Product> optProd = productRepo.findById(prodid);
		if (optProd.isPresent()) {
			product = optProd.get();
		}
		else {
			throw new DataException (ShoppingListConstants.ProductIdNotFound + " " + prodid);
		}
		productRepo.delete(product);
		
		
	}
	
	private Category getCategoryById(int catid)  throws DataException {
		Category category;
		Optional<Category> optCat = categoryRepo.findById(catid);
		if (optCat.isPresent()) {
			category = optCat.get();
		}
		else {
			throw new DataException (ShoppingListConstants.CategoryIdNotFound + " " + catid);
		}
	
		return (category);
	}

}
