package com.exercicio.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.ecommerce.dtos.ProdutoDTO;
import com.exercicio.ecommerce.mappers.ProdutoMapper;
import com.exercicio.ecommerce.models.Produto;
import com.exercicio.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoMapper produtoMapper;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto create(ProdutoDTO dto) throws Exception {
		try {
			Produto produto = produtoMapper.toEntity(dto);
			return produtoRepository.save(produto);
		}catch (Exception e) {
			throw new  Exception("Erro ao cadastrar produto");
		}
	}
	
	public List<ProdutoDTO> getAll(){
		return produtoRepository.findAll().stream().map(produtoMapper::toDTO).collect(Collectors.toList());
	}
	
	public ProdutoDTO getByCodigo(String codigo) {
		return produtoMapper.toDTO(produtoRepository.findByCodigo(codigo));
	}
	
	
	public ProdutoDTO update (String codigo, ProdutoDTO dto) {
		Produto produto = produtoRepository.findByCodigo(codigo);
		produto.setNome(dto.getNome());
		produto.setCodigo(dto.getCodigo());
		produto.setCategoria(dto.getCategoria());
		produto.setDescricaoProduto(dto.getDescricaoProduto());
		produto.setQtdEmEstoque(dto.getQtdEmEstoque());
		return produtoMapper.toDTO(produtoRepository.save(produto));
	}
	
	public String delete(String codigo) {
		if(produtoRepository.findByCodigo(codigo) !=null) {
			produtoRepository.deleteByCodigo(codigo);
		}
		return "Produto excluído com sucesso";
	}

}
