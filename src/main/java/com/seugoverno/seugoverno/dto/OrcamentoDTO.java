package com.seugoverno.seugoverno.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.HashMap;

public class OrcamentoDTO {

    @JsonProperty("ano")
    private Integer ano;

    @JsonProperty("orcamento-por-mes")
    private HashMap<Integer, BigDecimal> mesOrcamento;

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

    public HashMap<Integer, BigDecimal> getMesOrcamento() {
        return mesOrcamento;
    }

    public void setMesOrcamento(HashMap<Integer, BigDecimal> mesOrcamento) {
        this.mesOrcamento = mesOrcamento;
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
}
