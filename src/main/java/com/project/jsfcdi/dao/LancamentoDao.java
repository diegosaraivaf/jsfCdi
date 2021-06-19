package com.project.jsfcdi.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.project.jsfcdi.entity.Lancamento;
import com.project.jsfcdi.util.JpaUtil;

@Dependent
public class LancamentoDao implements Serializable{

	private static final long serialVersionUID = 7827871216647890375L;
	
	public Lancamento salvar(Lancamento lancamento) {	
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transaction =  manager.getTransaction();
		transaction.begin();
		lancamento = manager.merge(lancamento);
		transaction.commit();
		manager.close();
		return lancamento;
	}
	
	public List<Lancamento> listar() {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Lancamento> query = manager.createQuery("select l from Lancamento l ",Lancamento.class);
		List<Lancamento> list = query.getResultList();
		manager.close();
		return list;
	}
	
	public Lancamento porId(Long id) {
		EntityManager manager = JpaUtil.getEntityManager();
		Lancamento lancamento = manager.find(Lancamento.class, id);
		manager.close();
		return lancamento;
	}
	
	public void deletar(Lancamento lancamento) {	
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transaction =  manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery("delete from Lancamento l where l.id = :id ");
		query.setParameter("id",lancamento.getId());
		query.executeUpdate();
		transaction.commit();
		manager.close();
		
	}
}
