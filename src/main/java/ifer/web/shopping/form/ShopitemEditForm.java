package ifer.web.shopping.form;

public class ShopitemEditForm {
	private Integer prodid;
	private String productName;
	private Integer catid;
	private String categoryName;
	private String quantity;
	private boolean selected;
	
	
	public ShopitemEditForm() {
		super();
	}



	public ShopitemEditForm(Integer prodid, String productName, Integer catid, String categoryName, String quantity,
			boolean selected) {
		super();
		this.prodid = prodid;
		this.productName = productName;
		this.catid = catid;
		this.categoryName = categoryName;
		this.quantity = quantity;
		this.selected = selected;
	}




	public Integer getProdid() {
		return prodid;
	}


	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Integer getCatid() {
		return catid;
	}


	public void setCatid(Integer catid) {
		this.catid = catid;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getQuantity() {
		return quantity;
	}



	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	

}
