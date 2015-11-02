package testModule2;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CategoryServiceRemote;
import entities.Category;

public class TestCategoryServices {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CategoryServiceRemote proxy = (CategoryServiceRemote) context
				.lookup("/eMarket-ejb/CategoryService!services.module2.interfaces.CategoryServiceRemote");

		Category category = new Category("TestCategory");
		category.setId(1);
		proxy.addCategory(category);
		System.out.println("c bon mchet");
	}

}
