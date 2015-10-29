package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
public class Product implements Serializable {

	private Integer id;
	private String libelle;
	private Float price;
	private Integer quantity;
	private Byte[] image;

	private Category category;
	private List<Command> commands;
	private static final long serialVersionUID = 1L;

	public Product() {
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

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Byte[] getImage() {
		return this.image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	//******************************************************
	//*****************************************************
	public Category getCategory() {
		return category;

	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToMany
	@JoinTable(
			name="CommandeLine"
			joincolumn =@JoinColumn(name="pro")
			)
	public List<Command> getCommands() {
		return commands;
		
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;

	}

}
