package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.CommandLinePK;

public class TestDeleteCommandLine {

	public static void main(String[] args)throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
proxy.deleteCommandLine(new CommandLinePK(1,1));
System.out.println("commandline deleted");		
	

	}

}
