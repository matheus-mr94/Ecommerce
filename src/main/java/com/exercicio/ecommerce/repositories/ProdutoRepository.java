package com.exercicio.ecommerce.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.ecommerce.models.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long>  {
	
	Produto findByCodigo(String codigo);
	
	@Transactional
	void deleteByCodigo(String codigo);

}
