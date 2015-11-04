package testcustomer;
	import javax.naming.Context;
	import javax.naming.InitialContext;
	import javax.naming.NamingException;

	import entities.Customer;
	import entities.Product;
	import services.module1.interfaces.CustomerServiceRemote;
	import services.module2.interfaces.ProductServiceRemote;



	public class updateCustomer {

		public static void main(String[] args) throws NamingException {
			Context context = new InitialContext();
			CustomerServiceRemote proxy = (CustomerServiceRemote) context
					.lookup("/eMarket-ejb/CustomerService!services.module2.interfaces.CustomerServiceRemote");

					Customer customer =new Customer();
		    proxy.updateCustomer(customer);

		}
	}