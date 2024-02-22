package com.aviacao.airdegas.Aviacao.controller.FORM;

import com.aviacao.airdegas.Aviacao.model.Piloto;

public class pilotoFORM {
	private String nome;
	private String numbreve;
	public pilotoFORM(String nome, String numBreve) {
		super();
		this.nome = nome;
		this.numbreve = numBreve;
	}
	public pilotoFORM() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumbreve() {
		return numbreve;
	}
	public void setNumbreve(String numbreve) {
		this.numbreve = numbreve;
	}
	public Piloto criarPiloto() {
		Piloto piloto = new Piloto();
		piloto.setNome(this.nome);
		piloto.setNumBreve(this.numbreve);
		return piloto;
	}
}
