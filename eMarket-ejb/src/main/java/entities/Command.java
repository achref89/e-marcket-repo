package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Command
 *
 */
@Entity

public class Command implements Serializable {

	
	private Integer id;
	private Date date;
	private static final long serialVersionUID = 1L;
	private List<CommandLine> commandLines;
	private Customer customer;

	public Command() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@OneToMany(mappedBy="command",cascade=CascadeType.ALL)
	public List<CommandLine> getCommandLines() {
		return commandLines;
	}
	public void setCommandLines(List<CommandLine> commandLines) {
		this.commandLines = commandLines;
	}
	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
   
}
