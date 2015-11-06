package services.module2.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.module2.interfaces.CommandManagementServiceLocal;
import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Category;
import entities.Command;
import entities.CommandLine;
import entities.CommandLinePK;
import entities.Customer;
import entities.Product;

/**
 * Session Bean implementation class commandManagementService
 */
@Stateless
public class commandManagementService implements
		CommandManagementServiceRemote, CommandManagementServiceLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public commandManagementService() {
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);

	}

	/**********************************************************************/
	@Override
	public void addCategory(Category category) {
		entityManager.persist(category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			entityManager.merge(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		try {

			entityManager.remove(findCategoryById(categoryId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("***************ici**********");
		}

	}

	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategoryies() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select c from Category c");
		return query.getResultList();
	}

	/**********************************************************************/
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.merge(customer);

	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		entityManager.remove(findCustomerById(customerId));

	}

	@Override
	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select c from Customer c");
		return query.getResultList();
	}

	@Override
	public Customer login(String login, String password) {
		Customer customer = null;
		String jpql = "select c from Customer c where c.login=:param1 and c.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			customer = (Customer) query.getSingleResult();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("bad credentials!!!");
		}

		return customer;
	}

	@Override
	public void addCommand(Integer customerId, Command command) {
		// TODO Auto-generated method stub
		command.setCustomer(findCustomerById(customerId));
		entityManager.persist(command);

	}

	@Override
	public void updateCommand(Command command) {
		// TODO Auto-generated method stub
		entityManager.merge(command);
	}

	@Override
	public void deleteCommand(Integer commandId) {
		// TODO Auto-generated method stub
		Command command = findCommandById(commandId);
		entityManager.remove(command);
	}

	@Override
	public Command findCommandById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Command.class, id);
	}

	@Override
	public List<Command> findAllCommands() {
		Query query = entityManager.createQuery("select cmd from Command cmd");
		return query.getResultList();// TODO Auto-generated method stub

	}

	@Override
	public void addProduct(Integer CategoryId, Product product) {
		product.setCategory(findCategoryById(CategoryId));
		entityManager.persist(product);

	}

	@Override
	public void updateProduct(Product product) {
		entityManager.merge(product);

	}

	@Override
	public void deleteProduct(Integer productId) {
		entityManager.remove(findProductById(productId));

	}

	@Override
	public Product findProductById(int productId) {

		return entityManager.find(Product.class, productId);
	}

	@Override
	public List<Product> findAllProducts() {
		Query query = entityManager.createQuery("select p from Product p");
		return query.getResultList();
	}

	@Override
	public void addCommandLine(Integer productId, Integer commandId,
			CommandLine commandLine) {
		commandLine.setCommand(findCommandById(commandId));
		commandLine.setProduct(findProductById(productId));
		try {
			entityManager.persist(commandLine);
		} catch (Exception e) {
			System.out.println("insert exeption");
			e.printStackTrace();
		}

	}

	@Override
	public void updateCommandLine(CommandLine commandLine) {
		entityManager.merge(commandLine);

	}

	@Override
	public void deleteCommandLine(CommandLinePK commandLinePK) {
		CommandLine commandLine = findCommandLineById(commandLinePK);
		entityManager.remove(commandLine);

	}

	@Override
	public CommandLine findCommandLineById(CommandLinePK commandLinePK) {
		return entityManager.find(CommandLine.class, commandLinePK);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommandLine> findAllCommandsLine() {
		Query query = entityManager
				.createQuery("select cl from CommandLine cl");
		return query.getResultList();// TODO Auto-generated method stub
	}

	// @Override
	// public List<Command> findAllCommandByCustomer(Customer customer){
	//
	// Query query = entityManager.createQuery
	// ( "select cmd from Competence cmd "
	// + " where :customer member of cmd.customer");
	// query.setParameter("customer", customer);
	// return query.getResultList();
	//
	// }

	public float totalCommandsByCustomer(Integer customerId) {
		float ret = 0;
		Customer customer = findCustomerById(customerId);
		List<Command> commands = customer.getCommands();
		for (Command command : commands) {
			List<CommandLine> commandLines = command.getCommandLines();
			for (CommandLine commandLine : commandLines) {
				float a = (commandLine.getProduct().getPrice())
						* (commandLine.getQuantity());
				ret += a;
			}

		}
		return ret;
	}

	@Override
	public Customer bestCustomer() {
		Customer best = null;
		float max = 0;

		for (Customer customer : findAllCustomers()) {
			float f = totalCommandsByCustomer(customer.getId());
			if (f > max) {
				max = f;
				best = customer;
			}
		}
		return best;
	}

	@Override
	public int UnitsCommandedByProduct(Integer productId) {
		int tot = 0;
		Product product = findProductById(productId);
		List<CommandLine> commandLines = product.getCommandLines();
		for (CommandLine commandLine : commandLines) {
			tot += commandLine.getQuantity();
		}
		return tot;
	}

	@Override
	public Product mostCommandedProduct() {
		Product most = null;
		float max = 0;

		for (Product product : findAllProducts()) {
			int f = UnitsCommandedByProduct(product.getId());
			if (f > max) {
				max = f;
				most = product;
			}
		}
		return most;
	}

}
