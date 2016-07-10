package com.zup.xyinc.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.zup.xyinc.interfaces.IProductData;
import com.zup.xyinc.model.Product;

/**
 * 
 * @author Elivando França
 * 
 * Data ProductData
 *
 */
public class ProductData implements IProductData {
	
	private EntityManager entityManager ;

	public ProductData(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	/**
	 * Get all products
	 * @return all products
	 */
	@Override
	public List<Product> getAllProducts() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteria = criteriaBuilder.createQuery(Product.class);
		Root<Product> product = criteria.from(Product.class);
		criteria.select(product).orderBy(criteriaBuilder.asc(product.get("name")));

		return entityManager.createQuery(criteria).getResultList();
	}

	/**
	 * Get product by id
	 * @param id of the product
	 * @return product
	 */
	@Override
	public Product getById(Long id) {
		return entityManager.find(Product.class, id);
	}

	/**
	 * Create product
	 * @param product
	 */
	@Override
	public void create(Product product) {		
		entityManager.persist(product);		
	}

	/**
	 * Update product
	 * @param product
	 */
	@Override
	public void update(Product product) {		
		entityManager.merge(product);		
	}

	/**
	 * Delete product
	 * @param product
	 */
	@Override
	public void delete(Product product) {	
		entityManager.remove(product);
	}

}
