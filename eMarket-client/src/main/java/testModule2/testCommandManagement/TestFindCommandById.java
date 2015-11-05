package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Command;

public class TestFindCommandById {

	public static void main(String[] args)throws NamingException {
		Context context = new InitialContext();
		String url = "eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote";
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup(url);
		Command command=proxy.findCommandById(1);
		if (command==null) {
			System.out.println("lllllll");
		}
		else{
		System.out.println(command.getCustomer().getLogin());
		}
	}

}
