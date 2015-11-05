package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Command;
import entities.Customer;

public class TestUpdateCommand {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String url = "eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote";
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup(url);
		Command command = proxy.findCommandById(1);
		Customer customer=proxy.findCustomerById(1);
	
		command.setCustomer(customer);

		proxy.updateCommand(command);

	}

}
