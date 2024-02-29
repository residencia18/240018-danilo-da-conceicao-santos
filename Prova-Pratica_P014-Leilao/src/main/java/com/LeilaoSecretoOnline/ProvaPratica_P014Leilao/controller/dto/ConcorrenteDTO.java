package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.dto;

import java.util.ArrayList;

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Concorrente;

public class ConcorrenteDTO {
	private Long id;
	private String nome;
	private String cpf;
	
	public ConcorrenteDTO(Long id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public ConcorrenteDTO(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	
	

	public ConcorrenteDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public ConcorrenteDTO() {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public ArrayList<Concorrente> listarConcorrentesDTO() {
		ArrayList<Concorrente> lista = new ArrayList<Concorrente>();
		Concorrente c1 = new Concorrente("Rafael", "123");
		Concorrente c2 = new Concorrente("Joao", "123");
		Concorrente c3 = new Concorrente("Maria", "123");
		Concorrente c4 = new Concorrente("Pedro", "123");
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
		return lista;
	}
	
}
