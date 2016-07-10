package com.zup.xyinc.test;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.zup.xyinc.model.Product;
import com.zup.xyinc.service.ProductService;


public class ProductRestServiceTest {
	private static final String PRODUCT_NAME = "Test";
	private static final String PRODUCT_CATEGORY = "Test";
	private static final double PRODUCT_PRICE = 500.00D;
	private static final String PRODUCT_DESCRIPTION = "Test";

	private ProductService productService;

	public ProductRestServiceTest(){
		RestAssured.baseURI = "http://localhost:8080/xy-inc-backend/rest/products";
	}

	@Test
	public void testGetProduct() {
		Product product = new Product();
		productService = new ProductService();

		product.setName(PRODUCT_NAME);
		product.setCategory(PRODUCT_CATEGORY);
		product.setPrice(PRODUCT_PRICE);
		product.setDescription(PRODUCT_DESCRIPTION);		
		productService.create(product);	
		assertNotNull(product.getId());

		given()
		.contentType("application/json")
		.when()
		.get("/" + product.getId())   
		.then().log().all()
		.body("id", is(product.getId().toString()))
		.statusCode(200)
		.assertThat()
		.extract().response();

		given()
		.contentType("application/json")
		.when()
		.delete("/" + product.getId())   
		.then().log().all()		
		.statusCode(200)
		.assertThat()
		.extract().response();
	}

	@Test
	public void testDeleteProduct() {
		given()
		.contentType("application/json")
		.when()
		.delete("/1")   
		.then().log().all()		
		.statusCode(200)
		.assertThat()
		.extract().response();
	}

	/*
	@Test
	public void testCreateProduct() {

		given()
		.contentType("application/json")
		.body("{\"Category\":\"" + PRODUCT_CATEGORY + "\",\n" +
				"\"Description\":\"" + PRODUCT_DESCRIPTION + "\",\n" +
				"\"Id\":\"" + null + "\",\n" +
				"\"Name\":\"" + PRODUCT_NAME + "\",\n" +
				"\"Price\":\"" + PRODUCT_PRICE + "\"}")
		.when()
		.post()   
		.then().log().all()		
		.statusCode(200)
		.assertThat()
		.extract().response();

	}*/	

}
