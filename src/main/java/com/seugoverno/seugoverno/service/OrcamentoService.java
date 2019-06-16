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


    public List<OrcamentoDTO> findOrcamentos(Integer ano) {

        return orcamentoRepository.findOrcamentos(ano);
        /*List<OrcamentoDTO> orcamentosDTO = orcamentoRepository.findOrcamentos(anos);
        Map<Integer, BigDecimal> mesOrcamento = new HashMap<Integer, BigDecimal>();

        for (Integer ano : anos) {
            List<OrcamentoDTO> orcamentoByAno = orcamentosDTO.stream()
                    .filter(orcamentoDTO -> orcamentoDTO.getAno() == ano)
                    .collect(Collectors.toList());

            for (OrcamentoDTO orcDTO : orcamentoByAno) {
                Integer mes = orcDTO.getMes();
                BigDecimal orcamento = orcDTO.getOrcamento();
                mesOrcamento.put(mes, orcamento);
            }

        }*/
    }
}
