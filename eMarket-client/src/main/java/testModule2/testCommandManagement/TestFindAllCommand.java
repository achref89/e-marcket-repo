package testModule2.testCommandManagement;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Command;
import entities.CommandLine;

public class TestFindAllCommand {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String url = "eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote";
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup(url);

		List<Command> commands = proxy.findAllCommands();
		for (Command command : commands) {
			System.out.println(command.getId() + "      "
					+ command.getCustomer().getId());
			if (command.getCommandLines()==null){
				for (CommandLine commandLine : command.getCommandLines()) {
					System.out.println(command.getId() + "      "
							+ command.getCustomer().getId());
				}
			} else{
				System.out.println("Liste vide");
			}
		}
	}
}
