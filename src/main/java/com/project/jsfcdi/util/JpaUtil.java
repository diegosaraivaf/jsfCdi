package com.project.jsfcdi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoPU");
	private static EntityManager manager;
	
	public static EntityManager getEntityManager() {
		if(manager == null || !manager.isOpen()) {
			manager = factory.createEntityManager();
		}
		return  manager;
	}
}
