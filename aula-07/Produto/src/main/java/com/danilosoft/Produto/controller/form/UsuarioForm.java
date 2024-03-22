package com.danilosoft.Produto.controller.form;

import com.danilosoft.Produto.model.Usuario;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioForm {
	private Long id;
	
	
	@NotNull(message = "O nome nao pode ser nulo") 
	private String nome;
	
	@Email(message = "O Email nao eh valido")
	private String email;
	
	private String senha;
	
	public Usuario criarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		return usuario;
	}
}