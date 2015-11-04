package testCommande;



	import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Command;
import entities.Customer;
import entities.Product;
import services.module1.interfaces.CommandServiceRemote;
import services.module1.interfaces.CustomerServiceRemote;
import services.module2.interfaces.ProductServiceRemote;



	public class addCommand {

		public static void main(String[] args) throws NamingException {
			Context context = new InitialContext();
			CommandServiceRemote proxy = (CommandServiceRemote) context
					.lookup("/eMarket-ejb/CommandService!services.module2.interfaces.CommandServiceRemote");

					Command command =new Command();
		    proxy.addCommand(command);
		

		}
	}