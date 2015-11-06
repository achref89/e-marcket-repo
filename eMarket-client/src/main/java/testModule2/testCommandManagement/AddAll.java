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
		String str = "customer";
		
		for (int i = 0; i < 3; i++) {
			Customer customer=new Customer(str + (i + 1),str + (i + 1));
			customer.setName(str);customer.setLastName(str);
			proxy.addCustomer(customer);
			System.out.println("customer " + (i + 1) + " added");
		}

		// category/*************************************
		String categoryLibelle = "category";
		for (int i = 0; i < 3; i++) {
			proxy.addCategory(new Category(categoryLibelle + (i + 1)));
			System.out.println("Category " + (i + 1) + " added");
		}

		// ///////// product

		int price = 0;
		for (int i = 0; i < 3; i++) {
			Product product = new Product();
			float f = new Float(price + i);
			product.setPrice(f);
			Category category = proxy.findCategoryById(i + 1);
			if (category == null) {
				System.out
						.println("Category null where searching for in addProduct"
								+ i);
			} else {
				product.setCategory(category);
			}
			proxy.addProduct(i + 1, product);
			System.out.println("product " + (i + 1) + " added");
		}

		// command
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				proxy.addCommand((i + 1), new Command());
				System.out.println("command" + j + " added for user" + i);
			}
		}
		// ///////commdLine

		for (Command command : proxy.findAllCommands()) {
			for (Product product : proxy.findAllProducts()) {
				
				CommandLine commandLine = 
						new CommandLine(new CommandLinePK(product.getId(),command.getId()));
				commandLine.setQuantity(5);
				proxy.addCommandLine(product.getId(),command.getId(), commandLine);
				System.out.println("commandLine added for product"+product.getId()+" commande "+command.getId());

			}

		}

		

	}
}
