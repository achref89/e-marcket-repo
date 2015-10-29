package entities;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CommandLinePK
 *
 */
@Embeddable

public class CommandLinePK implements Serializable {

	
	private Integer idProduct;
	private Integer idCommand;
	private static final long serialVersionUID = 1L;

	public CommandLinePK() {
		super();
	}  
	
	@Column(name="id_product")
	public Integer getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}   
	@Column(name="id_command")
	public Integer getIdCommand() {
		return this.idCommand;
	}

	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}
   @Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
}
   @Override
public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
}
}
