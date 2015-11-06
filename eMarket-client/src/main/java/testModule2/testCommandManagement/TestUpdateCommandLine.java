package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.CommandLine;
import entities.CommandLinePK;
import services.module2.interfaces.CommandManagementServiceRemote;

public class TestUpdateCommandLine {

	public static void main(String[] args)throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
	CommandLine commandLine=proxy.findCommandLineById(new CommandLinePK(1,1));
commandLine.setQuantity(commandLine.getQuantity()-1);
proxy.updateCommandLine(commandLine);
System.out.println("command Line updated");
	}

}
