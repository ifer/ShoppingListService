package ifer.web.shopping.db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Category implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catid;
	
	@NotNull
	private String descr;
	
	@JsonIgnore   //Avoid json the infinite recursion problem 
	@OneToMany(mappedBy="category")
	private Set<Product> products = new HashSet<Product>();
	

	public Category() {

	}

	public Category(Integer catid, @NotNull String descr) {
		super();
		this.catid = catid;
		this.descr = descr;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	

}
