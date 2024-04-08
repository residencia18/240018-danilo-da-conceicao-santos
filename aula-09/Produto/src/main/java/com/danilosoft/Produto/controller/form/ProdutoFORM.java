package com.danilosoft.Produto.controller.form;

import com.danilosoft.Produto.model.Produto;
import com.danilosoft.Produto.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoFORM {
	private Long id;
	private String descricao;
	private double precoCusto;
	private double precoVista;
	private double precoPrazo;
	private int quantidade;
	
	
	
	public Produto criarProduto() {
		Produto produto = new Produto();
		produto.setDescricao(this.descricao);
		produto.setPrecoCusto(this.precoCusto);
		produto.setPrecoVista(this.precoVista);
		produto.setPrecoPrazo(this.precoPrazo);
		produto.setQuantidade(this.quantidade);
		return produto;
	}
	
}
