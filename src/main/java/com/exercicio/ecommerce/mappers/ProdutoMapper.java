package com.exercicio.ecommerce.mappers;

import org.springframework.stereotype.Component;

import com.exercicio.ecommerce.dtos.ProdutoDTO;
import com.exercicio.ecommerce.models.Produto;

@Component
public class ProdutoMapper {
	
	public Produto toEntity(ProdutoDTO dto) {
		Produto produto = new Produto();
		produto.setNome(dto.getNome());
		produto.setCodigo(dto.getCodigo());
		produto.setCategoria(dto.getCategoria());
		produto.setDescricaoProduto(dto.getDescricaoProduto());
		produto.setQtdEmEstoque(dto.getQtdEmEstoque());
		return produto;
	}

	public ProdutoDTO toDTO(Produto produto) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setNome(produto.getNome());
		dto.setCodigo(produto.getCodigo());
		dto.setCategoria(produto.getCategoria());
		dto.setDescricaoProduto(produto.getDescricaoProduto());
		dto.setQtdEmEstoque(produto.getQtdEmEstoque());
		return dto;
	}

}
