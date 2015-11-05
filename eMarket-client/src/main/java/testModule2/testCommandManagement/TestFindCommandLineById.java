package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.CommandLine;
import entities.CommandLinePK;

public class TestFindCommandLineById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String url = "eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote";
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup(url);
		CommandLine commandLine = proxy.findCommandLineById(new CommandLinePK(
				1, 1));
		System.out.println(commandLine.getId().getIdCommand() + "   " + " "
				+ commandLine.getId().getIdProduct());

	}

}
