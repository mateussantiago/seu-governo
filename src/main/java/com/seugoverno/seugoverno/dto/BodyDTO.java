package com.seugoverno.seugoverno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BodyDTO {

	@JsonProperty("anos")
	List<Integer> anos;

	@JsonProperty("meses")
	List<Integer> meses;

	@JsonProperty("programa_orcamentario")
	private String programaOrcamentario;

	@JsonProperty("categoria")
	private List<String> categoria;

	@JsonProperty("uf")
	private String uf;

	public BodyDTO() {
		super();
	}

	public List<Integer> getAnos() {
		return anos;
	}

	public void setAnos(List<Integer> anos) {
		this.anos = anos;
	}

	public List<Integer> getMeses() {
		return meses;
	}

	public void setMeses(List<Integer> meses) {
		this.meses = meses;
	}

	public String getProgramaOrcamentario() {
		return programaOrcamentario;
	}

	public void setProgramaOrcamentario(String programaOrcamentario) {
		this.programaOrcamentario = programaOrcamentario;
	}

	public List<String> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<String> categoria) {
		this.categoria = categoria;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
