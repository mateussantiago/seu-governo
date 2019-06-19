package com.seugoverno.seugoverno.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrcamentoDTO {

	@JsonProperty("ano")
	private Integer ano;

	@JsonProperty("meses")
	private List<Integer> meses;

	@JsonProperty("orcamentos")
	private List<BigDecimal> orcamentos;

	@JsonIgnore
	private Integer mes;

	@JsonIgnore
	private BigDecimal orcamento;
	
	private String categoria;

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<Integer> getMeses() {
		return meses;
	}

	public void setMeses(List<Integer> meses) {
		this.meses = meses;
	}

	public List<BigDecimal> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<BigDecimal> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public BigDecimal getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
