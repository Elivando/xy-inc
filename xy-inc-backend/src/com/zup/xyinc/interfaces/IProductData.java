package com.zup.xyinc.interfaces;

import java.util.List;
import com.zup.xyinc.model.*;

/**
 * 
 * @author Elivando França
 * Interface IProductData
 */
public interface IProductData {

	/**
	 * Get all products
	 * @return all products
	 */
	List<Product> getAllProducts();

	/**
	 * Get product by id
	 * @param id of the product
	 * @return product
	 */
	Product getById(Long id);

	/**
	 * Create product
	 * @param product
	 */
	void create(Product product);

	/**
	 * Update product
	 * @param product
	 */
	void update(Product product);

	/**
	 * Delete product
	 * @param product
	 */
	void delete(Product product);


}
