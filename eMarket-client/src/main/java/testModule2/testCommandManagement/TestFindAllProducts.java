package testModule2.testCommandManagement;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Product;

public class TestFindAllProducts {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup("eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote");
		List<Product> products = proxy.findAllProducts();
		if (products.size() == 0) {
			System.out.println("liste vide");
		} else {
			for (Product product : products) {
				System.out.println(product.getId());
			}
		}
	}
}
