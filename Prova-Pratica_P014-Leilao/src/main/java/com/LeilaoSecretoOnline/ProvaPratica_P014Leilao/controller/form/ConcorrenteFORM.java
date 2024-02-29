package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.form;

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Concorrente;

public class ConcorrenteFORM {
	private Long id;
	private String nome;	
	private String cpf;
	
	public ConcorrenteFORM() {
		super();
	}
	public ConcorrenteFORM(Long id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public ConcorrenteFORM(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public ConcorrenteFORM(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	public Concorrente criarConcorrente() {
		Concorrente concorrente = new Concorrente();
		concorrente.setId(id);
		concorrente.setNome(nome);
		concorrente.setCpf(cpf);
		return concorrente;		
	}
}
