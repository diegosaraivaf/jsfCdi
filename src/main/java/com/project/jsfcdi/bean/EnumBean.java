package com.project.jsfcdi.bean;

import java.io.Serializable;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

@Named
@ViewScoped
public class EnumBean implements Serializable{

	private static final long serialVersionUID = 2999991265706425663L;

	public SituacaoLancamento[] getSituacaoLancamento(){
		return SituacaoLancamento.values();
	}

}
