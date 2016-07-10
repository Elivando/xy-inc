package com.zup.xyinc.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

import com.zup.xyinc.data.ConnectionFactory;
import com.zup.xyinc.data.ProductData;
import com.zup.xyinc.model.*;

/**
 * @author Elivando França
 *
 */
@ApplicationScoped
public class ProductService {

	private EntityManager entityManager = ConnectionFactory.getEntityManager();
	private ProductData productData = new ProductData(entityManager);	

	/**
	 * Get all products
	 * @return all products
	 */
	public List<Product> getAllProducts() {
		return productData.getAllProducts();
	}

	/**
	 * Get product by id
	 * @param id of the product
	 * @return product
	 */
	public Product getById(Long id){
		return productData.getById(id);
	}	

	/**
	 * Create product
	 * @param product
	 */
	public void create(Product product){
		entityManager.getTransaction().begin();
		productData.create(product);
		entityManager.getTransaction().commit();
	}
	/**
	 * Update product
	 * @param product
	 */
	public void update(Product product) {
		entityManager.getTransaction().begin();
		productData.update(product);
		entityManager.getTransaction().commit();
	}

	/**
	 * Delete product
	 * @param product
	 */
	public void delete(Product product) {
		entityManager.getTransaction().begin();
		productData.delete(product);
		entityManager.getTransaction().commit();
	}
}

