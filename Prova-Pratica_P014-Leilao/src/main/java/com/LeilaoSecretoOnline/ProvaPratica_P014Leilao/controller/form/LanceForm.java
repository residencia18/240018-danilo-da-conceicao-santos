package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.form;

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Concorrente;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Lance;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Leilao;

public class LanceForm {
	private Long id;
	private Leilao leilao;
	private Concorrente concorrente;
	private double valor;
	
	public LanceForm(Leilao leilao, Concorrente concorrente, double valor) {
		super();
		this.leilao = leilao;
		this.concorrente = concorrente;
		this.valor = valor;
	}
	public LanceForm(Long id, Leilao leilao, Concorrente concorrente, double valor) {
		super();
		this.id = id;
		this.leilao = leilao;
		this.concorrente = concorrente;
		this.valor = valor;
	}
	public LanceForm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}

	public Concorrente getConcorrente() {
		return concorrente;
	}

	public void setConcorrente(Concorrente concorrente) {
		this.concorrente = concorrente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Lance criarLance() {
		Lance lance = new Lance();
		lance.setConcorrente(concorrente);
		lance.setLeilao(leilao);
		lance.setValor(valor);
		return lance;
	}
	
}
