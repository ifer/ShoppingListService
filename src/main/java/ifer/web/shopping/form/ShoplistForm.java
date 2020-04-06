package ifer.web.shopping.form;

import ifer.web.shopping.db.Shoplist;

public class ShoplistForm {
	private Integer listid;

	private Integer prodid;
	
	private Integer amount;
	
	private String comment;
	
    
    

	public ShoplistForm() {
		
	}



	public ShoplistForm(Integer listid, Integer prodid, Integer amount, String comment) {
		this.listid = listid;
		this.amount = amount;
		this.comment = comment;
		this.prodid = prodid;
	}

	//Constructor based on Shoplist
	public ShoplistForm(Shoplist shoplist) {
		this (
			shoplist.getListid(),
			shoplist.getProduct().getProdid(),
			shoplist.getAmount(),
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
		shoplist.setAmount(this.getAmount());
		shoplist.setComment(this.getComment());
		
		return shoplist;
	}

	public Integer getListid() {
		return listid;
	}



	public void setListid(Integer listid) {
		this.listid = listid;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
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
    
  
	
    
}
