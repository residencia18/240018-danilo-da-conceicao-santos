package carrinhoDeCompras;

public class Produto {
  	private static int idCounter = 0;
    private int id;
    private String descricao;
    private double valor;

    public Produto(String descricao, double valor) {
        super();
        this.descricao = descricao;
        this.valor = valor;
        this.id = ++idCounter; // Utilizando pós-incrementação
    }
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	
	public String toString() {
		String str = "";
		str += "ID: " + id;
		str += "\nDescrição: " + descricao;
		str += "\nValor: " + valor;
		return str;
	}
	
}
