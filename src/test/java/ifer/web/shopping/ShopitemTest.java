package ifer.web.shopping;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ifer.web.shopping.db.Shopitem;
import ifer.web.shopping.form.ShopitemForm;
import ifer.web.shopping.repo.ProductRepo;
import ifer.web.shopping.repo.ShopitemRepo;
import ifer.web.shopping.util.DataException;
import ifer.web.shopping.util.ShoppingListConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopitemTest {
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ShopitemRepo shopitemRepo;
	
	@Test
	public void findByItemidTest (){
		Shopitem shopitem = shopitemRepo.findByItemid(1);
		assertNotNull(shopitem);
	}
	
	@Test
	public void findAllTest (){
		List<Shopitem> shopitem = shopitemRepo.findAll();
		assertEquals(4, shopitem.size());
		
	}	
	
	@Test
	public void addShopitemTest () {
		ShopitemForm shopform = new ShopitemForm(null, 3,  "2", "All Bran");
		try {
			shopitemRepo.addOrUpdateShopitem(shopform);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}	

	@Test
	public void updateShopitemTest () {
		Shopitem shopitem = null;
		Optional<Shopitem> optShop = shopitemRepo.findById(3);
		
		if (optShop.isPresent()) {
			shopitem = optShop.get();
		}
		else {
			fail("Should not have thrown any exception");
		}
		shopitem.setComment("AJAX again");
		
		ShopitemForm shopform = new ShopitemForm(shopitem);
		try {
			shopitemRepo.addOrUpdateShopitem(shopform);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}	
	@Test
	public void deteteShopitemTest () {
		try {
			shopitemRepo.deleteShopitem(5);
		} catch (DataException e) {
				e.printStackTrace();
		}
	}
	
	@Test
	public void addShopitemListTest () {
		
		List sfList = new ArrayList<ShopitemForm>();
		
		for (int i=0; i<3; i++) {
			ShopitemForm shopform = new  ShopitemForm(null, i+1,  "2", "item " + (i+1));
			sfList.add(shopform);
		}

		
		try {
			shopitemRepo.addShopitemList(sfList);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}	
		
	@Test
	public void deleteShopitemListTest () {
		
		List sfList = new ArrayList<ShopitemForm>();
		
		for (int i=0; i<3; i++) {
			ShopitemForm shopform = new  ShopitemForm(6+i, i+1,  "2", "item " + (i+1));
			sfList.add(shopform);
		}

		
		try {
			shopitemRepo.deleteShopitemList(sfList);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}		

	@Test
	public void findShopitemListTest() {
		 List<Shopitem> silist = shopitemRepo.findShopitemPrintList();
		 assertEquals(46, silist.size());
		 for (int i=0; i<silist.size(); i++) {
			 Shopitem si = silist.get(i);
			 
			 System.out.printf ("%-60s %-40s %s\n", si.getProduct().getDescr(),
					                          si.getProduct().getCategory().getDescr(),
					                          si.getQuantity());
//			 System.out.println(silist.get(i));
		 }
	}

}
