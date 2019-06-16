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
    public List<OrcamentoDTO> findOrcamentos(List<Integer> anos, List<Integer> meses) {
        if (anos == null) {
            anos = new ArrayList<>();
            anos = orcamentoRepository.findAllDistinctAno();
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
    private List<OrcamentoDTO> getOrcamentos(List<Integer> anos, List<Integer> meses){
        List<OrcamentoDTO> orcamentosDTO = orcamentoRepository.findOrcamentos(anos, meses);
        List<OrcamentoDTO> orcamentosTratados = new ArrayList<>();

        for (Integer ano : anos) {
            OrcamentoDTO orcDTO = new OrcamentoDTO();
            HashMap<Integer, BigDecimal> mesOrcamento = new HashMap<Integer, BigDecimal>();

            List<OrcamentoDTO> orcamentoByAno = orcamentosDTO.stream()
                    .filter(orcamentoDTO -> orcamentoDTO.getAno().equals(ano))
                    .collect(Collectors.toList());

            List<Integer> mesesAux = new ArrayList<Integer>();
            List<BigDecimal> orcamentosAux = new ArrayList<BigDecimal>();
            for (OrcamentoDTO orc : orcamentoByAno) {
                Integer mes = orc.getMes();
                BigDecimal orcamento = orc.getOrcamento();
                mesOrcamento.put(mes, orcamento);
                
                mesesAux.add(mes);
                orcamentosAux.add(orcamento);
            }

            orcDTO.setAno(ano);
            orcDTO.setMesOrcamento(mesOrcamento);
            orcDTO.setMeses(mesesAux);
            orcDTO.setOrcamentos(orcamentosAux);
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

    public List<String> findOpcoesProramaOrcamentario(){
    	return orcamentoRepository.findAllDistinctProgramaOrcamentario();
    }
}
