package veiculos;

public class Carro extends Veiculo {
	public Carro(String modelo, String cor, int ano) {
        super(modelo, cor, ano);
    }
	 public Carro(String modelo, String cor, int ano, boolean eletrico) {
	        super(modelo, cor, ano, eletrico);
	    }

    public void ligar() {
        System.out.println("Carro ligado");
    }


    public void abrirPorta() {
        System.out.println("Porta do carro aberta");
    }
}
