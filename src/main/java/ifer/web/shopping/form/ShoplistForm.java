package ifer.web.shopping.form;

import ifer.web.shopping.db.Shoplist;

public class ShoplistForm {
	private Integer listid;

	private Integer prodid;
	
	private Integer quantity;
	
	private String comment;
	
    
    

	public ShoplistForm() {
		
	}




	public ShoplistForm(Integer listid, Integer prodid, Integer quantity, String comment) {
		super();
		this.listid = listid;
		this.prodid = prodid;
		this.quantity = quantity;
		this.comment = comment;
	}




	//Constructor based on Shoplist
	public ShoplistForm(Shoplist shoplist) {
		this (
			shoplist.getListid(),
			shoplist.getProduct().getProdid(),
			shoplist.getQuantity(),
			shoplist.getComment()
		);
		
	}
	
	public Shoplist toShoplist() {
		return toShoplist(null);
	}
	
	public Shoplist toShoplist (Shoplist shoplist) {
		if (shoplist == null) {
			shoplist = new Shoplist();
		}
		shoplist.setListid(this.getListid());
		shoplist.setQuantity(this.getQuantity());
		shoplist.setComment(this.getComment());
		
		return shoplist;
	}

	public Integer getListid() {
		return listid;
	}



	public void setListid(Integer listid) {
		this.listid = listid;
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
