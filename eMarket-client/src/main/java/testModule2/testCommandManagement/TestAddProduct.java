package testModule2.testCommandManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CommandManagementServiceRemote;
import entities.Category;
import entities.Product;

public class TestAddProduct {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String url = "eMarket-ejb/commandManagementService!services.module2.interfaces.CommandManagementServiceRemote";
		CommandManagementServiceRemote proxy = (CommandManagementServiceRemote) context
				.lookup(url);
		Product product = new Product();
		Category category = proxy.findCategoryById(1);
		if(category==null) {
			System.out.println("dsgsg");
		} 
		product.setCategory(category);

		proxy.addProduct(1, product);
		System.out.println("product added");
	}

}
