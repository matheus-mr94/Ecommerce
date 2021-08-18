package com.exercicio.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.ecommerce.models.Funcionario;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {

}
