package services.module2.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Product;
import services.module2.interfaces.ProductServiceLocal;
import services.module2.interfaces.ProductServiceRemote;

/**
 * Session Bean implementation class ProductService
 */
@Stateless
@LocalBean
public class ProductService implements ProductServiceRemote, ProductServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public ProductService() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
    	entityManager.persist(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		entityManager.merge(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		entityManager.remove(product);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Query query=  entityManager.createQuery("select p from Product p");
		return query.getResultList();
	}


}