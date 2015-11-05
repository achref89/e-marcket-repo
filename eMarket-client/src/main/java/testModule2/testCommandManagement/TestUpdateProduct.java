package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Product;

public class TestUpdateProduct {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
		Product product = proxy.findProductById(1);
	if (product==null) {
		System.out.println("uuhgih");	
	}
		product.setLibelle("updated");
		proxy.updateProduct(product);

	}
}
