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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCommand == null) ? 0 : idCommand.hashCode());
		result = prime * result
				+ ((idProduct == null) ? 0 : idProduct.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandLinePK other = (CommandLinePK) obj;
		if (idCommand == null) {
			if (other.idCommand != null)
				return false;
		} else if (!idCommand.equals(other.idCommand))
			return false;
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		return true;
	}
	
}
