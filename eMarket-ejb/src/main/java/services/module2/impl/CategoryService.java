package services.module2.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Category;
import services.module2.interfaces.CategoryServiceLocal;
import services.module2.interfaces.CategoryServiceRemote;

/**
 * Session Bean implementation class CategoryService
 */
@Stateless
public class CategoryService implements CategoryServiceRemote, CategoryServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public CategoryService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCategory(Category category) {
		entityManager.persist(category);
		}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategoryies() {
		// TODO Auto-generated method stub
		return null;
	}

}
