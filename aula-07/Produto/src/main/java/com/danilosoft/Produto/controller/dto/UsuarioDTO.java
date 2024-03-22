package com.danilosoft.Produto.controller.dto;

import java.util.ArrayList;

import com.danilosoft.Produto.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
		
	
}