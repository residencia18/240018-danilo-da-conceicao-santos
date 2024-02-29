package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.dto;

import java.util.ArrayList;

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Leilao;

public class LeilaoDTO {
	private Long id;
	private String descricao;
	private double valorminimo;
	private Boolean status;
	
	public LeilaoDTO(Long id, String descricao, double valorminimo, Boolean status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valorminimo = valorminimo;
		this.status = status;
	}

	public LeilaoDTO(String descricao, double valorminimo, Boolean status) {
		super();
		this.descricao = descricao;
		this.valorminimo = valorminimo;
		this.status = status;
	}

	public LeilaoDTO() {
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
	
	public ArrayList<Leilao> listarLeilaoDTO(){
		ArrayList<Leilao> lista = new ArrayList<>();
		Leilao l1 = new Leilao("Sapato", 100.00, true);
		Leilao l2 = new Leilao("Camisa", 15.00, true);
		Leilao l3 = new Leilao("Tenis", 80.00, true);
		Leilao l4 = new Leilao("Carro", 500.00, true);
		lista.add(l1);
		lista.add(l2);
		lista.add(l3);
		lista.add(l4);
		return lista;		
	}
}	
