package services.module1.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Customer;

@Remote
public interface CustomerServiceRemote {
public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
	public Customer getCustomerById(int id);
	
	public List<Customer>getAllCustomers();
}
