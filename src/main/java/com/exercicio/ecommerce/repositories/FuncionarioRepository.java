package com.exercicio.ecommerce.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.ecommerce.models.Funcionario;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {

	Funcionario findByMatricula(String matricula);
	
	@Transactional
	void deleteByMatricula(String matricula);

}
