package com.Danilo.vendaspring.controller.form;

import com.degasoft.redesocial.modelo.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UsuarioForm {
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioForm(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	public UsuarioForm() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario criarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		return usuario;
	}
}
