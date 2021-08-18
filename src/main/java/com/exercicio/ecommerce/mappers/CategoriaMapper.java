package com.exercicio.ecommerce.mappers;

import org.springframework.stereotype.Component;

import com.exercicio.ecommerce.dtos.CategoriaDTO;
import com.exercicio.ecommerce.models.Categoria;

@Component
public class CategoriaMapper {
	
	private Categoria toEntity(CategoriaDTO dto) {
		Categoria categoria = new Categoria();
		categoria.setNome(dto.getNome());
		categoria.setDescricao(dto.getDescricao());
		return categoria;
	}
	
	private CategoriaDTO toDTO(Categoria categoria) {
		CategoriaDTO dto = new CategoriaDTO();
		dto.setNome(categoria.getNome());
		dto.setDescricao(categoria.getDescricao());
		return dto;
	}

}
