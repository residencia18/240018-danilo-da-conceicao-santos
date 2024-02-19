package com.aviacao.airdegas.Aviacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Piloto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String numbreve;
	public Piloto(String nome, String numBreve) {
		super();
		this.nome = nome;
		this.numbreve = numBreve;
	}
	public Piloto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumBreve() {
		return numbreve;
	}
	public void setNumBreve(String numBreve) {
		this.numbreve = numBreve;
	}
	@Override
	public String toString() {
		return "Piloto [id=" + id + ", nome=" + nome + ", numBreve=" + numbreve + "]";
	}
	
	
	
	
}
