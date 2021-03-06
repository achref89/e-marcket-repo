package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Category;
import entities.Customer;

public class TestNumberByCustomerAndCategory {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
		Category category = proxy.findCategoryById(1);
		Customer customer = proxy.findCustomerById(1);
		System.out.println(proxy
				.numberByCustomerAndCategory(category, customer));

	}

}
