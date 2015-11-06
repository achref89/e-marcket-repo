package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Customer;

public class TestBestCustomer {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
		Customer customer = proxy.bestCustomer();

		System.out.println("The best Customer is " + customer.getName()
				+ "with total ="
				+ proxy.totalCommandsByCustomer(customer.getId()));
		customer.setName("thebest");
		proxy.updateCustomer(customer);
		customer = proxy.bestCustomer();
		System.out.println("The best Customer is " + customer.getName()
				+ "with total ="
				+ proxy.totalCommandsByCustomer(customer.getId()));
	}

}
