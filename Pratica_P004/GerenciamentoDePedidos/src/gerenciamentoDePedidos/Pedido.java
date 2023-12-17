package gerenciamentoDePedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private String cpfCliente;
    private List<ItemPedido> itens;

    public Pedido(int numeroPedido, String cpfCliente) {
        this.numeroPedido = numeroPedido;
        this.cpfCliente = cpfCliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco) {
        ItemPedido item = new ItemPedido(nome, preco);
        itens.add(item);
    }

    public void adicionarItens(List<ItemPedido> itens) {
        this.itens.addAll(itens);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.preco;
        }
        return total;
    }


    public double calcularTotal(double percentualDesconto) {
        double total = calcularTotal();
        return total - (total * percentualDesconto / 100);
    }

    public double calcularTotal(int numeroPrestacoes, double taxaJuros) {
        double total = calcularTotal();
        return total + (total * taxaJuros / 100 * numeroPrestacoes);
    }

    public void exibirInformacoes() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("CPF do Cliente: " + cpfCliente);
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : itens) {
            System.out.println("  - " + item.nome + ": R$ " + item.preco);
        }
        System.out.println("Total do Pedido: R$ " + calcularTotal());
    }
}  
