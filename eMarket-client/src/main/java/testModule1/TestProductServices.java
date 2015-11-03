package testModule1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.experimental.categories.Categories;

import services.module2.interfaces.CategoryServiceRemote;
import services.module2.interfaces.ProductServiceRemote;
import entities.Category;
import entities.Product;

public class TestProductServices {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProductServiceRemote proxy = (ProductServiceRemote) context
				.lookup("/eMarket-ejb/ProductServiceRemote!services.module2.interfaces.ProductServiceRemote");

		Product product = new Product("TestProduct");
		product.setId(1);
		proxy.createProductWhithNewCategory(product,);
		System.out.println("produit ajooter ");
	}

}
