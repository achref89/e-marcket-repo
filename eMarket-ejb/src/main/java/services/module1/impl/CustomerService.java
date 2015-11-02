package services.module1.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Customer;
import services.module1.interfaces.CustomerServiceLocal;
import services.module1.interfaces.CustomerServiceRemote;

/**
 * Session Bean implementation class CustomerService
 */
@Stateless
@LocalBean
public class CustomerService implements CustomerServiceRemote, CustomerServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public CustomerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.merge(customer);
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.remove(customer);
		
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select c from Customer c");
		return query.getResultList();
	}
	
	public Customer login(String login, String password){
		Customer customer=null;
		String jpql = "select c from Customer c where c.login=:param1 and c.password=:param2";
		Query query= entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			customer=(Customer) query.getSingleResult();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("bad credentials!!!");
		}
		
		return customer;
	}

	
	
}
