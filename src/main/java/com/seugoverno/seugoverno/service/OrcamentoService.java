package com.seugoverno.seugoverno.service;

import com.seugoverno.seugoverno.dto.OrcamentoDTO;
import com.seugoverno.seugoverno.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    /**
     * Verifica se a lista anos é nula. Sendo assim, busca por todos os anos disponíveis
     * chamando o repository.
     * @param anos lista contendo os anos passados
     * @param meses lista contendo os meses passados
     * @return lista com orçamentos
     */
    public List<OrcamentoDTO> findOrcamentos(List<String> anos, List<String> meses) {
        if (anos == null) {
            anos = new ArrayList<>();
            anos = orcamentoRepository.getAllAnos();
        }

        return getOrcamentos(anos, meses);
    }

    /**
     * Busca pelos orçamentos chamando o repository e trata o resultado. Para resultar em
     * um json mais limpo, o resultado da consulta no banco é agrupado por ano.
     * @param anos lista contendo os anos passados
     * @param meses lista contendo os meses passados
     * @return lista com orçamentos
     */
    private List<OrcamentoDTO> getOrcamentos(List<String> anos, List<String> meses){
        List<OrcamentoDTO> orcamentosDTO = orcamentoRepository.findOrcamentos(anos, meses);
        List<OrcamentoDTO> orcamentosTratados = new ArrayList<>();

        for (String ano : anos) {
            OrcamentoDTO orcDTO = new OrcamentoDTO();
            HashMap<String, BigDecimal> mesOrcamento = new HashMap<String, BigDecimal>();

            List<OrcamentoDTO> orcamentoByAno = orcamentosDTO.stream()
                    .filter(orcamentoDTO -> orcamentoDTO.getAno().equals(ano))
                    .collect(Collectors.toList());

            for (OrcamentoDTO orc : orcamentoByAno) {
                String mes = orc.getMes();
                BigDecimal orcamento = orc.getOrcamento();
                mesOrcamento.put(mes, orcamento);
            }

            orcDTO.setAno(ano);
            orcDTO.setMesOrcamento(mesOrcamento);
            orcamentosTratados.add(orcDTO);
        }

        return orcamentosTratados;
    }
}
