package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Command;

public class TestAddCommand {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String url = "eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote";
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup(url);

		proxy.addCommand(1, new Command());
		System.out.println("command added");
	}

}
