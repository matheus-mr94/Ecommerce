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

import com.exercicio.ecommerce.dtos.ProdutoDTO;
import com.exercicio.ecommerce.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<String> create (@Validated @RequestBody ProdutoDTO dto) throws Exception{
		produtoService.create(dto);
		return new ResponseEntity<>("Produto adicionado com sucesso",HttpStatus.CREATED);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<ProdutoDTO>> getAll(){
		return new ResponseEntity<>(produtoService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoDTO> getByCodigo(@PathVariable String codigo){
		return new ResponseEntity<ProdutoDTO>(produtoService.getByCodigo(codigo),HttpStatus.OK);
	}
	
	@PutMapping("/alterar/{codigo}")
	public ResponseEntity<String> update (@PathVariable String codigo, @Validated @RequestBody ProdutoDTO dto){
		produtoService.update(codigo, dto);
		return new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/excluir/{codigo}")
	public ResponseEntity<String> delete(@PathVariable String codigo){
		return new ResponseEntity<String>(produtoService.delete(codigo),HttpStatus.ACCEPTED);
	}

}
