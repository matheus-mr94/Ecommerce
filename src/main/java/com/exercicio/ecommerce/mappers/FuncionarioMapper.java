package com.exercicio.ecommerce.mappers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.exercicio.ecommerce.dtos.FuncionarioDTO;
import com.exercicio.ecommerce.dtos.FuncionarioDetalheDTO;
import com.exercicio.ecommerce.models.Funcionario;

@Component
public class FuncionarioMapper {

	public Funcionario toEntity(FuncionarioDTO dto) {
		Funcionario funcionario = new Funcionario();
		funcionario.setMatricula(dto.getMatricula());
		funcionario.setNome(dto.getNome());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCodificada = encoder.encode(dto.getSenha());
		funcionario.setSenha(senhaCodificada);
		return funcionario;
	}

	public FuncionarioDTO toDTO(Funcionario funcionario) {
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setMatricula(funcionario.getMatricula());
		dto.setNome(funcionario.getNome());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCodificada = encoder.encode(funcionario.getSenha());
		dto.setSenha(senhaCodificada);
		return dto;
	}

	public FuncionarioDetalheDTO toShow(Funcionario funcionario) {
		FuncionarioDetalheDTO dto = new FuncionarioDetalheDTO();
		dto.setMatricula(funcionario.getMatricula());
		dto.setNome(funcionario.getNome());
		return dto;
	}
	
	public FuncionarioDetalheDTO toExibir(Funcionario funcionario) {
		FuncionarioDetalheDTO dto = new FuncionarioDetalheDTO();
		dto.setMatricula(funcionario.getMatricula());
		dto.setNome(funcionario.getNome());
		return dto;
	}

}
