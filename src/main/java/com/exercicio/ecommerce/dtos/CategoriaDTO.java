package com.exercicio.ecommerce.dtos;

import java.util.List;

import com.exercicio.ecommerce.models.Produto;

public class CategoriaDTO {
	
	private String nome;
	private String descricao;
	private List<Produto> produtos;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

}
