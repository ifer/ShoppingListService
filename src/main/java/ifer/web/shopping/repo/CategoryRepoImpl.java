package ifer.web.shopping.repo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ifer.web.shopping.db.Category;
import ifer.web.shopping.form.CategoryForm;
import ifer.web.shopping.util.DataException;
import ifer.web.shopping.util.ShoppingListConstants;

public class CategoryRepoImpl implements CategoryRepoCustom {
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Transactional(rollbackFor = Exception.class)
	public Category addOrUpdateCategory(CategoryForm catform) throws DataException {
		Category category;
		if (catform.getCatid() == null || catform.getCatid() == 0){
			category = new Category();
		}
		else {
			Optional<Category> optCat = categoryRepo.findById(catform.getCatid());
			if (optCat.isPresent()) {
				category = optCat.get();
			}
			else {
				throw new DataException (ShoppingListConstants.CategoryIdNotFound + " " + catform.getCatid());
			}
		}


		category = catform.toCategory(category);
		
		category = categoryRepo.save(category);
		
		return (category);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteCategory(Integer catid) throws DataException {
		Category category;
		Optional<Category> optCat = categoryRepo.findById(catid);
		if (optCat.isPresent()) {
			category = optCat.get();
		}
		else {
			throw new DataException (ShoppingListConstants.CategoryIdNotFound + " " + catid);
		}
		 categoryRepo.delete(category);
	}

}
