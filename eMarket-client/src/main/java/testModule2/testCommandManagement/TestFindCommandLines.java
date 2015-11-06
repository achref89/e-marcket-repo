package testModule2.testCommandManagement;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.CommandLine;
import services.module2.interfaces.CommandManagementServiceRemote;

public class TestFindCommandLines {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
	List<CommandLine> commandLines=proxy.findAllCommandsLine();
	for (CommandLine commandLine : commandLines) {
		System.out.println(commandLine.getCommand().getCustomer().getName()+
				commandLine.getProduct().getLibelle()+
				commandLine.getQuantity().toString());
		System.out.println(commandLine.getCommand().getDate()+
				commandLine.getProduct().getLibelle()+
				commandLine.getQuantity().toString());
	}
	

	}

}
