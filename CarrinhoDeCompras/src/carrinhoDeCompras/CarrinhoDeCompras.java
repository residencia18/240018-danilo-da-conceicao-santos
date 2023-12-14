package carrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
	List<Produto> produtos;
	private double valorTotal = 0;
	private Cliente cliente;
	
	
	public CarrinhoDeCompras(Cliente cliente) {
		super();
		this.cliente = cliente;
		this.produtos = new ArrayList<>();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public double getValorTotal() {
		return valorTotal;
	}

	public void adicionarProdutos(Produto p) {
		produtos.add(p);
	}
	
	public double calcularValorTotal() {
		for (int i = 0; i < produtos.size(); i++) {
			valorTotal += produtos.get(i).getValor();
		}
		return valorTotal;
	}
	public void listarCarrinho() {
		for (int i = 0; i < produtos.size(); i++) {
			System.out.println("Cliente " + cliente.getNome());
			System.out.println("Id " + produtos.get(i).getId() + " Descrição " + produtos.get(i).getDescricao() + " Valor " + produtos.get(i).getValor());
		}
	}
	public void finalizarCarrinho(CarrinhoDeCompras carrinho) {
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Total Pago: " + carrinho.getValorTotal());
		System.out.println("Obrigado pela compra, Carrinho finalizado");
		
	}
}
