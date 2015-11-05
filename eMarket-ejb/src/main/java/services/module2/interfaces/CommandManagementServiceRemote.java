package services.module2.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Command;
import entities.CommandLine;
import entities.Customer;
import entities.Product;

@Remote
public interface CommandManagementServiceRemote {
	/************************* Customer ******************************/
	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer findCustomerById(int id);

	public void deleteCustomer(Integer custumerId);

	public List<Customer> findAllCustomers();

	/************************* Command ********************************/

	public void addCommand(Integer customerId, Command command);

	public void updateCommand(Command command);

	public void deleteCommand(Integer commandId);

	public Command findCommandById(int id);

	public List<Command> getAllCommands();

	/************************* Command ********************************/
	public void addProduct(Integer CategoryId, Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Integer productId);

	public Product findProductById(int id);

	public List<Product> getAllProducts();

	/************************* CommandLine ***************************/

	public void addCommandLine(Integer commandId, Integer ProductId,
			CommandLine commandLine);

	public void updateCommandLine(Command command);

	public void deleteCommandLine(Integer commandId);

	public Command findCommandByIdLine(int id);

	public List<Command> getAllCommandsLine();
	/************************* ********* ********************************/
	// Boolean createCommand(Command command);
	//
	// Command findCommandById(Integer commandId);
	//
	// List<Command> findAllCommands();

}
