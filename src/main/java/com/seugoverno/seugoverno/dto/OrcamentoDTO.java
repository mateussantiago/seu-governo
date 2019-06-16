package com.seugoverno.seugoverno.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrcamentoDTO {

	@JsonProperty("ano")
	private Integer ano;

	@JsonProperty("orcamento_por_mes")
	private HashMap<Integer, BigDecimal> mesOrcamento;
	
	private List<Integer> meses;
	
	private List<BigDecimal> orcamentos;

	@JsonIgnore
	private Integer mes;

	@JsonIgnore
	private BigDecimal orcamento;

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public HashMap<Integer, BigDecimal> getMesOrcamento() {
		return mesOrcamento;
	}

	public void setMesOrcamento(HashMap<Integer, BigDecimal> mesOrcamento) {
		this.mesOrcamento = mesOrcamento;
	}

	public BigDecimal getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
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
	
}
