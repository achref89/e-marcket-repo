package testModule2.categoryManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CategoryServiceRemote;
import entities.Category;

public class TestAddCategory {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CategoryServiceRemote proxy = (CategoryServiceRemote) context
				.lookup("/eMarket-ejb/CategoryService!services.module2.interfaces.CategoryServiceRemote");

		Category category = new Category("emchi 3ad");
		proxy.addCategory(category);
		System.out.println("c bon mchet");
//		proxy.deleteCategory(category);
	}

}
