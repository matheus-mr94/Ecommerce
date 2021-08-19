package com.exercicio.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.ecommerce.dtos.FuncionarioDTO;
import com.exercicio.ecommerce.dtos.FuncionarioDetalheDTO;
import com.exercicio.ecommerce.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@PostMapping
	public ResponseEntity<?> create(@Validated @RequestBody FuncionarioDTO dto) throws Exception{
		funcionarioService.create(dto);
		return new ResponseEntity<>("Funcionário cadastrado com sucesso", HttpStatus.CREATED);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<FuncionarioDetalheDTO>> getAll(){
		return new ResponseEntity<List<FuncionarioDetalheDTO>>(funcionarioService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<FuncionarioDetalheDTO> getByMatricula(@PathVariable String matricula){
		return new ResponseEntity<FuncionarioDetalheDTO>(funcionarioService.getByMatricula(matricula),HttpStatus.OK);
	}
	
	@PutMapping("/alterar/{matricula}")
	public ResponseEntity<?> update(@PathVariable String matricula, @Validated @RequestBody FuncionarioDTO dto){
		funcionarioService.update(matricula, dto);
		return new ResponseEntity<>("Dados do funcionário alterado com sucesso", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/excluir/{matricula}")
	public ResponseEntity<String> delete(@PathVariable String matricula){
		return new ResponseEntity<String>(funcionarioService.delete(matricula), HttpStatus.ACCEPTED);
	}
}
