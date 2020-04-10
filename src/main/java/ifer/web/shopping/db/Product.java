package ifer.web.shopping.db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prodid;
	
	@NotNull
	private String descr;
	
    @ManyToOne
    @JoinColumn(name="catid", nullable = false)
	private Category category;
    
	@JsonIgnore   //Avoid json the infinite recursion problem 
	@OneToMany(mappedBy="product")
	private Set<Shopitem> shopitems = new HashSet<Shopitem>();    

	
	public Product() {
		
	}

	public Product(Integer prodid, @NotNull String descr, Category category) {
		super();
		this.prodid = prodid;
		this.descr = descr;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}	

    
    
}
