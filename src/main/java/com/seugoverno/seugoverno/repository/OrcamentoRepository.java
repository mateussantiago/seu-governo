package com.seugoverno.seugoverno.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.seugoverno.seugoverno.dominio.Orcamento;
import com.seugoverno.seugoverno.repository.OrcamentoCustomRepository;

public interface OrcamentoRepository extends CrudRepository<Orcamento, Integer>, OrcamentoCustomRepository {

	List<String> findDistinctAno();

	List<String> findDistinctMes();

	List<String> findDistinctProgramaOrcamentario();
	
}
