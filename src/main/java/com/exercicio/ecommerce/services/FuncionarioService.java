package com.exercicio.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercicio.ecommerce.dtos.FuncionarioDTO;
import com.exercicio.ecommerce.dtos.FuncionarioDetalheDTO;
import com.exercicio.ecommerce.mappers.FuncionarioMapper;
import com.exercicio.ecommerce.models.Funcionario;
import com.exercicio.ecommerce.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioMapper funcionarioMapper;

	@Autowired
	FuncionarioRepository funcionarioRepository;

	public Funcionario findByid(Long id) {
		return funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + "não encontrado"));
	}

	public Funcionario create(FuncionarioDTO dto) throws Exception {
		try {
			Funcionario funcionario = funcionarioMapper.toEntity(dto);
			return funcionarioRepository.save(funcionario);
		} catch (Exception e) {
			throw new Exception("Matrícula já cadastrada");
		}
	}

	public List<FuncionarioDetalheDTO> getAll() {
		return funcionarioRepository.findAll().stream().map(funcionarioMapper::toShow).collect(Collectors.toList());
	}

	public FuncionarioDetalheDTO getByMatricula(String matricula) {
		return funcionarioMapper.toExibir(funcionarioRepository.findByMatricula(matricula));
	}

	public FuncionarioDTO update(String Matricula, FuncionarioDTO dto) {
		Funcionario funcionario = funcionarioRepository.findByMatricula(Matricula);
		funcionario.setNome(dto.getNome());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCodificada = encoder.encode(funcionario.getSenha());
		funcionario.setSenha(senhaCodificada);
		return funcionarioMapper.toDTO(funcionarioRepository.save(funcionario));

	}
	
	public String delete(String matricula) {
		if(funcionarioRepository.findByMatricula(matricula) != null) {
			funcionarioRepository.deleteByMatricula(matricula);
		}
		return "Funcionário removido com sucesso.";
	}
}
