package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;

public class TestDeleteCustomer {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy=(CommandManagementServiceRemote)context.
lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");

		int customerId=1;
		proxy.deleteCustomer(1);
System.out.println("customer   "+customerId+"   is removed");
	}

}
