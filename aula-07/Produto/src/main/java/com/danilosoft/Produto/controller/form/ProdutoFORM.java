package com.danilosoft.Produto.controller.form;

import com.danilosoft.Produto.model.Produto;

public class ProdutoFORM {
	private long id;
	private String descricao;
	private double precoCusto;
	private double precoVista;
	private double precoPrazo;
	private int quantidade;
	
	public ProdutoFORM(long id, String descricao, double precoCusto, double precoVista, double precoPrazo, int quantidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVista = precoVista;
		this.precoPrazo = precoPrazo;
		this.quantidade = quantidade;
	}

	public ProdutoFORM() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoVista() {
		return precoVista;
	}

	public void setPrecoVista(double precoVista) {
		this.precoVista = precoVista;
	}

	public double getPrecoPrazo() {
		return precoPrazo;
	}

	public void setPrecoPrazo(double precoPrazo) {
		this.precoPrazo = precoPrazo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Produto criarProduto() {
		Produto produto = new Produto();
		produto.setDescricao(this.descricao);
		produto.setPrecoCusto(this.precoCusto);
		produto.setPrecoVista(this.precoVista);
		produto.setPrecoPrazo(this.precoPrazo);
		produto.setQuantidade(this.quantidade);
		return produto;
	}
	
}
