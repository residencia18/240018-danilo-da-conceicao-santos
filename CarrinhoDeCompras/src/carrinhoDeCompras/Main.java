package carrinhoDeCompras;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Analia", "123456");

        Produto p1 = new Produto("Camiseta", 10.0);
        Produto p2 = new Produto("Calça", 20.0);
        Produto p3 = new Produto("Bermuda", 30.0);

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(cliente);
        carrinho.adicionarProdutos(p1);
        carrinho.adicionarProdutos(p2);
        carrinho.adicionarProdutos(p3);
        carrinho.listarCarrinho();
        System.out.println("Total: " + carrinho.calcularValorTotal());
        carrinho.finalizarCarrinho(carrinho);
    }
}
