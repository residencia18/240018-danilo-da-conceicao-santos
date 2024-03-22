package com.danilosoft.Produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cliente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String Endereco;
	private String numero;
	private String celular;
	private String cidae;
	private String bairro;
	private String cpf;
	private String mais_informacao;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
}
