package ifer.web.shopping.form;

public class ShopitemPrintForm {

	private String productName;
	private String categoryName;
	private String quantity;	
	
	public ShopitemPrintForm() {
		super();
	}


	public ShopitemPrintForm(String productName, String categoryName, String quantity) {
		super();
		this.productName = productName;
		this.categoryName = categoryName;
		this.quantity = quantity;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	
	
	
}
