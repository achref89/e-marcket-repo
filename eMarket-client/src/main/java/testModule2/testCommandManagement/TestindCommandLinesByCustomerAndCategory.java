package testModule2.testCommandManagement;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Category;
import entities.CommandLine;
import entities.Customer;

public class TestindCommandLinesByCustomerAndCategory {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
		Category category = proxy.findCategoryById(1);
		Customer customer = proxy.findCustomerById(1);
		List<CommandLine> commandLines = proxy
				.findCommandLinesByCustomerAndCategory(category, customer);
		for (CommandLine commandLine : commandLines) {
			System.out.println(commandLine.getCommand().getId() + " "
					+ commandLine.getProduct().getId());
		}
	}

}
