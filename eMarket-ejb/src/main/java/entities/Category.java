package entities;
import java.util.List;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	
	private Integer id;
	private String libelle;
	
	private static final long serialVersionUID = 1L;
	
	private List<Product>products;
	
	public Category() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	public List<Product> getProducts() {
		return products;
	}
   public void setProducts(List<Product> products) {
	   this.products=products;
	
}
   public void linkProductToThisCategory(List<Product> products) {
		this.products = products;
		for (Product p : products) {
			p.setCategory(this);
		}
	}
}
