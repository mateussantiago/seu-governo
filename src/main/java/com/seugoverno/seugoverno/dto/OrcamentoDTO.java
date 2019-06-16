package com.seugoverno.seugoverno.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.HashMap;

public class OrcamentoDTO {

    @JsonProperty("ano")
    private String ano;

    @JsonProperty("orcamento-por-mes")
    private HashMap<String, BigDecimal> mesOrcamento;

    @JsonIgnore
    private String mes;

    @JsonIgnore
    private BigDecimal orcamento;

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public HashMap<String, BigDecimal> getMesOrcamento() {
        return mesOrcamento;
    }

    public void setMesOrcamento(HashMap<String, BigDecimal> mesOrcamento) {
        this.mesOrcamento = mesOrcamento;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }
}
