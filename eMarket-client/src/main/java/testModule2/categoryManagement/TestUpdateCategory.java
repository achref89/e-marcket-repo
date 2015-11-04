package testModule2.categoryManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CategoryServiceRemote;
import entities.Category;


public class TestUpdateCategory {

	
		public static void main(String[] args) throws NamingException {
			Context context = new InitialContext();
			CategoryServiceRemote proxy = (CategoryServiceRemote) context
					.lookup("/eMarket-ejb/CategoryService!services.module2.interfaces.CategoryServiceRemote");

			Category category = proxy.getCategoryById(2);
			
			category.setLibelle("second step");

			proxy.updateCategory(category);
		}

	

}
