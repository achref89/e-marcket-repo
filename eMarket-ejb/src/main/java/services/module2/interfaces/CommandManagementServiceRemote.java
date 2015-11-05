package services.module2.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Customer;

@Remote
public interface CommandManagementServiceRemote {

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer findCustomerById(int id);

	public void deleteCustomer(Integer custumerId);

	public List<Customer> findAllCustomers();
	/*************************Customer********************************/

//	Boolean createCommand(Command command);
//
//	Command findCommandById(Integer commandId);
//
//	List<Command> findAllCommands();

}
