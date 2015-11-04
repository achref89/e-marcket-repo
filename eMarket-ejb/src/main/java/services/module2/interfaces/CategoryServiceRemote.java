package services.module2.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Category;

@Remote
public interface CategoryServiceRemote {
	
public void addCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void deleteCategory(int categoryId);
	
	public Category getCategoryById(int id);
	
	public List<Category>getAllCategoryies();

}
