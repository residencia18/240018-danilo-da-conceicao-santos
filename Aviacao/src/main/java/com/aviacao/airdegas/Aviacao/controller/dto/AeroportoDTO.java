package com.aviacao.airdegas.Aviacao.controller.dto;

import java.util.ArrayList;

import com.aviacao.airdegas.Aviacao.model.Aeroporto;

public class AeroportoDTO {
	private Long id;
	private String icao;
	private String nome;
	public AeroportoDTO(String icao, String nome) {
		super();
		this.icao = icao;
		this.nome = nome;
	}
	
	public AeroportoDTO(Long id, String icao, String nome) {
		super();
		this.id = id;
		this.icao = icao;
		this.nome = nome;
	}

	public AeroportoDTO() {
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
	
	public ArrayList<Aeroporto> listarAeroportosDTO() {
		ArrayList<Aeroporto> lista = new ArrayList<Aeroporto>();
		Aeroporto a1 = new Aeroporto("ABC", "aeroporto1");
		Aeroporto a2 = new Aeroporto("DEF", "aeroporto2");
		Aeroporto a3 = new Aeroporto("GHI", "aeroporto3");
		Aeroporto a4 = new Aeroporto("JKL", "aeroporto4");
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		lista.add(a4);
		return lista;
		
	}
		
	
}
