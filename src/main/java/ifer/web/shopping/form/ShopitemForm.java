package ifer.web.shopping.form;

import ifer.web.shopping.db.Shopitem;

public class ShopitemForm {
	private Integer itemid;

	private Integer prodid;
	
	private Integer quantity;
	
	private String comment;
	
    
    

	public ShopitemForm() {
		
	}




	public ShopitemForm(Integer itemid, Integer prodid, Integer quantity, String comment) {
		super();
		this.itemid = itemid;
		this.prodid = prodid;
		this.quantity = quantity;
		this.comment = comment;
	}




	//Constructor based on Shopitem
	public ShopitemForm(Shopitem shopitem) {
		this (
			shopitem.getItemid(),
			shopitem.getProduct().getProdid(),
			shopitem.getQuantity(),
			shopitem.getComment()
		);
		
	}
	
	public Shopitem toShopitem() {
		return toShopitem(null);
	}
	
	public Shopitem toShopitem (Shopitem shopitem) {
		if (shopitem == null) {
			shopitem = new Shopitem();
		}
		shopitem.setItemid(this.getItemid());
		shopitem.setQuantity(this.getQuantity());
		shopitem.setComment(this.getComment());
		
		return shopitem;
	}

	public Integer getItemid() {
		return itemid;
	}



	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public Integer getProdid() {
		return prodid;
	}



	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}




	public Integer getQuantity() {
		return quantity;
	}




	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
    
  
	
    
}
