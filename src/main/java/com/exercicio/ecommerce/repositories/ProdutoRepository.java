package com.exercicio.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.ecommerce.models.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long>  {

}
