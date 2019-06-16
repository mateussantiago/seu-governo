package com.seugoverno.seugoverno.repository;

import java.util.List;

import com.seugoverno.seugoverno.dto.OrcamentoDTO;

public interface OrcamentoCustomRepository {
	 public List<OrcamentoDTO> findOrcamentos(Integer ano);
}
