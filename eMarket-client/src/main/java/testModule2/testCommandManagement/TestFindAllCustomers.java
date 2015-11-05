package testModule2.testCommandManagement;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Customer;

public class TestFindAllCustomers {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String url = "eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote";
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup(url);

		List<Customer> customers = proxy.findAllCustomers();

		for (Customer customer : customers) 
		{
			System.out.println(customer.getLogin() + "********"
					+ customer.getPassword());
		}
	}

}
