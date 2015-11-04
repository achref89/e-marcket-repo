package testProductService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import services.module2.interfaces.ProductServiceRemote;


public class Addproduct {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProductServiceRemote proxy = (ProductServiceRemote) context
				.lookup("/eMarket-ejb/ProductService!services.module2.interfaces.ProductServiceRemote");
		
		
		Product product = new Product();
		product.setId(1);
		product.setLibelle("clavier");
		product.setPrice((float)7200);
		product.setQuantity(50);
		product.setCategory(null);
			
		
	    proxy.insertProduct(product);
	

	}
}
