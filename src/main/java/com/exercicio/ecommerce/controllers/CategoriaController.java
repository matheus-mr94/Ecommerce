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

import com.exercicio.ecommerce.dtos.CategoriaDTO;
import com.exercicio.ecommerce.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<?> create (@Validated @RequestBody CategoriaDTO dto) throws Exception{
		categoriaService.create(dto);
		return new ResponseEntity<>("Categoria cadastrada com sucesso", HttpStatus.CREATED);
	}
	
	@GetMapping("/todas")
	public ResponseEntity<List<CategoriaDTO>> getAll(){
		return new ResponseEntity<List<CategoriaDTO>>(categoriaService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> getById(@PathVariable Long id){
		return new ResponseEntity<CategoriaDTO>(categoriaService.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoriaDTO dto){
		categoriaService.update(id, dto);
		return new ResponseEntity<>("Categoria atualizada com sucesso", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> delete (@PathVariable Long id){
		return new ResponseEntity<String>(categoriaService.delete(id),HttpStatus.ACCEPTED);
	}
}
