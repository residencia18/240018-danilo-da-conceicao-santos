package produto;

import java.util.ArrayList;

public class Estoque {
	 	private int codigo;
	    private ArrayList<Produto> produtos;
	    private ArrayList<Integer> qtd_Produto;
		public Estoque(int codigo, ArrayList<Produto> produtos, ArrayList<Integer> qtd_Produto) {
			super();
			this.codigo = codigo;
			this.produtos = produtos;
			this.qtd_Produto = qtd_Produto;
		}
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public ArrayList<Produto> getProdutos() {
			return produtos;
		}
		public void setProdutos(ArrayList<Produto> produtos) {
			this.produtos = produtos;
		}
		public ArrayList<Integer> getQtd_Produto() {
			return qtd_Produto;
		}
		public void setQtd_Produto(ArrayList<Integer> qtd_Produto) {
			this.qtd_Produto = qtd_Produto;
		}
	    
	    void addproduto(Produto produto,int qtd) {
	    	produtos.add(produto);
	    	qtd_Produto.add(qtd);
	    }
}
