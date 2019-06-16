package com.seugoverno.seugoverno.dominio;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "orcamento")
public class Orcamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private Integer mes;

	private Integer ano;

	private String acaoOrcamentaria;

	private String programaOrcamentario;

	private String funcao;

	private String tipoFavorecido;

	private String uf;

	private String municipio;

	private BigDecimal valorTransferido;

	@Enumerated(EnumType.STRING)
	private GrupoDeGasto grupo;

	public Orcamento() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getAcaoOrcamentaria() {
		return acaoOrcamentaria;
	}

	public void setAcaoOrcamentaria(String acaoOrcamentaria) {
		this.acaoOrcamentaria = acaoOrcamentaria;
	}

	public String getProgramaOrcamentario() {
		return programaOrcamentario;
	}

	public void setProgramaOrcamentario(String programaOrcamentario) {
		this.programaOrcamentario = programaOrcamentario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getTipoFavorecido() {
		return tipoFavorecido;
	}

	public void setTipoFavorecido(String tipoFavorecido) {
		this.tipoFavorecido = tipoFavorecido;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public BigDecimal getValorTransferido() {
		return valorTransferido;
	}

	public void setValorTransferido(BigDecimal valorTransferido) {
		this.valorTransferido = valorTransferido;
	}

	public GrupoDeGasto getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoDeGasto grupo) {
		this.grupo = grupo;
	}

}
