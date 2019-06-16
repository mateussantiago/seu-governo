package com.seugoverno.seugoverno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BodyDTO {

    @JsonProperty("anos")
    List<Integer> anos;

    @JsonProperty("meses")
    List<Integer> meses;

    @JsonProperty("programa-orcamentario")
    private String programaOrcamentario;

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
}
