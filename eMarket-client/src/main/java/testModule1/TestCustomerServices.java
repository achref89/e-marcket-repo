package testModule1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module1.interfaces.CustomerServiceRemote;
import services.module2.interfaces.CategoryServiceRemote;
import entities.Category;
import entities.Customer;

public class TestCustomerServices {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CustomerServiceRemote proxy = (	CustomerServiceRemote) context
				.lookup("/eMarket-ejb/CategoryService!services.module2.interfaces.CustomerServiceRemote");

		Customer customer = new Customer();
		
		customer.setId(1);
		
		proxy.addCustomer(customer);
		System.out.println("client ajouter");
	}

}
