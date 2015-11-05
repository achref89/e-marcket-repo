package testModule2.testcategoryManagement;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.module2.interfaces.CategoryServiceRemote;
import entities.Category;

public class TestGetAllCategories {

	public static void main(String[] args)throws NamingException {
		Context context = new InitialContext();
		CategoryServiceRemote proxy = (CategoryServiceRemote) context
				.lookup("/eMarket-ejb/CategoryService!services.module2.interfaces.CategoryServiceRemote");

		List<Category> list=proxy.getAllCategoryies();
		

		for (Category category :list ) {
			System.out.println(category.getLibelle());
			System.out.println(category.getId());
		}
		
	}

}
