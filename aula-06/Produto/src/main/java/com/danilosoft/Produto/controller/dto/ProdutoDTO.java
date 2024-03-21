package com.danilosoft.Produto.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO {
	private long id;
	private String descricao;
	private double precoCusto;
	private double precoVista;
	private double precoPrazo;
	private int quantidade;
	
	
}
