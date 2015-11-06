package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import services.module2.interfaces.CommandManagementServiceRemote;

public class TestMostCommandedProduct {

	public static void main(String[] args)throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
		Product product=proxy.mostCommandedProduct();
		System.out.println(product.getLibelle()+" is the most commanded product");
	}

}
