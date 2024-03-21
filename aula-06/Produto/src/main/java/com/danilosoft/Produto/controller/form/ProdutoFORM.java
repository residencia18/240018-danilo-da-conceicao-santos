package com.danilosoft.Produto.controller.form;

import com.danilosoft.Produto.model.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoFORM {
	private long id;
	private String descricao;
	private double precoCusto;
	private double precoVista;
	private double precoPrazo;
	private int quantidade;
	
	
}
