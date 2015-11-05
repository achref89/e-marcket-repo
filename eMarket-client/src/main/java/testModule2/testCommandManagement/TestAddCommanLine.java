package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.CommandLine;
import entities.CommandLinePK;

public class TestAddCommanLine {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
CommandLine commandLine=new CommandLine(new CommandLinePK(1,1));

commandLine.setQuantity(5);
		proxy.addCommandLine(1, 1,commandLine );
		
		System.out.println("commandline added");

	}

}
