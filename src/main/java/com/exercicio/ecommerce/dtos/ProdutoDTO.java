package com.exercicio.ecommerce.dtos;

import com.exercicio.ecommerce.models.Categoria;

public class ProdutoDTO {

	private String nome;
	private String codigo;
	private String descricaoProduto;
	private Integer qtdEmEstoque;
	private Categoria categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getQtdEmEstoque() {
		return qtdEmEstoque;
	}

	public void setQtdEmEstoque(Integer qtdEmEstoque) {
		this.qtdEmEstoque = qtdEmEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
