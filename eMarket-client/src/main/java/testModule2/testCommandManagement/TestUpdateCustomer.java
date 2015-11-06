package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Customer;

public class TestUpdateCustomer {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String url = "eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote";
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup(url);

		Customer customer = proxy.findCustomerById(1);
		if (customer==null){System.out.println("customer null");};
		customer.setName("Achref");
		customer.setLogin(customer.getLogin()+"Updated");
		customer.setPassword(customer.getPassword()+"Updated");
		proxy.updateCustomer(customer);
		System.out.println("customer updated");

	}

}
