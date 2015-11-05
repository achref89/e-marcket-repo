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
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCommandLine(Integer commandId, Integer ProductId,
			CommandLine commandLine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCommandLine(Command command) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCommandLine(Integer commandId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Command findCommandByIdLine(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Command> findAllCommandsLine() {
		// TODO Auto-generated method stub
		return null;
	}

}
