package com.exercicio.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.ecommerce.dtos.CategoriaDTO;
import com.exercicio.ecommerce.mappers.CategoriaMapper;
import com.exercicio.ecommerce.models.Categoria;
import com.exercicio.ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaMapper categoriaMapper;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + "não encontrado"));
	}
	
	public Categoria create(CategoriaDTO dto ) throws Exception {
		try {
			Categoria categoria = categoriaMapper.toEntity(dto);
			return categoriaRepository.save(categoria);
		}catch(Exception e){
			throw new Exception("Categoria já cadastrada");
		}
	}
	
	public List<CategoriaDTO> getAll(){
		return categoriaRepository.findAll().stream().map(categoriaMapper::toDTO).collect(Collectors.toList());
	}
	
	public CategoriaDTO getById(Long id) {
		return categoriaRepository.findById(id).map(categoriaMapper::toDTO).orElseThrow(()-> new EntityNotFoundException(id + "não encontrado"));
	}
	
	public CategoriaDTO update(Long id, CategoriaDTO dto) {
		Categoria categoria = this.findById(id);
		categoria.setNome(dto.getNome());
		categoria.setDescricao(dto.getDescricao());
		return categoriaMapper.toDTO(categoriaRepository.save(categoria));
	}
	
	public String delete(Long id) {
		if(id != null)
			categoriaRepository.findById(id);
		return "Categoria Excluída";
	}
	
}
