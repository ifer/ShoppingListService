package ifer.web.shopping.form;

import ifer.web.shopping.db.Category;

public class CategoryForm {
	private Integer catid;
	private String descr;
	
	
	
	public CategoryForm() {
		
	}


	public CategoryForm(Integer catid, String descr) {
		
		this.catid = catid;
		this.descr = descr;
	}

	
	//Constructor based on Category
	public CategoryForm (Category category) {
		this(category.getCatid(),
		     category.getDescr());
	}

	public Category toCategory () {
		return (toCategory(null));
	}

	public Category toCategory (Category category) {
		if (category == null)
			category = new Category();
		
		category.setCatid(this.catid);
		category.setDescr(this.descr);
		
		return category;
	}
	
	public Integer getCatid() {
		return catid;
	}
	public void setCatid(Integer catid) {
		this.catid = catid;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}

	
}
