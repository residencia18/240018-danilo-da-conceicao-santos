package com.aviacao.airdegas.Aviacao.controller.FORM;

import com.aviacao.airdegas.Aviacao.model.Aeroporto;

public class AeroportoFORM {
	private Long id;
	private String icao;
	private String nome;
	public AeroportoFORM(String icao, String nome) {
		super();
		this.icao = icao;
		this.nome = nome;
	}
	public AeroportoFORM() {
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
	public Aeroporto criarAeroporto() {
		Aeroporto aeroporto = new Aeroporto();
		aeroporto.setIcao(this.icao);
		aeroporto.setNome(this.nome);
		return aeroporto;
	}
}
