package entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CommandLine
 *
 */
@Entity

public class CommandLine implements Serializable {

	
	private CommandLinePK id;
	private Integer quantity;
	private static final long serialVersionUID = 1L;
	
	private Product product;
	private Command command;

	public CommandLine() {
		super();
	}   
	@EmbeddedId    
	public CommandLinePK getId() {
		return this.id;
	}

	public void setId(CommandLinePK id) {
		this.id = id;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@ManyToOne
	@JoinColumn(name="id_product",referencedColumnName="id",insertable=false,updatable=false)
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_command",referencedColumnName="id",insertable=false,updatable=false)
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
   
}
