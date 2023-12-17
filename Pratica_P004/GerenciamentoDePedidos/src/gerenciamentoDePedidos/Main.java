package gerenciamentoDePedidos;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		 Pedido pedido1 = new Pedido(1, "123.456.789-00");

	      
	        pedido1.adicionarItem("Produto 1", 50.0);
	        pedido1.adicionarItem("Produto 2", 30.0);


	        List<ItemPedido> itensAdicionais = new ArrayList<>();
	        itensAdicionais.add(new ItemPedido("Produto 3", 25.0));
	        itensAdicionais.add(new ItemPedido("Produto 4", 40.0));
	        pedido1.adicionarItens(itensAdicionais);


	        pedido1.exibirInformacoes();


	        double totalDescontoVista = pedido1.calcularTotal(10.0);
	        System.out.println("Total com desconto à vista: R$ " + totalDescontoVista);


	        double totalPrazo = pedido1.calcularTotal(3, 5.0);
	        System.out.println("Total a prazo: R$ " + totalPrazo);
	   }

}


