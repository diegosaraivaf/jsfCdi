package com.project.jsfcdi.bean;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import com.project.jsfcdi.entity.Lancamento;
import com.project.jsfcdi.service.LancamentoService;

@Named
@ViewScoped
public class LancamentoDetalheBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LancamentoService lancamentoService;
	
	private Lancamento lancamento;
	
	private List<Lancamento> lancamentos;
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("contruido");
		lancamento = new Lancamento();
////		Lancamento strAux = (Lancamento) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("teste");
////		if(strAux != null) {
////			lancamento = strAux;
////		}
//		
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id != null) {
			lancamento = lancamentoService.porId(Long.parseLong(id));
		}
//		System.out.println(id);
		
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("destruido");
	}
	
	public Lancamento getLancamento() {
		return lancamento;
	}
	
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
