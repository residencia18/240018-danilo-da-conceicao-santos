package produto;

import java.util.ArrayList;

public class Produto {
	
	  private  int codigo;
	  private String nome;
	  private Double preco;
	  private ArrayList<String>produtos;
	  
	public Produto(int codigo, String nome, Double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	  
	  
}
