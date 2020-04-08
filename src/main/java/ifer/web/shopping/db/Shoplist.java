package ifer.web.shopping.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Shoplist implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer listid;

	private Integer quantity;
	
	private String comment;
	
    @ManyToOne
    @JoinColumn(name="prodid", nullable = false)
	private Product product;
    
    

	public Shoplist() {
		
	}





	public Shoplist(Integer listid, Integer quantity, String comment, Product product) {
		super();
		this.listid = listid;
		this.quantity = quantity;
		this.comment = comment;
		this.product = product;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
    
}
