package testProductService;

	import javax.naming.Context;
	import javax.naming.InitialContext;
	import javax.naming.NamingException;

	import entities.Category;
		import entities.Product;
	import services.module2.interfaces.ProductServiceRemote;

	public class getAllProducts {

			public static void main(String[] args) throws NamingException {
				Context context = new InitialContext();
				ProductServiceRemote proxy = (ProductServiceRemote) context
						.lookup("/eMarket-ejb/ProductService!services.module2.interfaces.ProductServiceRemote");
				
				
				Product product = new Product();
				Category category = new Category();
			    proxy.getAllProducts();

			}
		}

