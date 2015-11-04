package testModule2.categoryManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CategoryServiceRemote;

public class TestDeleteCategory {

	public static void main(String[] args)  throws NamingException {
		Context context = new InitialContext();
		CategoryServiceRemote proxy = (CategoryServiceRemote) context
				.lookup("/eMarket-ejb/CategoryService!services.module2.interfaces.CategoryServiceRemote");
		
	
			proxy.deleteCategory(1);
			
		System.out.println("c bon mchet");
	}

}
