package ifer.web.shopping;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ifer.web.shopping.db.Category;
import ifer.web.shopping.form.CategoryForm;
import ifer.web.shopping.repo.CategoryRepo;
import ifer.web.shopping.util.DataException;



@RunWith(SpringRunner.class)
@SpringBootTest
class ShoppingListServiceApplicationTests {
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
	public void deteteCategoryTest () {
		try {
			categoryRepo.deleteCategory(3);
		} catch (DataException e) {
				e.printStackTrace();
		}
		
	}
}
