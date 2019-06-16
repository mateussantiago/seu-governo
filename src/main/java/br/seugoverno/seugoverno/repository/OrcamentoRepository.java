package br.seugoverno.seugoverno.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.seugoverno.seugoverno.dominio.Orcamento;

public interface OrcamentoRepository extends CrudRepository<Orcamento, Integer>{

	List<String> findDistinctAno();

	List<String> findDistinctMes();

	List<String> findDistinctProgramaOrcamentario();
	
}
