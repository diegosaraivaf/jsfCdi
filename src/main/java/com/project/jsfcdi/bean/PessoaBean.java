package com.project.jsfcdi.bean;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.omnifaces.util.Messages.Message;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;

@Named
//@ViewScoped
@org.omnifaces.cdi.ViewScoped
public class PessoaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String teste;
	
	@PostConstruct
	public void preConstruct(){
		System.out.println("preConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy");
	}
	
	public void enviar() {
		Messages.addGlobalInfo("teste mensagem com prime e omnfaces");
		if(teste != null) {
			System.out.println("teste "+ teste);
		}
	}
	
	public String getTeste() {
		return teste;
	}
	
	public void setTeste(String teste) {
		this.teste = teste;
	}

}
