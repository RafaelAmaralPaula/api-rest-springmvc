package com.lovelacetecnologia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovelacetecnologia.apirest.model.Produto;

public interface IProdutoRepository  extends JpaRepository<Produto, Long> {

	public Produto findById(long id);
	
}