package com.seugoverno.seugoverno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.seugoverno.seugoverno.dominio.Orcamento;

public interface OrcamentoRepository extends CrudRepository<Orcamento, Integer>, OrcamentoCustomRepository {

	@Query(value = "SELECT DISTINCT(ano) FROM orcamento ORDER BY ano", nativeQuery = true)
	List<Integer> findAllDistinctAno();

	@Query(value = "SELECT DISTINCT(mes) FROM orcamento ORDER BY mes", nativeQuery = true)
	List<Integer> findAllDistinctMes();

	@Query(value = "SELECT DISTINCT(programa_orcamentario) FROM orcamento", nativeQuery = true)
	List<String> findAllDistinctProgramaOrcamentario();
	
}
