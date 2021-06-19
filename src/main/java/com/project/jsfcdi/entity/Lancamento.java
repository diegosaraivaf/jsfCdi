package com.project.jsfcdi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.project.jsfcdi.bean.SituacaoLancamento;

@Entity
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipo;
	
	private BigDecimal valor;
	
	private LocalDate dataEmissao;
	
	private SituacaoLancamento situacaoLancamento;
	
	@OneToMany
	@JoinColumn(name = "lancamento_id")
	private List<Parcela> parcelas;
	
	@ManyToOne
	@JoinColumn(name = "contribuinte_id")
	private Contribuinte contribuinte;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}
	
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public SituacaoLancamento getSituacaoLancamento() {
		return situacaoLancamento;
	}
	
	public void setSituacaoLancamento(SituacaoLancamento situacaoLancamento) {
		this.situacaoLancamento = situacaoLancamento;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
	
	
	
}
