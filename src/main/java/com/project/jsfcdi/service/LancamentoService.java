package com.project.jsfcdi.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.project.jsfcdi.dao.LancamentoDao;
import com.project.jsfcdi.entity.Lancamento;
import com.project.jsfcdi.util.JpaUtil;

@Dependent
public class LancamentoService implements Serializable{
	
	private static final long serialVersionUID = 8255010351462044519L;
	
	@Inject
	private LancamentoDao lancamentoDao;
	
	public Lancamento salvar(Lancamento lancamento) {
		return lancamentoDao.salvar(lancamento);
	}
	
	public void deletar(Lancamento lancamenot) {
		lancamentoDao.deletar(lancamenot);
	}
	
	public List<Lancamento> listar() {
		return lancamentoDao.listar();
	}
	
	public Lancamento porId(Long id) {
		return lancamentoDao.porId(id);
	}

}
