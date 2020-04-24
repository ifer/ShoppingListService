package ifer.web.shopping;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ifer.web.shopping.db.Category;
import ifer.web.shopping.form.CategoryForm;
import ifer.web.shopping.repo.CategoryRepo;
import ifer.web.shopping.util.DataException;
import ifer.web.shopping.util.ShoppingListConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTests {
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Test
	public void findByCatidTest (){
		Category category = categoryRepo.findByCatid(1);
		assertNotNull(category);
	}
	
	@Test
	public void findAllTest (){
		List<Category> catlist = categoryRepo.findAll();
		assertEquals(2, catlist.size());
		
	}
	
	@Test
	public void addCategoryTest () {
		CategoryForm catform = new CategoryForm(null, "Κουζινικά");
		try {
			categoryRepo.addOrUpdateCategory(catform);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}

	@Test
	public void updateCategoryTest () {
		Category category = null;
		Optional<Category> optCat = categoryRepo.findById(2);
		if (optCat.isPresent()) {
			category = optCat.get();
		}
		else {
			fail("catid not found");
			
		}
		
		category.setDescr("Είδη καθαριότητας-2");
		
		CategoryForm catform = new CategoryForm(category);
		try {
			categoryRepo.addOrUpdateCategory(catform);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}
	
	@Test
	public void deteteCategoryTest () {
		try {
			categoryRepo.deleteCategory(1);
		} catch (DataException e) {
				e.printStackTrace();
		}
	}


}
