package services.module2.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Category;
import entities.Product;

@Remote
public interface ProductServiceRemote {

	public void insertProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public Product getProductById(int id);
	
	public List<Product>getAllProducts();
	
	public Boolean createProductWhithNewCategory(Product product, Category category);
	
}
