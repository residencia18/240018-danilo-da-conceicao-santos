package com.Danilo.vendaspring.controller.dto;

import java.util.ArrayList;

import com.degasoft.redesocial.modelo.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	
	public UsuarioDTO(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public ArrayList<Usuario> listarUsuariosDTO() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Usuario u1 = new Usuario("Rafael", "r@r.com", "123");
		Usuario u2 = new Usuario("Joao", "j@j.com", "123");
		Usuario u3 = new Usuario("Maria", "m@m.com", "123");
		Usuario u4 = new Usuario("Pedro", "p@p.com", "123");
		lista.add(u1);
		lista.add(u2);
		lista.add(u3);
		lista.add(u4);
		return lista;
	};
	
}