package services.module2.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		// TODO Auto-generated method stub
		entityManager.persist(category);
	}
	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		entityManager.merge(category);
	}
	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		entityManager.remove(category);
		
	}
	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Category.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategoryies() {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select cg from Customer cg");
		return query.getResultList();
	}

}
