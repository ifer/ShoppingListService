package ifer.web.shopping.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class List implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lid;

	@NotNull
	private Integer amount;
	
	private String comment;
	
    @ManyToOne
    @JoinColumn(name="prodid", nullable = false)
	private Product product;

	public List(Integer lid, @NotNull Integer amount, String comment, Product product) {
		super();
		this.lid = lid;
		this.amount = amount;
		this.comment = comment;
		this.product = product;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
    
}
