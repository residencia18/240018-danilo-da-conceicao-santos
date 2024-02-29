package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.form;

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Leilao;

public class LeilaoFORM {
	private Long id;
	private String descricao;
	private double valorminimo;
	private Boolean status;
	
	public LeilaoFORM(Long id, String descricao, double valorminimo, Boolean status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valorminimo = valorminimo;
		this.status = status;
	}

	public LeilaoFORM(String descricao, double valorminimo, Boolean status) {
		super();
		this.descricao = descricao;
		this.valorminimo = valorminimo;
		this.status = status;
	}

	public LeilaoFORM() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorminimo() {
		return valorminimo;
	}

	public void setValorminimo(double valorminimo) {
		this.valorminimo = valorminimo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Leilao [id=" + id + ", descricao=" + descricao + ", valorminimo=" + valorminimo + ", status=" + status
				+ "]";
	}
	
	public Leilao criarLeilao() {
		Leilao leilao = new Leilao();
		leilao.setDescricao(this.descricao);
		leilao.setValorminimo(this.valorminimo);
		leilao.setStatus(this.status);
		return leilao;
		
	}
	
}
