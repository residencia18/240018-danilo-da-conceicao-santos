package com.aviacao.airdegas.Aviacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aeroporto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String icao;
	private String nome;
	public Aeroporto(String icao, String nome) {
		super();
		this.icao = icao;
		this.nome = nome;
	}
	public Aeroporto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIcao() {
		return icao;
	}
	public void setIcao(String icao) {
		this.icao = icao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Aeroporto [id=" + id + ", icao=" + icao + ", nome=" + nome + "]";
	}
	
	
}
