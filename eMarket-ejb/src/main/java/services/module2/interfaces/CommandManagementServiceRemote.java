package services.module2.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Category;
import entities.Command;
import entities.CommandLine;
import entities.Customer;
import entities.Product;

@Remote
public interface CommandManagementServiceRemote {
	
	/************************* Category ******************************/
public void addCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void deleteCategory(int categoryId);
	
	public Category findCategoryById(int id);
	
	public List<Category> findAllCategoryies();

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

	public List<Command> findAllCommands();

	/************************* product ********************************/
	public void addProduct(Integer CategoryId, Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Integer productId);

	public Product findProductById(int id);

	public List<Product> findAllProducts();

	/************************* CommandLine ***************************/

	public void addCommandLine(Integer commandId, Integer ProductId,
			CommandLine commandLine);

	public void updateCommandLine(Command command);

	public void deleteCommandLine(Integer commandId);

	public Command findCommandByIdLine(int id);

	public List<Command> findAllCommandsLine();
	/************************* ********* ********************************/
	// Boolean createCommand(Command command);
	//
	// Command findCommandById(Integer commandId);
	//
	// List<Command> findAllCommands();

}
