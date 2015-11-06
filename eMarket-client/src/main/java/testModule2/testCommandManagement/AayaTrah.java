package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;

public class AayaTrah {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");

		System.out.println(proxy.totalCommandsByCustomer(1));
	}
}
