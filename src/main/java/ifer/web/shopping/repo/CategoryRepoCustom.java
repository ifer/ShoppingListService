package ifer.web.shopping.repo;

import ifer.web.shopping.db.Category;
import ifer.web.shopping.form.CategoryForm;
import ifer.web.shopping.util.DataException;

public interface CategoryRepoCustom {
	public Category addOrUpdateCategory (CategoryForm catform) throws DataException;
	public void deleteCategory (Integer catid) throws DataException;

}
