package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Category;
import entities.Command;
import entities.CommandLine;
import entities.CommandLinePK;
import entities.Customer;
import entities.Product;

public class AddAll {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
		// customer/////////////////////////
		Customer customer = new Customer("tze", "bbEZb");
		proxy.addCustomer(customer);
		System.out.println("customer added");
		// category/*************************************
		Category category2 = new Category("emchi 3ad");
		proxy.addCategory(category2);
		System.out.println("c bon mchet");
		// product
		Product product = new Product();
		Category category = proxy.findCategoryById(1);
		if (category == null) {
			System.out.println("dsgsg");
		}
		product.setCategory(category);

		proxy.addProduct(1, product);
		System.out.println("product added");

		// command
		proxy.addCommand(1, new Command());
		System.out.println("command added");
		// ///////commdLine
		CommandLine commandLine = new CommandLine(new CommandLinePK(1, 1));

		commandLine.setQuantity(5);
		proxy.addCommandLine(1, 1, commandLine);

		System.out.println("commandline added");

	}
}
