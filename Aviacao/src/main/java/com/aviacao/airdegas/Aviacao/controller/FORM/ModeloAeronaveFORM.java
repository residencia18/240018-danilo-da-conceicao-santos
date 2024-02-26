package com.aviacao.airdegas.Aviacao.controller.FORM;

import com.aviacao.airdegas.Aviacao.model.ModeloAeronave;

public class ModeloAeronaveFORM {
	private Long id;
	private String fabricante;
	private String nome;
	public ModeloAeronaveFORM(String fabricante, String nome) {
		super();
		this.fabricante = fabricante;
		this.nome = nome;
	}
	public ModeloAeronaveFORM() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "ModeloAeronave [id=" + id + ", fabricante=" + fabricante + ", nome=" + nome + "]";
	}
	public ModeloAeronave criarModeloAeronave() {
		ModeloAeronave modeloAeronave = new ModeloAeronave();
		modeloAeronave.setFabricante(this.fabricante);
		modeloAeronave.setNome(this.nome);
		return modeloAeronave;
	}
}
