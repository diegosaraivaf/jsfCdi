package com.project.jsfcdi.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.project.jsfcdi.util.JpaUtil;

public class TesteJpa {
	public static void main(String[] args) {
		EntityManager entity = JpaUtil.getEntityManager();
		Query query = entity.createNativeQuery("select * from lancamento");
		List<Object> list = query.getResultList();
		for(Object o : list) {
			System.out.println(o.toString());
		}
		entity.close();

	}

}
