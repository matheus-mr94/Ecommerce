package com.exercicio.ecommerce.mappers;

import org.springframework.stereotype.Component;

import com.exercicio.ecommerce.dtos.CategoriaDTO;
import com.exercicio.ecommerce.models.Categoria;

@Component
public class CategoriaMapper {
	
	public Categoria toEntity(CategoriaDTO dto) {
		Categoria categoria = new Categoria();
		categoria.setNome(dto.getNome());
		categoria.setDescricao(dto.getDescricao());	
		categoria.setProdutos(dto.getProdutos());
		return categoria;
	}
	
	public CategoriaDTO toDTO(Categoria categoria) {
		CategoriaDTO dto = new CategoriaDTO();
		dto.setNome(categoria.getNome());
		dto.setDescricao(categoria.getDescricao());
		dto.setProdutos(categoria.getProdutos());
		return dto;
	}

}
