package ifer.web.shopping;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ifer.web.shopping.db.Shoplist;
import ifer.web.shopping.form.ShoplistForm;
import ifer.web.shopping.repo.ProductRepo;
import ifer.web.shopping.repo.ShoplistRepo;
import ifer.web.shopping.util.DataException;
import ifer.web.shopping.util.ShoppingListConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoplistTest {
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ShoplistRepo shoplistRepo;
	
	@Test
	public void findByListidTest (){
		Shoplist shoplist = shoplistRepo.findByListid(1);
		assertNotNull(shoplist);
	}
	
	@Test
	public void findAllTest (){
		List<Shoplist> shoplist = shoplistRepo.findAll();
		assertEquals(4, shoplist.size());
		
	}	
	
	@Test
	public void addShoplistTest () {
		ShoplistForm shopform = new ShoplistForm(null, 3,  2, "All Bran");
		try {
			shoplistRepo.addOrUpdateShoplist(shopform);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}	

	@Test
	public void updateShoplistTest () {
		Shoplist shoplist = null;
		Optional<Shoplist> optShop = shoplistRepo.findById(3);
		
		if (optShop.isPresent()) {
			shoplist = optShop.get();
		}
		else {
			fail("Should not have thrown any exception");
		}
		shoplist.setComment("AJAX again");
		
		ShoplistForm shopform = new ShoplistForm(shoplist);
		try {
			shoplistRepo.addOrUpdateShoplist(shopform);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}	
	@Test
	public void deteteShoplistTest () {
		try {
			shoplistRepo.deleteShoplist(5);
		} catch (DataException e) {
				e.printStackTrace();
		}
	}
		
	
}
