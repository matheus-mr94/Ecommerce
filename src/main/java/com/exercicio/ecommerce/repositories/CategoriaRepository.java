package com.exercicio.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.ecommerce.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
