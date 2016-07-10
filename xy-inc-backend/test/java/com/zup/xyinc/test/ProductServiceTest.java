package com.zup.xyinc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.zup.xyinc.model.Product;
import com.zup.xyinc.service.ProductService;

public class ProductServiceTest {

	/**
	 * static variables
	 */
	private static final String PRODUCT_NAME = "Refrigerator";
	private static final String PRODUCT_CATEGORY = "Electronic";
	private static final double PRODUCT_PRICE = 500.00D;
	private static final String PRODUCT_DESCRIPTION = "test";

	private static final String PRODUCT_NAME_2 = "Car";
	private static final String PRODUCT_CATEGORY_2 = "Other";
	private static final double PRODUCT_PRICE_2 = 1000.98D;
	private static final String PRODUCT_DESCRIPTION_2 = "test test";

	private static final String PRODUCT_NAME_3 = "Produce";
	private static final String PRODUCT_CATEGORY_3 = "Vegetables";
	private static final double PRODUCT_PRICE_3 = 1000.98D;
	private static final String PRODUCT_DESCRIPTION_3 = "Shopping List";

	private ProductService productService;

	/**
	 * Test save new product
	 * @throws Exception
	 */
	@Test
	public void saveNew() throws Exception {
		Product product = new Product();
		productService = new ProductService();

		product.setName(PRODUCT_NAME);
		product.setCategory(PRODUCT_CATEGORY);
		product.setPrice(PRODUCT_PRICE);
		product.setDescription(PRODUCT_DESCRIPTION);		
		productService.create(product);		

		assertNotNull(product.getId());
	}
	
	/**
	 * Test save new product and delete
	 * @throws Exception
	 */
	@Test
	public void saveNewAndDelete() throws Exception {
		Product product = new Product();
		productService = new ProductService();

		product.setName(PRODUCT_NAME_3);
		product.setCategory(PRODUCT_CATEGORY_3);
		product.setPrice(PRODUCT_PRICE_3);
		product.setDescription(PRODUCT_DESCRIPTION_3);	
		productService.create(product);		

		assertNotNull(product.getId());
		productService.delete(product);	

		product = productService.getById(product.getId());
		assertNull(product);
	}

	/**
	 * Test update product and delete
	 * @throws Exception
	 */
	@Test
	public void updateAndDelete() throws Exception {	    	
		Product product = new Product();
		productService = new ProductService();

		product.setName(PRODUCT_NAME_2);
		product.setCategory(PRODUCT_CATEGORY_2);
		product.setPrice(PRODUCT_PRICE_2);
		product.setDescription(PRODUCT_DESCRIPTION_2);	
		productService.create(product);
		assertNotNull(product.getId());

		product.setPrice(PRODUCT_PRICE);
		product.setCategory(PRODUCT_CATEGORY);
		product.setDescription(PRODUCT_DESCRIPTION);		
		productService.update(product);

		product = productService.getById(product.getId());		
		assertEquals(product.getDescription(), PRODUCT_DESCRIPTION);
		assertEquals(product.getCategory(),PRODUCT_CATEGORY);

		productService.delete(product);
		product = productService.getById(product.getId());
		assertNull(product);
	}

	/**
	 * Test delete all
	 * @throws Exception
	 */
	@Test
	public void deleteAll() throws Exception {	 
		productService = new ProductService();
		List<Product> products = productService.getAllProducts();
		for (Product product : products) {
			productService.delete(product);
		}
		products = productService.getAllProducts();
		Assert.assertTrue(products.size() == 0);		
	}
}
