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

	
	private Integer id;
	private Integer quantity;
	private static final long serialVersionUID = 1L;

	public CommandLine() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
   
}
