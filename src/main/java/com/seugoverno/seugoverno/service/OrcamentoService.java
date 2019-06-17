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
    public List<OrcamentoDTO> findOrcamentos(List<Integer> anos, List<Integer> meses, String programaOrcamentario,
                                             String categoria) {
        if (anos == null) {
            anos = new ArrayList<>();
            anos = orcamentoRepository.findAllDistinctAno();
        }

        return getOrcamentos(anos, meses, programaOrcamentario, categoria);
    }

    /**
     * Busca pelos orçamentos chamando o repository e trata o resultado. Para resultar em
     * um json mais limpo, o resultado da consulta no banco é agrupado por ano.
     * @param anos lista contendo os anos passados
     * @param meses lista contendo os meses passados
     * @return lista com orçamentos
     */
    private List<OrcamentoDTO> getOrcamentos(List<Integer> anos, List<Integer> meses, String programaOrcamentario,
                                             String categoria){
        List<OrcamentoDTO> orcamentosDTO = orcamentoRepository.findOrcamentos(anos, meses, programaOrcamentario, categoria);
        List<OrcamentoDTO> orcamentosTratados = new ArrayList<>();

        for (Integer ano : anos) {
            OrcamentoDTO orcDTO = new OrcamentoDTO();
            List<Integer> mesesByDTO = new ArrayList<Integer>();
            List<BigDecimal> orcamentosByDTO= new ArrayList<BigDecimal>();

            List<OrcamentoDTO> orcamentoByAno = orcamentosDTO.stream()
                    .filter(orcamentoDTO -> orcamentoDTO.getAno().equals(ano))
                    .collect(Collectors.toList());

                for (OrcamentoDTO orc : orcamentoByAno) {
                mesesByDTO.add(orc.getMes());
                orcamentosByDTO.add(orc.getOrcamento());
            }

            orcDTO.setAno(ano);
            orcDTO.setMeses(mesesByDTO);
            orcDTO.setOrcamentos(orcamentosByDTO);

            orcamentosTratados.add(orcDTO);
        }

        return orcamentosTratados;
    }
    
    public List<Integer> findOpcoesAnos(){
    	return orcamentoRepository.findAllDistinctAno();
    }

    public List<Integer> findOpcoesMeses(){
    	return orcamentoRepository.findAllDistinctMes();
    }

    public List<String> findOpcoesProramaOrcamentario() {
    	return orcamentoRepository.findAllDistinctProgramaOrcamentario();
    }

    public List<String> findOpcoesCategorias() {
        return orcamentoRepository.findAllDistinctCategorias();
    }
}
