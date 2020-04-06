package ifer.web.shopping;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ifer.web.shopping.db.Product;
import ifer.web.shopping.form.CategoryForm;
import ifer.web.shopping.form.ProductForm;
import ifer.web.shopping.repo.CategoryRepo;
import ifer.web.shopping.repo.ProductRepo;
import ifer.web.shopping.util.DataException;
import ifer.web.shopping.repo.ProductRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTests {
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	
	@Test
	public void findByProdidTest (){
		Product product = productRepo.findByProdid(1);
		assertNotNull(product);
	}
	
	@Test
	public void findAllTest (){
		List<Product> prodlist = productRepo.findAll();
		assertEquals(7, prodlist.size());
		
	}	
	
	@Test
	public void addProductTest () {
		ProductForm prodform = new ProductForm(null, "Καθαριστικό", 2);
		try {
			productRepo.addOrUpdateProduct(prodform);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}	
	
	@Test
	public void deteteProductTest () {
		try {
			productRepo.deleteProduct(8);
		} catch (DataException e) {
				e.printStackTrace();
		}
	}
	

}
