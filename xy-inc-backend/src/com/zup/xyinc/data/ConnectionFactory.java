package com.zup.xyinc.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Elivando França
 * 
 * Data ProductData
 *
 */
public class ConnectionFactory {

	/**
	 * persistence context.
	 * create EntityManagerFactory
	 */
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionJpa");
		
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}
