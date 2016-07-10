package com.zup.xyinc.test;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.zup.xyinc.model.*;

public class ProgramTest {

	public static void main(String[] args) {
		// create EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionJpa");

		// Criar EntityManager
			EntityManager em = emf.createEntityManager();

		// get dataBase
		List<Product> listProduct =	em.createQuery("FROM Product", Product.class).getResultList();

		for (Product product : listProduct) {
			System.out.println(product.getName());
		}
		
		// Persist object
		//Product product = new Product();
		//product.setName("Teste");
		//product.setCategory("teste");
		//product.setPrice(1.20);
		//product.setDescription("teste");
		
		//em.getTransaction().begin();
		///em.persist(product);
		//em.getTransaction().commit();

		// close EntityManager and EntityManagerFactory
		em.close();
		emf.close();

	}

}
