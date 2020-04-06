package ifer.web.shopping.form;

import ifer.web.shopping.db.Product;

public class ProductForm {
	private Integer prodid;
	
	private String descr;
	
	private Integer catid;

	public ProductForm() {
		
	}
	

	public ProductForm(Integer prodid, String descr, Integer catid) {
		this.prodid = prodid;
		this.descr = descr;
		this.catid = catid;
	}
	
	//Constructor based on Product
	public ProductForm (Product product) {
		this (
			product.getProdid(),
			product.getDescr(),
			product.getCategory().getCatid()
		);
	}
	


	public Product toProduct (Product product) {
		if (product == null) {
			product = new Product();
		}
		
		product.setProdid(this.prodid);
		product.setDescr(this.descr);
		
		return (product);
	}	

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getCatid() {
		return catid;
	}

	public void setCatid(Integer catid) {
		this.catid = catid;
	}
	
	

}
